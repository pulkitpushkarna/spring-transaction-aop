package com.spring.demo;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

public class EmployeeService2 {

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void insertEmployee(){
        String sql = "INSERT INTO Employee (name,age)VALUES(?,?)";
        jdbcTemplate.update(sql, new Object[]{"Peter2",29});
        throw new RuntimeException();
    }

    @Transactional(timeout = 3)
    public void insertEmployee2() throws InterruptedException {
        String sql = "INSERT INTO Employee (name,age)VALUES(?,?)";
        jdbcTemplate.update(sql, new Object[]{"Peter3",27});
        Thread.sleep(5000);

    }

    @Transactional(isolation = Isolation.READ_UNCOMMITTED,rollbackFor = RuntimeException.class)
    public void updateEmployee() throws InterruptedException {
        String sql = "Update Employee set name = ? where age = ?";
        jdbcTemplate.update(sql, new Object[]{"Peter",29});
        Thread.sleep(5000);
        throw new RuntimeException();
    }
}
