package com.sea.swallow.ibll;
import java.util.List;
import java.util.Map;

import com.sea.swallow.model.ResultInfo;
import com.sea.swallow.model.UserRelationInfo;

public interface IMainService {
	/**
	 * 获取朋友列表
	 * @return
	 */
   ResultInfo<List<UserRelationInfo>> getFriendListByParams(Map<String,Object> map);
}
