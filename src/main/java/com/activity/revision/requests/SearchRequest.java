package com.activity.revision.requests;

import com.activity.revision.user.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchRequest {
	
	private String userName;
	
	private String email;
	
	private String contactNumber;
	
	private String salaryRange;
	
	private Boolean isDeleted;
	
	private Role role;

}
