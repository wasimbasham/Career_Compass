package com.project.bankingapplication.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.bankingapplication.entity.BillerProvider;

@Repository
public interface ProviderRepository extends JpaRepository<BillerProvider, Long> {

	BillerProvider findBillerProviderById(long id);

	
}
