/*
[This file implements
a test that asserts] the behavior of your application.

[More concretely, this test does the following]:

start the application
and
listen for a connection (as it would do in production)

and then
send an HTTP request
and
assert the response.
*/

package com.github.tutorial_about_java_50;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.web.servlet.client.RestTestClient;

/*
[The first annotation serves]
to start the server with a random port
(useful to avoid conflicts in test environments).
*/
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureRestTestClient
public class HttpRequestTest {

    /*
    [The following represents] the injection of the port.
    */
    @LocalServerPort
    private int port;

    @Autowired
    private RestTestClient restTestClient;

    @Test
    void greetingShouldReturnDefaultMessage() {
        restTestClient
            .get().uri("http://localhost:%d/".formatted(port))
            .exchange()
            .expectBody(String.class)
            .isEqualTo("Hello, World")
        ;
    }

}
