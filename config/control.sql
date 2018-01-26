/*
Navicat MySQL Data Transfer

Source Server         : me
Source Server Version : 50535
Source Host           : localhost:3306
Source Database       : control

Target Server Type    : MYSQL
Target Server Version : 50535
File Encoding         : 65001

Date: 2018-01-26 16:44:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for application
-- ----------------------------
DROP TABLE IF EXISTS `application`;
CREATE TABLE `application` (
  `id` int(11) NOT NULL,
  `computerId` int(11) NOT NULL,
  `application_name` varchar(50) NOT NULL,
  `application_url` varchar(50) NOT NULL,
  `createTime` datetime NOT NULL,
  `isClose` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for computer
-- ----------------------------
DROP TABLE IF EXISTS `computer`;
CREATE TABLE `computer` (
  `id` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `ip` varchar(20) NOT NULL,
  `update_time` datetime NOT NULL,
  `pwd` varchar(50) NOT NULL,
  `create_time` datetime NOT NULL,
  `mac` varchar(255) NOT NULL,
  `port` varchar(50) DEFAULT NULL,
  `last_ip` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `epassword` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
