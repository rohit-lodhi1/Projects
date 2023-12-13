package com.dollop.DAO;

import com.dollop.entity.User;

public interface UserDao {
  public boolean save(User us);
  public boolean login(String email,String password);
}
