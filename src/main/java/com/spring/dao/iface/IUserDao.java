package com.spring.dao.iface;

import java.util.List;

import com.spring.model.User;

public interface IUserDao {

	List<User> findAll();

	User findById(int userId);

	User saveUser(User user);

	List<String> search(String parameter);

}
