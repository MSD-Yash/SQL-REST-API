package com.yash.RestApiSQL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.yash.RestApiSQL.service.EmpService;
import com.yash.RestApiSQLentity.Employee;


public class EmployeeController {

	@Autowired
	private EmpService ems;
	
	@GetMapping("/empall")
	public List< Employee> search() {
		return ems.searchAll();
	}
	
	@GetMapping("/empsearch/{empno}")
	public Employee find(@PathVariable int empno) {
		return ems.search(empno);
	}
	
	@PostMapping("/empadd")
	public Employee adEmployee(@RequestBody Employee empad) {
		return ems.AddEmp(empad);
	}

	
	@PutMapping("/update")
	public String increment(@RequestParam int empno,@RequestParam float salary) {
		String st=ems.Update(empno, salary);
		return st;
		
	}
	
	@DeleteMapping("/dlt")
	public String dlt(@RequestParam  int empno) {
		String st=ems.close(empno);
		return st;
		
	}
	
}

