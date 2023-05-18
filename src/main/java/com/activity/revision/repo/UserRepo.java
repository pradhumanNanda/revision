package com.activity.revision.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.activity.revision.user.UserDb;

public interface UserRepo extends JpaRepository<UserDb, Long>{

	@Query(value = "select * from user_table u where u.email = :email limit 1",
            nativeQuery = true) 
    UserDb findUserByEmail(@Param("email") String email);
	
}
