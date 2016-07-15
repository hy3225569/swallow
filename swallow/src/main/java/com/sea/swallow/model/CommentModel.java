package com.sea.swallow.model;

import java.io.Serializable;

public class CommentModel implements Serializable {

	
	private static final long serialVersionUID = 6064393940296628887L;
	/**
	 * 评论编号
	 */
    private Integer commentId;
    /**
     * 评论人
     */
    private Integer userId;
    /**
     * 评论时间
     */
    private String commentTime;
    /**
     * 评论的动态编号
     */
    private Integer actionId;
    private String commentContent;
    
    private String nickName;
    private String headImg;
	public Integer getCommentId() {
		return commentId;
	}
	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(String commentTime) {
		this.commentTime = commentTime;
	}
	public Integer getActionId() {
		return actionId;
	}
	public void setActionId(Integer actionId) {
		this.actionId = actionId;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getHeadImg() {
		return headImg;
	}
	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}
    
}
