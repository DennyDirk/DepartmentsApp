package com.silich.dao;

import com.silich.model.Department;

import java.util.List;

public interface DepartmentDAO {

    void create(Department department);

    void update(Department department);

    void delete(int id);

    Department findById(int id);

    Department findByName(String name);

    List<Department> findAll();


}
