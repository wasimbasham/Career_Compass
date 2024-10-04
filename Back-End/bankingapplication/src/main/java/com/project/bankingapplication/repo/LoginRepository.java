/**
 * Created the Login Form.
 *
 * @author Indhar P
 */

package com.project.bankingapplication.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.bankingapplication.entity.Login;

public interface LoginRepository extends JpaRepository<Login, Integer> {
	Login findByEmailAndPassword(String email,String password);
}
