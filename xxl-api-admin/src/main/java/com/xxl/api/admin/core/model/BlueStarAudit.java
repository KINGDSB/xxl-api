package com.xxl.api.admin.core.model;

import java.sql.Timestamp;

public class BlueStarAudit {
	private int applyOfId;
	private String auditor;
	private String bizComent;
	private Timestamp applyDate;
	private int auditStatus;
	public int getAuditStatus() {
		return auditStatus;
	}
	public void setAuditStatus(int auditStatus) {
		this.auditStatus = auditStatus;
	}
	public Timestamp getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(Timestamp applyDate) {
		this.applyDate = applyDate;
	}
	public int getApplyOfId() {
		return applyOfId;
	}
	public void setApplyOfId(int applyOfId) {
		this.applyOfId = applyOfId;
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
	
	
}
