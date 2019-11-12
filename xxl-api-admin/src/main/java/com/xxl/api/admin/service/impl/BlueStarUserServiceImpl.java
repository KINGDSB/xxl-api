package com.xxl.api.admin.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xxl.api.admin.core.model.BlueStarUserProfileDTO;
import com.xxl.api.admin.core.model.ReturnT;
import com.xxl.api.admin.core.model.XxlApiUser;
import com.xxl.api.admin.core.util.StringUtil;
import com.xxl.api.admin.dao.BlueStarUserProfileMapper;
import com.xxl.api.admin.dao.IXxlApiUserDao;
import com.xxl.api.admin.service.BlueStarUserService;

@Service
public class BlueStarUserServiceImpl implements BlueStarUserService {
	@Resource
	private BlueStarUserProfileMapper userProfileMapper;
	@Resource
	private IXxlApiUserDao xxlApiUserDao;

	@Override
	public int UserProfile(XxlApiUser user, BlueStarUserProfileDTO profile) {
		/* 判断userId是否存在 存在就更新 否则就新增并绑定user表*/
		BlueStarUserProfileDTO existProfile = userProfileMapper.existProfileUserId(profile.getUserId());
		if (existProfile != null) {
			userProfileMapper.updateProfile(profile);
			return ReturnT.UPDARE_CODE;
		} else {
			profile.setUserId(StringUtil.getUUID());
			user.setPid(profile.getUserId());
			xxlApiUserDao.setPid(user);
			userProfileMapper.addUserProfile(profile);
			return ReturnT.INSERT_CODE;
		}
	}
}
