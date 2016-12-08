
-- 创建数据库 --
CREATE DATABASE platform DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
-- 创建用户--
CREATE USER 'platform'@'localhost' IDENTIFIED BY 'platform'; 
-- 数据库用户授权 --
GRANT ALL ON platform.* TO 'platform'@'localhost'; 

  -- 基础配置信息 --
CREATE TABLE `BASE_CONFIG_DATA` (
`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
show_name  VARCHAR(200) NOT NULL  COMMENT '显示名称', 
directions  VARCHAR(200) DEFAULT NULL  COMMENT '说明', 
type INT(11) NOT NULL  COMMENT '类型 1经营范围 2企业性质 3服务类别 4企业服务评论标签',
status int(1) DEFAULT 1 COMMENT '状态  -1逻辑 1正常',
modify_time  TIMESTAMP NOT NULL  ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
create_time  TIMESTAMP NOT NULL COMMENT '创建时间',
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='基础配置信息';

CREATE TABLE `BASE_USER` (
`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
user_name VARCHAR(50) DEFAULT NULL COMMENT  '登录名',
true_name VARCHAR(50) DEFAULT NULL  COMMENT '真实名称',
user_password VARCHAR(50) DEFAULT NULL COMMENT  '登录密码',
register_time  DATETIME DEFAULT NULL COMMENT '注册时间',
last_login_time  DATETIME DEFAULT NULL COMMENT '最后登录时间',
last_login_ip VARCHAR(50) DEFAULT NULL  COMMENT '登录IP',
error_time  DATETIME DEFAULT NULL COMMENT '登录错误时间',
error_count int(11)   DEFAULT 0  COMMENT '登录错误次数',
mobile_phone_number  VARCHAR(16)  DEFAULT NULL  COMMENT '手机号码',
user_logo VARCHAR(100) DEFAULT NULL COMMENT  '用户头像',
dept_id  VARCHAR(100)  DEFAULT NULL  COMMENT 'deptId',
register_uid  VARCHAR(100)  DEFAULT NULL  COMMENT '注册Uid',
wx_open_id  VARCHAR(100)  DEFAULT NULL  COMMENT '微信ID',
user_status int(1) DEFAULT 0 COMMENT '状态  -1逻辑删除 0待验证 1正常',
user_sex INT(11) NOT NULL  COMMENT '性别 0 男 1 女',
user_desc VARCHAR(100) DEFAULT NULL  COMMENT '用户说明',
email VARCHAR(200) NOT NULL COMMENT  '邮件',
type int(1) DEFAULT 1  COMMENT '类型 1普通用户',
age INT(11) DEFAULT NULL  COMMENT '年龄',
modify_time  TIMESTAMP NOT NULL  ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
create_time  TIMESTAMP NOT NULL   COMMENT '创建时间',
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息';



-- 用户企业信息 --
CREATE TABLE `BASE_USER_COMPANY` (
`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
user_id INT(11) NOT NULL  COMMENT '用户中心用户ID',
company_name VARCHAR(200) DEFAULT NULL COMMENT  '企业名称',
company_address VARCHAR(500) DEFAULT NULL COMMENT  '企业地址',
company_contact_user  VARCHAR(50)  DEFAULT NULL  COMMENT '企业联系人',
company_contact_tel  VARCHAR(16)  DEFAULT NULL  COMMENT '企业联系电话',
company_url  VARCHAR(500)  DEFAULT NULL  COMMENT '企业网址',
company_register_money  VARCHAR(50)  DEFAULT NULL  COMMENT '注册资金',
company_register_time  DATETIME  DEFAULT NULL  COMMENT '注册时间',
company_directions VARCHAR(2000)  DEFAULT NULL  COMMENT '企业简介',
company_scope INT(11) NOT NULL COMMENT '经营范围',
company_type INT(11) NOT NULL  COMMENT '类型 1企业性质',
recommend int(1) NOT NULL DEFAULT 0 COMMENT '推荐  0 不推荐 1推荐',
status int(1) DEFAULT 0 COMMENT '状态  -1逻辑删除 0待验证 1审核通过  2审核不通过',
modify_time  TIMESTAMP NOT NULL  ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
create_time  TIMESTAMP NOT NULL COMMENT '创建时间',
verify_time  DATETIME DEFAULT NULL COMMENT '审核时间',
verify_user_id  INT(11) DEFAULT NULL COMMENT '审核人id',
verify_user_name VARCHAR(200) DEFAULT NULL COMMENT '审核人名称',
verify_user_des  VARCHAR(200) DEFAULT NULL COMMENT '审核说明',
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户企业信息';


-- 用户企业图片信息 --
CREATE TABLE `BASE_USER_COMPANY_PIC` (
`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
company_id INT(11) NOT NULL  COMMENT '用户中心用户ID',
company_pic_url  VARCHAR(500)  DEFAULT NULL  COMMENT '企业图片地址',
status int(1) DEFAULT 1 COMMENT '状态  -1逻辑删除  1正常',
modify_time  TIMESTAMP NOT NULL  ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
create_time  TIMESTAMP NOT NULL COMMENT '创建时间',
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户企业图片信息';


-- 用户发送信息 --
CREATE TABLE `BASE_USER_SEND_INFO` (
`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
user_id INT(11) NOT NULL  COMMENT '用户中心用户ID',
send_code  VARCHAR(10)  DEFAULT NULL  COMMENT '发送码',
send_content  VARCHAR(200)  DEFAULT NULL  COMMENT '发送内容',
mobile_phone  VARCHAR(16)  DEFAULT NULL  COMMENT '手机号码',
email VARCHAR(200) NOT NULL COMMENT  '邮件',
status int(1) DEFAULT 0 COMMENT '状态  -1逻辑删除 0待验证 1正常',
type int(1) DEFAULT 1  COMMENT '类型 1密码验证',
modify_time  TIMESTAMP NOT NULL  ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
create_time  TIMESTAMP NOT NULL COMMENT '创建时间',
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户发送信息';


-- 用户浏览历史 --
CREATE TABLE `USER_LOOK_HISTORY` (
`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
user_id INT(11) NOT NULL  COMMENT '用户中心用户ID',
service_id  INT(11)  NOT NULL  COMMENT '服务id',
company_id  INT(11)  DEFAULT NULL  COMMENT '企业id',
look_count  INT(11)  DEFAULT 1  COMMENT '每天的浏览次数',
status int(1) DEFAULT 1 COMMENT '状态  -1逻辑删除 1正常',
type int(1) DEFAULT 1  COMMENT '类型 1服务浏览  2企业浏览',
now_date VARCHAR(20) NOT NULL COMMENT '收藏日期',
modify_time  TIMESTAMP NOT NULL  ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
create_time  TIMESTAMP NOT NULL COMMENT '创建时间',
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户浏览历史';

-- 用户收藏历史 --
CREATE TABLE `USER_COLLECT_HISTORY` (
`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
user_id INT(11) NOT NULL  COMMENT '用户中心用户ID',
service_id  INT(11)  DEFAULT NULL  COMMENT '服务id',
company_id  INT(11)  DEFAULT NULL  COMMENT '企业id',
status int(1) DEFAULT 1 COMMENT '状态  -1逻辑删除 1正常',
type int(1) DEFAULT 1  COMMENT '类型 1服务收藏  2企业收藏',
modify_time  TIMESTAMP NOT NULL  ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
create_time  TIMESTAMP NOT NULL COMMENT '创建时间',
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户收藏历史';

-- 用户企业发布服务信息 --
CREATE TABLE `USER_COMPANY_SERVICE` (
`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
user_id INT(11) NOT NULL  COMMENT '用户中心用户ID',
company_id INT(11) NOT NULL  COMMENT  '企业id',
service_name VARCHAR(500) DEFAULT NULL COMMENT  '服务名称',
pic_url  VARCHAR(500)  DEFAULT NULL  COMMENT '服务图片地址',
service_contact_user  VARCHAR(50)  DEFAULT NULL  COMMENT '服务联系人',
service_contact_tel  VARCHAR(16)  DEFAULT NULL  COMMENT '服务联系电话',
service_directions   TEXT  DEFAULT NULL  COMMENT '服务简介',
service_type INT(11) NOT NULL  COMMENT '类型 1服务类别',
status int(1) DEFAULT 0 COMMENT '状态  -1逻辑删除 0待验证 1审核通过  2审核不通过',
recommend int(1) NOT NULL DEFAULT 0 COMMENT '推荐  0 不推荐 1推荐',
modify_time  TIMESTAMP NOT NULL  ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
create_time  TIMESTAMP NOT NULL COMMENT '创建时间',
verify_time  DATETIME DEFAULT NULL COMMENT '审核时间',
verify_user_id  INT(11) DEFAULT NULL COMMENT '审核人id',
verify_user_name VARCHAR(200) DEFAULT NULL COMMENT '审核人名称',
verify_user_des  VARCHAR(200) DEFAULT NULL COMMENT '审核说明',
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户企业发布服务信息';


-- 企业服务评论信息 --
CREATE TABLE `USER_SERVICE_COMMENT` (
`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
user_id INT(11) DEFAULT NULL  COMMENT '服务用户ID',
company_id INT(11) DEFAULT NULL  COMMENT  '服务企业id',
service_id INT(11) DEFAULT NULL COMMENT  '服务id',
comment_user_id INT(11)  DEFAULT NULL  COMMENT '服务评论人',
comment_user_name VARCHAR(200)  DEFAULT NULL  COMMENT '服务评论人名称',
comment_directions   TEXT  DEFAULT NULL  COMMENT '服务评论简介',
comment_type INT(11) NOT NULL  COMMENT '评论类型 1好评 2 中评  3差评',
status int(1) DEFAULT 1 COMMENT '状态  -1逻辑删除 1正常',
modify_time  TIMESTAMP NOT NULL  ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
create_time  TIMESTAMP NOT NULL COMMENT '创建时间',
verify_time  DATETIME DEFAULT NULL COMMENT '审核时间',
verify_user_id  INT(11) DEFAULT NULL COMMENT '审核人id',
verify_user_name VARCHAR(200) DEFAULT NULL COMMENT '审核人名称',
verify_user_des  VARCHAR(200) DEFAULT NULL COMMENT '审核说明',
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='企业服务评论信息';

-- 企业服务评论标签信息 --
CREATE TABLE `USER_SERVICE_COMMENT_TAG` (
`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
service_id INT(11) DEFAULT NULL COMMENT  '服务id',
comment_tag_id INT(11) NOT NULL  COMMENT '评论标签id',
comment_tag_name VARCHAR(200) NOT NULL  COMMENT '评论标签说明',
status int(1) DEFAULT 1 COMMENT '状态  -1逻辑删除 1正常',
modify_time  TIMESTAMP NOT NULL  ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
create_time  TIMESTAMP NOT NULL COMMENT '创建时间',
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='企业服务评论标签信息';
