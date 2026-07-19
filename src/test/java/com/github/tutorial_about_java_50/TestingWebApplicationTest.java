/*
[This file implements
a test, whose scope is]

to not start the server at all

but to test only the layer below that,
where Spring handles the incoming HTTP request and hands it off to your controller.

That way,
almost all of the full stack is used,
and your code will be called in exactly the same way as if it were processing a real HTTP request
but without the cost of starting the server.
*/

package com.github.tutorial_about_java_50;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.client.RestTestClient;

/*
leaving [the first annotation] with its default
[causes Spring Test]
to start a mock server environment.
*/
@SpringBootTest
@AutoConfigureRestTestClient
public class TestingWebApplicationTest {
    
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
