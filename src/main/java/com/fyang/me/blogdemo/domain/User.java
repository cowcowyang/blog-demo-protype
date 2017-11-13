package com.fyang.me.blogdemo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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

@Entity
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
	@Size(max = 50)
	@Column(length = 50)
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

	public void setEncodedPassword(String password) {
		Md5PasswordEncoder pwdEncoder = new Md5PasswordEncoder();
		this.password = pwdEncoder.encodePassword(password,this.userName);
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
	
	

	/**
	
	 * @Title:User
	
	 * @Description:TODO
	
	 * @param id
	 * @param userName
	 * @param password
	 * @param email
	 * @param nickName
	 * @param avatar
	 * @param userCode
	 * @param userType
	
	 */
	public User(String userName, String password, String email, String nickName, String avatar,
			String userCode, String userType) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.nickName = nickName;
		this.avatar = avatar;
		this.userCode = userCode;
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", nickName=" + nickName + ", avatar=" + avatar + ", userCode=" + userCode + ", userType=" + userType
				+ "]";
	};

}
