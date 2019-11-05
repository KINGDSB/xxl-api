package com.xxl.api.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
	/**
	 * 查询申请信息
	 * @return
	 */
	@PostMapping("/applyof/selectAllApplyof")
	@PermessionLimit(limit=false)
	public ReturnT<List> selectApplyOf(){
		if(applyOfServiceImp.getApplyOfData()!=null){
			List<BlueStarApplyfrom> list = applyOfServiceImp.getApplyOfData();
			return new ReturnT<List>(ReturnT.SUCCESS_CODE,"查询成功",list);
		}else{
			return new ReturnT<List>(ReturnT.FAIL_CODE,"查询失败",null);
		}
	}
	/**
	 * 查询申请日志表
	 * @return
	 */
	@PostMapping("/author/selectAllAuthor")
	@PermessionLimit(limit=false)
	public ReturnT<List> selectAllAuthor(){
		if(applyOfServiceImp.selectAllAuthor()!=null){
			List<BlueStarAudit>	authorList = applyOfServiceImp.selectAllAuthor();
			return new ReturnT<List>(ReturnT.SUCCESS_CODE,"查询成功",authorList);
		}else{
			return new ReturnT<List>(ReturnT.FAIL_CODE,"查询失败",null);
		}
		
	}
}
