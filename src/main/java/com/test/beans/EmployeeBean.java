package com.test.beans;

import com.test.entity.Employee;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class EmployeeBean {
    private String name;
    private Long id;
    private String department;
    private boolean active;

    public EmployeeBean() {
    }

    public EmployeeBean(Employee employee){
        this.setName(employee.getName()).setId(employee.getId()).setDepartment(employee.getDepartment().getName())
                .setActive(employee.isActive());
    }
}
