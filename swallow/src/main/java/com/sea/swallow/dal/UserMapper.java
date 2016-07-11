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
   List<UserModel> selectUserInfo(Map<String,Object> map);
   
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
   
   /**
    * 根据用户名和密码判断用户是否存在
    * @param map
    * @return
    */
   int selectByNameAndPass(Map<String,Object> map);
   
   /**
    * 根据用户名获取用户信息
    * @param userName
    * @return
    */
   UserModel selectUserByName(String userName);
}
