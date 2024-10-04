package com.project.bankingapplication.Biller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.project.bankingapplication.controller.RegistryController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BillerContextFile {

	@Autowired
	RegistryController registryController;

	@Test
	public void contextLoads() {
		Assertions.assertThat(registryController).isEqualTo(registryController);
	}
}
