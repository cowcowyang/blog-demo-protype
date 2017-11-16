/**  

 * @Title: AuditorAware.java

 * @Prject: blog-demo-protype

 * @Package: com.fyang.me.blogdemo.common.util

 * @Description: TODO

 * @author: "fyang"  

 * @date: 2017年11月16日 上午10:37:04

 * @version: V1.0  

 */
package com.fyang.me.blogdemo.common.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * 
 * @ClassName: AuditorAware
 * 
 * @Description: TODO
 * 
 * @author: "fyang"
 * 
 * @date: 2017年11月16日 上午10:37:04
 * 
 */

@Configuration
public class UserAuditorBean implements AuditorAware<Long> {
	@Override
	public Long getCurrentAuditor() {
		SecurityContext ctx = SecurityContextHolder.getContext();
		if (ctx == null) {
			return null;
		}
		if (ctx.getAuthentication() == null) {
			return null;
		}
		if (ctx.getAuthentication().getPrincipal() == null) {
			return null;
		}
		Object principal = ctx.getAuthentication().getPrincipal();
		if (principal.getClass().isAssignableFrom(Long.class)) {
			return (Long) principal;
		} else {
			return null;
		}
	}
}
