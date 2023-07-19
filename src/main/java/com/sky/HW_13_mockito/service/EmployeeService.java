
package com.sky.HW_13_mockito.service;


import com.sky.HW_13_mockito.employee.Employee;


import java.util.Map;


public interface EmployeeService {

    String addEmployee(String fullName, Integer salary, String department);

    String removeEmployee(String fullName);

    String findEmployee(String fullName);
    Map<String, Employee> getEmployees();

//    Map<String, Employee> getEmployees(Map<String, Employee> employee_mock);
}
