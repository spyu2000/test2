package com.spyu.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.spyu.bean.UserInfo;
import com.spyu.mapper.UserInfoMapper;
import com.spyu.service.UserInfoService;

@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {

	private UserInfoMapper userInfoMapper;
	@Resource(name="userInfoMapper")
	public void setUserInfoMapper(UserInfoMapper userInfoMapper) {
		System.out.println("---------------userInfoMapper");
		this.userInfoMapper = userInfoMapper;
	}
	@Override
	public UserInfo findByName(String userName) {
		// TODO Auto-generated method stub
		return this.userInfoMapper.getByName(userName);
	}

}
