package com.example.sys.common;

public interface Constast {
	
	
	/**
	 * 状态码
	 * 
	 */
	public static final Integer OK=200;
	public static final Integer ERROR=-1;

	/**
	 * 菜单权限类型
	 */
	public static final String TYPE_MENU = "menu";
	public static final String TYPE_PERMISSION = "permission";
	/**
	 * 可用 状态
	 */
	public static final Object AVAILABLE_TRUE = 1;
	public static final Object AVAILABLE_FASLSE = 0;

	/**
	 * 用户类型
	 */
	public static final Integer USER_TYPE_SUPER = 0;
	public static final Integer USER_TYPE_NORMAL = 1;

	/**
	 * 展开类型
	 */
	public static final Integer OPEN_TRUE = 1;
	public static final Integer OPEN_FALSE = 0;

}
