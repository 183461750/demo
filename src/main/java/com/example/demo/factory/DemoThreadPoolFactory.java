package com.example.demo.factory;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Fa
 * @date 2019-11-07 17:17
 */
public class DemoThreadPoolFactory implements ThreadFactory {

    private static final AtomicInteger poolNumber = new AtomicInteger(1);
    private final ThreadGroup threadGroup;

    private DemoThreadPoolFactory() {
        SecurityManager securityManager = System.getSecurityManager();
        threadGroup = securityManager != null ? securityManager.getThreadGroup() :
                Thread.currentThread().getThreadGroup();
    }

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(
                threadGroup,
                r,
                "a" + "-pool-" + poolNumber.getAndIncrement(),
                0
        );
    }

    public static DemoThreadPoolFactory newInstance() {
        return new DemoThreadPoolFactory();
    }

}
