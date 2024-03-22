package com.yash.RestApiSQLrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.RestApiSQLentity.Employee;



public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
	
	public Employee findByEmpno(int empno);

}
