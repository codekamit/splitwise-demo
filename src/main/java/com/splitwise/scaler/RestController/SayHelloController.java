package com.scaler.splitwise.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SayHelloController {
    @GetMapping("say-hello")
    public @ResponseBody ResponseEntity<String> sayHello() {
        return ResponseEntity.status(HttpStatus.OK).body("Hi Dear!");
    }
}
