package com.activity.revision.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
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
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class UserDb {
	
	@Id @GeneratedValue(strategy= GenerationType.SEQUENCE) private Long id;
	
	@Column(name = "UserName") private String userName;
	
	@Column(name = "email", unique = true, nullable = false) private String email;
	
	@Column(name = "password") private String password;
	
	@Column(name = "ContactNumber") private String contactNumber;
	
	@Column(name = "Salary") private Double salary;
	
	@Column(name = "isDeleted") private Boolean isDeleted;
	
	@Type(type = "jsonb") @Column(name = "Role", columnDefinition = "jsonb") private Role role;
	
}
