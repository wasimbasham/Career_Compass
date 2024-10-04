package com.project.bankingapplication.Biller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.bankingapplication.entity.BillerProvider;
import com.project.bankingapplication.entity.BillerRegister;
import com.project.bankingapplication.repo.ProviderRepository;
import com.project.bankingapplication.repo.RegisterRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class BillerEntityTest {

	@Autowired
	RegisterRepository registerRepository;
	
	@Autowired
	ProviderRepository providerRepository;

	// Test for create Register Biller
	@Test 
	@Order(1)
	public void create() {
		BillerRegister bReg = new BillerRegister();
		bReg.setBillerName("Airtel");
		bReg.setConsumerNumber(923823);
		registerRepository.save(bReg);
	}

	//Test for find Register Biller
	@Test	
	@Order(2)
	public void read() {
		BillerRegister bReg = registerRepository.findById(1L).get();
		assertEquals("Jio", bReg.getBillerName());
	}
	
	//Test for create Biller Provider
	@Test 
	@Order(3)
	public void createProvider() {
		BillerProvider bPro = new BillerProvider();
		bPro.setConsumerNumberFk(923);
		bPro.setAccNumber(101);
		bPro.setAmount(5000);
		providerRepository.save(bPro);
		
		
	}

	//Test for find Provider Biller
	@Test	
	@Order(4)
	public void readProvider() {
		BillerProvider bReg = providerRepository.findById(1L).get();
		assertEquals(102, bReg.getAccNumber());
	}

}
