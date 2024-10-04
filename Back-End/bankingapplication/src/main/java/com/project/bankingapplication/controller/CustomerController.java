/**
 * Created the registration form.
 *
 * @author Faraaz Ahmed Khan
 */

package com.project.bankingapplication.controller;

import java.util.List;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.bankingapplication.entity.Customer;
import com.project.bankingapplication.entity.RegistrationFormData;
import com.project.bankingapplication.entity.SavingsAccount;
import com.project.bankingapplication.entity.SavingsTransaction;
import com.project.bankingapplication.service.Implementation.EmailServiceImpl;
import com.project.bankingapplication.service.Interfaces.ICustomerService;
import com.project.bankingapplication.service.Interfaces.ISavingsAccountService;
import com.fasterxml.jackson.databind.node.ObjectNode;

@CrossOrigin
@RestController
@RequestMapping("/customer")
public class CustomerController {

	Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private ICustomerService customerService;

	@Autowired
	private ISavingsAccountService savingsAccountService;
	@Autowired
	private EmailServiceImpl email;

	public CustomerController() {
		System.out.println("inside ctor of CustomerController " + getClass().getName());
	}

	@GetMapping("/activate/{id}")
	public ResponseEntity<?> activate(@PathVariable int id) {
		logger.debug("Debug Occured");
		Customer c = customerService.activateAccount(id);
		System.out.println(c);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	// Login api
	@PostMapping(value = "/login", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> fetchDetails(@RequestBody Customer c) {
//		Customer cust = new Customer();
		System.out.println("in fetch customer email : " + c.getEmail() + "	password : " + c.getPassword());
		logger.debug("Debug Occured");
		if ((c = customerService.getCustomerDetails(c.getEmail(), c.getPassword())) != null) {
			return ResponseEntity.ok(c);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@PutMapping("/updateEmail/{customerId}")
	public String updateEmail(@PathVariable int customerId, @RequestBody ObjectNode json) {// String email
		logger.debug("Debug Occured");
		return customerService.updateEmail(customerId, json.get("email").asText());
	}

	@PutMapping("/updatePassword/{customerId}")
	public String updatePassword(@PathVariable int customerId, @RequestBody ObjectNode json) {
		logger.debug("Debug Occured");
		return customerService.updatePassword(customerId, json.get("password").asText());
	}

	@PutMapping("/updateMobileNumber/{customerId}")
	public String updateMobileNumber(@PathVariable int customerId, @RequestBody ObjectNode json) {
		logger.debug("Debug Occured");
		return customerService.updateMobileNumber(customerId, json.get("mobileNo").asText());
	}

	@PostMapping("/register")
	public ResponseEntity<?> insertData(@RequestBody RegistrationFormData reg) {
		Customer customer = new Customer(reg.getPassword(), reg.getEmail(), reg.getMobileNo());
		SavingsAccount sa = new SavingsAccount(reg.getAccountNumber(), reg.getBranchName(), reg.getIfscCode());
		logger.debug("Debug Occured");
		Customer c = customerService.findByEmail(reg.getEmail());
		int i = savingsAccountService.getSavingsAccount(reg.getAccountNumber()).getIsNetBankingActive();

		if (i == (byte) 1)
			return ResponseEntity.ok("Already registered");
		else {
			try {
				email.sendMail(c);
			} catch (MessagingException e) {

				e.printStackTrace();
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}

			if (customerService.addCustomer(customer)) {

				return ResponseEntity.ok("Registered Succesfully..!!");

			}
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/getProfile")
	public SavingsAccount getCustomerProfile(@RequestParam int id) {
		logger.debug("Debug Occured");
		SavingsAccount s1 = customerService.getCustomer(id).getSavingsAccount();
		return new SavingsAccount(s1.getAccountId(), s1.getAccountNumber(), s1.getAccountBalance(), s1.getCifNo(),
				s1.getBranchName(), s1.getIfscCode(), s1.getCustomer());
	}

	@GetMapping("/getTransaction/{customerId}")
	public List<SavingsTransaction> getTransactionByCustomerId(@PathVariable int customerId) {
		logger.debug("Debug Occured");
		return customerService.getCustomer(customerId).getSavingsAccount().getSavingsTransactionList();
	}

}