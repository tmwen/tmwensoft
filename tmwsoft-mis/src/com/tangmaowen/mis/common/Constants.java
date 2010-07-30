package com.tangmaowen.mis.common;

/**
 * @author 唐懋文
 * @since 2009-10-24 下午05:09:26
 *
 */
public class Constants {
	
	/**
	 * 服务器根目录
	 */
	public static final String WEBROOT = "/tmwsoft";
	
	/**
	 * URL请求路径后缀
	 */
	public static final String EXTENSION = "page";
	
	/**
	 * 出现错误时返回给客户端,主要用于EXT请求
	 */
	public static final String SERVERERRORINFO = "服务器端出现错误请稍后再试";
	
	/**
	 * 在session中的用户登录信息ID
	 */
	public static final String USERSESSION = "userInfo";

	/**
	 * 管理员账号
	 */
	public static final Integer ADMIN = 1000;
	
	/**
	 * 来宾账号
	 */
	public static final Integer GUESTID = 0;
	
	/**
	 * 账户启用
	 */
	public static final String USERUSINGACTION = "1";
	
	/**
	 * 账户停用
	 */
	public static final String USERSTOPACTION = "2";

	/**
	 * 账户初始密码
	 */
	public static final String USERINITPASSWORD = "000000";
	
	/**
	 * 菜单类型编码
	 */
	public static final String MENUAUTHCODE = "1";
	
	/**
	 * 学生信息excel模板，学生信息导入导出都使用该模板
	 */
	public static final String STUINFOEXCELTEMP = "/upload/studataExcelTemp.xls";
	
	/**
	 * 消息文件路径，默认路径在服务器同一个目录下
	 */
	public static final String MESSAGEFILE = "../../../upload/message.txt";
	
	//-------------------------action result name----------------------------------
	/**
	 * 对应struts配置文件的result值，系统入口
	 */
	public static final String INDEX = "index";
	
	/**
	 * 对应struts配置文件的result值，用于跳转到登录页面
	 */
	public static final String LOGIN = "login";
	
	/**
	 * 对应struts配置文件的result值，用于跳转到处理json信息的页面
	 */
	public static final String FORWARDJSONINFO = "forwardJsonInfo";

	/**
	 * 对应struts配置文件的result值，用于跳转到错误信息的页面，用于非ajax请求
	 */
	public static final String ERROR = "error";
	
	/**
	 * 对应struts配置文件的result值，用于跳转到框架主页面
	 */
	public static final String MAINFRAME = "mainFrame";
	
}
