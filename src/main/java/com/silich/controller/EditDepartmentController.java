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

public class EditDepartmentController extends HttpServlet {
    private DepartmentServiceImpl departmentService = new DepartmentServiceImpl();
    private Department department = null;
    private String departmentId = "";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        departmentId = req.getParameter("id");
        String error = req.getParameter("error");
        req.setAttribute("wrongName", error);
        department = departmentService.findById(Integer.parseInt(departmentId));
        req.setAttribute("departmentName", department.getName());
        req.getRequestDispatcher("/WEB-INF/view/edit_department.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        department.setName(name);
        Validator validator = new Validator();
        List<ConstraintViolation> violations = validator.validate(department);

        if (violations.size() > 0) {
            String error = "Wrong name";
            req.setAttribute("error", error);
            resp.sendRedirect("/editDepartment?id=" + departmentId + "&error=" + error);
        } else {
            departmentService.update(department);
            resp.sendRedirect("/");
        }
    }
}
