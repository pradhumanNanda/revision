package com.activity.revision.dataGenerator;

import java.security.GeneralSecurityException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.springframework.stereotype.Service;
import com.activity.revision.repo.UserRepo;
import com.activity.revision.user.Address;
import com.activity.revision.user.Role;
import com.activity.revision.user.UserDb;
import com.activity.revision.utils.Constants;
import com.activity.revision.utils.PasswordEncDecUtil;
import com.github.javafaker.Faker;

@Service
public class DataGenerator {
	
	public static Faker faker = new Faker();
	
	private UserRepo userRepo;
	
	public DataGenerator(UserRepo userRepo) {
		super();
		this.userRepo = userRepo;
	}
	
	public String generateKey() {
		return faker.numerify("######");
	}
	public void generateCustomer() throws GeneralSecurityException {
		
		ExecutorService service = Executors.newFixedThreadPool(25);
		
		for(int i=0;i<100000;i++) service.execute(new Task());
		
	}
	
	class Task implements Runnable {

		@Override
		public void run() {
			
			String userName = faker.name().username();
			String email = faker.name().firstName()+faker.name().lastName()+faker.number().digits(3)+"@gmail.com";
			String contactNumber = faker.phoneNumber().cellPhone();
			String password = faker.name().firstName()+faker.name().lastName()+faker.number().digits(3);
			Address address = Address.builder().
									  city(faker.address().city()).
									  street(faker.address().streetName()).
									  state(faker.address().state()).
									  country(faker.address().country()).build();
			UserDb userDb = null;
			try {
				userDb = UserDb.builder().
										contactNumber(contactNumber).
										email(email).
										password(PasswordEncDecUtil.encrypt(password)).
										role(Role.NEWUSER).userName(userName).
										salary(Constants.DEFAULTSALARY).
										isDeleted(false).
										address(address).
										build();
			} catch (GeneralSecurityException e) {
				e.printStackTrace();
			}
			if(userDb != null) userRepo.save(userDb);
		}
		
		
	}

}
