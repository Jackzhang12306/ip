package com.cetc.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.User;

import com.sun.xml.internal.bind.v2.runtime.Name;

public class IpBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -654300023595539377L;
	private String ip;
	private String username;							//拥有者
	private int  used;										//是否使用 0未使用  1使用
	private String decription;							//描述
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getDecription() {
		return decription;
	}
	public void setDecription(String decription) {
		this.decription = decription;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getUsed() {
		return used;
	}
	public void setUsed(int used) {
		this.used = used;
	}
	

}
