/**  

 * @Title: Response.java

 * @Prject: blog-demo-protype

 * @Package: com.fyang.me.blogdemo.vo

 * @Description: TODO

 * @author: "fyang"  

 * @date: 2017年11月10日 下午4:16:55

 * @version: V1.0  

 */
package com.fyang.me.blogdemo.vo;

/**
 * 
 * @ClassName: Response
 * 
 * @Description: 响应类
 * 
 * @author: "fyang"
 * 
 * @date: 2017年11月10日 下午4:16:55
 * 
 */
public class Response<T> {

	// 响应码
	private String code;

	// 响应信息
	private String message;

	// 调用结果
	private boolean success;

	// 传输实体
	private T data;
	

	/**
	
	 * @Title:Response
	
	 * @Description:TODO
	
	 * @param code
	 * @param message
	 * @param success
	 * @param data
	
	 */
	public Response(String code, String message, boolean success, T data) {
		super();
		this.code = code;
		this.message = message;
		this.success = success;
		this.data = data;
	}
	

	/**
	
	 * @Title:Response
	
	 * @Description:TODO
	
	 * @param code
	 * @param message
	 * @param success
	
	 */
	public Response(String code, String message, boolean success) {
		super();
		this.code = code;
		this.message = message;
		this.success = success;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/**
	
	 * @Title: isSuccess
	
	 * @Description: 返回调用是否成功
	
	 * @return: boolean
	
	 */
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
}
