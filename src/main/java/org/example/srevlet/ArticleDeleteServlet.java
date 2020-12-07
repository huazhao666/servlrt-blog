package org.example.srevlet;

import org.example.dao.ArticleDAO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with Intellij IDEA
 * Description:
 * User : 花朝
 * Date : 2020-12-04
 * Time : 9:17
 */
@WebServlet("/articleDelete")
public class ArticleDeleteServlet extends AbstractBaseServlet {

    @Override
    protected Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String ids = req.getParameter("ids");
        int num = ArticleDAO.delete(ids.split(","));
        return null;
    }
}
