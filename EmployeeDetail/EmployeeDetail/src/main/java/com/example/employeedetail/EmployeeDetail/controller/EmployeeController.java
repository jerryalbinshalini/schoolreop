package com.example.employeedetail.EmployeeDetail.controller;

import com.example.employeedetail.EmployeeDetail.model.Employee;
import com.example.employeedetail.EmployeeDetail.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/employee")
public class EmployeeController {
    @Autowired
   public EmployeeService employeeService;
    @GetMapping(value = "/all")
    public @ResponseBody List<Employee> getAllEmployeeDetail(){

        return employeeService.getAllEmployeeDetail();
    }

    @PostMapping(value = "/create")
    public @ResponseBody String createEmployee(@RequestBody Employee employee){
        employeeService.insert(employee);
        return "employee created successfully";
    }


    @PutMapping(value = "/edit/{id}")
    public @ResponseBody String editEmployee(@PathVariable("id") Long id,@RequestBody Employee employee){
        return employeeService.update(employee,id);
    }
    @DeleteMapping(value = "delete/{id}")
    public @ResponseBody String delete(@PathVariable("id")Long id,@RequestBody Employee employee){
         return employeeService.delete(employee,id);
    }


}
