package com.bnc.sbjb.model.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@JsonInclude(Include.NON_EMPTY)
public class CustomError {

    private String message;

    private final Instant timestamp = Instant.now();
    private final List<SubError> subErrors = new ArrayList<>();

    public CustomError() {
        // Visible for testing JSON deserialization.
    }

    @Nullable
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Nonnull
    public Instant getTimestamp() {
        return timestamp;
    }

    @Nonnull
    public List<SubError> getSubErrors() {
        return Collections.unmodifiableList(subErrors);
    }

    /**
     * Adds all errors to existing list of errors.
     */
    public void addSubErrors(@Nonnull List<SubError> subErrors) {
        this.subErrors.addAll(subErrors);
    }
}
