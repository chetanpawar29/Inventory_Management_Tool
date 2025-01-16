package com.r3sys.model;

import javax.persistence.*;

import org.springframework.stereotype.Component;

@Entity
@Component
public class ProcessedMaterial {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pid;
	private String pname;
	private float pQuantity;
	private String pUnit;
	private float pCostPerUnit;
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
	public float getpQuantity() {
		return pQuantity;
	}
	public void setpQuantity(float pQuantity) {
		this.pQuantity = pQuantity;
	}
	public String getpUnit() {
		return pUnit;
	}
	public void setpUnit(String pUnit) {
		this.pUnit = pUnit;
	}
	public float getpCostPerUnit() {
		return pCostPerUnit;
	}
	public void setpCostPerUnit(float pCostPerUnit) {
		this.pCostPerUnit = pCostPerUnit;
	}
	public ProcessedMaterial() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProcessedMaterial(int pid, String pname, float pQuantity, String pUnit, float pCostPerUnit) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pQuantity = pQuantity;
		this.pUnit = pUnit;
		this.pCostPerUnit = pCostPerUnit;
	}
	@Override
	public String toString() {
		return "ProcessedMaterial [pid=" + pid + ", pname=" + pname + ", pQuantity=" + pQuantity + ", pUnit=" + pUnit
				+ ", pCostPerUnit=" + pCostPerUnit + "]";
	}
	
}
