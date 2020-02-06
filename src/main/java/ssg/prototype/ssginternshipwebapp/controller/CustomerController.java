package ssg.prototype.ssginternshipwebapp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ssg.prototype.ssginternshipwebapp.domain.entity.Customer;
//import com.example.jpa.entity.Product;
import ssg.prototype.ssginternshipwebapp.domain.repository.CustomerRepository;

@Controller
@EnableAutoConfiguration
@RequestMapping
public class CustomerController {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@GetMapping("/")
	public String signIn() {
		return "/customer/signin";
	}
	
	@PostMapping("/")
	public @ResponseBody List<Customer> createCustomer(@RequestBody Map<String,String> param){
		String name = param.get("name");
		String password = param.get("password");
		Customer customer = Customer.builder().name(name).password(password).build();
		customerRepository.save(customer);
		
		return customerRepository.findAll();
	}

}