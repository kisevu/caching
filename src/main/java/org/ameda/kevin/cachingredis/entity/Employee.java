package org.ameda.kevin.cachingredis.entity;/*
*
@author ameda
@project caching-redis
@package org.ameda.kevin.cachingredis.entity
*
*/

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
@Builder
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;
    @Column(name="employee_no")
    private String employeeNo;
    private String firstName;
    private String lastName;
    private String workDept;

}
