package com.activity.revision.utils;

import java.util.Arrays;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.activity.revision.user.UserDb;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Service
@AllArgsConstructor
@NoArgsConstructor
public class AccessControl {
	
	private SecurityContext securityContext = null;
	
	private UserDb userDb= null;

	public boolean checkSuperAccess() {
		
		securityContext = SecurityContextHolder.getContext();
		
		if(securityContext != null) {
			
			userDb = (UserDb)securityContext.getAuthentication().getPrincipal();
			
			if(userDb.getRole().name().equals("SUPERADMIN")) return true; 
			
		}
		return false;
	}
	
	public boolean checkAccess() {
		
		securityContext = SecurityContextHolder.getContext();
		
		if(securityContext != null) {
			
			userDb = (UserDb)securityContext.getAuthentication().getPrincipal();
			
			if(Arrays.asList("SUPERADMIN", "HRPARTNER", "HRADMIN").contains(userDb.getRole().name())) return true;

		}
		return false;
	}
	
}
