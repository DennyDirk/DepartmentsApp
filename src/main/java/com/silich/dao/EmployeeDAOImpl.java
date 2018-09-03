package com.silich.dao;

import com.silich.model.Employee;
import com.silich.util.JDBCUtil;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    private ResultSet resultSet;
    private Statement statement;
    @Override
    public void create(Employee employee, int department_id) {
        statement = JDBCUtil.getStatement();
        try {
            String emp_email = employee.getEmail();
            String emp_f_name = employee.getFirstName();
            String emp_l_name = employee.getLastName();
            Date emp_date = employee.getCreatedOn();
            int emp_age = employee.getAge();
            statement.executeUpdate("INSERT INTO employees (email, first_name, last_name, age, created_on, department_id) VALUES ('"+emp_email+"', '"+emp_f_name+"', '"+emp_l_name+"', '"+emp_age+"', '"+emp_date+"', '"+department_id+"');");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(Employee employee) {
        int id = employee.getId();
        String email = employee.getEmail();
        String first_name = employee.getFirstName();
        String lastName = employee.getLastName();
        int age = employee.getAge();
        try {
            statement = JDBCUtil.getStatement();
            statement.executeUpdate("UPDATE departments.employees SET email = '" + email + "', first_name = '" + first_name + "'" +
                    ", last_name = '" + lastName + "', age = '" + age + "' WHERE id = '" + id + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(int id) {
        statement = JDBCUtil.getStatement();
        try {
            statement.executeUpdate("DELETE FROM departments.employees WHERE id = '" + id + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Employee findById(int id) {
        Employee employee = new Employee();
        try {
            statement = JDBCUtil.getStatement();
            resultSet = statement.executeQuery("SELECT * FROM departments.employees WHERE id = '" + id + "'");
            while (resultSet.next()) {
                int emp_id = resultSet.getInt("id");
                String email = resultSet.getString("email");
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                int age = resultSet.getInt("age");
                Date created_on = resultSet.getDate("created_on");

                employee.setId(emp_id);
                employee.setEmail(email);
                employee.setFirstName(first_name);
                employee.setLastName(last_name);
                employee.setAge(age);
                employee.setCreatedOn(created_on);
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
        return employee;
    }

    @Override
    public Employee findByEmail(String email) {
        return null;
    }

    @Override
    public List<Employee> findAll(int department_id) {
        List<Employee> employees = new LinkedList<>();
        statement = JDBCUtil.getStatement();
        try {
            resultSet = statement.executeQuery("SELECT * FROM employees AS emp JOIN departments ON emp.department_id = departments.id WHERE emp.department_id ='"+ department_id +"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while (resultSet.next()){
                int emp_id = resultSet.getInt("emp.id");
                String email = resultSet.getString("email");
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                int age = resultSet.getInt("age");
                Date created_on = resultSet.getDate("created_on");
                Employee employee = new Employee();
                employee.setId(emp_id);
                employee.setEmail(email);
                employee.setFirstName(first_name);
                employee.setLastName(last_name);
                employee.setAge(age);
                employee.setCreatedOn(created_on);
                employees.add(employee);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                resultSet.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return employees;
    }
}
