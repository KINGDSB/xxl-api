package com.xxl.api.admin.service;



import org.springframework.stereotype.Service;

import com.xxl.api.admin.core.model.BlueStarApplyfrom;
import com.xxl.api.admin.core.model.BlueStarAudit;

@Service
public interface BlueStarApplyOfService {
	/**
	 * 申请项目、接口
	 * @param xdp
	 * @return
	 */
	int getApplyOfDao(BlueStarApplyfrom xxl);
	/**
	 * 审批接口
	 * @param xdp
	 * @return
	 */
	int setAudit(BlueStarAudit audit, BlueStarApplyfrom apply);


}
