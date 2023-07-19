
package com.sky.HW_13_mockito.controller;

import com.sky.HW_13_mockito.service.EmployeeServiceImpl;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping(path = "/department")

public class EmployeeController {


    private final EmployeeServiceImpl employeeService; /* приватное поле EmployeeServiceImpl employeeService */

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }
    /* такая констукция НЕ позволяет создавать EmployeeController-объект без фактического разрешения EmployeeServiceImpl зависимости.*/

    @GetMapping(path = "/add")

    public String addEmployee(@RequestParam ("fullName") String fullName,

                              @RequestParam ("salary") Integer salary,

                              @RequestParam ("department") String department){

        return employeeService.addEmployee(fullName,  salary, department);

    }

    @GetMapping(path = "/remove")

    public String removeEmployee(@RequestParam ("fullName") String fullName){

        return employeeService.removeEmployee(fullName);

    }

    @GetMapping(path = "/find")

    public String findEmployee(@RequestParam ("fullName") String fullName){

        return employeeService.findEmployee(fullName);

    }
}
