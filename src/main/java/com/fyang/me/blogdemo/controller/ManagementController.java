/**  

 * @Title: ManagementController.java

 * @Prject: blog-demo-protype

 * @Package: com.fyang.me.blogdemo.controller

 * @Description: TODO

 * @author: "fyang"  

 * @date: 2017年11月14日 下午4:32:32

 * @version: V1.0  

 */
package com.fyang.me.blogdemo.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fyang.me.blogdemo.domain.Menu;


/**

 * @ClassName: ManagementController

 * @Description: 管理页面接口

 * @author: "fyang"

 * @date: 2017年11月14日 下午4:32:32

 */
@Controller
@RequestMapping("/manage")
public class ManagementController extends BaseController {
	
	@GetMapping
	public ModelAndView usersDashbord(Model model) {
		List<Menu> list = new ArrayList<>();
		list.add(new Menu("用户管理", "/users"));
		model.addAttribute("list", list);
		return new ModelAndView("admins/index","model",model);
	}
	
}	
