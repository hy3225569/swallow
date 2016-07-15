package com.sea.swallow.ibll;

import com.sea.swallow.model.CommentModel;
import com.sea.swallow.model.ResultInfo;

public interface ICommentService {
    ResultInfo<String> commentAction(CommentModel model);
    
}
