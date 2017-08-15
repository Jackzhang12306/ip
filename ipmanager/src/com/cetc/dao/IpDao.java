package com.cetc.dao;

import java.util.List;
import com.cetc.bean.Ip;
import com.cetc.bean.IpBean;
import com.cetc.util.CrudDao;

public interface IpDao extends CrudDao<Ip> {
	List<Ip> findByName(String name);
}


