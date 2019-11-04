package com.xxl.api.admin.core.model;

import java.sql.Timestamp;

public class BlueStarApplyfrom {
	private String id;
	private String applyOfName;
	private String applyOfProjectName;
	private String applyOfPort;
	private Timestamp applyOfDate;
	private String applyOfStatus;

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getApplyOfStatus() {
		return applyOfStatus;
	}
	public void setApplyOfStatus(String applyOfStatus) {
		this.applyOfStatus = applyOfStatus;
	}
	
	
}
