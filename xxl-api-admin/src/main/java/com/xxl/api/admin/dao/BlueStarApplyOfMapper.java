package com.xxl.api.admin.dao;


import org.apache.ibatis.annotations.Mapper;

import com.xxl.api.admin.core.model.BlueStarAudit;
import com.xxl.api.admin.core.model.BlueStarApplyfrom;
@Mapper
public interface BlueStarApplyOfMapper {
	/**
	 * 新增申请
	 * @param xxlApplyform
	 * @return
	 */
	int addApplyOf(BlueStarApplyfrom xxlApplyform);
	/**
	 * 更新申请状态信息
	 * @param apply 
	 */
	void updataAgreement(BlueStarApplyfrom apply);

}
