/**
 * Created the Login Form.
 *
 * @author Indhar P
 */

package com.project.bankingapplication.service.Interfaces;

import com.project.bankingapplication.entity.Login;

public interface ILoginService {
	Login login(String email, String password);
	Login getEmployee(int id);
}
