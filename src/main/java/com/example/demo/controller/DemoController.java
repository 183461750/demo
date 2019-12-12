package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Fa
 * @date 2019-10-06 14:39
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/get")
    public String get() {
        return "Hello World!";
    }

    @GetMapping("/redis/{key}/{value}")
    public Object redis(@PathVariable String key, @PathVariable String value) {
        redisTemplate.opsForValue().set(key, value);
        return redisTemplate.opsForValue().get(key);
    }

    @GetMapping(value = "/AsyncTest/{testUrl}")
    public DeferredResult<ResponseEntity<String>> testProcess(@PathVariable String testUrl) {
        final DeferredResult<ResponseEntity<String>> deferredResult = new DeferredResult<>();

        // 业务逻辑异步处理,将处理结果 set 到 DeferredResult
        new Thread(new AsyncTask(deferredResult)).start();

        System.out.println("aaa");

        return deferredResult;
    }

    @GetMapping(value = "/AsyncTest2/{testUrl}")
    public Map testProcess2(@PathVariable String testUrl) {
        HashMap resultMap = new HashMap<>();

        // 业务逻辑异步处理,将处理结果 set 到 DeferredResult
        new Thread(new AsyncTask2(resultMap)).start();

        System.out.println("aaa");
        resultMap.put("a", "a");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return resultMap;
    }

    private static class AsyncTask implements Runnable {

        private DeferredResult result;

        private AsyncTask(DeferredResult result) {
            this.result = result;
        }

        @Override
        public void run() {
            //业务逻辑START
//            ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
//            HttpServletRequest request = servletRequestAttributes.getRequest();
//            String queryString = request.getQueryString();
            String queryString = "queryString";
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            result.setResult(queryString);
            //业务逻辑END
            result.setResult(result);
        }
    }


    private static class AsyncTask2 implements Runnable {

        private Map result;

        private AsyncTask2(Map result) {
            this.result = result;
        }

        @Override
        public void run() {
            //业务逻辑START
//            ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
//            HttpServletRequest request = servletRequestAttributes.getRequest();
//            String queryString = request.getQueryString();
            String queryString = "queryString";
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            result.put(queryString,"b");
            //业务逻辑END
            result.put(result,"c");
        }
    }


}
