package com.spring.jdbc.dao.impl;

import com.spring.jdbc.dao.EmployeeDao;
import com.spring.jdbc.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insert(Employee e) {
    String sql="insert into employee(name,surname,age,salary) values(?,?,?,?)";
    jdbcTemplate.update(sql,e.getName(),e.getSurname(),e.getAge(),e.getSalary());
    }

    @Override
    public void update(Employee e) {
    String sql="update employee set name=?,surname=?,age=?,salary=? where id=?";
    jdbcTemplate.update(sql,e.getName(),e.getSurname(),e.getAge(),e.getSalary(),e.getId());
    }

    @Override
    public void delete(int id) {
    String sql="delete from employee where id=?";
    jdbcTemplate.update(sql,id);
    }

    @Override
    public Employee getEmployeeById(int id) {
        String sql="select * from employee where id=?";
        Employee employee=jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Employee.class),id);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        String sql="select * from employee";
        List<Employee> employeeList=jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Employee.class));
        return employeeList;
    }

    @Override
    public long count() {
        String sql="select count(*) from employee";
        return jdbcTemplate.queryForObject(sql,Long.class);
    }
}
