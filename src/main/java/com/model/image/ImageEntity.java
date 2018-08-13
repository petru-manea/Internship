package com.model.image;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.config.BaseEntity;

@Entity
@Table(name = "IMAGE")
public class ImageEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "PICTURE")
	private byte[] picture;

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	@Override
	public String toString() {
		return "ImageEntity [id=" + getId() + ", picture=" + Arrays.toString(picture) + "]";
	}
	
}
