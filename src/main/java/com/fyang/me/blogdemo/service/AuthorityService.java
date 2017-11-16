/**  

 * @Title: AuthorityService.java

 * @Prject: blog-demo-protype

 * @Package: com.fyang.me.blogdemo.service

 * @Description: TODO

 * @author: "fyang"  

 * @date: 2017年11月16日 下午4:49:28

 * @version: V1.0  

 */
package com.fyang.me.blogdemo.service;

import com.fyang.me.blogdemo.domain.Authority;

/**

 * @ClassName: AuthorityService

 * @Description: 权限服务

 * @author: "fyang"

 * @date: 2017年11月16日 下午4:49:28

 */
public interface AuthorityService {
	
	Authority getAuthrotyById(Long id);

}
