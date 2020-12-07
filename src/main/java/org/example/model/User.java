package org.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * Created with Intellij IDEA
 * Description:
 * User : 花朝
 * Date : 2020-12-03
 * Time : 16:02
 */
@Getter
@Setter
@ToString
public class User {
    private Integer id ;
    private String username;
    private String password;
    private String nickname;
    private Date birthday;
    private String phoneNumber;
    private String email;
    private String head;
}
