package com.portal.app.services.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.portal.app.entity.User;
import com.portal.app.entity.UserRole;
import com.portal.app.entity.payload.UserPayLoad;
import com.portal.app.exception.UserFoundException;
import com.portal.app.repository.IRoleRepository;
import com.portal.app.repository.IUserRepository;
import com.portal.app.services.IUserServices;

@Service
public class UserServiceImpl implements IUserServices {

	@Autowired
	private IUserRepository userRepo;

	@Autowired
	private IRoleRepository roleRepo;

	// create user
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		User us = this.userRepo.findByUserName(user.getUserName());

		if (Objects.nonNull(us)) {

			throw new UserFoundException();
		} else {
			for (UserRole ur : userRoles) {
				roleRepo.save(ur.getRole());
			}
			user.getUserRoles().addAll(userRoles);

			us = this.userRepo.save(user);
		}
		return us;
	}

	/// getting user by userName
	@Override
	public User getUser(String userName) {

		return this.userRepo.findByUserName(userName);
	}

	@Override
	public Long deleteUser(Long userID) {

		this.userRepo.deleteById(userID);
		return userID;

	}

	@Override
	public User updateUser(UserPayLoad user) {
		User user1 = this.userRepo.findByUserName(user.getUserName());
		if (user1 != null) {
			user1.setEnabled(user.isEnabled());
			user1.setProfileIMG(user.getProfileIMG());
			user1.setUserFirstName(user.getUserFirstName());
			user1.setUserLastName(user.getUserLastName());
			user1.setUserMobile(user.getUserMobile());
			user1.setUserEmail(user.getUserEmail());
		}
		return this.userRepo.save(user1);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return this.userRepo.findAll();
	}

	public Page<User> getAllUsers(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		Page<User> page = this.userRepo.findAll(pageable);
		return page;
	}

	@Override
	public User getUserById(Long id) {
		// TODO Auto-generated method stub
		return this.userRepo.findById(id).get();
	}

}
