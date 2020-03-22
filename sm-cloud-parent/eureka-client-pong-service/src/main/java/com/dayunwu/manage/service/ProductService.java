package com.dayunwu.manage.service;

import com.dayunwu.manage.pojo.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author： reyco
 * @date 2020/3/22
 */
@Service
@FeignClient(value = "MICROSERVICE-PRODUCT")
public interface ProductService {

    @RequestMapping(value = "/product/get/{id}", method = RequestMethod.GET)
    //尽量避免使用PathVariable，在Fegion下容易产生错误
    Product get(@PathVariable("id") int id);

    @RequestMapping(value = "/product/add", method = RequestMethod.POST)
    boolean add(Product product);

    @RequestMapping(value = "/product/list", method = RequestMethod.GET)
    List<Product> list();
}
