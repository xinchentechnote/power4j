package com.wusx.thinkinginnetty.rpc.server;

import com.wusx.thinkinginnetty.rpc.codec.RpcRequest;
import com.wusx.thinkinginnetty.rpc.codec.RpcResponse;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.reflect.FastClass;
import net.sf.cglib.reflect.FastMethod;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 17:59 2020/6/25.
 * @Modified By:
 */
@Slf4j
public class RpcServerHandler extends SimpleChannelInboundHandler<RpcRequest> {

  private Map<String, Object> handlerMap;

  private ThreadPoolExecutor executor = new ThreadPoolExecutor(
      16,
      16,
      600L,
      TimeUnit.SECONDS,
      new ArrayBlockingQueue<Runnable>(65535)
  );

  public RpcServerHandler(Map<String, Object> handlerMap) {
    this.handlerMap = handlerMap;
  }

  @Override
  protected void channelRead0(ChannelHandlerContext ctx, RpcRequest rpcRequest)
      throws Exception {
    //1、解析rpcRequest对象
    //2、从handlerMap中找到具体接口对应的实现的实例
    //3、通过反射cglib调用具体方法，传递相关的执行参数，执行相关的逻辑即可
    //4、返回响应信息给调用方
    executor.submit(new Runnable() {
      @Override
      public void run() {
        RpcResponse rpcResponse = new RpcResponse();
        rpcResponse.setRequestId(rpcRequest.getRequestId());
        try {
          Object result = handle(rpcRequest);
          rpcResponse.setResult(result);
        } catch (Throwable t) {
          log.error("rpc service handle request throwable :{}", t.getMessage());
          rpcResponse.setThrowable(t);
        }
        //回写响应结果
        ctx.writeAndFlush(rpcResponse).addListener(new ChannelFutureListener() {
          @Override
          public void operationComplete(ChannelFuture future) throws Exception {
            if (future.isSuccess()) {
              //afterRpcHook
            }
          }
        });
      }
    });
  }

  private Object handle(RpcRequest rpcRequest) throws InvocationTargetException {
    String className = rpcRequest.getClassName();
    Object ref = handlerMap.get(className);
    Class<?> refClass = ref.getClass();
    String methodName = rpcRequest.getMethodName();
    Class<?>[] parameterTypes = rpcRequest.getParameterTypes();
    Object[] parameters = rpcRequest.getParameters();
    //JDK反射调用
    //或者CGLib反射调用
    FastClass refFastClass = FastClass.create(refClass);
    FastMethod method = refFastClass.getMethod(methodName, parameterTypes);
    return method.invoke(ref, parameters);
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    log.error("server exceptionCaught :{}", cause.getMessage());
    super.exceptionCaught(ctx, cause);
  }
}
