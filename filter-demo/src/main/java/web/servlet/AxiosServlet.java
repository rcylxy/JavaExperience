package web.servlet;
/**
 * @Classname ${NAME}
 * @Date 2022/7/12 12:12
 * @Created by 李晓阳
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/axiosServlet")
public class AxiosServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("get----------");
        String username = request.getParameter("username");
        System.out.println(username);
        response.getWriter().write("hello,axios");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("post---------");
        this.doGet(request, response);

    }
}
