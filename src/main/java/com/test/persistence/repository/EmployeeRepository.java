package com.test.persistence.repository;

import com.test.entity.Employee;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByName(String name);
    List<Employee> findByNameStartingWith(String s);
    List<Employee> findByNameStartingWith(String s, Pageable pageable);

    long countByNameStartingWith(String s);
}
