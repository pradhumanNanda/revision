package com.activity.revision.service;

import java.security.GeneralSecurityException;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import com.activity.revision.criteriaBuilder.QueryBuilder;
import com.activity.revision.dataGenerator.DataGenerator;
import com.activity.revision.repo.UserRepo;
import com.activity.revision.requests.DeleteRequest;
import com.activity.revision.requests.SearchRequest;
import com.activity.revision.requests.SetRoleRequest;
import com.activity.revision.requests.SetSalaryRequest;
import com.activity.revision.requests.UserLoginRequest;
import com.activity.revision.requests.UserSignUpRequest;
import com.activity.revision.user.Role;
import com.activity.revision.user.UserDb;
import com.activity.revision.utils.AccessControl;
import com.activity.revision.utils.Constants;
import com.activity.revision.utils.PasswordEncDecUtil;
import com.activity.revision.utils.UserValidator;

@Service
public class UserServiceImpl implements UserService{

	@Autowired UserRepo userRepo;
	
	@Autowired AuthenticationManager authenticationManager;
	
	@Autowired DataGenerator dataGenerator;
	
	@Autowired AccessControl accessControl;
	
	@Autowired UserValidator userValidator;
	
	@Autowired QueryBuilder queryBuilder;
	
	@Override
	public void signinUser(UserSignUpRequest userSignUpRequest) throws GeneralSecurityException {
		
		UserDb newUserDb = UserDb.builder().
				userName(userSignUpRequest.getUserName()).
				email(userSignUpRequest.getEmail()).
				password(PasswordEncDecUtil.encrypt(userSignUpRequest.getPassword())).
				contactNumber(userSignUpRequest.getContactNumber()).role(Role.NEWUSER).build();
		
		userRepo.save(newUserDb);
	}

	@Override
	public boolean loginUser(UserLoginRequest userLoginRequest) {
		
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = 
				new UsernamePasswordAuthenticationToken(userLoginRequest, null);
		
		Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
		
		if(authentication != null && authentication.isAuthenticated()) return true;
		
		return false;
	}

	@Override
	public boolean setRole(SetRoleRequest setRoleRequest) {
		
		if(accessControl.checkSuperAccess()) {
			
			UserDb user = userRepo.findUserByEmail(setRoleRequest.getEmail());
			
			if(user.getIsDeleted()) return false;
			
			user.setRole(setRoleRequest.getRole());
			
			userRepo.save(user);
			
			return true;
		}
		
		return false;
		
	}

	@Override
	public void setAllEmployee() {
		
		if(accessControl.checkSuperAccess()) {
			
			userRepo.findAll().forEach(curNewUser->{
				
				if(curNewUser.getRole().name().equals("NEWUSER")) {
					
					if(!curNewUser.getIsDeleted()) {
						
						curNewUser.setRole(Role.EMPLOYEE);
						
						userRepo.save(curNewUser);
						
					}
				}
			});
			
		}
	}

	@Override
	public boolean addNewUser() throws GeneralSecurityException{
		
		if(accessControl.checkSuperAccess()) {
			
			for(int i=0;i<10;i++) userRepo.save(dataGenerator.generateCustomer());
			
			return true;		
		}
	
		return false;
		
	}

	@Override
	public List<UserDb> getAll() {
		
		if(accessControl.checkAccess()) {
			
			return  userRepo.findAll().stream()
		            .filter(curUserDb -> !curUserDb.getIsDeleted())
		            .collect(Collectors.toList());
			
		}
		
		return null;
	}

	@Override
	public boolean delete(DeleteRequest deleteRequest) {
		
		if(accessControl.checkSuperAccess()) {
			
			UserDb curUserDb = userRepo.findUserByEmail(deleteRequest.getEmail());
			
			curUserDb.setIsDeleted(true);
			
			userRepo.save(curUserDb);
			
			return true;	
		}
		
		return false;
	}


	@Override
	public boolean addUser(UserSignUpRequest userSignUpRequest, BindingResult bindingResult) throws GeneralSecurityException {
		
		if(accessControl.checkSuperAccess()) {
			
			userValidator.validate(userSignUpRequest, bindingResult);
			
			if(bindingResult.hasErrors()) return false;
			
			userRepo.save(UserDb.builder().
								userName(userSignUpRequest.getUserName()).
								email(userSignUpRequest.getEmail()).
								password(PasswordEncDecUtil.encrypt(userSignUpRequest.getPassword())).
								contactNumber(userSignUpRequest.getContactNumber()).
								isDeleted(false).
								role(Role.EMPLOYEE).
								salary(Constants.DEFAULTSALARY).
								build());
			
			return true;
		}
		return false;
	}

	@Override
	public List<UserDb> search(SearchRequest searchRequest) {
		return queryBuilder.searchUser(searchRequest);
	}

	@Override
	public boolean setSalary(SetSalaryRequest salaryRequest) {
		if(accessControl.checkAccess()) {
			
			UserDb curUserDb = userRepo.findUserByEmail(salaryRequest.getEmail());
			
			curUserDb.setSalary(salaryRequest.getNewSalary());
			
			userRepo.save(curUserDb);
			
			return true;
		}
		
		return false;
	}

}
