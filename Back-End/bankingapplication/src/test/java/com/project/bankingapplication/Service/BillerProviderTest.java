package com.project.bankingapplication.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.project.bankingapplication.entity.BillerProvider;
import com.project.bankingapplication.repo.ProviderRepository;
import com.project.bankingapplication.service.Implementation.ProviderService;

@SpringBootTest
public class BillerProviderTest {

	@Autowired
	ProviderService providerService;
	
	@MockBean
	ProviderRepository providerRepository;
	
	@Test
	public void createNewProviderTest() {
		BillerProvider bPro =new BillerProvider();
		bPro.setConsumerNumberFk(88383);
		bPro.setAccNumber(939309);
		bPro.setAmount(2000);
		
		when(providerRepository.save(bPro)).thenReturn(bPro);
		
		assertEquals(providerService.createNewProvider(bPro),0);
		//asserEqual(expedted value,,actual value) will check whther the service layer is passed or not .
	}
	
	
}
