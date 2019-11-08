package com.xxl.api.admin.controller;

import com.xxl.api.admin.controller.annotation.PermessionLimit;
import com.xxl.api.admin.core.model.ReturnT;
import com.xxl.api.admin.core.model.XxlApiUser;

import com.xxl.api.admin.dao.IXxlApiUserDao;
import com.xxl.api.admin.dto.LoginDTO;
import com.xxl.api.admin.service.impl.LoginService;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * index controller
 * @author xuxueli 2015-12-19 16:13:16
 */
@RestController
public class IndexController {

	@Resource
	private LoginService loginService;
	@Resource
	private IXxlApiUserDao xxlApiUserDao;

	@RequestMapping("/")
	@PermessionLimit(limit=false)
	/*
	 * 原返回值String
	 */
	public ReturnT<String> index(Model model, HttpServletRequest request) {
		XxlApiUser loginUser = loginService.ifLogin(request);
		if (loginUser == null) {

//			return "redirect:/toLogin";
			return new ReturnT<String>(ReturnT.FAIL_CODE,"跳转至登陆");
		}
//		return "redirect:/project";
		return new ReturnT<String>(ReturnT.SUCCESS_CODE,"进入项目");
	}

	@RequestMapping("/toLogin")
	@PermessionLimit(limit=false)

	  //原返回值String

	public ReturnT<String> toLogin(Model model, HttpServletRequest request) {
		XxlApiUser loginUser = loginService.ifLogin(request);
		if (loginUser != null) {
//			return "redirect:/";
			return new ReturnT<String>(ReturnT.SUCCESS_CODE,"重复登陆，跳转至是否登陆");
		}
//		return "login";
		return new ReturnT<String>(ReturnT.FAIL_CODE,"当前无用户登陆，跳转至登陆");
	}

	@RequestMapping(value="login", method=RequestMethod.POST)
	@PermessionLimit(limit=false)
	public ReturnT<String> loginDo(@RequestBody LoginDTO dto){
		// do login
		ReturnT<String> loginRet = loginService.login(dto);
		return loginRet;
	}

	@RequestMapping(value="test", method=RequestMethod.GET)
	@ResponseBody
	@PermessionLimit(limit=false)
	public String test(String str){
		System.out.println("test");
		return "test:"+str;
	}

	@RequestMapping(value="logout", method=RequestMethod.POST)
//	@ResponseBody
	@PermessionLimit(limit=false)
	public ReturnT<String> logout(HttpServletRequest request, HttpServletResponse response){
		loginService.logout(request, response);
		return ReturnT.SUCCESS;
	}

	@RequestMapping("/help")
	@PermessionLimit(limit=false)
	public ReturnT<String> help() {
		return new ReturnT<String>(ReturnT.SUCCESS_CODE,"请求转发到帮助页面");
	}
	/**
	 * 注册
	 * @param xxlApiUser
	 * @return
	 */
	@RequestMapping("/auth/register")
	@PermessionLimit(limit=false)
//	@ResponseBody
	public ReturnT<String> Register(@RequestBody XxlApiUser xxlApiUser){
		// valid
		XxlApiUser existUser = xxlApiUserDao.findByUserName(xxlApiUser.getUserName());
		if (existUser != null) {
			return new ReturnT<String>(ReturnT.FAIL_CODE, "“登录账号”重复，请更换");
		}else{
			// passowrd md5
			xxlApiUser.setPermissionBiz("1");
			String md5Password = DigestUtils.md5DigestAsHex(xxlApiUser.getPassword().getBytes());
			xxlApiUser.setPassword(md5Password);
			int ret = xxlApiUserDao.add(xxlApiUser);
			return (ret>0)?ReturnT.SUCCESS:ReturnT.FAIL;
		}
	}
}
