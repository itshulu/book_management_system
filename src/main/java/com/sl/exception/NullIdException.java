package com.sl.exception;

import org.springframework.http.HttpStatus;

/**
 * @author ShuLu
 */
public class NullIdException  extends BaseException {

    public NullIdException(String msg, HttpStatus code) {
        super(msg, code);
    }
}
