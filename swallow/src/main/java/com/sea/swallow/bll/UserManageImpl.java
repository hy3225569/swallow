package com.sea.swallow.bll;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

import org.springframework.stereotype.Service;

import com.sea.swallow.dal.UserMapper;
import com.sea.swallow.ibll.IUserManage;
import com.sea.swallow.model.ResultInfo;
import com.sea.swallow.model.UserModel;
import com.sea.swallow.common.CookieUtils;
import com.sea.swallow.common.MD5;

/**
 * 用户管理实现类
 * 
 * @author Administrator
 *
 */
@Service("userManageService")
public class UserManageImpl implements IUserManage {

	@Resource(name = "userMapper")
	private UserMapper userMapper;

	@Override
	public List<UserModel> GetAllUserInfo(Map<String, Object> map) {
		try {
			List<UserModel> list = userMapper.selectUserInfo(map);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * 用户注册
	 */
	@Override
	public ResultInfo<String> userRegister(UserModel user, HttpServletRequest request) {
		// 检测该用户是否注册过
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userName", user.getUserName());
		Boolean isRegiste = userMapper.checkUique(map) > 0;
		if (isRegiste) {
			return new ResultInfo<String>(-1, " 该帐号已注册", "");
		} else {
			// md5加密
			user.setUserPass(MD5.md5(user.getUserPass()));
			int result = userMapper.insertUser(user);
			if (result > 0) {
				UserModel userInfo = userMapper.selectUserByName(user.getUserName());
				if (userInfo != null) {
					request.getSession().setAttribute("user", userInfo);
					return new ResultInfo<String>(0, " 注册成功", "");
				}
				return new ResultInfo<String>(-1, "请求服务器失败!", "");
			}
			return new ResultInfo<String>(-1, " 注册失败", "");
		}

	}

	/**
	 * 用户登录
	 */
	@Override
	public ResultInfo<UserModel> userLogin(Map<String, Object> map, HttpServletRequest request,HttpServletResponse response) {

		try {

			
				// 密码md5加密操作
				map.put("userPass", MD5.md5(map.get("userPass").toString()));
				Boolean isLogin = userMapper.selectByNameAndPass(map) == 1;
				if (isLogin) {
					UserModel userInfo = userMapper.selectUserByName(map.get("userName").toString());
					if (userInfo != null) {
						request.getSession().setAttribute("user", userInfo);
						if (map.get("rememberMe").equals("1")) {
						//设置cookie
						CookieUtils.setCookie(response, "userName",userInfo.getUserName(),100);
						}
						return new ResultInfo<UserModel>(0, "登录成功!", userInfo);
					}
					return new ResultInfo<UserModel>(0, "请求服务器失败!", userInfo);
				} else {
					return new ResultInfo<UserModel>(-1, "用户名或密码错误!", null);
				}
		} catch (Exception e) {
			return new ResultInfo<UserModel>(-1, "向服务器请求异常!", null);
		}
	}

}
