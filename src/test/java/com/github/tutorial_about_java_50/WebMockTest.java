package com.github.tutorial_about_java_50;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.client.RestTestClient;

@WebMvcTest(GreetingController.class)
@AutoConfigureRestTestClient
public class WebMockTest {
    
    @Autowired
    private RestTestClient restTestClient;

    /*
    [This annotation serves]
    to create and inject a mock for the `GreetingService`
    (if you do not do so, the «application context» cannot start)
    */
    @MockitoBean
    private GreetingService mockForGreetingService;

    @Test
    void greetingShouldReturnDefaultMessageFromService() {
        // Arrange.
        when(
            mockForGreetingService.greet()
        )
        .thenReturn(
            "[from mock for GreetingService] Hello, World"
        );

        // Act + Assert.
        restTestClient
            .get().uri("/greeting")
            .exchange()
            .expectBody(String.class)
            .isEqualTo("[from mock for GreetingService] Hello, World")
        ;
    }

}
