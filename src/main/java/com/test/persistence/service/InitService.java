package com.test.persistence.service;

import com.test.entity.Department;
import com.test.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@Service
public class InitService {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;


    @PostConstruct
    public void init() {
        if(employeeService.count()==0){
            List<Department> departments = new ArrayList<>();
            for(int i=0; i<5;i++){
                departments.add(new Department().setName("dep"+i));
            }
            departmentService.saveAll(departments);
            List<Employee> employees = new ArrayList<>();
            for(int i=0; i<20;i++){
                employees.add(new Employee().setActive(true).setName("emp"+i).setDepartment(departments.get(i%5)));
            }
            employeeService.saveAll(employees);
        }
    }
}
