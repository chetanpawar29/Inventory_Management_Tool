package com.r3sys.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

@Entity
@Component
public class Manager {
	
	@Id
	private String aemail;
	private String apassword;
	public String getAemail() {
		return aemail;
	}
	public void setAemail(String aemail) {
		this.aemail = aemail;
	}
	public String getApassword() {
		return apassword;
	}
	public void setApassword(String apassword) {
		this.apassword = apassword;
	}
	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Manager(String aemail, String apassword) {
		super();
		this.aemail = aemail;
		this.apassword = apassword;
	}
	@Override
	public String toString() {
		return "Manager [aemail=" + aemail + ", apassword=" + apassword + "]";
	}
	

}
