package com.dayunwu.manage.controller;

import com.dayunwu.manage.pojo.Product;
import com.dayunwu.manage.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author： reyco
 * @date 2020/3/22
 */
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/consumer/product/add", method = RequestMethod.POST)
    public boolean add(@RequestBody Product product) { return productService.add(product); }

    @RequestMapping(value = "/consumer/product/get/{id}", method = RequestMethod.GET)
    public Product get(@PathVariable("id") int id) { return productService.get(id); }

    @RequestMapping(value = "/consumer/product/list", method = RequestMethod.GET)
    public List<Product> list() { return productService.list(); }

}
