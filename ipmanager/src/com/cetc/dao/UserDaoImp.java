package com.cetc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cetc.bean.User;
import com.cetc.util.PageHibernateDaoSupport;

@Repository
public class UserDaoImp extends PageHibernateDaoSupport<User> implements UserDao{
	 public UserDaoImp() {
	        super();
	        setClass(User.class);
	    }

	@Override
	public List<User> findByName(String name) {
		        String hql = "from User where name=?";
		        return (List<User>) getHibernateTemplate().find(hql, name);
	}
}
