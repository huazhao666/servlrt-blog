package org.example.srevlet;

import org.example.exception.AppException;
import org.example.model.JSONResponse;
import org.example.util.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with Intellij IDEA
 * Description:
 * User : 花朝
 * Date : 2020-12-02
 * Time : 10:51
 */
public abstract class AbstractBaseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        //创建前后端统一的数据格式对象
        JSONResponse js = new JSONResponse();

        //业务解析请求数据，执行业务操作，获取业务操作返回类型
        try{
            Object data = process(req,resp);
            js.setSuccess(true);
            js.setData(data);
            //业务操做成功，设置success=true及业务数据
            //统一异常处理
        }catch (Exception e){
            //业务操做失败，设置success=false,code错误码，message;
            //1.处理自定义异常（code，message，）
            // 2.其他异常,错误消息可能是英文
            e.printStackTrace();
            String code = "unknown";
            String message = "未知错误，请联系管理员";
            if(e instanceof AppException) {
                code = ((AppException) e).getCode();
                message = e.getMessage();
            }
            js.setCode(code);
            js.setMessage(message);
        }

        //将统一的数据对象，序列化为json字符串，返回给前端
        PrintWriter pw = resp.getWriter();
        pw.println(JSONUtil.serialize(js));
        pw.flush();;
        pw.close();
    }

    protected abstract Object  process(HttpServletRequest req, HttpServletResponse resp) throws  Exception;

}

