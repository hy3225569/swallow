package com.sea.swallow.model;

import java.io.Serializable;

public class ArticleModel implements Serializable{
    
	private static final long serialVersionUID = -4520613046637849964L;
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
	 * 撰写时间
	 */
	private String writeTime;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 文章状态 1.草稿 2.审核 3.发布 4.删除
	 */
	private Byte status;
	/**
	 * 文章内容
	 */
	private String content;
	/**
	 * 文章简述
	 */
	private String discreption;
	/**
	 * 开放类型 1 对所有用户公开 2.仅对好友公开 3.仅自己可见
	 */
	private Byte openType;
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
	public String getWriteTime() {
		return writeTime;
	}
	public void setWriteTime(String writeTime) {
		this.writeTime = writeTime;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Byte getStatus() {
		return status;
	}
	public void setStatus(Byte status) {
		this.status = status;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDiscreption() {
		return discreption;
	}
	public void setDiscreption(String discreption) {
		this.discreption = discreption;
	}
	public Byte getOpenType() {
		return openType;
	}
	public void setOpenType(Byte openType) {
		this.openType = openType;
	}
	
}
