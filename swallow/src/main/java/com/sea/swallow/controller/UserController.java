package com.sea.swallow.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sea.swallow.ibll.IUserManage;
import com.sea.swallow.model.UserModel;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource(name="userManageService")
	private IUserManage userManageService;
	
	/**
	 * 获取用户信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/userlist",method=RequestMethod.GET)
	@ResponseBody
	public List<UserModel> GetUserInfo(HttpServletRequest request)
	{
		try {
			return userManageService.GetAllUserInfo();
		} catch (Exception e) {
			return new ArrayList<UserModel>();
		}
		
	}
}
