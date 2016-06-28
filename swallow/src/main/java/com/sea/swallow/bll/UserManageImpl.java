package com.sea.swallow.bll;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sea.swallow.dal.UserMapper;
import com.sea.swallow.ibll.IUserManage;
import com.sea.swallow.model.UserModel;;
/**
 * 用户管理实现类
 * @author Administrator
 *
 */
@Service("userManageService")
public class UserManageImpl implements IUserManage {

	@Resource(name="userMapper")
	private UserMapper userMapper;
	@Override
	public List<UserModel> GetAllUserInfo() {
	   return userMapper.selectUserInfo();
	}

}
