package com.sea.swallow.bll;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.sea.swallow.common.JsonUtils;
import com.sea.swallow.dal.MyPageMapper;
import com.sea.swallow.ibll.IMainService;
import com.sea.swallow.model.ResultInfo;
import com.sea.swallow.model.UserModel;
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
	/**
	 * 更新用户信息
	 */
	@Override
	public ResultInfo<String> editUserInfo(HttpServletRequest request) {
		try {
			String data = request.getParameter("data");
			if (data != null) {
				UserModel model = JsonUtils.readValue(data, UserModel.class);
				if (request.getSession().getAttribute("user") != null) {
					model.setUserId(((UserModel) request.getSession().getAttribute("user")).getUserId());
					return myPageMapper.updateUserInfo(model) > 0 ? new ResultInfo<String>(0, "更新成功", "")
							: new ResultInfo<String>(-1, "更新失败", "");
				} else {
					return new ResultInfo<String>(-1, "更新失败", "");
				}
			} else {
				return new ResultInfo<String>(-1, "参数错误", "");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultInfo<String>(-1, "服务器异常", "");
		}
		
	}

}
