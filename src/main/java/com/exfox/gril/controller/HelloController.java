package com.exfox.gril.controller;

import com.exfox.gril.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @Value("${cupSize}")
    private String cupSize;

    @Value("${age}")
    private String age;

    @Value("${content}")
    private String content;

    @Autowired
    private GirlProperties girlProperties;

    @RequestMapping(value = "/say", method = RequestMethod.GET)
    public String say(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id) {
        return "id:" + id;
    }

    @GetMapping(value = "/say1")
    public String say1() {
        return girlProperties.getCupSize();
    }

    @GetMapping("/say2")
    public String say2() {
        return cupSize + age;
    }

    @GetMapping("/say3")
    public String say3() {
        return content;
    }
}
