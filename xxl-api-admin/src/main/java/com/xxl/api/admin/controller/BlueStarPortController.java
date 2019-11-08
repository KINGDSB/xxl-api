package com.xxl.api.admin.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xxl.api.admin.controller.annotation.PermessionLimit;
import com.xxl.api.admin.core.model.BlueStarPortDTO;
import com.xxl.api.admin.core.model.ReturnT;
import com.xxl.api.admin.service.impl.BlueStarPortServiceImp;

@RestController
public class BlueStarPortController {
	/**
	 * 查询接口信息
	 */
	@Autowired
	BlueStarPortServiceImp blueStarPortServiceImp;
	@PostMapping("/auth/getPort")
	@PermessionLimit(limit=false)
	public ReturnT<List> getPort(BlueStarPortDTO port){
			List<BlueStarPortDTO> list = blueStarPortServiceImp.getPort(port);
			if(list!=null&&!list.isEmpty()){
			return new ReturnT<List>(ReturnT.SUCCESS_CODE,"查询成功",list);
		}else{
			return new ReturnT<List>(ReturnT.FAIL_CODE,"查询失败");
		}
	}
}
