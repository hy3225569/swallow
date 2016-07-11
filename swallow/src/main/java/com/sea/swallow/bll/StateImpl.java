package com.sea.swallow.bll;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.sea.swallow.common.JsonUtils;
import com.sea.swallow.dal.StateMapper;
import com.sea.swallow.ibll.IStateService;
import com.sea.swallow.model.ArticleModel;
import com.sea.swallow.model.ResultInfo;
import com.sea.swallow.model.StateModel;
import com.sea.swallow.model.UserModel;

@Service("stateService")
public class StateImpl implements IStateService {
	@Resource(name="stateMapper")
    private StateMapper stateMapper;

	/**
	 * 查询动态
	 */
	@Override
	public ResultInfo<List<StateModel>> getStatusByParames(Map<String, Object> map) {
		
		try {
			return new ResultInfo<List<StateModel>>(0,"",stateMapper.selectStateList(map));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 更新动态
	 */
	@Override
	public ResultInfo<String> updateStatus(HttpServletRequest request) {
		try {
			String data = request.getParameter("data");
			StateModel model = new StateModel();
			if (data != null) {
				model = JsonUtils.readValue(data, StateModel.class);
				model.setUserId(0);
				if (request.getSession().getAttribute("user") != null) {
					model.setUserId(((UserModel) request.getSession().getAttribute("user")).getUserId());
				}
				if (stateMapper.insertState(model) > 0) {
					return new ResultInfo<String>(0, "更新成功!", "");
				}
				return new ResultInfo<String>(-1, "更新失败!", "");
			} else {
				return new ResultInfo<String>(-1, "参数有误!", "");
			}

		} catch (Exception e) {
			e.printStackTrace();
			return new ResultInfo<String>(-1, "服务器有异常!", "");
		}
	}
	
}
