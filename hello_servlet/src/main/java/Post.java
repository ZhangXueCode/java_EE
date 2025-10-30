import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

class ServletRequest {
    public String aa;
    public String bb;

}
class ServletResponse {
    public boolean ok;
}
@WebServlet("/json")
public class Post extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ServletRequest request = objectMapper.readValue(req.getInputStream(),ServletRequest.class);
        System.out.println("aa=" + request.aa);
        System.out.println("bb=" + request.bb);

        ServletResponse response = new ServletResponse();
        response.ok = true;
        String repJson = objectMapper.writeValueAsString(response);
        resp.setContentType("application/json; charset = utf8");
        resp.getWriter().write(repJson);
    }
}
