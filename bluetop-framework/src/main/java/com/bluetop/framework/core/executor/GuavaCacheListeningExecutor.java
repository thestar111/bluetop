package com.bluetop.framework.core.executor;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <Guava缓存监听器>
 *
 * @author zhouping
 * @version 1.0
 * @date 2021/1/26 8:59 上午
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Configuration
public class GuavaCacheListeningExecutor implements DisposableBean {

    /**
     * 执行器
     */
    private final ListeningExecutorService executor = MoreExecutors.listeningDecorator(new ThreadPoolExecutor(5, 50,
            0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(2000)));

    /**
     * 提交异步任务
     *
     * @param callable
     * @param <T>
     * @return
     */
    public <T> ListenableFuture<T> submit(Callable<T> callable) {
        return executor.submit(callable);
    }

    @Override
    public void destroy() throws Exception {
        if (!executor.isShutdown()) {
            executor.isShutdown();
        }
    }
}
