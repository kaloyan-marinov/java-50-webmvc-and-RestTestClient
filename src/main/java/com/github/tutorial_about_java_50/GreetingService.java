package com.github.tutorial_about_java_50;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    
    public String greet() {
        return "[from GreetingService] Hello, World";
    }

}
