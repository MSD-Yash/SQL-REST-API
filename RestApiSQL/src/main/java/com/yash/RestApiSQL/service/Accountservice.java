package com.yash.RestApiSQL.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.RestApiSQLentity.Account;
import com.yash.RestApiSQLrepository.Accountrepo;



@Service
public class Accountservice {

	@Autowired
	private Accountrepo acrp;
	
	public List<Account> search(){
		List<Account> aclist=acrp.findAll();
		return aclist;
		
	}
	
	
	public Account getInfo(int accno) {
		return acrp.findByAccno(accno);
	}
	
	public Account adAccount(Account ano) {
		return acrp.save(ano);
	}
	
	
	public String deposite(int accno,float balance) {
		
		Account obj=acrp.findByAccno(accno);
		obj.setBalance(obj.getBalance()+balance);
		acrp.save(obj);
		
		
		return "Done";
	}

}

