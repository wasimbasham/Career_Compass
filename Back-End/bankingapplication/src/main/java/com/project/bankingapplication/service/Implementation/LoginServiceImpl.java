/**
 * Created the Login Form.
 *
 * @author Indhar P
 */

package com.project.bankingapplication.service.Implementation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.bankingapplication.repo.LoginRepository;
import com.project.bankingapplication.entity.Login;
import com.project.bankingapplication.service.Interfaces.ILoginService;

@Service
@Transactional
public class LoginServiceImpl implements ILoginService {
	
	Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
	
	@Autowired
	private LoginRepository empRepo;
	
	@Override
	public Login login(String email, String password) {
		logger.debug("Debug Occured");
		Login employee= empRepo.findByEmailAndPassword(email, password);   // calling customerrepository's method
		if(employee != null)
			return employee;
		else
			return null;
	}

	@Override
	public Login getEmployee(int id) {
		logger.debug("Debug Occured");
		return empRepo.findById(id).get();
	}
	
	
}
	
