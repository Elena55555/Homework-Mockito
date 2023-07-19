package com.sky.HW_13_mockito.constants_final;

import com.sky.HW_13_mockito.employee.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConstantsClass {



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

    }



