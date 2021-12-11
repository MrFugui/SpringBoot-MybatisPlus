/*
 Navicat Premium Data Transfer

 Source Server         : 120.76.201.118_3306
 Source Server Type    : MySQL
 Source Server Version : 50736
 Source Host           : 120.76.201.118:3306
 Source Schema         : springbootjpa

 Target Server Type    : MySQL
 Target Server Version : 50736
 File Encoding         : 65001

 Date: 11/12/2021 15:22:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (3, 'ailisi', 18, '2021-12-11 00:27:51');
INSERT INTO `user` VALUES (4, 'ailisi', 18, '2021-12-11 00:27:51');
INSERT INTO `user` VALUES (5, 'ailisi', 18, '2021-12-11 00:27:51');

SET FOREIGN_KEY_CHECKS = 1;
