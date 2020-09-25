package org.hebronworks.SpringAuthethicationJDBC.userdetails;

import java.util.Optional;

import org.hebronworks.SpringAuthethicationJDBC.model.User;
import org.hebronworks.SpringAuthethicationJDBC.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional <User> user=userRepository.findUserByUsername(username);
		user.orElseThrow(()-> new UsernameNotFoundException("User does not exist"+username));
		return user.map(MyUserDetails::new).get();
	}

}
