package com.gh.repository;

import com.gh.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.Arrays;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest() {
        ProductCategory productCategory = repository.findById(1).orElse(null);
        System.out.println(productCategory.toString());
    }

//    @Test
//    public void saveTest() {
//        ProductCategory productCategory = new ProductCategory();
//        productCategory.setCategoryName("女生最愛");
//        productCategory.setCategoryType(3);
//        repository.save(productCategory);
//    }

    @Test
    @Transactional   // 完全回滚  用于测试
    public void saveTest() {
//        ProductCategory productCategory = repository.findById(2).orElse(null);
//        productCategory.setCategoryType(100);
//        repository.save(productCategory);

        ProductCategory productCategory = new ProductCategory("男生最爱", 4);
        ProductCategory result = repository.save(productCategory);
        Assert.assertNotNull(result);
        // Assert.assertNotEquals(null, result);
    }

    @Test
    public void findByCategoryTypeInTest() {
        List<Integer> list = Arrays.asList(0,3,10);

        List<ProductCategory> result = repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0, result.size());
    }
}