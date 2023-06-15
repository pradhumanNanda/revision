package com.activity.revision.controller;

import java.security.GeneralSecurityException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.activity.revision.dataGenerator.DataGenerator;
import com.activity.revision.requests.ChatRequest;
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
import com.activity.revision.utils.ChatBot;
import com.activity.revision.utils.HelperMethods;
import com.aerospike.client.AerospikeClient;
import com.aerospike.client.Bin;
import com.aerospike.client.Key;

@RestController
@RequestMapping("/user")
@SuppressWarnings("unused")
public class Controller {
	
	private UserService userService;
    
	private DataGenerator dataGenerator;
	
	private ChatBot chatBot;
	
	public Controller(UserService userService, DataGenerator dataGenerator, ChatBot chatBot) {
		super();
		this.userService = userService;
		this.dataGenerator = dataGenerator;
		this.chatBot = chatBot;
	}
	
	@PostMapping("/signUp")
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
	public ResponseStatus addNewUser() throws GeneralSecurityException{
		userService.addNewUser();
		return new ResponseStatus(SystemError.OK);
	}
	
	@GetMapping("/cacheData")
	public ResponseStatus saveData() {
		userService.saveData();
		return new ResponseStatus(SystemError.OK);
	}
	
	@GetMapping("/getAllEmployees")
	public List<UserDb> getAll(){
		return userService.getAll();
	}
	
	@GetMapping("/setAllNewUsers")
	public ResponseStatus setAllNewUsers() {
		userService.setAllEmployee();
		return new ResponseStatus(SystemError.OK); 
	}
	
	@GetMapping("/getById/{id}")
	public UserDb getById(@PathVariable Long id) {
		return userService.getById(id);
	}
	
	@PostMapping("/addNew")
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
	public ResponseStatus deleteUser(@RequestBody DeleteRequest deleteRequest) {
		ResponseStatus responseStatus;
		if(userService.delete(deleteRequest)) responseStatus = new ResponseStatus(SystemError.OK);
		else responseStatus = new ResponseStatus(SystemError.BAD_REQUEST);
		return responseStatus;
	}
	
	@PostMapping("/setRole")
	public ResponseStatus setRole(@RequestBody SetRoleRequest setRoleRequest) {
		ResponseStatus responseStatus;
		if(userService.setRole(setRoleRequest)) responseStatus = new ResponseStatus(SystemError.OK);
		else responseStatus = new ResponseStatus(SystemError.BAD_REQUEST);
		return responseStatus;
	}
	
	@PostMapping("/setSalary")
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
	
	@GetMapping("/data")
	public ResponseStatus xml() throws Exception {
		ResponseStatus responseStatus = new ResponseStatus(SystemError.OK);
		responseStatus.setResponse(userService.xml());
		return responseStatus;
	}
	
	@GetMapping("/test2")
	public ResponseStatus test() throws Exception {
		ResponseStatus responseStatus = new ResponseStatus(SystemError.OK);
		responseStatus.setResponse(HelperMethods.helper());
		return responseStatus;
	}
	
	@PostMapping("/chat1")
	public ResponseStatus chat1(@RequestBody ChatRequest chatRequest) throws Exception {
		ResponseStatus responseStatus = new ResponseStatus(SystemError.OK);
		responseStatus.setResponse(chatBot.chat1(chatRequest));
		return responseStatus;
	}
	
	@PostMapping("/chat2")
	public ResponseStatus chat2(@RequestBody ChatRequest chatRequest) throws Exception {
		ResponseStatus responseStatus = new ResponseStatus(SystemError.OK);
		responseStatus.setResponse(chatBot.chat2(chatRequest));
		return responseStatus;
	}
	
	@PostMapping("/chat3")
	public ResponseStatus chat3(@RequestBody ChatRequest chatRequest) throws Exception {
		ResponseStatus responseStatus = new ResponseStatus(SystemError.OK);
		responseStatus.setResponse(chatBot.chat3(chatRequest));
		return responseStatus;
	}
	
	@GetMapping("/checkMethod")
	public ResponseStatus checkMethod() throws Exception {
		ResponseStatus responseStatus = new ResponseStatus(SystemError.OK);
		responseStatus.setResponse(chatBot.getAnswer());
		return responseStatus;
	}
}
