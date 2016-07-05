package com.sea.swallow.ibll;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

import com.sea.swallow.model.ArticleModel;
import com.sea.swallow.model.ResultInfo;

public interface IArticleManage {
   
	/**
	 * 写文章
	 * @return
	 */
	ResultInfo<String> writeBlog(HttpServletRequest request);
	
	/**
	 * 根据条件获取博文列表(可以是用户ID，博文的名称等等)
	 * @param map
	 * @return
	 */
	ResultInfo<List<ArticleModel>> getArticleListByParames(Map<String,Object> map);
}
