package com.example.springasyncstudy;

import org.springframework.stereotype.Service;

@Service
public class DemoService {


    public String methodA() {
        String result = "";

        result += methodB(1);
        result += methodB(2);

        return result;
    }

    private String methodB(int num){

        try {
            Thread.sleep(1000L);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return String.valueOf(num);
    }



}
