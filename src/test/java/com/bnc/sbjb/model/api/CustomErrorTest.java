package com.bnc.sbjb.model.api;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Instant;
import java.util.Collections;
import org.junit.jupiter.api.Test;

class CustomErrorTest {

    @Test
    void testTimestampIdempotent() {
        assertThat(new CustomError().getTimestamp()).isBeforeOrEqualTo(Instant.now());
    }

    @Test
    void testMessageIdempotent() {
        CustomError customError = new CustomError();
        customError.setMessage("test-message");
        assertThat(customError.getMessage()).isEqualTo("test-message");
    }

    @Test
    void testSubErrorIdempotent() {
        CustomError customError = new CustomError();
        customError.addSubErrors(Collections.singletonList(new TestSubError()));
        assertThat(customError.getSubErrors().size()).isEqualTo(1);
    }
}
