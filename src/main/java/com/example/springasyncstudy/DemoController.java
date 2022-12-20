package com.example.springasyncstudy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private final DemoService demoService;

    public DemoController(final DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping
    public String sampleApi1() {

        return demoService.methodA();
    }

    @GetMapping("async")
    public String sampleApi2() {

        return demoService.methodA2();
    }

}
