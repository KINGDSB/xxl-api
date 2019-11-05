package com.xxl.api.admin.dao;

import org.apache.ibatis.annotations.Mapper;

import com.xxl.api.admin.core.model.BlueStarAudit;
@Mapper
public interface BlueStarAuthorMapper {
	/**
	 * 审批记录表
	 * @param audit
	 * @return
	 */
	int insertAudit(BlueStarAudit audit);

}