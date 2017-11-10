/**  

 * @Title: BeansExceptionHandler.java

 * @Prject: blog-demo-protype

 * @Package: com.fyang.me.blogdemo.common

 * @Description: TODO

 * @author: "fyang"  

 * @date: 2017年11月10日 下午4:32:35

 * @version: V1.0  

 */
package com.fyang.me.blogdemo.common;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.apache.commons.lang3.StringUtils;

/**

 * @ClassName: BeansExceptionHandler

 * @Description: 实体异常信息处理

 * @author: "fyang"

 * @date: 2017年11月10日 下午4:32:35

 */
public class BeansExceptionHandler {
	
	public static String getErrorMessage(ConstraintViolationException cvException) {
		List<String> exceptionList =  new ArrayList<>();
		for (ConstraintViolation<?> constraintViolation : cvException.getConstraintViolations()) {
			exceptionList.add(constraintViolation.getMessage());
        }
		String messages = StringUtils.join(exceptionList.toArray(), ";");
		return messages;
	}

}
