package com.github.tutorial_about_java_50;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
Notice that,
unlike the `HomeController`,
the following controller class is more realistic
because it has nonzero dependencies.
*/
@RestController
public class GreetingController {
    
    private final GreetingService service;

    /*
    Spring automatically injects the service dependency into the controller
    (because of the constructor signature).
    */
    public GreetingController(GreetingService service) {
        this.service = service;
    }

    @GetMapping("/greeting")
    public String greeting() {
        return service.greet();
    }
}
