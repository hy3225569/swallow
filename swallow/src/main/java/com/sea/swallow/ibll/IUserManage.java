package com.sea.swallow.ibll;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.sea.swallow.model.ResultInfo;
import com.sea.swallow.model.UserModel;

/**
 * 用户管理接口
 * @author Administrator
 *
 */
public interface IUserManage {
	/**
	 * 获取所有用户集合(含条件 map)
	 * @return
	 */
   List<UserModel> GetAllUserInfo(Map<String,Object> map);
   /**
    * 用户注册
    * @param user
    * @return
    */
   ResultInfo<String> userRegister(UserModel user,HttpServletRequest request);
   
   /**
    * 用户登录
    * @param map
    * @return
    */
   ResultInfo<UserModel> userLogin(Map<String,Object> map,HttpServletRequest request); 
}
