package com.itheima.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Classname BrandServlet
 * @Date 2022/7/13 13:52
 * @Created by 李晓阳
 */
@WebServlet("/user/*")
public class UserServlet extends BaseServlet {
    public void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("user selectAll---------");
    }

    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("user add-------------");
    }


}
