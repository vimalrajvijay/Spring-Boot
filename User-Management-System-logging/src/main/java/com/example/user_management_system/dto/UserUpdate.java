package com.example.user_management_system.dto;

import lombok.Data;

@Data
public class UserUpdate {

	private final String name;
	private final int age;
	private  final String email;
	private final String password;

}
