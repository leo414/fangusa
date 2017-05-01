package com.hhh.fangusa.exception;

import java.text.MessageFormat;

public class UserVisiableException extends RuntimeException {
    private static final long serialVersionUID = -3941496235852955794L;
    private Integer errorCode = Integer.valueOf(500);

    public UserVisiableException() {
    }

    public UserVisiableException(Integer errorCode, String exMessage) {
        super(exMessage);
        this.errorCode = errorCode;
    }

    public UserVisiableException(Integer errorCode, String exMessage, Object... args) {
        super(MessageFormat.format(exMessage, args));
        this.errorCode = errorCode;
    }

    public Integer getErrorCode() {
        return this.errorCode;
    }
}