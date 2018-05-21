package com.bnc.sbjb.rest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
public class SimpleErrorControllerTest {

    @Autowired
    private TestRestTemplate template;

    @org.junit.jupiter.api.Test
    public void error() {
        String actualResponse = template.getForObject("/invalidurl", String.class);
        Assertions.assertThat(actualResponse).isEqualTo("404");
    }
}
