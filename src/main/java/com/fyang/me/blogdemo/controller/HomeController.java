/**  

 * @Title: HomeController.java

 * @Prject: blog-demo-protype

 * @Package: com.fyang.me.blogdemo.controller

 * @Description: TODO

 * @author: "fyang"  

 * @date: 2017年11月14日 下午3:35:55

 * @version: V1.0  

 */
package com.fyang.me.blogdemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.fyang.me.blogdemo.common.constants.BlogConstants;
import com.fyang.me.blogdemo.domain.Authority;
import com.fyang.me.blogdemo.domain.User;
import com.fyang.me.blogdemo.service.AuthorityService;
import com.fyang.me.blogdemo.service.UserService;


/**
 * 
 * @ClassName: HomeController
 * 
 * @Description: TODO
 * 
 * @author: "fyang"
 * 
 * @date: 2017年11月14日 下午3:35:55
 * 
 */
@Controller
public class HomeController extends BaseController {
	
	@Autowired
	private AuthorityService authorityService;
	
	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String root() {
		return "redirect:/manage";
	}

	@GetMapping("/index")
	public String index() {
		return "index";
	}

	/**
	 * 获取登录界面
	 * 
	 * @return
	 */
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/login-error")
	public String loginError(Model model) {
		model.addAttribute("loginError", true);
		model.addAttribute("errorMsg", "登陆失败，账号或者密码错误！");
		return "login";
	}

	@GetMapping("/register")
	public String register() {
		return "register";
	}

	@PostMapping("/register")
	public String registerUser(User user) {
		List<Authority> authorities = new ArrayList<>();
		authorities.add(authorityService.getAuthrotyById(BlogConstants.ROLE_USER_AUTHORITY_ID));
		user.setAuthority(authorities);
		userService.saveUser(user);
		return "redirect:/login";
	}

	@GetMapping("/search")
	public String search() {
		return "search";
	}
}
