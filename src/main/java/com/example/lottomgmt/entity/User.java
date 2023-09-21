package com.example.lottomgmt.entity;

import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import jakarta.validation.constraints.Email;

@Entity
@Data
@Table(name = "user_tbl")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(View.class)
	private Long id;
	
	@Column(length = 50, nullable = false)
	private String username;
	
	@Column(length = 250, nullable = false, unique = true)
	private String passkey;
	
	@Column(length = 50, nullable = false, unique = true)
	@Email
	private String email;
	
	@Column(length = 8, nullable = false)
	private String shop_type;
	
	@Column(length = 20, nullable = false)
	private String created_on;
	
	@Column(length = 20)
	private String last_login;
	
	private String auth_token;

}
