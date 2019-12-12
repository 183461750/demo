package com.example.demo;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Test {

    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                10, 15,
                30, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(), (ThreadFactory) Thread::new);

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 100; i++) {
            String aa = String.valueOf(new Random().nextBoolean());
            threadPoolExecutor.submit(() -> {
                sb.append(aa);
                sb.append("b");
                sb.append("c");
                sb.append("d");

                log.debug("sb1=" + sb.toString());
            });
        }


        StringBuilder sb3 = new StringBuilder();
        sb3.append("a");
        sb3.append("b");
        sb3.append("c");
        sb3.append("d");

        log.debug("sb3=" + sb3.toString());


        System.exit(0);

        List<String> list = new ArrayList<>();
        int a = 20;
        for (int i = 1; i <= a; i++) {
            String output = "";
            output = i % 3 == 0 ?
                    i % 5 == 0 ?
                            "fizz buzz" :
                            "fizz" :
                    i % 5 == 0 ?
                            "buzz" :
                            i + "";
            list.add(output);
        }
        System.out.println(list);
        Integer.valueOf(100);
        Calendar.getInstance(Locale.CHINA);
    }

}
