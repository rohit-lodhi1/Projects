package com.roverse.DAO;

import com.roverse.entity.User;

public interface RoverseDAO {
   public User login(String email,String password);
   public Boolean registration(User us);
}
