package com.sea.swallow.dal;

import java.util.List;
import java.util.Map;

import javax.inject.Named;

import com.sea.swallow.model.UserModel;
import com.sea.swallow.model.UserRelationInfo;

@Named("myPageMapper")
public interface MyPageMapper {
   List<UserRelationInfo> selectFriend(Map<String,Object> map);
   
   int updateUserInfo(UserModel model);
}
