package com.silich.controller;

import com.silich.model.Department;
import com.silich.service.DepartmentService;
import com.silich.service.DepartmentServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddDepartment extends HttpServlet {
    private DepartmentServiceImpl departmentService = new DepartmentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/view/add_department.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String departmentName = req.getParameter("name");
        Department department = new Department();
        department.setName(departmentName);
        departmentService.create(department);
        resp.sendRedirect("/");
    }

}
