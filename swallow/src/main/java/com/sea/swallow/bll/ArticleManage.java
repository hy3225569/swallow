package com.sea.swallow.bll;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.sea.swallow.common.JsonUtils;
import com.sea.swallow.dal.ArticleMapper;
import com.sea.swallow.ibll.IArticleManage;
import com.sea.swallow.model.ArticleModel;
import com.sea.swallow.model.ResultInfo;
import com.sea.swallow.model.UserModel;

@Service("articleService")
public class ArticleManage implements IArticleManage {

	@Resource(name="articleMapper")
	private ArticleMapper articleMapper;
	/**
	 * 写文章
	 */
	@Override
	public ResultInfo<String> writeBlog(HttpServletRequest request) {
		String data=request.getParameter("data");
		ArticleModel model=new ArticleModel();
		try {
		model.setOpenType((byte)2);
		model.setArticleType(1);
		model.setUserId(((UserModel)request.getSession().getAttribute("user")).getUserId());
			if(data!=null){
				 model=JsonUtils.readValue(data, ArticleModel.class);
				 if(checkArticleForm(model)){
				  return articleMapper.insertArticle(model)>0?  new ResultInfo<String>(0,"发布成功",""): new ResultInfo<String>(-1,"发布失败","");	
				 }
				 return new ResultInfo<String>(-1,"请求的参数有误","");
			}
			return new ResultInfo<String>(-1,"请求的参数有误","");
		} catch (Exception e) {
			return new ResultInfo<String>(-1,"向服务器请求失败"+e.getMessage(),"");
		} 
	}
	/**
	 * 验证
	 */
	public Boolean checkArticleForm(ArticleModel model) {
		if(StringUtils.isEmpty(model.getContent())||StringUtils.isEmpty(model.getDiscreption())||StringUtils.isEmpty(model.getTitle())){
			return false;
		}
		return true;
	}

}
