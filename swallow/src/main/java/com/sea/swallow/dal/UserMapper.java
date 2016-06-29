package com.sea.swallow.dal;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import com.sea.swallow.model.UserModel;
@Named("userMapper")
public interface UserMapper {
	/**
	 * 查询所有用户
	 * @return
	 */
   List<UserModel> selectUserInfo();
   
   /**
    * 插入用户基本信息
    * @param user
    * @return
    */
   int insertUser(UserModel user);
   
   /**
    * 判读用户是否唯一
    * @param map
    * @return
    */
   int checkUique(Map<String,Object> map);
}
