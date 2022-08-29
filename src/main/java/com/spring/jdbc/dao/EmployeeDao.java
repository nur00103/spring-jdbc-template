package com.spring.jdbc.dao;

import com.spring.jdbc.model.Employee;

import java.util.List;

public interface EmployeeDao {

    void insert(Employee employee);

    void update(Employee employee);

    void delete(int id);

    Employee getEmployeeById(int id);

    List<Employee> getAllEmployees();

    long count();
}
