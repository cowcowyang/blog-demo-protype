/**  

 * @Title: AuthorityRepository.java

 * @Prject: blog-demo-protype

 * @Package: com.fyang.me.blogdemo.repository

 * @Description: TODO

 * @author: "fyang"  

 * @date: 2017年11月16日 下午4:47:39

 * @version: V1.0  

 */
package com.fyang.me.blogdemo.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fyang.me.blogdemo.domain.Authority;

/**

 * @ClassName: AuthorityRepository

 * @Description: 权限表操作

 * @author: "fyang"

 * @date: 2017年11月16日 下午4:47:39

 */
public interface AuthorityRepository extends JpaRepository<Authority, Serializable>{

}
