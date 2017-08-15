package com.cetc.bean;

import java.io.Serializable;

public class IpBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -654300023595539377L;
	private String ip;
	private String id;
	private String username;							//鎷ユ湁鑰�
	private int  used;										//鏄惁浣跨敤 0鏈娇鐢�  1浣跨敤
	private String description;							//鎻忚堪
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getDecription() {
		return description;
	}
	public void setDecription(String decription) {
		this.description = decription;
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
        this.used=Integer.parseInt(ip.getUsed());
        this.username = ip.getUsername();
        this.description = ip.getDescription();
    }
	

}
