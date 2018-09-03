package com.silich.controller;

import com.silich.model.Department;
import com.silich.service.DepartmentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditDepartment extends HttpServlet {
    private DepartmentServiceImpl departmentService = new DepartmentServiceImpl();
    private Department department = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        department = departmentService.findById(Integer.parseInt(id));
        req.setAttribute("departmentName", department.getName());
        req.getRequestDispatcher("/WEB-INF/view/edit_department.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        department.setName(name);
        departmentService.update(department);
        resp.sendRedirect("/");
    }
}
