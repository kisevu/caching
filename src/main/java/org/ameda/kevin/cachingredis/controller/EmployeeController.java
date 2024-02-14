package org.ameda.kevin.cachingredis.controller;/*
*
@author ameda
@project caching-redis
@package org.ameda.kevin.cachingredis.controller
*
*/

import lombok.RequiredArgsConstructor;
import org.ameda.kevin.cachingredis.exceptions.EmployeeNotFoundException;
import org.ameda.kevin.cachingredis.payload.request.EmployeeRequest;
import org.ameda.kevin.cachingredis.payload.request.UpdateNames;
import org.ameda.kevin.cachingredis.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/employee/one")
    public ResponseEntity<?> getEmployeeByNo(@RequestParam("employeeNo") String employeeNo){
        try{
            return new ResponseEntity<>(employeeService.findByEmployeeNo(employeeNo),HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>("unexpected error!",HttpStatus.EXPECTATION_FAILED);
        }
    }
    @GetMapping
    public ResponseEntity<?> getAllEmployees(){
        try{
            return new ResponseEntity<>(employeeService.getAll(),HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>("",HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/employee/delete/{employeeNo}")
    public ResponseEntity<?> removeEmployee(@PathVariable("employeeNo") String employeeNo){
        try{
            employeeService.delete(employeeNo);
            return new ResponseEntity<>("successfully deleted.",HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>("not deleted",HttpStatus.NOT_ACCEPTABLE);
        }
    }
    @PatchMapping("/employee/update")
    public ResponseEntity<?> updateEmployee(@RequestParam("employeeNo") String employeeNo, @RequestBody UpdateNames updateNames){
        try{
            return new ResponseEntity<>(employeeService.update(employeeNo,updateNames),HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(new EmployeeNotFoundException("unexpected error!!!"),HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> createEmployee(@RequestBody EmployeeRequest employeeRequest){
        try{
            return new ResponseEntity<>(employeeService.createEmployee(employeeRequest),HttpStatus.CREATED);
        }catch (Exception ex){
            return new ResponseEntity<>("couldn't create an employee",HttpStatus.BAD_REQUEST);
        }
    }
}
