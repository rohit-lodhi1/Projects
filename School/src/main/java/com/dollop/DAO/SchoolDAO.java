package com.dollop.DAO;

import com.dollop.entity.User;

public interface  SchoolDAO {
	public boolean registration(User us);

	public int login(String email,String password,String type);

	public boolean logOut(User us);

	public boolean isLogin(User us);

}
