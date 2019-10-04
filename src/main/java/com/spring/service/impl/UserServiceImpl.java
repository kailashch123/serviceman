package com.spring.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.User;
import com.spring.repository.iface.IUserDao;
import com.spring.service.iface.IUserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserDao userDao;

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	public User findById(int userId) {
		return userDao.findById(userId);
	}

	@Override
	public User saveUser(User user) {
		User respUser = userDao.saveUser(user);
		return null;
	}

}
