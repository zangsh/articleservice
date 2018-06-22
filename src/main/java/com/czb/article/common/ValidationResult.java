package com.czb.article.common;

import java.util.Map;

/**
 * <p>Title: ValidationResult.java</p>
 * <p>Description: 参数验证返回</p>
 * @author zhxun
 * @date 2018年6月22日上午10:21:56
 */
public class ValidationResult {
	
	// 校验结果是否有错
	private boolean hasErrors;
	
	// 校验错误信息
	private Map<String, String> errorMsg;
	
	public boolean isHasErrors() {
		return hasErrors;
	}
	public void setHasErrors(boolean hasErrors) {
		this.hasErrors = hasErrors;
	}
	public Map<String, String> getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(Map<String, String> errorMsg) {
		this.errorMsg = errorMsg;
	}
}
