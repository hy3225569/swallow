package com.sea.swallow.dal;
import java.util.List;

import javax.inject.Named;

import com.sea.swallow.model.UserModel;
@Named("userMapper")
public interface UserMapper {
   List<UserModel> selectUserInfo();
}
