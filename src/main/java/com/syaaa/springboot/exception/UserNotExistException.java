package com.syaaa.springboot.exception;

/**
 * @ClassName UserNotExistException
 * @Description TODO
 * @Author APPO
 * @Date 17:05   2018-9-21
 * @Version 1.0
 **/
public class UserNotExistException extends RuntimeException {

    public UserNotExistException() {
        super("用户不存在");
    }
}
