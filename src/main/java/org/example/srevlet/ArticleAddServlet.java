package org.example.srevlet;

import org.example.dao.ArticleDAO;
import org.example.model.Article;
import org.example.model.User;
import org.example.util.JSONUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.InputStream;

/**
 * Created with Intellij IDEA
 * Description:
 * User : 花朝
 * Date : 2020-12-04
 * Time : 10:20
 */
@WebServlet("/articleAdd")
public class ArticleAddServlet extends AbstractBaseServlet {
    @Override
    protected Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //通过session获取用户id；
        HttpSession session = req.getSession(false);
        User user = (User) session.getAttribute("user");
        //请求数据类型为application/json,需要从输入流获取；
        InputStream is = req.getInputStream();
        //请求体数据存在于输入流，json格式化需要反序列；
        Article article = JSONUtil.deserialize(is,Article.class);
        article.setUserId(user.getId());
        int num = ArticleDAO.insert(article);
        return null;
    }
}
