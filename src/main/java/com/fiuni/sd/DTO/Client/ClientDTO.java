package com.fiuni.sd.DTO.Client;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.sd.DTO.Base.BaseDTO;
@XmlRootElement
public class ClientDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;

	private Integer userId;

	private String clientRuc;
	private String firstName;
	private String lastName;

	private String clientPhone;
	
	@XmlElement
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@XmlElement
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@XmlElement
	public String getClientPhone() {
		return clientPhone;
	}

	public void setClientPhone(String clientPhone) {
		this.clientPhone = clientPhone;
	}



	@XmlElement
	public String getClientRuc() {
		return clientRuc;
	}

	public void setClientRuc(String clientRuc) {
		this.clientRuc = clientRuc;
	}

}
