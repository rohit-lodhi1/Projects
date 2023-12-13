package com.portal.app.services.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.portal.app.Repository.IUserRepository;
import com.portal.app.entity.User;

@Service
public class UserDetaileServiceImpl implements UserDetailsService {
@Autowired
	private IUserRepository userRepo;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
     User user = this.userRepo.findByUserName(username);
     if(user==null) {
    	 System.out.println("User not FOund");
    	 throw new UsernameNotFoundException("Not User Found");
     }
		return user;
	}

}
