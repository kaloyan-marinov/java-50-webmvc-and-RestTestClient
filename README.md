# Compile the tests and run the via the `maven-surefire-plugin`:

```shell
$ mvn test

# Run only one test class.
$ mvn test \
    -Dtest=TutorialAboutJava50ApplicationTests
```

# highlight the different categories/types of tests

```
# sanity-check tests
src/test/java/com/github/tutorial_about_java_50/TutorialAboutJava50ApplicationTests.java
src/test/java/com/github/tutorial_about_java_50/TutorialAboutJava50ApplicationTestsSmokeTest.java

# integration tests = full-stack tests
src/test/java/com/github/tutorial_about_java_50/HttpRequestTest.java


```

# run the application from the command line with ... Maven

```shell
$ ./mvnw spring-boot:run
# ...
```

(Either use a web browser or)
Use another terminal window to ssue these HTTP request:
```shell
$ curl localhost:8080
Hello, World
```

# build a single executable JAR file that contains all the necessary dependencies, classes, and resources and run that

build the JAR file with
```shell
./mvnw clean package
```

run the JAR file, as follows:
```
java \
    -jar target/tutorial-about-java-50-0.0.1-SNAPSHOT.jar
```

Issue the above-mentioned HTTP request (either via a web browser or via `curl`).
