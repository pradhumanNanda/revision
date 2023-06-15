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
	
	@Id @GeneratedValue(strategy= GenerationType.AUTO) private Long id;
	
	@Column(name = "userName") private String userName;
	
	@Column(name = "email", nullable = false) private String email;
	
	@Column(name = "password") private String password;
	
	@Column(name = "contactNumber") private String contactNumber;
	
	@Column(name = "salary") private Double salary;
	
	@Column(name = "isDeleted") private Boolean isDeleted;
	
	@Type(type = "jsonb") @Column(name = "address",columnDefinition = "jsonb") private Address address;
	
	@Column(name = "role") @Enumerated(EnumType.STRING) private Role role;

	@Override
	public String toString() {
		return "id=" + id + ", userName=" + userName + ", email=" + email + ", password=" + password
				+ ", contactNumber=" + contactNumber + ", salary=" + salary + ", isDeleted=" + isDeleted + ", address="
				+ address + ", role=" + role;
	}
	
	
	
}
