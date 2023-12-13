package com.blog.app.service;

public interface IUserRolesService {
   public boolean deleteUserRole(Long userId,Long roleId);
   
   public void deleteOrphanalValues();
}
