package com.silich.service;

import com.silich.model.Employee;

import java.util.List;

public interface EmployeeService {

    void create(Employee employee);

    void update(Employee employee);

    void delete(int id);

    Employee findById(int id);

    Employee findByEmail(String email);

    List<Employee> findAll(int department_id);
}
