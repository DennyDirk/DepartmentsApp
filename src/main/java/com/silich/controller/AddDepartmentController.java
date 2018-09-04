package com.silich.controller;

import com.silich.model.Department;
import com.silich.service.DepartmentServiceImpl;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AddDepartmentController extends HttpServlet {
    private DepartmentServiceImpl departmentService = new DepartmentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String error = request.getParameter("error");
        request.setAttribute("wrongName", error);
        request.getRequestDispatcher("/WEB-INF/view/add_department.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String departmentName = req.getParameter("name");
        Validator validator = new Validator();
        Department department = new Department();
        department.setName(departmentName);
        List<ConstraintViolation> violations = validator.validate(department);

        if (violations.size() > 0) {
            String error = "Wrong name";
            req.setAttribute("error", error);
            resp.sendRedirect("/addDepartment?error=" + error);
        } else {
            departmentService.create(department);
            resp.sendRedirect("/");
        }
    }

}
