package com.r3sys.dao;

import java.util.*;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.r3sys.model.RawMaterial;

@Component
public class RawMaterialDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional
	public int insert(RawMaterial raw) {
		int i = (int)this.hibernateTemplate.save(raw);
		return i;
	}

	public List<RawMaterial> getAllRaw(RawMaterial raw) {
		
		List<RawMaterial> rawList =this.hibernateTemplate.loadAll(RawMaterial.class);
		return rawList;
	}

	public RawMaterial getRaw(int rid) {
		RawMaterial raw = this.hibernateTemplate.get(RawMaterial.class, rid);
		return raw;
	}

	@Transactional
	public void qtyUpdate(RawMaterial raw) {
		this.hibernateTemplate.update(raw);
	}
	@Transactional
	public void delete(int rid) {
		RawMaterial raw = this.hibernateTemplate.get(RawMaterial.class, rid);
		this.hibernateTemplate.delete(raw);
		
	}
	
}
