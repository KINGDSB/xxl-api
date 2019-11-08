package com.xxl.api.admin.dao;



import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.xxl.api.admin.core.model.BlueStarPortDTO;
@Mapper
public interface BlueStarPortMapper {
	/**
	 * 获取接口信息
	 * @param port
	 * @return
	 */
	List<BlueStarPortDTO> getPort(BlueStarPortDTO port);

}
