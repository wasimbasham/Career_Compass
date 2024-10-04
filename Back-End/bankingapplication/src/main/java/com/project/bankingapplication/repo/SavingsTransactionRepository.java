/**
 * Created the Transaction.
 *
 * @author Janarthanan C 
 */

package com.project.bankingapplication.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.bankingapplication.entity.SavingsTransaction;

public interface SavingsTransactionRepository extends JpaRepository<SavingsTransaction, Integer> {

}
