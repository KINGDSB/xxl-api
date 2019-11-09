package com.xxl.api.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxl.api.admin.core.model.BlueStarPortDTO;
import com.xxl.api.admin.dao.BlueStarPortMapper;

import com.xxl.api.admin.service.BlueStarPortOfService;
@Service
public class BlueStarPortServiceImpl implements BlueStarPortOfService{
	@Autowired
	BlueStarPortMapper blueStarPortDao;
	@Override
	public List<BlueStarPortDTO> getPort(BlueStarPortDTO port) {
	return blueStarPortDao.getPort(port);
	}
}
