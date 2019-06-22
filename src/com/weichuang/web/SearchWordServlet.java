package com.weichuang.web;

import com.alibaba.fastjson.JSON;
import com.weichuang.domain.Product;
import com.weichuang.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class SearchWordServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            req.setCharacterEncoding("utf-8");
            String word = req.getParameter("word");
            ProductService productService = new ProductService();
            List<Product> productList =  productService.getProductsByWord(word);
            System.out.println("word = " + word);
            System.out.println("productList = " + productList);
            resp.setContentType("text/html;charset=utf-8");
            String jsonString = JSON.toJSONString(productList);
            resp.getWriter().write(jsonString);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req , resp);
    }
}
