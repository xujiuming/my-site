package com.ming;

import com.ming.repository.TestEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class TestController {
   private final TestEntityRepository testEntityRepository;
    @GetMapping("/test")
    public Mono<String> test() {
        return Mono.justOrEmpty("test");
    }
}
