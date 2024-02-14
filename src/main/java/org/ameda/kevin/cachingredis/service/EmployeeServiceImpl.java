package org.ameda.kevin.cachingredis.service;/*
*
@author ameda
@project caching-redis
@package org.ameda.kevin.cachingredis.service
*
*/

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ameda.kevin.cachingredis.entity.Employee;
import org.ameda.kevin.cachingredis.exceptions.EmployeeNotFoundException;
import org.ameda.kevin.cachingredis.payload.request.EmployeeRequest;
import org.ameda.kevin.cachingredis.payload.request.UpdateNames;
import org.ameda.kevin.cachingredis.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
private final EmployeeRepository repository;
private final ModelMapper modelMapper;

    @Cacheable(value = "EmployeeRequest",key = "#employeeNo")
    @Override
    public EmployeeRequest findByEmployeeNo(String employeeNo) {
    /*
    @author{author}
    */
        Optional<Employee> employee = repository
                .findFirstByEmployeeNo(employeeNo);
        log.info("Fetch employee from dB by employeeNo:{}",employeeNo);
       return employee
                .map(value->modelMapper.map(value,EmployeeRequest.class))
                .orElseThrow(()->new EmployeeNotFoundException("Couldn't find employee with passed employee number..."));
    }

    @Caching
    @Override
    public List<EmployeeRequest> getAll() {
    /*
    @author{author}
    */
        List<Employee> all = repository.findAll();
        assert !(all.isEmpty());
        log.info("fetching from the database.");
            return all.stream()
                .map(emp-> modelMapper.map(emp,EmployeeRequest.class))
                .toList();
        /*
        *  if empty then return an empty list...
        * */
    }

    @CachePut(value = "EmployeeRequestUpdate",key = "#employeeNo")
    @Override
    public EmployeeRequest update(String employeeNo, UpdateNames updateNames) {
    /*
    @author{author}
    */
        Optional<Employee> employee = repository.findFirstByEmployeeNo(employeeNo);
        assert employee.isPresent();
        employee.get().setFirstName(updateNames.getFirstName());
        employee.get().setLastName(updateNames.getLastName());
        Employee newEmployee =  repository.save(employee.get());
        return modelMapper.map(newEmployee,EmployeeRequest.class);
    }

    @CacheEvict(value = "EmployeeRequestDelete",key = "#employeeNo")
    @Override
    public void delete(String employeeNo) {
    /*
    @author{author}
    */
        Optional<Employee> employee = repository.findFirstByEmployeeNo(employeeNo);
        employee.ifPresent(repository::delete);
    }

    @CachePut(value = "EmployeeRequest", key = "#employeeRequest.employeeNo")
    @Override
    public EmployeeRequest createEmployee(EmployeeRequest employeeRequest) {
    /*
    @author{author}
    */
        Employee employee = Employee.builder()
                .employeeNo(generateEmployeeNo())
                .firstName(employeeRequest.getFirstName())
                .lastName(employeeRequest.getLastName())
                .workDept(employeeRequest.getWorkDept())
                .build();
        Employee savedEmployee = repository.save(employee);
        return modelMapper.map(savedEmployee,EmployeeRequest.class);
    }

    public String generateEmployeeNo(){
        return UUID.randomUUID().toString()
                .replace("-", "")
                .substring(0, 12);
    }

}
