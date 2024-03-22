package com.yash.RestApiSQLrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.RestApiSQLentity.Account;



@Repository
public interface Accountrepo extends JpaRepository<Account,Integer>{

	public Account findByAccno(int accno);

}

