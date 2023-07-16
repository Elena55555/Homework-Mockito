
package com.sky.HW_13_mockito.service;

import com.sky.HW_13_mockito.employee.Employee;

import com.sky.HW_13_mockito.exceptions.WrongSymbolsException;

import com.sky.HW_13_mockito.repository.EmployeeRepository;

import org.apache.commons.lang3.StringUtils;

import org.springframework.stereotype.Service;

import java.util.List;

import java.util.Map;

@Service

public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeesRepository;

    public EmployeeServiceImpl(EmployeeRepository employeesRepository) {

        this.employeesRepository = employeesRepository;

    }

    @Override

    public String addEmployee(String fullName, Integer salary, String department) {

        validateNames(fullName);

        Employee employee = new Employee(fullName,  salary, department);

        return String.valueOf(employeesRepository.save(employee));

    }

    @Override

    public String removeEmployee(String fullName) {

        validateNames(fullName);

        return employeesRepository.removeByFullName(fullName).toString();

    }

    @Override

    public String findEmployee(String fullName) {

        validateNames(fullName );

        return employeesRepository.findByFullName(fullName).toString();

    }

    @Override

    public Map<String, List<Employee>> getEmployees () {

        return employeesRepository.findEmployeesGroupByDepartments();

    }

    private void validateNames(String fullName){

        if (! StringUtils.isAlpha(fullName))   {

            throw new WrongSymbolsException("Wrong symbols in names");
        }
    }
}
