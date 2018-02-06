package com.fyang.me.blogdemo.service.impl;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
public class UserServiceImpl implements UserService,UserDetailsService {

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

	/*
	 * (non Javadoc)
	 * 
	 * @Title: queryUsersByUserName
	 * 
	 * @Description: TODO
	 * 
	 * @param userName
	 * 
	 * @param paging
	 * 
	 * @return
	 * 
	 * @see
	 * com.fyang.me.blogdemo.service.UserService#queryUsersByUserName(java.lang.
	 * String, org.springframework.data.domain.Pageable)
	 * 
	 */
	@Override
	public Page<User> queryUsersByUserName(String userName, Pageable paging) {
		userName = "%" + userName + "%";
		Page<User> users = userRepository.findByUserNameLike(userName, paging);
		return users;
	}

	/*
	 * (non Javadoc)
	 * 
	 * @Title: queryUserById
	 * 
	 * @Description: TODO
	 * 
	 * @param id
	 * 
	 * @return
	 * 
	 * @see
	 * com.fyang.me.blogdemo.service.UserService#queryUserById(java.lang.String)
	 * 
	 */
	@Override
	public User queryUserById(Long id) {
		User user = null;
		if (null != id) {
			user = userRepository.findById(id);
		}
		return user;
	}

	/*
	 * (non Javadoc)
	 * 
	 * @Title: removeUserById
	 * 
	 * @Description: TODO
	 * 
	 * @param id
	 * 
	 * @see com.fyang.me.blogdemo.service.UserService#removeUserById(java.lang.Long)
	 * 
	 */
	@Transactional
	@Override
	public void removeUserById(Long id) {
		userRepository.delete(id);
	}

	/*
	 * (non Javadoc)
	 * 
	 * @Title: queryEntityByUserName
	 * 
	 * @Description: TODO
	 * 
	 * @param userName
	 * 
	 * @return
	 * 
	 * @see
	 * com.fyang.me.blogdemo.service.UserService#queryEntityByUserName(java.lang.
	 * String)
	 * 
	 */
	@Override
	public User queryEntityByUserName(String userName) {
		User user = null;
		if (StringUtils.isNotEmpty(userName)) {
			user = userRepository.findByUserName(userName);
		}
		return user;
	}

	/* (non Javadoc)
	
	 * @Title: loadUserByUsername
	
	 * @Description: TODO
	
	 * @param username
	 * @return
	 * @throws UsernameNotFoundException
	
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	
	 */
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		return this.queryEntityByUserName(userName);
	}
}
