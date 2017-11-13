/**  

 * @Title: UserServiceImpl.java

 * @Prject: blog-demo-protype

 * @Package: com.fyang.me.blogdemo.service.impl

 * @Description: TODO

 * @author: "fyang"  

 * @date: 2017年11月10日 下午4:03:35

 * @version: V1.0  

 */
package com.fyang.me.blogdemo.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fyang.me.blogdemo.domain.User;
import com.fyang.me.blogdemo.repository.UserRepository;
import com.fyang.me.blogdemo.service.UserService;

/**
 * 
 * @ClassName: UserServiceImpl
 * 
 * @Description: TODO
 * 
 * @author: "fyang"
 * 
 * @date: 2017年11月10日 下午4:03:35
 * 
 */

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	/*
	 * (non Javadoc)
	 * 
	 * @Title: saveUser
	 * 
	 * @Description: TODO
	 * 
	 * @param user
	 * 
	 * @return
	 * 
	 * @see
	 * com.fyang.me.blogdemo.service.UserService#saveUser(com.fyang.me.blogdemo.
	 * domain.User)
	 * 
	 */
	@Transactional
	@Override
	public User saveUser(User user) {
		User save = userRepository.save(user);
		return save;
	}

}
