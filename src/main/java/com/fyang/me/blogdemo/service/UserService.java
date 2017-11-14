/**  

 * @Title: UserService.java

 * @Prject: blog-demo-protype

 * @Package: com.fyang.me.blogdemo.service

 * @Description: TODO

 * @author: "fyang"  

 * @date: 2017年11月10日 下午4:01:22

 * @version: V1.0  

 */
package com.fyang.me.blogdemo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fyang.me.blogdemo.domain.User;

/**

 * @ClassName: UserService

 * @Description: 用户管理服务

 * @author: "fyang"

 * @date: 2017年11月10日 下午4:01:22

 */
public interface UserService {
	
	/**
	
	 * @Title: saveUser
	
	 * @Description: 新建用户
	
	 * @param user
	 * @return
	
	 * @return: User
	
	 */
	User saveUser(User user);
	
	/**
	
	 * @Title: queryUsersByUserName
	
	 * @Description: 根据用户名匹配
	
	 * @param userName
	 * @param paging
	 * @return
	
	 * @return: Page<User>
	
	 */
	Page<User> queryUsersByUserName(String userName,Pageable paging);
	
}
