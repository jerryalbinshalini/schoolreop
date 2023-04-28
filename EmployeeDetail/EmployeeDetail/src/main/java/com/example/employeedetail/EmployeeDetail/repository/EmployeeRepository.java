package com.example.employeedetail.EmployeeDetail.repository;

import com.example.employeedetail.EmployeeDetail.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
