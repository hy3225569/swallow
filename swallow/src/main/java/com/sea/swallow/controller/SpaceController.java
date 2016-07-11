package com.sea.swallow.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sea.swallow.ibll.IArticleManage;
import com.sea.swallow.ibll.IStateService;
import com.sea.swallow.model.ArticleModel;
import com.sea.swallow.model.ResultInfo;
import com.sea.swallow.model.StateModel;
import com.sea.swallow.model.UserModel;

@Controller
@RequestMapping("/space")
public class SpaceController {
	@Resource(name = "articleService")
	private IArticleManage articleService;
    
	@Resource(name = "stateService")
	private IStateService stateService;
	/**
	 * 写博文
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/writearticle")
	@ResponseBody
	public ResultInfo<String> WriteArticle(HttpServletRequest request) {
		try {
			return articleService.writeBlog(request);
		} catch (Exception e) {
			return new ResultInfo<String>(-1, "服务器请求失败", "");
		}
	}

	/**
	 * 获取登录用户的文章列表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/articlelogin")
	@ResponseBody
	public ResultInfo<List<ArticleModel>> getArticleListByLoginUser(HttpServletRequest request) {
		try {
			if (request.getSession().getAttribute("user") != null) {
				HashMap<String, Object> map = new HashMap<>();
				map.put("userId", ((UserModel) request.getSession().getAttribute("user")).getUserId());
				return articleService.getArticleListByParames(map);
			}
			return new ResultInfo<List<ArticleModel>>(-1, "用户未登录", null);
		} catch (Exception e) {
			return new ResultInfo<List<ArticleModel>>(-1, "请求失败,服务器出现异常", null);
		}
	}
	/**
	 * 获取文章
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/article")
	@ResponseBody
	public ResultInfo<List<ArticleModel>> getArticleByArticleId(HttpServletRequest request) {
		try {
			if (request.getSession().getAttribute("user") != null) {
				HashMap<String, Object> map = new HashMap<>();
				map.put("articleId", Integer.valueOf(request.getParameter("articleId")));
				return articleService.getArticleListByParames(map);
			}
			return new ResultInfo<List<ArticleModel>>(-1, "用户未登录", null);
		} catch (Exception e) {
			return new ResultInfo<List<ArticleModel>>(-1, "请求失败,服务器出现异常", null);
		}
	}
	/**
	 *  写状态
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/writestate")
	@ResponseBody
	public ResultInfo<String> writeState(HttpServletRequest request) {
		try {
			return stateService.updateStatus(request);
		} catch (Exception e) {
			return new ResultInfo<String>(-1, "服务器请求失败", "");
		}
	}
	/**
	 * 获取登录用户状态
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/statelogin")
	@ResponseBody
	public ResultInfo<List<StateModel>> getStateListByLoginUser(HttpServletRequest request) {
		try {
			if (request.getSession().getAttribute("user") != null) {
				HashMap<String, Object> map = new HashMap<>();
				map.put("userId", ((UserModel) request.getSession().getAttribute("user")).getUserId());
				return stateService.getStatusByParames(map);
			}
			return new ResultInfo<List<StateModel>>(-1, "用户未登录", null);
		} catch (Exception e) {
			return new ResultInfo<List<StateModel>>(-1, "请求失败,服务器出现异常", null);
		}
	}
}
