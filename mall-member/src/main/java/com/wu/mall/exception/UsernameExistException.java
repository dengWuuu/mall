package com.wu.mall.exception;

public class UsernameExistException extends RuntimeException {

    public UsernameExistException() {
        super("用户名存在");
    }
}
