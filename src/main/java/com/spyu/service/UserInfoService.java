package com.spyu.service;

import com.spyu.bean.UserInfo;


public interface UserInfoService {
	UserInfo findByName(String username);
}
