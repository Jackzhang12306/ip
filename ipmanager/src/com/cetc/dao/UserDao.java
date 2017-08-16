package com.cetc.dao;

import java.util.List;

import com.cetc.bean.Ip;
import com.cetc.bean.User;
import com.cetc.util.CrudDao;

public interface UserDao extends CrudDao<User>{
	List<User> findByName(String name);
}
