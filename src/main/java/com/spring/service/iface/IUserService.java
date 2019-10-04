package com.spring.service.iface;

import java.util.List;

import com.spring.model.User;

public interface IUserService {

	List<User> findAll();

	User findById(int userId);

}
