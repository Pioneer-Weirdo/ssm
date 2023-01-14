/*
 Navicat Premium Data Transfer

 Source Server         : student
 Source Server Type    : MySQL
 Source Server Version : 80031 (8.0.31)
 Source Host           : localhost:3306
 Source Schema         : ssm

 Target Server Type    : MySQL
 Target Server Version : 80031 (8.0.31)
 File Encoding         : 65001

 Date: 14/01/2023 10:22:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_dept
-- ----------------------------
DROP TABLE IF EXISTS `t_dept`;
CREATE TABLE `t_dept`  (
  `dept_id` int NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_dept
-- ----------------------------
INSERT INTO `t_dept` VALUES (1, '公关部');
INSERT INTO `t_dept` VALUES (2, '公关部');
INSERT INTO `t_dept` VALUES (3, '采购部');
INSERT INTO `t_dept` VALUES (4, '工程部');
INSERT INTO `t_dept` VALUES (5, '信息技术支持部');
INSERT INTO `t_dept` VALUES (6, '会计及金融部');
INSERT INTO `t_dept` VALUES (7, '公关部');
INSERT INTO `t_dept` VALUES (8, '公关部');
INSERT INTO `t_dept` VALUES (9, '产品质量部');
INSERT INTO `t_dept` VALUES (10, '公关部');

SET FOREIGN_KEY_CHECKS = 1;
