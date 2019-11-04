package com.xxl.api.admin.dao;


import org.apache.ibatis.annotations.Mapper;

import com.xxl.api.admin.core.model.BlueStarAudit;
import com.xxl.api.admin.core.model.BlueStarApplyfrom;
@Mapper
public interface BlueStarApplyOfMapper {
	int addApplyOf(BlueStarApplyfrom xxlApplyform);

	void updataAgreement();

}
