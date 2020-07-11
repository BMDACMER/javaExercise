package com.imooc.repository;

import com.imooc.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/7/11 23:11
 */
public interface EmployeeJpaRepository extends JpaRepository<Employee,Integer> {

}
