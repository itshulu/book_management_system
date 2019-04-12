package com.sl.exception;

import org.springframework.http.HttpStatus;

public class NotFoundUser extends BaseException {
    public NotFoundUser(String msg, HttpStatus code) {
        super(msg, code);
    }
}
