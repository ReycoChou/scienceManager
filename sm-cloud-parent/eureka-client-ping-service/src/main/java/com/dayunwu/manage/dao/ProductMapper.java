package com.dayunwu.manage.dao;

import com.dayunwu.manage.pojo.Product;
import org.springframework.stereotype.Component;

@Component
public interface ProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
}