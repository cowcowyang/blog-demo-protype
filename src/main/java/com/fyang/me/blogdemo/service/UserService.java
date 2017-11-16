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
 * 
 * @ClassName: UserService
 * 
 * @Description: 用户管理服务
 * 
 * @author: "fyang"
 * 
 * @date: 2017年11月10日 下午4:01:22
 * 
 */
public interface UserService {

	/**
	 * 
	 * @Title: saveUser
	 * 
	 * @Description: 新建用户
	 * 
	 * @param user
	 * @return
	 * 
	 * @return: User
	 * 
	 */
	User saveUser(User user);

	/**
	 * 
	 * @Title: queryUsersByUserName
	 * 
	 * @Description: 根据用户名匹配
	 * 
	 * @param userName
	 * @param paging
	 * @return
	 * 
	 * @return: Page<User>
	 * 
	 */
	Page<User> queryUsersByUserName(String userName, Pageable paging);

	/**
	 * 
	 * @Title: findById
	 * 
	 * @Description: 根据用户Id返回用户信息
	 * 
	 * @param id
	 * @return
	 * 
	 * @return: User
	 * 
	 */
	User queryUserById(Long id);

	/**
	
	 * @Title: deleteUserById
	
	 * @Description: 根据ID删除用户信息
	
	 * @param id
	
	 * @return: void
	
	 */
	void removeUserById(Long id);
	
	/**
	
	 * @Title: queryEntityByUserName
	
	 * @Description: 按照用户名查找用户
	
	 * @param userName
	 * @return
	
	 * @return: User
	
	 */
	User queryEntityByUserName(String userName);

}
