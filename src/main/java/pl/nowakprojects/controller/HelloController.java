package pl.nowakprojects.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Mateusz on 07.04.2017.
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/world")
    public String hello(){
        return "Hello World!";
    }
}
