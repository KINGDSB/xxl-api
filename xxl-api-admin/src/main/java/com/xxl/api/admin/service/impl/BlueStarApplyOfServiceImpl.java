package com.xxl.api.admin.service.impl;


import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxl.api.admin.core.model.BlueStarAuditDTO;
import com.xxl.api.admin.core.util.StringUtil;
import com.xxl.api.admin.core.model.BlueStarApplyfromDTO;
import com.xxl.api.admin.dao.BlueStarApplyOfMapper;
import com.xxl.api.admin.dao.BlueStarAuthorMapper;
import com.xxl.api.admin.service.BlueStarApplyOfService;
@Service
public class BlueStarApplyOfServiceImpl implements BlueStarApplyOfService{
	@Autowired
	BlueStarApplyOfMapper applydao;
	@Autowired
	BlueStarAuthorMapper authordao;
	@Override
	public int getApplyOfDao(BlueStarApplyfromDTO xxl) {
		xxl.setId(StringUtil.getUUID());
		xxl.setApplyOfDate(new Timestamp(System.currentTimeMillis()));
		return applydao.addApplyOf(xxl);
	}
	@Override
	public int setAudit(BlueStarAuditDTO audit,BlueStarApplyfromDTO apply) {
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
	public List<BlueStarApplyfromDTO> getApplyOfData(BlueStarApplyfromDTO apply) {
		return  applydao.getApplyOfData(apply);
	}
	@Override
	public List<BlueStarAuditDTO> selectAllAuthor(BlueStarAuditDTO audit) {
		return authordao.getAllAuthor(audit);
	}
}
