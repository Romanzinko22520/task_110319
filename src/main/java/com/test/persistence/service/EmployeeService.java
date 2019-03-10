package com.test.persistence.service;

import com.test.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {
    long count();
    List<Employee> getAll();
    Page<Employee> getAll(Pageable pageable);
    Employee findById(Long id);
    Employee findByName(String name);
    Employee save(Employee employee);
    List<Employee> saveAll(List<Employee> employees);
    boolean delete(Employee employee);
    boolean deleteById(Long id);
    List<Employee> findByNameStartingWith(String s, Pageable pageable);
    List<Employee> findByNameStartingWith(String s);
    long countByNameStartingWith(String s);

}
