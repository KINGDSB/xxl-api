package com.xxl.api.admin.dao;


import org.apache.ibatis.annotations.Mapper;

import com.xxl.api.admin.core.model.XxlApplyfrom;
@Mapper
public interface BlueStarApplyDao {
	int addApplyOf(XxlApplyfrom xxlApplyform);

}
