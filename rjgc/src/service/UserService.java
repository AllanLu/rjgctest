package service;

import model.UserModel;

public class UserService {
	public UserModel getUserFromSession(){
		UserModel user = new UserModel();
		//从session中获取用户信息
		return user;
	}
}
