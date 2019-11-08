package com.xxl.api.admin.core.model;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BlueStarAuditDTO {
	private String id;
	private String applyofId;
	private String auditor;
	private String bizComent;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Timestamp applyDate;
	private String auditStatus;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getApplyofId() {
		return applyofId;
	}
	public void setApplyofId(String applyofId) {
		this.applyofId = applyofId;
	}
	public String getAuditor() {
		return auditor;
	}
	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}
	public String getBizComent() {
		return bizComent;
	}
	public void setBizComent(String bizComent) {
		this.bizComent = bizComent;
	}
	public Timestamp getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(Timestamp applyDate) {
		this.applyDate = applyDate;
	}
	public String getAuditStatus() {
		return auditStatus;
	}
	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}
	
}
