package com.xxl.api.admin.core.model;

import java.sql.Timestamp;

public class XxlApplyfrom {
	private int ID;
	private String applyOfName;
	private String applyOfProjectName;
	private String applyOfPort;
	private Timestamp applyOfDate;
	private int applyOfStatus;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getApplyOfName() {
		return applyOfName;
	}
	public void setApplyOfName(String applyOfName) {
		this.applyOfName = applyOfName;
	}
	public String getApplyOfProjectName() {
		return applyOfProjectName;
	}
	public void setApplyOfProjectName(String applyOfProjectName) {
		this.applyOfProjectName = applyOfProjectName;
	}
	public String getApplyOfPort() {
		return applyOfPort;
	}
	public void setApplyOfPort(String applyOfPort) {
		this.applyOfPort = applyOfPort;
	}
	public Timestamp getApplyOfDate() {
		return applyOfDate;
	}
	public void setApplyOfDate(Timestamp applyOfDate) {
		this.applyOfDate = applyOfDate;
	}
	public int getApplyOfStatus() {
		return applyOfStatus;
	}
	public void setApplyOfStatus(int applyOfStatus) {
		this.applyOfStatus = applyOfStatus;
	}
	
}
