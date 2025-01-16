package com.r3sys.model;

import javax.persistence.*;

import org.springframework.stereotype.Component;

@Entity
@Component
public class IssueRaw {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int irId;
	private int rid;
	private String rname;
	private String issuerName;
	private float rQuantity;
	private String issueDate;
	private String issueTime;
	public int getIrId() {
		return irId;
	}
	public void setIrId(int irId) {
		this.irId = irId;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getIssuerName() {
		return issuerName;
	}
	public void setIssuerName(String issuerName) {
		this.issuerName = issuerName;
	}
	public float getrQuantity() {
		return rQuantity;
	}
	public void setrQuantity(float rQuantity) {
		this.rQuantity = rQuantity;
	}
	public String getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	public String getIssueTime() {
		return issueTime;
	}
	public void setIssueTime(String issueTime) {
		this.issueTime = issueTime;
	}
	public IssueRaw() {
		super();
		// TODO Auto-generated constructor stub
	}
	public IssueRaw(int irId, int rid, String rname, String issuerName, float rQuantity, String issueDate,
			String issueTime) {
		super();
		this.irId = irId;
		this.rid = rid;
		this.rname = rname;
		this.issuerName = issuerName;
		this.rQuantity = rQuantity;
		this.issueDate = issueDate;
		this.issueTime = issueTime;
	}
	@Override
	public String toString() {
		return "IssueRaw [irId=" + irId + ", rid=" + rid + ", rname=" + rname + ", issuerName=" + issuerName
				+ ", rQuantity=" + rQuantity + ", issueDate=" + issueDate + ", issueTime=" + issueTime + "]";
	}
	
	
}
