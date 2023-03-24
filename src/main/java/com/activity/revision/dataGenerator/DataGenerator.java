package com.activity.revision.dataGenerator;

import java.security.GeneralSecurityException;

import org.springframework.stereotype.Service;

import com.activity.revision.user.Role;
import com.activity.revision.user.UserDb;
import com.activity.revision.utils.Constants;
import com.activity.revision.utils.PasswordEncDecUtil;
import com.github.javafaker.Faker;

@Service
public class DataGenerator {
	Faker faker = new Faker();
	public UserDb generateCustomer() throws GeneralSecurityException {
		String userName = faker.name().username();
		String email = faker.name().firstName()+faker.name().lastName()+faker.number().digits(3)+"@gmail.com";
		String contactNumber = faker.phoneNumber().cellPhone();
		String password = faker.name().firstName()+faker.name().lastName()+faker.number().digits(3);
		return UserDb.builder().
				contactNumber(contactNumber).
				email(email).
				password(PasswordEncDecUtil.encrypt(password)).
				role(Role.NEWUSER).userName(userName).
				salary(Constants.DEFAULTSALARY).
				isDeleted(false).
				build();
	}

}
