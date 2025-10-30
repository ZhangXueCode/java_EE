import com.oracle.webservices.internal.api.message.ContentType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/post")
public class doPost extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("你好");
        resp.setContentType("test/html;charset = utf8");
        resp.getWriter().write("你好");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("你好");
        resp.setContentType("test/html;charset = utf8");
        resp.getWriter().write("你好");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("你好");
        resp.setContentType("test/html;charset = utf8");
        resp.getWriter().write("你好");
    }
}
