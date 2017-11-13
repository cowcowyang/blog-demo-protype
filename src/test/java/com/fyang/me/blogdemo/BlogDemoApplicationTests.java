package com.fyang.me.blogdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fyang.me.blogdemo.controller.UserController;
import com.fyang.me.blogdemo.domain.User;
import com.fyang.me.blogdemo.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogDemoApplicationTests {

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserController UserController;

	@Test
	public void contextLoads() {
	}

	@Test
	public void test() {
		UserController.signUp(new User("test01", "123456", "test@sd.com", "01", "dsad/dsda.jpg", "kdsh283129", "000"));
	}

}
