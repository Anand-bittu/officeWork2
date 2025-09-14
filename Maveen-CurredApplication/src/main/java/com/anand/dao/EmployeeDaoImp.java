package com.anand.dao;


import com.anand.dto.EmployeeDto;
import com.anand.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImp implements EmployeeDao {

    @PersistenceContext
    private EntityManager entityManager;



    public void saveEmployee(EmployeeDto employeeDto){
       //conver the EmployeeDTo to Employee
        Employee employee=new Employee(employeeDto);
        System.out.println("Inside Entity DAO");
        entityManager.persist(employee);
    }
}
