package com.sea.swallow.ibll;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.sea.swallow.model.ResultInfo;
import com.sea.swallow.model.UserModel;
import com.sea.swallow.model.UserRelationInfo;

public interface IMainService {
	/**
	 * 获取朋友列表
	 * @return
	 */
   ResultInfo<List<UserRelationInfo>> getFriendListByParams(Map<String,Object> map);
   
   /**
    * 更新用户信息
    * @param model
    * @return
    */
   ResultInfo<String> editUserInfo(HttpServletRequest request);
}
