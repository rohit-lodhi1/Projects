package com.portal.app.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userId", nullable = false)
	private Long userId;

	@Column(name = "userName")
	private String userName;

	@Column(name = "userEmail")
	private String userEmail;

	@Column(name = "userPassword")
	private String userPassword;

	@Column(name = "userFirstName")
	private String userFirstName;

	@Column(name = "userLastName")
	private String userLastName;

	@Column(name = "userMobile")
	private String userMobile;

	@Column(name = "userEnabled")
	private boolean enabled = true;
	
	private String profileIMG = "default.png";
	
	@OneToMany(cascade= CascadeType.ALL,fetch = FetchType.EAGER , mappedBy = "user")
	@JsonIgnore
	private Set<UserRole> userRoles = new HashSet<>();

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		Set<Authority> set = new HashSet<>();
		this.userRoles.forEach(userRole->{
			set.add(new Authority(userRole.getRole().getRoleName()));
		});
		
		return set;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return userPassword;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public String getUserName() {
		return userName;
	}
}
