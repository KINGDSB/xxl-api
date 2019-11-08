package com.xxl.api.admin.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xxl.api.admin.core.model.BlueStarUserProfileDTO;
import com.xxl.api.admin.core.model.XxlApiUser;
import com.xxl.api.admin.core.util.StringUtil;
import com.xxl.api.admin.dao.BlueStarUserProfileMapper;
import com.xxl.api.admin.dao.IXxlApiUserDao;
import com.xxl.api.admin.service.BlueStarUserService;

@Service
public class BlueStarUserServiceImp implements BlueStarUserService {
	@Resource
	private BlueStarUserProfileMapper userProfileMapper;
	@Resource
	private IXxlApiUserDao xxlApiUserDao;

	@Override
	public int UserProfile(XxlApiUser user, BlueStarUserProfileDTO profile) {
		user.setPid(profile.getUserId());
		// profile.setUserId(user.getId());
		BlueStarUserProfileDTO existProfile = userProfileMapper.existProfileUserId(profile.getUserId());
		// XxlApiUser existUser = xxlApiUserDao.findByPid(user.getPid());
		if (existProfile != null) {
			userProfileMapper.updateProfile(profile);
			return 400;
		} else {
			profile.setUserId(StringUtil.getUUID());
			xxlApiUserDao.setPid(user);
			userProfileMapper.addUserProfile(profile);
			return 200;
		}
	}
}
