package com.fyang.me.blogdemo.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

/**

 * @ClassName: BaseEntity

 * @Description: TODO

 * @author: "fyang"

 * @date: 2017年11月10日 下午3:29:54

 */

@MappedSuperclass
public class BaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	// 创建日期
	@CreatedDate
	protected Date createDate;

	// 创建人员
	protected String createUserCode;

	// 更新日期
	@LastModifiedDate
	protected Date updateDate;

	// 更新人员
	protected String updateUserCode;
	
}
