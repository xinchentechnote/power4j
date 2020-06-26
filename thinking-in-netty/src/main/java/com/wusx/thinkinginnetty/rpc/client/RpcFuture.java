package com.wusx.thinkinginnetty.rpc.client;

import com.wusx.thinkinginnetty.rpc.codec.RpcRequest;
import com.wusx.thinkinginnetty.rpc.codec.RpcResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 21:20 2020/6/21.
 * @Modified By:
 */
@Slf4j
public class RpcFuture implements Future<Object> {

  private RpcRequest rpcRequest;

  private RpcResponse rpcResponse;

  private long startTime;

  private static final long TIME_THRESHOLD = 5000;

  private ReentrantLock lock = new ReentrantLock();

  private Sync sync;

  private ThreadPoolExecutor executor = new ThreadPoolExecutor(16, 16, 5, TimeUnit.SECONDS,
      new ArrayBlockingQueue<>(65535));

  private List<RpcCallback> pendingCallbacks = new ArrayList<>();

  public RpcFuture(RpcRequest request) {
    this.rpcRequest = request;
    this.startTime = System.currentTimeMillis();
    this.sync = new Sync();
  }

  /**
   *@Description 实际回调处理.
   *@Author wusx
   *@Date 11:55 2020/6/26
   *@Modified
   */
  public void done(RpcResponse response) {
    this.rpcResponse = response;
    boolean release = sync.release(1);
    if (release) {
      invokeCallbacks();
    }
    //rpc调用耗时
    long costTime = System.currentTimeMillis() - startTime;
    if (costTime > costTime) {
      log.warn("tpc response time {} is to slow,requestId:{}", costTime,
          this.rpcRequest.getRequestId());
    }

  }

  /**
   *@Description 回调.
   *@Author wusx
   *@Date 12:14 2020/6/26
   *@Modified
   */
  private void invokeCallbacks() {
    lock.lock();
    try {
      for (final RpcCallback callback : pendingCallbacks) {
        runCallback(callback);
      }
    } finally {
      lock.unlock();
    }
  }

  private void runCallback(RpcCallback callback) {

    final RpcResponse rpcResponse = this.rpcResponse;
    executor.submit(new Runnable() {
      @Override
      public void run() {
        if (null == rpcResponse.getThrowable()) {
          callback.success(rpcResponse.getResult());
        } else {
          callback.failed(rpcResponse.getThrowable());
        }
      }
    });

  }

  @Override
  public boolean cancel(boolean mayInterruptIfRunning) {
    throw new UnsupportedOperationException();
  }

  @Override
  public boolean isCancelled() {
    throw new UnsupportedOperationException();
  }

  @Override
  public boolean isDone() {
    return sync.isDone();
  }

  @Override
  public Object get() throws InterruptedException, ExecutionException {
    //TODO
    sync.tryAcquire(-1);
    if (null != this.rpcResponse) {
      return this.rpcResponse.getResult();
    }
    return null;
  }

  @Override
  public Object get(long timeout, TimeUnit unit)
      throws InterruptedException, ExecutionException, TimeoutException {
    boolean acquireNanos = sync.tryAcquireNanos(-1, unit.toNanos(timeout));
    if (acquireNanos) {
      if (null != this.rpcResponse) {
        return this.rpcResponse.getResult();
      }
    } else {
      throw new RuntimeException("timeout exception requestIt:" +
          this.rpcRequest.getRequestId()
          + ",className:" +
          this.rpcRequest.getClassName()
          + ",methodName:" +
          this.rpcRequest.getMethodName()
      );
    }
    return null;
  }

  public RpcFuture addCallback(RpcCallback callback) {
    lock.lock();
    try {
      if (isDone()) {
        runCallback(callback);
      } else {
        this.pendingCallbacks.add(callback);
      }
    } finally {
      lock.unlock();
    }
    return this;
  }


  class Sync extends AbstractQueuedSynchronizer {

    private final int done = 1;
    private final int pending = 0;

    @Override
    protected boolean tryAcquire(int acquires) {
      return getState() == done ? true : false;
    }

    @Override
    protected boolean tryRelease(int releases) {
      if (getState() == pending) {
        if (compareAndSetState(pending, done)) {
          return true;
        }
      }
      return false;
    }

    public boolean isDone() {
      return getState() == done;
    }
  }


}
