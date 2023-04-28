package com.example.employeedetail.EmployeeDetail.service;

import com.example.employeedetail.EmployeeDetail.model.Employee;
import com.example.employeedetail.EmployeeDetail.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    public EmployeeRepository employeeRepository;
    public Employee insert(Employee employee){

        employeeRepository.save(employee);
        return employee;
    }
    public List<Employee> getAllEmployeeDetail() {
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList;
    }
    public String update(Employee employee,Long id){
        if(employeeRepository.findById(id).isPresent()) {
           Employee olddata = employeeRepository.findById(id).get();
            olddata.setName(employee.getName());
            olddata.setEmail(employee.getEmail());
            olddata.setDesignation(employee.getDesignation());
            olddata.setAddress(employee.getAddress());
            employeeRepository.save(olddata);
            return "Updated Successfully";
        }
        return "Updation Failed";
    }
    public String delete(Employee employee,Long id){
       employeeRepository.deleteById(id);
       return "Delete successfully";

    }
}
