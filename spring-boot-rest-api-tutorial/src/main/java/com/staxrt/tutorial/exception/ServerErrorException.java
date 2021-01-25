package com.staxrt.tutorial.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
public class ServerErrorException extends Exception{
    /**
     * Instantiates a new server error exception.
     *
     * @param message the message
     */
    public ServerErrorException(String message) {
        super(message);
    }

}
