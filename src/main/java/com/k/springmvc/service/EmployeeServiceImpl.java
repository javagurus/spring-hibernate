package com.k.springmvc.service;

import com.k.springmvc.dao.EmployeeDao;
import com.k.springmvc.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeDao employeeDao;

    public Employee findById(int id) {
        return employeeDao.findById(id);
    }

    public void saveEmployee(Employee employee) {
        employeeDao.saveEmployee(employee);
    }

    /*
        * Since the method is running with Transaction, No need to call hibernate update explicitly.
        * Just fetch the entity from db and update it with proper values within transaction.
        * It will be updated in db once transaction ends.
        */
    public void updateEmployee(Employee employee) {
        Employee entity = employeeDao.findById(employee.getId());
        if (entity != null) {
            entity.setName(employee.getName());
            entity.setJoiningDate(employee.getJoiningDate());
            entity.setSalary(employee.getSalary());
            entity.setSsn(employee.getSsn());
        }
    }

    public void deleteEmployeeBySsn(String ssn) {
        employeeDao.deleteEmployeeBySsn(ssn);
    }

    public List<Employee> findAllEmployees() {
        return employeeDao.findAllEmployees();
    }

    public Employee findEmployeeBySsn(String ssn) {
        return employeeDao.findEmployeeBySsn(ssn);
    }

    public boolean isEmployeeSsnUnique(Integer id, String ssn) {
        Employee employee = findEmployeeBySsn(ssn);
        return (employee == null || ((id != null) && (employee.getId() == id)));
    }

}
