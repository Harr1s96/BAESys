package com.bae.universalapp.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Please specify a module")
public class EmptyModuleListException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

}
