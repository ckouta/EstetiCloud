package com.barberia.springboot.app;

//import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;

import com.barberia.springboot.app.auth.handler.LoginSuccessHandler;
import com.barberia.springboot.app.models.service.JpaUserDetailsService;


@EnableGlobalMethodSecurity(securedEnabled=true,prePostEnabled=true)
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private LoginSuccessHandler successHandler;
	
	//@Autowired
	//private DataSource dataSource;
	
	@Autowired
	private JpaUserDetailsService userDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/**","/index/**","/barbero/**","/bower_components/**","/dist/**","/layout/**","/plugins/**","/toastr.min.css","/toastr.min.js").permitAll()
				.anyRequest().authenticated().and().formLogin()
				.successHandler(successHandler)
				.loginPage("/login")
				.permitAll().and()
				.logout().permitAll().and()
				.exceptionHandling().accessDeniedPage("/error_403");
	}

	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception {
		
		/*con jpa*/
		build.userDetailsService(userDetailsService)
		.passwordEncoder(passwordEncoder);
		
	}
}
