package com.xxl.api.admin.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.xxl.api.admin.core.model.BlueStarAuditDTO;
import com.xxl.api.admin.core.model.BlueStarApplyfromDTO;
@Mapper
public interface BlueStarApplyOfMapper {
	/**
	 * 新增申请
	 * @param xxlApplyform
	 * @return
	 */
	int addApplyOf(BlueStarApplyfromDTO xxlApplyform);
	/**
	 * 更新申请状态信息
	 * @param apply 
	 */
	void updataAgreement(BlueStarApplyfromDTO apply);
	/**
	 * 查询所有申请
	 * 可根据 id applyOfName applyOfStatus 动态查询
	 * @param apply 
	 */
	List<BlueStarApplyfromDTO> getApplyOfData(BlueStarApplyfromDTO apply);
	
}
