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

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fyang.me.blogdemo.common.BeansExceptionHandler;
import com.fyang.me.blogdemo.common.BlogConstants;
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
		return ResponseEntity.ok().body(new Response<User>("000", "处理成功", true, saveUser));
	}

	@GetMapping
	public ModelAndView getList(@RequestParam(value = "async", required = false) boolean async,
			@RequestParam(value = "pageIndex", required = false, defaultValue = "0") int pageIndex,
			@RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
			@RequestParam(value = "userName", required = false, defaultValue = "") String userName, Model model) {

		PageRequest pageRequest = new PageRequest(pageIndex, pageSize);
		Page<User> pagingData = userService.queryUsersByUserName(userName, pageRequest);
		List<User> userList = pagingData.getContent();

		model.addAttribute("paging", pagingData);
		model.addAttribute("userList", userList);

		return new ModelAndView(async == true ? "users/list :: #userList" : "users/list", "usersModel", model);
	}

}
