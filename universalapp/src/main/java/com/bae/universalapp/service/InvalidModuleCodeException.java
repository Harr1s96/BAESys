package com.bae.universalapp.service;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Please enter correct module code")
public class InvalidModuleCodeException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

}