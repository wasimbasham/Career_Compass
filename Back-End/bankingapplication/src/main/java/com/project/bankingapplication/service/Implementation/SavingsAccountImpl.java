/**
 * Created the Transaction.
 *
 * @author Janarthanan C 
 */

package com.project.bankingapplication.service.Implementation;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.bankingapplication.repo.SavingsAccountRepository;
import com.project.bankingapplication.entity.SavingsAccount;
import com.project.bankingapplication.service.Interfaces.ISavingsAccountService;

@Service // to tell sc that this is a service class(business logic )
@Transactional
public class SavingsAccountImpl implements ISavingsAccountService {

	Logger logger = LoggerFactory.getLogger(SavingsAccountImpl.class);

	@Autowired
	private SavingsAccountRepository savingAccountRepo;

	@Override
	public Boolean addAccountDetails(SavingsAccount account) {
		logger.debug("Debug Occured");
		account = savingAccountRepo.save(account);
		System.out.println("account : " + account);
		if (account != null)
			return true;
		return null;
	}

	// for registration
	@Override
	public String addSA(SavingsAccount sa) {
		logger.debug("Debug Occured");

		Optional<SavingsAccount> optional = savingAccountRepo.findByAccountNumberAndBranchName(sa.getAccountNumber(),
				sa.getBranchName());
		System.out.println("optional data = " + optional);
		String str = null;

		if (optional.isPresent()) {
			System.out.println("inside optional.ispresent()");
			SavingsAccount s;
			s = optional.get();
			if (s.getIsNetBankingActive() == 0) {
//					System.out.println("inside s.getIsNetBankingActive()==0");
//					s.setIsNetBankingActive((byte) 1);
//					sar.save(s); 
//					//System.out.println(sar.save(s));
//					str="Registered";
			} else if (s.getIsNetBankingActive() == 1) {
				System.out.println("inside s.getIsNetBankingActive()==1");
				str = "Already registered";
			}
		} else {
			str = "Account Not found";
		}
		return str;
	}

	@Override
	public SavingsAccount getSavingsAccount(int accountNumber) {
		logger.debug("Debug Occured");
		return savingAccountRepo.findByAccountNumber(accountNumber);
	}

}
