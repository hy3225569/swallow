package com.sea.swallow.bll;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sea.swallow.dal.CommentMapper;
import com.sea.swallow.ibll.ICommentService;
import com.sea.swallow.model.CommentModel;
import com.sea.swallow.model.ResultInfo;

@Service("commentService")
public class CommentImpl implements ICommentService {

	@Resource(name="commentMapper")
	private CommentMapper commentMapper;
	@Override
	public ResultInfo<String> commentAction(CommentModel model) {
		 try {
			return commentMapper.insertComment(model)>0? new ResultInfo<String>(0, "发表成功", ""):new ResultInfo<String>(-1, "发表失败", "");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultInfo<String>(-1, "服务器出现异常", "");
		}
	}

}
