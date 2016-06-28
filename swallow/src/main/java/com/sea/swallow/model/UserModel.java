package com.sea.swallow.model;

import java.io.Serializable;

public class UserModel implements Serializable {

	private static final long serialVersionUID = 5295431204819808159L;

	/**
	 *自增ID
	 */
	private Integer id;
	/**
	 * 学生姓名
	 */
	private String stuname;
	/**
	 * 学生年龄
	 */
	private Integer stuage;
	/**
	 * 学生住址ַ
	 */
	private String stulocation;

	/**
	 * 年级
	 */
	private Integer gradeid;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStuname() {
		return stuname;
	}

	public void setStuname(String stuname) {
		this.stuname = stuname;
	}

	public Integer getStuage() {
		return stuage;
	}

	public void setStuage(Integer stuage) {
		this.stuage = stuage;
	}

	public String getStulocation() {
		return stulocation;
	}

	public void setStulocation(String stulocation) {
		this.stulocation = stulocation;
	}

	public Integer getGradeid() {
		return gradeid;
	}

	public void setGradeid(Integer gradeid) {
		this.gradeid = gradeid;
	}

}
