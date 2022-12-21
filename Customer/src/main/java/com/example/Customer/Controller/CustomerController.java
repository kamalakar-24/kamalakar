package com.example.Customer.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Customer.Entity.Customer;
import com.example.Customer.Repository.CustomerRepository;
import com.example.Customer.Request.CreditRequest;
import com.example.Customer.Request.DebitRequest;
import com.example.Customer.Response.MessageResponse;
import com.example.Customer.Service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	CustomerRepository customerRepository;
	
	
	@PostMapping("/save")
	public ResponseEntity save (@RequestBody Customer customer) {
		Long amount=Long.parseLong(customer.getAmount());
		if(amount<500) {
			return ResponseEntity.badRequest().body(new MessageResponse("amount should be greater then 500"));
		}
//		if(customerService.isEmailExist(customer.getEmail())) {
//			return ResponseEntity.badRequest().body(new MessageResponse("Email is already exist"));
//		}
			customerService.save(customer);
		
		return ResponseEntity.ok().body(new MessageResponse("Submitted"));
		
		
	}
	
	
	@PutMapping("/update")
	public Customer update(@RequestBody Customer id) {
		Customer customer=null;
		customer= customerService.update(id);
		return customer;
//		return customerService.update(id);
	}
	
	@GetMapping("/getCustomers")
	public List<Customer> getAll(){
		List<Customer> list=null;
		list=customerService.getCustomers();
//		return customerService.getCustomers();
		return list;
		
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		return customerService.delete(id);
	}
	@PostMapping("/credit")
	public String credit(@RequestBody CreditRequest creditRequest) {
		customerService.credit(creditRequest);
		return "Credited Successfully";
	}
	@PostMapping("/debit")
	public String debit(@RequestBody DebitRequest debitRequest) {
		customerService.debit(debitRequest);
		return "Debited Successfully Successfully";
	}
	@GetMapping("/balance/{id}")
	public String balanceCheck(@PathVariable Long id) {
		return customerService.balanceCheck(id);
	}
}
