/**
 * Created the Transaction.
 *
 * @author Janarthanan C 
 */

package com.project.bankingapplication.service.Interfaces;

import com.project.bankingapplication.entity.SavingsAccount;

public interface ISavingsAccountService {
	
	public Boolean addAccountDetails(SavingsAccount account);
	String addSA(SavingsAccount sa);
	SavingsAccount getSavingsAccount(int accountNumber);

}
