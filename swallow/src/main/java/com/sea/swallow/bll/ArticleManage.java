package com.sea.swallow.bll;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sea.swallow.common.JsonUtils;
import com.sea.swallow.common.StringUtils;
import com.sea.swallow.dal.ActivityMapper;
import com.sea.swallow.dal.ArticleMapper;
import com.sea.swallow.dal.CommentMapper;
import com.sea.swallow.ibll.IArticleManage;
import com.sea.swallow.model.ActivityModel;
import com.sea.swallow.model.ArticleModel;
import com.sea.swallow.model.FriendArticleModel;
import com.sea.swallow.model.ResultInfo;
import com.sea.swallow.model.UserModel;

@Service("articleService")
public class ArticleManage implements IArticleManage {

	@Resource(name = "articleMapper")
	private ArticleMapper articleMapper;
    
	@Resource(name="activityMapper")
	private ActivityMapper activityMapper;
	
	@Resource(name="commentMapper")
	private CommentMapper commentMapper;
	/**
	 * 写文章
	 */
	@Override
	@Transactional(rollbackFor={Exception.class})
	public ResultInfo<String> writeBlog(HttpServletRequest request) {
		String data = request.getParameter("data");
		ArticleModel model = new ArticleModel();
		ActivityModel activityModel=new ActivityModel();
		try {
			
			if (data != null) {
				model = JsonUtils.readValue(data, ArticleModel.class);
				model.setOpenType((byte) 2);
				model.setArticleType(1);
				model.setUserId(0);
				activityModel.setActionType((byte) 1);
				if (request.getSession().getAttribute("user") != null) {
					model.setUserId(((UserModel)request.getSession().getAttribute("user")).getUserId());
				}
				if (checkArticleForm(model)) {
					activityMapper.insertActivity(activityModel);
					model.setArticleId(activityModel.getActionId());
					return articleMapper.insertArticle(model) > 0 ? new ResultInfo<String>(0, "发布成功", "")
							: new ResultInfo<String>(-1, "发布失败", "");
				}
				return new ResultInfo<String>(-1, "请求的参数有误", "");
			}
			return new ResultInfo<String>(-1, "请求的参数有误", "");
		} catch (Exception e) {
			return new ResultInfo<String>(-1, "向服务器请求失败" + e.getMessage(), "");
		}
	}

	/**
	 * 验证
	 */
	public Boolean checkArticleForm(ArticleModel model) {
		if (StringUtils.isEmpty(model.getContent()) || StringUtils.isEmpty(model.getDiscreption())
				|| StringUtils.isEmpty(model.getTitle())) {
			return false;
		}
		return true;
	}

	/**
	 * 根据条件得到博文列表
	 */
	@Override
	public ResultInfo<List<ArticleModel>> getArticleListByParames(Map<String, Object> map) {
		try {
			List<ArticleModel> list= articleMapper.selectArticleList(map);
			if(list!=null && !list.isEmpty())
			{
				return new ResultInfo<List<ArticleModel>>(0,"",list);
			}
			return new ResultInfo<List<ArticleModel>>(0,"",new ArrayList<ArticleModel>());
		} catch (Exception e) {
			return new ResultInfo<List<ArticleModel>>(0,"",new ArrayList<ArticleModel>());
		}
		
	}

	/**
	 * 根据条件获取博文列表
	 */
	@Override
	public ResultInfo<List<FriendArticleModel>> getFriendArticleList(Map<String, Object> map) {
		try {
			List<FriendArticleModel> list= articleMapper.selectFriendArticleList(map);
			for (FriendArticleModel friendArticleModel : list) {
				friendArticleModel.setComment(commentMapper.selectCommentList(Integer.valueOf(friendArticleModel.getArticleId().toString())));
			}
			if(list!=null && !list.isEmpty())
			{
				return new ResultInfo<List<FriendArticleModel>>(0,"",list);
			}
			return new ResultInfo<List<FriendArticleModel>>(0,"",null);
		} catch (Exception e) {
			return new ResultInfo<List<FriendArticleModel>>(0,"",null);
		}
	}

}
