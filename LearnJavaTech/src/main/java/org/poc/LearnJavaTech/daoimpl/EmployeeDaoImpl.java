package org.poc.LearnJavaTech.daoimpl;

import java.util.List;

import org.poc.LearnJavaTech.controller.EmployeeDAO;
import org.poc.LearnJavaTech.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
@Repository("employeeDao")
@Transactional
public class EmployeeDaoImpl implements EmployeeDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<Employee> getEmployeeList() {
		// TODO Auto-generated method stub
		return sessionFactory.openSession().createQuery("from Employee").list();
	}


}
