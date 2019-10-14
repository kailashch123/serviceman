package com.spring.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.spring.dao.iface.IUserDao;
import com.spring.model.User;

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

	@Override
	public List<String> search(String parameter) {
		Criteria cri = createEntityCriteria();
		cri.add(Restrictions.like("firstName", parameter, MatchMode.ANYWHERE));
		List<User> users = cri.list();
		List<String> stringList = new ArrayList<String>();
		for(User u : users) {
			stringList.add(u.getFirstName()+" "+u.getLastName()+" ("+u.getEmail()+")");
		}
		return stringList;
	}

	@Override
	public User findUserByEmail(String emailStr) {
		Criteria cr = createEntityCriteria();
		cr.add(Restrictions.eq("email", emailStr));
		User user = (User) cr.uniqueResult();
		return user;
	}

	@Override
	public User update(User user) {
		User userTemp = findById(user.getUserId());
		if(user.getFirstName() != null)
			userTemp.setFirstName(user.getFirstName());
		if(user.getLastName() != null)
			userTemp.setLastName(user.getLastName());
		if(user.getPassword() != null)
			userTemp.setPassword(user.getPassword());
		if(user.getMobile() != null)
			userTemp.setMobile(user.getMobile());
		if(user.getDob() != null)
			userTemp.setDob(user.getDob());
		if(user.getAddress() != null)
			userTemp.setAddress(user.getAddress());
		getSession().update(userTemp);
		return userTemp;
	}

	@Override
	public void deleteUserById(int userId) {
		Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("userId", userId));
        User user = (User)crit.uniqueResult();
        delete(user);
	}

}
