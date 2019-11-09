package com.xxl.api.admin.core.model;

import java.io.Serializable;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
@Data
public class BlueStarApplyfromDTO implements Serializable{
	private String id;
	private String applyOfName;
	private String applyOfProjectName;
	private String applyOfPort;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
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
