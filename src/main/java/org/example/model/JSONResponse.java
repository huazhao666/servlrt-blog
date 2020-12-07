package org.example.model;

/**
 * Created with Intellij IDEA
 * Description:
 * User : 花朝
 * Date : 2020-12-02
 * Time : 10:58
 */

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 前后端约定的统一数据格式：返回的状态码是200
 */
@Getter
@Setter
@ToString

public class JSONResponse {
    //业务是否操作成功
    private  boolean success;
    //错误码：开发人员解决问题
    private String code;
    //错误信息：给用户的信息；
    private String message;
    //业务数据
    private Object data;

}
