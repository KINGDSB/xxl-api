package com.xxl.api.admin.dao;



import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.xxl.api.admin.core.model.BlueStarPort;
@Mapper
public interface BlueStarPortMapper {

	List<BlueStarPort> getPort();

}
