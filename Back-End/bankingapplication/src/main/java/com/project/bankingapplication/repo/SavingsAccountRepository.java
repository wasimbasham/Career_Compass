/**
 * Created the Transaction.
 *
 * @author Janarthanan C 
 */

package com.project.bankingapplication.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.bankingapplication.entity.SavingsAccount;

public interface SavingsAccountRepository extends JpaRepository<SavingsAccount, Integer> {
	
	Optional<SavingsAccount> findByAccountNumberAndBranchName(int accountNumber,String branchName);
	SavingsAccount findByAccountNumber(int accountNumber);

}
