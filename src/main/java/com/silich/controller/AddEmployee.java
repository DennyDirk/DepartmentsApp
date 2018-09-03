package com.silich.controller;

import com.silich.dao.EmployeeDAOImpl;
import com.silich.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class AddEmployee extends HttpServlet {
    private String department_id = null;
    private EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        department_id = req.getParameter("id");
        req.setAttribute("department_id", department_id);
        req.getRequestDispatcher("/WEB-INF/view/add_employee.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String first_name = req.getParameter("firstName");
        String last_name = req.getParameter("lastName");
        String email = req.getParameter("email");
        String age = req.getParameter("age");
        Date created = new Date();
        java.sql.Date sqlDate = new java.sql.Date(created.getTime());
        Employee employee = new Employee();
        employee.setEmail(email);
        employee.setFirstName(first_name);
        employee.setLastName(last_name);
        employee.setAge(Integer.parseInt(age));
        employee.setCreatedOn(sqlDate);

        employeeDAO.create(employee, Integer.parseInt(department_id));
        resp.sendRedirect("/employees?id=" + department_id);
    }
}
