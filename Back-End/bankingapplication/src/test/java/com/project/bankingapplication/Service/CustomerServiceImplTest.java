package com.project.bankingapplication.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.project.bankingapplication.entity.Customer;
import com.project.bankingapplication.repo.CustomerRepository;
import com.project.bankingapplication.service.Implementation.CustomerServiceImpl;

@SpringBootTest
public class CustomerServiceImplTest {

	@Autowired
	CustomerServiceImpl customerServiceImpl;

	@MockBean
	CustomerRepository customerRepository;

	@Test
	public void getAllCustomersTest() {

		Customer cust = new Customer();		
		
		cust.setEmail("Faraaz@gmail.com");

//		when(customerRepository.findByEmail("Faraaz@gmail.com").get()).thenReturn(cust);
		when(customerRepository.findCustomerByEmail("Faraaz@gmail.com")).thenReturn(cust);

		assertEquals(cust,customerServiceImpl.findCustomerByEmail("Faraaz@gmail.com"));
//		assertEquals(cust,customerServiceImpl.findByEmail("Faraaz@gmail.com"));

	}

}
