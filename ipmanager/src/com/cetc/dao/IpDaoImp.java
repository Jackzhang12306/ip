package com.cetc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cetc.bean.IpBean;
import com.cetc.util.PageBean;
import com.cetc.util.Util;

public class IpDaoImp implements IpDao{

	@Override
	public boolean addIp(IpBean ipBean) {
		try {
			if(Util.addIp(ipBean)){
				return true;
			}
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delIp(IpBean ipBean) {
		
		return false;
	}

	@Override
	public boolean updateIp(IpBean ipBean) {
		return false;
	}

	

	@Override
	public List<IpBean> queryAll() {
		List<IpBean> list = null;
		try {
			list=Util.queryPageForList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<IpBean> queryByName(String username) {
		List<IpBean> list = null;
		try {
			list=Util.getIpList(username);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	//获取当前页数据
			@Override
		public PageBean<IpBean> getPager(int pc, int pr) {
				PageBean<IpBean> pager=new PageBean<>();
				int count=this.size();
				if (count> 0) {
				pager.setPc(pc);
				pager.setPr(pr);
				String sql = "select * from message  order by id desc limit "
			               +pr*(pc-1)+ "," + pr;
				List<IpBean> list = null;
				try {
					list = Util.query(sql);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				pager.setBeanList(list);
			}
			return pager;
		}
			
			// message记录数
			public int size() {
				int count = 0;
				try {
					List<IpBean> list = Util.getIpList();
					if(list.size()>0){
						count = list.size();
					}
					
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return count;
			}

}
