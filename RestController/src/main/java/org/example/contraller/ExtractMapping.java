package org.example.contraller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/extract")
public class ExtractMapping {

 @GetMapping(path = "/test1")
 public String sayHello(){
     return "test1";
 }

 @GetMapping(path = "/test2/dila")
 public String sayHello2(){
     return "test2";
 }

}
