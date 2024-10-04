/**
 * Created the Transaction.
 *
 * @author Janarthanan C 
 */

package com.project.bankingapplication.service.Interfaces;

import java.util.List;

import com.project.bankingapplication.entity.SavingsTransaction;

public interface ITransactionService {
	String betweenAccountsTransfer(int senderAccountNo, int receiverAccountNo, Double amount);
	List<SavingsTransaction> getAllTransactions();

}
