package com.yash.RestApiSQL.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.RestApiSQLentity.Employee;
import com.yash.RestApiSQLrepository.EmployeeRepo;


@Service
public class EmpService {

	@Autowired
	private EmployeeRepo emp;
	
	public List<Employee> searchAll(){
		List<Employee> empli=emp.findAll();
		return empli;
		
	}
	
	public Employee search( int empno) {
		
		return emp.findByEmpno(empno);
		
	}
	
	public Employee AddEmp(Employee empe) {
		return emp.save(empe);
	}
	
	
	public String Update(int empno,float salary) {
		Employee obj=emp.findByEmpno(empno);
		obj.setSalary(salary);
		emp.save(obj);
		return "done";
	}
	
	
	public String close(int empno) {
		Employee eob=emp.findByEmpno(empno);
		emp.delete(eob);
		return "done";
	}

}

