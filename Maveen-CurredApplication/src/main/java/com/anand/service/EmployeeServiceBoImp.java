package com.anand.service;

import com.anand.dao.EmployeeDao;
import com.anand.dto.EmployeeDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceBoImp implements EmployeeServiceBo {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    @Transactional
    public void saveEmployeeBo(EmployeeDto employeeDto) {
        System.out.println("inside Save EmployeeBo");
        employeeDao.saveEmployee(employeeDto);
    }
}
