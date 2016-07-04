package com.sea.swallow.ibll;

import javax.servlet.http.HttpServletRequest;

import com.sea.swallow.model.ArticleModel;
import com.sea.swallow.model.ResultInfo;

public interface IArticleManage {
   
	/**
	 * 写文章
	 * @return
	 */
	ResultInfo<String> writeBlog(HttpServletRequest request);
}
