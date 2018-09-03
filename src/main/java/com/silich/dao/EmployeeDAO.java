package com.silich.dao;


import com.silich.model.Employee;

import java.util.List;

public interface EmployeeDAO {

    void create(Employee employee, int department_id);

    void update(Employee employee);

    void delete(int id);

    Employee findById(int id);

    Employee findByEmail(String email);

    List<Employee> findAll(int department_id);
}
