package com.silich.controller;

import com.silich.model.Department;
import com.silich.model.Employee;
import com.silich.service.DepartmentService;
import com.silich.service.DepartmentServiceImpl;
import com.silich.service.EmployeeService;
import com.silich.service.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class EmployeesList extends HttpServlet {
    private DepartmentServiceImpl departmentService = new DepartmentServiceImpl();
    private EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
    private String department_id = null;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        department_id = req.getParameter("id");
        Department department = departmentService.findById(Integer.parseInt(department_id));
        req.setAttribute("departmentName", department.getName());
        List<Employee> employeesList = employeeService.findAll(Integer.parseInt(department_id));
        req.setAttribute("employeesList", employeesList);
        req.setAttribute("department_id", department_id);
        req.getRequestDispatcher("/WEB-INF/view/employees_list.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idEditElement = req.getParameter("edit");
        String idDeleteElement = req.getParameter("delete");
        if (idEditElement !=null){

            req.setAttribute("idEditElement", idEditElement);
            resp.sendRedirect("/editEmployee?id=" + idEditElement + "&dep_id=" + department_id);
        }
        else if (idDeleteElement != null){
            employeeService.delete(Integer.parseInt(idDeleteElement));
            resp.sendRedirect("/employees?id="+department_id);
        }
    }
}
