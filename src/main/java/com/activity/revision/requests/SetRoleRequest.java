package com.activity.revision.requests;

import com.activity.revision.user.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SetRoleRequest {

	private String email;
	
	private Role role;
	
}
