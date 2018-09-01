package com.exfox.gril.controller;

import com.exfox.gril.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    private GirlProperties girlProperties;

    @RequestMapping(value = "/say", method = RequestMethod.GET)
    public String say(@RequestParam(value = "id",required = false,defaultValue = "0") Integer id) {
        return "id:" + id;
    }

    @GetMapping(value = "/say1")
    public  String say1(){
        return  girlProperties.getCupSize();
    }
}
