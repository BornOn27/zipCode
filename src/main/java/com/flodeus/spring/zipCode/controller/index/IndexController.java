package com.flodeus.spring.zipCode.controller.index;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping(path = "/")
    public String main(){
        return "Welcome to the Zip Code Service - India";
    }

    @GetMapping(path = "/index")
    public String index(){
        return "Welcome to the Zip Code Service - India";
    }
}
