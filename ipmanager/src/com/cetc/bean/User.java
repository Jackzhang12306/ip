package com.cetc.bean;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "usertable")
public class User implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String uid;

    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String telephone;
    
    /*@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Ip> ips = new ArrayList<>();*/

	public String getUid() {
		return uid;
	}

	public String getName() {
		return name;
	}

	public String getTelephone() {
		return telephone;
	}

	/*public List<Ip> getIps() {
		return ips;
	}*/

	public void setUid(String uid) {
		this.uid = uid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/*public void setIps(List<Ip> ips) {
		this.ips = ips;
	}*/
    
   
}


