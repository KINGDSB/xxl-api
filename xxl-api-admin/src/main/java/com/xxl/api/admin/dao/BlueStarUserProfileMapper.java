package com.xxl.api.admin.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.xxl.api.admin.core.model.BlueStarUserProfileDTO;

@Mapper
public interface BlueStarUserProfileMapper {
	/**
     * 完善用户信息
     * @param user
     * @param profile
     * @return
     */
	int addUserProfile(BlueStarUserProfileDTO profile);
	/**
	 * 更新用户信息
	 * @param profile
	 * @return
	 */
	int updateProfile(BlueStarUserProfileDTO profile);
	/**
	 * 查询userId是否重复
	 * @param userId
	 * @return
	 */
	BlueStarUserProfileDTO existProfileUserId(@Param(value = "userId") String userId);
	

}
