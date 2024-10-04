package com.project.bankingapplication.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.bankingapplication.entity.BillerRegister;

@Repository
public interface RegisterRepository extends JpaRepository<BillerRegister, Long>
{

	BillerRegister findBillerRegisterById(long id);

}
