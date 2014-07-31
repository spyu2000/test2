package com.spyu.bean;

import java.util.ArrayList;
import java.util.List;

public class UserInfo implements java.io.Serializable{
	/**
	 * 
	 */
	private int userId = 0;
	private String userName = "";
	private String password="";
	private List<RoleInfo> roles = new ArrayList<RoleInfo>(4);

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<RoleInfo> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleInfo> roles) {
		this.roles = roles;
	}

}
