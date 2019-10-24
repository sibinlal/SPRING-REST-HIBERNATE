package com.luv2code.springdemo.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.restException.CustomerNotFoundException;
import com.luv2code.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customers")
	public List<Customer> getCustomers(){
		return customerService.getCustomers();
	}
	
	@GetMapping("/customers/{customerID}")
	public Customer getSpecificCustomer(@PathVariable int customerID) {
		Customer theCustomer = customerService.getCustomer(customerID);
		if(null == theCustomer) {
			throw new CustomerNotFoundException("CustomerNotFound: "+ customerID);
		}
		return theCustomer;
	}
	
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer theCustomer) {
		theCustomer.setId(0);
		customerService.saveCustomer(theCustomer);
		return theCustomer;
	}
	
	@PutMapping("/customers")
	public String  updateCustomer(@RequestBody Customer theCustomer) {
		int customerID = theCustomer.getId();
		theCustomer = customerService.getCustomer(customerID);
		if (theCustomer == null) {
			throw new CustomerNotFoundException("Customer Not found:" + customerID);
		}
		customerService.saveCustomer(theCustomer);		
		return "Update Success:"+customerID;
	}
	
	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable int customerID) {
		Customer theCustomer = customerService.getCustomer(customerID);
		if(theCustomer == null) {
			throw new CustomerNotFoundException("Customer Not Found: "+customerID);
		}
		customerService.deleteCustomer(customerID);
		return "Deleted Customer: "+customerID;
	}
	
	

}
