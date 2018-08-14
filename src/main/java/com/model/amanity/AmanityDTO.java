package com.model.amanity;

import java.io.Serializable;

public class AmanityDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private AmanityTypeDTO name;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public AmanityTypeDTO getName() {
		return name;
	}

	public void setName(AmanityTypeDTO name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "AmanitytEntity [id=" + getId() + ", name=" + name + "]";
	}

}
