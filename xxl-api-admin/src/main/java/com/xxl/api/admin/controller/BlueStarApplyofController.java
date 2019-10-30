package com.xxl.api.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xxl.api.admin.controller.annotation.PermessionLimit;
import com.xxl.api.admin.core.model.BlueStarAudit;
import com.xxl.api.admin.core.model.ReturnT;
import com.xxl.api.admin.core.model.XxlApplyfrom;
import com.xxl.api.admin.service.BlueStarApplyOfServicev;

@RestController
public class BlueStarApplyofController {
	@Autowired
	BlueStarApplyOfServicev  applyOfService;
	@RequestMapping(value="/auth/applyof",method=RequestMethod.POST)
	@PermessionLimit(limit=false)
	public ReturnT<String> getApplyOf(@RequestBody XxlApplyfrom xxlApplyform){   //@RequestBody
		int applyOfDao = applyOfService.getApplyOfDao(xxlApplyform);
		String applyOfName = xxlApplyform.getApplyOfName();
		System.out.println(applyOfName);
		return (applyOfDao>0)?ReturnT.SUCCESS:ReturnT.FAIL;
	}
	@RequestMapping(value="/applyof/audit",method=RequestMethod.POST)
	@PermessionLimit(limit=false)
	public ReturnT<String> applyOfJudge(@RequestBody BlueStarAudit audit){
		int setAudit = applyOfService.setAudit(audit);
		return (setAudit>0)?ReturnT.SUCCESS:ReturnT.FAIL;
	}
}
