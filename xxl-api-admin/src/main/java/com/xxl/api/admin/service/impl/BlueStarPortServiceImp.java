package com.xxl.api.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxl.api.admin.core.model.BlueStarPort;
import com.xxl.api.admin.dao.BlueStarPortMapper;

import com.xxl.api.admin.service.BlueStarPortOfService;
@Service
public class BlueStarPortServiceImp implements BlueStarPortOfService{
	@Autowired
	BlueStarPortMapper blueStarPortDao;
	@Override
	public List<BlueStarPort> getPort() {
	return blueStarPortDao.getPort();
	}
}
