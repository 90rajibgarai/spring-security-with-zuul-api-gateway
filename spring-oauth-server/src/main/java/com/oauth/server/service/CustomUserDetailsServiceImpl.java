package com.oauth.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.oauth.server.config.CustomUserDetails;
import com.oauth.server.model.User;
import com.oauth.server.repository.UserRepository;

@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService
{
	@Autowired
    private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
        User user = userRepository.findByUsername(username);
        return new CustomUserDetails(user);
    }
	
	public User saveUser(User user)
	{
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}
}
