package com.fyang.me.blogdemo.repository;

import com.fyang.me.blogdemo.domain.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Long> {

}
