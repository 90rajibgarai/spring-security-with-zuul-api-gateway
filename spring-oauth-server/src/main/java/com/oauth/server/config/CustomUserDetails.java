package com.oauth.server.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.oauth.server.model.Role;
import com.oauth.server.model.User;

public class CustomUserDetails implements UserDetails
{
	private User user = new User();
	
	List<Role> roleList = new ArrayList<>();
	
	public CustomUserDetails() {}
	
	public CustomUserDetails(User user) 
	{
		this.user = user;
        this.roleList = user.getRoles();
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities()
	{
	    List<SimpleGrantedAuthority> simpleGrantedAuthorityList = new ArrayList<>();
	    
	    for(Role role: roleList)
	    {
	        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getName());
	        simpleGrantedAuthorityList.add(authority);
	    }
	    return simpleGrantedAuthorityList;
	}

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
