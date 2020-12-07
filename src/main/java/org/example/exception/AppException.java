package org.example.exception;

import lombok.Getter;

/**
 * Created with Intellij IDEA
 * Description:
 * User : 花朝
 * Date : 2020-12-02
 * Time : 11:43
 */
@Getter
public class AppException  extends RuntimeException{

    private String code;//抛异常时给定的错误码

    public AppException(String code, String message) {
        this(code,message,null);
    }

    public AppException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}
