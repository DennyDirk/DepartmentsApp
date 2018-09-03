package com.silich.service;

import com.silich.dao.DepartmentDAOImpl;
import com.silich.model.Department;
import com.silich.util.JDBCUtil;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentDAOImpl departmentDAO = new DepartmentDAOImpl();

    @Override
    public void create(Department department) {
        departmentDAO.create(department);
    }

    @Override
    public void update(Department department) {
        departmentDAO.update(department);
    }

    @Override
    public void delete(int id) {
        departmentDAO.delete(id);
    }

    @Override
    public Department findById(int id) {
        return departmentDAO.findById(id);
    }

    @Override
    public Department findByName(String name) {
        return null;
    }

    @Override
    public List<Department> findAll() {
        return departmentDAO.findAll();
    }
}
