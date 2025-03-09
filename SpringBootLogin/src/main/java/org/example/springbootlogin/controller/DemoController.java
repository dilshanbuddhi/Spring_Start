package org.example.springbootlogin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/demo")
public class DemoController {

    private static final Logger logger = LoggerFactory.getLogger(DemoController.class.getName());

    @GetMapping("/test1")
    public void test1() {
        logger.trace("trace massage");
        logger.debug("debug massage");
        logger.info("info massage");
        logger.warn("warn massage");
        logger.error("error massage");
    }
}
