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

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fyang.me.blogdemo.common.BeansExceptionHandler;
import com.fyang.me.blogdemo.domain.User;
import com.fyang.me.blogdemo.service.UserService;
import com.fyang.me.blogdemo.vo.Response;

/**
 * 
 * @ClassName: UserController
 * 
 * @Description: TODO
 * 
 * @author: "fyang"
 * 
 * @date: 2017年11月10日 下午4:10:04
 * 
 */

@RestController
@RequestMapping("/users")
public class UserController extends BaseController {

	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity<Response<User>> signUp(User user) {
		User saveUser = null;
		try {
			user.setEncodedPassword(user.getPassword());
			saveUser = userService.saveUser(user);
		} catch (ConstraintViolationException e) {
			return ResponseEntity.ok().body(new Response<User>("998", BeansExceptionHandler.getErrorMessage(e), false));
		}
		return ResponseEntity.ok().body(new Response<User>("000","处理成功",true,saveUser));
	}
}
