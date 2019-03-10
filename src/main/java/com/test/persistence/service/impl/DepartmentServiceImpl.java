package com.test.persistence.service.impl;

import com.test.entity.Department;
import com.test.persistence.repository.DepartmentRepository;
import com.test.persistence.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department findById(Long id) {
        return departmentRepository.getOne(id);
    }

    @Override
    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> saveAll(List<Department> departments) {
        return departmentRepository.saveAll(departments);
    }

    @Override
    public boolean delete(Department department) {
        try{
            departmentRepository.delete(department);
            return true;
        }catch (Exception e){
            return  false;
        }
    }
}
