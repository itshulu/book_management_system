package com.sl.exception;

/**
 * @author ShuLu
 */
public class NotNameException extends Exception {
    private String errorMessage;
    public NotNameException(String message) {
        super(message);
        this.errorMessage=message;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
