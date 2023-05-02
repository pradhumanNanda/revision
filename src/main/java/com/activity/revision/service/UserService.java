package com.activity.revision.service;

import java.security.GeneralSecurityException;
import java.util.List;
import org.springframework.validation.BindingResult;
import com.activity.revision.requests.DeleteRequest;
import com.activity.revision.requests.SearchRequest;
import com.activity.revision.requests.SetRoleRequest;
import com.activity.revision.requests.SetSalaryRequest;
import com.activity.revision.requests.UserLoginRequest;
import com.activity.revision.requests.UserSignUpRequest;
import com.activity.revision.user.UserDb;

public interface UserService {

	void signinUser(UserSignUpRequest userSignUpRequest) throws GeneralSecurityException;
	
	boolean loginUser(UserLoginRequest userLoginRequest);
	
	boolean setRole(SetRoleRequest setRoleRequest);
	
	void setAllEmployee();
	
	boolean addUser(UserSignUpRequest userSignUpRequest, BindingResult bindingResult) throws GeneralSecurityException;
	
	void addNewUser() throws GeneralSecurityException;
	
	List<UserDb> getAll();
	
	boolean delete(DeleteRequest deleteRequest);
	
	List<UserDb> search(SearchRequest searchRequest);
	
	boolean setSalary(SetSalaryRequest salaryRequest);
	
	UserDb getById(Long id);
	
	void saveData();
	
}
