package com.test.persistence.service.impl;

import com.test.entity.Employee;
import com.test.persistence.repository.EmployeeRepository;
import com.test.persistence.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public long count() {
        return employeeRepository.count();
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Page<Employee> getAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.getOne(id);
    }

    @Override
    public Employee findByName(String name) {
        return employeeRepository.findByName(name);
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> saveAll(List<Employee> employees) {
        return employeeRepository.saveAll(employees);
    }

    @Override
    public boolean delete(Employee employee) {
        try {
            employeeRepository.delete(employee);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    @Override
    public boolean deleteById(Long id) {
        try {
            employeeRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public List<Employee> findByNameStartingWith(String s) {
        return employeeRepository.findByNameStartingWith(s);
    }

    @Override
    public List<Employee> findByNameStartingWith(String s, Pageable pageable) {
        return employeeRepository.findByNameStartingWith(s,pageable);

    }

    @Override
    public long countByNameStartingWith(String s) {
        return  employeeRepository.countByNameStartingWith(s);
    }
}
