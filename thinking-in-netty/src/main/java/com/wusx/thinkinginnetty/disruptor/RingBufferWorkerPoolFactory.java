package com.wusx.thinkinginnetty.disruptor;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.ExceptionHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.SequenceBarrier;
import com.lmax.disruptor.WaitStrategy;
import com.lmax.disruptor.WorkerPool;
import com.lmax.disruptor.dsl.ProducerType;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.TimeUnit;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 22:22 2020/6/22.
 * @Modified By:
 */
public class RingBufferWorkerPoolFactory {

  private RingBufferWorkerPoolFactory() {

  }

  /**
   *@Description 静态内部类实现单例模式.
   *@Author wusx
   *@Date 22:24 2020/6/22
   *@Modified
   */
  private static class SingletonHolder {

    static final RingBufferWorkerPoolFactory instance = new RingBufferWorkerPoolFactory();
  }

  public static RingBufferWorkerPoolFactory getInstance() {
    return SingletonHolder.instance;
  }

  /** 消费者池.*/
  private Map<String, MessageConsumer> consumers = new ConcurrentHashMap<>();
  /** 生产者池.*/
  private Map<String, MessageProducer> producers = new ConcurrentHashMap<>();


  private RingBuffer<TranslatorDataWrapper> ringBuffer;

  private SequenceBarrier sequenceBarrier;

  private WorkerPool<TranslatorDataWrapper> workerPool;

  public void initAndStart(ProducerType type, int bufferSize, WaitStrategy waitStrategy,
      MessageConsumer[] messageConsumers) {
    //1、构建ringBuffer
    this.ringBuffer = RingBuffer.create(type,
        (EventFactory<TranslatorDataWrapper>) () -> new TranslatorDataWrapper(),
        bufferSize,
        waitStrategy);
    //2、设置序号栅栏
    this.sequenceBarrier = this.ringBuffer.newBarrier();
    //3、设置工作池
    this.workerPool = new WorkerPool<TranslatorDataWrapper>(this.ringBuffer,
        this.sequenceBarrier,
        new EventExceptionHandler(), messageConsumers);
    //4、把所构建的消费者置入池中
    for (MessageConsumer mc : messageConsumers) {
      this.consumers.put(mc.getConsumerId(), mc);
    }
    //5、添加sequences
    this.ringBuffer.addGatingSequences(this.workerPool.getWorkerSequences());
    //6、启动工作线程池
    this.workerPool.start(new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),
        Runtime.getRuntime().availableProcessors() * 2,
            60,
                        TimeUnit.SECONDS,
                        new ArrayBlockingQueue<Runnable>(1000),
                        new ThreadFactoryBuilder().setNameFormat("disruptor-thread-%d").build(),
                        new AbortPolicy()
    ));
  }

  public MessageProducer getMessageProducer(String producerId) {

    MessageProducer messageProducer = this.producers.get(producerId);
    if (null == messageProducer) {
      messageProducer = new MessageProducer(producerId, this.ringBuffer);
      this.producers.put(producerId, messageProducer);
    }
    return messageProducer;
  }

  /**
   * .
   * @Description 异常处理类
   * @Author:ShangxiuWu
   * @Date: 22:40 2020/6/22.
   * @Modified By:
   */
  static class EventExceptionHandler implements ExceptionHandler<TranslatorDataWrapper> {

    @Override
    public void handleEventException(Throwable throwable, long l,
        TranslatorDataWrapper translatorDataWrapper) {

    }

    @Override
    public void handleOnStartException(Throwable throwable) {

    }

    @Override
    public void handleOnShutdownException(Throwable throwable) {

    }
  }

}
