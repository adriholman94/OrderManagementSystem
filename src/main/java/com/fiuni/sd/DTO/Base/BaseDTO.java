package com.fiuni.sd.DTO.Base;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

public abstract class BaseDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
