package com.sea.swallow.bll;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sea.swallow.dal.UserMapper;
import com.sea.swallow.ibll.IUserManage;
import com.sea.swallow.model.ResultInfo;
import com.sea.swallow.model.UserModel;
import com.sea.swallow.common.MD5;
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
	/**
	 * 用户注册
	 */
	@Override
	public ResultInfo<String> userRegister(UserModel user) {
		//检测该用户是否注册过
	   HashMap<String,Object> map=new HashMap<String,Object>();
	   map.put("userName", user.getUserName());
	   Boolean isRegiste= userMapper.checkUique(map)>0;
	   if(isRegiste){
		   return new ResultInfo<String>(-1," 该帐号已注册","");
	   }else{
		   //md5加密
		  user.setUserPass(MD5.md5(user.getUserPass()));
		  int result= userMapper.insertUser(user);
		  if(result>0){
			  return new ResultInfo<String>(0," 注册成功","");
		  }
		  return new ResultInfo<String>(-1," 注册失败","");
	   }
	   
	}

}
