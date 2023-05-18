package com.activity.revision.jwt;

import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import com.activity.revision.repo.UserRepo;
import com.activity.revision.user.UserDb;
import com.activity.revision.utils.Constants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class SecurityFilter extends GenericFilterBean{

	@Autowired UserRepo userRepo;

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest)req;
		
		HttpServletResponse response = (HttpServletResponse)res;
		
		if(!request.getRequestURI().contains("/logIn") && !request.getRequestURI().contains("/signUp") && !request.getRequestURI().contains("/hey")){
            try{
                UserDb userDb;
   
                Claims claims = Jwts.parser().
                		setSigningKey(Constants.secret).
                		parseClaimsJws(Constants.curUserJwtString).
                		getBody();
                
                Long id = Long.parseLong(claims.getSubject());
                
                boolean isExpired = (new Date().getTime() - claims.getIssuedAt().getTime()) / 60000  > 15 ? true : false;
                
                if(isExpired){
                
                    response.addHeader(Constants.error, "Auth token expired");
                    
                    throw new RuntimeException("Auth token expired");
                }
                if(userRepo.findById(id).isPresent() && !isExpired){
                	
                    userDb = userRepo.findById(id).get();
                    
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                            new UsernamePasswordAuthenticationToken(userDb, null, Collections.emptyList());
                    
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
               
                }else {
                	
                    response.addHeader(Constants.error, String.format("No user found for id : %s", id));
                    
                    throw new RuntimeException(String.format("User with this %s id not found in db", id));
                }
            }catch (Exception e){
            	
                response.addHeader(Constants.error, e.getMessage());
                
                throw new RuntimeException(e.getMessage());
            }
        }
		chain.doFilter(request, response);
	}
	
}
