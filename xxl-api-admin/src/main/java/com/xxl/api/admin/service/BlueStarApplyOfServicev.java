package com.xxl.api.admin.service;

import java.sql.Date;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxl.api.admin.core.model.BlueStarAudit;
import com.xxl.api.admin.core.model.XxlApplyfrom;
import com.xxl.api.admin.dao.BlueStarApplyDao;
@Service
public class BlueStarApplyOfServicev {
	@Autowired
	BlueStarApplyDao applydao;
	public int getApplyOfDao(XxlApplyfrom xxl) {
		xxl.setApplyOfStatus(1);
//		Date a =new Date(0);
//		int date = a.getDate();
//		xxl.setApplyOfDate(""+date);
//		xxl.setApplyOfName("zs");
//		xxl.setApplyOfProjectName("sb");
//		xxl.setApplyOfProt("支付");
		xxl.setApplyOfDate(new Timestamp(System.currentTimeMillis()));
		return applydao.addApplyOf(xxl);
	}
	public int setAudit(BlueStarAudit audit) {
		//获取当前时间
//		audit.setApplyOfId(1);
//		audit.setAuditor("测试");
//		audit.setBizComent("通过");
		audit.setApplyDate(new Timestamp(System.currentTimeMillis()));
		if(audit.getAuditStatus()==1){
			applydao.setAgreement();
		}
		return applydao.updataAudit(audit);
	}
}
