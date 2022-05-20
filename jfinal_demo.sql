/*
 Navicat MySQL Data Transfer

 Source Server         : 个人服务器
 Source Server Type    : MySQL
 Source Server Version : 50650
 Source Host           : liuyang1024.online:3306
 Source Schema         : jfinal_demo

 Target Server Type    : MySQL
 Target Server Version : 50650
 File Encoding         : 65001

 Date: 20/05/2022 21:41:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `account_username_uindex`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES (1, 'liuyang', '1024');
INSERT INTO `account` VALUES (2, '1024839103', '345');
INSERT INTO `account` VALUES (3, '1024839', '345');
INSERT INTO `account` VALUES (4, 'ss', 'ddd');
INSERT INTO `account` VALUES (5, 'csad', 'sdfsd');
INSERT INTO `account` VALUES (6, 'admin', '123456');

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `content` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES (1, 'JFinal Demo Title here', 'JFinal Demo Content here');
INSERT INTO `blog` VALUES (2, 'test 1', 'test 1');
INSERT INTO `blog` VALUES (3, 'test 2', 'test 2');
INSERT INTO `blog` VALUES (4, 'test 3', 'test 3');
INSERT INTO `blog` VALUES (5, 'test 4', 'test 4');

SET FOREIGN_KEY_CHECKS = 1;
