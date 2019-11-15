package com.xxl.api.admin.service;



import java.util.List;

import org.springframework.stereotype.Service;

import com.xxl.api.admin.config.PageUtil;
import com.xxl.api.admin.core.model.BlueStarApplyfromDTO;
import com.xxl.api.admin.core.model.BlueStarAuditDTO;
import com.xxl.api.admin.core.model.ReturnT;

@Service
public interface BlueStarApplyOfService {
	/**
	 * 申请项目、接口
	 * @param xdp
	 * @return
	 */
	int getApplyOfDao(BlueStarApplyfromDTO xxl);
	/**
	 * 审批接口
	 * @param xdp
	 * @return
	 */
	int setAudit(BlueStarAuditDTO audit, BlueStarApplyfromDTO apply);
	/**
	 * 查询所有申请信息
	 * 可根据 id applyOfName applyOfStatus 动态查询
	 * @return
	 */
//	List<BlueStarApplyfromDTO> getApplyOfData(BlueStarApplyfromDTO apply);
	List<BlueStarApplyfromDTO> getApplyOfData(BlueStarApplyfromDTO apply, PageUtil page);
	/**
	 * 查询所有审批记录
	 * @return
	 */
	List<BlueStarAuditDTO> selectAllAuthor(BlueStarAuditDTO audit);
    

	


}
