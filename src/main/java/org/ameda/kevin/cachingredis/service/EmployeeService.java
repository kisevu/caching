package org.ameda.kevin.cachingredis.service;/*
*
@author ameda
@project caching-redis
@package org.ameda.kevin.cachingredis.service
*
*/

import org.ameda.kevin.cachingredis.payload.request.EmployeeRequest;
import org.ameda.kevin.cachingredis.payload.request.UpdateNames;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    EmployeeRequest findByEmployeeNo(String employeeNo);

    List<EmployeeRequest> getAll();

    EmployeeRequest update(String employeeNo, UpdateNames updateNames);

    void delete(String employeeNo);

    EmployeeRequest createEmployee(EmployeeRequest employeeRequest);
}
