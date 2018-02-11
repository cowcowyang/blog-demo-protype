package com.fyang.me.blogdemo.domain;

import com.github.rjeschke.txtmark.Processor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

/**
  * @auther:fyang
  * @date: 2018/2/11
  * @description: 博客实体
  *
 */
@Entity
public class Blog extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "标题不能为空")
    @Size(min=2, max=50)
    @Column(nullable = false, length = 50)
    private String title;

    @NotEmpty(message = "摘要不能为空")
    @Size(min=2, max=300)
    @Column(nullable = false)
    private String summary;

    @Lob
    @Basic(fetch=FetchType.LAZY) // 懒加载
    @NotEmpty(message = "内容不能为空")
    @Size(min=2)
    @Column(nullable = false)
    private String content;

    @Lob
    @Basic(fetch=FetchType.LAZY) // 懒加载
    @NotEmpty(message = "内容不能为空")
    @Size(min=2)
    @Column(nullable = false)
    private String htmlContent; // 将 md 转为 html

    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @Column(nullable = false) // 映射为字段，值不能为空
    @org.hibernate.annotations.CreationTimestamp  // 由数据库自动创建时间
    private Timestamp createTime;

    @Column(name="reading")
    private Long clicks = 0L; // 访问量、阅读量

    @Column(name="comments")
    private Long comments = 0L;  // 评论量

    @Column(name="likes")
    private Long likes = 0L;  // 点赞量

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        this.htmlContent = Processor.process(content);
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Long getClicks() {
        return clicks;
    }

    public void setClicks(Long clicks) {
        this.clicks = clicks;
    }

    public Long getComments() {
        return comments;
    }

    public void setComments(Long comments) {
        this.comments = comments;
    }

    public Long getLikes() {
        return likes;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }

    public Blog() {
    }
}
