package com.sea.swallow.model;

import java.io.Serializable;

public class ActivityModel implements Serializable {

	
	private static final long serialVersionUID = -358928569104105812L;
	/**
	 * 动态编号
	 */
    private Long actionId;
    /**
     * 动态类型
     */
    private Byte actionType;
    /**
     * 用户编号
     */
    private Integer userId;
    /**
     * 动态发生时间
     */
    private String updateTime;
    public Long getActionId() {
		return actionId;
	}
	public void setActionId(Long actionId) {
		this.actionId = actionId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public Byte getActionType() {
		return actionType;
	}
	public void setActionType(Byte actionType) {
		this.actionType = actionType;
	}
	
}
