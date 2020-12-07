package org.example.srevlet;

import org.example.dao.ArticleDAO;
import org.example.model.Article;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with Intellij IDEA
 * Description:
 * User : 花朝
 * Date : 2020-12-04
 * Time : 10:44
 */
@WebServlet("/articleDetail")
public class ArticleDetailServlet extends AbstractBaseServlet {
    @Override
    protected Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
       //获取文章id;
        String id = req.getParameter("id");
        Article article = ArticleDAO.query(Integer.parseInt(id));
        return article;
    }
}
