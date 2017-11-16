/**  

 * @Title: Authority.java

 * @Prject: blog-demo-protype

 * @Package: com.fyang.me.blogdemo.domain

 * @Description: TODO

 * @author: "fyang"  

 * @date: 2017年11月16日 下午4:03:24

 * @version: V1.0  

 */
package com.fyang.me.blogdemo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

/**

 * @ClassName: Authority

 * @Description: TODO

 * @author: "fyang"

 * @date: 2017年11月16日 下午4:03:24

 */

@Entity
public class Authority extends BaseEntity implements GrantedAuthority {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/* (non Javadoc)
	
	 * @Title: getAuthority
	
	 * @Description: 返回权限名
	
	 * @return
	
	 * @see org.springframework.security.core.GrantedAuthority#getAuthority()
	
	 */
	@Override
	public String getAuthority() {
		return name;
	}

}
