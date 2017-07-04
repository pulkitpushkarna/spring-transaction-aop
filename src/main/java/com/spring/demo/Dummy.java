package com.spring.demo;

import com.spring.component.MyClass1;
import com.spring.component.MyClass2;
import com.spring.component.MyClass3;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Dummy {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("transactional-spring-config.xml");
        EmployeeService employeeService=applicationContext.getBean(EmployeeService.class);
        employeeService.insertEmployee();
        System.out.println("Done");
    }
}
