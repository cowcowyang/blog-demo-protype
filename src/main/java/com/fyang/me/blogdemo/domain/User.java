package com.fyang.me.blogdemo.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
@EntityListeners(AuditingEntityListener.class)
public class User extends BaseEntity implements UserDetails {

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
	@Size(max = 100)
	@Column(nullable = false,length = 100)
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

	/**
	 * 
	 * @Title:User
	 * 
	 * @Description:TODO
	 * 
	 * @param id
	 * @param userName
	 * @param password
	 * @param email
	 * 
	 */
	public User(Long id, String userName, String password, String email) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.email = email;
	}

	// 用户头像
	@Column(length = 200)
	private String avatar;

	// 用户业务编号
	private String userCode;

	// 用户类型
	private String userType;

	// 用户权限列表
	@ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinTable(name = "user_authority", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
	private List<Authority> authority;

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
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		this.password = encoder.encode(password);
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
	 * 
	 * @Title:User
	 * 
	 * @Description:TODO
	 * 
	 * @param userName
	 * @param password
	 * @param email
	 * @param nickName
	 * @param avatar
	 * @param userCode
	 * @param userType
	 * 
	 */
	public User(String userName, String password, String email, String nickName, String avatar, String userCode,
			String userType) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.nickName = nickName;
		this.avatar = avatar;
		this.userCode = userCode;
		this.userType = userType;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateUserCode() {
		return createUserCode;
	}

	public void setCreateUserCode(String createUserCode) {
		this.createUserCode = createUserCode;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateUserCode() {
		return updateUserCode;
	}

	public void setUpdateUserCode(String updateUserCode) {
		this.updateUserCode = updateUserCode;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", nickName=" + nickName + ", createDate=" + createDate + ", createUserCode=" + createUserCode
				+ ", updateDate=" + updateDate + ", updateUserCode=" + updateUserCode + ", avatar=" + avatar
				+ ", userCode=" + userCode + ", userType=" + userType + "]";
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		for (GrantedAuthority authority : this.authority) {
			authorities.add(new SimpleGrantedAuthority(authority.getAuthority()));
		}
		return authorities;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public List<Authority> getAuthority() {
		return authority;
	}

	public void setAuthority(List<Authority> authority) {
		this.authority = authority;
	}
	
}
