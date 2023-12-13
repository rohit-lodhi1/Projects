package com.dollop.DAO;

import java.sql.SQLException;
import java.util.List;

import com.dollop.entity.Contacts;
import com.dollop.entity.Groups;
import com.dollop.entity.User;

public interface PhoneBookDAO {
	public User save(User us) throws SQLException ;
	public User login(String email,String psw) throws SQLException ;
	public boolean addContact(Contacts cont) throws SQLException;
	public List<Contacts> getContacts(int uId,String query) ;
	public boolean deleteContact(int id) ;
	public List<Contacts> getFavourites() throws SQLException;
	public List<Groups> getGroups()  throws SQLException;
}
