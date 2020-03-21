package com.dayunwu.manage.service;

import com.dayunwu.manage.pojo.Product;

import java.util.List;

/**
 * @author： reyco
 * @date 2020/3/22
 */
public interface ProductService {
    boolean add(Product product);
    Product get(int id);
    List<Product> list();
}
