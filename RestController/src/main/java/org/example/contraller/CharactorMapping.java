package org.example.contraller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/charactor")
@RestController
public class CharactorMapping {

    @GetMapping(path = "/test1/I???")
    public String sayHello(){
        return "hello";
    }
}
