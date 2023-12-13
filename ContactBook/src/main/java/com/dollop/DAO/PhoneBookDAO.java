package com.dollop.DAO;

import java.util.List;

import com.dollop.entity.Contacts;
import com.dollop.entity.User;

public interface PhoneBookDAO {
	public boolean registration(User us);

	public User login(String email,String password);

	public boolean logOut(User us);

	public boolean isLogin(User us);

	public boolean addContact(Contacts cont);
	
	public int getUser(String name);
	
	public List<Contacts> getContacts(int uId);
	
	public Contacts getContact(int id);

	public boolean updateContact(Contacts c);
	
	public List<Contacts> getContact(String name,int uid);
	
	public boolean deleteContact(int id);
	public User getUser(int id);
	public boolean uploadImg(int id,String img);

	public List<Contacts> getContacts(int attribute, String sort);

}
