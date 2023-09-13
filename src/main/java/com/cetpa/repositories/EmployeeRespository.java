package com.cetpa.repositories;

import java.util.List;

import com.cetpa.models.Employee;

public interface EmployeeRespository 
{
	List<Employee> getList();
	void saveEmployee(Employee employee);
	Employee getEmployee(int eid);
	void deleteEmployee(Employee employee);
	void updateEmployee(Employee empold, Employee empnew);
}
