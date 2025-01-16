package com.r3sys.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.r3sys.model.IssueProcessed;
import com.r3sys.model.IssueRaw;

@Component
public class IssueProcessedDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional
	public int insert(IssueProcessed iProcessed) {
		int i = (int)this.hibernateTemplate.save(iProcessed);
		return i;
	}

	public List<IssueProcessed> getAllIssueRaw(IssueProcessed iProcessed) {
		List<IssueProcessed> iProcessedList =this.hibernateTemplate.loadAll(IssueProcessed.class);
		return iProcessedList;
	}
	
}
