package com.weichuang.web;

import com.weichuang.domain.Category;
import com.weichuang.domain.Product;
import com.weichuang.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AdminProductListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            ProductService productService = new ProductService();
            List<Product> productList = productService.getAllProduct();
            List<Category> categoryList = productService.getAllCategory();
            req.setAttribute("productList" , productList);
            req.setAttribute("categoryList" , categoryList);
            req.getRequestDispatcher("admin/product/list.jsp").forward(req , resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req , resp);
    }
}
