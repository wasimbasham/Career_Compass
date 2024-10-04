package com.project.bankingapplication.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.project.bankingapplication.entity.BillerStatement;

@Repository
public interface StatementRepository extends JpaRepository<BillerStatement, Long> {
	
}
