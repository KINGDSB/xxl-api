package com.xxl.api.admin.service.impl;


import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxl.api.admin.core.model.BlueStarAudit;
import com.xxl.api.admin.core.model.BlueStarPort;
import com.xxl.api.admin.core.model.ReturnT;
import com.xxl.api.admin.core.util.StringUtil;
import com.xxl.api.admin.core.model.BlueStarApplyfrom;
import com.xxl.api.admin.dao.BlueStarApplyOfMapper;
import com.xxl.api.admin.dao.BlueStarAuthorMapper;
import com.xxl.api.admin.service.BlueStarApplyOfService;
@Service
public class BlueStarApplyOfServiceImp implements BlueStarApplyOfService{
	@Autowired
	BlueStarApplyOfMapper applydao;
	@Autowired
	BlueStarAuthorMapper authordao;
	@Override
	public int getApplyOfDao(BlueStarApplyfrom xxl) {
		xxl.setId(StringUtil.getUUID());
		xxl.setApplyOfDate(new Timestamp(System.currentTimeMillis()));
		return applydao.addApplyOf(xxl);
	}
	@Override
	public int setAudit(BlueStarAudit audit,BlueStarApplyfrom apply) {
		audit.setId(StringUtil.getUUID());
		audit.setApplyDate(new Timestamp(System.currentTimeMillis()));
		if(audit.getAuditStatus()=="01"){
			apply.setApplyOfStatus("1");
		}else if(audit.getAuditStatus()=="02"){
			apply.setApplyOfStatus("2");
		}
		apply.setId(audit.getApplyofId());//绑定申请id
		applydao.updataAgreement(apply); //更新申请状态
		return authordao.insertAudit(audit);//新增审批日志信息
	}
	@Override
	public List<BlueStarApplyfrom> getApplyOfData() {
		return  applydao.getApplyOfData();
	}
	@Override
	public List<BlueStarAudit> selectAllAuthor() {
		return authordao.getAllAuthor();
	}
	@Override
	public BlueStarApplyfrom applyofDetail(String id) {
		
		return applydao.getApplyOfDetail(id);
	}
	
}
