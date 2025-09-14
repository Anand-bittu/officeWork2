package com.anand.entity;

import com.anand.dto.EmployeeDto;
import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sno;
    private String sname;
    private Double salary;

    public Employee() {
    }

    public Employee(EmployeeDto employeeDto) {
        this.sname=employeeDto.getName();
        this.salary=employeeDto.getSalary();

    }

    public Integer getSno() {
        return sno;
    }

    public void setSno(Integer sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
