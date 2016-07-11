package com.sea.swallow.bll;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sea.swallow.dal.MyPageMapper;
import com.sea.swallow.ibll.IMainService;
import com.sea.swallow.model.ResultInfo;
import com.sea.swallow.model.UserRelationInfo;

@Service("mainService")
public class MainImpl implements IMainService {

	@Resource(name="myPageMapper")
	private MyPageMapper myPageMapper;
	/**
	 * 获取某用户的所有朋友信息
	 */
	@Override
	public ResultInfo<List<UserRelationInfo>> getFriendListByParams(Map<String, Object> map) {
		try {
			return new ResultInfo<List<UserRelationInfo>>(0,"获取成功",myPageMapper.selectFriend(map));
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultInfo<List<UserRelationInfo>>(-1,"服务器出现异常",null);
		}
	}

}
