package com.ming.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

@Controller
@Slf4j
@RequiredArgsConstructor
public class IndexController {

    @RequestMapping(value = {"", "/", "index","/index.html","/index.htm"})
    public Mono<String> index() {
        return Mono.just("index");
    }
}
