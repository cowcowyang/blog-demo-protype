package com.fyang.me.blogdemo.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 
 * @ClassName: User
 * 
 * @Description: 用户类
 * 
 * @author: "fyang"
 * 
 * @date: 2017年11月10日 下午3:30:25
 * 
 */
public class User extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// 登陆账号
	@NotEmpty(message = "请输入账号")
	@Size(min = 5, max = 20)
	@Column(nullable = false, length = 20, unique = true)
	private String userName;

	@NotEmpty(message = "请输入密码")
	@Size(max = 20)
	@Column(length = 20)
	private String password;

	@NotEmpty(message = "请输入邮箱")
	@Size(max = 50)
	@Email(message = "请输入正确格式邮箱地址")
	@Column(nullable = false, length = 50, unique = true)
	private String email;

	// 昵称
	@Size(min = 2, max = 20)
	@Column(nullable = true, length = 20)
	private String nickName;

	// 用户头像
	@Column(length = 200)
	private String avatar;

	// 用户业务编号
	private String userCode;

	// 用户类型
	private String userType;

	protected User() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", nickName=" + nickName + ", avatar=" + avatar + ", userCode=" + userCode + ", userType=" + userType
				+ "]";
	};
	
	

}
