package com.example.Customer.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.Customer.Entity.Customer;
import com.example.Customer.Request.CreditRequest;
import com.example.Customer.Request.DebitRequest;
@Service
public interface CustomerService {
	
	Customer save(Customer customer) ;
	
	Customer update(Customer id);
	
	List<Customer> getCustomers();
	
	String delete(Long id);
	
	String amount(Customer customer1);
	
	void credit(CreditRequest creditRequest);
	
	void debit(DebitRequest debitRequest);
	
	String balanceCheck(Long id);
	
	List<Customer> details(Long id);
	
//	Boolean isEmailExist(String email);
	
//	Boolean isUserAvailableByEmail(String email);
//	Optional<Customer> isEmailPresent(String email);
	
//	Boolean isUserAvailableByMobile(String Mobile);
	

}
