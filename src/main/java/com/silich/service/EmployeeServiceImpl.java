package com.silich.service;

import com.silich.dao.EmployeeDAOImpl;
import com.silich.model.Employee;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();

    @Override
    public void create(Employee employee, int id) {
        employeeDAO.create(employee, id);
    }

    @Override
    public void update(Employee employee) {
        employeeDAO.update(employee);
    }

    @Override
    public void delete(int id) {
        employeeDAO.delete(id);
    }

    @Override
    public Employee findById(int id) {
        return employeeDAO.findById(id);
    }

    @Override
    public Employee findByEmail(String email) {
        return null;
    }

    @Override
    public List<Employee> findAll(int department_id) {
        return employeeDAO.findAll(department_id);
    }
}
