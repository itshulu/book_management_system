package com.sl.exception;

import org.springframework.http.HttpStatus;

/**
 * @author ShuLu
 */
public class AddUserException extends BaseException {
    public AddUserException(String msg, HttpStatus code) {
        super(msg, code);
    }
}
