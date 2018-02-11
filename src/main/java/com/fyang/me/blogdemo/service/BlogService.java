package com.fyang.me.blogdemo.service;

import com.fyang.me.blogdemo.domain.Blog;

public interface BlogService{

    Boolean saveBlog(Blog blog);

    Boolean removeBlog(Long blogId);

    Boolean updateBlog(Long blogId);

    Blog queryByBlogId(Long blogId);

}
