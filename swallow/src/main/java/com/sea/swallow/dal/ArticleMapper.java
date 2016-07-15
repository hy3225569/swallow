package com.sea.swallow.dal;

import java.util.List;
import java.util.Map;

import javax.inject.Named;

import com.sea.swallow.model.ActivityModel;
import com.sea.swallow.model.ArticleModel;
import com.sea.swallow.model.FriendArticleModel;

@Named("articleMapper")
public interface ArticleMapper {
     int insertArticle(ArticleModel model);
     List<ArticleModel> selectArticleList(Map<String,Object> map);
     
     List<FriendArticleModel> selectFriendArticleList(Map<String,Object> map);
}
