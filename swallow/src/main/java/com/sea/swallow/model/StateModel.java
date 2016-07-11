package com.sea.swallow.model;

import java.io.Serializable;

public class StateModel implements Serializable {


	private static final long serialVersionUID = 949610652910412933L;
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
}
