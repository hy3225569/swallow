package com.sea.swallow.model;

import java.io.Serializable;

public class UserRelationInfo implements Serializable {

	
	private static final long serialVersionUID = 7631205452815305001L;
    private Integer userId;
    private Integer friendId;
    private String userName;
    private String friendNickName;
    private String friendSelfDescription;
    private String friendName;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getFriendId() {
		return friendId;
	}
	public void setFriendId(Integer friendId) {
		this.friendId = friendId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFriendNickName() {
		return friendNickName;
	}
	public void setFriendNickName(String friendNickName) {
		this.friendNickName = friendNickName;
	}
	public String getFriendSelfDescription() {
		return friendSelfDescription;
	}
	public void setFriendSelfDescription(String friendSelfDescription) {
		this.friendSelfDescription = friendSelfDescription;
	}
	public String getFriendName() {
		return friendName;
	}
	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}
}
