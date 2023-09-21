package com.dnb.DevConnector.service;

import java.util.Optional;

import com.dnb.DevConnector.dto.User;
import com.dnb.DevConnector.exceptions.IdNotFoundException;

public interface UserService {
	public User createUser(User user);
	
	public Optional<User> getUserByUserId(String userId);
	
	public Iterable<User> getAllUsers();
	
	public boolean deleteUserById(String userId) throws IdNotFoundException;

	public boolean userExistsById(String userId);
}
