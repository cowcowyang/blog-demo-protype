/**  

 * @Title: UserRepository.java

 * @Prject: blog-demo-protype

 * @Package: com.fyang.me.blogdemo.repository

 * @Description: TODO

 * @author: "fyang"  

 * @date: 2017年11月10日 下午4:49:11

 * @version: V1.0  

 */
package com.fyang.me.blogdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fyang.me.blogdemo.domain.User;

/**
 * 
 * @ClassName: UserRepository
 * 
 * @Description: User 持久层接口
 * 
 * @author: "fyang"
 * 
 * @date: 2017年11月10日 下午4:49:11
 * 
 */
public interface UserRepository extends JpaRepository<User, Long> {

	User findByCode(String userCode);

}
