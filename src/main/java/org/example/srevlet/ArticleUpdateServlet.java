package org.example.srevlet;

import org.example.dao.ArticleDAO;
import org.example.model.Article;
import org.example.util.JSONUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;

/**
 * Created with Intellij IDEA
 * Description:
 * User : 花朝
 * Date : 2020-12-04
 * Time : 11:03
 */
@WebServlet("/articleUpdate")
public class ArticleUpdateServlet extends AbstractBaseServlet {
    @Override
    protected Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        InputStream is = req.getInputStream();
        Article article = JSONUtil.deserialize(is,Article.class);
        int num = ArticleDAO.update(article);
        return null;
    }
}
