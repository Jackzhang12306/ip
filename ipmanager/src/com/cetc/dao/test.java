package com.cetc.dao;

import java.util.List;

import com.cetc.bean.Ip;
import com.cetc.bean.User;

public class test {

	public static void main(String[] args) {
			
		UserDao userDao=new UserDaoImp();
		IpDao ipDao= new IpDaoImp();
		 
			User user= new User();
			user.setName("张三");
			user.setTelephone("123456");
		  Ip ip = new Ip();
			ip.setIp("192.168.1.001");
			ip.setUsed("1");
			ip.setDescription("王五用");
			ip.setUser(user);
	
			ipDao.save(ip);
		
			
			
	}

}
