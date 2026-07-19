/*
[This file implements]
a simple sanity check test that will fail if the «application context» cannot start
[or if] the context [fails to create a specific] controller.
*/


package com.github.tutorial_about_java_50;

/*
`AssertJ` (provides `assertThat()` and other methods) to express the test assertions.
*/
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TutorialAboutJava50ApplicationTestsSmokeTest {
    
    /*
    [Due to this] annotation,
    ... the controller is injected before the test methods are run.
    */
    @Autowired
    private HomeController controller;

    @Test
    void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }
}
