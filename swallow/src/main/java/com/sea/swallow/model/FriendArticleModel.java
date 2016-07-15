package com.sea.swallow.model;

import java.io.Serializable;
import java.util.List;

/**
 * 好友文章实体
 * @author Administrator
 *
 */
public class FriendArticleModel implements Serializable {


	private static final long serialVersionUID = -4715578306095526881L;
	/**
	 * 文章编号
	 */
	private Long articleId;
	/**
	 * 所属用户
	 */
	private Integer userId;
	/**
	 * 文章类型
	 */
	private Integer articleType;
	/**
	 * 发布时间
	 */
	private String releaseTime;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 文章内容
	 */
	private String content;
	
	/**
	 * 好友昵称
	 */
	private String friendNickName;
	
	private String articleTypeName;
    
	private List<CommentModel> comment;
	public Long getArticleId() {
		return articleId;
	}

	public void setArticleId(Long articleId) {
		this.articleId = articleId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getArticleType() {
		return articleType;
	}

	public void setArticleType(Integer articleType) {
		this.articleType = articleType;
	}

	public String getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(String releaseTime) {
		this.releaseTime = releaseTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getArticleTypeName() {
		return articleTypeName;
	}

	public void setArticleTypeName(String articleTypeName) {
		this.articleTypeName = articleTypeName;
	}

	public String getFriendNickName() {
		return friendNickName;
	}

	public void setFriendNickName(String friendNickName) {
		this.friendNickName = friendNickName;
	}

	public List<CommentModel> getComment() {
		return comment;
	}

	public void setComment(List<CommentModel> comment) {
		this.comment = comment;
	}
}
