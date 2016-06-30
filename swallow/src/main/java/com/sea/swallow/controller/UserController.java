package com.sea.swallow.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sea.swallow.common.JsonUtils;
import com.sea.swallow.ibll.IUserManage;
import com.sea.swallow.model.ResultInfo;
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
			if(request.getSession().getAttribute("user")==null){
				return null;
			}
			return userManageService.GetAllUserInfo();
		} catch (Exception e) {
			return new ArrayList<UserModel>();
		}
		
	}
	/**
	 * 用户注册
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/userregiste",method=RequestMethod.POST)
	@ResponseBody
	public ResultInfo<String> userRegister(HttpServletRequest request)
	{
		try {
			String data=request.getParameter("data");
			UserModel user=JsonUtils.readValue(data, UserModel.class);
			return userManageService.userRegister(user,request);
		} catch (Exception e) {
			return new ResultInfo<String>(-1,"服务器错误!","");
		}
	}
	/**
	 * 用户登录
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/userlogin",method=RequestMethod.POST)
	@ResponseBody
	public ResultInfo<UserModel> userLogin(HttpServletRequest request)
	{
		try {
			String userName=request.getParameter("userName")==null?"":request.getParameter("userName");
			String userPass=request.getParameter("userPass")==null?"":request.getParameter("userPass");
			HashMap<String,Object> map=new HashMap<>();
			map.put("userName", userName);
			map.put("userPass", userPass);
			return userManageService.userLogin(map,request);
		} catch (Exception e) {
			return new ResultInfo<UserModel>(-1,"服务器错误!",null);
		}
	}
}
