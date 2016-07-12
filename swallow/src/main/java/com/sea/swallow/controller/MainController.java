package com.sea.swallow.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sea.swallow.ibll.IMainService;
import com.sea.swallow.model.ResultInfo;
import com.sea.swallow.model.UserModel;
import com.sea.swallow.model.UserRelationInfo;

@Controller
@RequestMapping("/main")
public class MainController {
  
	@Resource(name="mainService")
	private IMainService mainService;
	
	 @RequestMapping("/friendlist")
	 @ResponseBody
     public ResultInfo<List<UserRelationInfo>> getFriendInfo(HttpServletRequest request)
     {
		HashMap<String, Object> map = new HashMap<>();
		try {
			if (request.getSession().getAttribute("user") != null) {
				map.put("userId", ((UserModel) request.getSession().getAttribute("user")).getUserId());
				return mainService.getFriendListByParams(map);
			}
			return new ResultInfo<List<UserRelationInfo>>(-1, "你还未登录!", null);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
     }
	 
	 /**
		 *  更新用户信息
		 * 
		 * @param request
		 * @return
		 */
		@RequestMapping("/updateuserinfo")
		@ResponseBody
		public ResultInfo<String> updateUserInfo(HttpServletRequest request) {
			try {
				return mainService.editUserInfo(request);
			} catch (Exception e) {
				return new ResultInfo<String>(-1, "服务器请求失败", "");
			}
		}
}
