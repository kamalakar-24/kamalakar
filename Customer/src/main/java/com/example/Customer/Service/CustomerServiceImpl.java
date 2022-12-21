package com.example.Customer.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Customer.Entity.Customer;
import com.example.Customer.Repository.CustomerRepository;
import com.example.Customer.Request.CreditRequest;
import com.example.Customer.Request.DebitRequest;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository repository;
	
	

	@Override
	public Customer save(Customer customer){
		String message="";
//		Integer amount=Integer.parseInt(customer.getAmount());
//		Optional<Customer> s=repository.findByEmail(customer.getEmail());
//		if(s.isPresent()) {
//			message="This email is already exist";
//		}
		return repository.save(customer);
	
		
	}
	public String amount(Customer customer1) {
		String message="";
		Integer amount=Integer.parseInt(customer1.getAmount());
		if(!(amount>=500)) {
			message="Amount should be more than 500";
		}

		return message;
		
	}
	@Override
	public Customer update(Customer id) {
		Optional<Customer> s = repository.findById(id.getId());
		if (s.isPresent()) {
			if (id.getId() == s.get().getId()) {
				return repository.save(id);
			}
		}
		return id;
	}

	@Override
	public List<Customer> getCustomers() {
		return repository.findAll();
	}

	@Override
	public String delete(Long id) {
		repository.deleteById(id);
		return "Your record deleted successfully" ;
	}
	
	public void credit(CreditRequest creditRequest) {
		Customer customer=repository.getById(creditRequest.getId());
		if(customer!=null) {
			customer.setCredit(creditRequest.getCredit());
			String amount=customer.getAmount();
			Long amount2=Long.parseLong(amount);
			Long totalAmount=amount2+creditRequest.getCredit();
			customer.setAmount(totalAmount.toString());
			repository.save(customer);
		}
		
	}
	
	public void debit(DebitRequest debitRequest) {
		Customer customer=repository.getById(debitRequest.getId());
		if(customer!=null) {
			customer.setDebit(debitRequest.getDebit());
			String amount=customer.getAmount();
			Long amount2=Long.parseLong(amount);
			Long totalAmount=amount2-debitRequest.getDebit();
			customer.setAmount(totalAmount.toString());
			repository.save(customer);
		}
	}
	
//	public Long balanceChenullck(Long id) {
//		Optional<Customer> customer=repository.findById(id);
//		if(customer.isPresent()) {
//			customer.get().getAmount();
//		}
//		return id ;
//		
//	}
	@Override
	public String balanceCheck(Long id) {
		
		Optional<Customer> optionalCustomer=repository.findById(id);
		String customer=optionalCustomer.get().getAmount();
//		String customer1=optionalCustomer.get().getEmail();
		return customer;
	}

}

