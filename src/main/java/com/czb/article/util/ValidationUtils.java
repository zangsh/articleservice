package com.czb.article.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.groups.Default;

import com.czb.article.common.ValidationResult;

/**
 * <p>Title: ValidationUtils.java</p>
 * <p>Description: 参数验证工具类</p>
 * @author zhxun
 * @date 2018年6月22日上午10:23:07
 */
public class ValidationUtils {
	
	private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

	public static <T> ValidationResult validateEntity(T obj) {
		ValidationResult result = new ValidationResult();
		Set<ConstraintViolation<T>> set = validator.validate(obj, Default.class);
		if (set != null && set.size() != 0) {
			result.setHasErrors(true);
			Map<String, String> errorMsg = new HashMap<String, String>();
			for (ConstraintViolation<T> cv : set) {
				errorMsg.put(cv.getPropertyPath().toString(), cv.getMessage());
			}
			result.setErrorMsg(errorMsg);
		}
		return result;
	}

	public static <T> ValidationResult validateProperty(T obj, String propertyName) {
		ValidationResult result = new ValidationResult();
		Set<ConstraintViolation<T>> set = validator.validateProperty(obj, propertyName, Default.class);
		if (set != null && set.size() != 0) {
			result.setHasErrors(true);
			Map<String, String> errorMsg = new HashMap<String, String>();
			for (ConstraintViolation<T> cv : set) {
				errorMsg.put(propertyName, cv.getMessage());
			}
			result.setErrorMsg(errorMsg);
		}
		return result;
	}
}
