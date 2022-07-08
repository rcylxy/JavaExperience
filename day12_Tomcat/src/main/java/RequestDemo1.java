import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Classname RequestDemo1
 * @Date 2022/7/8 9:50
 * @Created by 李晓阳
 */

@WebServlet("/demo001")
public class RequestDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("-----------------------");

        System.out.println(req.getMethod());

        System.out.println(req.getContextPath());

        System.out.println(req.getRequestURL());

        System.out.println(req.getRequestURI());

        System.out.println(req.getQueryString());

        System.out.println(req.getHeader("user-agent"));

        System.out.println("-------------------------");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
