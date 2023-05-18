package com.activity.revision.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SetSalaryRequest {

	private String email;
	
	private Double newSalary;
	
}
