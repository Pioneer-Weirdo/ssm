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

 Date: 14/01/2023 10:23:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_emp
-- ----------------------------
DROP TABLE IF EXISTS `t_emp`;
CREATE TABLE `t_emp`  (
  `emp_id` int NOT NULL AUTO_INCREMENT,
  `emp_name` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `age` int NULL DEFAULT NULL,
  `gender` char(1) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `dept_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`emp_id`) USING BTREE,
  INDEX `dept_id`(`dept_id` ASC) USING BTREE,
  CONSTRAINT `dept_id` FOREIGN KEY (`dept_id`) REFERENCES `t_dept` (`dept_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 101 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_emp
-- ----------------------------
INSERT INTO `t_emp` VALUES (1, '邵震南', 21, '男', 10);
INSERT INTO `t_emp` VALUES (2, '罗詩涵', 30, '女', 1);
INSERT INTO `t_emp` VALUES (3, '汪震南', 50, '男', 7);
INSERT INTO `t_emp` VALUES (4, '姜子异', 58, '男', 3);
INSERT INTO `t_emp` VALUES (5, '许岚', 53, '女', 10);
INSERT INTO `t_emp` VALUES (6, '姜震南', 41, '男', 1);
INSERT INTO `t_emp` VALUES (7, '傅秀英', 30, '女', 9);
INSERT INTO `t_emp` VALUES (8, '夏宇宁', 19, '男', 7);
INSERT INTO `t_emp` VALUES (9, '邱秀英', 56, '女', 4);
INSERT INTO `t_emp` VALUES (10, '史詩涵', 48, '女', 4);
INSERT INTO `t_emp` VALUES (11, '汪致远', 47, '男', 6);
INSERT INTO `t_emp` VALUES (12, '梁晓明', 27, '男', 2);
INSERT INTO `t_emp` VALUES (13, '徐子韬', 49, '男', 7);
INSERT INTO `t_emp` VALUES (14, '邹岚', 20, '女', 4);
INSERT INTO `t_emp` VALUES (15, '郭云熙', 25, '男', 9);
INSERT INTO `t_emp` VALUES (16, '邓嘉伦', 19, '男', 3);
INSERT INTO `t_emp` VALUES (17, '郑杰宏', 46, '男', 1);
INSERT INTO `t_emp` VALUES (18, '段秀英', 44, '女', 4);
INSERT INTO `t_emp` VALUES (19, '冯詩涵', 22, '女', 1);
INSERT INTO `t_emp` VALUES (20, '贺震南', 22, '男', 2);
INSERT INTO `t_emp` VALUES (21, '谭岚', 57, '女', 8);
INSERT INTO `t_emp` VALUES (22, '曹子韬', 31, '男', 8);
INSERT INTO `t_emp` VALUES (23, '沈晓明', 23, '男', 6);
INSERT INTO `t_emp` VALUES (24, '朱致远', 53, '男', 3);
INSERT INTO `t_emp` VALUES (25, '余晓明', 48, '男', 4);
INSERT INTO `t_emp` VALUES (26, '邵子异', 59, '男', 1);
INSERT INTO `t_emp` VALUES (27, '丁安琪', 33, '女', 2);
INSERT INTO `t_emp` VALUES (28, '曹云熙', 27, '男', 10);
INSERT INTO `t_emp` VALUES (29, '邹嘉伦', 29, '男', 9);
INSERT INTO `t_emp` VALUES (30, '郝晓明', 38, '男', 7);
INSERT INTO `t_emp` VALUES (31, '曾晓明', 22, '男', 1);
INSERT INTO `t_emp` VALUES (32, '汤云熙', 19, '男', 4);
INSERT INTO `t_emp` VALUES (33, '于子异', 36, '男', 10);
INSERT INTO `t_emp` VALUES (34, '周秀英', 33, '女', 2);
INSERT INTO `t_emp` VALUES (35, '田子韬', 57, '男', 4);
INSERT INTO `t_emp` VALUES (36, '陶子韬', 44, '男', 4);
INSERT INTO `t_emp` VALUES (37, '龙睿', 33, '男', 6);
INSERT INTO `t_emp` VALUES (38, '于震南', 38, '男', 6);
INSERT INTO `t_emp` VALUES (39, '于秀英', 33, '女', 3);
INSERT INTO `t_emp` VALUES (40, '雷秀英', 31, '女', 8);
INSERT INTO `t_emp` VALUES (41, '杨宇宁', 51, '男', 4);
INSERT INTO `t_emp` VALUES (42, '段璐', 22, '女', 9);
INSERT INTO `t_emp` VALUES (43, '袁秀英', 53, '女', 1);
INSERT INTO `t_emp` VALUES (44, '萧嘉伦', 22, '男', 4);
INSERT INTO `t_emp` VALUES (45, '常晓明', 56, '男', 7);
INSERT INTO `t_emp` VALUES (46, '沈安琪', 47, '女', 6);
INSERT INTO `t_emp` VALUES (47, '马云熙', 53, '男', 4);
INSERT INTO `t_emp` VALUES (48, '段子韬', 59, '男', 3);
INSERT INTO `t_emp` VALUES (49, '汤詩涵', 31, '女', 4);
INSERT INTO `t_emp` VALUES (50, '韩震南', 34, '男', 2);
INSERT INTO `t_emp` VALUES (51, '姚安琪', 40, '女', 4);
INSERT INTO `t_emp` VALUES (52, '陶震南', 23, '男', 1);
INSERT INTO `t_emp` VALUES (53, '石安琪', 44, '女', 9);
INSERT INTO `t_emp` VALUES (54, '曹岚', 43, '女', 3);
INSERT INTO `t_emp` VALUES (55, '方致远', 32, '男', 5);
INSERT INTO `t_emp` VALUES (56, '罗致远', 32, '男', 4);
INSERT INTO `t_emp` VALUES (57, '薛安琪', 24, '女', 10);
INSERT INTO `t_emp` VALUES (58, '段秀英', 52, '女', 3);
INSERT INTO `t_emp` VALUES (59, '廖睿', 20, '男', 2);
INSERT INTO `t_emp` VALUES (60, '高嘉伦', 39, '男', 10);
INSERT INTO `t_emp` VALUES (61, '吕安琪', 23, '女', 5);
INSERT INTO `t_emp` VALUES (62, '陈子异', 28, '男', 10);
INSERT INTO `t_emp` VALUES (63, '常晓明', 27, '男', 3);
INSERT INTO `t_emp` VALUES (64, '刘睿', 35, '男', 6);
INSERT INTO `t_emp` VALUES (65, '朱睿', 60, '男', 2);
INSERT INTO `t_emp` VALUES (66, '马詩涵', 59, '女', 8);
INSERT INTO `t_emp` VALUES (67, '周宇宁', 43, '男', 6);
INSERT INTO `t_emp` VALUES (68, '任宇宁', 58, '男', 3);
INSERT INTO `t_emp` VALUES (69, '陶杰宏', 56, '男', 8);
INSERT INTO `t_emp` VALUES (70, '段嘉伦', 47, '男', 2);
INSERT INTO `t_emp` VALUES (71, '周云熙', 55, '男', 5);
INSERT INTO `t_emp` VALUES (72, '汤安琪', 27, '女', 5);
INSERT INTO `t_emp` VALUES (73, '朱子异', 44, '男', 2);
INSERT INTO `t_emp` VALUES (74, '秦安琪', 35, '女', 1);
INSERT INTO `t_emp` VALUES (75, '史岚', 48, '女', 7);
INSERT INTO `t_emp` VALUES (76, '赵秀英', 59, '女', 8);
INSERT INTO `t_emp` VALUES (77, '金安琪', 39, '女', 6);
INSERT INTO `t_emp` VALUES (78, '余睿', 49, '男', 8);
INSERT INTO `t_emp` VALUES (79, '姜秀英', 23, '女', 9);
INSERT INTO `t_emp` VALUES (80, '郝詩涵', 25, '女', 5);
INSERT INTO `t_emp` VALUES (81, '于安琪', 43, '女', 10);
INSERT INTO `t_emp` VALUES (82, '廖睿', 53, '男', 7);
INSERT INTO `t_emp` VALUES (83, '王嘉伦', 38, '男', 7);
INSERT INTO `t_emp` VALUES (84, '陈岚', 18, '女', 10);
INSERT INTO `t_emp` VALUES (85, '石致远', 46, '男', 3);
INSERT INTO `t_emp` VALUES (86, '朱詩涵', 48, '女', 2);
INSERT INTO `t_emp` VALUES (87, '程嘉伦', 26, '男', 5);
INSERT INTO `t_emp` VALUES (88, '潘詩涵', 59, '女', 5);
INSERT INTO `t_emp` VALUES (89, '张璐', 24, '女', 1);
INSERT INTO `t_emp` VALUES (90, '马詩涵', 38, '女', 10);
INSERT INTO `t_emp` VALUES (91, '林睿', 46, '男', 3);
INSERT INTO `t_emp` VALUES (92, '尹子异', 51, '男', 10);
INSERT INTO `t_emp` VALUES (93, '王晓明', 33, '男', 4);
INSERT INTO `t_emp` VALUES (94, '杨宇宁', 23, '男', 2);
INSERT INTO `t_emp` VALUES (95, '姜嘉伦', 52, '男', 4);
INSERT INTO `t_emp` VALUES (96, '许秀英', 50, '女', 6);
INSERT INTO `t_emp` VALUES (97, '邓晓明', 38, '男', 10);
INSERT INTO `t_emp` VALUES (98, '陶子韬', 51, '男', 1);
INSERT INTO `t_emp` VALUES (99, '周睿', 57, '男', 6);
INSERT INTO `t_emp` VALUES (100, '刘璐', 59, '女', 3);

SET FOREIGN_KEY_CHECKS = 1;
