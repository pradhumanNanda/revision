package com.activity.revision;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import com.activity.revision.repo.UserRepo;
import com.activity.revision.user.Role;
import com.activity.revision.user.UserDb;
import com.activity.revision.utils.Constants;
import com.activity.revision.utils.PasswordEncDecUtil;

@SpringBootApplication
@EnableCaching
public class RevisionApplication {
	
    public static void main(String[] args) {
        SpringApplication.run(RevisionApplication.class, args);
        
    }
    @Bean
    CommandLineRunner init(UserRepo userRepo){
        return args -> {
        	if(userRepo.findAll().size() == 0) userRepo.save(UserDb.builder().
									            		userName("SuperAdmin").
									            		email("superadmin@gmail.com").
									            		password(PasswordEncDecUtil.encrypt("SuperAdmin")).
									            		contactNumber("9667432838").
									            		isDeleted(false).
									            		salary(Constants.DEFAULTSALARY).
									            		role(Role.SUPERADMIN).build());
        };
    }

}
