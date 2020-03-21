package com.dayunwu.manage.service.impl;

import com.dayunwu.manage.dao.ProductMapper;
import com.dayunwu.manage.pojo.Product;
import com.dayunwu.manage.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author： reyco
 * @date 2020/3/22
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;

    @Override
    public boolean add(Product product) {
        productMapper.insert(product);
        return true;
    }

    @Override
    public Product get(int id) {
        return productMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Product> list() {
        return null;
    }
}
