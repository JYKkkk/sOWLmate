package com.ssafy.sowlmate.exception;

public class ExistValueException extends RuntimeException {

    public ExistValueException() {
        super("이미 존재하는 값입니다.");
    }
}
