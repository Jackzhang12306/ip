package com.cetc.bean;

import java.io.Serializable;

public class UserBean implements Serializable {
	
	    private static final long serialVersionUID = 1L;
	   	private String uid;
	    private String name;
	    private String telephone;
		public String getUid() {
			return uid;
		}
		public void setUid(String uid) {
			this.uid = uid;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getTelephone() {
			return telephone;
		}
		public void setTelephone(String telephone) {
			this.telephone = telephone;
		}
		
		 public UserBean(User user) {
		        super();
		        this.uid = user.getUid();
		        this.name =user.getName();
		        this.telephone=user.getTelephone();
		    }

		
		
}
