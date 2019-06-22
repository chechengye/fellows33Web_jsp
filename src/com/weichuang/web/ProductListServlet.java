package com.weichuang.web;

import com.weichuang.domain.Product;
import com.weichuang.service.ProductService;
import com.weichuang.vo.PageBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ProductListServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            ProductService productService = new ProductService();
            PageBean pageBean = new PageBean();
            String currentPage = req.getParameter("currentPage");
            if(currentPage == null) currentPage = "1";
            //1、封装当前页
            pageBean.setCurrentPage(Integer.valueOf(currentPage));
            //2、总数量
            int totalCount = productService.getTotalCount();
            pageBean.setTotalCount(totalCount);
            //3、每页最大数量
            int maxCount = 12;
            pageBean.setMaxCount(maxCount);
            //4、总页数
            int totalPages = (int)Math.ceil(1.0*totalCount / maxCount);
            pageBean.setTotalPages(totalPages);

            /***
             *    当前页     索引   数量
             *     1           0      12
             *     2           12     12
             *     3           24     12
             *
             */

            int index = (Integer.valueOf(currentPage) - 1) * maxCount;
            //5、当前页数据
            List<Product> productList = productService.getProductsByLimit(index , maxCount);
            pageBean.setProductList(productList);
            //List<Product> productList = productService.getAllProduct();
            req.setAttribute("pageBean" , pageBean);
            req.getRequestDispatcher("product_list.jsp").forward(req , resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req , resp);
    }
}
