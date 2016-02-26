/*
Navicat MySQL Data Transfer

Source Server         : 1
Source Server Version : 50619
Source Host           : localhost:3306
Source Database       : dlog

Target Server Type    : MYSQL
Target Server Version : 50619
File Encoding         : 65001

Date: 2016-01-19 14:46:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `dlog_album`
-- ----------------------------
DROP TABLE IF EXISTS `dlog_album`;
CREATE TABLE `dlog_album` (
  `album_id` int(11) NOT NULL AUTO_INCREMENT,
  `photo_id` int(11) DEFAULT NULL,
  `dlo_album_id` int(11) DEFAULT NULL,
  `site_id` int(11) NOT NULL,
  `dlog_type_id` int(11) DEFAULT NULL,
  `album_name` varchar(40) NOT NULL,
  `album_desc` varchar(200) DEFAULT NULL,
  `photo_count` int(11) NOT NULL,
  `album_type` int(11) NOT NULL,
  `verifycode` varchar(20) DEFAULT NULL,
  `sort_order` int(11) NOT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`album_id`),
  KEY `album_id` (`album_id`),
  KEY `FK_r_album` (`dlo_album_id`),
  KEY `FK_r_album_cover` (`photo_id`),
  KEY `FK_r_album_type` (`dlog_type_id`),
  KEY `FK_r_site_album` (`site_id`),
  CONSTRAINT `FK_r_album` FOREIGN KEY (`dlo_album_id`) REFERENCES `dlog_album` (`album_id`),
  CONSTRAINT `FK_r_album_cover` FOREIGN KEY (`photo_id`) REFERENCES `dlog_photo` (`photo_id`),
  CONSTRAINT `FK_r_album_type` FOREIGN KEY (`dlog_type_id`) REFERENCES `dlog_type` (`dlog_type_id`),
  CONSTRAINT `FK_r_site_album` FOREIGN KEY (`site_id`) REFERENCES `dlog_site` (`site_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dlog_album
-- ----------------------------
INSERT INTO `dlog_album` VALUES ('1', null, null, '2', null, '测试1', '测试22222', '1', '0', null, '1', '2015-10-15 11:07:44');

-- ----------------------------
-- Table structure for `dlog_blocked_ip`
-- ----------------------------
DROP TABLE IF EXISTS `dlog_blocked_ip`;
CREATE TABLE `dlog_blocked_ip` (
  `blocked_ip_id` int(11) NOT NULL AUTO_INCREMENT,
  `site_id` int(11) DEFAULT NULL,
  `ip_addr` int(11) NOT NULL,
  `s_ip_addr` varchar(16) NOT NULL,
  `ip_mask` int(11) NOT NULL,
  `s_ip_mask` varchar(16) NOT NULL,
  `blocked_type` smallint(6) NOT NULL,
  `blocked_time` datetime NOT NULL,
  `status` smallint(6) NOT NULL,
  PRIMARY KEY (`blocked_ip_id`),
  KEY `blocked_ip_id` (`blocked_ip_id`),
  KEY `FK_r_site_blocked_ip` (`site_id`),
  CONSTRAINT `FK_r_site_blocked_ip` FOREIGN KEY (`site_id`) REFERENCES `dlog_site` (`site_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dlog_blocked_ip
-- ----------------------------

-- ----------------------------
-- Table structure for `dlog_bookmark`
-- ----------------------------
DROP TABLE IF EXISTS `dlog_bookmark`;
CREATE TABLE `dlog_bookmark` (
  `mark_id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `site_id` int(11) NOT NULL,
  `parent_id` int(11) NOT NULL,
  `parent_type` smallint(6) NOT NULL,
  `title` varchar(200) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`mark_id`),
  KEY `mark_id` (`mark_id`),
  KEY `FK_r_site_bookmark` (`site_id`),
  KEY `FK_r_user_mark` (`userid`),
  CONSTRAINT `FK_r_site_bookmark` FOREIGN KEY (`site_id`) REFERENCES `dlog_site` (`site_id`),
  CONSTRAINT `FK_r_user_mark` FOREIGN KEY (`userid`) REFERENCES `dlog_user` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dlog_bookmark
-- ----------------------------
INSERT INTO `dlog_bookmark` VALUES ('1', '3', '2', '2', '5', '1', null, '2015-10-15 15:33:29');
INSERT INTO `dlog_bookmark` VALUES ('2', '2', '2', '2', '5', '??', null, '2015-10-27 11:34:02');

-- ----------------------------
-- Table structure for `dlog_bulletin`
-- ----------------------------
DROP TABLE IF EXISTS `dlog_bulletin`;
CREATE TABLE `dlog_bulletin` (
  `bulletin_id` int(11) NOT NULL AUTO_INCREMENT,
  `site_id` int(11) NOT NULL,
  `bulletin_type` int(11) NOT NULL,
  `pub_time` datetime NOT NULL,
  `status` smallint(6) NOT NULL,
  `title` varchar(200) NOT NULL,
  `content` text NOT NULL,
  PRIMARY KEY (`bulletin_id`),
  KEY `bulletin_id` (`bulletin_id`),
  KEY `FK_r_site_bulletin` (`site_id`),
  CONSTRAINT `FK_r_site_bulletin` FOREIGN KEY (`site_id`) REFERENCES `dlog_site` (`site_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dlog_bulletin
-- ----------------------------

-- ----------------------------
-- Table structure for `dlog_catalog`
-- ----------------------------
DROP TABLE IF EXISTS `dlog_catalog`;
CREATE TABLE `dlog_catalog` (
  `catalog_id` int(11) NOT NULL AUTO_INCREMENT,
  `dlog_type_id` int(11) DEFAULT NULL,
  `site_id` int(11) NOT NULL,
  `catalog_name` varchar(20) NOT NULL,
  `catalog_desc` varchar(200) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `article_count` int(11) NOT NULL,
  `catalog_type` smallint(6) NOT NULL,
  `verifyCode` varchar(20) DEFAULT NULL,
  `sort_order` int(11) NOT NULL,
  PRIMARY KEY (`catalog_id`),
  KEY `catalog_id` (`catalog_id`),
  KEY `FK_r_catalog_type` (`dlog_type_id`),
  KEY `FK_r_site_catalog` (`site_id`),
  CONSTRAINT `FK_r_catalog_type` FOREIGN KEY (`dlog_type_id`) REFERENCES `dlog_type` (`dlog_type_id`),
  CONSTRAINT `FK_r_site_catalog` FOREIGN KEY (`site_id`) REFERENCES `dlog_site` (`site_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dlog_catalog
-- ----------------------------
INSERT INTO `dlog_catalog` VALUES ('1', null, '2', '????', null, '2015-10-15 10:54:53', '0', '1', null, '1');
INSERT INTO `dlog_catalog` VALUES ('2', null, '2', '测试', null, '2015-10-15 10:55:04', '2', '1', null, '2');

-- ----------------------------
-- Table structure for `dlog_catalog_perm`
-- ----------------------------
DROP TABLE IF EXISTS `dlog_catalog_perm`;
CREATE TABLE `dlog_catalog_perm` (
  `catalog_id` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `user_role` int(11) NOT NULL,
  PRIMARY KEY (`catalog_id`,`userid`),
  KEY `catalog_id` (`catalog_id`),
  KEY `FK_dlog_catalog_perm2` (`userid`),
  CONSTRAINT `FK_dlog_catalog_perm` FOREIGN KEY (`catalog_id`) REFERENCES `dlog_catalog` (`catalog_id`),
  CONSTRAINT `FK_dlog_catalog_perm2` FOREIGN KEY (`userid`) REFERENCES `dlog_user` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dlog_catalog_perm
-- ----------------------------

-- ----------------------------
-- Table structure for `dlog_comments`
-- ----------------------------
DROP TABLE IF EXISTS `dlog_comments`;
CREATE TABLE `dlog_comments` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `dlo_comment_id` int(11) DEFAULT NULL,
  `owner_type` smallint(6) NOT NULL,
  `owner_ident` int(11) NOT NULL,
  `entity_id` int(11) NOT NULL,
  `entity_type` int(11) NOT NULL,
  `client_ip` varchar(16) NOT NULL,
  `client_type` smallint(6) NOT NULL,
  `client_user_agent` varchar(100) DEFAULT NULL,
  `author_id` int(11) NOT NULL,
  `author` varchar(20) NOT NULL,
  `author_email` varchar(50) DEFAULT NULL,
  `author_url` varchar(100) DEFAULT NULL,
  `title` varchar(200) NOT NULL,
  `content` text NOT NULL,
  `content_format` smallint(6) NOT NULL,
  `comment_time` datetime NOT NULL,
  `comment_flag` smallint(6) NOT NULL,
  `comment_status` smallint(6) NOT NULL,
  PRIMARY KEY (`comment_id`),
  KEY `comment_id` (`comment_id`),
  KEY `FK_r_sub_comment` (`dlo_comment_id`),
  CONSTRAINT `FK_r_sub_comment` FOREIGN KEY (`dlo_comment_id`) REFERENCES `dlog_comments` (`comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dlog_comments
-- ----------------------------

-- ----------------------------
-- Table structure for `dlog_config`
-- ----------------------------
DROP TABLE IF EXISTS `dlog_config`;
CREATE TABLE `dlog_config` (
  `config_id` int(11) NOT NULL AUTO_INCREMENT,
  `site_id` int(11) DEFAULT NULL,
  `config_name` varchar(20) NOT NULL,
  `int_value` int(11) DEFAULT NULL,
  `string_value` varchar(100) DEFAULT NULL,
  `date_value` date DEFAULT NULL,
  `time_value` time DEFAULT NULL,
  `timestamp_value` datetime DEFAULT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`config_id`),
  KEY `config_id` (`config_id`),
  KEY `FK_r_site_config` (`site_id`),
  CONSTRAINT `FK_r_site_config` FOREIGN KEY (`site_id`) REFERENCES `dlog_site` (`site_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dlog_config
-- ----------------------------

-- ----------------------------
-- Table structure for `dlog_diary`
-- ----------------------------
DROP TABLE IF EXISTS `dlog_diary`;
CREATE TABLE `dlog_diary` (
  `diary_id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `site_id` int(11) NOT NULL,
  `catalog_id` int(11) NOT NULL,
  `author` varchar(20) NOT NULL,
  `author_url` varchar(100) DEFAULT NULL,
  `title` varchar(200) NOT NULL,
  `content` text NOT NULL,
  `diary_size` int(11) NOT NULL,
  `refer` varchar(100) DEFAULT NULL,
  `weather` varchar(20) NOT NULL,
  `mood_level` smallint(6) NOT NULL,
  `tags` varchar(100) DEFAULT NULL,
  `bgsound` int(11) DEFAULT NULL,
  `reply_count` int(11) NOT NULL,
  `view_count` int(11) NOT NULL,
  `tb_count` int(11) NOT NULL,
  `client_type` smallint(6) NOT NULL,
  `client_ip` varchar(16) NOT NULL,
  `client_user_agent` varchar(100) DEFAULT NULL,
  `write_time` datetime NOT NULL,
  `last_read_time` datetime DEFAULT NULL,
  `last_reply_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `reply_notify` smallint(6) NOT NULL,
  `diary_type` smallint(6) NOT NULL,
  `locked` smallint(6) NOT NULL,
  `status` smallint(6) NOT NULL,
  `diary_annex` smallint(6) NOT NULL DEFAULT '0',
  PRIMARY KEY (`diary_id`),
  KEY `diary_id` (`diary_id`),
  KEY `FK_r_catalog_diary` (`catalog_id`),
  KEY `FK_r_site_journal` (`site_id`),
  KEY `FK_r_user_journal` (`userid`),
  CONSTRAINT `FK_r_catalog_diary` FOREIGN KEY (`catalog_id`) REFERENCES `dlog_catalog` (`catalog_id`),
  CONSTRAINT `FK_r_site_journal` FOREIGN KEY (`site_id`) REFERENCES `dlog_site` (`site_id`),
  CONSTRAINT `FK_r_user_journal` FOREIGN KEY (`userid`) REFERENCES `dlog_user` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dlog_diary
-- ----------------------------
INSERT INTO `dlog_diary` VALUES ('1', '2', '2', '2', '2', '/dlog/dlog/viewuser.vm?sid=2&uid=2', '测试', '测试测试^^^^^……', '17', null, 'sunny', '3', '测试', null, '17', '85', '0', '0', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/36.0.1985....', '2015-10-15 07:03:18', '2015-11-06 19:28:56', '2015-10-30 10:25:30', null, '1', '0', '0', '0', '1');
INSERT INTO `dlog_diary` VALUES ('2', '2', '2', '2', '2', '/dlog/dlog/viewuser.vm?sid=2&uid=2', '测试2', 'TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT', '0', null, 'sunny', '3', '测试  测试1', null, '0', '0', '0', '0', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2547....', '2015-10-30 12:03:28', null, null, null, '1', '0', '0', '5', '1');
INSERT INTO `dlog_diary` VALUES ('3', '2', '2', '2', '2', '/dlog/dlog/viewuser.vm?sid=2&uid=2', '测试2', 'TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT111', '0', null, 'sunny', '3', '测试  测试1', null, '0', '0', '0', '0', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2547....', '2015-10-30 12:35:07', null, null, null, '1', '0', '0', '5', '1');
INSERT INTO `dlog_diary` VALUES ('4', '2', '2', '2', '2', '/dlog/dlog/viewuser.vm?sid=2&uid=2', '测试2', 'TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT111\r\n、\r\n\r\nvewbwerbgrn', '59', null, 'sunny', '3', '测试  测试1', null, '0', '2', '0', '0', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2547....', '2015-10-30 12:39:49', '2015-11-06 19:41:20', null, null, '0', '0', '0', '0', '1');

-- ----------------------------
-- Table structure for `dlog_diary_annex`
-- ----------------------------
DROP TABLE IF EXISTS `dlog_diary_annex`;
CREATE TABLE `dlog_diary_annex` (
  `annex_id` int(11) NOT NULL,
  `annex_user_id` int(11) NOT NULL,
  `annex_site_id` int(11) NOT NULL,
  `annex_upload_time` datetime NOT NULL,
  `annex_download_count` int(11) NOT NULL,
  `annex_status` int(11) DEFAULT NULL,
  `annex_validate` bigint(20) NOT NULL,
  `annex_type` int(11) DEFAULT NULL,
  `annex_url` varchar(256) NOT NULL,
  `annex_disk_path` varchar(256) NOT NULL,
  `annex_file_name` varchar(256) NOT NULL,
  `annex_file_desc` varchar(256) DEFAULT NULL,
  `annex_name` varchar(256) NOT NULL,
  `annex_diary_id` int(11) DEFAULT NULL,
  `annex_size` int(11) NOT NULL,
  `annex_last_time` datetime DEFAULT NULL,
  `annex_extend1` int(11) DEFAULT NULL,
  `annex_extend2` int(11) DEFAULT NULL,
  `annex_extend3` varchar(1024) DEFAULT NULL,
  `annex_extend4` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`annex_id`),
  KEY `annex_id` (`annex_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dlog_diary_annex
-- ----------------------------

-- ----------------------------
-- Table structure for `dlog_external_refer`
-- ----------------------------
DROP TABLE IF EXISTS `dlog_external_refer`;
CREATE TABLE `dlog_external_refer` (
  `refer_id` int(11) NOT NULL AUTO_INCREMENT,
  `site_id` int(11) DEFAULT NULL,
  `ref_id` int(11) NOT NULL,
  `ref_type` smallint(6) NOT NULL,
  `refer_host` varchar(50) DEFAULT NULL,
  `refer_url` varchar(250) NOT NULL,
  `client_ip` varchar(16) NOT NULL,
  `refer_time` datetime NOT NULL,
  PRIMARY KEY (`refer_id`),
  KEY `refer_id` (`refer_id`),
  KEY `FK_r_site_refer` (`site_id`),
  CONSTRAINT `FK_r_site_refer` FOREIGN KEY (`site_id`) REFERENCES `dlog_site` (`site_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dlog_external_refer
-- ----------------------------

-- ----------------------------
-- Table structure for `dlog_fck_upload_file`
-- ----------------------------
DROP TABLE IF EXISTS `dlog_fck_upload_file`;
CREATE TABLE `dlog_fck_upload_file` (
  `fck_file_id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `site_id` int(11) DEFAULT NULL,
  `upload_time` datetime NOT NULL,
  `session_id` varchar(100) NOT NULL,
  `ref_id` int(11) NOT NULL,
  `ref_type` smallint(6) NOT NULL,
  `save_path` varchar(255) NOT NULL,
  `file_uri` varchar(100) NOT NULL,
  `file_type` int(11) NOT NULL,
  `file_size` int(11) NOT NULL,
  PRIMARY KEY (`fck_file_id`),
  KEY `fck_file_id` (`fck_file_id`),
  KEY `FK_r_site_file` (`site_id`),
  KEY `FK_r_user_upload` (`userid`),
  CONSTRAINT `FK_r_site_file` FOREIGN KEY (`site_id`) REFERENCES `dlog_site` (`site_id`),
  CONSTRAINT `FK_r_user_upload` FOREIGN KEY (`userid`) REFERENCES `dlog_user` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dlog_fck_upload_file
-- ----------------------------

-- ----------------------------
-- Table structure for `dlog_forum`
-- ----------------------------
DROP TABLE IF EXISTS `dlog_forum`;
CREATE TABLE `dlog_forum` (
  `forum_id` int(11) NOT NULL AUTO_INCREMENT,
  `site_id` int(11) NOT NULL,
  `dlog_type_id` int(11) DEFAULT NULL,
  `forum_name` varchar(40) NOT NULL,
  `forum_desc` varchar(200) DEFAULT NULL,
  `forum_type` int(11) NOT NULL,
  `create_time` datetime NOT NULL,
  `modify_time` datetime DEFAULT NULL,
  `last_time` datetime DEFAULT NULL,
  `last_user_id` int(11) DEFAULT NULL,
  `last_user_name` varchar(50) DEFAULT NULL,
  `last_topic_id` int(11) DEFAULT NULL,
  `sort_order` int(11) NOT NULL,
  `topic_count` int(11) NOT NULL,
  `forum_option` int(11) NOT NULL,
  `status` smallint(6) NOT NULL,
  PRIMARY KEY (`forum_id`),
  KEY `forum_id` (`forum_id`),
  KEY `FK_r_forum_type` (`dlog_type_id`),
  KEY `FK_r_site_forum` (`site_id`),
  CONSTRAINT `FK_r_forum_type` FOREIGN KEY (`dlog_type_id`) REFERENCES `dlog_type` (`dlog_type_id`),
  CONSTRAINT `FK_r_site_forum` FOREIGN KEY (`site_id`) REFERENCES `dlog_site` (`site_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dlog_forum
-- ----------------------------
INSERT INTO `dlog_forum` VALUES ('1', '1', null, '测试2015', '测试。。。。。。。。。。。', '0', '2015-10-16 14:53:54', null, null, null, null, null, '0', '0', '0', '0');

-- ----------------------------
-- Table structure for `dlog_friend`
-- ----------------------------
DROP TABLE IF EXISTS `dlog_friend`;
CREATE TABLE `dlog_friend` (
  `user_id` int(11) NOT NULL,
  `friend_id` int(11) NOT NULL,
  `friend_type` int(11) NOT NULL,
  `friend_role` int(11) NOT NULL,
  `add_time` datetime NOT NULL,
  `friend_group_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`friend_id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dlog_friend
-- ----------------------------

-- ----------------------------
-- Table structure for `dlog_guestbook`
-- ----------------------------
DROP TABLE IF EXISTS `dlog_guestbook`;
CREATE TABLE `dlog_guestbook` (
  `guest_book_id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `site_id` int(11) NOT NULL,
  `content` text NOT NULL,
  `client_type` smallint(6) NOT NULL,
  `client_ip` varchar(16) NOT NULL,
  `client_user_agent` varchar(100) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `reply_content` text,
  `reply_time` datetime DEFAULT NULL,
  PRIMARY KEY (`guest_book_id`),
  KEY `guest_book_id` (`guest_book_id`),
  KEY `FK_r_site_guest` (`site_id`),
  KEY `FK_r_user_liuyan` (`userid`),
  CONSTRAINT `FK_r_site_guest` FOREIGN KEY (`site_id`) REFERENCES `dlog_site` (`site_id`),
  CONSTRAINT `FK_r_user_liuyan` FOREIGN KEY (`userid`) REFERENCES `dlog_user` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dlog_guestbook
-- ----------------------------

-- ----------------------------
-- Table structure for `dlog_j_reply`
-- ----------------------------
DROP TABLE IF EXISTS `dlog_j_reply`;
CREATE TABLE `dlog_j_reply` (
  `j_reply_id` int(11) NOT NULL AUTO_INCREMENT,
  `site_id` int(11) NOT NULL,
  `userid` int(11) DEFAULT NULL,
  `diary_id` int(11) NOT NULL,
  `author` varchar(20) NOT NULL,
  `author_url` varchar(100) DEFAULT NULL,
  `author_email` varchar(50) DEFAULT NULL,
  `client_type` smallint(6) NOT NULL,
  `client_ip` varchar(16) NOT NULL,
  `client_user_agent` varchar(100) DEFAULT NULL,
  `owner_only` int(11) NOT NULL,
  `content` text NOT NULL,
  `write_time` datetime NOT NULL,
  `status` smallint(6) NOT NULL,
  PRIMARY KEY (`j_reply_id`),
  KEY `j_reply_id` (`j_reply_id`),
  KEY `FK_r_journal_reply` (`diary_id`),
  KEY `FK_r_site_j_reply` (`site_id`),
  KEY `FK_r_user_j_reply` (`userid`),
  CONSTRAINT `FK_r_journal_reply` FOREIGN KEY (`diary_id`) REFERENCES `dlog_diary` (`diary_id`),
  CONSTRAINT `FK_r_site_j_reply` FOREIGN KEY (`site_id`) REFERENCES `dlog_site` (`site_id`),
  CONSTRAINT `FK_r_user_j_reply` FOREIGN KEY (`userid`) REFERENCES `dlog_user` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dlog_j_reply
-- ----------------------------
INSERT INTO `dlog_j_reply` VALUES ('1', '2', '2', '1', '2', null, '852416288@qq.com', '0', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/36.0.1985....', '0', '测试测试											', '2015-10-15 10:57:44', '0');
INSERT INTO `dlog_j_reply` VALUES ('2', '2', '2', '1', '2', null, '852416288@qq.com', '0', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/36.0.1985....', '1', '																											11111111										\r\n		31525	32525								\r\n											', '2015-10-15 10:59:44', '0');
INSERT INTO `dlog_j_reply` VALUES ('3', '2', '3', '1', '3', null, '852416288@qq.com', '0', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/36.0.1985....', '0', '		到此一游									', '2015-10-15 15:34:34', '0');
INSERT INTO `dlog_j_reply` VALUES ('4', '2', '2', '1', '匿名网友', null, '852416288@qq.com', '0', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/36.0.1985....', '0', '			20151028								', '2015-10-28 11:25:15', '0');
INSERT INTO `dlog_j_reply` VALUES ('5', '2', '2', '1', '匿名网友', null, null, '0', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/36.0.1985....', '0', '													12345	4235435										\r\n											', '2015-10-28 11:28:24', '0');
INSERT INTO `dlog_j_reply` VALUES ('6', '2', '2', '1', '匿名网友', null, null, '0', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/36.0.1985....', '0', '													<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"5\" class=\"quote\">\r\n                            	<tr>\r\n									<td class=\"quote_title\"><a href=\"#comment_5\">#5楼</a> <span class=\"quote_author\">2</span> 原帖：</td>\r\n                            	</tr>\r\n                            	<tr>\r\n                            		<td class=\"quote_content\">12345											</td>\r\n                            	</tr>\r\n                            </table>\r\n							<p>点评：</p>\r\n											', '2015-10-28 11:32:58', '0');
INSERT INTO `dlog_j_reply` VALUES ('7', '2', '2', '1', '匿名网友', null, null, '0', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/36.0.1985....', '0', '													<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"5\" class=\"quote\">\r\n                            	<tr>\r\n									<td class=\"quote_title\"><a href=\"#comment_6\">#6楼</a> <span class=\"quote_author\">匿名网友</span> 原帖：</td>\r\n                            	</tr>\r\n                            	<tr>\r\n                            		<td class=\"quote_content\">													<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"5\" class=\"quote\">\r\n                            	<tr>\r\n									<td class=\"quote_title\"><a href=\"#comment_5\">#5楼</a> <span class=\"quote_author\">2</span> 原帖：</td>\r\n                            	</tr>\r\n                            	<tr>\r\n                            		<td class=\"quote_content\">12345											</td>\r\n                            	</tr>\r\n                            </table>\r\n							<p>点评：</p>\r\n											</td>\r\n                            	</tr>\r\n                            </table>\r\n							<p>点评：1234567</p>\r\n											', '2015-10-28 11:34:59', '0');
INSERT INTO `dlog_j_reply` VALUES ('8', '2', '2', '1', '匿名网友', null, null, '0', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/36.0.1985....', '0', '													<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"5\" class=\"quote\">\r\n                            	<tr>\r\n									<td class=\"quote_title\"><a href=\"#comment_7\">#7楼</a> <span class=\"quote_author\">匿名网友</span> 原帖：</td>\r\n                            	</tr>\r\n                            	<tr>\r\n                            		<td class=\"quote_content\">													<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"5\" class=\"quote\">\r\n                            	<tr>\r\n									<td class=\"quote_title\"><a href=\"#comment_6\">#6楼</a> <span class=\"quote_author\">匿名网友</span> 原帖：</td>\r\n                            	</tr>\r\n                            	<tr>\r\n                            		<td class=\"quote_content\">													<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"5\" class=\"quote\">\r\n                            	<tr>\r\n									<td class=\"quote_title\"><a href=\"#comment_5\">#5楼</a> <span class=\"quote_author\">2</span> 原帖：</td>\r\n                            	</tr>\r\n                            	<tr>\r\n                            		<td class=\"quote_content\">12345											</td>\r\n                            	</tr>\r\n                            </table>\r\n							<p>点评：</p>\r\n											</td>\r\n                            	</tr>\r\n                            </table>\r\n							<p>点评：1234567</p>\r\n											</td>\r\n                            	</tr>\r\n                            </table>\r\n							<p>点评：</p>\r\n											', '2015-10-28 12:03:07', '0');
INSERT INTO `dlog_j_reply` VALUES ('9', '2', '1', '1', '匿名网友', null, null, '0', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/36.0.1985....', '0', '													<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"5\" class=\"quote\">\r\n                            	<tr>\r\n									<td class=\"quote_title\"><a href=\"#comment_8\">#8楼</a> <span class=\"quote_author\">匿名网友</span> 原帖：</td>\r\n                            	</tr>\r\n                            	<tr>\r\n                            		<td class=\"quote_content\">													<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"5\" class=\"quote\">\r\n                            	<tr>\r\n									<td class=\"quote_title\"><a href=\"#comment_7\">#7楼</a> <span class=\"quote_author\">匿名网友</span> 原帖：</td>\r\n                            	</tr>\r\n                            	<tr>\r\n                            		<td class=\"quote_content\">													<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"5\" class=\"quote\">\r\n                            	<tr>\r\n									<td class=\"quote_title\"><a href=\"#comment_6\">#6楼</a> <span class=\"quote_author\">匿名网友</span> 原帖：</td>\r\n                            	</tr>\r\n                            	<tr>\r\n                            		<td class=\"quote_content\">													<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"5\" class=\"quote\">\r\n                            	<tr>\r\n									<td class=\"quote_title\"><a href=\"#comment_5\">#5楼</a> <span class=\"quote_author\">2</span> 原帖：</td>\r\n                            	</tr>\r\n                            	<tr>\r\n                            		<td class=\"quote_content\">12345											</td>\r\n                            	</tr>\r\n                            </table>\r\n							<p>点评：</p>\r\n											</td>\r\n                            	</tr>\r\n                            </table>\r\n							<p>点评：1234567</p>\r\n											</td>\r\n                            	</tr>\r\n                            </table>\r\n							<p>点评：</p>\r\n											</td>\r\n                            	</tr>\r\n                            </table>\r\n							<p>点评：</p>\r\n											', '2015-10-28 15:32:56', '0');
INSERT INTO `dlog_j_reply` VALUES ('10', '2', '1', '1', '匿名网友', null, null, '0', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/36.0.1985....', '0', '													<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"5\" class=\"quote\">\r\n                            	<tr>\r\n									<td class=\"quote_title\"><a href=\"#comment_9\">#9楼</a> <span class=\"quote_author\">匿名网友</span> 原帖：</td>\r\n                            	</tr>\r\n                            	<tr>\r\n                            		<td class=\"quote_content\">													<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"5\" class=\"quote\">\r\n                            	<tr>\r\n									<td class=\"quote_title\"><a href=\"#comment_8\">#8楼</a> <span class=\"quote_author\">匿名网友</span> 原帖：</td>\r\n                            	</tr>\r\n                            	<tr>\r\n                            		<td class=\"quote_content\">													<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"5\" class=\"quote\">\r\n                            	<tr>\r\n									<td class=\"quote_title\"><a href=\"#comment_7\">#7楼</a> <span class=\"quote_author\">匿名网友</span> 原帖：</td>\r\n                            	</tr>\r\n                            	<tr>\r\n                            		<td class=\"quote_content\">													<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"5\" class=\"quote\">\r\n                            	<tr>\r\n									<td class=\"quote_title\"><a href=\"#comment_6\">#6楼</a> <span class=\"quote_author\">匿名网友</span> 原帖：</td>\r\n                            	</tr>\r\n                            	<tr>\r\n                            		<td class=\"quote_content\">													<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"5\" class=\"quote\">\r\n                            	<tr>\r\n									<td class=\"quote_title\"><a href=\"#comment_5\">#5楼</a> <span class=\"quote_author\">2</span> 原帖：</td>\r\n                            	</tr>\r\n                            	<tr>\r\n                            		<td class=\"quote_content\">12345											</td>\r\n                            	</tr>\r\n                            </table>\r\n							<p>点评：</p>\r\n											</td>\r\n                            	</tr>\r\n     ...</table></td></tr></table></td></tr></table></td></tr></table>', '2015-10-28 15:36:08', '0');
INSERT INTO `dlog_j_reply` VALUES ('11', '2', '1', '1', '匿名网友', null, null, '0', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/36.0.1985....', '0', '													<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"5\" class=\"quote\">\r\n                            	<tr>\r\n									<td class=\"quote_title\"><a href=\"#comment_10\">#10楼</a> <span class=\"quote_author\">匿名网友</span> 原帖：</td>\r\n                            	</tr>\r\n                            	<tr>\r\n                            		<td class=\"quote_content\">													<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"5\" class=\"quote\">\r\n                            	<tr>\r\n									<td class=\"quote_title\"><a href=\"#comment_9\">#9楼</a> <span class=\"quote_author\">匿名网友</span> 原帖：</td>\r\n                            	</tr>\r\n                            	<tr>\r\n                            		<td class=\"quote_content\">													<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"5\" class=\"quote\">\r\n                            	<tr>\r\n									<td class=\"quote_title\"><a href=\"#comment_8\">#8楼</a> <span class=\"quote_author\">匿名网友</span> 原帖：</td>\r\n                            	</tr>\r\n                            	<tr>\r\n                            		<td class=\"quote_content\">													<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"5\" class=\"quote\">\r\n                            	<tr>\r\n									<td class=\"quote_title\"><a href=\"#comment_7\">#7楼</a> <span class=\"quote_author\">匿名网友</span> 原帖：</td>\r\n                            	</tr>\r\n                            	<tr>\r\n                            		<td class=\"quote_content\">													<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"5\" class=\"quote\">\r\n                            	<tr>\r\n									<td class=\"quote_title\"><a href=\"#comment_6\">#6楼</a> <span class=\"quote_author\">匿名网友</span> 原帖：</td>\r\n                            	</tr>\r\n                            	<tr>\r\n                            		<td class=\"quote_content\">													<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"5\" class=\"quote\">\r\n                            	<tr>\r\n									<td class=\"quote_title\"><a href=\"#...\"></a></td></tr></table></td></tr></table></td></tr></table></td></tr></table></td></tr></table></td></tr></table>', '2015-10-28 15:38:35', '0');
INSERT INTO `dlog_j_reply` VALUES ('12', '2', '1', '1', '匿名网友', null, null, '0', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/36.0.1985....', '0', '		43t2t423									', '2015-10-28 15:50:32', '0');
INSERT INTO `dlog_j_reply` VALUES ('13', '2', '1', '1', '匿名网友', null, null, '0', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/36.0.1985....', '0', '													<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"5\" class=\"quote\">\r\n                            	<tr>\r\n									<td class=\"quote_title\"><a href=\"#comment_11\">#11楼</a> <span class=\"quote_author\">匿名网友</span> 原帖：</td>\r\n                            	</tr>\r\n                            	<tr>\r\n                            		<td class=\"quote_content\">													<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"5\" class=\"quote\">\r\n                            	<tr>\r\n									<td class=\"quote_title\"><a href=\"#comment_10\">#10楼</a> <span class=\"quote_author\">匿名网友</span> 原帖：</td>\r\n                            	</tr>\r\n                            	<tr>\r\n                            		<td class=\"quote_content\">													<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"5\" class=\"quote\">\r\n                            	<tr>\r\n									<td class=\"quote_title\"><a href=\"#comment_9\">#9楼</a> <span class=\"quote_author\">匿名网友</span> 原帖：</td>\r\n                            	</tr>\r\n                            	<tr>\r\n                            		<td class=\"quote_content\">													<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"5\" class=\"quote\">\r\n                            	<tr>\r\n									<td class=\"quote_title\"><a href=\"#comment_8\">#8楼</a> <span class=\"quote_author\">匿名网友</span> 原帖：</td>\r\n                            	</tr>\r\n                            	<tr>\r\n                            		<td class=\"quote_content\">													<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"5\" class=\"quote\">\r\n                            	<tr>\r\n									<td class=\"quote_title\"><a href=\"#comment_7\">#7楼</a> <span class=\"quote_author\">匿名网友</span> 原帖：</td>\r\n                            	</tr>\r\n                            	<tr>\r\n                            		<td class=\"quote_content\">													<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"5\" class=\"quote\">\r\n                            	<tr>\r\n									<td class=\"quote_title\"><a href=...></a></td></tr></table></td></tr></table></td></tr></table></td></tr></table></td></tr></table></td></tr></table>', '2015-10-28 16:02:19', '0');
INSERT INTO `dlog_j_reply` VALUES ('14', '2', '1', '1', '匿名网友', null, null, '0', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/36.0.1985....', '0', '													<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"5\" class=\"quote\">\r\n                            	<tr>\r\n									<td class=\"quote_title\"><a href=\"#comment_13\">#13楼</a> <span class=\"quote_author\">匿名网友</span> 原帖：</td>\r\n                            	</tr>\r\n                            	<tr>\r\n                            		<td class=\"quote_content\">													<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"5\" class=\"quote\">\r\n                            	<tr>\r\n									<td class=\"quote_title\"><a href=\"#comment_11\">#11楼</a> <span class=\"quote_author\">匿名网友</span> 原帖：</td>\r\n                            	</tr>\r\n                            	<tr>\r\n                            		<td class=\"quote_content\">													<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"5\" class=\"quote\">\r\n                            	<tr>\r\n									<td class=\"quote_title\"><a href=\"#comment_10\">#10楼</a> <span class=\"quote_author\">匿名网友</span> 原帖：</td>\r\n                            	</tr>\r\n                            	<tr>\r\n                            		<td class=\"quote_content\">													<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"5\" class=\"quote\">\r\n                            	<tr>\r\n									<td class=\"quote_title\"><a href=\"#comment_9\">#9楼</a> <span class=\"quote_author\">匿名网友</span> 原帖：</td>\r\n                            	</tr>\r\n                            	<tr>\r\n                            		<td class=\"quote_content\">													<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"5\" class=\"quote\">\r\n                            	<tr>\r\n									<td class=\"quote_title\"><a href=\"#comment_8\">#8楼</a> <span class=\"quote_author\">匿名网友</span> 原帖：</td>\r\n                            	</tr>\r\n                            	<tr>\r\n                            		<td class=\"quote_content\">													<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"5\" class=\"quote\">\r\n                            	<tr>\r\n									<td class=\"quote_title\"><a hre...></a></td></tr></table></td></tr></table></td></tr></table></td></tr></table></td></tr></table></td></tr></table>', '2015-10-28 16:42:02', '0');
INSERT INTO `dlog_j_reply` VALUES ('16', '2', '2', '1', '2', null, '852416288@qq.com', '0', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2547....', '0', '13242											', '2015-10-29 15:37:30', '0');
INSERT INTO `dlog_j_reply` VALUES ('17', '2', '2', '1', '2', null, '852416288@qq.com', '0', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2547....', '0', '																										<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"5\" class=\"quote\">\r\n                            	<tr>\r\n									<td class=\"quote_title\"><a href=\"#comment_14\">#14楼</a> <span class=\"quote_author\">匿名网友</span> 原帖：</td>\r\n                            	</tr>\r\n                            	<tr>\r\n                            		<td class=\"quote_content\">													<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"5\" class=\"quote\">\r\n                            	<tr>\r\n									<td class=\"quote_title\"><a href=\"#comment_13\">#13楼</a> <span class=\"quote_author\">匿名网友</span> 原帖：</td>\r\n                            	</tr>\r\n                            	<tr>\r\n                            		<td class=\"quote_content\">													<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"5\" class=\"quote\">\r\n                            	<tr>\r\n									<td class=\"quote_title\"><a href=\"#comment_11\">#11楼</a> <span class=\"quote_author\">匿名网友</span> 原帖：</td>\r\n                            	</tr>\r\n                            	<tr>\r\n                            		<td class=\"quote_content\">													<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"5\" class=\"quote\">\r\n                            	<tr>\r\n									<td class=\"quote_title\"><a href=\"#comment_10\">#10楼</a> <span class=\"quote_author\">匿名网友</span> 原帖：</td>\r\n                            	</tr>\r\n                            	<tr>\r\n                            		<td class=\"quote_content\">													<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"5\" class=\"quote\">\r\n                            	<tr>\r\n									<td class=\"quote_title\"><a href=\"#comment_9\">#9楼</a> <span class=\"quote_author\">匿名网友</span> 原帖：</td>\r\n                            	</tr>\r\n                            	<tr>\r\n                            		<td class=\"quote_content\">													<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"5\" class=\"quote\">\r\n                            	<tr>\r\n									<td class=\"quot...\"></td></tr></table></td></tr></table></td></tr></table></td></tr></table></td></tr></table></td></tr></table>', '2015-10-29 16:35:05', '0');
INSERT INTO `dlog_j_reply` VALUES ('18', '2', '2', '1', '2', null, '852416288@qq.com', '0', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2547....', '0', '11234566778											', '2015-10-30 10:25:30', '0');

-- ----------------------------
-- Table structure for `dlog_link`
-- ----------------------------
DROP TABLE IF EXISTS `dlog_link`;
CREATE TABLE `dlog_link` (
  `linkid` int(11) NOT NULL AUTO_INCREMENT,
  `site_id` int(11) NOT NULL,
  `link_title` varchar(40) NOT NULL,
  `link_url` varchar(200) NOT NULL,
  `link_type` smallint(6) NOT NULL,
  `sort_order` int(11) NOT NULL,
  `create_time` datetime NOT NULL,
  `status` smallint(6) NOT NULL,
  PRIMARY KEY (`linkid`),
  KEY `linkid` (`linkid`),
  KEY `FK_r_site_link` (`site_id`),
  CONSTRAINT `FK_r_site_link` FOREIGN KEY (`site_id`) REFERENCES `dlog_site` (`site_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dlog_link
-- ----------------------------
INSERT INTO `dlog_link` VALUES ('1', '3', '测试', '2', '5', '1', '2015-10-15 15:33:32', '0');
INSERT INTO `dlog_link` VALUES ('2', '1', '知乎', 'http://www.zhihu.com/rss', '2', '0', '2015-10-22 14:59:37', '0');

-- ----------------------------
-- Table structure for `dlog_message`
-- ----------------------------
DROP TABLE IF EXISTS `dlog_message`;
CREATE TABLE `dlog_message` (
  `msgid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `from_user_id` int(11) NOT NULL,
  `from_user_name` varchar(50) NOT NULL,
  `content` text NOT NULL,
  `send_time` datetime NOT NULL,
  `expire_time` datetime DEFAULT NULL,
  `read_time` datetime DEFAULT NULL,
  `status` smallint(6) NOT NULL,
  PRIMARY KEY (`msgid`),
  KEY `msgid` (`msgid`),
  KEY `FK_r_msg_receiver` (`userid`),
  CONSTRAINT `FK_r_msg_receiver` FOREIGN KEY (`userid`) REFERENCES `dlog_user` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dlog_message
-- ----------------------------

-- ----------------------------
-- Table structure for `dlog_message_affiche`
-- ----------------------------
DROP TABLE IF EXISTS `dlog_message_affiche`;
CREATE TABLE `dlog_message_affiche` (
  `affiche_id` int(11) NOT NULL AUTO_INCREMENT,
  `affiche_title` varchar(100) NOT NULL,
  `affiche_content` text NOT NULL,
  `affiche_send_time` datetime NOT NULL,
  `affiche_status` int(11) NOT NULL,
  `affiche_user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`affiche_id`),
  KEY `affiche_id` (`affiche_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dlog_message_affiche
-- ----------------------------
INSERT INTO `dlog_message_affiche` VALUES ('1', '系统消息', '<strong>2</strong>，您好：<br />\r\n<br />\r\n&nbsp;&nbsp;&nbsp; 恭喜您已经成为网记注册用户，现在就<a href=\"http://www.seokr.com/dlog/accounts/reguser.vm\">开通个人空间</a>？ <br />\r\n<br />\r\n&nbsp;&nbsp;&nbsp; 网记的注册用户可使用的功能包括保存文章、空间为书签；交友；收发短消息等。<br />\r\n<br />\r\n<br />\r\n<strong><font size=\"3\">网记个人空间，展现你的精彩！</font></strong><br />\r\n<hr width=\"100%\" size=\"2\" />\r\n<font color=\"#808080\">客服信息：<br />\r\n<br />\r\n</font><font size=\"1\" color=\"#808080\">QQ: 22758932<br />\r\nMSN: dlog.cn@hotmail.com<br />\r\n电话: 020-33033030</font>\r\n', '2015-10-14 12:43:28', '1', '2');
INSERT INTO `dlog_message_affiche` VALUES ('2', '系统消息', '<strong>2</strong>，您好：<br />\r\n<br />\r\n&nbsp;&nbsp;&nbsp; 恭喜您已经成功开通个人空间，您可以在空间中写日记、发布照片、收藏喜爱的歌曲。您还可以跟成千上万的搜客用户沟通交流。<br />\r\n<br />\r\n&nbsp;&nbsp;&nbsp; 本站支持WEB和WAP数据同步，当您不方便用电脑访问网记时，可以通过手机访问 http://wap.seokr.com。<br />\r\n<br />\r\n&nbsp;&nbsp;&nbsp; <strong>使用网记的步骤：</strong><br />\r\n<br />\r\n&nbsp;&nbsp;&nbsp; 1. 挑选一个喜欢网站风格，<a href=\"http://www.seokr.com/html/sitemgr/styles.vm?sid=2\">GO</a><br />\r\n&nbsp;&nbsp;&nbsp; 2. 个性化频道名称，<a href=\"http://www.seokr.com/html/sitemgr/funcs.vm?sid=2\">GO</a><br />\r\n&nbsp;&nbsp;&nbsp; 3. 管理日记分类，<a href=\"http://www.seokr.com/html/sitemgr/catalogs.vm?sid=2\">GO</a><br />\r\n&nbsp;&nbsp;&nbsp; 4. 现在就开始写日记，<a href=\"http://www.seokr.com/html/diary/addlog.vm?sid=2\">GO</a><br />\r\n&nbsp;&nbsp;&nbsp; 5. 发布照片，<a href=\"http://www.seokr.com/html/photo/upload.vm?sid=2\">GO</a> <br />\r\n&nbsp;&nbsp;&nbsp; 6. 添加我喜欢的音乐，<a href=\"http://www.seokr.com/html/music/?sid=2\">GO</a><br />\r\n<br />\r\n<strong><font size=\"3\">搜客网，展现你的精彩！</font></strong><br />\r\n<hr width=\"100%\" size=\"2\" />\r\n<font color=\"#808080\">客服信息：<br />\r\n<br />\r\n</font><font size=\"1\" color=\"#808080\">QQ: 22758932<br />\r\nMSN: dlog.cn@hotmail.com<br />\r\n电话: 020-33033030</font>\r\n', '2015-10-14 12:44:07', '1', '2');
INSERT INTO `dlog_message_affiche` VALUES ('3', '系统消息', '<strong>3</strong>，您好：<br />\r\n<br />\r\n&nbsp;&nbsp;&nbsp; 恭喜您已经成为网记注册用户，现在就<a href=\"http://www.seokr.com/dlog/accounts/reguser.vm\">开通个人空间</a>？ <br />\r\n<br />\r\n&nbsp;&nbsp;&nbsp; 网记的注册用户可使用的功能包括保存文章、空间为书签；交友；收发短消息等。<br />\r\n<br />\r\n<br />\r\n<strong><font size=\"3\">网记个人空间，展现你的精彩！</font></strong><br />\r\n<hr width=\"100%\" size=\"2\" />\r\n<font color=\"#808080\">客服信息：<br />\r\n<br />\r\n</font><font size=\"1\" color=\"#808080\">QQ: 22758932<br />\r\nMSN: dlog.cn@hotmail.com<br />\r\n电话: 020-33033030</font>\r\n', '2015-10-14 15:29:34', '1', '3');
INSERT INTO `dlog_message_affiche` VALUES ('4', '系统消息', '<strong>3</strong>，您好：<br />\r\n<br />\r\n&nbsp;&nbsp;&nbsp; 恭喜您已经成功开通个人空间，您可以在空间中写日记、发布照片、收藏喜爱的歌曲。您还可以跟成千上万的搜客用户沟通交流。<br />\r\n<br />\r\n&nbsp;&nbsp;&nbsp; 本站支持WEB和WAP数据同步，当您不方便用电脑访问网记时，可以通过手机访问 http://wap.seokr.com。<br />\r\n<br />\r\n&nbsp;&nbsp;&nbsp; <strong>使用网记的步骤：</strong><br />\r\n<br />\r\n&nbsp;&nbsp;&nbsp; 1. 挑选一个喜欢网站风格，<a href=\"http://www.seokr.com/html/sitemgr/styles.vm?sid=3\">GO</a><br />\r\n&nbsp;&nbsp;&nbsp; 2. 个性化频道名称，<a href=\"http://www.seokr.com/html/sitemgr/funcs.vm?sid=3\">GO</a><br />\r\n&nbsp;&nbsp;&nbsp; 3. 管理日记分类，<a href=\"http://www.seokr.com/html/sitemgr/catalogs.vm?sid=3\">GO</a><br />\r\n&nbsp;&nbsp;&nbsp; 4. 现在就开始写日记，<a href=\"http://www.seokr.com/html/diary/addlog.vm?sid=3\">GO</a><br />\r\n&nbsp;&nbsp;&nbsp; 5. 发布照片，<a href=\"http://www.seokr.com/html/photo/upload.vm?sid=3\">GO</a> <br />\r\n&nbsp;&nbsp;&nbsp; 6. 添加我喜欢的音乐，<a href=\"http://www.seokr.com/html/music/?sid=3\">GO</a><br />\r\n<br />\r\n<strong><font size=\"3\">搜客网，展现你的精彩！</font></strong><br />\r\n<hr width=\"100%\" size=\"2\" />\r\n<font color=\"#808080\">客服信息：<br />\r\n<br />\r\n</font><font size=\"1\" color=\"#808080\">QQ: 22758932<br />\r\nMSN: dlog.cn@hotmail.com<br />\r\n电话: 020-33033030</font>\r\n', '2015-10-14 15:29:59', '1', '3');

-- ----------------------------
-- Table structure for `dlog_message_receiver`
-- ----------------------------
DROP TABLE IF EXISTS `dlog_message_receiver`;
CREATE TABLE `dlog_message_receiver` (
  `receiver_id` int(11) NOT NULL,
  `receiver_msg_id` int(11) NOT NULL,
  `receiver_user_id` int(11) NOT NULL,
  `receiver_s_user_id` int(11) NOT NULL,
  `receiver_s_user_name` varchar(100) NOT NULL,
  `receiver_write_time` datetime NOT NULL,
  `receiver_status` int(11) NOT NULL,
  PRIMARY KEY (`receiver_id`),
  KEY `receiver_id` (`receiver_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dlog_message_receiver
-- ----------------------------

-- ----------------------------
-- Table structure for `dlog_message_send`
-- ----------------------------
DROP TABLE IF EXISTS `dlog_message_send`;
CREATE TABLE `dlog_message_send` (
  `send_id` int(11) NOT NULL,
  `send_msg_id` int(11) NOT NULL,
  `send_user_id` int(11) NOT NULL,
  `send_r_user_id` int(11) NOT NULL,
  `send_r_user_name` varchar(100) NOT NULL,
  `send_time` datetime NOT NULL,
  `send_status` int(11) NOT NULL,
  PRIMARY KEY (`send_id`),
  KEY `send_id` (`send_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dlog_message_send
-- ----------------------------

-- ----------------------------
-- Table structure for `dlog_music`
-- ----------------------------
DROP TABLE IF EXISTS `dlog_music`;
CREATE TABLE `dlog_music` (
  `music_id` int(11) NOT NULL AUTO_INCREMENT,
  `music_box_id` int(11) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `site_id` int(11) NOT NULL,
  `music_title` varchar(100) NOT NULL,
  `music_word` text,
  `album` varchar(100) DEFAULT NULL,
  `singer` varchar(50) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `view_count` int(11) NOT NULL,
  `music_type` int(11) NOT NULL,
  `status` smallint(6) NOT NULL,
  PRIMARY KEY (`music_id`),
  KEY `music_id` (`music_id`),
  KEY `FK_r_music_box` (`music_box_id`),
  KEY `FK_r_recommend` (`userid`),
  KEY `FK_r_site_music` (`site_id`),
  CONSTRAINT `FK_r_music_box` FOREIGN KEY (`music_box_id`) REFERENCES `dlog_musicbox` (`music_box_id`),
  CONSTRAINT `FK_r_recommend` FOREIGN KEY (`userid`) REFERENCES `dlog_user` (`userid`),
  CONSTRAINT `FK_r_site_music` FOREIGN KEY (`site_id`) REFERENCES `dlog_site` (`site_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dlog_music
-- ----------------------------
INSERT INTO `dlog_music` VALUES ('1', null, null, '2', '测试111', '追究什么对错　你的谎言　基于你还爱我\r\n \r\n美丽的泡沫　虽然一刹花火\r\n你所有承诺　虽然都太脆弱\r\n但爱像泡沫　如果能够看破　有什么难过\r\n \r\n早该知道泡沫　一触就破\r\n就像已伤的心　不胜折磨\r\n也不是谁的错　谎言再多　基于你还爱我\r\n \r\n美丽的泡沫　虽然一刹花火\r\n你所有承诺　虽然都太脆弱\r\n爱本是泡沫　如果能够看破　有什么难过\r\n再美的花朵　盛开过就凋落\r\n再亮眼的星　一闪过就堕落\r\n爱本是泡沫　如果能够看破　有什么难过\r\n \r\n为什么难过　有什么难过　为什么难过\r\n \r\n全都是泡沫　只一刹的花火\r\n你所有承诺　全部都太脆弱\r\n而你的轮廓　怪我没有看破　才如此难过\r\n相爱的把握　要如何再搜索\r\n相拥着寂寞　难道就不寂寞\r\n爱本是泡沫　怪我没有看破　才如此难过\r\n \r\n在雨下的泡沫　一触就破\r\n当初炽热的心　早已沉没\r\n说什么你爱我　如果骗我　我宁愿你沉默\r\n \r\n', '1', '1', 'http://play.baidu.com/?__m=mboxCtrl.playSong&__a=14945107&__o=song/14945107||playBtn&fr=new_mp3||music_add.vm#', '2015-10-15 11:03:34', '0', '0', '0');
INSERT INTO `dlog_music` VALUES ('2', '1', null, '2', '泡沫', '测试', '邓紫棋', '邓紫棋', 'http://play.baidu.com/?__m=mboxCtrl.playSong&__a=14945107&__o=song/14945107||playBtn&fr=new_mp3||music_add.vm#', '2015-10-15 11:05:25', '2', '0', '0');

-- ----------------------------
-- Table structure for `dlog_musicbox`
-- ----------------------------
DROP TABLE IF EXISTS `dlog_musicbox`;
CREATE TABLE `dlog_musicbox` (
  `music_box_id` int(11) NOT NULL AUTO_INCREMENT,
  `site_id` int(11) NOT NULL,
  `box_name` varchar(40) NOT NULL,
  `box_desc` varchar(100) DEFAULT NULL,
  `music_count` int(11) NOT NULL,
  `create_time` datetime NOT NULL,
  `sort_order` int(11) NOT NULL,
  PRIMARY KEY (`music_box_id`),
  KEY `music_box_id` (`music_box_id`),
  KEY `FK_r_site_mbox` (`site_id`),
  CONSTRAINT `FK_r_site_mbox` FOREIGN KEY (`site_id`) REFERENCES `dlog_site` (`site_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dlog_musicbox
-- ----------------------------
INSERT INTO `dlog_musicbox` VALUES ('1', '2', '1', '测试', '1', '2015-10-15 11:04:37', '1');

-- ----------------------------
-- Table structure for `dlog_my_blacklist`
-- ----------------------------
DROP TABLE IF EXISTS `dlog_my_blacklist`;
CREATE TABLE `dlog_my_blacklist` (
  `my_user_id` int(11) NOT NULL,
  `other_user_id` int(11) NOT NULL,
  `bl_type` int(11) NOT NULL,
  `add_time` datetime NOT NULL,
  PRIMARY KEY (`my_user_id`,`other_user_id`),
  KEY `my_user_id` (`my_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dlog_my_blacklist
-- ----------------------------

-- ----------------------------
-- Table structure for `dlog_p_reply`
-- ----------------------------
DROP TABLE IF EXISTS `dlog_p_reply`;
CREATE TABLE `dlog_p_reply` (
  `p_reply_id` int(11) NOT NULL AUTO_INCREMENT,
  `site_id` int(11) NOT NULL,
  `photo_id` int(11) NOT NULL,
  `userid` int(11) DEFAULT NULL,
  `author` varchar(20) NOT NULL,
  `author_url` varchar(100) DEFAULT NULL,
  `author_email` varchar(50) DEFAULT NULL,
  `client_type` smallint(6) NOT NULL,
  `client_ip` varchar(16) NOT NULL,
  `client_user_agent` varchar(100) DEFAULT NULL,
  `owner_only` int(11) NOT NULL,
  `content` text NOT NULL,
  `write_time` datetime NOT NULL,
  `status` smallint(6) NOT NULL,
  PRIMARY KEY (`p_reply_id`),
  KEY `p_reply_id` (`p_reply_id`),
  KEY `FK_r_photo_reply` (`photo_id`),
  KEY `FK_r_site_p_reply` (`site_id`),
  KEY `FK_r_user_p_reply` (`userid`),
  CONSTRAINT `FK_r_photo_reply` FOREIGN KEY (`photo_id`) REFERENCES `dlog_photo` (`photo_id`),
  CONSTRAINT `FK_r_site_p_reply` FOREIGN KEY (`site_id`) REFERENCES `dlog_site` (`site_id`),
  CONSTRAINT `FK_r_user_p_reply` FOREIGN KEY (`userid`) REFERENCES `dlog_user` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dlog_p_reply
-- ----------------------------
INSERT INTO `dlog_p_reply` VALUES ('1', '2', '1', '2', '2', null, '852416288@qq.com', '0', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/36.0.1985....', '0', '11111111', '2015-10-15 11:09:07', '0');

-- ----------------------------
-- Table structure for `dlog_photo`
-- ----------------------------
DROP TABLE IF EXISTS `dlog_photo`;
CREATE TABLE `dlog_photo` (
  `photo_id` int(11) NOT NULL AUTO_INCREMENT,
  `site_id` int(11) NOT NULL,
  `album_id` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `photo_name` varchar(40) NOT NULL,
  `photo_desc` text,
  `file_name` varchar(100) NOT NULL,
  `photo_url` varchar(100) NOT NULL,
  `preview_url` varchar(100) NOT NULL,
  `tags` varchar(100) DEFAULT NULL,
  `p_year` int(11) NOT NULL,
  `p_month` smallint(6) NOT NULL,
  `p_date` smallint(6) NOT NULL,
  `width` int(11) NOT NULL,
  `height` int(11) NOT NULL,
  `photo_size` bigint(20) NOT NULL,
  `color_bit` int(11) NOT NULL,
  `exif_manufacturer` varchar(50) DEFAULT NULL,
  `exif_model` varchar(50) DEFAULT NULL,
  `exif_iso` int(11) NOT NULL,
  `exif_aperture` varchar(20) DEFAULT NULL,
  `exif_shutter` varchar(20) DEFAULT NULL,
  `exif_exposure_bias` varchar(20) DEFAULT NULL,
  `exif_exposure_time` varchar(20) DEFAULT NULL,
  `exif_focal_length` varchar(20) DEFAULT NULL,
  `exif_color_space` varchar(20) DEFAULT NULL,
  `reply_count` int(11) NOT NULL,
  `view_count` int(11) NOT NULL,
  `create_time` datetime NOT NULL,
  `modify_time` datetime DEFAULT NULL,
  `last_reply_time` datetime DEFAULT NULL,
  `photo_type` int(11) NOT NULL,
  `locked` smallint(6) NOT NULL,
  `photo_status` smallint(6) NOT NULL,
  PRIMARY KEY (`photo_id`),
  KEY `photo_id` (`photo_id`),
  KEY `FK_r_album_photo` (`album_id`),
  KEY `FK_r_photo_owner` (`userid`),
  KEY `FK_r_site_photo` (`site_id`),
  CONSTRAINT `FK_r_album_photo` FOREIGN KEY (`album_id`) REFERENCES `dlog_album` (`album_id`),
  CONSTRAINT `FK_r_photo_owner` FOREIGN KEY (`userid`) REFERENCES `dlog_user` (`userid`),
  CONSTRAINT `FK_r_site_photo` FOREIGN KEY (`site_id`) REFERENCES `dlog_site` (`site_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dlog_photo
-- ----------------------------
INSERT INTO `dlog_photo` VALUES ('1', '2', '1', '2', '1', ' ', '1.png', '/uploads/photo/2015/10/15/1444878496060.png', '/uploads/photo/2015/10/15/1444878496060_s.png.jpg', null, '2015', '10', '15', '154', '107', '22929', '32', null, null, '-1', null, null, null, null, null, null, '1', '14', '2015-10-15 11:08:16', null, '2015-10-15 11:09:07', '0', '0', '0');

-- ----------------------------
-- Table structure for `dlog_site`
-- ----------------------------
DROP TABLE IF EXISTS `dlog_site`;
CREATE TABLE `dlog_site` (
  `site_id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `dlog_type_id` int(11) DEFAULT NULL,
  `site_name` varchar(20) NOT NULL,
  `site_c_name` varchar(50) NOT NULL,
  `site_url` varchar(100) DEFAULT NULL,
  `site_title` varchar(100) DEFAULT NULL,
  `site_detail` varchar(250) DEFAULT NULL,
  `site_icp` varchar(20) DEFAULT NULL,
  `site_logo` varchar(50) DEFAULT NULL,
  `site_css` varchar(50) DEFAULT NULL,
  `site_layout` varchar(50) DEFAULT NULL,
  `site_lang` varchar(10) DEFAULT NULL,
  `site_flag` int(11) NOT NULL,
  `create_time` datetime NOT NULL,
  `last_time` datetime DEFAULT NULL,
  `expired_time` datetime DEFAULT NULL,
  `last_exp_time` datetime DEFAULT NULL,
  `access_mode` smallint(6) NOT NULL,
  `access_code` varchar(50) DEFAULT NULL,
  `diary_status` smallint(6) NOT NULL,
  `photo_status` smallint(6) NOT NULL,
  `music_status` smallint(6) NOT NULL,
  `forum_status` smallint(6) NOT NULL,
  `guestbook_status` smallint(6) NOT NULL,
  `diary_cname` varchar(16) DEFAULT NULL,
  `photo_cname` varchar(16) DEFAULT NULL,
  `music_cname` varchar(16) DEFAULT NULL,
  `bbs_cname` varchar(16) DEFAULT NULL,
  `guestbook_cname` varchar(16) DEFAULT NULL,
  `photo_space_total` int(11) NOT NULL,
  `photo_space_used` int(11) NOT NULL,
  `diary_space_total` int(11) NOT NULL,
  `diary_space_used` int(11) NOT NULL,
  `media_space_total` int(11) unsigned NOT NULL,
  `media_space_used` int(11) NOT NULL,
  `site_type` int(11) NOT NULL,
  `site_level` int(11) NOT NULL,
  `status` smallint(6) NOT NULL,
  `friend_cname` varchar(16) DEFAULT NULL,
  `friend_status` smallint(6) DEFAULT NULL,
  `site_ext1` int(11) NOT NULL DEFAULT '0',
  `site_ext2` int(11) NOT NULL DEFAULT '0',
  `site_ext3` varchar(16) DEFAULT NULL,
  `site_ext4` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`site_id`),
  KEY `site_id` (`site_id`),
  KEY `FK_r_site_type` (`dlog_type_id`),
  KEY `FK_r_user_site` (`userid`),
  CONSTRAINT `FK_r_site_type` FOREIGN KEY (`dlog_type_id`) REFERENCES `dlog_type` (`dlog_type_id`),
  CONSTRAINT `FK_r_user_site` FOREIGN KEY (`userid`) REFERENCES `dlog_user` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dlog_site
-- ----------------------------
INSERT INTO `dlog_site` VALUES ('1', '1', null, 'cc', '测试2', '', '测试22', '测试中。。。。。', null, null, 'main.css', '10000', null, '0', '2015-10-14 12:29:46', null, null, null, '0', null, '0', '0', '0', '0', '0', null, null, null, null, null, '100000', '0', '0', '0', '0', '0', '1', '1', '0', null, '0', '0', '0', null, null);
INSERT INTO `dlog_site` VALUES ('2', '2', null, 'chenyi', '测试', null, '测试1', '测试。。。。。。。。。', null, null, 'main.css', '10000', null, '0', '2015-10-14 12:44:07', null, null, null, '0', null, '0', '0', '0', '2', '0', null, null, null, null, null, '100000', '22', '0', '0', '0', '0', '1', '1', '0', null, '0', '0', '0', null, null);
INSERT INTO `dlog_site` VALUES ('3', '3', null, 'cccc', 'cccc', null, 'cccc', null, null, null, 'main.css', '10000', null, '0', '2015-10-14 15:29:59', null, null, null, '0', null, '0', '0', '0', '2', '0', null, null, null, null, null, '100000', '0', '0', '0', '0', '0', '1', '1', '0', null, '0', '0', '0', null, null);

-- ----------------------------
-- Table structure for `dlog_site_stat`
-- ----------------------------
DROP TABLE IF EXISTS `dlog_site_stat`;
CREATE TABLE `dlog_site_stat` (
  `site_stat_id` int(11) NOT NULL AUTO_INCREMENT,
  `site_id` int(11) DEFAULT NULL,
  `stat_date` int(11) NOT NULL,
  `uv_count` int(11) NOT NULL,
  `pv_count` int(11) NOT NULL,
  `v_source` int(11) NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`site_stat_id`),
  KEY `site_stat_id` (`site_stat_id`),
  KEY `FK_r_site_stat` (`site_id`),
  CONSTRAINT `FK_r_site_stat` FOREIGN KEY (`site_id`) REFERENCES `dlog_site` (`site_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dlog_site_stat
-- ----------------------------
INSERT INTO `dlog_site_stat` VALUES ('1', '2', '20151014', '1', '0', '1', '2015-10-14 12:44:07');
INSERT INTO `dlog_site_stat` VALUES ('2', '1', '20151014', '1', '0', '1', '2015-10-14 14:43:20');
INSERT INTO `dlog_site_stat` VALUES ('3', '3', '20151014', '1', '0', '1', '2015-10-14 15:29:59');
INSERT INTO `dlog_site_stat` VALUES ('4', '2', '20151015', '3', '0', '1', '2015-10-15 10:23:15');
INSERT INTO `dlog_site_stat` VALUES ('5', '3', '20151015', '1', '0', '1', '2015-10-15 15:31:30');
INSERT INTO `dlog_site_stat` VALUES ('6', '2', '20151016', '7', '0', '1', '2015-10-16 10:40:44');
INSERT INTO `dlog_site_stat` VALUES ('7', '3', '20151016', '1', '0', '1', '2015-10-16 11:33:33');
INSERT INTO `dlog_site_stat` VALUES ('8', '1', '20151016', '1', '0', '1', '2015-10-16 14:51:54');
INSERT INTO `dlog_site_stat` VALUES ('9', '1', '20151019', '1', '0', '1', '2015-10-19 14:42:21');
INSERT INTO `dlog_site_stat` VALUES ('10', '2', '20151022', '1', '0', '1', '2015-10-22 09:48:30');
INSERT INTO `dlog_site_stat` VALUES ('11', '1', '20151022', '1', '0', '1', '2015-10-22 09:54:30');
INSERT INTO `dlog_site_stat` VALUES ('12', '1', '20151026', '1', '0', '1', '2015-10-26 16:55:05');
INSERT INTO `dlog_site_stat` VALUES ('13', '2', '20151027', '1', '0', '1', '2015-10-27 11:25:11');
INSERT INTO `dlog_site_stat` VALUES ('14', '2', '20151027', '2', '0', '3', '2015-10-27 11:56:20');
INSERT INTO `dlog_site_stat` VALUES ('15', '2', '20151028', '1', '0', '1', '2015-10-28 11:24:41');
INSERT INTO `dlog_site_stat` VALUES ('16', '1', '20151028', '1', '0', '1', '2015-10-28 15:31:52');
INSERT INTO `dlog_site_stat` VALUES ('17', '1', '20151029', '1', '0', '1', '2015-10-29 09:20:15');
INSERT INTO `dlog_site_stat` VALUES ('18', '2', '20151029', '1', '0', '1', '2015-10-29 09:25:21');
INSERT INTO `dlog_site_stat` VALUES ('19', '3', '20151029', '1', '0', '1', '2015-10-29 16:18:43');
INSERT INTO `dlog_site_stat` VALUES ('20', '2', '20151030', '1', '0', '1', '2015-10-30 09:40:06');
INSERT INTO `dlog_site_stat` VALUES ('21', '1', '20151030', '1', '0', '1', '2015-10-30 09:40:14');
INSERT INTO `dlog_site_stat` VALUES ('22', '3', '20151030', '1', '0', '1', '2015-10-30 09:40:24');
INSERT INTO `dlog_site_stat` VALUES ('23', '1', '20151106', '1', '0', '1', '2015-11-06 19:22:00');
INSERT INTO `dlog_site_stat` VALUES ('24', '2', '20151106', '1', '0', '1', '2015-11-06 19:28:31');

-- ----------------------------
-- Table structure for `dlog_style`
-- ----------------------------
DROP TABLE IF EXISTS `dlog_style`;
CREATE TABLE `dlog_style` (
  `style_id` int(11) NOT NULL,
  `style_path_name` varchar(200) NOT NULL,
  `style_name` varchar(200) NOT NULL,
  `style_css` varchar(200) NOT NULL,
  `style_preview_l_image` varchar(200) NOT NULL,
  `style_preview_s_image` varchar(200) NOT NULL,
  `style_explain` varchar(1024) DEFAULT NULL,
  `style_status` int(11) NOT NULL,
  `style_type` int(11) NOT NULL,
  `style_level` int(11) NOT NULL,
  `style_count` int(11) NOT NULL,
  `style_create_time` datetime DEFAULT NULL,
  `style_extend1` int(11) DEFAULT NULL,
  `style_extend2` int(11) DEFAULT NULL,
  `style_extend3` varchar(1024) DEFAULT NULL,
  `style_extend4` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`style_id`),
  KEY `style_id` (`style_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dlog_style
-- ----------------------------

-- ----------------------------
-- Table structure for `dlog_t_reply`
-- ----------------------------
DROP TABLE IF EXISTS `dlog_t_reply`;
CREATE TABLE `dlog_t_reply` (
  `t_reply_id` int(11) NOT NULL AUTO_INCREMENT,
  `topic_id` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `site_id` int(11) NOT NULL,
  `title` varchar(200) NOT NULL,
  `content` text NOT NULL,
  `write_time` datetime DEFAULT NULL,
  `status` smallint(6) DEFAULT NULL,
  `client_ip` varchar(16) DEFAULT NULL,
  `client_type` smallint(6) DEFAULT NULL,
  `client_user_agent` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`t_reply_id`),
  KEY `t_reply_id` (`t_reply_id`),
  KEY `FK_r_site_t_reply` (`site_id`),
  KEY `FK_r_topic_reply` (`topic_id`),
  KEY `FK_r_user_t_reply` (`userid`),
  CONSTRAINT `FK_r_site_t_reply` FOREIGN KEY (`site_id`) REFERENCES `dlog_site` (`site_id`),
  CONSTRAINT `FK_r_topic_reply` FOREIGN KEY (`topic_id`) REFERENCES `dlog_topic` (`topic_id`),
  CONSTRAINT `FK_r_user_t_reply` FOREIGN KEY (`userid`) REFERENCES `dlog_user` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dlog_t_reply
-- ----------------------------

-- ----------------------------
-- Table structure for `dlog_tag`
-- ----------------------------
DROP TABLE IF EXISTS `dlog_tag`;
CREATE TABLE `dlog_tag` (
  `tag_id` int(11) NOT NULL AUTO_INCREMENT,
  `site_id` int(11) NOT NULL,
  `ref_id` int(11) NOT NULL,
  `ref_type` smallint(6) NOT NULL,
  `tag_name` varchar(20) NOT NULL,
  `ref_time` int(11) NOT NULL,
  PRIMARY KEY (`tag_id`),
  KEY `tag_id` (`tag_id`),
  KEY `FK_r_site_tag` (`site_id`),
  CONSTRAINT `FK_r_site_tag` FOREIGN KEY (`site_id`) REFERENCES `dlog_site` (`site_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dlog_tag
-- ----------------------------
INSERT INTO `dlog_tag` VALUES ('1', '2', '1', '1', '测试', '20151015');
INSERT INTO `dlog_tag` VALUES ('2', '2', '2', '1', '测试', '20151030');
INSERT INTO `dlog_tag` VALUES ('3', '2', '2', '1', '测试1', '20151030');
INSERT INTO `dlog_tag` VALUES ('4', '2', '3', '1', '测试', '20151030');
INSERT INTO `dlog_tag` VALUES ('5', '2', '3', '1', '测试1', '20151030');
INSERT INTO `dlog_tag` VALUES ('6', '2', '4', '1', '测试', '20151030');
INSERT INTO `dlog_tag` VALUES ('7', '2', '4', '1', '测试1', '20151030');
INSERT INTO `dlog_tag` VALUES ('8', '2', '4', '1', '测试', '20151030');
INSERT INTO `dlog_tag` VALUES ('9', '2', '4', '1', '测试1', '20151030');

-- ----------------------------
-- Table structure for `dlog_topic`
-- ----------------------------
DROP TABLE IF EXISTS `dlog_topic`;
CREATE TABLE `dlog_topic` (
  `topic_id` int(11) NOT NULL AUTO_INCREMENT,
  `site_id` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `forum_id` int(11) NOT NULL,
  `username` varchar(40) NOT NULL,
  `create_time` datetime NOT NULL,
  `modify_time` datetime DEFAULT NULL,
  `title` varchar(200) NOT NULL,
  `content` text NOT NULL,
  `tags` varchar(100) DEFAULT NULL,
  `last_reply_time` datetime DEFAULT NULL,
  `last_reply_id` int(11) DEFAULT NULL,
  `last_user_id` int(11) DEFAULT NULL,
  `last_user_name` varchar(50) DEFAULT NULL,
  `reply_count` int(11) NOT NULL,
  `view_count` int(11) NOT NULL,
  `locked` smallint(6) NOT NULL,
  `topic_type` int(11) NOT NULL,
  `status` smallint(6) NOT NULL,
  `client_type` smallint(6) NOT NULL,
  `client_ip` varchar(16) NOT NULL,
  `client_user_agent` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`topic_id`),
  KEY `topic_id` (`topic_id`),
  KEY `FK_r_forum_topic` (`forum_id`),
  KEY `FK_r_site_topic` (`site_id`),
  KEY `FK_r_user_topic` (`userid`),
  CONSTRAINT `FK_r_forum_topic` FOREIGN KEY (`forum_id`) REFERENCES `dlog_forum` (`forum_id`),
  CONSTRAINT `FK_r_site_topic` FOREIGN KEY (`site_id`) REFERENCES `dlog_site` (`site_id`),
  CONSTRAINT `FK_r_user_topic` FOREIGN KEY (`userid`) REFERENCES `dlog_user` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dlog_topic
-- ----------------------------

-- ----------------------------
-- Table structure for `dlog_trackback`
-- ----------------------------
DROP TABLE IF EXISTS `dlog_trackback`;
CREATE TABLE `dlog_trackback` (
  `track_id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) NOT NULL,
  `parent_type` smallint(6) NOT NULL,
  `refurl` varchar(100) NOT NULL,
  `title` varchar(200) DEFAULT NULL,
  `excerpt` varchar(200) DEFAULT NULL,
  `blog_name` varchar(50) NOT NULL,
  `remote_addr` char(15) NOT NULL,
  `track_time` datetime NOT NULL,
  PRIMARY KEY (`track_id`),
  KEY `track_id` (`track_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dlog_trackback
-- ----------------------------

-- ----------------------------
-- Table structure for `dlog_type`
-- ----------------------------
DROP TABLE IF EXISTS `dlog_type`;
CREATE TABLE `dlog_type` (
  `dlog_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `dlo_dlog_type_id` int(11) DEFAULT NULL,
  `type_name` varchar(20) NOT NULL,
  `sort_order` int(11) NOT NULL,
  PRIMARY KEY (`dlog_type_id`),
  KEY `dlog_type_id` (`dlog_type_id`),
  KEY `FK_r_site_type_tree` (`dlo_dlog_type_id`),
  CONSTRAINT `FK_r_site_type_tree` FOREIGN KEY (`dlo_dlog_type_id`) REFERENCES `dlog_type` (`dlog_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dlog_type
-- ----------------------------

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

-- ----------------------------
-- Table structure for `dlog_user_f_group`
-- ----------------------------
DROP TABLE IF EXISTS `dlog_user_f_group`;
CREATE TABLE `dlog_user_f_group` (
  `group_id` int(11) NOT NULL,
  `group_user_id` int(11) NOT NULL,
  `group_name` varchar(64) NOT NULL,
  `group_type` int(11) NOT NULL,
  `group_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`group_id`),
  KEY `group_id` (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dlog_user_f_group
-- ----------------------------
