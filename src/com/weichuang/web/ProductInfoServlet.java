package com.weichuang.web;

import com.weichuang.domain.Product;
import com.weichuang.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ProductInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String pid = req.getParameter("pid");
            ProductService productService = new ProductService();
            Product product = productService.getProductById(pid);
            req.setAttribute("product" , product);
            req.getRequestDispatcher("product_info.jsp").forward(req , resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req , resp);
    }
}
