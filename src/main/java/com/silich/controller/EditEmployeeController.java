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
import java.util.List;

public class EditEmployeeController extends HttpServlet {
    private EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
    private Employee employee = new Employee();
    private String dep_id = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String error = req.getParameter("error");
        dep_id = req.getParameter("dep_id");
        employee = employeeService.findById(Integer.parseInt(id));
        req.setAttribute("employee", employee);
        req.setAttribute("dep_id", dep_id);
        req.setAttribute("wrongfields", error);

        req.getRequestDispatcher("/WEB-INF/view/edit_employee.jsp").forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String first_name = req.getParameter("firstName");
        String last_name = req.getParameter("lastName");
        String email = req.getParameter("email");
        String age = req.getParameter("age");

        employee.setFirstName(first_name);
        employee.setLastName(last_name);
        employee.setEmail(email);
        req.setAttribute("employee", employee);

        if (age.length() > 0) {
            employee.setAge(Integer.parseInt(age));
        }

        Validator validator = new Validator();
        List<ConstraintViolation> violations = validator.validate(employee);

        if (violations.size() > 0) {
            String error = "employee-error";
            req.setAttribute("error", error);
            resp.sendRedirect("/editEmployee?id="+dep_id+"&error="+error);
        }
        else {
            employeeService.update(employee);
            resp.sendRedirect("/employees?id=" + dep_id);
        }
    }
}
