package com.cetc.bean;

import java.io.Serializable;

public class IpBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -654300023595539377L;
	private String ip;
	private String id;
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
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public IpBean(Ip ip) {
        super();
        this.id = ip.getId();
        this.ip = ip.getIp();
        this.ip = ip.getUsername();
        this.ip = ip.getDecription();
    }
	

}
