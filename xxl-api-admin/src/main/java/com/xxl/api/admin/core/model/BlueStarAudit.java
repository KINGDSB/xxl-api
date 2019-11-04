package com.xxl.api.admin.core.model;

import java.sql.Timestamp;

public class BlueStarAudit {
	private String id;
	private String applyofId;
	private String auditor;
	private String bizComent;
	private Timestamp applyDate;
	private String auditStatus;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getApplyofId() {
		return applyofId;
	}
	public void setApplyofId(String applyOfId) {
		this.applyofId = applyOfId;
	}
	
}
