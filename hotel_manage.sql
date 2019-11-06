/*
Navicat MySQL Data Transfer

Source Server         : javaweb
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : hotel_manage

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2019-11-06 21:43:02
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
  PRIMARY KEY (`client_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_german1_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tb_client
-- ----------------------------
INSERT INTO `tb_client` VALUES ('230522199211087652', '猪悟能', '0', '27', '15793431080');
INSERT INTO `tb_client` VALUES ('310225198907108738', '朱世鹏', '0', '20', '15037563489');
INSERT INTO `tb_client` VALUES ('310225198907108739', '唐僧', '0', '30', '13454008456');
INSERT INTO `tb_client` VALUES ('330783198707103073', '孙悟空', '0', '32', '13879532772');
INSERT INTO `tb_client` VALUES ('350782198507180733', '镇元子', '0', '34', '15022037668');
INSERT INTO `tb_client` VALUES ('41010519990915105x', '沙悟净', '0', '20', '13155364139');
INSERT INTO `tb_client` VALUES ('431028199907185903', '嫦娥', '1', '20', '15222717669');

-- ----------------------------
-- Table structure for tb_login
-- ----------------------------
DROP TABLE IF EXISTS `tb_login`;
CREATE TABLE `tb_login` (
  `username` varchar(20) CHARACTER SET utf8 NOT NULL,
  `password` varchar(20) COLLATE latin1_german1_ci NOT NULL,
  PRIMARY KEY (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_german1_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tb_login
-- ----------------------------
INSERT INTO `tb_login` VALUES ('manager', 'password');
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
  `housing` tinyint(1) NOT NULL,
  PRIMARY KEY (`order_id`) USING BTREE,
  KEY `room_id` (`room_id`) USING BTREE,
  KEY `client_id` (`client_id`) USING BTREE,
  CONSTRAINT `client_id` FOREIGN KEY (`client_id`) REFERENCES `tb_client` (`client_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `room_id` FOREIGN KEY (`room_id`) REFERENCES `tb_room` (`room_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1 COLLATE=latin1_german1_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tb_order
-- ----------------------------
INSERT INTO `tb_order` VALUES ('9', '310225198907108739', '105', '2019-10-01 00:00:00', '7', '2019-10-07 00:00:00', '0');
INSERT INTO `tb_order` VALUES ('10', '330783198707103073', '102', '2019-10-01 00:00:00', '7', '2019-10-07 00:00:00', '0');
INSERT INTO `tb_order` VALUES ('11', '230522199211087652', '103', '2019-10-01 00:00:00', '7', '2019-10-07 00:00:00', '0');
INSERT INTO `tb_order` VALUES ('12', '41010519990915105x', '104', '2019-10-01 00:00:00', '7', '2019-10-07 00:00:00', '0');

-- ----------------------------
-- Table structure for tb_room
-- ----------------------------
DROP TABLE IF EXISTS `tb_room`;
CREATE TABLE `tb_room` (
  `room_id` int(11) NOT NULL,
  `type` int(11) NOT NULL,
  `price` double(10,2) NOT NULL,
  `state` tinyint(1) NOT NULL,
  PRIMARY KEY (`room_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_german1_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tb_room
-- ----------------------------
INSERT INTO `tb_room` VALUES ('101', '0', '500.00', '0');
INSERT INTO `tb_room` VALUES ('102', '0', '500.00', '1');
INSERT INTO `tb_room` VALUES ('103', '0', '500.00', '1');
INSERT INTO `tb_room` VALUES ('104', '0', '500.00', '1');
INSERT INTO `tb_room` VALUES ('105', '0', '500.00', '1');
INSERT INTO `tb_room` VALUES ('201', '1', '1000.00', '0');
INSERT INTO `tb_room` VALUES ('202', '1', '1000.00', '0');
INSERT INTO `tb_room` VALUES ('203', '1', '1000.00', '0');
INSERT INTO `tb_room` VALUES ('204', '1', '1000.00', '0');
INSERT INTO `tb_room` VALUES ('205', '1', '1000.00', '0');
INSERT INTO `tb_room` VALUES ('301', '2', '1500.00', '0');
INSERT INTO `tb_room` VALUES ('302', '2', '1500.00', '0');
INSERT INTO `tb_room` VALUES ('303', '2', '1500.00', '0');
INSERT INTO `tb_room` VALUES ('304', '2', '1500.00', '0');
INSERT INTO `tb_room` VALUES ('305', '2', '1500.00', '0');
