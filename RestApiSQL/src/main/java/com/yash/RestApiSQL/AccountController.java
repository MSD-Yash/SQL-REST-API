package com.yash.RestApiSQL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yash.RestApiSQL.service.Accountservice;
import com.yash.RestApiSQLentity.Account;


@RestController
@RequestMapping("/bank")
public class AccountController {

	@Autowired
	private Accountservice acs;
	
	@GetMapping("/acin")
	public List< Account> info() {
		return acs.search();
	}
	
	
	@GetMapping("/bank/acno/{accno}")
	public Account getinfo(@PathVariable int accno) {
		return acs.getInfo(accno);
	}
	
	@PostMapping("/bank/add/")
	public Account addAccount(@RequestBody Account ano ) {
		
		return acs.adAccount(ano);
	}
	
	
	@PutMapping("/bank/update")
	public String deposite(@RequestParam int accno,@RequestParam float balance) {
		String st=acs.deposite(accno, balance);
		return st;
	}

}

