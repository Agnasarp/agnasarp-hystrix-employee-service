package com.agnasarp.employeeservice.controller;

import com.agnasarp.employeeservice.domain.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class EmployeeServiceController {

    private static Map<String, List<Employee>> agnasarpDB = new HashMap<String, List<Employee>>();

    static {
        agnasarpDB = new HashMap<String, List<Employee>>();

        List<Employee> lst = new ArrayList<Employee>();
        Employee std = new Employee("Max", "Male");
        lst.add(std);
        std = new Employee("Lisa", "Female");
        lst.add(std);

        agnasarpDB.put("it-department", lst);

        lst = new ArrayList<Employee>();
        std = new Employee("Steve", "Male");
        lst.add(std);
        std = new Employee("Anne", "Female");
        lst.add(std);

        agnasarpDB.put("finance-department", lst);

    }

    @GetMapping(value = "/getEmployeeDetailsForDepartment/{department}")
    public List<Employee> getEmployees(@PathVariable String department) {
        System.out.println("Getting Employee details for " + department);

        List<Employee> employeeList = agnasarpDB.get(department);
        if (employeeList == null) {
            employeeList = new ArrayList<Employee>();
            Employee std = new Employee("Not Found", "N/A");
            employeeList.add(std);
        }
        return employeeList;
    }
}
