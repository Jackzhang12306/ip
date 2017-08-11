package com.cetc.dao;

import java.util.List;

import com.cetc.bean.IpBean;
import com.cetc.util.PageBean;

public interface IpDao {
	public boolean addIp(IpBean ipBean);
	public boolean delIp(IpBean ipBean);
	public boolean updateIp(IpBean ipBean);
	public List<IpBean> queryAll();
	public List<IpBean> queryByName(String username);
	public PageBean<IpBean> getPager(int pageNo, int pageSize);
}
