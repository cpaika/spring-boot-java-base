package com.bnc.sbjb.rest;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import com.bnc.sbjb.model.api.CustomError;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class DefaultErrorController implements ErrorController {

    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    @ResponseStatus(value = NOT_FOUND)
    public Mono<CustomError> error() {
        CustomError error = new CustomError();
        error.setMessage("Not Found");
        return Mono.just(error);
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
