package com.xxl.api.admin.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xxl.api.admin.controller.annotation.PermessionLimit;
import com.xxl.api.admin.core.model.BlueStarPortDTO;
import com.xxl.api.admin.core.model.ReturnT;
import com.xxl.api.admin.service.impl.BlueStarPortServiceImpl;

@RestController
public class BlueStarPortController {
	/**
	 * 查询接口信息
	 */
	@Autowired
	BlueStarPortServiceImpl blueStarPortServiceImp;
	@PostMapping("/auth/getPort")
	@PermessionLimit(limit=false)
	public ReturnT<List> getPort(BlueStarPortDTO port){
			List<BlueStarPortDTO> list = blueStarPortServiceImp.getPort(port);
			if(list!=null&&!list.isEmpty()){
			return new ReturnT<List>(ReturnT.SUCCESS_CODE,ReturnT.SELECT_SUCCESS,list);
		}else{
			return new ReturnT<List>(ReturnT.FAIL_CODE,ReturnT.SELECT_FAIL);
		}
	}
}
