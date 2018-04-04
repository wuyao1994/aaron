/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : aaron

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-04-04 11:15:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_account
-- ----------------------------
DROP TABLE IF EXISTS `sys_account`;
CREATE TABLE `sys_account` (
  `id` char(32) NOT NULL,
  `login_name` varchar(64) NOT NULL,
  `password` varchar(64) NOT NULL,
  `name` varchar(16) NOT NULL,
  `salt` varchar(32) NOT NULL,
  `phone` varchar(32) DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL,
  `is_valid` tinyint(4) DEFAULT '1',
  `is_admin` tinyint(4) DEFAULT NULL,
  `help_code` varchar(16) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_account
-- ----------------------------
INSERT INTO `sys_account` VALUES ('1', 'admin', '4005fea06c0b46aa308a3efb85c5dd8a26d36913', 'elvis', '8c337b2acf2a3136', '1111111111', 'wuyaoiot@163.com', '1', '1', null, null, null, '2017-09-28 19:34:12', '1');

-- ----------------------------
-- Table structure for sys_account_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_account_role`;
CREATE TABLE `sys_account_role` (
  `account_id` char(32) NOT NULL,
  `role_id` char(32) NOT NULL,
  PRIMARY KEY (`role_id`,`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_account_role
-- ----------------------------

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` char(32) NOT NULL,
  `bpid` char(32) DEFAULT NULL COMMENT '面包屑父菜单 ID',
  `mpid` char(32) DEFAULT NULL COMMENT '菜单父 ID',
  `name` varchar(64) NOT NULL,
  `icon` varchar(128) DEFAULT NULL,
  `router` varchar(128) DEFAULT NULL,
  `permission` char(32) NOT NULL,
  `sequence` tinyint(2) DEFAULT NULL,
  `menu_level` tinyint(2) DEFAULT NULL,
  `help_code` varchar(32) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_by` varchar(32) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_by` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('4dcab7f2ad5f4166996de3ff910ac8c2', null, null, 'Dashboard', 'dashboard', '/dashboard', 'ca87eb56a7954f43a212eb0dc2b835f6', '1', '1', null, null, null, null, null);
INSERT INTO `sys_menu` VALUES ('6bb9338ed85441b097f1a47101457a47', '80e8bd5c73014fa68d0b0983ecf45b1b', '80e8bd5c73014fa68d0b0983ecf45b1b', 'ECharts', 'line-chart', '/chart/ECharts', '986800e2c0fc4d7da86a5c39a554a287', '1', '2', null, '2017-09-26 14:30:28', '1', null, null);
INSERT INTO `sys_menu` VALUES ('80e8bd5c73014fa68d0b0983ecf45b1b', '4dcab7f2ad5f4166996de3ff910ac8c2', '', 'Charts', 'code-o', '', 'ce468a33bb1f41e9b7aa3aaa19f05f57', '2', '1', null, '2017-09-26 14:30:14', '1', null, null);

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` char(32) NOT NULL,
  `name` varchar(32) NOT NULL,
  `code` varchar(32) NOT NULL,
  `parent_id` varchar(32) DEFAULT NULL,
  `permission_level` tinyint(2) DEFAULT NULL,
  `sequence` tinyint(2) DEFAULT NULL,
  `is_resource` tinyint(2) DEFAULT NULL,
  `remark` varchar(128) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_by` varchar(64) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_by` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('475ba36f30b74c1cb7035242305ee603', '角色管理', 'sys:role', 'ce468a33bb1f41e9b7aa3aaa19f05f57', '2', '2', '1', null, '2017-09-26 14:27:57', '1', null, null);
INSERT INTO `sys_permission` VALUES ('49dda1e85934453dafb1ca36c650d7f4', '账户管理', 'sys:account', 'ce468a33bb1f41e9b7aa3aaa19f05f57', '2', '4', '1', null, '2017-09-26 14:28:35', '1', null, null);
INSERT INTO `sys_permission` VALUES ('73e97595a7944a32afeff608fc599179', '菜单1', '11', '986800e2c0fc4d7da86a5c39a554a287', '3', '1', '1', '111', '2017-09-29 18:00:26', '1', null, null);
INSERT INTO `sys_permission` VALUES ('986800e2c0fc4d7da86a5c39a554a287', '菜单管理', 'sys:menu', 'ce468a33bb1f41e9b7aa3aaa19f05f57', '2', '1', '1', null, '2017-09-26 14:27:44', '1', null, null);
INSERT INTO `sys_permission` VALUES ('ca87eb56a7954f43a212eb0dc2b835f6', '管理控制台', 'dashboard', null, '1', '1', '1', null, null, null, null, null);
INSERT INTO `sys_permission` VALUES ('cca83b97b3f4409a96317dbe55f0126e', '权限管理', 'sys:permission', 'ce468a33bb1f41e9b7aa3aaa19f05f57', '2', '3', '1', null, '2017-09-26 14:28:14', '1', null, null);
INSERT INTO `sys_permission` VALUES ('ce468a33bb1f41e9b7aa3aaa19f05f57', '系统管理', 'sys', null, '1', '2', '1', null, null, null, null, null);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` char(32) NOT NULL,
  `name` varchar(32) DEFAULT NULL,
  `reamrk` varchar(128) DEFAULT NULL,
  `is_valid` tinyint(4) DEFAULT NULL,
  `help_code` varchar(16) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('ba26ff0f44374fbb8e02d6234f93d850', '管理员', null, null, null, '2017-09-26 14:33:40', '1', null, null);

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `role_id` char(32) NOT NULL,
  `permission_id` char(32) NOT NULL,
  PRIMARY KEY (`role_id`,`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('ba26ff0f44374fbb8e02d6234f93d850', '475ba36f30b74c1cb7035242305ee603');
INSERT INTO `sys_role_permission` VALUES ('ba26ff0f44374fbb8e02d6234f93d850', '49dda1e85934453dafb1ca36c650d7f4');
INSERT INTO `sys_role_permission` VALUES ('ba26ff0f44374fbb8e02d6234f93d850', '986800e2c0fc4d7da86a5c39a554a287');
INSERT INTO `sys_role_permission` VALUES ('ba26ff0f44374fbb8e02d6234f93d850', 'ca87eb56a7954f43a212eb0dc2b835f6');
INSERT INTO `sys_role_permission` VALUES ('ba26ff0f44374fbb8e02d6234f93d850', 'cca83b97b3f4409a96317dbe55f0126e');
INSERT INTO `sys_role_permission` VALUES ('ba26ff0f44374fbb8e02d6234f93d850', 'ce468a33bb1f41e9b7aa3aaa19f05f57');
SET FOREIGN_KEY_CHECKS=1;
