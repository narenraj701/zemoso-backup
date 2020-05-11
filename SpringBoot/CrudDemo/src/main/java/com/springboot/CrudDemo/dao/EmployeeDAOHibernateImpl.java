package com.springboot.CrudDemo.dao;

import com.springboot.CrudDemo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> findAll() {
        Session session=entityManager.unwrap(Session.class);
        Query<Employee> employeeQuery=
                session.createQuery("from Employee",Employee.class);
        List<Employee> employeeList=employeeQuery.getResultList();

        return  employeeList;
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(employee);
    }

    @Override
    public Employee getCustomer(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Employee employee=currentSession.get(Employee.class,theId);
        return employee;
    }

    @Override
    public void deleteEmployee(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query theQuery =
                currentSession.createQuery("delete from Employee where id=:EmployeeId");
        theQuery.setParameter("EmployeeId", theId);

        theQuery.executeUpdate();
    }
}
