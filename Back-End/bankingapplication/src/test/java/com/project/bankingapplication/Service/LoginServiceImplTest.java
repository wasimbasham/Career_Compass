package com.project.bankingapplication.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.project.bankingapplication.entity.Login;
import com.project.bankingapplication.repo.LoginRepository;
import com.project.bankingapplication.service.Implementation.LoginServiceImpl;

@SpringBootTest
public class LoginServiceImplTest {

	@Autowired
	LoginServiceImpl loginServiceImpl;

	@MockBean
	LoginRepository loginRepository;

	@Test
	public void login() {
		Login login = new Login();
		login.setEmail("indhar@gmail.com");
		login.setName("indhar");
		login.setPassword("123456");

		when(loginRepository.findByEmailAndPassword("indhar@gmail.com", "123456")).thenReturn(login);

		assertEquals(login, loginServiceImpl.login("indhar@gmail.com", "123456"));

	}

}
