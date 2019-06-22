package com.weichuang.web;

import com.weichuang.domain.Category;
import com.weichuang.domain.Product;
import com.weichuang.service.ProductService;
import com.weichuang.vo.Condition;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public class AdminSearchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            req.setCharacterEncoding("utf-8");
            Condition condition = new Condition();
            BeanUtils.populate(condition , req.getParameterMap());
            ProductService productService = new ProductService();
            List<Product> productList = productService.getProductsByCondition(condition);
            List<Category> categoryList = productService.getAllCategory();
            req.setAttribute("productList" , productList);
            req.setAttribute("categoryList" , categoryList);
            req.setAttribute("condition" , condition);
            req.getRequestDispatcher("/admin/product/list.jsp").forward(req , resp);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req , resp);
    }
}
