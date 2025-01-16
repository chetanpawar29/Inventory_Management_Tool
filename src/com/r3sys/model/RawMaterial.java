package com.r3sys.model;


import javax.persistence.*;

import org.springframework.stereotype.Component;

@Entity
@Component
public class RawMaterial {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int rid;
	private String rname;
	private float rQuantity;
	private String rUnit;
	private float rCostPerUnit;
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
	public float getrQuantity() {
		return rQuantity;
	}
	public void setrQuantity(float rQuantity) {
		this.rQuantity = rQuantity;
	}
	public String getrUnit() {
		return rUnit;
	}
	public void setrUnit(String rUnit) {
		this.rUnit = rUnit;
	}
	public float getrCostPerUnit() {
		return rCostPerUnit;
	}
	public void setrCostPerUnit(float rCostPerUnit) {
		this.rCostPerUnit = rCostPerUnit;
	}
	public RawMaterial() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RawMaterial(int rid, String rname, float rQuantity, String rUnit, float rCostPerUnit) {
		super();
		this.rid = rid;
		this.rname = rname;
		this.rQuantity = rQuantity;
		this.rUnit = rUnit;
		this.rCostPerUnit = rCostPerUnit;
	}
	@Override
	public String toString() {
		return "RawMaterial [rid=" + rid + ", rname=" + rname + ", rQuantity=" + rQuantity + ", rUnit=" + rUnit
				+ ", rCostPerUnit=" + rCostPerUnit + "]";
	}
	
}
