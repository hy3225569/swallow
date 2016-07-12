package com.sea.swallow.model;

import java.io.Serializable;
import java.util.Date;

import com.sea.swallow.common.DateUtils;

public class UserModel implements Serializable {

	private static final long serialVersionUID = 5295431204819808159L;

	/**
	 * 用户编号
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
	 * ַ用户权限
	 */
	private Integer roleId;

	/**
	 * 创建时间
	 */
	private String createTime;
	/**
	 * 是否删除 0否 1 是
	 */
	private Byte beDeleted;
	/**
	 * 自我描述
	 */
	private String selfDescription;
	/**
	 * 昵称
	 */
	private String nickName;
	/**
	 * 出生日期
	 */
	private String bornDate;
	
	/**
	 * 头像
	 */
	private String headImg;
	/**
	 * 爱好
	 */
	private String hobby;
	
	/**
	 * 手机号
	 */
	private String phone;
	/**
	 * 性别 
	 */
	private String sex;
	/**
	 * 地址
	 */
	private String address;
	
	private Byte rememberMe;
	public String getSelfDescription() {
		return selfDescription;
	}

	public void setSelfDescription(String selfDescription) {
		this.selfDescription = selfDescription;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getBornDate() {
		return bornDate;
	}

	public void setBornDate(String bornDate) {
		this.bornDate = bornDate;
	}

	public String getHeadImg() {
		return headImg;
	}

	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}



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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Byte getRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(Byte rememberMe) {
		this.rememberMe = rememberMe;
	}


}
