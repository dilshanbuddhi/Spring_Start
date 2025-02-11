package org.example.contraller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("hello")
public class HelloContraller {

    @GetMapping
    public String sayHello(){
        return "helloooo";
    }

    @PostMapping
    public String sayHelloPost(){
        return "post helloooo";
    }

    @DeleteMapping
    public String sayHelloDelete(){
        return "delete helloooo";
    }

    @PutMapping
    public String sayHelloPut(){
        return "put hellooooo";
    }

    @PatchMapping
    public String sayHelloPatch(){
        return "patch hellooooo";
    }
}
