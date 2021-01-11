package com.example.accessingdatamongodb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
//@CrossOrigin(origins="http://localhost:4200")
public class CustomerController {
	
	@Autowired
	private CustomerRepository repository;
	
	@GetMapping(name="",path="/customer/getCustomer")
	public List<Customer> getCustomer() {
		
		List<Customer> custumer= repository.findAll();
		return custumer;
		
	}
	
	@PostMapping(path="/customer/addCustomer",consumes="application/json",produces="application/json")
	public void addCustomer(@RequestBody Customer customer) {
		
		repository.save(customer);
		
	}

}
