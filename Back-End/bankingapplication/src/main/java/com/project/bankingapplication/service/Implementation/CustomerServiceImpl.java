/**
 * Created the registration form.
 *
 * @author Faraaz Ahmed Khan
 */

package com.project.bankingapplication.service.Implementation;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.bankingapplication.repo.CustomerRepository;
import com.project.bankingapplication.entity.Customer;
import com.project.bankingapplication.service.Interfaces.ICustomerService;

//Customer Service Implementation 

@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {

	Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

	@Autowired
	private CustomerRepository customerRepo; // Dao layer interface injected

	// for register
	@Override
	public boolean addCustomer(Customer customer) {
		logger.debug("Debug Occured");
		Optional<Customer> optional = customerRepo.findByEmailAndMobileNo(customer.getEmail(), customer.getMobileNo());
		System.out.println("optional of cust is " + optional);
		if (!optional.isPresent()) {
			System.out.println("inside if(optional==null)");
			return false;
		} else {
			System.out.println("inside else of if(optional==null)");
			Customer c = optional.get();

			c.setPassword(customer.getPassword());
			if (customerRepo.save(c) != null)
				return true;

		}
		return false;
	}

	// list of customer
	@Override
	public List<Customer> getAllCustomers() {
		logger.debug("Debug Occured");
		return customerRepo.findAll();
	}

	@Override
	public void deleteCustomer(int id) {
		logger.debug("Debug Occured");
		customerRepo.deleteById(id);
	}

	@Override
	public Customer findByEmail(String email) {
		logger.debug("Debug Occured");
		Customer c = customerRepo.findByEmail(email).get();
		return c;
	}
	
	
	public Customer findCustomerByEmail(String email) {
		Customer customer = customerRepo.findCustomerByEmail(email);
		return customer;
	}

	@Override
	public Customer activateAccount(int id) {
		logger.debug("Debug Occured");
		Customer c = customerRepo.findById(id).get();
		c.getSavingsAccount().setIsNetBankingActive((byte) 1);
		return null;
	}

	// for login
	@Override
	public Customer getCustomerDetails(String email, String password) {
		logger.debug("Debug Occured");

		Optional<Customer> optional = customerRepo.customerAuthentication(email, password); // calling
																							// customerrepository's
																							// method
		// Optional<Customer> optional= customerRepo.findByEmail(email);
		if (optional.isPresent()) {
			System.out.println(optional.get());
			return optional.get();
		} else
			return null;
	}

	@Override
	public String updateEmail(int id, String email) {
		logger.debug("Debug Occured");
		Optional<Customer> optional = customerRepo.findById(id);
		if (optional.isPresent()) {
			Customer customer = optional.get();
			customer.setEmail(email);
			if (customerRepo.save(customer) != null)
				return "successfully updated email!!!";
		}
		return null;
	}

	@Override
	public String updatePassword(int id, String password) {
		logger.debug("Debug Occured");
		Optional<Customer> optional = customerRepo.findById(id);
		if (optional.isPresent()) {
			Customer customer = optional.get();
			customer.setPassword(password);
			if (customerRepo.save(customer) != null)
				return "successfully updated password!!!";
		}
		return null;
	}

	@Override
	public String updateMobileNumber(int id, String mobileNo) {
		logger.debug("Debug Occured");
		Optional<Customer> optional = customerRepo.findById(id);
		if (optional.isPresent()) {
			Customer customer = optional.get();
			customer.setMobileNo(mobileNo);
			if (customerRepo.save(customer) != null)
				return "successfully updated mobile number!!!";
		}
		return null;

	}

	@Override
	public Customer getCustomer(int id) {
		logger.debug("Debug Occured");
		System.out.println("inside CustomerService impl");
		Optional<Customer> optional = customerRepo.findById(id);
		if (optional.isPresent()) {
			System.out.println("Customer : " + optional.get());
			return optional.get();
		}
		return null;
	}

	@Override
	public Customer findById(int id) {
		logger.debug("Debug Occured");
		Customer c = customerRepo.findById(id).get();
		c.getSavingsAccount().setIsNetBankingActive((byte) 1);
		return null;
	}

}
