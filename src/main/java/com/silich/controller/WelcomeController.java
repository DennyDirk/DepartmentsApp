package com.silich.controller;

import com.silich.model.Department;
import com.silich.service.DepartmentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class WelcomeController extends HttpServlet {
    private DepartmentServiceImpl departmentService = new DepartmentServiceImpl();

    @Override
    public void init() throws ServletException {
        super.init();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Department> departmentList = departmentService.findAll();
        request.setAttribute("departmentList", departmentList);
        request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idEditElement = req.getParameter("edit");
        String idDeleteElement = req.getParameter("delete");
        if (idEditElement != null) {

            req.setAttribute("idEditElement", idEditElement);
            resp.sendRedirect("/editDepartment?id=" + idEditElement);
        } else if (idDeleteElement != null) {
            departmentService.delete(Integer.parseInt(idDeleteElement));
            resp.sendRedirect("/");
        }
    }
}
