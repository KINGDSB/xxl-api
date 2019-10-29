package com.xxl.api.admin.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xxl.api.admin.controller.annotation.PermessionLimit;
import com.xxl.api.admin.core.model.BlueStarPort;
import com.xxl.api.admin.core.model.ReturnT;
import com.xxl.api.admin.service.BlueStarPortService;

@RestController
public class BlueStarPortController {
	@Autowired
	BlueStarPortService blueStarPortService;
	@RequestMapping("/auth/getPort")
	@PermessionLimit(limit=false)
	public ReturnT<List> getPort(){
		if(blueStarPortService.getPort()!=null){
			List<BlueStarPort> list = blueStarPortService.getPort();
			  
			return new ReturnT<List>(ReturnT.SUCCESS_CODE,"查询成功",list);
		}else{
			return new ReturnT<List>(ReturnT.FAIL_CODE,"查询失败",null);
		}
	}
}
