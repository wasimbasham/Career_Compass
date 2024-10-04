/**
 * Created the Transaction.
 *
 * @author Janarthanan C 
 */

package com.project.bankingapplication.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.bankingapplication.repo.NewApplicationRepository;
import com.project.bankingapplication.entity.NewApplication;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/newapplication")
public class NewApplicationController {

	Logger logger = LoggerFactory.getLogger(NewApplicationController.class);

	@Autowired
	private NewApplicationRepository newApplicationRepository;

	@GetMapping("/allaccounts")
	public List<NewApplication> getAllRequest() {
		logger.debug("Debug Occured");
		return newApplicationRepository.findAll();
	}

	// build create Rest api
	@PostMapping("/create")
	public NewApplication createAccount(@RequestBody NewApplication accountopen) {
		logger.debug("Debug Occured");
		return newApplicationRepository.save(accountopen);
	}
}
