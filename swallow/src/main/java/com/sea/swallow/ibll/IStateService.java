package com.sea.swallow.ibll;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.sea.swallow.model.FriendStateModel;
import com.sea.swallow.model.ResultInfo;
import com.sea.swallow.model.StateModel;

public interface IStateService {
   
	/**
	 * 根据条件查询动态,条件可选,map字典控制
	 * @return
	 */
	ResultInfo<List<StateModel>> getStatusByParames(Map<String,Object> map);
    /**
     * 更新动态
     * @param state
     * @return
     */
	ResultInfo<String> updateStatus(HttpServletRequest request);
	
	/**
	 * 查询好友动态
	 * @return
	 */
	ResultInfo<List<FriendStateModel>> getFriendStatusList(Map<String,Object> map);
}
