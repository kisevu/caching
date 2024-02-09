package org.ameda.kevin.cachingredis.repository;/*
*
@author ameda
@project caching-redis
@package org.ameda.kevin.cachingredis.repository
*
*/

import org.ameda.kevin.cachingredis.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Optional<Employee> findFirstByEmployeeNo(String employeeNo);
}
