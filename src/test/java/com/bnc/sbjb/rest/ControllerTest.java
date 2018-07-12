package com.bnc.sbjb.rest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
public class ControllerTest {

    @Value("${resource.path}")
    private String basePath;

    @Autowired
    private TestRestTemplate template;

    @Test
    void testHelloWorld() {
        String actual = template.getForObject(basePath + "/hello", String.class);
        assertThat(actual).isEqualTo("Hello World");
    }
}
