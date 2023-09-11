package com.dnb.DevConnector.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnb.DevConnector.dto.User;
import com.dnb.DevConnector.exceptions.IdNotFoundException;
import com.dnb.DevConnector.repo.UserRepository;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public Optional<User> getUserByEmailId(String emailId) {
		// TODO Auto-generated method stub
		return userRepository.findById(emailId);
	}

	@Override
	public Iterable<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public boolean deleteUserByEmailId(String emailId) throws IdNotFoundException {
		// TODO Auto-generated method stub
		if(userRepository.existsById(emailId)) {
			userRepository.deleteById(emailId);
			if(userRepository.existsById(emailId)) {
				return false;
			}
			return true;
		}
		else {
			throw new IdNotFoundException("ID not found");
		}
	}

	
}
