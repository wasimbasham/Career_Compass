package com.project.bankingapplication.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.project.bankingapplication.entity.Customer;
import com.project.bankingapplication.entity.SavingsAccount;
import com.project.bankingapplication.repo.SavingsAccountRepository;
import com.project.bankingapplication.service.Implementation.SavingsAccountImpl;

@SpringBootTest
public class SavingsAccServiceTest {

	@Autowired
	SavingsAccountImpl savingsAccountImpl;

	@MockBean
	SavingsAccountRepository savingsAccountRepository;

	@Test
	public void addAccountDetailsTest() {
		SavingsAccount sAcc = new SavingsAccount();
		sAcc.setAccountBalance(10000D);
		sAcc.setAccountId(23);
		sAcc.setAccountNumber(834843);
		sAcc.setBranchName("chennai");
		sAcc.setCifNo(88383838L);
		sAcc.setIfscCode(8348349L);
		Customer cust = new Customer();
		cust.setCustomerId(2);
		cust.setEmail("faraaz@gmail.com");
		cust.setFirstName("faraaz");
		cust.setLastName("khan");
		cust.setMobileNo("8348343");
		cust.setPassword("82382");
		sAcc.setCustomer(cust);

		when(savingsAccountRepository.save(sAcc)).thenReturn(sAcc);

		assertEquals(true, savingsAccountImpl.addAccountDetails(sAcc));

	}

}
