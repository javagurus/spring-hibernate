package com.k.springmvc.dao;


import com.k.springmvc.model.Employee;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("employeeDao")
public class EmployeeDaoImpl extends AbstractDao<Integer, Employee> implements EmployeeDao {


    public Employee findById(int id) {
        return getByKey(id);
    }

    public void saveEmployee(Employee employee) {
        persist(employee);
    }

    public void deleteEmployeeBySsn(String ssn) {
        Query query = getSession().createSQLQuery("delete from Employee where ssn = :ssn");
        query.setString("ssn", ssn);
        query.executeUpdate();
    }


    @Override
    public List<Employee> findAllEmployees() {
        Criteria entityCriteria = createEntityCriteria();
        List employeeList = entityCriteria.list();
        return employeeList;

    }

    @Override
    public Employee findEmployeeBySsn(String ssn) {
        Criteria entityCriteria = createEntityCriteria();
        entityCriteria.add(Restrictions.eq("ssn", ssn));
        return (Employee) entityCriteria.uniqueResult();
    }
}
