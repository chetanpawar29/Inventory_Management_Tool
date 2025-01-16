package com.r3sys.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.r3sys.model.IssueRaw;
import com.r3sys.model.RawMaterial;

@Component
public class IssueRawDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional
	public int insert(IssueRaw iraw) {
		int i = (int)this.hibernateTemplate.save(iraw);
		return i;
	}

	public List<IssueRaw> getAllIssueRaw(IssueRaw iraw) {
		List<IssueRaw> iRawList =this.hibernateTemplate.loadAll(IssueRaw.class);
		return iRawList;
	}

	
}
