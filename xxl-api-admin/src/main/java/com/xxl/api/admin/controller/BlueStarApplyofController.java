package com.xxl.api.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xxl.api.admin.controller.annotation.PermessionLimit;
import com.xxl.api.admin.core.model.BlueStarAudit;
import com.xxl.api.admin.core.model.ReturnT;
import com.xxl.api.admin.service.impl.BlueStarApplyOfServiceImp;
import com.xxl.api.admin.core.model.BlueStarApplyfrom;

@RestController
public class BlueStarApplyofController {
	@Autowired
	BlueStarApplyOfServiceImp  applyOfServiceImp;
	/**
	 * 新增申请信息
	 * @param xxlApplyform
	 * @return
	 */
	@RequestMapping(value="/auth/applyof",method=RequestMethod.POST)
	@PermessionLimit(limit=false)
	public ReturnT<String> getApplyOf(@RequestBody BlueStarApplyfrom xxlApplyform){   //@RequestBody
		int applyOfDao = applyOfServiceImp.getApplyOfDao(xxlApplyform);
		String applyOfName = xxlApplyform.getApplyOfName();
		System.out.println(applyOfName);
		return (applyOfDao>0)?ReturnT.SUCCESS:ReturnT.FAIL;
	}
	/**
	 * 申请日志信息，更改申请状态
	 * @param audit
	 * @param apply
	 * @return
	 */
	@RequestMapping(value="/applyof/audit",method=RequestMethod.POST)
	@PermessionLimit(limit=false)
	public ReturnT<String> applyOfJudge(@RequestBody BlueStarAudit audit,BlueStarApplyfrom apply){
			applyOfServiceImp.setAudit(audit, apply);
		return (audit.getAuditStatus()=="01")?new ReturnT<String>(200,"申请通过"):new ReturnT<String>(500,"申请未通过:",audit.getBizComent());
	}
}
