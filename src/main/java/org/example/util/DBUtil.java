package org.example.util;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.example.exception.AppException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created with Intellij IDEA
 * Description:
 * User : 花朝
 * Date : 2020-12-03
 * Time : 15:17
 */
public class DBUtil {
    //final 修饰，引用无法改变;
    private static final DataSource  DS = new MysqlDataSource();
    //多线程学习后，会优化围殴双重校验锁的单例模式；
    static {
        ((MysqlDataSource)DS).setUrl("jdbc:mysql://localhost:3306/chong_blog?user=root&password=WOaini91154576@qq.com&useUnicode=true&useSSL=false&characterEncoding=UTF-8");
    }
    public static Connection getConnection(){
        try {
            return DS.getConnection();
        }catch (SQLException e){
            throw new AppException("DB001","获取数据库连接失败",e);
        }
    }
    public static void close(Connection c, Statement s){
        close(c,s,null);
    }

    public static void close(Connection c, Statement s, ResultSet r) {
        try {
            if(r != null){
                r.close();
            }
            if(s != null){
                s.close();
            }
            if(c != null){
                c.close();
            }
        } catch (SQLException e) {
            throw  new AppException("DB002","释放数据库资源失败",e);
        }
    }
}
