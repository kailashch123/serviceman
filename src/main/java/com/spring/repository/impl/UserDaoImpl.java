package com.spring.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.model.User;
import com.spring.repository.iface.IUserDao;

@Repository("userRepository")
public class UserDaoImpl implements IUserDao {

	@Override
	public List<User> findAll() {
		return null;
	}

	@Override
	public User findById(int userId) {
		return null;
	}

}
