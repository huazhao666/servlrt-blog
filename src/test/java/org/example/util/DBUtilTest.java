package org.example.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created with Intellij IDEA
 * Description:
 * User : 花朝
 * Date : 2020-12-03
 * Time : 15:27
 */
public class DBUtilTest {

    @Test
    public  void testConnection(){
        Assert.assertNotNull(DBUtil.getConnection());
    }
}
