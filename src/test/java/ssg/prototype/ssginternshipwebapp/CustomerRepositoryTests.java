package ssg.prototype.ssginternshipwebapp;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ssg.prototype.ssginternshipwebapp.domain.entity.Customer;
import ssg.prototype.ssginternshipwebapp.domain.repository.CustomerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRepositoryTests {

	@Autowired
	CustomerRepository customerRepository;
	
	@After
	public void deleteAll() {
		customerRepository.deleteAll();
	}
	
	@Test
	public void testCustomerRepository(){
		Customer customer = Customer.builder().name("크리스").password("test").build();
		customerRepository.save(customer);
		
		List<Customer> customerList = customerRepository.findByName("크리스");
		
		Customer chris = customerList.get(0);
		assertThat(chris.getName(), is("크리스"));
		assertThat(chris.getPassword(), is("test"));
	}
}