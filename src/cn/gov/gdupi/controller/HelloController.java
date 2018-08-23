package cn.gov.gdupi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ping")
public class HelloController {

    @RequestMapping("")
    public String index() {
        return "hello";
    }
}
