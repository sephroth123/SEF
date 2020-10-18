/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : spds

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 18/10/2020 18:29:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for client
-- ----------------------------
DROP TABLE IF EXISTS `client`;
CREATE TABLE `client` (
  `CID` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `userName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`CID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of client
-- ----------------------------
BEGIN;
INSERT INTO `client` VALUES ('C1', 'joke', '12345');
INSERT INTO `client` VALUES ('C2', 'tian', '54321');
INSERT INTO `client` VALUES ('C3', 'zoe', 'qwert');
COMMIT;

-- ----------------------------
-- Table structure for framework
-- ----------------------------
DROP TABLE IF EXISTS `framework`;
CREATE TABLE `framework` (
  `FID` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `fName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`FID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of framework
-- ----------------------------
BEGIN;
INSERT INTO `framework` VALUES ('fr1', '001');
INSERT INTO `framework` VALUES ('fr10', 'chifan');
INSERT INTO `framework` VALUES ('fr11', 'null');
INSERT INTO `framework` VALUES ('fr12', 'chifan');
INSERT INTO `framework` VALUES ('fr13', 'null');
INSERT INTO `framework` VALUES ('fr14', 'xxx1');
INSERT INTO `framework` VALUES ('fr15', 'null');
INSERT INTO `framework` VALUES ('fr16', 'chifan444');
INSERT INTO `framework` VALUES ('fr17', 'null');
INSERT INTO `framework` VALUES ('fr18', '23423423');
INSERT INTO `framework` VALUES ('fr19', '342342');
INSERT INTO `framework` VALUES ('fr2', '44444');
INSERT INTO `framework` VALUES ('fr20', 'null');
INSERT INTO `framework` VALUES ('fr21', '5t5t5t5t5');
INSERT INTO `framework` VALUES ('fr22', '2222');
INSERT INTO `framework` VALUES ('fr23', 'null');
INSERT INTO `framework` VALUES ('fr24', '2222');
INSERT INTO `framework` VALUES ('fr25', 'null');
INSERT INTO `framework` VALUES ('fr3', '1231231231');
INSERT INTO `framework` VALUES ('fr4', 'fffffffff');
INSERT INTO `framework` VALUES ('fr5', 'tttt');
INSERT INTO `framework` VALUES ('fr6', 'chifan');
INSERT INTO `framework` VALUES ('fr7', 'null');
INSERT INTO `framework` VALUES ('fr8', 'chifan');
INSERT INTO `framework` VALUES ('fr9', 'null');
COMMIT;

-- ----------------------------
-- Table structure for IDcreator
-- ----------------------------
DROP TABLE IF EXISTS `IDcreator`;
CREATE TABLE `IDcreator` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(64) NOT NULL,
  `value` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of IDcreator
-- ----------------------------
BEGIN;
INSERT INTO `IDcreator` VALUES (14, 'project', 7);
INSERT INTO `IDcreator` VALUES (15, 'role', 25);
INSERT INTO `IDcreator` VALUES (16, 'framework', 25);
INSERT INTO `IDcreator` VALUES (17, 'roleFramework', 25);
INSERT INTO `IDcreator` VALUES (18, 'projectRole', 7);
INSERT INTO `IDcreator` VALUES (19, 'studentRole', 8);
INSERT INTO `IDcreator` VALUES (20, 'team', 4);
COMMIT;

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `PID` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `CID` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`PID`) USING BTREE,
  KEY `CID` (`CID`) USING BTREE,
  CONSTRAINT `CID` FOREIGN KEY (`CID`) REFERENCES `client` (`CID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of project
-- ----------------------------
BEGIN;
INSERT INTO `project` VALUES ('pr1', 'c1', '001');
INSERT INTO `project` VALUES ('pr2', 'c1', '4444444');
INSERT INTO `project` VALUES ('pr3', 'c1', '213213123');
INSERT INTO `project` VALUES ('pr4', 'c1', 'rrrrrr');
INSERT INTO `project` VALUES ('pr5', 'c1', 'tttt');
INSERT INTO `project` VALUES ('pr6', 'c1', '4323243243');
INSERT INTO `project` VALUES ('pr7', 'c1', 'tttt444');
COMMIT;

-- ----------------------------
-- Table structure for projectrole
-- ----------------------------
DROP TABLE IF EXISTS `projectrole`;
CREATE TABLE `projectrole` (
  `PRID` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `PID` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `RFID` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`PRID`) USING BTREE,
  KEY `PID` (`PID`) USING BTREE,
  KEY `RFID` (`RFID`) USING BTREE,
  CONSTRAINT `projectrole_ibfk_1` FOREIGN KEY (`PID`) REFERENCES `project` (`PID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `projectrole_ibfk_2` FOREIGN KEY (`RFID`) REFERENCES `roleframework` (`RFID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of projectrole
-- ----------------------------
BEGIN;
INSERT INTO `projectrole` VALUES ('prr1', 'pr1', 'rofr1');
INSERT INTO `projectrole` VALUES ('prr2', 'pr2', 'rofr2');
INSERT INTO `projectrole` VALUES ('prr3', 'pr3', 'rofr3');
INSERT INTO `projectrole` VALUES ('prr4', 'pr4', 'rofr4');
INSERT INTO `projectrole` VALUES ('prr5', 'pr5', 'rofr5');
INSERT INTO `projectrole` VALUES ('prr6', 'pr6', 'rofr18');
INSERT INTO `projectrole` VALUES ('prr7', 'pr7', 'rofr21');
COMMIT;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `RID` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `rName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`RID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of role
-- ----------------------------
BEGIN;
INSERT INTO `role` VALUES ('ro1', '001');
INSERT INTO `role` VALUES ('ro10', 'cai shu yi');
INSERT INTO `role` VALUES ('ro11', 'cai shu yi 2');
INSERT INTO `role` VALUES ('ro12', 'cai shu yi');
INSERT INTO `role` VALUES ('ro13', 'cai shu yi 2');
INSERT INTO `role` VALUES ('ro14', 'cashuyi');
INSERT INTO `role` VALUES ('ro15', 'caishuyi2');
INSERT INTO `role` VALUES ('ro16', 'cai shu yi555');
INSERT INTO `role` VALUES ('ro17', 'cai shu yi 25555');
INSERT INTO `role` VALUES ('ro18', '23423423');
INSERT INTO `role` VALUES ('ro19', '321231');
INSERT INTO `role` VALUES ('ro2', '44444');
INSERT INTO `role` VALUES ('ro20', '3423423');
INSERT INTO `role` VALUES ('ro21', 'rrrrrrrrrr66');
INSERT INTO `role` VALUES ('ro22', 'lllllll');
INSERT INTO `role` VALUES ('ro23', 'lllll111');
INSERT INTO `role` VALUES ('ro24', 'lllllll');
INSERT INTO `role` VALUES ('ro25', 'lllll111');
INSERT INTO `role` VALUES ('ro3', '2312312312');
INSERT INTO `role` VALUES ('ro4', 'rrrrrr');
INSERT INTO `role` VALUES ('ro5', 'tttt');
COMMIT;

-- ----------------------------
-- Table structure for roleframework
-- ----------------------------
DROP TABLE IF EXISTS `roleframework`;
CREATE TABLE `roleframework` (
  `RID` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `FID` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `RFID` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`RFID`) USING BTREE,
  KEY `RID` (`RID`) USING BTREE,
  KEY `FID` (`FID`) USING BTREE,
  CONSTRAINT `roleframework_ibfk_1` FOREIGN KEY (`RID`) REFERENCES `role` (`RID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `roleframework_ibfk_2` FOREIGN KEY (`FID`) REFERENCES `framework` (`FID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of roleframework
-- ----------------------------
BEGIN;
INSERT INTO `roleframework` VALUES ('ro1', 'fr1', 'rofr1');
INSERT INTO `roleframework` VALUES ('ro12', 'fr12', 'rofr12');
INSERT INTO `roleframework` VALUES ('ro13', 'fr13', 'rofr13');
INSERT INTO `roleframework` VALUES ('ro14', 'fr14', 'rofr14');
INSERT INTO `roleframework` VALUES ('ro15', 'fr15', 'rofr15');
INSERT INTO `roleframework` VALUES ('ro16', 'fr16', 'rofr16');
INSERT INTO `roleframework` VALUES ('ro17', 'fr17', 'rofr17');
INSERT INTO `roleframework` VALUES ('ro18', 'fr18', 'rofr18');
INSERT INTO `roleframework` VALUES ('ro19', 'fr19', 'rofr19');
INSERT INTO `roleframework` VALUES ('ro2', 'fr2', 'rofr2');
INSERT INTO `roleframework` VALUES ('ro20', 'fr20', 'rofr20');
INSERT INTO `roleframework` VALUES ('ro21', 'fr21', 'rofr21');
INSERT INTO `roleframework` VALUES ('ro22', 'fr22', 'rofr22');
INSERT INTO `roleframework` VALUES ('ro23', 'fr23', 'rofr23');
INSERT INTO `roleframework` VALUES ('ro24', 'fr24', 'rofr24');
INSERT INTO `roleframework` VALUES ('ro25', 'fr25', 'rofr25');
INSERT INTO `roleframework` VALUES ('ro3', 'fr3', 'rofr3');
INSERT INTO `roleframework` VALUES ('ro4', 'fr4', 'rofr4');
INSERT INTO `roleframework` VALUES ('ro5', 'fr5', 'rofr5');
COMMIT;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `SID` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `sName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `sPassword` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `gender` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `pType` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `experence` int NOT NULL,
  `GPA` double(255,0) NOT NULL,
  PRIMARY KEY (`SID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of student
-- ----------------------------
BEGIN;
INSERT INTO `student` VALUES ('S1', 'lwx', '1234321', 'male', 'A', 2, 3);
INSERT INTO `student` VALUES ('S10', 'pp', 'yyyyy', 'male', 'E', 5, 3);
INSERT INTO `student` VALUES ('S11', 'aa', 'uuuuu', 'male', 'F', 4, 4);
INSERT INTO `student` VALUES ('S12', 'ss', 'iiiiii', 'male', 'B', 3, 3);
INSERT INTO `student` VALUES ('S2', 'qq', '2222222', 'male', 'B', 5, 4);
INSERT INTO `student` VALUES ('S3', 'ww', 'qwerewq', 'female', 'C', 4, 4);
INSERT INTO `student` VALUES ('S4', 'rr', 'wasddsaw', 'male', 'D', 5, 3);
INSERT INTO `student` VALUES ('S5', 'tt', 'qqqqqq', 'female', 'E', 5, 4);
INSERT INTO `student` VALUES ('S6', 'yy', 'wwwwww', 'male', 'F', 2, 3);
INSERT INTO `student` VALUES ('S7', 'uu', 'eeeeee', 'male', 'B', 4, 4);
INSERT INTO `student` VALUES ('S8', 'ii', 'rrrrrr', 'female', 'C', 5, 3);
INSERT INTO `student` VALUES ('S9', 'oo', 'tttttt', 'male', 'D', 4, 4);
COMMIT;

-- ----------------------------
-- Table structure for studentpreference
-- ----------------------------
DROP TABLE IF EXISTS `studentpreference`;
CREATE TABLE `studentpreference` (
  `SID` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `dislike1` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `dislike2` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `dislike3` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `p1` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `p2` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `p3` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `p4` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`SID`) USING BTREE,
  KEY `dislike1` (`dislike1`) USING BTREE,
  KEY `dislike2` (`dislike2`) USING BTREE,
  KEY `dislike3` (`dislike3`) USING BTREE,
  KEY `p1` (`p1`) USING BTREE,
  KEY `p2` (`p2`) USING BTREE,
  KEY `p3` (`p3`) USING BTREE,
  KEY `p4` (`p4`) USING BTREE,
  CONSTRAINT `studentpreference_ibfk_1` FOREIGN KEY (`SID`) REFERENCES `student` (`SID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `studentpreference_ibfk_2` FOREIGN KEY (`dislike1`) REFERENCES `student` (`SID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `studentpreference_ibfk_3` FOREIGN KEY (`dislike2`) REFERENCES `student` (`SID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `studentpreference_ibfk_4` FOREIGN KEY (`dislike3`) REFERENCES `student` (`SID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `studentpreference_ibfk_5` FOREIGN KEY (`p1`) REFERENCES `project` (`PID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `studentpreference_ibfk_6` FOREIGN KEY (`p2`) REFERENCES `project` (`PID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `studentpreference_ibfk_7` FOREIGN KEY (`p3`) REFERENCES `project` (`PID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `studentpreference_ibfk_8` FOREIGN KEY (`p4`) REFERENCES `project` (`PID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of studentpreference
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for studentrole
-- ----------------------------
DROP TABLE IF EXISTS `studentrole`;
CREATE TABLE `studentrole` (
  `SRID` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `SID` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `RFID` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`SRID`) USING BTREE,
  KEY `SID` (`SID`) USING BTREE,
  KEY `RFID` (`RFID`) USING BTREE,
  CONSTRAINT `studentrole_ibfk_1` FOREIGN KEY (`SID`) REFERENCES `student` (`SID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `studentrole_ibfk_2` FOREIGN KEY (`RFID`) REFERENCES `roleframework` (`RFID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of studentrole
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for team
-- ----------------------------
DROP TABLE IF EXISTS `team`;
CREATE TABLE `team` (
  `TID` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `SID1` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `SID2` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `SID3` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `SID4` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `PID` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `satisfaction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '',
  PRIMARY KEY (`TID`) USING BTREE,
  KEY `SID1` (`SID1`) USING BTREE,
  KEY `SID2` (`SID2`) USING BTREE,
  KEY `SID3` (`SID3`) USING BTREE,
  KEY `SID4` (`SID4`) USING BTREE,
  KEY `PID` (`PID`) USING BTREE,
  CONSTRAINT `team_ibfk_1` FOREIGN KEY (`SID1`) REFERENCES `student` (`SID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `team_ibfk_2` FOREIGN KEY (`SID2`) REFERENCES `student` (`SID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `team_ibfk_3` FOREIGN KEY (`SID3`) REFERENCES `student` (`SID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `team_ibfk_4` FOREIGN KEY (`SID4`) REFERENCES `student` (`SID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `team_ibfk_5` FOREIGN KEY (`PID`) REFERENCES `project` (`PID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of team
-- ----------------------------
BEGIN;
INSERT INTO `team` VALUES ('null', 's1', 's2', 's7', 's9', 'pr2', '0');
INSERT INTO `team` VALUES ('t2', 's1', 's2', 's7', 's9', 'pr2', '0');
INSERT INTO `team` VALUES ('t3', 's1', 's2', 's7', 's9', 'pr5', '3');
INSERT INTO `team` VALUES ('t4', 's1', 's2', 's7', 's9', 'pr6', '3');
COMMIT;

-- ----------------------------
-- Table structure for Weight
-- ----------------------------
DROP TABLE IF EXISTS `Weight`;
CREATE TABLE `Weight` (
  `wId` varchar(255) NOT NULL,
  `constraint` varchar(255) NOT NULL,
  `weight` int NOT NULL,
  PRIMARY KEY (`wId`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Weight
-- ----------------------------
BEGIN;
INSERT INTO `Weight` VALUES ('w1', 'personalitytype', 7);
INSERT INTO `Weight` VALUES ('w2', 'workexperience', 3);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
