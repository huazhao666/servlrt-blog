package org.example.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created with Intellij IFEA
 * Description:
 * User : 花朝
 * Date : 2020-11-29
 * Time : 13:11
 */
public class JSONUtil {
    //jackson框架中，对json字符串和java对象之间互相转换的类；
    private static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * 序列化操作：java对象序列化为json字符串
     * @param o Java对象
     * @return java字符串
     */
    public static String serialize(Object o){
        try {
            return MAPPER.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException("java对象序列化为json字符串出错：" + o );
        }
    }

    /**
     * 反序列化输入流/字符串为Java对象
     * @param is 输入流
     * @param clazz 指定要反序列化的java对象
     * @param <T> 泛型
     * @return 反序列后的java对象
     */
    public static <T> T deserialize(InputStream is,Class<T> clazz){
        try {
            return MAPPER.readValue(is,clazz);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("反序列化失败");
        }
    }

}
