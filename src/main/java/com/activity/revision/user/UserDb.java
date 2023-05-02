package com.activity.revision.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.springframework.data.aerospike.mapping.Document;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "userTable")
@Document(collection = "set1")
@TypeDef(name="jsonb", typeClass = JsonBinaryType.class)
public class UserDb {
	
	@Id @GeneratedValue(strategy= GenerationType.SEQUENCE) private Long id;
	
	@Column(name = "UserName") private String userName;
	
	@Column(name = "email", unique = true, nullable = false) private String email;
	
	@Column(name = "password") private String password;
	
	@Column(name = "ContactNumber") private String contactNumber;
	
	@Column(name = "Salary") private Double salary;
	
	@Column(name = "isDeleted") private Boolean isDeleted;
	
	@Type(type = "jsonb") @Column(name = "address",columnDefinition = "jsonb") private Address address;
	
	@Column(name = "role") @Enumerated(EnumType.STRING)private Role role;
	
}
