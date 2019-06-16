package com.weichuang.service;

import com.weichuang.dao.ProductDao;
import com.weichuang.domain.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductService {

    private ProductDao productDao;

    public ProductService(){
        productDao = new ProductDao();
    }
    public List<Product> getAllProduct() throws SQLException {
        return productDao.getAllProduct();
    }

    public Product getProductById(String pid) throws SQLException {
        return productDao.getProductById(pid);
    }
}
