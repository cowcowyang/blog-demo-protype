package com.fyang.me.blogdemo.controller;

import com.fyang.me.blogdemo.common.enums.ResponseEnum;
import com.fyang.me.blogdemo.domain.Blog;
import com.fyang.me.blogdemo.domain.User;
import com.fyang.me.blogdemo.service.BlogService;
import com.fyang.me.blogdemo.vo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/b")
public class BlogController extends BaseController{

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private BlogService blogService;

    @GetMapping("/{userName}/edit")
    public ModelAndView createBlog(Model model) {
        model.addAttribute("blog", new Blog());
        return new ModelAndView("/userspace/blogedit", "blogModel", model);
    }

    @PostMapping("/{userName}/blogs/edit")
    @PreAuthorize("authentication.name.equals(#userName)")
    public ResponseEntity<Response<String>> saveBlog(@PathVariable("userName") String userName, @RequestBody Blog blog) {
        Response<String> resp =  new Response<>(ResponseEnum.Success);
        User user = (User)userDetailsService.loadUserByUsername(userName);
        blog.setUser(user);
        blogService.saveBlog(blog);

        String redirectUrl = "/u/" + userName + "/blogs/" + blog.getId();
        resp.setData(redirectUrl);
        return ResponseEntity.ok().body(resp);
    }

}
