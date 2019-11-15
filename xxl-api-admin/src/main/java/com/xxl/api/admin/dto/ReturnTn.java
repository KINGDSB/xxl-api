package com.xxl.api.admin.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * common return
 * @author xuxueli 2015-12-4 16:32:31
 * @param <T>
 */
@Data
public class ReturnTn<T> implements Serializable {
	public static final long serialVersionUID = 42L;

	public static final int SUCCESS_CODE = 200;
	public static final int FAIL_CODE = 500;
	public static final int UPDARE_CODE = 400;
	public static final int INSERT_CODE = 200;
	public static final ReturnTn<String> SUCCESS = new ReturnTn<String>(null);
	public static final ReturnTn<String> FAIL = new ReturnTn<String>(FAIL_CODE, null);
	public static final String UPDATE_SUSESS="更新成功";
	public static final String APPLY_PASS="申请通过";
	public static final String APPLY_NOT_PASS="申请未通过";
	public static final String SELECT_SUCCESS="查询成功";
	public static final String SELECT_FAIL="查询失败";
	private int code;
	private String msg;
	private T promise;
	public ReturnTn(int failCode, String msg) {
		this.code = failCode;
		this.msg = msg;
	}

	public ReturnTn(int code, String msg, T promise) {
		super();
		this.code = code;
		this.msg = msg;
		this.promise = promise;
	}
	
	
	public ReturnTn(T promise) {
		this.code = SUCCESS_CODE;
		this.promise = promise;
	}
	public static ReturnTn success(Object promise) {
		return new ReturnTn(promise);
	}

	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public T getPromise() {
		return promise;
	}
	public void setPromise(T promise) {
		this.promise = promise;
	}

	@Override
	public String toString() {
		return "ReturnT [code=" + code + ", msg=" + msg + ", promise=" + promise + "]";
	}

}
