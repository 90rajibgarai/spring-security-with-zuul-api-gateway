package com.oauth.server;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.oauth.server.model.Role;
import com.oauth.server.model.User;
import com.oauth.server.repository.UserRepository;

@SpringBootTest
class SpringOauthServerApplicationTests {

	@Autowired
	 private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	 public void createUser()
	 {
		User user2 = new User();
		 
		 user2.setUsername("test@gmail.com");
		 user2.setPassword(passwordEncoder.encode("pass"));
		 
		 user2.setFirstName("Test");
		 user2.setLastName("User");
		 user2.setMobile("+1-8039362015");
		 
		 List<Role> roleList2 = new ArrayList<>();
		 
		 Role role3 = new Role();
		 role3.setName("ADMIN");
		 role3.setDescription("Administrator");
		 roleList2.add(role3);
		 
		 Role role4 = new Role();
		 role4.setName("USER");
		 role4.setDescription("User");
		 roleList2.add(role4);
		 
		 user2.setRoles(roleList2);
		 
		 userRepository.save(user2);
		 
		 User user = new User();		 
		 user.setUsername("90rajibgarai@gmail.com");
		 user.setPassword(passwordEncoder.encode("rajib"));
		 
		 user.setFirstName("Rajib");
		 user.setLastName("Garai");
		 user.setMobile("+91-9563359659");
		 
		 List<Role> roleList = new ArrayList<>();
		 
		 Role role1 = new Role();
		 role1.setName("ADMIN");
		 role1.setDescription("Administrator");
		 roleList.add(role1);
		 
		 Role role2 = new Role();
		 role2.setName("USER");
		 role2.setDescription("User");
		 roleList.add(role2);
		 
		 user.setRoles(roleList);
		 
		 userRepository.save(user);		
	 }

}
