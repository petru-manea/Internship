package com.dao.review.impl;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.config.GenericDAOImpl;
import com.dao.review.ReviewDAO;
import com.model.review.ReviewEntity;

@Component
public class ReviewDAOImpl extends GenericDAOImpl<ReviewEntity, Integer> implements ReviewDAO {

	public ReviewDAOImpl() {
		super(ReviewEntity.class);
	}

	@Override
	@Transactional
	public void save(ReviewEntity entity) {
		super.save(entity);
		flush();
	}

	@Override
	@Transactional
	public ReviewEntity update(ReviewEntity entity) {
		ReviewEntity updatedEntity = super.update(entity);
		flush();
		return updatedEntity;
	}

	@Override
	@Transactional
	public void delete(ReviewEntity entity) {
		super.delete(entity);
		flush();
	}

	@Override
	@Transactional
	public ReviewEntity findById(Integer id) {
		ReviewEntity entity = super.findById(id);
		return entity;
	}

	@Override
	@Transactional
	public List<ReviewEntity> findAll() {
		return super.findAll();
	}

	@Override
	@Transactional
	public void flush() {
		super.flush();
	} 

}
