package fr.dawan.springintermediare.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class HelloWorldController {
    @Value("${message::Hello World}")
    private String msg;
    @RequestMapping("/hello")
    public String Hello() {
        return msg;
    }
    
}
