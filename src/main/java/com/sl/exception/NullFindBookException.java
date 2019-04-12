package com.sl.exception;

import org.springframework.http.HttpStatus;

/**
 * @author ShuLu
 */
public class NullFindBookException extends BaseException {

    public NullFindBookException(String msg, HttpStatus code) {
        super(msg, code);
    }
}
