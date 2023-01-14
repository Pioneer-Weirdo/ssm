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

 Date: 14/01/2023 10:31:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `age` int NULL DEFAULT NULL,
  `gender` char(1) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 41 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, '杜岚', 'UorB1OXnni', 33, '女', 'du1972@outlook.com');
INSERT INTO `t_user` VALUES (2, '杨杰宏', 'BZ1UVMiyIN', 50, '男', 'jiehongyang@hotmail.com');
INSERT INTO `t_user` VALUES (3, '孙子异', '22HHhctekh', 58, '男', 'sziyi@outlook.com');
INSERT INTO `t_user` VALUES (4, '潘詩涵', 'S1q1DkW3Nm', 53, '女', 'pshihan2010@outlook.com');
INSERT INTO `t_user` VALUES (5, '邵晓明', 'j3BQCz2lp3', 37, '男', 'shaoxiaoming@gmail.com');
INSERT INTO `t_user` VALUES (6, '任岚', 'jI7pOqk1Fq', 53, '女', 'ren1211@yahoo.com');
INSERT INTO `t_user` VALUES (7, '阎致远', 'fZTvQ3y3ln', 41, '男', 'zhiyuany@gmail.com');
INSERT INTO `t_user` VALUES (8, '胡岚', 'G2tLvizQEe', 32, '女', 'lan94@gmail.com');
INSERT INTO `t_user` VALUES (9, '史震南', 'IzY2viQOpH', 52, '男', 'zshi817@icloud.com');
INSERT INTO `t_user` VALUES (10, '朱睿', 'rfCG3xFHbj', 55, '男', 'zhurui@gmail.com');
INSERT INTO `t_user` VALUES (11, '邵安琪', 'pXxpet5yLZ', 35, '女', 'shao1941@outlook.com');
INSERT INTO `t_user` VALUES (12, '张嘉伦', 'EynhuE2lmp', 46, '男', 'zhangj97@icloud.com');
INSERT INTO `t_user` VALUES (13, '廖震南', 'n1KpISuTfw', 43, '男', 'zhennl@gmail.com');
INSERT INTO `t_user` VALUES (14, '邵詩涵', 'LiEst03jBW', 50, '女', 'shihanshao@yahoo.com');
INSERT INTO `t_user` VALUES (15, '贾杰宏', 'rQnXvzpKGy', 51, '男', 'jjiehong@outlook.com');
INSERT INTO `t_user` VALUES (16, '宋云熙', 'Yk6irtkYdt', 36, '男', 'syunxi@gmail.com');
INSERT INTO `t_user` VALUES (17, '杨子异', 'mg8zYUoKuC', 60, '男', 'yaziy3@outlook.com');
INSERT INTO `t_user` VALUES (18, '黎云熙', 'ZNEEG1iDn2', 55, '男', 'yli9@gmail.com');
INSERT INTO `t_user` VALUES (19, '罗岚', 'rIjTsTxPRH', 22, '女', 'lan02@icloud.com');
INSERT INTO `t_user` VALUES (21, '董宇宁', 'nLjRJbBQ6g', 40, '男', 'donyuning@outlook.com');

SET FOREIGN_KEY_CHECKS = 1;
