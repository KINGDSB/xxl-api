package com.xxl.api.admin.service;

import com.xxl.api.admin.core.model.BlueStarUserProfileDTO;
import com.xxl.api.admin.core.model.XxlApiUser;

public interface BlueStarUserService {
	/**
	 * 完善用户信息
	 * 根据user id判断更新还是添加
	 * @param profile
	 * @return
	 */
	int UserProfile(XxlApiUser user, BlueStarUserProfileDTO profile);
	
}
