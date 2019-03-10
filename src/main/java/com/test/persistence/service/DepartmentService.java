package com.test.persistence.service;

import com.test.entity.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> getAll();
    Department findById(Long id);
    Department save(Department department);
    List<Department> saveAll(List<Department> departments);
    boolean delete(Department department);
}
