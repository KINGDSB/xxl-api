package com.xxl.api.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.xxl.api.admin.core.model.BlueStarAuditDTO;
@Mapper
public interface BlueStarAuthorMapper {
	/**
	 * 审批记录表
	 * @param audit
	 * @return
	 */
	int insertAudit(BlueStarAuditDTO audit);
	/**
	 * 查询所有审批记录日志信息
	 * @param audit 
	 * @return
	 */
	List<BlueStarAuditDTO> getAllAuthor(BlueStarAuditDTO audit);

}
