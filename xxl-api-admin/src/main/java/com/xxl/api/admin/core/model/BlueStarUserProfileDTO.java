package com.xxl.api.admin.core.model;

import java.io.Serializable;

import lombok.Data;
@Data
public class BlueStarUserProfileDTO implements Serializable{
	private String userId;
	private String name;
	private String address ;
	private String idNumber;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	
}
