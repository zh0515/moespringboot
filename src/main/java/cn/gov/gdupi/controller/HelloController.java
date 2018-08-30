package cn.gov.gdupi.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ping")
public class HelloController {

    @ApiOperation(value = "测试apiserver 健康状况", notes = "")
    @RequestMapping("")
    public String index() {
        return "hello";
    }
}
