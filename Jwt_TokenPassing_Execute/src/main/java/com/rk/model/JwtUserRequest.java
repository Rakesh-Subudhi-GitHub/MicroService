package com.rk.model;

import lombok.Data;

@Data
public class JwtUserRequest {

	private String username;
	private String password;
}
