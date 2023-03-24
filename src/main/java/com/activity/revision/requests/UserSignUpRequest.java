package com.activity.revision.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSignUpRequest {

	private String userName;
	
	private String email;
	
	private String password;
	
	private String contactNumber;
	
}
