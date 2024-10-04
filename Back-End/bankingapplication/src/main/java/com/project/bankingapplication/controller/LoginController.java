/**
 * Created the Login Form.
 *
 * @author Indhar P
 */

package com.project.bankingapplication.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.bankingapplication.entity.Customer;
import com.project.bankingapplication.entity.Login;
import com.project.bankingapplication.entity.SavingsAccount;
import com.project.bankingapplication.entity.SavingsTransaction;
import com.project.bankingapplication.service.Interfaces.ICustomerService;
import com.project.bankingapplication.service.Interfaces.ILoginService;
import com.project.bankingapplication.service.Interfaces.ISavingsAccountService;
import com.project.bankingapplication.service.Interfaces.ITransactionService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Employee")
public class LoginController {

	Logger logger = LoggerFactory.getLogger(LoginController.class);

	public LoginController() {
		System.out.println("inside ctor of  " + getClass().getName());
	}

	@Autowired
	private ILoginService employeeService;

	@Autowired
	private ICustomerService customerService;

	@Autowired
	private ISavingsAccountService savingsAccountService;

	@Autowired
	private ITransactionService transactionService;

	// admin login
	@PostMapping("/login")
	public ResponseEntity<?> fetchDetails(@RequestBody Login e) {
		logger.debug("Debug Occured");
		if ((e = employeeService.login(e.getEmail(), e.getPassword())) != null) {
			System.out.println("in admin login " + e);
			return ResponseEntity.ok(e);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/adminProfile")
	public ResponseEntity<?> adminProfile(@RequestParam int id) {
		logger.debug("Debug Occured");
		Login emp = employeeService.getEmployee(id);
		if (emp != null) {
			return ResponseEntity.ok(emp);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// list of customers
	@GetMapping("/customerList")
	public List<Customer> fetchAllCustomers() {
		logger.debug("Debug Occured");
		System.out.println("in fetch all customer ");
		return customerService.getAllCustomers();
	}

	// delete customer
	@DeleteMapping("/deleteCustomer/{customerId}")
	public void deleteCustomer(@PathVariable int customerId) {
		logger.debug("Debug Occured");
		customerService.deleteCustomer(customerId);
	}

	// add account
	@PostMapping("/addAccount")
	public ResponseEntity<?> addAccountDetails(@RequestBody SavingsAccount account) {
		logger.debug("Debug Occured");
		System.out.println("customer data : " + account);
		savingsAccountService.addAccountDetails(account);
		return ResponseEntity.ok("Successfully Added..!");
	}

	// List of Transactions
	@GetMapping("/listOfTransactions")
	public List<SavingsTransaction> fetchAllTransactions() {
		logger.debug("Debug Occured");
		System.out.println("inside CustomerController::fetch all Transactions");
		return transactionService.getAllTransactions();
	}
}