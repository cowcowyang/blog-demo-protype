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

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
	
	@GetMapping("/")
	public String root() {
		return "redirect:/index";
	}

	@GetMapping("/index")
	public String index() {
		return "index";
	}
}
