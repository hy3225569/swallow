package com.sea.swallow.ibll;

import java.util.List;

import com.sea.swallow.model.UserModel;

/**
 * 用户管理接口
 * @author Administrator
 *
 */
public interface IUserManage {
   List<UserModel> GetAllUserInfo();
}
