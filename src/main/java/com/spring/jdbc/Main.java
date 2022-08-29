package com.spring.jdbc;

import com.spring.jdbc.config.SpringJdbcConfig;
import com.spring.jdbc.dao.EmployeeDao;
import com.spring.jdbc.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("Spring-config.xml");
        EmployeeDao employeeDao=applicationContext.getBean(EmployeeDao.class);
        //long count=employeeDao.count();
        //System.out.println("Count of employees: "+ count);

//        Employee employee=employeeDao.getEmployeeById(1);
//        System.out.println(employee.getName()+" "+ employee.getSurname());

        System.out.println(employeeDao.getAllEmployees());

//        Employee e=new Employee();
//        e.setName("Ayan");
//        e.setSurname("Qasimova");
//        e.setAge(24);
//        e.setSalary(1200);
//        employeeDao.insert(e);


    }
}
