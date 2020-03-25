package com.dayunwu.manage.controller;

import com.dayunwu.manage.pojo.Product;
import com.dayunwu.manage.pojo.User;
import com.dayunwu.manage.service.ProductService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.bouncycastle.cms.PasswordRecipientId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import javax.rmi.PortableRemoteObject;
import java.util.List;

/**
 * @author： reyco
 * @date 2020/3/22
 */
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/product/add", method = RequestMethod.POST)
    public boolean add(@RequestBody Product product){
        return productService.add(product);
    }

    @HystrixCommand(fallbackMethod = "get_hystrix")
    @RequestMapping(value = "/product/get/{id}", method = RequestMethod.GET)
    public Product get(@PathVariable("id") int id, @AuthenticationPrincipal String user){
        System.out.println("username : " + user);
        if(id < 0){
            throw new RuntimeException();
        }
        return productService.get(id);
    }

    @RequestMapping(value = "/product/list", method = RequestMethod.GET)
    public List<Product> list(){
        return productService.list();
    }


    public Product get_hystrix(@PathVariable("id") int id, @AuthenticationPrincipal String user){
        System.out.println(user);
        return new Product(id, "error");
    }
}
