package com.fyang.me.blogdemo.service.impl;

import com.fyang.me.blogdemo.domain.Blog;
import com.fyang.me.blogdemo.repository.BlogRepository;
import com.fyang.me.blogdemo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Boolean saveBlog(Blog blog) {
        return null == blogRepository.save(blog);
    }

    @Override
    public Boolean removeBlog(Long blogId) {
        return null;
    }

    @Override
    public Boolean updateBlog(Long blogId) {
        return null;
    }

    @Override
    public Blog queryByBlogId(Long blogId) {
        return blogRepository.findOne(blogId);
    }
}
