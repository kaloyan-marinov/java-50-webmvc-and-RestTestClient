/*
[This file implements]
a simple sanity check test that will fail if the «application context» cannot start.
*/

package com.github.tutorial_about_java_50;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/*
[This] annotation tells Spring Boot to
look for a main configuration class (one with `@SpringBootApplication`, for instance)
and
use that to start a Spring «application context».
*/
@SpringBootTest
class TutorialAboutJava50ApplicationTests {

	@Test
	void contextLoads() {
	}

}
