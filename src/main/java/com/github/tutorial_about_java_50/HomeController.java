package com.github.tutorial_about_java_50;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
Notice that
the following controller class is simple [in that it] has no dependencies.
*/
@RestController
public class HomeController {

    @GetMapping("/")
    public String greeting() {
        return "Hello, World";
    }
    
}
