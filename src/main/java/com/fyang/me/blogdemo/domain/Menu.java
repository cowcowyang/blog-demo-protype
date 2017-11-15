/**  

 * @Title: Menu.java

 * @Prject: blog-demo-protype

 * @Package: com.fyang.me.blogdemo.domain

 * @Description: TODO

 * @author: "fyang"  

 * @date: 2017年11月15日 下午3:22:20

 * @version: V1.0  

 */
package com.fyang.me.blogdemo.domain;

import javax.persistence.Entity;

/**
 * 
 * @ClassName: Menu
 * 
 * @Description: 菜单实体
 * 
 * @author: "fyang"
 * 
 * @date: 2017年11月15日 下午3:22:20
 * 
 */

public class Menu extends BaseEntity {

	private static final long serialVersionUID = 1L;

	// 菜单名称
	private String name;

	// 菜单链接地址
	private String url;

	/**
	 * @Title:Menu
	 * @param name
	 * @param url
	
	 */
	public Menu(String name, String url) {
		super();
		this.name = name;
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
