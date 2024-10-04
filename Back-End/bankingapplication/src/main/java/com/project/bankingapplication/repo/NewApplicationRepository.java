/**
 * Created the Transaction.
 *
 * @author Janarthanan C 
 */

package com.project.bankingapplication.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.project.bankingapplication.entity.NewApplication;

public interface NewApplicationRepository extends JpaRepository<NewApplication ,Long>{

	NewApplicationRepository save(NewApplicationRepository accountopen);





}
