ALTER TABLE role_authority DROP FOREIGN KEY fk_roleid_role_auth;
ALTER TABLE role_authority DROP FOREIGN KEY fk_authid_role_auth;
ALTER TABLE user_role DROP FOREIGN KEY fk_userid_user_role;
ALTER TABLE user_role DROP FOREIGN KEY fk_roleid_user_role;
ALTER TABLE group_role DROP FOREIGN KEY fk_groupid_group_role;
ALTER TABLE group_role DROP FOREIGN KEY fk_roleid_group_role;
ALTER TABLE user_group DROP FOREIGN KEY fk_userid_user_group;
ALTER TABLE user_group DROP FOREIGN KEY fk_groupid_user_group;

DROP TABLE IF EXISTS student_baseinfo;
CREATE TABLE  student_baseinfo (
  stuid INT NOT NULL AUTO_INCREMENT COMMENT '流水号',
  active VARCHAR(1) CHARACTER SET GBK DEFAULT '1' COMMENT '删除标志',
  msbbh VARCHAR(10) CHARACTER SET GBK NOT NULL COMMENT '面试表编号',
  msrq VARCHAR(10) CHARACTER SET GBK NOT NULL COMMENT '面试日期',
  bkxl VARCHAR(1) CHARACTER SET GBK NOT NULL COMMENT '报读学历',
  jie VARCHAR(4) CHARACTER SET GBK NOT NULL COMMENT '届',
  jj VARCHAR(1) CHARACTER SET GBK NOT NULL COMMENT '季',
  xm VARCHAR(100) CHARACTER SET GBK NOT NULL COMMENT '姓名',
  xb VARCHAR(1) CHARACTER SET GBK NOT NULL COMMENT '性别',
  mz VARCHAR(2) CHARACTER SET GBK NOT NULL COMMENT '民族',
  sg DOUBLE(4,1) DEFAULT NULL COMMENT '身高cm',
  bdzy VARCHAR(4) CHARACTER SET GBK DEFAULT NULL COMMENT '报读专业',
  zzmm VARCHAR(1) CHARACTER SET GBK NOT NULL COMMENT '政治面貌',
  csrq VARCHAR(10) CHARACTER SET GBK NOT NULL COMMENT '出生日期',
  sfzhm VARCHAR(18) CHARACTER SET GBK DEFAULT NULL COMMENT '身份证号码',
  hj VARCHAR(1) CHARACTER SET GBK DEFAULT NULL COMMENT '户籍',
  kslb VARCHAR(1) CHARACTER SET GBK DEFAULT NULL COMMENT '考生类别',
  yklx VARCHAR(1) CHARACTER SET GBK DEFAULT NULL COMMENT '高考/中考',
  byz VARCHAR(1) CHARACTER SET GBK DEFAULT NULL COMMENT '毕业证',
  jtxsdz VARCHAR(500) CHARACTER SET GBK NOT NULL COMMENT '家庭详细地址',
  xslxdh VARCHAR(100) CHARACTER SET GBK DEFAULT NULL COMMENT '学生联系电话',
  jzlxdh VARCHAR(100) CHARACTER SET GBK NOT NULL COMMENT '家长联系电话',
  byxx VARCHAR(200) CHARACTER SET GBK NOT NULL COMMENT '毕业学校',
  syd VARCHAR(200) CHARACTER SET GBK NOT NULL COMMENT '生源地',
  zsls VARCHAR(100) CHARACTER SET GBK NOT NULL COMMENT '招生老师',
  zfzr VARCHAR(100) CHARACTER SET GBK NOT NULL COMMENT '总负责人',
  zs VARCHAR(1) CHARACTER SET GBK DEFAULT NULL COMMENT '政审',
  tj VARCHAR(1) CHARACTER SET GBK DEFAULT NULL COMMENT '体检',
  lq VARCHAR(1) CHARACTER SET GBK DEFAULT NULL COMMENT '录取',
  yjfrq VARCHAR(19) CHARACTER SET GBK DEFAULT NULL COMMENT '预交费日期',
  yjfje DOUBLE(8,2) DEFAULT 0 COMMENT '预交费金额',
  yjfskr VARCHAR(100) CHARACTER SET GBK DEFAULT NULL COMMENT '预交费收款人',
  jfrq VARCHAR(19) CHARACTER SET GBK DEFAULT NULL COMMENT '缴费日期',
  jfje DOUBLE(8,2) DEFAULT 0 COMMENT '缴费金额',
  jfskr INT DEFAULT NULL COMMENT '缴费收款人',
  jfze DOUBLE(8,2) DEFAULT 0 COMMENT '已缴费用',
  yjje DOUBLE(8,2) DEFAULT 0 COMMENT '应缴费用',
  bdk VARCHAR(1) CHARACTER SET GBK DEFAULT NULL COMMENT '报到卡',
  bz VARCHAR(2000) CHARACTER SET GBK DEFAULT NULL COMMENT '备注',
  cwbz VARCHAR(2000) CHARACTER SET GBK DEFAULT NULL COMMENT '财务备注',
  creater INT NOT NULL COMMENT '创建人',
  createtime VARCHAR(19) CHARACTER SET GBK NOT NULL COMMENT '创建时间',
  lastupdater INT NOT NULL COMMENT '最后更新人',
  lastupdatertime VARCHAR(19) CHARACTER SET GBK NOT NULL COMMENT '最后更新时间',
  PRIMARY KEY (stuid)
) TYPE=InnoDB DEFAULT CHARSET=GBK COMMENT = '学生基本信息表';

DROP TABLE IF EXISTS student_fees;
CREATE TABLE  student_fees (
  feeid INT NOT NULL AUTO_INCREMENT,
  stuid INT NOT NULL,
  active VARCHAR(1) CHARACTER SET GBK DEFAULT '1',
  jfrq VARCHAR(19) CHARACTER SET GBK NOT NULL,
  je DOUBLE(8,2) NOT NULL,
  skr VARCHAR(100) CHARACTER SET GBK NOT NULL,
  jflx VARCHAR(1) CHARACTER SET GBK NOT NULL,
  creater INT NOT NULL,
  createtime VARCHAR(19) CHARACTER SET GBK NOT NULL,
  lastupdater INT NOT NULL,
  lastupdatertime VARCHAR(19) CHARACTER SET GBK NOT NULL,
  PRIMARY KEY (feeid)
) TYPE=InnoDB DEFAULT CHARSET=GBK;
ALTER TABLE student_fees 
 ADD CONSTRAINT fk_stuid_fees_baseinfo FOREIGN KEY fk_stuid_fees_baseinfo (stuid) REFERENCES student_baseinfo (stuid);
-- aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
-- active 用户状态(1有效、2停用)
-- usertype 用户类型(1普通用户、2管理员)
DROP TABLE IF EXISTS users;
CREATE TABLE users (
  userid INT NOT NULL AUTO_INCREMENT,
  accountid VARCHAR(5) CHARACTER SET GBK DEFAULT NULL,
  active VARCHAR(1) CHARACTER SET GBK DEFAULT '1',
  usertype VARCHAR(1) CHARACTER SET GBK DEFAULT '1',
  username VARCHAR(100) CHARACTER SET GBK NOT NULL,
  password VARCHAR(32) CHARACTER SET GBK NOT NULL,
  status VARCHAR(20) CHARACTER SET GBK DEFAULT NULL,
  addressunit VARCHAR(200) CHARACTER SET GBK DEFAULT NULL,
  addresshome VARCHAR(200) CHARACTER SET GBK DEFAULT NULL,
  phoneunit VARCHAR(100) CHARACTER SET GBK DEFAULT NULL,
  phonehome VARCHAR(100) CHARACTER SET GBK DEFAULT NULL,
  email VARCHAR(300) CHARACTER SET GBK DEFAULT NULL,
  lastvisittime VARCHAR(19) CHARACTER SET GBK DEFAULT NULL,
  visitcount INT DEFAULT '0',
  creater INT NOT NULL,
  createtime VARCHAR(19) CHARACTER SET GBK NOT NULL,
  lastupdater INT NOT NULL,
  lastupdatertime VARCHAR(19) CHARACTER SET GBK NOT NULL,
  PRIMARY KEY  (userid)
) TYPE=InnoDB DEFAULT CHARSET=GBK;

DROP TABLE IF EXISTS dictionary;
CREATE TABLE dictionary (
  dictid INT NOT NULL AUTO_INCREMENT,
  dictcode VARCHAR(200) CHARACTER SET GBK NOT NULL,
  codecontent VARCHAR(300) CHARACTER SET GBK NOT NULL,
  parentcode VARCHAR(200) CHARACTER SET GBK NOT NULL,
  level INT NOT NULL,
  levelseq INT NOT NULL,
  PRIMARY KEY (dictid)
) TYPE=InnoDB DEFAULT CHARSET=GBK;

DROP TABLE IF EXISTS log;
CREATE TABLE log (
  logid INT NOT NULL AUTO_INCREMENT,
  operater INT NOT NULL,
  opertime VARCHAR(19) CHARACTER SET GBK NOT NULL,
  operip VARCHAR(100) CHARACTER SET GBK NOT NULL,
  operaction VARCHAR(100) CHARACTER SET GBK NOT NULL,
  operinfo VARCHAR(5000) CHARACTER SET GBK NOT NULL,
  operresult VARCHAR(5000) CHARACTER SET GBK NOT NULL,
  PRIMARY KEY (logid)
) TYPE=InnoDB DEFAULT CHARSET=GBK;

-- aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa

DROP TABLE IF EXISTS role;
CREATE TABLE role (
  roleid INT NOT NULL AUTO_INCREMENT,
  rolename VARCHAR(100) CHARACTER SET GBK NOT NULL,
  roledesc VARCHAR(500) CHARACTER SET GBK DEFAULT NULL,
  PRIMARY KEY (roleid)
) TYPE=InnoDB DEFAULT CHARSET=GBK;

DROP TABLE IF EXISTS authority;
CREATE TABLE authority (
  authid VARCHAR(100) CHARACTER SET GBK NOT NULL,
  authname VARCHAR(100) CHARACTER SET GBK NOT NULL,
  authdesc VARCHAR(500) CHARACTER SET GBK DEFAULT NULL,
  authtype VARCHAR(1) CHARACTER SET GBK DEFAULT NULL,
  PRIMARY KEY (authid)
) TYPE=InnoDB DEFAULT CHARSET=GBK;

DROP TABLE IF EXISTS role_authority;
CREATE TABLE role_authority (
	roleid INT NOT NULL,
	authid VARCHAR(100) CHARACTER SET GBK NOT NULL,
	INDEX idx_role (roleid),
	INDEX idx_auth (authid),
	PRIMARY KEY (roleid, authid)
) TYPE=InnoDB DEFAULT CHARSET=GBK;
ALTER TABLE role_authority
 ADD CONSTRAINT fk_roleid_role_auth FOREIGN KEY fk_roleid_role_auth (roleid) REFERENCES role (roleid),
 ADD CONSTRAINT fk_authid_role_auth FOREIGN KEY fk_authid_role_auth (authid) REFERENCES authority (authid);

DROP TABLE IF EXISTS user_role;
CREATE TABLE user_role (
	userid INT NOT NULL,
	roleid INT NOT NULL,
	INDEX idx_user (userid),
	INDEX idx_role (roleid),
	PRIMARY KEY (userid, roleid)
) TYPE=InnoDB DEFAULT CHARSET=GBK;
ALTER TABLE user_role 
 ADD CONSTRAINT fk_userid_user_role FOREIGN KEY fk_userid_user_role (userid) REFERENCES users (userid),
 ADD CONSTRAINT fk_roleid_user_role FOREIGN KEY fk_roleid_user_role (roleid) REFERENCES role (roleid);
-- aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
DROP TABLE IF EXISTS groups;
CREATE TABLE groups (
  groupid INT NOT NULL AUTO_INCREMENT,
  groupname VARCHAR(100) CHARACTER SET GBK NOT NULL,
  groupdesc VARCHAR(500) CHARACTER SET GBK DEFAULT NULL,
  parentid INT DEFAULT '0',
  PRIMARY KEY  (groupid)
) TYPE=InnoDB DEFAULT CHARSET=GBK;

DROP TABLE IF EXISTS group_role;
CREATE TABLE group_role (
	groupid INT NOT NULL,
	roleid INT NOT NULL,
	INDEX idx_group (groupid),
	INDEX idx_role (roleid),
	PRIMARY KEY (groupid, roleid)
) TYPE=InnoDB DEFAULT CHARSET=GBK;
ALTER TABLE group_role 
 ADD CONSTRAINT fk_groupid_group_role FOREIGN KEY fk_groupid_group_role (groupid) REFERENCES groups (groupid),
 ADD CONSTRAINT fk_roleid_group_role FOREIGN KEY fk_roleid_group_role (roleid) REFERENCES role (roleid);

DROP TABLE IF EXISTS user_group;
CREATE TABLE user_group (
	userid INT NOT NULL,
	groupid INT NOT NULL,
	INDEX idx_user (userid),
	INDEX idx_group (groupid),
	PRIMARY KEY (userid, groupid)
) TYPE=InnoDB DEFAULT CHARSET=GBK;
ALTER TABLE user_group 
 ADD CONSTRAINT fk_userid_user_group FOREIGN KEY fk_userid_user_group (userid) REFERENCES users (userid),
 ADD CONSTRAINT fk_groupid_user_group FOREIGN KEY fk_groupid_user_group (groupid) REFERENCES groups (groupid);
