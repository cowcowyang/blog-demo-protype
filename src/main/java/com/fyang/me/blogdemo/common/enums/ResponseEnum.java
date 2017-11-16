/**  

 * @Title: ResponseEnum.java

 * @Prject: blog-demo-protype

 * @Package: com.fyang.me.blogdemo.common.enums

 * @Description: TODO

 * @author: "fyang"  

 * @date: 2017年11月15日 下午5:49:50

 * @version: V1.0  

 */
package com.fyang.me.blogdemo.common.enums;

/**
 * 
 * @ClassName: ResponseEnum
 * 
 * @Description: TODO
 * 
 * @author: "fyang"
 * 
 * @date: 2017年11月15日 下午5:49:50
 * 
 */
public enum ResponseEnum {

	Success("000", "success"), Fail("999", "false");

	private String code;
	private String msg;

	/**
	 * 
	 * @Title:ResponseEnum
	 * 
	 * @Description:TODO
	 * 
	 * @param code
	 * @param msg
	 * 
	 */
	private ResponseEnum(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean isSuccess() {
		return Success.getCode().equals(this.code);
	}

	public static ResponseEnum get(String code) {
		for (ResponseEnum response : ResponseEnum.values()) {
			if (response.getCode().equals(code))
				return response;
		}
		throw new IllegalArgumentException("ResponseType is not exist : " + code);
	}
}
