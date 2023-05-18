package com.activity.revision.utils;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.activity.revision.requests.UserSignUpRequest;

@Service
public class UserValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return UserSignUpRequest.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		UserSignUpRequest userSignUpRequest = (UserSignUpRequest)target;
		
		if(!supports(UserSignUpRequest.class)) return;
		
		if (!HelperUtil.isEmailValid(userSignUpRequest.getEmail())) {
            errors.reject("email", "Enter Valid Email!");
        }
        if (!HelperUtil.isMobileValid(userSignUpRequest.getContactNumber())) {
            errors.reject("contactNumber","Enter Valid ContactNumber!");
        }
        if (userSignUpRequest.getPassword().length() < 6) {
            errors.reject("password","Password length less than 6!");
        }
        if (userSignUpRequest.getUserName().length() < 4) {
        	errors.reject("username","Username length less than 6!");
        }
	}

}
