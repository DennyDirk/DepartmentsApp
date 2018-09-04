package com.silich.controller;

import com.silich.model.Employee;
import com.silich.service.EmployeeServiceImpl;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class AddEmployeeController extends HttpServlet {
    private String department_id = null;
    private EmployeeServiceImpl employeeService = new EmployeeServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        department_id = req.getParameter("id");
        String error = req.getParameter("error");
        req.setAttribute("wrongEmployee", error);
        req.setAttribute("department_id", department_id);
        req.getRequestDispatcher("/WEB-INF/view/add_employee.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Validator validator = new Validator();
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
        if (age.length() > 0) {
            employee.setAge(Integer.parseInt(age));
        }
        employee.setCreatedOn(sqlDate);

        List<ConstraintViolation> violations = validator.validate(employee);
        if (violations.size() > 0) {
            String error = "employee-error";
            req.setAttribute("error", error);
            req.setAttribute("val-employee", employee);
            resp.sendRedirect("/addEmployee?id=" + department_id + "&error=" + error);
        } else {
            employeeService.create(employee, Integer.parseInt(department_id));
            resp.sendRedirect("/employees?id=" + department_id);
        }

    }
}
