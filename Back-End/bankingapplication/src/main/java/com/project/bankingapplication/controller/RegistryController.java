/**
 * Created the Register.
 *
 * @author WASIM BASHA M 
 */

package com.project.bankingapplication.controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.FileHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.bankingapplication.entity.BillerProvider;
import com.project.bankingapplication.entity.BillerRegister;
import com.project.bankingapplication.entity.BillerStatement;
import com.project.bankingapplication.service.Implementation.ProviderService;
import com.project.bankingapplication.service.Implementation.RegisterService;
import com.project.bankingapplication.service.Implementation.StatementService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/registry")
public class RegistryController {

	Logger logger = LoggerFactory.getLogger(RegistryController.class);

	@Autowired
	ProviderService providerService;

	@Autowired
	RegisterService registerService;

	@Autowired
	StatementService statementService;

	// TO CREATE AN BILLER_REGISTER
	@PostMapping("/register")
	public ResponseEntity<String> createNewRegister(@RequestBody BillerRegister billerRegister) {
		String strCreateStatus = "Biller Registered Succesfully";
		logger.debug("Debug Occured");
		registerService.createNewRegistry(billerRegister);
		return ResponseEntity.status(HttpStatus.CREATED).body(strCreateStatus);

	}

	// TO FIND AN REGISTER BILLER BY ID
	@GetMapping("/register/{id}")
	public ResponseEntity<BillerRegister> readRegister(@PathVariable long id) {
		logger.debug("Debug Occured");
		logger.warn("warn");
		logger.info("info");
		
		BillerRegister billerRegister = registerService.findById(id);
		return ResponseEntity.ok(billerRegister);
	}

//	----------------------------------------------  //  
	// TO CREATE AN BILLER_PROVIDER
	@PostMapping("/provider")
	public ResponseEntity<String> createNewProvider(@RequestBody BillerProvider billerProvider) {
		String strCreateStatus = "Biller Provided Succesfully";
		logger.debug("Debug Occured");
		providerService.createNewProvider(billerProvider);
		return ResponseEntity.status(HttpStatus.CREATED).body(strCreateStatus);
	}

	// TO READ AN EXISTING PROVIDER BY ID
	@GetMapping("/provider/{id}")
	public ResponseEntity<BillerProvider> readProvider(@PathVariable long id) {
		logger.debug("Debug Occured");
		BillerProvider billerProvider = providerService.findBillerProviderById(id);
		return ResponseEntity.ok(billerProvider);
	}

	// -------------------------------------------------//
	// TO LIST ALL STATEMENTS
	@GetMapping("/statement")
	public ResponseEntity<List<BillerStatement>> listAllBillerStatement()

	{
		logger.debug("Debug Occured");
		List<BillerStatement> billerStatement = statementService.listAllBillerStatement();
		return ResponseEntity.ok(billerStatement);

	}

}
