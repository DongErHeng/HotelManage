/*
Navicat MySQL Data Transfer

Source Server         : javaweb
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : hotel_manage

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2019-10-17 18:32:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_client
-- ----------------------------
DROP TABLE IF EXISTS `tb_client`;
CREATE TABLE `tb_client` (
  `client_id` char(18) CHARACTER SET utf8 NOT NULL,
  `name` varchar(20) CHARACTER SET utf8 NOT NULL,
  `sex` tinyint(1) NOT NULL,
  `age` int(4) NOT NULL,
  `tell` char(11) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_german1_ci;

-- ----------------------------
-- Records of tb_client
-- ----------------------------

-- ----------------------------
-- Table structure for tb_login
-- ----------------------------
DROP TABLE IF EXISTS `tb_login`;
CREATE TABLE `tb_login` (
  `username` varchar(20) CHARACTER SET utf8 NOT NULL,
  `password` varchar(20) COLLATE latin1_german1_ci NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_german1_ci;

-- ----------------------------
-- Records of tb_login
-- ----------------------------
INSERT INTO `tb_login` VALUES ('user', 'password');

-- ----------------------------
-- Table structure for tb_order
-- ----------------------------
DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `client_id` char(18) CHARACTER SET utf8 NOT NULL,
  `room_id` int(11) NOT NULL,
  `comedate` timestamp NOT NULL DEFAULT '2000-04-01 12:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `days` int(11) NOT NULL,
  `leavedate` timestamp NOT NULL DEFAULT '2000-04-02 12:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`order_id`),
  KEY `room_id` (`room_id`),
  KEY `client_id` (`client_id`),
  CONSTRAINT `client_id` FOREIGN KEY (`client_id`) REFERENCES `tb_client` (`client_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `room_id` FOREIGN KEY (`room_id`) REFERENCES `tb_room` (`room_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_german1_ci;

-- ----------------------------
-- Records of tb_order
-- ----------------------------

-- ----------------------------
-- Table structure for tb_room
-- ----------------------------
DROP TABLE IF EXISTS `tb_room`;
CREATE TABLE `tb_room` (
  `room_id` int(11) NOT NULL,
  `type` int(11) NOT NULL,
  `price` double(10,2) NOT NULL,
  `state` tinyint(1) NOT NULL,
  PRIMARY KEY (`room_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_german1_ci;

-- ----------------------------
-- Records of tb_room
-- ----------------------------
INSERT INTO `tb_room` VALUES ('101', '0', '500.00', '0');
INSERT INTO `tb_room` VALUES ('201', '1', '1000.00', '0');
INSERT INTO `tb_room` VALUES ('301', '2', '1500.00', '0');
