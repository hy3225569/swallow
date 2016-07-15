package com.sea.swallow.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sea.swallow.bll.ArticleManage;
import com.sea.swallow.common.JsonUtils;
import com.sea.swallow.ibll.ICommentService;
import com.sea.swallow.ibll.IStateService;
import com.sea.swallow.model.CommentModel;
import com.sea.swallow.model.FriendArticleModel;
import com.sea.swallow.model.FriendStateModel;
import com.sea.swallow.model.ResultInfo;
import com.sea.swallow.model.UserModel;

@Controller
@RequestMapping("/activity")
public class ActivityController {
	
	@Resource(name="articleService")
    private ArticleManage articleService;
	
	@Resource(name="stateService")
    private IStateService stateService;
	
	@Resource(name="commentService")
	private ICommentService commentService;
	/**
	 * 获取所有好友的文章列表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/friendarticle")
	@ResponseBody
	public ResultInfo<List<FriendArticleModel>> getArticleListByLoginUser(HttpServletRequest request) {
		try {
			if (request.getSession().getAttribute("user") != null) {
				HashMap<String, Object> map = new HashMap<>();
				map.put("userId", ((UserModel) request.getSession().getAttribute("user")).getUserId());
				return articleService.getFriendArticleList(map);
			}
			return new ResultInfo<List<FriendArticleModel>>(-1, "用户未登录", null);
		} catch (Exception e) {
			return new ResultInfo<List<FriendArticleModel>>(-1, "请求失败,服务器出现异常", null);
		}
	}
	/**
	 * 获取好友状态
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/friendState")
	@ResponseBody
	public ResultInfo<List<FriendStateModel>> getFriendStateList(HttpServletRequest request) {
		try {
			if (request.getSession().getAttribute("user") != null) {
				HashMap<String, Object> map = new HashMap<>();
				map.put("userId", ((UserModel) request.getSession().getAttribute("user")).getUserId());
				return stateService.getFriendStatusList(map);
			}
			return new ResultInfo<List<FriendStateModel>>(-1, "用户未登录", null);
		} catch (Exception e) {
			return new ResultInfo<List<FriendStateModel>>(-1, "请求失败,服务器出现异常", null);
		}
	}
	/**
	 * 发表评论
	 * @param request
	 * @return
	 */
	@RequestMapping("/writecomment")
	@ResponseBody
	public ResultInfo<String> writeComment(HttpServletRequest request)
	{
		try {
			String data=request.getParameter("data");
			CommentModel model=JsonUtils.readValue(data, CommentModel.class);
			if(request.getSession().getAttribute("user")!=null)
			{
				model.setUserId(((UserModel)request.getSession().getAttribute("user")).getUserId());
				return commentService.commentAction(model);
			}
			else
			{
				return new ResultInfo<String>(-1, "用户未登录", "");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
