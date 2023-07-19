
package com.sky.HW_13_mockito.service;

import com.sky.HW_13_mockito.constants_final.ConstantsClass;
import com.sky.HW_13_mockito.employee.Employee;

import com.sky.HW_13_mockito.repository.EmployeeRepository;


import org.springframework.stereotype.Service;

import com.sky.HW_13_mockito.exceptions.DepartmentIsBlankException;

import com.sky.HW_13_mockito.exceptions.NoDepartmentException;

import java.util.List;

import java.util.Map;

@Service

public abstract class DepartmentServiceImpl implements DepartmentService {

    private EmployeeRepository repository;

    public DepartmentServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    private void throwExceptions(String department){

        if (department.isBlank()){

            throw new DepartmentIsBlankException("Department is blank");

        }

    }
//    public List<Employee> getEmployeesByDepartment2(String department){
//
//        throwExceptions(department);
//
//        return repository.getEmployees().values().stream()
//                .filter(e -> e.getDepartment().contains(department))
//                .collect(Collectors.toList());
//    }

    @Override

    public List<Employee> getEmployeesByDepartment(String department) {

        throwExceptions(department);

        List<Employee> employeesByDepartment = repository.findEmployeesByDepartment(department);

        if (employeesByDepartment.isEmpty())

            throw new     NoDepartmentException("No department");

        return employeesByDepartment;

    }

    @Override

    public int sumSalaryByDepartment(String department) {

        throwExceptions(department);

        return repository.sumSalaryByDepartment(department);
//        return sumSalaryByDepartment(department);

    }

    @Override

    public int maxSalaryByDepartment(String department) {

        throwExceptions(department);

        return repository.maxSalaryByDepartment(department);

    }

    @Override

    public int minSalaryByDepartment(String department) {

        throwExceptions(department);

        return repository.minSalaryByDepartment(department);

    }

    @Override

    public Map<String, List<Employee>> getEmployeesByDepartments() {

            return repository.findEmployeesGroupByDepartments();

    }
//    Map<String,  List<Employee>> employees = new HashMap<>();

    @Override
    public Map<String, Employee> getEmployees(Map<String, Employee> employee_mock) {
        return ConstantsClass.employee_mock;
    }


//    @Override
//    public Map<Integer, List<Employee>> getEmployees3() {
//        return employee_mock ;

    }







