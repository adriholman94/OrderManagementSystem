package com.fiuni.sd.Security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(bCryptPasswordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/home", "/login", "/logout").permitAll()
				.antMatchers("/clients/**", "/products/**", "/orders/**").hasAnyRole("CLIENT", "ADMIN")
				.antMatchers("/users/**", "purchases/**", "/categories/**", "/roles/**", "/suppliers/**", "/stocks/**")
				.hasRole("ADMIN").anyRequest().authenticated().and().httpBasic().and().formLogin().loginPage("/login")
				.defaultSuccessUrl("/home");
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("select user_name as username, user_password as password, 1 as enabled "
						+ "from users " + "where user_name = ?")
				.authoritiesByUsernameQuery("select u.user_name as username, r.role_name as role "
						+ "from users u, users_roles ur, roles r "
						+ "where u.user_id = ur.user_id and r.role_id = ur.role_id and u.user_name  = ?");
	}

	@Bean
	public BCryptPasswordEncoder getEncoder() {
		return new BCryptPasswordEncoder();
	}
}
