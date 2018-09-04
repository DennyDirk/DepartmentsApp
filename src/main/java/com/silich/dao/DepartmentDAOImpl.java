package com.silich.dao;

import com.silich.model.Department;
import com.silich.util.JDBCUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class DepartmentDAOImpl implements DepartmentDAO {

    private ResultSet resultSet;
    private Statement statement;

    @Override
    public void create(Department department) {
        String name = department.getName();
        try {
            statement = JDBCUtil.getStatement();
            statement.executeUpdate("INSERT INTO departments.departments(id, name) VALUES (NULL, '" + name + "')");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Department department) {
        int id = department.getId();
        String name = department.getName();
        try {
            statement = JDBCUtil.getStatement();
            statement.executeUpdate("UPDATE departments.departments SET name = '" + name + "' WHERE id = '" + id + "'");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        statement = JDBCUtil.getStatement();
        try {
            statement.executeUpdate("DELETE FROM departments.departments WHERE id = '" + id + "'");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Department findById(int id) {
        Department department = new Department();
        try {
            statement = JDBCUtil.getStatement();
            resultSet = statement.executeQuery("SELECT * FROM departments.departments WHERE id = '" + id + "'");
            while (resultSet.next()) {
                int dept_id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                department.setId(dept_id);
                department.setName(name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return department;
    }

    @Override
    public Department findByName(String name) {
        return null;
    }

    @Override
    public List<Department> findAll() {
        List departmentsList = new LinkedList();
        statement = JDBCUtil.getStatement();
        try {
            resultSet = statement.executeQuery("SELECT * FROM departments.departments");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Department department = new Department();
                department.setId(id);
                department.setName(name);
                departmentsList.add(department);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departmentsList;
    }
}


