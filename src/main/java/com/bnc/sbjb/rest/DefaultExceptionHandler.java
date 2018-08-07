package com.bnc.sbjb.rest;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import com.bnc.sbjb.model.api.CustomError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.handler.ResponseStatusExceptionHandler;
import reactor.core.publisher.Mono;

@ControllerAdvice
public class DefaultExceptionHandler extends ResponseStatusExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(DefaultExceptionHandler.class);

    @RequestMapping(value = "/error")
    @ExceptionHandler({Throwable.class})
    @ResponseStatus(value = INTERNAL_SERVER_ERROR)
    public Mono<CustomError> error(Throwable exception) {
        logger.warn("Captured errorMessage=\"{}\"", exception.getMessage());
        return Mono.just(new CustomError());
    }
}
