package com.gh.service;

import com.gh.dataobject.ProductCategory;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoryService {
    // 通过主键查找
    ProductCategory findOne(Integer categoryId);
    // 查找所有商品
    List<ProductCategory> findAll();
    // 查找商品类别
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
    // 保存商品
    ProductCategory save(ProductCategory productCategory);
}
