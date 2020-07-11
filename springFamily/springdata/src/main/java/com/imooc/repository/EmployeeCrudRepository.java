package com.imooc.repository;

import com.imooc.domain.Employee;
import org.springframework.data.repository.CrudRepository;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/7/11 22:39
 */
public interface EmployeeCrudRepository extends CrudRepository<Employee, Integer> {

}
