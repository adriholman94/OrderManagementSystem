package com.fiuni.sd.DTO;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
public abstract class BaseDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long _id;

	@XmlElement
	public Long getId() {
		return _id;
	}

	public void setId(Long id) {
		_id = id;
	}

}
