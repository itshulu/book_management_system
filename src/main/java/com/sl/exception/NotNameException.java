package com.sl.exception;

import org.springframework.http.HttpStatus;

/**
 * @author ShuLu
 */
public class NotNameException extends BaseException {

    public NotNameException(String msg, HttpStatus code) {
        super(msg, code);
    }
}
