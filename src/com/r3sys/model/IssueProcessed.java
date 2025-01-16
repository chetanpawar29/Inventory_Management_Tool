package com.r3sys.model;


import javax.persistence.*;

import org.springframework.stereotype.Component;

@Entity
@Component
public class IssueProcessed {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ipId;
	private int pid;
	private String pname;
	private String issuerName;
	private float pQuantity;
	private String issueDate;
	private String issueTime;
	public int getIpId() {
		return ipId;
	}
	public void setIpId(int ipId) {
		this.ipId = ipId;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getIssuerName() {
		return issuerName;
	}
	public void setIssuerName(String issuerName) {
		this.issuerName = issuerName;
	}
	public float getpQuantity() {
		return pQuantity;
	}
	public void setpQuantity(float pQuantity) {
		this.pQuantity = pQuantity;
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
	public IssueProcessed() {
		super();
		// TODO Auto-generated constructor stub
	}
	public IssueProcessed(int ipId, int pid, String pname, String issuerName, float pQuantity, String issueDate,
			String issueTime) {
		super();
		this.ipId = ipId;
		this.pid = pid;
		this.pname = pname;
		this.issuerName = issuerName;
		this.pQuantity = pQuantity;
		this.issueDate = issueDate;
		this.issueTime = issueTime;
	}
	@Override
	public String toString() {
		return "IssueProcessed [ipId=" + ipId + ", pid=" + pid + ", pname=" + pname + ", issuerName=" + issuerName
				+ ", pQuantity=" + pQuantity + ", issueDate=" + issueDate + ", issueTime=" + issueTime + "]";
	}
	
	
}
