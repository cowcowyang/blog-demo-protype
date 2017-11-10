/**  

 * @Title: UserController.java

 * @Prject: blog-demo-protype

 * @Package: com.fyang.me.blogdemo.controller

 * @Description: TODO

 * @author: "fyang"  

 * @date: 2017年11月10日 下午4:10:04

 * @version: V1.0  

 */
package com.fyang.me.blogdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fyang.me.blogdemo.service.UserService;

/**

 * @ClassName: UserController

 * @Description: TODO

 * @author: "fyang"

 * @date: 2017年11月10日 下午4:10:04

 */

@RestController
@RequestMapping("/users")
public class UserController extends BaseController{
	
	@Autowired
	private UserService userService;
	
	
	
}
