package com.k.springmvc.dao;


import com.k.springmvc.model.Employee;

import java.util.List;

public interface EmployeeDao {
    Employee findById(int id);

    void saveEmployee(Employee employee);

    void deleteEmployeeBySsn(String ssn);

    List<Employee> findAllEmployees();

    Employee findEmployeeBySsn(String ssn);
}
