package com.activity.revision.controller;

import java.security.GeneralSecurityException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.activity.revision.requests.DeleteRequest;
import com.activity.revision.requests.SearchRequest;
import com.activity.revision.requests.SetRoleRequest;
import com.activity.revision.requests.SetSalaryRequest;
import com.activity.revision.requests.UserLoginRequest;
import com.activity.revision.requests.UserSignUpRequest;
import com.activity.revision.response.ResponseStatus;
import com.activity.revision.response.SystemError;
import com.activity.revision.service.UserService;
import com.activity.revision.user.UserDb;

@RestController
@RequestMapping("/user")
public class Controller {
	
	@Autowired UserService userService;
	
	@GetMapping("/hey")
	public String sayHello() {
		return "Hello!!";
	}
	
	@PostMapping("/signUp")
	@Cacheable(value = "test")
	@CachePut(value = "test", cacheNames = "test")
	public ResponseStatus signup(@RequestBody UserSignUpRequest userSignUpRequest) throws GeneralSecurityException{
		userService.signinUser(userSignUpRequest);
		return new ResponseStatus(SystemError.OK);
	}
	
	@PostMapping("/logIn")
	public ResponseStatus login(@RequestBody UserLoginRequest userLoginRequest) {
		ResponseStatus responseStatus;
		if(userService.loginUser(userLoginRequest)) responseStatus = new ResponseStatus(SystemError.OK);
		else responseStatus = new ResponseStatus(SystemError.BAD_REQUEST);
		return responseStatus;
	}
	
	@GetMapping("/addNewUsers")
	@Cacheable(value = "test")
	@CachePut(value = "test", cacheNames = "test")
	public ResponseStatus addNewUser() throws GeneralSecurityException{
		userService.addNewUser();
		return new ResponseStatus(SystemError.OK);
	}
	
	@GetMapping("/getAllEmployees")
	@Cacheable(value = "test")
	@CachePut(value = "test", cacheNames = "test")
	public List<UserDb> getAll(){
		return userService.getAll();
	}
	
	@GetMapping("/setAllNewUsers")
	@Cacheable(value = "test")
	@CachePut(value = "test", cacheNames = "test")
	public ResponseStatus setAllNewUsers() {
		userService.setAllEmployee();
		return new ResponseStatus(SystemError.OK); 
	}
	
	@PostMapping("/addNew")
	@Cacheable(value = "test")
	@CachePut(value = "test", cacheNames = "test")
	public ResponseStatus addNew(@RequestBody UserSignUpRequest userSignUpRequest, BindingResult bindingResult) throws GeneralSecurityException {
		ResponseStatus responseStatus;
		if(userService.addUser(userSignUpRequest, bindingResult)) responseStatus = new ResponseStatus(SystemError.OK);
		else{
			responseStatus = new ResponseStatus(SystemError.CUSTOM);
			bindingResult.getAllErrors().forEach(i-> responseStatus.setMessage(responseStatus.getMessage()+"<---"+i.getDefaultMessage()+"--->"));
		}
		return responseStatus;
	}
	
	@PostMapping("/deleteUser")
	@Cacheable(value = "test")
	@CachePut(value = "test", cacheNames = "test")
	public ResponseStatus deleteUser(@RequestBody DeleteRequest deleteRequest) {
		ResponseStatus responseStatus;
		if(userService.delete(deleteRequest)) responseStatus = new ResponseStatus(SystemError.OK);
		else responseStatus = new ResponseStatus(SystemError.BAD_REQUEST);
		return responseStatus;
	}
	
	@PostMapping("/setRole")
	@Cacheable(value = "test")
	@CachePut(value = "test", cacheNames = "test")
	public ResponseStatus setRole(@RequestBody SetRoleRequest setRoleRequest) {
		ResponseStatus responseStatus;
		if(userService.setRole(setRoleRequest)) responseStatus = new ResponseStatus(SystemError.OK);
		else responseStatus = new ResponseStatus(SystemError.BAD_REQUEST);
		return responseStatus;
	}
	
	@PostMapping("/setSalary")
	@Cacheable(value = "test")
	@CachePut(value = "test", cacheNames = "test")
	public ResponseStatus setSalary(@RequestBody SetSalaryRequest setSalaryRequest) {
		ResponseStatus responseStatus;
		if(userService.setSalary(setSalaryRequest)) responseStatus = new ResponseStatus(SystemError.OK);
		else responseStatus = new ResponseStatus(SystemError.BAD_REQUEST);
		return responseStatus;
	}
	
	@PostMapping("/search")
	public List<UserDb> search(@RequestBody SearchRequest searchRequest) {
		return userService.search(searchRequest);
	}
	
}
