import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //将这个显示到tomcat服务器的控制台上
        System.out.println("hello world");
        //这个会写到http响应的body中
        //将这个显示到浏览器的页面中
        resp.getWriter().write("hello world");
    }
}
