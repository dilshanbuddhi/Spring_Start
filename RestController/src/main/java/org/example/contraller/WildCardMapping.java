package org.example.contraller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wildcard")
public class WildCardMapping {

    @GetMapping(path = "test1/*/hello")
    public String sayHello(){
        return "hello";
    }
}
