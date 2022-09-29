package com.xtd.ybls.enums;

import com.xtd.ybls.exception.BaseErrorInfoInterface;

/**
 * @author 冯瑞宁
 */

public enum CommonEnum implements BaseErrorInfoInterface {
	// 数据操作错误定义
	SUCCESS("200", "成功!"), 
	BODY_NOT_MATCH("400","空指针异常!"),
	NOT_FOUND("404", "未找到该资源!"), 
	INTERNAL_SERVER_ERROR("500", "服务器内部错误!"),
	SERVER_BUSY("503","服务器正忙，请稍后再试!"),
	ARITHMETIC_IS_ILLEGAL("500","算术异常!"),
	OPERATION_DATABASE_EXCEPTION("500","操作数据库异常!"),
	ARRAY_INDEX_OUT_OF_BOUNDS_EXCEPTION("500","数组索引越界异常!"),
	BAD_SQL_GRAMMAR_EXCEPTION("500","错误的sql参数异常"),
	DUPLICATE_KEY_EXCEPTION("500","主键冲突")
	;

	/** 错误码 */
	private String resultCode;

	/** 错误描述 */
	private String resultMsg;

	CommonEnum(String resultCode, String resultMsg) {
		this.resultCode = resultCode;
		this.resultMsg = resultMsg;
	}

	@Override
	public String getResultCode() {
		return resultCode;
	}

	@Override
	public String getResultMsg() {
		return resultMsg;
	}

}