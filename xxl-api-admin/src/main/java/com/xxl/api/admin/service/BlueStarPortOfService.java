package com.xxl.api.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xxl.api.admin.core.model.BlueStarPort;
@Service
public interface BlueStarPortOfService {
	/***
	 * 获取节点信息
	 * @return
	 */
	List<BlueStarPort> getPort();

}
