package com.example.designMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author Fa
 * @date 2019-10-21 15:46
 */
public class Test {

    @Autowired
    private static ThreadPoolTaskExecutor taskExecutor;

    public static void main(String[] args) {
        // 1.懒汉式
//        Singleton singleton = Singleton.getInstance();
//        Assert.assertNotNull(singleton);

        // 2.双重线程检查模式
        while (true) {
            Future<SingletonInner> submit = taskExecutor.submit(SingletonInner::getInstance);
            try {
                submit.get(30, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
        }
    }

}
