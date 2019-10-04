package com.spring.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.spring.model.User;
import com.spring.repository.iface.IUserDao;

@Repository("userRepository")
public class UserDaoImpl extends AbstractDao<Integer, User> implements IUserDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {
		Criteria criteria = createEntityCriteria();
		List<User> users = criteria.list();
		return users;
	}

	@Override
	public User findById(int userId) {
		User user = getByKey(userId);
		return user;
	}

	@Override
	public User saveUser(User user) {
		save(user);
		return user;
	}

}
