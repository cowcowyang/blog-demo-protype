/**  

 * @Title: SecurityConfig.java

 * @Prject: blog-demo-protype

 * @Package: com.fyang.me.blogdemo.config

 * @Description: TODO

 * @author: "fyang"  

 * @date: 2017年11月16日 下午5:10:45

 * @version: V1.0  

 */
package com.fyang.me.blogdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fyang.me.blogdemo.common.constants.BlogConstants;

/**
 * 
 * @ClassName: SecurityConfig
 * 
 * @Description: SpringSecurity配置
 * 
 * @author: "fyang"
 * 
 * @date: 2017年11月16日 下午5:10:45
 * 
 */

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/css/**", "/js/**", "/fonts/**", "/index").permitAll()
				.antMatchers("/manage/**").hasRole("ADMIN")
				.and()
				.formLogin()
				.loginPage("/login").failureUrl("/login-error")
				.and().rememberMe().key(BlogConstants.SECURITY_KEY)
				.and().exceptionHandling().accessDeniedPage("/403");
	}
	
	@Bean  
    public PasswordEncoder passwordEncoder() {  
        return new BCryptPasswordEncoder();
    } 
	
	@Bean  
    public AuthenticationProvider authenticationProvider() {  
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService);
		authenticationProvider.setPasswordEncoder(passwordEncoder);
        return authenticationProvider;  
    }

	/**
	 * 认证信息管理
	 * @param auth
	 * @throws Exception
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
		auth.authenticationProvider(authenticationProvider());
	}
}
