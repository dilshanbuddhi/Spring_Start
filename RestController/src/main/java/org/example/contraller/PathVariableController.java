package org.example.contraller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("PathVariable")
public class PathVariableController {
    @GetMapping(path = "/test1/{id}/{name}")
    public String test1(@PathVariable ("id") String id, @PathVariable("name")  String name) {
        return "id: " + id + " name: " + name;
    }

    @GetMapping(path =" {id:[A][0-9]{3}}")
    public String test2(@PathVariable String id) {
        return "id: " + id;
    }
}

