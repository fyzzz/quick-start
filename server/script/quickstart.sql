/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50730
Source Host           : localhost:3306
Source Database       : quickstart

Target Server Type    : MYSQL
Target Server Version : 50730
File Encoding         : 65001

Date: 2020-06-02 16:09:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(32) DEFAULT NULL COMMENT '用户名',
  `password` varchar(256) DEFAULT NULL COMMENT '密码',
  `create_user_id` int(11) DEFAULT NULL COMMENT '创建人id',
  `update_user_id` int(11) DEFAULT NULL COMMENT '修改人id',
  `create_time` timestamp(3) NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
  `update_time` timestamp(3) NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户信息表';

-- ----------------------------
-- Records of user_info
-- ----------------------------
