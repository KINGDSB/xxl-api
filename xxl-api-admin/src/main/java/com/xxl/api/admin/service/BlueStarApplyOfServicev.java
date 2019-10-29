package com.xxl.api.admin.service;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
		return applydao.addApplyOf(xxl);
	}

}
