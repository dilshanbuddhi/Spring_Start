package org.example.contraller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/param")
public class ParamController {

    @GetMapping(params = {"id", "name"})
    public String test1(@RequestParam ("id") String id , @RequestParam("name") String name) {
        return "id: " + id + " name: " + name;
    }

    @GetMapping(path = "/newOne" , params = {"id" , "name"})
    public String test2(@RequestParam ("id") String id , @RequestParam("name") String name) {
        return "id: " + id + " name: " + name;
    }
}
