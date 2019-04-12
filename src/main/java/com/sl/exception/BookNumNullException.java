package com.sl.exception;

import org.springframework.http.HttpStatus;

/**
 * @author ShuLu
 */
public class BookNumNullException  extends BaseException {

    public BookNumNullException(String msg, HttpStatus code) {
        super(msg, code);
    }
}