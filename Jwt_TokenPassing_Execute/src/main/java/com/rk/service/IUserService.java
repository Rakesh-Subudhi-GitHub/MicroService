package com.rk.service;

import java.util.Optional;

import com.rk.model.User;

public interface IUserService {

	public Integer saveUser(User user);
	
	public Optional<User> findByUserName(String userName);
}
