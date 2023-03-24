package com.activity.revision.jwt;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import com.activity.revision.repo.UserRepo;
import com.activity.revision.requests.UserLoginRequest;
import com.activity.revision.user.UserDb;
import com.activity.revision.utils.Constants;
import com.activity.revision.utils.PasswordEncDecUtil;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class UserAuthenticationProvider implements AuthenticationProvider{
	
	@Autowired UserRepo userRepo;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		UserLoginRequest userLoginRequest = (UserLoginRequest)authentication.getPrincipal();
		
		UserDb userDb = userRepo.findUserByEmail(userLoginRequest.getEmail());
		
		if(userDb != null) {
			
			try {
				
				String passwordString = PasswordEncDecUtil.decrypt(userDb.getPassword());
				
				if(userLoginRequest.getPassword().equals(passwordString)) {
					
					String id = String.valueOf(userDb.getId());
					
					String JWT = Jwts.builder().
							 signWith(SignatureAlgorithm.HS512,Constants.secret).
							 setIssuedAt(new Date()).
							 setSubject(id).compact();
					 
					 Constants.curUserJwtString = JWT;
					 
					 
					 return new UsernamePasswordAuthenticationToken(userDb, null, Collections.emptyList());
				}
				
			} catch (GeneralSecurityException e) {
				throw new RuntimeException("PassWord Mismatch");
			}
		}
		
		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}

	
	

}
