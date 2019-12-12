package com.example.demo;

import com.example.demo.factory.DemoThreadPoolFactory;

import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * jdk1.8之前的Future
 *
 * @author Fa
 */
public class JavaFuture {

    public static void main(String[] args) throws Throwable {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(),
                DemoThreadPoolFactory.newInstance()
        );

        Future<String> f = threadPoolExecutor.submit(() -> {
            System.out.println("task started!");
            longTimeMethod();
            System.out.println("task finished!");
            return "hello";
        });

//        ExecutorService executor = Executors.newFixedThreadPool(1);
//        Future<String> f = executor.submit(new Callable<String>() {
//
//            @Override
//            public String call() throws Exception {
//                System.out.println("task started!");
//                longTimeMethod();
//                System.out.println("task finished!");
//                return "hello";
//            }
//        });

        //此处get()方法阻塞main线程
        System.out.println(f.get());
        System.out.println("main thread is blocked");
    }

    public static void longTimeMethod() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}