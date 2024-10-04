/**
 * Created the Transaction.
 *
 * @author Janarthanan C 
 */

package com.project.bankingapplication.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.bankingapplication.dto.TransactionDTO;
import com.project.bankingapplication.service.Interfaces.ITransactionService;

@RestController
@RequestMapping("/transaction")
@CrossOrigin(origins = "*")
public class TransactionController {

	Logger logger = LoggerFactory.getLogger(TransactionController.class);

	@Autowired
	private ITransactionService its;

	public TransactionController() {
		System.out.println("in ctor " + getClass().getName());
	}

	@PostMapping
	public String fundsTransfer(@RequestBody TransactionDTO transactionDTO) {
		logger.debug("Debug Occured");
		System.out.println("transactionDTO : " + transactionDTO);
		return its.betweenAccountsTransfer(transactionDTO.getSenderAccountNo(), transactionDTO.getReciverAccountNo(),
				transactionDTO.getAmount());
	}

}
