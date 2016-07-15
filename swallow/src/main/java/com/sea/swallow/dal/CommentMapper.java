package com.sea.swallow.dal;

import java.util.List;

import javax.inject.Named;

import org.apache.ibatis.annotations.Param;

import com.sea.swallow.model.CommentModel;

@Named("commentMapper")
public interface CommentMapper {
    int insertComment(CommentModel model);
    
    
    List<CommentModel> selectCommentList( @Param("actionId") Integer actionId);
}
