package org.ameda.kevin.cachingredis.config;
/*
*
@author ameda
@project caching-redis
@package org.ameda.kevin.cachingredis.config
*
*/

import jakarta.annotation.PostConstruct;
import org.ameda.kevin.cachingredis.entity.Employee;
import org.springframework.context.annotation.Configuration;
import java.util.ArrayList;
import java.util.List;


@Configuration
public class LoadData {

    @PostConstruct
    private void kickOffData()  {
         List<Employee> employees = new ArrayList<>();
         employees.add(new Employee(1,"1000","kevin","ameda","IT"));
         employees.add(new Employee(2,"1001","paul","gitau","kitchen"));
    }

}
