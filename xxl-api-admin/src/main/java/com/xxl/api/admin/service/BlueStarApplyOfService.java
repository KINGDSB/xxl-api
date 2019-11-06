package com.xxl.api.admin.service;



import java.util.List;

import org.springframework.stereotype.Service;

import com.xxl.api.admin.core.model.BlueStarApplyfrom;
import com.xxl.api.admin.core.model.BlueStarAudit;
import com.xxl.api.admin.core.model.ReturnT;

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
	/**
	 * 查询所有申请信息
	 * @return
	 */
	List<BlueStarApplyfrom> getApplyOfData();
	/**
	 * 查询所有审批记录
	 * @return
	 */
	List<BlueStarAudit> selectAllAuthor();
	/**
	 * 查询申请详情
	 * @param id
	 * @return
	 */
	BlueStarApplyfrom applyofDetail(String id);


}
