package com.tangmaowen.mis.common;

/**
 * 权限映射，与struts.xml的action对应
 * @author 唐懋文
 * @since 2009-10-25 上午10:51:18
 * 
 */
public class AuthorityConstants {
/**
	// C: COMMON M: MENU A: ACTION D: DATA
	// 首页权限
	public static final String C_INDEX = "/mis/index";
	// 登录权限
	public static final String C_LOGIN = "/mis/login";// 不验证
	public static final String C_LOGOUT = "/mis/logout";// 不验证
	
	// 菜单权限
	public static final String M_STU_BASEINFO = "/mis/xhzy/sms/studentsBaseInfoIndex";
	public static final String M_STU_FEES = "/mis/xhzy/sms/studentsFeesIndex";
	public static final String M_STU_SEARCH = "/mis/xhzy/sms/stuSearchIndex";
	public static final String M_SYS_USERS = "/mis/sys/usersIndex";
	public static final String M_SYS_AUTH = "/mis/sys/authorityIndex";
	public static final String M_SYS_DIC = "/mis/sys/dictionaryIndex";
	public static final String M_SYS_LOG = "/mis/sys/logIndex";
	public static final String M_SYS_SET = "/mis/sys/setupIndex";
	public static final String M_SYS_USER_SET = "/mis/sys/userIndex";
	
	// 功能按钮权限
	// 系统管理
	// 个人设置
	public static final String A_SYS_USER_ALTER_PASSWORD = "/mis/sys/alterUserPasswordByUser";
	public static final String A_SYS_USER_UPDATE_INFO = "/mis/sys/updateUserInfoByUser";
	public static final String A_SYS_USER_GET_INFO = "/mis/sys/getUserInfoByUser";
	// 用户管理
	public static final String A_SYS_USERS_GET_LIST = "/mis/sys/getUsersList";
	public static final String A_SYS_USERS_INSERT_USERINFO = "/mis/sys/insertUserInfoByUsers";
	public static final String A_SYS_USERS_UPDATE_USERINFO = "/mis/sys/updateUserInfoByUsers";
	public static final String A_SYS_USERS_GET_USERINFO = "/mis/sys/getUserInfoByUsers";
	public static final String A_SYS_USERS_CHANGE_USERACTIVE = "/mis/sys/changeUserActive";
	public static final String A_SYS_USERS_GET_USERROLE = "/mis/sys/getUserRole";
	public static final String A_SYS_USERS_UPDATE_USERROLE = "/mis/sys/updateUserRole";
	// 数据字典
	public static final String A_SYS_DICT_GET_ENTRY_LIST = "/mis/sys/getEntryList";
	public static final String A_SYS_DICT_INSERT_ENTRY = "/mis/sys/insertEntry";
	public static final String A_SYS_DICT_UPDATE_ENTRY = "/mis/sys/updateEntry";
	public static final String A_SYS_DICT_DELETE_ENTRY = "/mis/sys/deleteEntry";
	// 角色权限
	public static final String A_SYS_AUTH_GET_ROLEAUTH_LIST = "/mis/sys/getRoleAuthList";
	public static final String A_SYS_AUTH_UPDATE_ROLEAUTH = "/mis/sys/updateRoleAuth";
	public static final String A_SYS_AUTH_GET_ROLEINFO = "/mis/sys/getRoleInfo";
	public static final String A_SYS_AUTH_INSERT_ROLE = "/mis/sys/insertRole";
	public static final String A_SYS_AUTH_UPDATE_ROLE = "/mis/sys/updateRole";
	public static final String A_SYS_AUTH_DELETE_ROLE = "/mis/sys/deleteRole";
	// 业务日志
	public static final String A_SYS_LOG_GET_LIST = "/mis/sys/getLogList";
	public static final String A_SYS_LOG_GET_INFO = "/mis/sys/getLogInfo";
	
	// 入学管理
	// 学生基本信息
	public static final String A_STU_BASEINFO_GET_LIST = "/mis/xhzy/sms/getStudentsBaseInfoList";
	public static final String A_STU_BASEINFO_INSERT = "/mis/xhzy/sms/insertStudentBaseInfo";
	public static final String A_STU_BASEINFO_UPDATE = "/mis/xhzy/sms/updateStudentBaseInfo";
	public static final String A_STU_BASEINFO_DELETE = "/mis/xhzy/sms/deleteStudentBaseInfo";
	public static final String A_STU_BASEINFO_GET = "/mis/xhzy/sms/getStudentBaseInfo";
	// 学生缴费信息
	public static final String A_STU_FEES_GET_STUDENTS_LIST = "/mis/xhzy/sms/getStudentsFeesList";
	public static final String A_STU_FEES_GET_STUDENT_LIST = "/mis/xhzy/sms/getStudentFeesList";
	public static final String A_STU_FEES_INSERT = "/mis/xhzy/sms/insertStudentFees";
	public static final String A_STU_FEES_UPDATE = "/mis/xhzy/sms/updateStudentFees";
	public static final String A_STU_FEES_DELETE = "/mis/xhzy/sms/deleteStudentFees";
	public static final String A_STU_BASEINFO_UPDATE_FEE = "/mis/xhzy/sms/updateStuInfoByFee";
	// 综合查询
	public static final String A_STU_DATA_GET_STUBASEINFO_LIST = "/mis/xhzy/sms/getStuBaseInfoListBySearch";
	public static final String A_STU_DATA_STUBASEINFO_IMPORT = "/mis/xhzy/sms/stuBaseInfoImport";
	public static final String A_STU_DATA_STUBASEINFO_EXPORT = "/mis/xhzy/sms/stuBaseInfoExport";
*/	
	// 数据约束
	public static final String D_ONESELF = "oneselfData";// 创建者或修改者
	public static final String D_ALL = "allData";
	
	// 管理员id
	public static final String ADMIN_ROLE_ID ="1";

}
