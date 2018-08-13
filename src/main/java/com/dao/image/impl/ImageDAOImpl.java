package com.dao.image.impl;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.config.GenericDAOImpl;
import com.dao.image.ImageDAO;
import com.model.image.ImageEntity;

@Component
public class ImageDAOImpl extends GenericDAOImpl<ImageEntity, Integer> implements ImageDAO {
	
	public ImageDAOImpl() {
		super(ImageEntity.class);
	}

	@Override
	@Transactional
	public void save(ImageEntity entity) {
		super.save(entity);
		flush();
	}

	@Override
	@Transactional
	public ImageEntity update(ImageEntity entity) {
		ImageEntity updatedEntity = super.update(entity);
		flush();
		return updatedEntity;
	}

	@Override
	@Transactional
	public void delete(ImageEntity entity) {
		super.delete(entity);
		flush();
	}

	@Override
	@Transactional
	public ImageEntity findById(Integer id) {
		ImageEntity entity = super.findById(id);
		return entity;
	}

	@Override
	@Transactional
	public List<ImageEntity> findAll() {
		return super.findAll();
	}

	@Override
	@Transactional
	public void flush() {
		super.flush();
	}
}
