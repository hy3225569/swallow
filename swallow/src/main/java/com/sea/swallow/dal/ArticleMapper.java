package com.sea.swallow.dal;

import javax.inject.Named;

import com.sea.swallow.model.ArticleModel;

@Named("articleMapper")
public interface ArticleMapper {
     int insertArticle(ArticleModel model);
}
