package com.mdev.spring.services;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.GrantedAuthority;

import com.mdev.spring.entites.Role;
import com.mdev.spring.entites.User;

public class AuthenticatedUser extends org.springframework.security.core.userdetails.User {

	private User user;

	public AuthenticatedUser(User user) {
		super(user.getEmail(), user.getPassword(), getAuthorities(user));
		this.user = user;
	}

	private static Collection<? extends GrantedAuthority> getAuthorities(User user) {
		Set<String> roleAndPermissions = new HashSet<>();
		Collection<Role> roles = user.getRoles();

		for (Role role : roles) {
			roleAndPermissions.add(role.getName());
		}
		String[] roleNames = new String[roleAndPermissions.size()];
		Collection<GrantedAuthority> authorities = AuthorityUtils
				.createAuthorityList(roleAndPermissions.toArray(roleNames));
		return authorities;
	}
	


}
