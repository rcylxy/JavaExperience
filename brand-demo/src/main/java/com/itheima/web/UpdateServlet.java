package com.itheima.web;
/**
 * @Classname ${NAME}
 * @Date 2022/7/11 17:53
 * @Created by 李晓阳
 */

import com.itheima.pojo.Brand;
import com.itheima.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet {

    private BrandService service = new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("updateServlet");
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        System.out.println("debug-----------id=="+id);

        String brandName = request.getParameter("brandName");
        String companyName = request.getParameter("companyName");
        String ordered = request.getParameter("ordered");
        String description = request.getParameter("description");
        String status = request.getParameter("status");

        Brand brand = new Brand();

        brand.setId(Integer.parseInt(id));
        brand.setDescription(description);
        brand.setStatus(Integer.parseInt(status));
        brand.setBrandName(brandName);
        brand.setOrdered(Integer.parseInt(ordered));
        brand.setCompanyName(companyName);

        service.update(brand);
        request.getRequestDispatcher("/selectAllServlet").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
