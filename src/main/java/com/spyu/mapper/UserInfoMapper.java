package com.spyu.mapper;

import com.spyu.bean.UserInfo;
import com.spyu.common.BaseDao;

public interface UserInfoMapper extends BaseDao<UserInfo> {

	public UserInfo getByName(String userName);
}
