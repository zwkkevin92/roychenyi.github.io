/*
Navicat MySQL Data Transfer

Source Server         : 1
Source Server Version : 50619
Source Host           : localhost:3306
Source Database       : dlog

Target Server Type    : MYSQL
Target Server Version : 50619
File Encoding         : 65001

Date: 2016-01-19 12:58:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `dlog_user`
-- ----------------------------
DROP TABLE IF EXISTS `dlog_user`;
CREATE TABLE `dlog_user` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `site_id` int(11) DEFAULT NULL,
  `own_site_id` int(11) NOT NULL,
  `username` varchar(40) NOT NULL,
  `password` varchar(50) NOT NULL,
  `user_role` int(11) NOT NULL,
  `nickname` varchar(50) NOT NULL,
  `sex` smallint(6) NOT NULL,
  `birth` date DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `homepage` varchar(50) DEFAULT NULL,
  `qq` varchar(16) DEFAULT NULL,
  `msn` varchar(50) DEFAULT NULL,
  `mobile` varchar(16) DEFAULT NULL,
  `nation` varchar(40) DEFAULT NULL,
  `province` varchar(40) DEFAULT NULL,
  `city` varchar(40) DEFAULT NULL,
  `industry` varchar(40) DEFAULT NULL,
  `company` varchar(80) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `job` varchar(40) DEFAULT NULL,
  `fax` varchar(20) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `zip` varchar(12) DEFAULT NULL,
  `portrait` varchar(100) DEFAULT NULL,
  `resume` varchar(200) DEFAULT NULL,
  `regtime` datetime NOT NULL,
  `last_time` datetime DEFAULT NULL,
  `last_ip` varchar(16) DEFAULT NULL,
  `keep_days` int(11) NOT NULL,
  `online_status` int(11) NOT NULL,
  `user_level` int(11) NOT NULL,
  `status` smallint(6) NOT NULL,
  `article_count` int(11) NOT NULL,
  `article_reply_count` int(11) NOT NULL,
  `topic_count` int(11) NOT NULL,
  `topic_reply_count` int(11) NOT NULL,
  `photo_count` int(11) NOT NULL,
  `photo_reply_count` int(11) NOT NULL,
  `guestbook_count` int(11) NOT NULL,
  `bookmark_count` int(11) NOT NULL,
  `portrait_icon` char(100) DEFAULT NULL,
  `popedom` smallint(6) NOT NULL DEFAULT '0',
  `visitor` char(200) DEFAULT NULL,
  `user_ext1` int(11) NOT NULL DEFAULT '0',
  `user_ext2` int(11) NOT NULL DEFAULT '0',
  `user_ext3` varchar(16) DEFAULT NULL,
  `user_ext4` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`userid`),
  KEY `userid` (`userid`),
  KEY `FK_r_site_user` (`site_id`),
  CONSTRAINT `FK_r_site_user` FOREIGN KEY (`site_id`) REFERENCES `dlog_site` (`site_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dlog_user
-- ----------------------------
INSERT INTO `dlog_user` VALUES ('1', '1', '1', '1', '70AC44F868C01069', '0', '1', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2015-10-07 12:27:53', '2015-11-06 19:21:54', '127.0.0.1', '365', '0', '1', '0', '0', '6', '0', '0', '0', '0', '0', '0', '', '0', null, '0', '0', '5LtOobiph7r5Ici9', null);
INSERT INTO `dlog_user` VALUES ('2', '2', '2', '2', '70AC44F868C01069', '0', '2', '0', null, '852416288@qq.com', null, null, null, null, null, '', '', null, null, null, null, null, null, null, '0/2.png', null, '2015-10-14 12:43:24', '2015-10-30 11:51:11', '127.0.0.1', '365', '1', '1', '0', '2', '10', '0', '0', '1', '1', '0', '1', '0/2_s.png', '4', '3,1', '0', '0', 'Rz05V9Ef7VVhA1HQ', null);
INSERT INTO `dlog_user` VALUES ('3', null, '3', '3', '70AC44F868C01069', '0', '3', '0', '2015-10-15', '852416288@qq.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2015-10-14 15:29:24', '2015-10-16 14:31:01', '127.0.0.1', '0', '0', '1', '0', '0', '1', '0', '0', '0', '0', '0', '1', null, '0', null, '0', '0', 'aNYil29QNUwXQdXg', null);
INSERT INTO `dlog_user` VALUES ('4', null, '1', '测试', '70AC44F868C01069', '0', '测试', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2016-01-19 12:23:59', '2016-01-19 12:24:03', '127.0.0.1', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', null, '0', null, '0', '0', null, null);
