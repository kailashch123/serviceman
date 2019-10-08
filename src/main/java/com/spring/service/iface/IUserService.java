package com.spring.service.iface;

import java.util.List;

import com.spring.model.User;

public interface IUserService {

	List<User> findAll();

	User findById(int userId);

	User saveUser(User user);

	List<String> search(String parameter);

}
