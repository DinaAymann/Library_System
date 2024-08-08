package com.library.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY )
public class CanNotCreate extends RuntimeException {

    public CanNotCreate(String message){
        super(message);
    }
}
