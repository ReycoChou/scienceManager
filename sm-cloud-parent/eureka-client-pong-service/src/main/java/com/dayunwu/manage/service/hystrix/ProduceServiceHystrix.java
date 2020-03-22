package com.dayunwu.manage.service.hystrix;

import com.dayunwu.manage.pojo.Product;
import com.dayunwu.manage.service.ProductService;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author： reyco
 * @date 2020/3/22
 */
@Component
public class ProduceServiceHystrix implements ProductService {

    @Override
    public Product get(int id) {
        return new Product(id,"error");
    }

    @Override
    public boolean add(Product product) {
        return false;
    }

    @Override
    public List<Product> list() {
        return null;
    }
}
