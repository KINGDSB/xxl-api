package com.xxl.api.admin.service.impl;


import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.xxl.api.admin.core.model.BlueStarAudit;
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
		audit.setApplyofId(apply.getId());//绑定申请id?
		applydao.updataAgreement(); //更新申请状态
		return authordao.insertAudit(audit);//新增审批日志信息
	}
}
