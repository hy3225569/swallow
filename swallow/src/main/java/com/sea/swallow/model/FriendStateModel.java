package com.sea.swallow.model;

import java.io.Serializable;
import java.util.List;

public class FriendStateModel implements Serializable {

	
	private static final long serialVersionUID = 8462487787212595530L;
	/**
	 * 说说id
	 */
    private Integer stateId;
    /**
     * 内容
     */
    private String content;
    /**
     * 发布时间
     */
    private String releaseTime;
    /**
     * 发布人
     */
    private Integer userId;
    /**
     * 好友昵称
     */
    private String friendNickName;
    /**
     * 头像
     */
    private String headImg;
    /**
     * 评论
     */
    private List<CommentModel> comment;
	public Integer getStateId() {
		return stateId;
	}
	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getReleaseTime() {
		return releaseTime;
	}
	public void setReleaseTime(String releaseTime) {
		this.releaseTime = releaseTime;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getFriendNickName() {
		return friendNickName;
	}
	public void setFriendNickName(String friendNickName) {
		this.friendNickName = friendNickName;
	}
	public String getHeadImg() {
		return headImg;
	}
	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}
	public List<CommentModel> getComment() {
		return comment;
	}
	public void setComment(List<CommentModel> comment) {
		this.comment = comment;
	}
	
    
}
