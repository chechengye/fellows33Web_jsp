package com.weichuang.vo;

import com.weichuang.domain.Product;

import java.util.ArrayList;
import java.util.List;

public class PageBean {
    private int currentPage;//标识当前页
    private int maxCount; //每页容纳数量
    private int totalCount;//总数量
    private int totalPages;//总页数
    private List<Product> productList = new ArrayList<>();//每页的数据


    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
