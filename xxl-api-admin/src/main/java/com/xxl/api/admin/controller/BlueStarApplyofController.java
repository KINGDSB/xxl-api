package com.xxl.api.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xxl.api.admin.controller.annotation.PermessionLimit;
import com.xxl.api.admin.core.model.ReturnT;
import com.xxl.api.admin.core.model.XxlApplyfrom;
import com.xxl.api.admin.service.BlueStarApplyOfServicev;

@RestController
public class BlueStarApplyofController {
	@Autowired
	BlueStarApplyOfServicev  applyOfService;
	@RequestMapping("/auth/applyof")
	@PermessionLimit(limit=false)
	public ReturnT<String> getApplyOf(XxlApplyfrom xxlApplyform){   //@RequestBody
		int applyOfDao = applyOfService.getApplyOfDao(xxlApplyform);
		return (applyOfDao>0)?ReturnT.SUCCESS:ReturnT.FAIL;
	}
}
