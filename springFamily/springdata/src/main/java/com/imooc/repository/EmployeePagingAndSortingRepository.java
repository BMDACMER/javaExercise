package com.imooc.repository;

import com.imooc.domain.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/7/11 22:56
 */
public interface EmployeePagingAndSortingRepository extends PagingAndSortingRepository<Employee, Integer> {

}
