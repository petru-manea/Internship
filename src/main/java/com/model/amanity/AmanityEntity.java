package com.model.amanity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.config.BaseEntity;

@Entity
@Table(name = "AMANITY")
public class AmanityEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "NAME", nullable = false)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "AmanitytEntity [id=" + getId() + ", name=" + name + "]";
	}

}
