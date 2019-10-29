package com.xxl.api.admin.core.model;

public class BlueStarPort {
	private int ID;
	private String portName;
	private String portGroupName;
	private String portUrl;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
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
