/*
[This file implements
a test, in which]
Spring Boot instantiates only the web layer rather than the whole [«application context»].
*/

package com.github.tutorial_about_java_50;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.client.RestTestClient;

/*
[The first annotation]
[narrows this test] to only the web layer.

In an application with multiple controllers,
[using the first annotation as it is used here enables the test to]
ask for only one [controller] to be instantiated.
*/
@WebMvcTest(HomeController.class)
@AutoConfigureRestTestClient
public class WebLayerTest {
    
    @Autowired
    private RestTestClient restTestClient;

    @Test
    void greetingShouldReturnDefaultMessage() {
        restTestClient
            .get().uri("/")
            .exchange()
            .expectBody(String.class)
            .isEqualTo("Hello, World")
        ;
    }

}
