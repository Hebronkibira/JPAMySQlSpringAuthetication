package org.hebronworks.SpringAuthethicationJDBC;

import org.hebronworks.SpringAuthethicationJDBC.userdetails.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
   
	
	@Autowired
	MyUserDetailsService userDetailsService;
	
	/*Implementation of this method */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
	
	
	
	/*This method takes filters any request that comes in
	 * 
	 * */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.
		     authorizeRequests() //authorize all requests 
		     .antMatchers("/admin") //for "/admin" end point 
		     .hasRole("ADMIN")//allow  persons with role ADMIN only others not authorized
		     .antMatchers("/user")//for end point "/user" 
		     .hasAnyRole("ADMIN","USER")//allow all users with either ADMIN or USER roles
		     .antMatchers("/")//for the root end point 
		     .permitAll()//allow anybody without needing authentication
		     .and().formLogin();
		
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	

}
