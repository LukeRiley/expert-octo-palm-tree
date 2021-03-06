package io.trade.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	DataSource dataSource;
	
	 @Override
	 protected void configure(HttpSecurity http) throws Exception {
	   http.authorizeRequests()
	  .antMatchers("/hello").access("hasRole('ROLE_ADMIN')")  
	  //.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")  
	  //.antMatchers("/auth/**").access("hasRole('ROLE_USER')")
	  .anyRequest().permitAll()
	  .and()
	    .formLogin().loginPage("/auth/login.html")
	    .usernameParameter("username").passwordParameter("password")
	  .and()
		.exceptionHandling().accessDeniedPage("/403")
	  .and()
	    .logout().logoutSuccessUrl("/auth/login?logout") 
	  .and()
	    .csrf().disable();
	 }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	auth.jdbcAuthentication().dataSource(dataSource)
    	  .usersByUsernameQuery(
    	   "select username,password, enabled from users where username=?")
    	  .authoritiesByUsernameQuery(
    	   "select users.username, user_roles.role from users INNER JOIN user_roles ON (users.id = user_roles.users_id) WHERE username=?");
    }
    
    
}
