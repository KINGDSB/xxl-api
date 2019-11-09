package com.xxl.api.admin.core.model;

import java.io.Serializable;

import lombok.Data;
@Data
public class BlueStarPortDTO implements Serializable{
	private String id;
	private String portName;
	private String portGroupName;
	private String portUrl;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPortName() {
		return portName;
	}
	public void setPortName(String portName) {
		this.portName = portName;
	}
	public String getPortGroupName() {
		return portGroupName;
	}
	public void setPortGroupName(String portGroupName) {
		this.portGroupName = portGroupName;
	}
	public String getPortUrl() {
		return portUrl;
	}
	public void setPortUrl(String portUrl) {
		this.portUrl = portUrl;
	}

}
