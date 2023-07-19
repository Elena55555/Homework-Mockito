
package com.sky.HW_13_mockito.repository;

import com.sky.HW_13_mockito.employee.Employee;

import org.springframework.stereotype.Repository;

import java.util.HashMap;

import java.util.LinkedHashMap;
import java.util.List;

import java.util.Map;

import java.util.stream.Collectors;

import java.util.stream.Stream;

@Repository

public class EmployeeRepository {

    private Map<String, Employee> employees = new HashMap<>(Map.of(

            "Иванов",

            new Employee("Иванов", 95_000, "1"),

            "Петров Петр Петрович",

            new Employee("Петров Петр Петрович", 197_000, "1"),

            "Васильев Василий Васильев",

            new Employee("Васильев Василий Васильев", 165_000, "2"),

            "Александров Александр Александрович",

            new Employee("Александров Александр Александрович", 910_000, "2"),

            "Семенов Семен Семенович",

            new Employee("Семенов Семен Семенович", 167_000, "3"),

            "Сергеев Сергей Сергеевич",

            new Employee("Сергеев Сергей Сергеевич", 163_000, "3"),

            "Александровкин Александр Александрович",

            new Employee("Александровкин Александр Александрович", 199_000, "4"),

            "Владимиров Владимир Владимирович",

            new Employee("Владимиров Владимир Владимирович", 712_000, "4"),

            "Серпухов Сергей Сергеевич",

            new Employee("Серпухов Сергей Сергеевич", 176_000, "5"),

            "Данилов Данил Данилович",

            new Employee("Данилов Данил Данилович", 765_000, "5")

    ));
    public final static Map<String, Employee> employee_mock = new  HashMap<>(Map.of(

            "Иванов Иван Иванович",

            new Employee("Иванов Иван Иванович", 95_000, "1"),
            "Петров Петр Петрович" ,

            new Employee("Петров Петр Петрович", 197_000, "1" )
//                "Васильев Василий Васильев",
//                new Employee("Васильев Василий Васильев", 165_000, "2"),
//                "Александров Александр Александрович",
//                new Employee("Александров Александр Александрович", 910_000, "2"),
//                "Семенов Семен Семенович",
//                new Employee("Семенов Семен Семенович", 167_000, "3"),
//                "Сергеев Сергей Сергеевич",
//                new Employee("Сергеев Сергей Сергеевич", 163_000, "3"),
//                "Александровкин Александр Александрович",
//                new Employee("Александровкин Александр Александрович", 199_000, "4"),
//                "Владимиров Владимир Владимирович",
//                new Employee("Владимиров Владимир Владимирович", 712_000, "4"),
//                "Серпухов Сергей Сергеевич",
//                new Employee("Серпухов Сергей Сергеевич", 176_000, "5"),
//                "Данилов Данил Данилович",
//                new Employee("Данилов Данил Данилович", 765_000, "5")
    ));


    public Employee save(Employee employee) {

        if (employees.containsKey(employee.getFullName()))

            throw new RuntimeException("Employee already exists");

        employees.put(employee.getFullName(), employee);

        return employee;
    }

    public Employee removeByFullName(String fullName) {

        if (!employees.containsKey(fullName)) {

            throw new RuntimeException("Employee does not exist");

        }

        return employees.remove(fullName);

    }

    public Employee findByFullName(String fullName) {

        if (!employees.containsKey(fullName)) {

            throw new RuntimeException("This employee is not in database");

        }

        return employees.get(fullName);

    }

    public List<Employee> findEmployeesByDepartment(String department) {

        return buildDepartmentStream(department)

                .collect(Collectors.toList());

    }

    public int sumSalaryByDepartment(String department) {

        return buildDepartmentStream(department).mapToInt(Employee::getSalary).sum();

    }

    private Stream<Employee> buildDepartmentStream(String department){

        return employees.values().stream()

                .filter(employee -> employee.getDepartment().equals(department));

    }

    public int maxSalaryByDepartment(String department) {

        return buildDepartmentStream(department)

                .filter(e -> e.getDepartment().contains(department))

                .map(Employee::getSalary)

                .max(Integer::compare)

                .orElseThrow(() -> new RuntimeException("Employee with max salary is not found"));

    }

    public int minSalaryByDepartment(String department) {

        return buildDepartmentStream(department)

                .filter(e -> e.getDepartment().contains(department))

                .map(Employee::getSalary)

                .min(Integer::compare)

                .orElseThrow(() -> new RuntimeException("Employee with min salary is not found"));

    }

    public Map<String, List<Employee>> findEmployeesGroupByDepartments() {

        return employees.values().stream().collect(Collectors.groupingBy(Employee::getDepartment));

    }


//    public Map<String, Employee> getEmployees(Map<String, Employee> employee_mock) {
//        return employees;
//    }

//    private Map<String, Employee> employees2 = new LinkedHashMap<>(Map.of(
//            "Попова Варвара Богдановна",
//            new Employee("Попова Варвара Богдановна", 85_000, "5"),
//            "Петрова Елена Павловна",
//            new Employee("Петрова Елена Павловна", 87_000, "2"),
//            "Васильев Денис Андреевич",
//            new Employee("Васильев Денис Андреевич", 65_000, "1"),
//            "Лянге Александр Григорьевич",
//            new Employee("Лянге Александр Григорьевич", 90_000, "3"),
//            "Кузнецов Александр Семенович",
//            new Employee("Кузнцов Александр Семенович", 67_000, "4"),
//            "Скворцов Сергей Денисович",
//            new Employee("Скворцов Сергей Денисович", 63_000, "4"),
//            "Александров Михаил Богданович",
//            new Employee("Александров Михаил Богданович", 99_000, "2"),
//            "Карчемный Владимир Георгиевич",
//            new Employee("Карчемный Владимир Георгиевич", 72_000, "1"),
//            "Юницин Сергей Михайлович",
//            new Employee("Юницин Сергей Михайлович", 76_000, "5"),
//            "Рыбкин Данил Амвросиевич",
//            new Employee("Рыбкин Данил Амвросиевич", 75_000, "3")
//    ));

    public Map<String, Employee> getEmployees3() {
        return employees;
    }

    public Map<String, Employee> getEmployees2 () {
        return employees;
    }

    public Map<String, Employee> getEmployees() {
        return employees;
    }


}
