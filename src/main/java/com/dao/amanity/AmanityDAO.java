package com.dao.amanity;

import org.springframework.stereotype.Component;

import com.config.GenericDAO;
import com.model.amanity.AmanityEntity;

@Component
public interface  AmanityDAO extends GenericDAO<AmanityEntity, Integer> {

}
