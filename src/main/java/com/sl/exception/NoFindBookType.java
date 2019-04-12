package com.sl.exception;

import org.springframework.http.HttpStatus;

/**
 * @author ShuLu
 */
public class NoFindBookType extends BaseException {
    public NoFindBookType(String msg, HttpStatus code) {
        super(msg, code);
    }
}
