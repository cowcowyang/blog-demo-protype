/**  

 * @Title: AuthorityServiceImpl.java

 * @Prject: blog-demo-protype

 * @Package: com.fyang.me.blogdemo.service.impl

 * @Description: TODO

 * @author: "fyang"  

 * @date: 2017年11月16日 下午4:52:22

 * @version: V1.0  

 */
package com.fyang.me.blogdemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fyang.me.blogdemo.domain.Authority;
import com.fyang.me.blogdemo.repository.AuthorityRepository;
import com.fyang.me.blogdemo.service.AuthorityService;

/**

 * @ClassName: AuthorityServiceImpl

 * @Description: TODO

 * @author: "fyang"

 * @date: 2017年11月16日 下午4:52:22

 */

@Service
public class AuthorityServiceImpl implements AuthorityService{

	@Autowired
	private AuthorityRepository authorityRepository;
	
	@Override
	public Authority getAuthrotyById(Long id) {
		return authorityRepository.findOne(id);
	}

}
