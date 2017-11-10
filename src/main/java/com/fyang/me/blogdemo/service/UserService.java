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
	
}
