package com.sky.HW_13_mockito.service;
import com.sky.HW_13_mockito.employee.Employee;

import java.util.List;
import java.util.Map;
public interface DepartmentService {
    List<Employee> getEmployeesByDepartment(String department);
    int sumSalaryByDepartment(String department);
    int maxSalaryByDepartment(String department);
    int minSalaryByDepartment(String department);
    Map<String, List<Employee>> getEmployeesByDepartments();
}
