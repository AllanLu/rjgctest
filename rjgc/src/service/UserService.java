package service;

import javax.servlet.http.HttpSession;

import model.UserModel;

public class UserService {
	public UserModel getUserFromSession(HttpSession session){
		UserModel user = new UserModel();
		//��session�л�ȡ�û���Ϣ
		user=(UserModel) session.getAttribute("user");
		return user;
	}
}
