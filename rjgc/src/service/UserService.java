package service;

import javax.servlet.http.HttpSession;

import model.UserModel;

public class UserService {
	public UserModel getUserFromSession(HttpSession session){
		UserModel user = new UserModel();
		//从session中获取用户信息
		user=(UserModel) session.getAttribute("user");
		return user;
	}
}
