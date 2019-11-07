package com.xxl.api.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	@RequestMapping(value="/auth/addApplyof",method=RequestMethod.POST)
	@PermessionLimit(limit=false)
	public ReturnT<String> getApplyOf(@RequestBody BlueStarApplyfrom xxlApplyform){   //@RequestBody
		int applyOfDao = applyOfServiceImp.getApplyOfDao(xxlApplyform);
		return (applyOfDao>0)?ReturnT.SUCCESS:ReturnT.FAIL;
	}
	/**
	 * 审批流程，新增审批日志信息、更改申请状态
	 * @param audit
	 * @param apply
	 * @return
	 */
	@RequestMapping(value="/author/audit",method=RequestMethod.POST)
	@PermessionLimit(limit=false)
	public ReturnT<String> applyOfJudge(@RequestBody BlueStarAudit audit,BlueStarApplyfrom apply){
			applyOfServiceImp.setAudit(audit, apply);
		return (audit.getAuditStatus()=="01")?new ReturnT<String>(200,"申请通过"):new ReturnT<String>(500,"申请未通过:",audit.getBizComent());
	}
	/**
	 * 查询申请信息 可根据 id applyOfName applyOfStatus 动态查询
	 * @return
	 */
	@PostMapping("/applyof/applyofAll")
	@PermessionLimit(limit=false)
	public ReturnT<List> selectApplyOf(BlueStarApplyfrom apply){
		List<BlueStarApplyfrom> list = applyOfServiceImp.getApplyOfData(apply);
		if(list!=null&&!list.isEmpty()){
			return new ReturnT<List>(ReturnT.SUCCESS_CODE,"查询成功",list);
		}
		return new ReturnT<List>(ReturnT.FAIL_CODE,"查询失败");
	}
	
	/**
	 * 查询申请日志表 可根据id  auditor applyofId auditStatus 动态查询
	 * @return
	 */
	@PostMapping("/author/authorAllLog")
	@PermessionLimit(limit=false)
	public ReturnT<List> selectAllAuthor(BlueStarAudit audit){
		List<BlueStarAudit>	list = applyOfServiceImp.selectAllAuthor(audit);
		if(list!=null&&!list.isEmpty()){
			return new ReturnT<List>(ReturnT.SUCCESS_CODE,"查询成功",list);
		}
		return new ReturnT<List>(ReturnT.FAIL_CODE,"查询失败");
	}
}
