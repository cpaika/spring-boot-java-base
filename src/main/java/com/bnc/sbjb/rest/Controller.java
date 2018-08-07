package com.bnc.sbjb.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("${resource.path}")
public class Controller {

    @RequestMapping("/hello")
    public Mono<String> helloWorld() {
        return Mono.just("Hello World");
    }
}
