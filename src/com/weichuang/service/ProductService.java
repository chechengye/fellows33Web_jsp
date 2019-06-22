package com.weichuang.service;

import com.weichuang.dao.ProductDao;
import com.weichuang.domain.Category;
import com.weichuang.domain.Product;
import com.weichuang.vo.Condition;

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

    public List<Category> getAllCategory() throws SQLException {
        return productDao.getAllCategory();
    }

    public void addProduct(Product product) throws SQLException {
        productDao.addProduct(product);
    }

    public void deleteProductById(String pid) throws SQLException {
        productDao.deleteProductById(pid);
    }

    public void updateProductByProduct(Product product) throws SQLException {
        productDao.updateProductByProduct(product);
    }

    public List<Product> getProductsByCondition(Condition condition) throws SQLException {
        return productDao.getProductsByCondition(condition);
    }

    public int getTotalCount() throws SQLException {
        return productDao.getTotalCount();
    }

    public List<Product> getProductsByLimit(int index , int maxCount) throws SQLException {
        return productDao.getProductsByLimit(index , maxCount);
    }

    public List<Product> getProductsByWord(String word) throws SQLException {
        return productDao.getProductsByWord(word);
    }
}
