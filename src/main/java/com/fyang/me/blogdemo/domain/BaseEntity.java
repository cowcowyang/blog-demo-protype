package com.fyang.me.blogdemo.domain;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

/**

 * @ClassName: BaseEntity

 * @Description: TODO

 * @author: "fyang"

 * @date: 2017年11月10日 下午3:29:54

 */

@MappedSuperclass
public class BaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;

}
