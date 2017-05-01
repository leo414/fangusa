package com.hhh.fangusa.exception;

public class ExceptionConst {

	// 参数
    public static final Integer PARAM_EXCEPTION = 100;
	// 缺少参数
	public static final Integer PARAM_MISSING_EXCEPTION = 101;
	// 参数验证失败
	public static final Integer PARAM_INCONFORMITY_EXCEPTION = 102;

	// 数据
	public static final Integer DATA_EXCEPTION = 200;
	// 没有数据权限失败
	public static final Integer DATA_PERMISSION_EXCEPTION = 201;

	// 业务
	public static final Integer BUSINESS_EXCEPTION = 300;

	// 调用其他系统异常
	public static final Integer OTHER_APP_EXCEPTION = 500;

	// 没有权限
	public static final Integer NOT_CURRENT_PERMISSION = 401;

	// 未知异常
	public static final Integer UNKNOW_EXCEPTION = 999;
}