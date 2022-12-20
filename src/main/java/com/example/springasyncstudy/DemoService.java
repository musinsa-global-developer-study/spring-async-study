package com.example.springasyncstudy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

@Service
public class DemoService {


    public String methodA() {
        String result = "";

        ExecutorService executor = Executors.newFixedThreadPool(10);

        Callable<String> callableTask1 = () -> {
            return methodB(1);
        };

        Callable<String> callableTask2 = () -> {
            return methodB(2);
        };

        List<Callable<String>> callableTasks = new ArrayList<>();
        callableTasks.add(callableTask1);
        callableTasks.add(callableTask2);

        // 일단 되는지 보자....
        try{
            List<Future<String>> futures = executor.invokeAll(callableTasks);
            futures.forEach(stringFuture -> {
                try {
                    System.out.println(stringFuture.get());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        executor.shutdown();



        return result;
    }

    private String methodB(int num){

        try {
            Thread.sleep(3000L);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return String.valueOf(num);
    }



}
