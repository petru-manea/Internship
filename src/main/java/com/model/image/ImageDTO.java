package com.model.image;

import java.io.Serializable;

public class ImageDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private byte[] picture;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

}
