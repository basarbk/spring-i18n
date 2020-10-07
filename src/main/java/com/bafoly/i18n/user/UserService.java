package com.bafoly.i18n.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public User save(User user) {
		return this.userRepository.save(user);
	}
  
}
