package com.xxl.api.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxl.api.admin.core.model.BlueStarPort;
import com.xxl.api.admin.dao.BlueStarPortDao;
@Service
public class BlueStarPortService {
	@Autowired
	BlueStarPortDao blueStarPortDao;
	public List<BlueStarPort> getPort() {
	return blueStarPortDao.getPort();
	}

}
