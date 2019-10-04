package com.spring.repository.iface;

import java.util.List;

import com.spring.model.User;

public interface IUserDao {

	List<User> findAll();

	User findById(int userId);

}
