package org.example.dao;

import org.example.exception.AppException;
import org.example.model.User;
import org.example.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

/**
 * Created with Intellij IDEA
 * Description:
 * User : 花朝
 * Date : 2020-12-03
 * Time : 16:11
 */
public class LoginDAO {

    public static User query(String username) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = DBUtil.getConnection();
            String sql = "select id, username, password, nickname, birthday, phone_number, email, head\n" +
                    "from user where username = ?";
            ps = c.prepareStatement(sql);
            //设置占位符的值;
            ps.setString(1,username);
            rs = ps.executeQuery();
            //处理结果集；
            User user = null;
            while (rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(username);
                user.setPassword(rs.getString("password"));
                user.setNickname(rs.getString("nickname"));
                java.sql.Date birthday = rs.getDate("birthday");
                if(birthday != null)
                user.setBirthday(new Date(birthday.getTime()));
                user.setPhoneNumber(rs.getString("phone_number"));
                user.setEmail(rs.getString("email"));
                user.setHead(rs.getString("head"));
            }
            return user;
        }catch (Exception e){
            throw new AppException("LOG001","登录操作数据库错误",e);
        }finally {
            DBUtil.close(c,ps,rs);
        }
    }
}
