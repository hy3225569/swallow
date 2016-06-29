package com.sea.swallow.model;

import java.io.Serializable;

public class UserModel implements Serializable {

	private static final long serialVersionUID = 5295431204819808159L;

	/**
	 *用户编号
	 */
	private Integer userId;
	/**
	 * 用户姓名
	 */
	private String userName;
	/**
	 * 用户密码
	 */
	private String userPass;
	/**
	 *ַ用户权限
	 */
	private Integer roleId;

	/**
	 * 创建时间
	 */
	private String createTime;
	/**
	 *是否删除 0否 1 是
	 */
    private Byte beDeleted;
    
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public Byte getBeDeleted() {
		return beDeleted;
	}
	public void setBeDeleted(Byte beDeleted) {
		this.beDeleted = beDeleted;
	}
	

}
