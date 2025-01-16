package com.r3sys.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.r3sys.model.ProcessedMaterial;
import com.r3sys.model.RawMaterial;

@Component
public class ProcessedMaterialDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional
	public int insert(ProcessedMaterial processed) {
		int i = (int)this.hibernateTemplate.save(processed);
		return i;
	}

	public List<ProcessedMaterial> getAllRaw(ProcessedMaterial processed) {

		List<ProcessedMaterial> processedList =this.hibernateTemplate.loadAll(ProcessedMaterial.class);
		return processedList;
	}
	@Transactional
	public void qtyUpdate(ProcessedMaterial processed) {
		this.hibernateTemplate.update(processed);
		
	}

	
	public ProcessedMaterial getProcessed(int pid) {
		ProcessedMaterial processed = this.hibernateTemplate.get(ProcessedMaterial.class, pid);
		return processed;
	}
	
	@Transactional
	public void delete(int pid) {
		ProcessedMaterial processed = this.hibernateTemplate.get(ProcessedMaterial.class, pid);
		this.hibernateTemplate.delete(processed);
		
	}
	
}
