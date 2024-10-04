package com.project.bankingapplication.Service;




import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.project.bankingapplication.entity.BillerRegister;
import com.project.bankingapplication.repo.RegisterRepository;
import com.project.bankingapplication.service.Implementation.RegisterService;

@SpringBootTest
public class BillerRegisterTest {

	@Autowired
	RegisterService registerService;

	@MockBean
	RegisterRepository registerRepository;

	@Test
	public void createNewRegistryTest() {
		BillerRegister bReg = new BillerRegister();
		bReg.setId(1L);
		bReg.setBillerName("Airtel");
		bReg.setConsumerNumber(328239L);

		when(registerRepository.save(bReg)).thenReturn(bReg);
		assertEquals(bReg.getId(), registerService.createNewRegistry(bReg));
		 
	}
}
