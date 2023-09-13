package com.cetpa.repositories.impl;

import java.util.List;

import org.hibernate.*;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cetpa.models.Employee;
import com.cetpa.repositories.EmployeeRespository;

@Repository
public class EmployeeRespositoryImpl implements EmployeeRespository 
{
	private Session session;
	private Transaction transaction;
	
	@Autowired
	public EmployeeRespositoryImpl(SessionFactory sessionFactory)
	{
		session=sessionFactory.openSession();
		transaction=session.getTransaction(); 
	}
	public List<Employee> getList() 
	{
		Query<Employee> query=session.createQuery("from Employee");
		return query.list();
	}
	public void saveEmployee(Employee employee) 
	{
		transaction.begin();
		session.save(employee);
		transaction.commit();
	}
	public Employee getEmployee(int eid) 
	{
		Employee employee=session.get(Employee.class,eid);
		return employee;
	}
	public void deleteEmployee(Employee employee) 
	{
		transaction.begin();
		session.delete(employee);
		transaction.commit();
	}
	public void updateEmployee(Employee empold, Employee empnew) 
	{
		transaction.begin();
		empold.setFirstname(empnew.getFirstname());
		empold.setLastname(empnew.getLastname());
		empold.setPhone(empnew.getPhone());
		empold.setEmail(empnew.getEmail());
		empold.setDepartment(empnew.getDepartment());
		empold.setSalary(empnew.getSalary());
		transaction.commit();
	}
}
