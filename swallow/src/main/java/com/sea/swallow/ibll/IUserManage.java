package com.sea.swallow.ibll;

import java.util.List;
import java.util.Map;

import com.sea.swallow.model.ResultInfo;
import com.sea.swallow.model.UserModel;

/**
 * 用户管理接口
 * @author Administrator
 *
 */
public interface IUserManage {
	/**
	 * 获取所有用户集合
	 * @return
	 */
   List<UserModel> GetAllUserInfo();
   /**
    * 用户注册
    * @param user
    * @return
    */
   ResultInfo<String> userRegister(UserModel user);
   
   /**
    * 用户登录
    * @param map
    * @return
    */
   ResultInfo<UserModel> userLogin(Map<String,Object> map); 
}
