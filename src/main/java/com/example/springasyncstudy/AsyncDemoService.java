package com.example.springasyncstudy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

@Service
public class AsyncDemoService {

    @Async("threadPoolTaskExecutor")
    public Future<String> methodB(final int num) {
        try {
            Thread.sleep(3000L);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new AsyncResult<>(String.valueOf(num));
    }
}
