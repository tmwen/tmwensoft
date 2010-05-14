SET @ADMIN_ID = 1000;
INSERT INTO users ( userid, active, username, password, creater, createtime, lastupdater, lastupdatertime ) VALUES (@ADMIN_ID, '1', '系统管理员', '670b14728ad9902aecba32e22fa4f6bd', @ADMIN_ID, '2009-11-11 11:11:11', @ADMIN_ID, '2009-11-11 11:11:11');

INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('xb', '性别', 'root', 0, 1);
INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('mz', '民族', 'root', 0, 2);
INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('bkxl', '报读学历', 'root', 0, 3);
INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('jj', '季', 'root', 0, 4);
INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('bdzydz', '报读专业(大专)', 'root', 0, 5);
INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('bdzyzz', '报读专业(中专)', 'root', 0, 6);
INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('zzmm', '政治面貌', 'root', 0, 7);
INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('hj', '户籍', 'root', 0, 8);
INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('kslb', '考生类别', 'root', 0, 9);
INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('yklx', '中考/高考', 'root', 0, 10);
INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('byz', '毕业证', 'root', 0, 11);
INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('zs', '政审', 'root', 0, 12);
INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('tj', '体检', 'root', 0, 13);
INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('lq', '录取', 'root', 0, 14);
INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('jflx', '交费类型', 'root', 0, 15);
INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('userActive', '用户状态', 'root', 0, 16);
INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('active', '记录状态', 'root', 0, 17);
INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('authType', '权限类型', 'root', 0, 18);
INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('bdk', '报到卡', 'root', 0, 19);

INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('1', '男', 'xb', 1, 1);
INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('2', '女', 'xb', 1, 2);

INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('1', '汉族', 'mz', 1, 1);
INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('2', '彝族', 'mz', 1, 2);
INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('3', '藏族', 'mz', 1, 3);
INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('4', '羌族', 'mz', 1, 4);
INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('5', '苗族', 'mz', 1, 5);
INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('6', '其他', 'mz', 1, 6);

INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('1', '大专', 'bkxl', 1, 1);
INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('2', '中专', 'bkxl', 1, 2);

INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('1', '春季', 'jj', 1, 1);
INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('2', '秋季', 'jj', 1, 2);

INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('11', '空中乘务', 'bdzydz', 1, 1);
INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('12', '航空安检', 'bdzydz', 1, 2);
INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('13', '航空机电设备维修', 'bdzydz', 1, 3);
INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('14', '航空服务', 'bdzydz', 1, 4);

INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('11', '空中乘务', 'bdzyzz', 1, 1);
INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('12', '航空安检', 'bdzyzz', 1, 2);
INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('13', '空港服务', 'bdzyzz', 1, 3);

INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('1', '党员', 'zzmm', 1, 1);
INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('2', '团员', 'zzmm', 1, 2);
INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('3', '其他', 'zzmm', 1, 3);

INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('1', '城镇', 'hj', 1, 1);
INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('2', '农村', 'hj', 1, 2);

INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('1', '初中应届', 'kslb', 1, 1);
INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('2', '初中往届', 'kslb', 1, 2);
INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('3', '农民工', 'kslb', 1, 3);
INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('4', '退役军人', 'kslb', 1, 4);

INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('1', '高考', 'yklx', 1, 1);
INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('2', '中考', 'yklx', 1, 2);

INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('1', '高中', 'byz', 1, 1);
INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('2', '初中', 'byz', 1, 2);
INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('3', '无', 'byz', 1, 3);

INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('1', '合格', 'zs', 1, 1);
INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('2', '不合格', 'zs', 1, 2);

INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('1', '合格', 'tj', 1, 1);
INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('2', '不合格', 'tj', 1, 2);

INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('1', '录取', 'lq', 1, 1);
INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('2', '否', 'lq', 1, 2);

INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('1', '预交费', 'jflx', 1, 1);
INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('2', '缴费', 'jflx', 1, 2);

INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('1', '启用', 'userActive', 1, 1);
INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('2', '停用', 'userActive', 1, 2);

INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('1', '有效', 'active', 1, 1);
INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('2', '无效', 'active', 1, 2);

INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('1', '菜单', 'authType', 1, 1);
INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('2', '动作', 'authType', 1, 2);
INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('3', '数据', 'authType', 1, 3);
INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('4', '页面', 'authType', 1, 4);

INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('1', '已领', 'bdk', 1, 1);
INSERT INTO dictionary ( dictcode, codecontent, parentcode, level, levelseq ) VALUES ('2', '未领', 'bdk', 1, 2);

INSERT INTO authority ( authid, authname, authdesc, authtype ) VALUES ('/mis/xhzy/sms/studentsBaseInfoIndex', '学生基本信息', '学生管理', '1');
INSERT INTO authority ( authid, authname, authdesc, authtype ) VALUES ('/mis/xhzy/sms/studentsFeesIndex', '学生缴费信息', '学生管理', '1');
INSERT INTO authority ( authid, authname, authdesc, authtype ) VALUES ('/mis/xhzy/sms/stuSearchIndex', '综合查询', '学生管理', '1');
INSERT INTO authority ( authid, authname, authdesc, authtype ) VALUES ('/mis/sys/usersIndex', '用户管理', '系统管理', '1');
INSERT INTO authority ( authid, authname, authdesc, authtype ) VALUES ('/mis/sys/authorityIndex', '角色权限', '系统管理', '1');
INSERT INTO authority ( authid, authname, authdesc, authtype ) VALUES ('/mis/sys/dictionaryIndex', '数据字典', '系统管理', '1');
INSERT INTO authority ( authid, authname, authdesc, authtype ) VALUES ('/mis/sys/logIndex', '业务日志', '系统管理', '1');
INSERT INTO authority ( authid, authname, authdesc, authtype ) VALUES ('/mis/sys/setupIndex', '系统设置', '系统管理', '1');
INSERT INTO authority ( authid, authname, authdesc, authtype ) VALUES ('/mis/sys/userIndex', '个人设置', '系统管理', '1');
INSERT INTO authority ( authid, authname, authdesc, authtype ) VALUES ('/mis/sys/messageIndex', '消息设置', '系统管理', '1');
INSERT INTO authority ( authid, authname, authdesc, authtype ) VALUES ('/mis/sys/alterUserPasswordByUser', '个人密码修改', '个人设置', '2');
INSERT INTO authority ( authid, authname, authdesc, authtype ) VALUES ('/mis/sys/updateUserInfoByUser', '个人信息修改', '个人设置', '2');
INSERT INTO authority ( authid, authname, authdesc, authtype ) VALUES ('/mis/sys/getUserInfoByUser', '个人信息查看', '个人设置', '2');
INSERT INTO authority ( authid, authname, authdesc, authtype ) VALUES ('/mis/sys/getUsersList', '用户列表', '用户管理', '2');
INSERT INTO authority ( authid, authname, authdesc, authtype ) VALUES ('/mis/sys/insertUserInfoByUsers', '用户新增', '用户管理', '2');
INSERT INTO authority ( authid, authname, authdesc, authtype ) VALUES ('/mis/sys/updateUserInfoByUsers', '用户信息修改', '用户管理', '2');
INSERT INTO authority ( authid, authname, authdesc, authtype ) VALUES ('/mis/sys/getUserInfoByUsers', '用户信息查看', '用户管理', '2');
INSERT INTO authority ( authid, authname, authdesc, authtype ) VALUES ('/mis/sys/changeUserActive', '用户状态设置', '用户管理', '2');
INSERT INTO authority ( authid, authname, authdesc, authtype ) VALUES ('/mis/sys/getUserRole', '用户角色查看', '用户管理', '2');
INSERT INTO authority ( authid, authname, authdesc, authtype ) VALUES ('/mis/sys/updateUserRole', '用户角色修改', '用户管理', '2');
INSERT INTO authority ( authid, authname, authdesc, authtype ) VALUES ('/mis/sys/resetPasswordByUsers', '重置用户密码', '用户管理', '2');
INSERT INTO authority ( authid, authname, authdesc, authtype ) VALUES ('/mis/sys/getEntryList', '字典列表', '数据字典', '2');
INSERT INTO authority ( authid, authname, authdesc, authtype ) VALUES ('/mis/sys/insertEntry', '字典条目新增', '数据字典', '2');
INSERT INTO authority ( authid, authname, authdesc, authtype ) VALUES ('/mis/sys/updateEntry', '字典条目修改', '数据字典', '2');
INSERT INTO authority ( authid, authname, authdesc, authtype ) VALUES ('/mis/sys/deleteEntry', '字典条目删除', '数据字典', '2');
INSERT INTO authority ( authid, authname, authdesc, authtype ) VALUES ('/mis/sys/getRoleAuthList', '角色权限列表', '角色权限', '2');
INSERT INTO authority ( authid, authname, authdesc, authtype ) VALUES ('/mis/sys/updateRoleAuth', '角色权限修改', '角色权限', '2');
INSERT INTO authority ( authid, authname, authdesc, authtype ) VALUES ('/mis/sys/getRoleInfo', '角色信息查看', '角色权限', '2');
INSERT INTO authority ( authid, authname, authdesc, authtype ) VALUES ('/mis/sys/insertRole', '角色新增', '角色权限', '2');
INSERT INTO authority ( authid, authname, authdesc, authtype ) VALUES ('/mis/sys/updateRole', '角色信息修改', '角色权限', '2');
INSERT INTO authority ( authid, authname, authdesc, authtype ) VALUES ('/mis/sys/deleteRole', '角色删除', '角色权限', '2');
INSERT INTO authority ( authid, authname, authdesc, authtype ) VALUES ('/mis/sys/getLogList', '业务日志列表', '业务日志', '2');
INSERT INTO authority ( authid, authname, authdesc, authtype ) VALUES ('/mis/sys/getLogInfo', '业务日志信息查看', '业务日志', '2');
INSERT INTO authority ( authid, authname, authdesc, authtype ) VALUES ('/mis/sys/updateMessageInfo', '消息修改', '消息设置', '2');
INSERT INTO authority ( authid, authname, authdesc, authtype ) VALUES ('/mis/xhzy/sms/getStudentsBaseInfoList', '学生基本信息列表', '学生基本信息', '2');
INSERT INTO authority ( authid, authname, authdesc, authtype ) VALUES ('/mis/xhzy/sms/insertStudentBaseInfo', '学生基本信息新增', '学生基本信息', '2');
INSERT INTO authority ( authid, authname, authdesc, authtype ) VALUES ('/mis/xhzy/sms/updateStudentBaseInfo', '学生基本信息修改', '学生基本信息', '2');
INSERT INTO authority ( authid, authname, authdesc, authtype ) VALUES ('/mis/xhzy/sms/deleteStudentBaseInfo', '学生基本信息删除', '学生基本信息', '2');
INSERT INTO authority ( authid, authname, authdesc, authtype ) VALUES ('/mis/xhzy/sms/getStudentBaseInfo', '学生基本信息查看', '学生基本信息', '2');

INSERT INTO authority ( authid, authname, authdesc, authtype ) VALUES ('/mis/xhzy/sms/getStudentsFeesList', '学生缴费信息列表', '学生缴费信息', '2');
INSERT INTO authority ( authid, authname, authdesc, authtype ) VALUES ('/mis/xhzy/sms/getStudentFeesInfo', '学生缴费详情查看', '学生缴费信息', '2');
INSERT INTO authority ( authid, authname, authdesc, authtype ) VALUES ('/mis/xhzy/sms/updateStudentFeesInfo', '学生缴费详情修改', '学生缴费信息', '2');

--INSERT INTO authority ( authid, authname, authdesc, authtype ) VALUES ('/mis/xhzy/sms/getStudentFeesList', '学生缴费详情列表', '学生缴费信息', '2');
--INSERT INTO authority ( authid, authname, authdesc, authtype ) VALUES ('/mis/xhzy/sms/insertStudentFees', '学生缴费信息新增', '学生缴费信息', '2');
--INSERT INTO authority ( authid, authname, authdesc, authtype ) VALUES ('/mis/xhzy/sms/updateStudentFees', '学生缴费信息修改', '学生缴费信息', '2');
--INSERT INTO authority ( authid, authname, authdesc, authtype ) VALUES ('/mis/xhzy/sms/deleteStudentFees', '学生缴费信息删除', '学生缴费信息', '2');
--INSERT INTO authority ( authid, authname, authdesc, authtype ) VALUES ('/mis/xhzy/sms/updateStuInfoByFee', '学生缴费基本信息修改', '学生缴费信息', '2');

INSERT INTO authority ( authid, authname, authdesc, authtype ) VALUES ('/mis/xhzy/sms/getStuBaseInfoListBySearch', '综合查询信息列表', '综合查询', '2');
INSERT INTO authority ( authid, authname, authdesc, authtype ) VALUES ('/mis/xhzy/sms/stuBaseInfoImport', '综合查询学生基本信息导入', '综合查询', '2');
INSERT INTO authority ( authid, authname, authdesc, authtype ) VALUES ('/mis/xhzy/sms/stuBaseInfoExport', '综合查询学生基本信息导出', '综合查询', '2');
INSERT INTO authority ( authid, authname, authdesc, authtype ) VALUES ('oneselfData', '所属数据', '数据权限', '3');
INSERT INTO authority ( authid, authname, authdesc, authtype ) VALUES ('allData', '所有数据', '数据权限', '3');

INSERT INTO role ( roleid, rolename, roledesc ) VALUES (1, '超级系统管理员', '用户管理，角色权限，数据字典，业务日志，系统设置，个人设置');
INSERT INTO role ( roleid, rolename, roledesc ) VALUES (2, '招生办领导', '学生基本信息，学生缴费信息，综合查询');
INSERT INTO role ( roleid, rolename, roledesc ) VALUES (3, '招生人员', '所招学生基本信息查询');
INSERT INTO role ( roleid, rolename, roledesc ) VALUES (4, '财务人员', '学生缴费信息管理');

INSERT INTO role_authority ( roleid, authid ) VALUES (1, '/mis/sys/usersIndex');
INSERT INTO role_authority ( roleid, authid ) VALUES (1, '/mis/sys/authorityIndex');
INSERT INTO role_authority ( roleid, authid ) VALUES (1, '/mis/sys/dictionaryIndex');
INSERT INTO role_authority ( roleid, authid ) VALUES (1, '/mis/sys/logIndex');
INSERT INTO role_authority ( roleid, authid ) VALUES (1, '/mis/sys/setupIndex');
INSERT INTO role_authority ( roleid, authid ) VALUES (1, '/mis/sys/userIndex');
INSERT INTO role_authority ( roleid, authid ) VALUES (1, '/mis/sys/alterUserPasswordByUser');
INSERT INTO role_authority ( roleid, authid ) VALUES (1, '/mis/sys/updateUserInfoByUser');
INSERT INTO role_authority ( roleid, authid ) VALUES (1, '/mis/sys/getUserInfoByUser');
INSERT INTO role_authority ( roleid, authid ) VALUES (1, '/mis/sys/getUsersList');
INSERT INTO role_authority ( roleid, authid ) VALUES (1, '/mis/sys/insertUserInfoByUsers');
INSERT INTO role_authority ( roleid, authid ) VALUES (1, '/mis/sys/updateUserInfoByUsers');
INSERT INTO role_authority ( roleid, authid ) VALUES (1, '/mis/sys/getUserInfoByUsers');
INSERT INTO role_authority ( roleid, authid ) VALUES (1, '/mis/sys/changeUserActive');
INSERT INTO role_authority ( roleid, authid ) VALUES (1, '/mis/sys/getUserRole');
INSERT INTO role_authority ( roleid, authid ) VALUES (1, '/mis/sys/updateUserRole');
INSERT INTO role_authority ( roleid, authid ) VALUES (1, '/mis/sys/getEntryList');
INSERT INTO role_authority ( roleid, authid ) VALUES (1, '/mis/sys/insertEntry');
INSERT INTO role_authority ( roleid, authid ) VALUES (1, '/mis/sys/updateEntry');
INSERT INTO role_authority ( roleid, authid ) VALUES (1, '/mis/sys/deleteEntry');
INSERT INTO role_authority ( roleid, authid ) VALUES (1, '/mis/sys/getRoleAuthList');
INSERT INTO role_authority ( roleid, authid ) VALUES (1, '/mis/sys/updateRoleAuth');
INSERT INTO role_authority ( roleid, authid ) VALUES (1, '/mis/sys/getRoleInfo');
INSERT INTO role_authority ( roleid, authid ) VALUES (1, '/mis/sys/insertRole');
INSERT INTO role_authority ( roleid, authid ) VALUES (1, '/mis/sys/updateRole');
INSERT INTO role_authority ( roleid, authid ) VALUES (1, '/mis/sys/deleteRole');
INSERT INTO role_authority ( roleid, authid ) VALUES (1, '/mis/sys/getLogList');
INSERT INTO role_authority ( roleid, authid ) VALUES (1, '/mis/sys/getLogInfo');

INSERT INTO user_role ( userid, roleid ) VALUES (1000, 1);




