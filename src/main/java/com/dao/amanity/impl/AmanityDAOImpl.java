package com.dao.amanity.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.config.GenericDAOImpl;
import com.dao.amanity.AmanityDAO;
import com.model.amanity.AmanityEntity;

public class AmanityDAOImpl extends GenericDAOImpl<AmanityEntity, Integer> implements AmanityDAO{

	public AmanityDAOImpl() {
		super(AmanityEntity.class);
	}

	@Override
	@Transactional
	public void save(AmanityEntity entity) {
		super.save(entity);
		flush();
	}

	@Override
	@Transactional
	public AmanityEntity update(AmanityEntity entity) {
		AmanityEntity updatedEntity = super.update(entity);
		flush();
		return updatedEntity;
	}

	@Override
	@Transactional
	public void delete(AmanityEntity entity) {
		super.delete(entity);
		flush();
	}

	@Override
	@Transactional
	public AmanityEntity findById(Integer id) {
		AmanityEntity entity = super.findById(id);
		return entity;
	}

	@Override
	@Transactional
	public List<AmanityEntity> findAll() {
		return super.findAll();
	}

	@Override
	@Transactional
	public void flush() {
		super.flush();
	} 
}
