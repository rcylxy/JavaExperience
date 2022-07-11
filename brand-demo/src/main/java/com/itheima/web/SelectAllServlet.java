package com.itheima.web;
/**
 * @Classname ${NAME}
 * @Date 2022/7/11 17:11
 * @Created by 李晓阳
 */

import com.itheima.pojo.Brand;
import com.itheima.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectAllServlet")
public class SelectAllServlet extends HttpServlet {
    private BrandService service = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("selectAllServlet");
        List<Brand> brands = service.selectAll();
        request.setAttribute("brands", brands);
        request.getRequestDispatcher("/brand.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
