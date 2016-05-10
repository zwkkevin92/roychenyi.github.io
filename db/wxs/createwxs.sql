/*
Navicat MySQL Data Transfer

Source Server         : 1
Source Server Version : 50619
Source Host           : localhost:3306
Source Database       : wxs

Target Server Type    : MYSQL
Target Server Version : 50619
File Encoding         : 65001

Date: 2016-01-19 13:26:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `b_access`
-- ----------------------------
DROP TABLE IF EXISTS `b_access`;
CREATE TABLE `b_access` (
  `baccess_id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '访问记录',
  `site_id` int(11) NOT NULL COMMENT '空间id',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `time` datetime DEFAULT NULL COMMENT '访问时间',
  `client_agent` varchar(250) DEFAULT NULL COMMENT '客户端UA',
  `client_ip` varchar(50) DEFAULT NULL COMMENT '用户ip',
  `client_type` smallint(6) DEFAULT NULL COMMENT '访问类型',
  PRIMARY KEY (`baccess_id`),
  KEY `baccess_id` (`baccess_id`),
  KEY `site_id` (`site_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `FK_b_access_site` FOREIGN KEY (`site_id`) REFERENCES `b_site` (`site_id`),
  CONSTRAINT `FK_b_access_user` FOREIGN KEY (`user_id`) REFERENCES `u_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of b_access
-- ----------------------------

-- ----------------------------
-- Table structure for `b_backlist`
-- ----------------------------
DROP TABLE IF EXISTS `b_backlist`;
CREATE TABLE `b_backlist` (
  `blacklist_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '黑名单id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `back_id` int(11) NOT NULL COMMENT '好友id',
  `bl_type` int(11) DEFAULT NULL COMMENT '黑名单类型',
  `add_time` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`blacklist_id`),
  KEY `blacklist_id` (`blacklist_id`),
  KEY `user_id` (`user_id`),
  KEY `back_id` (`back_id`),
  CONSTRAINT `FK_b_backlistt_user2` FOREIGN KEY (`back_id`) REFERENCES `u_user` (`user_id`),
  CONSTRAINT `FK_b_backlist_user1` FOREIGN KEY (`user_id`) REFERENCES `u_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of b_backlist
-- ----------------------------

-- ----------------------------
-- Table structure for `b_config`
-- ----------------------------
DROP TABLE IF EXISTS `b_config`;
CREATE TABLE `b_config` (
  `bconfig_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '配置id',
  `site_id` int(11) NOT NULL COMMENT '空间id',
  `config_key` varchar(20) DEFAULT NULL COMMENT '配置主键',
  `value` varchar(36) DEFAULT NULL COMMENT '配置参数',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_time` datetime DEFAULT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`bconfig_id`),
  KEY `bconfig_id` (`bconfig_id`),
  KEY `site_id` (`site_id`),
  CONSTRAINT `FK_b_config_site` FOREIGN KEY (`site_id`) REFERENCES `b_site` (`site_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of b_config
-- ----------------------------

-- ----------------------------
-- Table structure for `b_site`
-- ----------------------------
DROP TABLE IF EXISTS `b_site`;
CREATE TABLE `b_site` (
  `site_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '网站id',
  `user_id` int(11) NOT NULL COMMENT '用户编号',
  `name` varchar(20) NOT NULL COMMENT '名字',
  `title` varchar(10) NOT NULL COMMENT '标题(空间的url表示)',
  `site_url` varchar(100) NOT NULL COMMENT '域名',
  `site_detail` varchar(250) DEFAULT NULL COMMENT '说明',
  `logo` varchar(50) DEFAULT NULL COMMENT 'logo',
  `style_id` int(11) NOT NULL COMMENT '样式id',
  `flag` smallint(6) DEFAULT NULL COMMENT '空间标志',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_time` datetime DEFAULT NULL COMMENT '最后发帖时间',
  `mode` smallint(6) DEFAULT NULL COMMENT '权限模式',
  `access_code` varchar(50) DEFAULT NULL COMMENT '访问密码',
  `index_name` varchar(10) DEFAULT NULL COMMENT '个性化首页名',
  `diary_name` varchar(10) DEFAULT NULL COMMENT '个性化日记名',
  `sound_name` varchar(10) DEFAULT NULL COMMENT '个性化声音',
  `image_name` varchar(10) DEFAULT NULL COMMENT '个性相册名',
  `friend_name` varchar(10) DEFAULT NULL COMMENT '个性化好友名',
  `site_type` int(11) DEFAULT NULL COMMENT '空间类型',
  `status` smallint(6) DEFAULT NULL COMMENT '记录状态',
  PRIMARY KEY (`site_id`),
  KEY `site_id` (`site_id`),
  KEY `user_id` (`user_id`),
  KEY `name` (`name`),
  KEY `FK_u_site_style` (`style_id`),
  CONSTRAINT `FK_b_site_user` FOREIGN KEY (`user_id`) REFERENCES `u_user` (`user_id`),
  CONSTRAINT `FK_u_site_style` FOREIGN KEY (`style_id`) REFERENCES `sys_style` (`style_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of b_site
-- ----------------------------

-- ----------------------------
-- Table structure for `b_status`
-- ----------------------------
DROP TABLE IF EXISTS `b_status`;
CREATE TABLE `b_status` (
  `bstatus_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '状态id',
  `site_id` int(11) NOT NULL COMMENT '空间编号',
  `time` datetime NOT NULL COMMENT '统计时间',
  `uv_count` int(11) DEFAULT NULL COMMENT '用户数',
  `pv_count` int(11) DEFAULT NULL COMMENT '点击数',
  `type` smallint(6) DEFAULT NULL COMMENT '访问类型',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`bstatus_id`),
  KEY `bstatus_id` (`bstatus_id`),
  KEY `site_id` (`site_id`),
  CONSTRAINT `FK_b_status_site` FOREIGN KEY (`site_id`) REFERENCES `b_site` (`site_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of b_status
-- ----------------------------

-- ----------------------------
-- Table structure for `b_tag`
-- ----------------------------
DROP TABLE IF EXISTS `b_tag`;
CREATE TABLE `b_tag` (
  `tag_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '标签id',
  `site_id` int(11) NOT NULL COMMENT '空间标示',
  `ref_id` int(11) NOT NULL COMMENT '应用id',
  `ref_type` smallint(6) DEFAULT NULL COMMENT '应用类型',
  `time` datetime DEFAULT NULL COMMENT '时间',
  `tag_name` varchar(20) DEFAULT NULL COMMENT '标签名',
  PRIMARY KEY (`tag_id`),
  KEY `tag_id` (`tag_id`),
  KEY `site_id` (`site_id`),
  KEY `FK_b_tag_diary` (`ref_id`),
  CONSTRAINT `FK_b_tag_diary` FOREIGN KEY (`ref_id`) REFERENCES `d_diary` (`diary_id`),
  CONSTRAINT `FK_b_tag_site` FOREIGN KEY (`site_id`) REFERENCES `b_site` (`site_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of b_tag
-- ----------------------------

-- ----------------------------
-- Table structure for `d_access`
-- ----------------------------
DROP TABLE IF EXISTS `d_access`;
CREATE TABLE `d_access` (
  `daccess_id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '记录id',
  `diary_id` int(11) NOT NULL COMMENT '日记id',
  `user_id` int(11) NOT NULL COMMENT '浏览人id',
  `client_agent` varchar(250) DEFAULT NULL COMMENT '客户端UA',
  `client_ip` varchar(50) DEFAULT NULL COMMENT '客户端ip',
  `client_type` smallint(6) DEFAULT NULL COMMENT '客户端类型',
  `time` datetime DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`daccess_id`),
  KEY `daccess_id` (`daccess_id`),
  KEY `diary_id` (`diary_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `FK_d_access_diary` FOREIGN KEY (`diary_id`) REFERENCES `d_diary` (`diary_id`),
  CONSTRAINT `FK_d_access_user` FOREIGN KEY (`user_id`) REFERENCES `u_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of d_access
-- ----------------------------

-- ----------------------------
-- Table structure for `d_annex`
-- ----------------------------
DROP TABLE IF EXISTS `d_annex`;
CREATE TABLE `d_annex` (
  `annex_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '附件id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `site_id` int(11) NOT NULL COMMENT '空间id',
  `diary_id` int(11) NOT NULL COMMENT '日记id',
  `upload_time` datetime DEFAULT NULL COMMENT '上传时间',
  `download_count` int(11) DEFAULT NULL COMMENT '下次次数',
  `status` smallint(6) DEFAULT NULL COMMENT '状态',
  `validate` smallint(6) DEFAULT NULL COMMENT '附件验证',
  `url` varchar(256) DEFAULT NULL COMMENT 'URL地址',
  `path` varchar(256) DEFAULT NULL COMMENT '附近的路径',
  `file_name` varchar(256) DEFAULT NULL COMMENT '文件类型',
  `file_description` varchar(1024) DEFAULT NULL COMMENT '文件介绍',
  `size` int(11) DEFAULT NULL COMMENT '文件大小',
  `last_time` datetime DEFAULT NULL COMMENT '最后更新时间',
  `ext1` int(11) DEFAULT NULL,
  `ext2` int(11) DEFAULT NULL,
  `ext3` varchar(1024) DEFAULT NULL,
  `ext4` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`annex_id`),
  KEY `annex_id` (`annex_id`),
  KEY `site_id` (`site_id`),
  KEY `user_id` (`user_id`),
  KEY `diary_id` (`diary_id`),
  CONSTRAINT `FK_d_annex_diary` FOREIGN KEY (`diary_id`) REFERENCES `d_diary` (`diary_id`),
  CONSTRAINT `FK_d_annex_site` FOREIGN KEY (`site_id`) REFERENCES `b_site` (`site_id`),
  CONSTRAINT `FK_d_annex_user` FOREIGN KEY (`user_id`) REFERENCES `u_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of d_annex
-- ----------------------------

-- ----------------------------
-- Table structure for `d_catalog`
-- ----------------------------
DROP TABLE IF EXISTS `d_catalog`;
CREATE TABLE `d_catalog` (
  `catalog_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '日记分类id',
  `site_id` int(11) NOT NULL COMMENT '空间id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `catalog_name` varchar(20) NOT NULL COMMENT '分类名',
  `description` varchar(200) DEFAULT NULL COMMENT '说明',
  `create_time` datetime DEFAULT NULL COMMENT '创立时间',
  `article_count` int(11) DEFAULT NULL,
  `catalog_type` int(11) DEFAULT NULL COMMENT '类型',
  `verifyCode` varchar(20) DEFAULT NULL COMMENT '访问密码',
  `sort_order` smallint(6) DEFAULT NULL COMMENT '排列顺序',
  `ext1` int(11) DEFAULT NULL COMMENT '扩展1',
  `ext2` int(11) DEFAULT NULL,
  `ext3` varchar(1024) DEFAULT NULL,
  `ext4` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`catalog_id`),
  KEY `catalog_id` (`catalog_id`),
  KEY `site_id` (`site_id`),
  KEY `FK_d_catalog_user` (`user_id`),
  CONSTRAINT `FK_d_catalog_site` FOREIGN KEY (`site_id`) REFERENCES `b_site` (`site_id`),
  CONSTRAINT `FK_d_catalog_user` FOREIGN KEY (`user_id`) REFERENCES `u_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of d_catalog
-- ----------------------------

-- ----------------------------
-- Table structure for `d_diary`
-- ----------------------------
DROP TABLE IF EXISTS `d_diary`;
CREATE TABLE `d_diary` (
  `diary_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '日记id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `site_id` int(11) NOT NULL COMMENT '空间id',
  `catalog_id` int(11) NOT NULL COMMENT '空间分类id',
  `title` varchar(50) NOT NULL COMMENT '标题',
  `content` text NOT NULL COMMENT '内容',
  `drary_size` int(11) DEFAULT NULL COMMENT '内容字数',
  `reply_count` int(11) DEFAULT NULL COMMENT '回复数',
  `view_count` int(11) DEFAULT NULL COMMENT '浏览数',
  `client_type` smallint(6) DEFAULT NULL COMMENT '客户端类型',
  `client_ip` varchar(50) DEFAULT NULL COMMENT '客户端ip',
  `client_agent` varchar(250) DEFAULT NULL COMMENT '客户端UA',
  `write_time` datetime DEFAULT NULL COMMENT '发表时间',
  `last_read_time` datetime DEFAULT NULL COMMENT '最后阅读时间',
  `last_reply_time` datetime DEFAULT NULL COMMENT '最后回复时间',
  `modify_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `reply_notify` smallint(6) DEFAULT NULL COMMENT '是否回帖提醒',
  `mood_level` smallint(6) DEFAULT NULL COMMENT '心情指数',
  `locked` smallint(6) DEFAULT NULL COMMENT '是否锁定',
  `contribute` smallint(6) DEFAULT NULL COMMENT '是否投稿',
  `role` smallint(6) DEFAULT NULL COMMENT '权限',
  `tag` varchar(100) DEFAULT NULL COMMENT '标签',
  `annex_id` int(11) DEFAULT NULL COMMENT '附件id',
  `ext1` int(11) DEFAULT NULL COMMENT '扩展1',
  `ext2` int(11) DEFAULT NULL COMMENT '扩展2',
  `ext3` int(11) DEFAULT NULL COMMENT '扩展3',
  `ext4` int(11) DEFAULT NULL COMMENT '扩展4',
  PRIMARY KEY (`diary_id`),
  KEY `diary_id` (`diary_id`),
  KEY `site_id` (`site_id`),
  KEY `user_id` (`user_id`),
  KEY `FK_d_diary_catalog` (`catalog_id`),
  CONSTRAINT `FK_d_diary_catalog` FOREIGN KEY (`catalog_id`) REFERENCES `d_catalog` (`catalog_id`),
  CONSTRAINT `FK_d_diary_site` FOREIGN KEY (`site_id`) REFERENCES `b_site` (`site_id`),
  CONSTRAINT `FK_d_diary_user` FOREIGN KEY (`user_id`) REFERENCES `u_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of d_diary
-- ----------------------------

-- ----------------------------
-- Table structure for `d_reply1`
-- ----------------------------
DROP TABLE IF EXISTS `d_reply1`;
CREATE TABLE `d_reply1` (
  `dreply_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评论id',
  `diary_id` int(11) NOT NULL COMMENT '日记id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `client_type` smallint(6) DEFAULT NULL COMMENT '客户端类型',
  `owner_only` smallint(6) DEFAULT NULL COMMENT '是否允许所有人查看',
  `write_time` datetime DEFAULT NULL COMMENT '发表时间',
  `status` smallint(6) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`dreply_id`),
  KEY `dreply_id` (`dreply_id`),
  KEY `diary_id` (`diary_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `FK_d_reply1_diary` FOREIGN KEY (`diary_id`) REFERENCES `d_diary` (`diary_id`),
  CONSTRAINT `FK_d_reply1_user` FOREIGN KEY (`user_id`) REFERENCES `u_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of d_reply1
-- ----------------------------

-- ----------------------------
-- Table structure for `d_reply2`
-- ----------------------------
DROP TABLE IF EXISTS `d_reply2`;
CREATE TABLE `d_reply2` (
  `dreply1_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评论1id',
  `dreply_id` int(11) NOT NULL COMMENT '评论id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `commentator` int(11) NOT NULL COMMENT '被评论人',
  `content` text NOT NULL COMMENT '内容',
  `client_angent` varchar(250) DEFAULT NULL COMMENT '客户端UA',
  `client_ip` varchar(50) DEFAULT NULL COMMENT '客户端ip',
  `client_type` smallint(6) DEFAULT NULL COMMENT '客户端类型',
  `reply_time` datetime DEFAULT NULL COMMENT '发表时间',
  `reply_id` int(11) DEFAULT NULL COMMENT '引用id',
  `sort_order` smallint(6) DEFAULT NULL COMMENT '排列序号',
  `ext1` int(11) DEFAULT NULL COMMENT '扩展1',
  `ext2` int(11) DEFAULT NULL COMMENT '扩展2',
  `ext3` varchar(1024) DEFAULT NULL COMMENT '扩展3',
  `ext4` varchar(1024) DEFAULT NULL COMMENT '扩展4',
  PRIMARY KEY (`dreply1_id`),
  KEY `dreply1_id` (`dreply1_id`),
  KEY `dreply_id` (`dreply_id`),
  KEY `user_id` (`user_id`),
  KEY `FK_d_reply2_user1` (`commentator`),
  CONSTRAINT `FK_d_reply2_reply1` FOREIGN KEY (`dreply_id`) REFERENCES `d_reply1` (`dreply_id`),
  CONSTRAINT `FK_d_reply2_user` FOREIGN KEY (`user_id`) REFERENCES `u_user` (`user_id`),
  CONSTRAINT `FK_d_reply2_user1` FOREIGN KEY (`commentator`) REFERENCES `u_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of d_reply2
-- ----------------------------

-- ----------------------------
-- Table structure for `d_upvote`
-- ----------------------------
DROP TABLE IF EXISTS `d_upvote`;
CREATE TABLE `d_upvote` (
  `dupvote_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '点赞id',
  `diary_id` int(11) NOT NULL COMMENT '日记id',
  `user_id` int(11) NOT NULL COMMENT '点赞人id',
  `client_agent` varchar(250) DEFAULT NULL COMMENT '客户端UA',
  `client_ip` varchar(50) DEFAULT NULL COMMENT '客户端ip',
  `client_type` smallint(6) DEFAULT NULL COMMENT '客户端类型（手机、pc）',
  `time` datetime DEFAULT NULL COMMENT '时间',
  `status` smallint(6) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`dupvote_id`),
  KEY `dupvote_id` (`dupvote_id`),
  KEY `diary_id` (`diary_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `FK_d_upvote_diary` FOREIGN KEY (`diary_id`) REFERENCES `d_diary` (`diary_id`),
  CONSTRAINT `FK_d_upvote_user` FOREIGN KEY (`user_id`) REFERENCES `u_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of d_upvote
-- ----------------------------

-- ----------------------------
-- Table structure for `i_access`
-- ----------------------------
DROP TABLE IF EXISTS `i_access`;
CREATE TABLE `i_access` (
  `iaccess_id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '记录id',
  `image_id` int(11) NOT NULL COMMENT '图片id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `client_agent` varchar(250) DEFAULT NULL COMMENT '客户端UA',
  `client_ip` varchar(50) DEFAULT NULL COMMENT '客户端ip',
  `client_type` smallint(6) DEFAULT NULL COMMENT '客户端类型',
  `time` datetime DEFAULT NULL COMMENT '访问时间',
  PRIMARY KEY (`iaccess_id`),
  KEY `iaccess_id` (`iaccess_id`),
  KEY `image_id` (`image_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `FK_i_access_sound` FOREIGN KEY (`image_id`) REFERENCES `i_image` (`image_id`),
  CONSTRAINT `FK_i_access_user` FOREIGN KEY (`user_id`) REFERENCES `u_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of i_access
-- ----------------------------

-- ----------------------------
-- Table structure for `i_album`
-- ----------------------------
DROP TABLE IF EXISTS `i_album`;
CREATE TABLE `i_album` (
  `album_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '相册id',
  `site_id` int(11) NOT NULL COMMENT '空间id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `name` varchar(20) DEFAULT NULL COMMENT '相册名称',
  `description` text COMMENT '描述',
  `ablum_type` int(11) DEFAULT NULL COMMENT '相册类型',
  `ablum_count` int(11) DEFAULT NULL COMMENT '图片数',
  `access_question` varchar(200) DEFAULT NULL COMMENT '访问密码',
  `verifycode` varchar(50) DEFAULT NULL COMMENT '访问密码',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `sort_order` smallint(6) DEFAULT NULL COMMENT '排列顺序',
  `ext1` int(11) DEFAULT NULL,
  `ext2` int(11) DEFAULT NULL,
  `ext3` varchar(1024) DEFAULT NULL,
  `ext4` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`album_id`),
  KEY `album_id` (`album_id`),
  KEY `site_id` (`site_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `FK_i_album_site` FOREIGN KEY (`site_id`) REFERENCES `b_site` (`site_id`),
  CONSTRAINT `FK_i_album_user` FOREIGN KEY (`user_id`) REFERENCES `u_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of i_album
-- ----------------------------

-- ----------------------------
-- Table structure for `i_image`
-- ----------------------------
DROP TABLE IF EXISTS `i_image`;
CREATE TABLE `i_image` (
  `image_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '声音id',
  `album_id` int(11) NOT NULL COMMENT '相册id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `site_id` int(11) NOT NULL COMMENT '网站id',
  `name` varchar(20) DEFAULT NULL COMMENT '原图名字',
  `content` varchar(1024) DEFAULT NULL COMMENT '介绍',
  `file_name` varchar(100) DEFAULT NULL COMMENT '图片名字',
  `file_path` varchar(256) DEFAULT NULL COMMENT '文件路径',
  `url` varchar(256) DEFAULT NULL COMMENT '下载URL',
  `preview_url` varchar(256) DEFAULT NULL COMMENT '浏览图url',
  `tag` varchar(100) DEFAULT NULL COMMENT '标签',
  `time` datetime DEFAULT NULL COMMENT '上传时间',
  `year` smallint(6) DEFAULT NULL COMMENT '年份',
  `mount` smallint(6) DEFAULT NULL COMMENT '上传月份',
  `day` smallint(6) DEFAULT NULL COMMENT '上传日',
  `width` smallint(6) DEFAULT NULL COMMENT '宽度',
  `height` smallint(6) DEFAULT NULL COMMENT '高度',
  `image_type` int(11) DEFAULT NULL COMMENT '图片类型',
  `client_type` smallint(6) DEFAULT NULL COMMENT '客户端类型',
  `client_ip` varchar(50) DEFAULT NULL COMMENT '客户端ip',
  `client_agent` varchar(250) DEFAULT NULL COMMENT '客户端UA',
  `status` smallint(6) DEFAULT NULL COMMENT '状态',
  `reply_count` int(11) DEFAULT NULL COMMENT '评论次数',
  `view_count` int(11) DEFAULT NULL COMMENT '浏览次数',
  `download_count` int(11) DEFAULT NULL COMMENT '下载次数',
  `ext1` int(11) DEFAULT NULL,
  `ext2` int(11) DEFAULT NULL,
  `ext3` varchar(1024) DEFAULT NULL,
  `ext4` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`image_id`),
  KEY `image_id` (`image_id`),
  KEY `album_id` (`album_id`),
  KEY `user_id` (`user_id`),
  KEY `site_id` (`site_id`),
  CONSTRAINT `FK_i_image_album` FOREIGN KEY (`album_id`) REFERENCES `i_album` (`album_id`),
  CONSTRAINT `FK_i_image_site` FOREIGN KEY (`site_id`) REFERENCES `b_site` (`site_id`),
  CONSTRAINT `FK_i_image_user` FOREIGN KEY (`user_id`) REFERENCES `u_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of i_image
-- ----------------------------

-- ----------------------------
-- Table structure for `i_reply1`
-- ----------------------------
DROP TABLE IF EXISTS `i_reply1`;
CREATE TABLE `i_reply1` (
  `ireply_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评论id',
  `image_id` int(11) NOT NULL COMMENT '图片id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `client_type` smallint(6) DEFAULT NULL COMMENT '客户端类型',
  `owner_only` smallint(6) DEFAULT NULL COMMENT '是否允许所有人查看0-允许，1不允许',
  `write_time` datetime DEFAULT NULL COMMENT '发布时间',
  `status` smallint(6) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`ireply_id`),
  KEY `ireply_id` (`ireply_id`),
  KEY `image_id` (`image_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `FK_i_reply1_image` FOREIGN KEY (`image_id`) REFERENCES `i_image` (`image_id`),
  CONSTRAINT `FK_i_reply1_user` FOREIGN KEY (`user_id`) REFERENCES `u_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of i_reply1
-- ----------------------------

-- ----------------------------
-- Table structure for `i_reply2`
-- ----------------------------
DROP TABLE IF EXISTS `i_reply2`;
CREATE TABLE `i_reply2` (
  `ireply1_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评论1-id',
  `ireply_id` int(11) NOT NULL COMMENT '评论编号',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `commentator` int(11) NOT NULL COMMENT '被评论人id',
  `content` text NOT NULL COMMENT '评论内容',
  `client_angent` varchar(250) DEFAULT NULL COMMENT '客户端UA',
  `client_ip` varchar(50) DEFAULT NULL COMMENT '客户端ip',
  `client_type` smallint(6) DEFAULT NULL COMMENT '客户端类型',
  `reply_time` datetime DEFAULT NULL COMMENT '发布时间',
  `reply_id` datetime DEFAULT NULL,
  `sort_order` smallint(6) DEFAULT NULL COMMENT '排列顺序',
  `ext1` int(11) DEFAULT NULL,
  `ext2` int(11) DEFAULT NULL,
  `ext3` varchar(1024) DEFAULT NULL,
  `ext4` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`ireply1_id`),
  KEY `ireply1_id` (`ireply1_id`),
  KEY `ireply_id` (`ireply_id`),
  KEY `user_id` (`user_id`),
  KEY `FK_i_reply2_user1` (`commentator`),
  CONSTRAINT `FK_i_reply2_ireply1` FOREIGN KEY (`ireply_id`) REFERENCES `i_reply1` (`ireply_id`),
  CONSTRAINT `FK_i_reply2_user` FOREIGN KEY (`user_id`) REFERENCES `u_user` (`user_id`),
  CONSTRAINT `FK_i_reply2_user1` FOREIGN KEY (`commentator`) REFERENCES `u_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of i_reply2
-- ----------------------------

-- ----------------------------
-- Table structure for `i_upvote`
-- ----------------------------
DROP TABLE IF EXISTS `i_upvote`;
CREATE TABLE `i_upvote` (
  `iupvote_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '点赞id',
  `image_id` int(11) NOT NULL COMMENT '图片id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `client_agent` varchar(250) DEFAULT NULL COMMENT '客户端UA',
  `client_ip` varchar(50) DEFAULT NULL COMMENT '客户端ip',
  `client_type` smallint(6) DEFAULT NULL COMMENT '客户端类型',
  `time` datetime DEFAULT NULL COMMENT '点赞时间',
  `status` smallint(6) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`iupvote_id`),
  KEY `iupvote_id` (`iupvote_id`),
  KEY `image_id` (`image_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `FK_i_upvote_image` FOREIGN KEY (`image_id`) REFERENCES `i_image` (`image_id`),
  CONSTRAINT `FK_i_upvote_user` FOREIGN KEY (`user_id`) REFERENCES `u_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of i_upvote
-- ----------------------------

-- ----------------------------
-- Table structure for `m_affiche`
-- ----------------------------
DROP TABLE IF EXISTS `m_affiche`;
CREATE TABLE `m_affiche` (
  `affiche_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '广告id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `title` varchar(20) DEFAULT NULL COMMENT '标题id',
  `content` varchar(1024) DEFAULT NULL COMMENT '内容id',
  `send_time` datetime DEFAULT NULL COMMENT '发送时间',
  `expire_time` datetime DEFAULT NULL COMMENT '有效时间',
  `status` smallint(6) DEFAULT NULL COMMENT '状态id',
  PRIMARY KEY (`affiche_id`),
  KEY `affiche_id` (`affiche_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `FK_m_affiche_user` FOREIGN KEY (`user_id`) REFERENCES `u_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of m_affiche
-- ----------------------------

-- ----------------------------
-- Table structure for `m_guestbook`
-- ----------------------------
DROP TABLE IF EXISTS `m_guestbook`;
CREATE TABLE `m_guestbook` (
  `guestbook_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录id',
  `site_id` int(11) NOT NULL COMMENT '空间id',
  `user_id` int(11) NOT NULL COMMENT '用户id（被访问人)',
  `visitor_id` int(11) NOT NULL COMMENT '访客id',
  `content` varchar(1024) NOT NULL COMMENT '内容',
  `client_type` smallint(6) DEFAULT NULL COMMENT '客户端类型',
  `client_ip` varchar(50) DEFAULT NULL COMMENT '客户端ip',
  `client_agent` varchar(250) DEFAULT NULL COMMENT '客户端UA',
  `time` datetime DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`guestbook_id`),
  KEY `guestbook_id` (`guestbook_id`),
  KEY `site_id` (`site_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `FK_m_guestbook_site` FOREIGN KEY (`site_id`) REFERENCES `b_site` (`site_id`),
  CONSTRAINT `FK_m_guestbook_user` FOREIGN KEY (`user_id`) REFERENCES `u_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of m_guestbook
-- ----------------------------

-- ----------------------------
-- Table structure for `m_message`
-- ----------------------------
DROP TABLE IF EXISTS `m_message`;
CREATE TABLE `m_message` (
  `message_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '信息id',
  `user_id` int(11) NOT NULL COMMENT '写信息人id',
  `receive_id` int(11) NOT NULL COMMENT '接收人id',
  `content` varchar(1024) DEFAULT NULL COMMENT '内容',
  `send_time` datetime DEFAULT NULL COMMENT '发送时间',
  `expire_time` datetime DEFAULT NULL COMMENT '有效时间期限',
  `read_time` datetime DEFAULT NULL COMMENT '阅读时间',
  `status` smallint(6) DEFAULT NULL COMMENT '状态',
  `client_type` smallint(6) DEFAULT NULL COMMENT '客户端类型',
  `client_ip` varchar(50) DEFAULT NULL COMMENT '客户端ip',
  `client_agent` varchar(250) DEFAULT NULL COMMENT '客户端UA',
  PRIMARY KEY (`message_id`),
  KEY `message_id` (`message_id`),
  KEY `user_id` (`user_id`),
  KEY `receive_id` (`receive_id`),
  CONSTRAINT `FK_m_message_user1` FOREIGN KEY (`user_id`) REFERENCES `u_user` (`user_id`),
  CONSTRAINT `FK_m_message_user2` FOREIGN KEY (`receive_id`) REFERENCES `u_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of m_message
-- ----------------------------

-- ----------------------------
-- Table structure for `m_reply`
-- ----------------------------
DROP TABLE IF EXISTS `m_reply`;
CREATE TABLE `m_reply` (
  `mreply_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '留言回复id',
  `guestbook_id` int(11) NOT NULL COMMENT '留言id',
  `user_id` int(11) NOT NULL COMMENT '评论人id',
  `content` varchar(1024) DEFAULT NULL COMMENT '评论内容',
  `time` datetime DEFAULT NULL COMMENT '时间',
  `reply_id` int(11) DEFAULT NULL COMMENT '引用id',
  `client_type` smallint(6) DEFAULT NULL COMMENT '客户端类型',
  `client_ip` varchar(50) DEFAULT NULL COMMENT '客户端ip',
  `client_agent` varchar(250) DEFAULT NULL COMMENT '客户端UA',
  PRIMARY KEY (`mreply_id`),
  KEY `mreply_id` (`mreply_id`),
  KEY `guestbook_id` (`guestbook_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `FK_m_reply_guestbook` FOREIGN KEY (`guestbook_id`) REFERENCES `m_guestbook` (`guestbook_id`),
  CONSTRAINT `FK_m_reply_user` FOREIGN KEY (`user_id`) REFERENCES `u_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of m_reply
-- ----------------------------

-- ----------------------------
-- Table structure for `s_access`
-- ----------------------------
DROP TABLE IF EXISTS `s_access`;
CREATE TABLE `s_access` (
  `saccess_id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '记录id',
  `sound_id` int(11) NOT NULL COMMENT '声音id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `client_agent` varchar(250) DEFAULT NULL COMMENT '客户端UA',
  `client_ip` varchar(50) DEFAULT NULL COMMENT '客户端ip',
  `client_type` smallint(6) DEFAULT NULL COMMENT '客户端类型',
  `time` datetime DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`saccess_id`),
  KEY `saccess_id` (`saccess_id`),
  KEY `sound_id` (`sound_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `FK_s_access_sound` FOREIGN KEY (`sound_id`) REFERENCES `s_sound` (`sound_id`),
  CONSTRAINT `FK_s_access_user` FOREIGN KEY (`user_id`) REFERENCES `u_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_access
-- ----------------------------

-- ----------------------------
-- Table structure for `s_box`
-- ----------------------------
DROP TABLE IF EXISTS `s_box`;
CREATE TABLE `s_box` (
  `box_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '盒子id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `name` varchar(20) DEFAULT NULL COMMENT '名字',
  `description` text COMMENT '说明',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `sound_count` int(11) DEFAULT NULL COMMENT '数量',
  `sort_order` smallint(6) DEFAULT NULL COMMENT '排列顺序',
  `ext1` int(11) DEFAULT NULL,
  `ext2` int(11) DEFAULT NULL,
  `ext3` varchar(1024) DEFAULT NULL,
  `ext4` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`box_id`),
  KEY `box_id` (`box_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `FK_s_box_user` FOREIGN KEY (`user_id`) REFERENCES `u_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_box
-- ----------------------------

-- ----------------------------
-- Table structure for `s_reply1`
-- ----------------------------
DROP TABLE IF EXISTS `s_reply1`;
CREATE TABLE `s_reply1` (
  `sreply_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评论id',
  `sound_id` int(11) NOT NULL COMMENT '声音id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `client_type` smallint(6) DEFAULT NULL COMMENT '客户端类型',
  `owner_only` smallint(6) DEFAULT NULL COMMENT '是否值允许所有人查看（0-允许，1-不允许）',
  `write_time` datetime DEFAULT NULL COMMENT '评论时间',
  `status` smallint(6) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`sreply_id`),
  KEY `sreply_id` (`sreply_id`),
  KEY `sound_id` (`sound_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `FK_s_reply1_sound` FOREIGN KEY (`sound_id`) REFERENCES `s_sound` (`sound_id`),
  CONSTRAINT `FK_s_reply1_user` FOREIGN KEY (`user_id`) REFERENCES `u_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_reply1
-- ----------------------------

-- ----------------------------
-- Table structure for `s_reply2`
-- ----------------------------
DROP TABLE IF EXISTS `s_reply2`;
CREATE TABLE `s_reply2` (
  `sreply1_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评论1-id',
  `sreply_id` int(11) NOT NULL COMMENT '评论id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `commentator` int(11) NOT NULL COMMENT '被评论人id（被引用人）',
  `content` text NOT NULL COMMENT '内容',
  `client_angent` varchar(250) DEFAULT NULL COMMENT '客户端UA',
  `client_ip` varchar(50) DEFAULT NULL COMMENT '客户端ip',
  `client_type` smallint(6) DEFAULT NULL COMMENT '客户端类型',
  `reply_time` datetime DEFAULT NULL COMMENT '发布时间',
  `reply_id` datetime DEFAULT NULL COMMENT '引用id',
  `sort_order` smallint(6) DEFAULT NULL COMMENT '排列顺序',
  `ext1` int(11) DEFAULT NULL,
  `ext2` int(11) DEFAULT NULL,
  `ext3` varchar(1024) DEFAULT NULL,
  `ext4` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`sreply1_id`),
  KEY `sreply1_id` (`sreply1_id`),
  KEY `sreply_id` (`sreply_id`),
  KEY `user_id` (`user_id`),
  KEY `FK_s_reply2_user1` (`commentator`),
  CONSTRAINT `FK_s_reply2_sreply1` FOREIGN KEY (`sreply_id`) REFERENCES `s_reply1` (`sreply_id`),
  CONSTRAINT `FK_s_reply2_user` FOREIGN KEY (`user_id`) REFERENCES `u_user` (`user_id`),
  CONSTRAINT `FK_s_reply2_user1` FOREIGN KEY (`commentator`) REFERENCES `u_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_reply2
-- ----------------------------

-- ----------------------------
-- Table structure for `s_sound`
-- ----------------------------
DROP TABLE IF EXISTS `s_sound`;
CREATE TABLE `s_sound` (
  `sound_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '声音id',
  `box_id` int(11) NOT NULL COMMENT '声音盒子id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `title` varchar(20) DEFAULT NULL COMMENT '标题',
  `content` varchar(1024) DEFAULT NULL COMMENT '内容',
  `url` varchar(256) DEFAULT NULL COMMENT '声音url',
  `file_name` varchar(100) DEFAULT NULL COMMENT '文件名字',
  `file_path` varchar(200) DEFAULT NULL COMMENT '文件路径',
  `time` datetime DEFAULT NULL COMMENT '时间',
  `status` smallint(6) DEFAULT NULL COMMENT '状态',
  `view_count` int(11) DEFAULT NULL COMMENT '试听次数',
  `download_count` int(11) DEFAULT NULL COMMENT '下载次数',
  `ext1` int(11) DEFAULT NULL,
  `ext2` int(11) DEFAULT NULL,
  `ext3` varchar(1024) DEFAULT NULL,
  `ext4` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`sound_id`),
  KEY `sound_id` (`sound_id`),
  KEY `box_id` (`box_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `FK_s_sound_box` FOREIGN KEY (`box_id`) REFERENCES `s_box` (`box_id`),
  CONSTRAINT `FK_s_sound_user` FOREIGN KEY (`user_id`) REFERENCES `u_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_sound
-- ----------------------------

-- ----------------------------
-- Table structure for `s_upvote`
-- ----------------------------
DROP TABLE IF EXISTS `s_upvote`;
CREATE TABLE `s_upvote` (
  `supvote_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '点赞id',
  `sound_id` int(11) NOT NULL COMMENT '声音id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `client_agent` varchar(250) DEFAULT NULL COMMENT '客户端UA',
  `client_ip` varchar(50) DEFAULT NULL COMMENT '客户端ip',
  `client_type` smallint(6) DEFAULT NULL COMMENT '客户端类型',
  `time` datetime DEFAULT NULL COMMENT '发布时间',
  `status` smallint(6) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`supvote_id`),
  KEY `supvote_id` (`supvote_id`),
  KEY `sound_id` (`sound_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `FK_s_upvote_sound` FOREIGN KEY (`sound_id`) REFERENCES `s_sound` (`sound_id`),
  CONSTRAINT `FK_s_upvote_user` FOREIGN KEY (`user_id`) REFERENCES `u_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_upvote
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_blocked_ip`
-- ----------------------------
DROP TABLE IF EXISTS `sys_blocked_ip`;
CREATE TABLE `sys_blocked_ip` (
  `blockedip_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录id',
  `ip` varchar(50) DEFAULT NULL COMMENT 'ip地址',
  `ipmask` varchar(50) DEFAULT NULL COMMENT 'ip掩码',
  `blocked_type` int(11) DEFAULT NULL COMMENT '阻止方式',
  `time` datetime DEFAULT NULL COMMENT '时间',
  `status` smallint(6) DEFAULT NULL COMMENT '状态',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`blockedip_id`),
  KEY `blockedip_id` (`blockedip_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_blocked_ip
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_city`
-- ----------------------------
DROP TABLE IF EXISTS `sys_city`;
CREATE TABLE `sys_city` (
  `city_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '城市id',
  `province_id` int(11) NOT NULL COMMENT '省id',
  `name` varchar(20) NOT NULL COMMENT '名称',
  `description` text COMMENT '介绍',
  PRIMARY KEY (`city_id`),
  KEY `city_id` (`city_id`),
  KEY `province_id` (`province_id`),
  CONSTRAINT `FK_sys_city_province` FOREIGN KEY (`province_id`) REFERENCES `sys_province` (`province_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_city
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_college`
-- ----------------------------
DROP TABLE IF EXISTS `sys_college`;
CREATE TABLE `sys_college` (
  `college_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学院id',
  `school_id` int(11) DEFAULT NULL COMMENT '学院id',
  `name` varchar(20) DEFAULT NULL COMMENT '名称',
  `description` text COMMENT '介绍',
  PRIMARY KEY (`college_id`),
  KEY `college_id` (`college_id`),
  KEY `school_id` (`school_id`),
  CONSTRAINT `FK_sys_college_school` FOREIGN KEY (`school_id`) REFERENCES `sys_school` (`school_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_college
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_config`
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config` (
  `config_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '配置id',
  `config_name` varchar(20) DEFAULT NULL COMMENT '配置key',
  `value` varchar(36) DEFAULT NULL COMMENT '配置参数',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_time` datetime DEFAULT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`config_id`),
  KEY `config_id` (`config_id`),
  KEY `config_name` (`config_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_config
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_invitation_code`
-- ----------------------------
DROP TABLE IF EXISTS `sys_invitation_code`;
CREATE TABLE `sys_invitation_code` (
  `code_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '邀请码id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `wxs_id` int(11) NOT NULL COMMENT '文学社id',
  `code` varchar(16) DEFAULT NULL COMMENT '邀请码',
  `reg_time` datetime DEFAULT NULL COMMENT '注册时间',
  `client_agent` varchar(250) DEFAULT NULL COMMENT '客户端UA',
  `client_ip` varchar(50) DEFAULT NULL COMMENT '客户端ip',
  `client_type` smallint(6) DEFAULT NULL COMMENT '客户端类型',
  `status` smallint(6) DEFAULT NULL COMMENT '状态',
  `flag` smallint(6) DEFAULT NULL COMMENT '标志',
  PRIMARY KEY (`code_id`),
  KEY `code_id` (`code_id`),
  KEY `wxs_id` (`wxs_id`),
  KEY `FK_sys_invitation_code_user` (`user_id`),
  CONSTRAINT `FK_sys_invitation_code_user` FOREIGN KEY (`user_id`) REFERENCES `u_user` (`user_id`),
  CONSTRAINT `FK_sys_invitation_code_wxs` FOREIGN KEY (`wxs_id`) REFERENCES `w_wxs` (`wxs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_invitation_code
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_link`
-- ----------------------------
DROP TABLE IF EXISTS `sys_link`;
CREATE TABLE `sys_link` (
  `link_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '链接id',
  `name` varchar(10) DEFAULT NULL COMMENT '链接名',
  `link_url` varchar(200) DEFAULT NULL COMMENT '链接url',
  `link_type` int(11) DEFAULT NULL COMMENT '链接类型',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `status` smallint(6) DEFAULT NULL COMMENT '状态',
  `sort_order` smallint(6) DEFAULT NULL COMMENT '排列顺序',
  PRIMARY KEY (`link_id`),
  KEY `link_id` (`link_id`),
  KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_link
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_login_record`
-- ----------------------------
DROP TABLE IF EXISTS `sys_login_record`;
CREATE TABLE `sys_login_record` (
  `record_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录id',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `client_agent` varchar(250) DEFAULT NULL COMMENT '客户端UA',
  `client_ip` varchar(50) DEFAULT NULL COMMENT '客户端ip',
  `client_type` smallint(6) DEFAULT NULL COMMENT '客户端类型',
  PRIMARY KEY (`record_id`),
  KEY `record_id` (`record_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `FK_sys_login_record_user` FOREIGN KEY (`user_id`) REFERENCES `u_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_login_record
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_province`
-- ----------------------------
DROP TABLE IF EXISTS `sys_province`;
CREATE TABLE `sys_province` (
  `province_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '省id',
  `name` varchar(20) DEFAULT NULL COMMENT '名称',
  `description` text COMMENT '介绍',
  PRIMARY KEY (`province_id`),
  KEY `province_id` (`province_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_province
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_rank`
-- ----------------------------
DROP TABLE IF EXISTS `sys_rank`;
CREATE TABLE `sys_rank` (
  `rank_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '等级记录id',
  `name` varchar(20) DEFAULT NULL COMMENT '等级名称',
  `rank_high` int(11) NOT NULL COMMENT '分数上限',
  `rank_low` int(11) NOT NULL COMMENT '分数下限',
  `rank_logo` varchar(200) DEFAULT NULL COMMENT '等级logo',
  `time` datetime DEFAULT NULL COMMENT '创建时间',
  `ext1` int(11) DEFAULT NULL,
  `ext2` int(11) DEFAULT NULL,
  `ext3` varchar(1024) DEFAULT NULL,
  `ext4` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`rank_id`),
  KEY `rank_id` (`rank_id`),
  KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_rank
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '配置id',
  `name` varchar(20) DEFAULT NULL COMMENT '配置key',
  `value` varchar(36) DEFAULT NULL COMMENT '配置参数',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_time` datetime DEFAULT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`role_id`),
  KEY `role_id` (`role_id`),
  KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_school`
-- ----------------------------
DROP TABLE IF EXISTS `sys_school`;
CREATE TABLE `sys_school` (
  `school_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学校id',
  `name` varchar(20) DEFAULT NULL COMMENT '名称',
  `description` text COMMENT '描述',
  `address` varchar(100) DEFAULT NULL COMMENT '地址',
  `province_id` int(11) DEFAULT NULL COMMENT '省份id',
  `city_id` int(11) DEFAULT NULL COMMENT '城市id',
  `post` smallint(6) DEFAULT NULL COMMENT '邮编',
  PRIMARY KEY (`school_id`),
  KEY `school_id` (`school_id`),
  KEY `FK_sys_school_province` (`province_id`),
  KEY `FK_sys_school_city` (`city_id`),
  CONSTRAINT `FK_sys_school_city` FOREIGN KEY (`city_id`) REFERENCES `sys_city` (`city_id`),
  CONSTRAINT `FK_sys_school_province` FOREIGN KEY (`province_id`) REFERENCES `sys_province` (`province_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_school
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_style`
-- ----------------------------
DROP TABLE IF EXISTS `sys_style`;
CREATE TABLE `sys_style` (
  `style_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '样式id',
  `name` varchar(20) DEFAULT NULL COMMENT '样式名称',
  `path` varchar(256) DEFAULT NULL COMMENT '样式类型',
  `status` smallint(6) DEFAULT NULL COMMENT '状态',
  `create_time` datetime DEFAULT NULL COMMENT '创立时间',
  `cover` varchar(50) DEFAULT NULL COMMENT '预览图',
  `ext1` int(11) DEFAULT NULL,
  `ext2` int(11) DEFAULT NULL,
  `ext3` varchar(1024) DEFAULT NULL,
  `ext4` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`style_id`),
  KEY `style_id` (`style_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_style
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_topic`
-- ----------------------------
DROP TABLE IF EXISTS `sys_topic`;
CREATE TABLE `sys_topic` (
  `topic_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主题ip',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `topic_key` varchar(20) DEFAULT NULL COMMENT '主题key',
  `description` text COMMENT '介绍',
  `topic_index` int(11) DEFAULT NULL COMMENT '主题索引',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `ext1` int(11) DEFAULT NULL,
  `ext2` int(11) DEFAULT NULL,
  `ext3` varchar(1024) DEFAULT NULL,
  `ext4` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`topic_id`),
  KEY `topic_id` (`topic_id`),
  KEY `user_id` (`user_id`),
  KEY `topic_key` (`topic_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_topic
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_type`
-- ----------------------------
DROP TABLE IF EXISTS `sys_type`;
CREATE TABLE `sys_type` (
  `type_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '类型id',
  `name` varchar(20) DEFAULT NULL COMMENT '配置key',
  `value` varchar(36) DEFAULT NULL COMMENT '配置参数',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_time` datetime DEFAULT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`type_id`),
  KEY `type_id` (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_type
-- ----------------------------

-- ----------------------------
-- Table structure for `u_book`
-- ----------------------------
DROP TABLE IF EXISTS `u_book`;
CREATE TABLE `u_book` (
  `ubook_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'bookid',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `name` int(11) NOT NULL COMMENT '名字',
  `book_detaik` text COMMENT '内容简介',
  `cover` varchar(50) DEFAULT NULL COMMENT '封面',
  `time` datetime DEFAULT NULL COMMENT '成立时间',
  `ext1` int(11) DEFAULT NULL COMMENT '扩展1',
  `ext2` int(11) DEFAULT NULL COMMENT '扩展2',
  `ext3` varchar(1024) DEFAULT NULL COMMENT '扩展3',
  `ext4` varchar(1024) DEFAULT NULL COMMENT '扩展4',
  PRIMARY KEY (`ubook_id`),
  KEY `ubook_id` (`ubook_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `FK_u_book_user` FOREIGN KEY (`user_id`) REFERENCES `u_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of u_book
-- ----------------------------

-- ----------------------------
-- Table structure for `u_friend`
-- ----------------------------
DROP TABLE IF EXISTS `u_friend`;
CREATE TABLE `u_friend` (
  `id` int(11) NOT NULL DEFAULT '0' COMMENT 'id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `friend_id` int(11) NOT NULL COMMENT '朋友id',
  `friend_type` int(11) NOT NULL COMMENT '朋友类别',
  `friend_role` int(11) DEFAULT NULL COMMENT '朋友权限',
  `add_time` datetime NOT NULL COMMENT '添加时间',
  `group_id` int(11) NOT NULL COMMENT '所属分组',
  `status` smallint(6) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `friend_id` (`friend_id`),
  KEY `FK_u_fenri_f_group` (`group_id`),
  CONSTRAINT `FK_u_fenri_f_group` FOREIGN KEY (`group_id`) REFERENCES `u_friend_group` (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of u_friend
-- ----------------------------

-- ----------------------------
-- Table structure for `u_friend_group`
-- ----------------------------
DROP TABLE IF EXISTS `u_friend_group`;
CREATE TABLE `u_friend_group` (
  `group_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '分组ip',
  `name` varchar(10) NOT NULL COMMENT '分组名称',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `group_type` int(11) DEFAULT NULL COMMENT '分组类型',
  `group_count` int(11) DEFAULT NULL COMMENT '好友数',
  PRIMARY KEY (`group_id`),
  KEY `group_id` (`group_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `FK_u_friend_group_user` FOREIGN KEY (`user_id`) REFERENCES `u_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of u_friend_group
-- ----------------------------

-- ----------------------------
-- Table structure for `u_sign`
-- ----------------------------
DROP TABLE IF EXISTS `u_sign`;
CREATE TABLE `u_sign` (
  `sign_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '签名编号',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `content` varchar(140) NOT NULL COMMENT '内容',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `status` smallint(6) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`sign_id`),
  KEY `sign_id` (`sign_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `FK_u_sign_user` FOREIGN KEY (`user_id`) REFERENCES `u_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of u_sign
-- ----------------------------

-- ----------------------------
-- Table structure for `u_user`
-- ----------------------------
DROP TABLE IF EXISTS `u_user`;
CREATE TABLE `u_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `site_id` int(11) DEFAULT NULL COMMENT '空间编号',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `nickname` varchar(20) NOT NULL COMMENT '昵称',
  `role_id` int(11) NOT NULL COMMENT '用户角色',
  `sex` smallint(6) DEFAULT NULL COMMENT '性别',
  `birth` datetime DEFAULT NULL COMMENT '生日',
  `email` varchar(50) DEFAULT NULL COMMENT '电子邮箱',
  `homepage` varchar(100) DEFAULT NULL COMMENT '空间主页',
  `qq` varchar(16) DEFAULT NULL COMMENT 'QQ',
  `mobile` varchar(16) DEFAULT NULL COMMENT '手机',
  `province_id` int(11) DEFAULT NULL COMMENT '省',
  `city_id` int(11) DEFAULT NULL COMMENT '城市',
  `school_id` int(11) DEFAULT NULL COMMENT '学校',
  `college_id` int(11) DEFAULT NULL COMMENT '学院',
  `class` varchar(10) DEFAULT NULL COMMENT '班级',
  `portrait` varchar(100) DEFAULT NULL COMMENT '头像',
  `sign_id` int(11) DEFAULT NULL COMMENT '签名档',
  `regtime` datetime DEFAULT NULL COMMENT '注册时间',
  `last_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `last_ip` varchar(48) DEFAULT NULL COMMENT '最后登录ip',
  `keep_day` smallint(6) DEFAULT NULL COMMENT '保留时间',
  `online_status` smallint(6) DEFAULT NULL COMMENT '在线状态',
  `rank_id` int(11) DEFAULT NULL COMMENT '用户等级',
  `article_count` int(11) DEFAULT NULL COMMENT '文章数',
  `article_reply_count` int(11) DEFAULT NULL COMMENT '评论数',
  `topic_count` int(11) DEFAULT NULL COMMENT '帖子数',
  `topic_reply_count` int(11) DEFAULT NULL COMMENT '回帖数',
  `image_count` int(11) DEFAULT NULL COMMENT '照片数',
  `image_reply_count` int(11) DEFAULT NULL COMMENT '图片回帖数',
  `guestbook_count` int(11) DEFAULT NULL COMMENT '留言数',
  `tag_count` int(11) DEFAULT NULL COMMENT '收藏数',
  `popedom` int(11) DEFAULT NULL COMMENT '权限',
  `coid_id` int(11) DEFAULT NULL COMMENT '邀请码',
  PRIMARY KEY (`user_id`),
  KEY `user_id` (`user_id`),
  KEY `FK_u_user_rank` (`rank_id`),
  KEY `FK_u_user_sign` (`sign_id`),
  KEY `FK_u_user_site` (`site_id`),
  CONSTRAINT `FK_u_user_site` FOREIGN KEY (`site_id`) REFERENCES `b_site` (`site_id`),
  CONSTRAINT `FK_u_user_rank` FOREIGN KEY (`rank_id`) REFERENCES `sys_rank` (`rank_id`),
  CONSTRAINT `FK_u_user_sign` FOREIGN KEY (`sign_id`) REFERENCES `u_sign` (`sign_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of u_user
-- ----------------------------
INSERT INTO `u_user` VALUES ('1', null, 'admin', 'admin', 'admin', '0', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `v_access`
-- ----------------------------
DROP TABLE IF EXISTS `v_access`;
CREATE TABLE `v_access` (
  `vaccess_id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '记录id',
  `vote_id` int(11) NOT NULL COMMENT '投票id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `client_agent` varchar(250) DEFAULT NULL COMMENT '客户端UA',
  `client_ip` varchar(50) DEFAULT NULL COMMENT '客户端ip',
  `client_type` smallint(6) DEFAULT NULL COMMENT '客户端类型',
  `time` datetime DEFAULT NULL COMMENT '访问时间',
  PRIMARY KEY (`vaccess_id`),
  KEY `vaccess_id` (`vaccess_id`),
  KEY `vote_id` (`vote_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `FK_v_access_sound` FOREIGN KEY (`vote_id`) REFERENCES `v_vote` (`vote_id`),
  CONSTRAINT `FK_v_access_user` FOREIGN KEY (`user_id`) REFERENCES `u_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of v_access
-- ----------------------------

-- ----------------------------
-- Table structure for `v_count`
-- ----------------------------
DROP TABLE IF EXISTS `v_count`;
CREATE TABLE `v_count` (
  `vcount_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '计数id',
  `vote_id` int(11) NOT NULL COMMENT '投票id',
  `item_id` int(11) NOT NULL COMMENT '选项id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `client_agent` varchar(250) DEFAULT NULL COMMENT '客户端UA',
  `client_ip` varchar(50) DEFAULT NULL COMMENT '客户端ip',
  `client_type` smallint(6) DEFAULT NULL COMMENT '客户端类型',
  `time` datetime DEFAULT NULL COMMENT '发布时间',
  `ext1` int(11) DEFAULT NULL,
  `ext2` int(11) DEFAULT NULL,
  `ext3` varchar(1024) DEFAULT NULL,
  `ext4` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`vcount_id`),
  KEY `vcount_id` (`vcount_id`),
  KEY `vote_id` (`vote_id`),
  KEY `item_id` (`item_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `FK_v_count_item` FOREIGN KEY (`item_id`) REFERENCES `v_item` (`item_id`),
  CONSTRAINT `FK_v_count_user` FOREIGN KEY (`user_id`) REFERENCES `u_user` (`user_id`),
  CONSTRAINT `FK_v_count_vote` FOREIGN KEY (`vote_id`) REFERENCES `v_vote` (`vote_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of v_count
-- ----------------------------

-- ----------------------------
-- Table structure for `v_item`
-- ----------------------------
DROP TABLE IF EXISTS `v_item`;
CREATE TABLE `v_item` (
  `item_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '选项id',
  `vote_id` int(11) NOT NULL COMMENT '主题id',
  `content` varchar(1024) NOT NULL COMMENT '内容id',
  `create_time` datetime DEFAULT NULL COMMENT '创立时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `count` int(11) DEFAULT NULL COMMENT '计数',
  `sort_order` smallint(6) DEFAULT NULL COMMENT '排序',
  `ext1` int(11) DEFAULT NULL,
  `ext2` int(11) DEFAULT NULL,
  `ext3` varchar(1024) DEFAULT NULL,
  `ext4` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`item_id`),
  KEY `item_id` (`item_id`),
  KEY `vote_id` (`vote_id`),
  CONSTRAINT `FK_v_item_vote` FOREIGN KEY (`vote_id`) REFERENCES `v_vote` (`vote_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of v_item
-- ----------------------------

-- ----------------------------
-- Table structure for `v_reply1`
-- ----------------------------
DROP TABLE IF EXISTS `v_reply1`;
CREATE TABLE `v_reply1` (
  `vreply_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评论id',
  `vote_id` int(11) NOT NULL COMMENT '主题id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `client_type` smallint(6) DEFAULT NULL COMMENT '客户端类型',
  `owner_only` smallint(6) DEFAULT NULL COMMENT '是否允许所有人查看',
  `write_time` datetime DEFAULT NULL COMMENT '发表时间',
  `status` smallint(6) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`vreply_id`),
  KEY `vreply_id` (`vreply_id`),
  KEY `vote_id` (`vote_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `FK_v_reply1_image` FOREIGN KEY (`vote_id`) REFERENCES `v_vote` (`vote_id`),
  CONSTRAINT `FK_v_reply1_user` FOREIGN KEY (`user_id`) REFERENCES `u_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of v_reply1
-- ----------------------------

-- ----------------------------
-- Table structure for `v_reply2`
-- ----------------------------
DROP TABLE IF EXISTS `v_reply2`;
CREATE TABLE `v_reply2` (
  `vreply1_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评论id-1',
  `vreply_id` int(11) NOT NULL COMMENT '评论id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `commentator` int(11) NOT NULL COMMENT '被评论人id',
  `content` text NOT NULL COMMENT '内容',
  `client_angent` varchar(250) DEFAULT NULL COMMENT '浏览器UA',
  `client_ip` varchar(50) DEFAULT NULL COMMENT '客户端ip',
  `client_type` smallint(6) DEFAULT NULL COMMENT '客户端类型',
  `reply_time` datetime DEFAULT NULL COMMENT '发布时间',
  `reply_id` datetime DEFAULT NULL COMMENT '引用id',
  `sort_order` smallint(6) DEFAULT NULL COMMENT '排列顺序',
  `ext1` int(11) DEFAULT NULL,
  `ext2` int(11) DEFAULT NULL,
  `ext3` varchar(1024) DEFAULT NULL,
  `ext4` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`vreply1_id`),
  KEY `vreply1_id` (`vreply1_id`),
  KEY `vreply_id` (`vreply_id`),
  KEY `user_id` (`user_id`),
  KEY `FK_v_reply2_user1` (`commentator`),
  CONSTRAINT `FK_v_reply2_user` FOREIGN KEY (`user_id`) REFERENCES `u_user` (`user_id`),
  CONSTRAINT `FK_v_reply2_user1` FOREIGN KEY (`commentator`) REFERENCES `u_user` (`user_id`),
  CONSTRAINT `FK_v_reply2_vreply1` FOREIGN KEY (`vreply_id`) REFERENCES `v_reply1` (`vreply_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of v_reply2
-- ----------------------------

-- ----------------------------
-- Table structure for `v_upvote`
-- ----------------------------
DROP TABLE IF EXISTS `v_upvote`;
CREATE TABLE `v_upvote` (
  `vupvote_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '点赞id',
  `vote_id` int(11) NOT NULL COMMENT '投票id',
  `user_id` int(11) NOT NULL COMMENT '点赞人id',
  `client_agent` varchar(250) DEFAULT NULL COMMENT '客户端UA',
  `client_ip` varchar(50) DEFAULT NULL COMMENT '客户端IP',
  `client_type` smallint(6) DEFAULT NULL COMMENT '客户端类型',
  `time` datetime DEFAULT NULL COMMENT '发布时间',
  `status` smallint(6) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`vupvote_id`),
  KEY `vupvote_id` (`vupvote_id`),
  KEY `vote_id` (`vote_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `FK_v_upvote_image` FOREIGN KEY (`vote_id`) REFERENCES `v_vote` (`vote_id`),
  CONSTRAINT `FK_v_upvote_user` FOREIGN KEY (`vote_id`) REFERENCES `u_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of v_upvote
-- ----------------------------

-- ----------------------------
-- Table structure for `v_vote`
-- ----------------------------
DROP TABLE IF EXISTS `v_vote`;
CREATE TABLE `v_vote` (
  `vote_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `vconfig_id` int(11) DEFAULT NULL COMMENT '配置id',
  `content` varchar(1024) DEFAULT NULL COMMENT '内容',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`vote_id`),
  KEY `vote_id` (`vote_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `FK_v_vote_user` FOREIGN KEY (`user_id`) REFERENCES `u_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of v_vote
-- ----------------------------

-- ----------------------------
-- Table structure for `w_access`
-- ----------------------------
DROP TABLE IF EXISTS `w_access`;
CREATE TABLE `w_access` (
  `waccess_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `client_agent` varchar(250) DEFAULT NULL,
  `client_ip` varchar(50) DEFAULT NULL,
  `client_type` smallint(6) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  PRIMARY KEY (`waccess_id`),
  KEY `waccess` (`waccess_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `FK_w_access_user` FOREIGN KEY (`user_id`) REFERENCES `u_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of w_access
-- ----------------------------

-- ----------------------------
-- Table structure for `w_book`
-- ----------------------------
DROP TABLE IF EXISTS `w_book`;
CREATE TABLE `w_book` (
  `wbook_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '书id',
  `wxs_id` int(11) NOT NULL COMMENT '文学社id',
  `name` varchar(50) DEFAULT NULL COMMENT '名字',
  `book_dateil` text,
  `cover` varchar(50) DEFAULT NULL COMMENT '封面',
  `create_time` datetime DEFAULT NULL COMMENT '成立时间',
  `ext1` int(11) DEFAULT NULL,
  `ext2` int(11) DEFAULT NULL,
  `ext3` varchar(1024) DEFAULT NULL,
  `ext4` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`wbook_id`),
  KEY `wbook_id` (`wbook_id`),
  KEY `wxs_id` (`wxs_id`),
  CONSTRAINT `FK_w_book_wxs` FOREIGN KEY (`wxs_id`) REFERENCES `w_wxs` (`wxs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of w_book
-- ----------------------------

-- ----------------------------
-- Table structure for `w_config`
-- ----------------------------
DROP TABLE IF EXISTS `w_config`;
CREATE TABLE `w_config` (
  `wconfig_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '配置id',
  `wxs_id` int(11) NOT NULL COMMENT '文学社id',
  `config_key` varchar(20) DEFAULT NULL COMMENT '配置key',
  `value` varchar(36) DEFAULT NULL COMMENT '配置参数',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_time` datetime DEFAULT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`wconfig_id`),
  KEY `wconfig_id` (`wconfig_id`),
  KEY `wxs_id` (`wxs_id`),
  CONSTRAINT `FK_w_cofig_wxs` FOREIGN KEY (`wxs_id`) REFERENCES `w_wxs` (`wxs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of w_config
-- ----------------------------

-- ----------------------------
-- Table structure for `w_link`
-- ----------------------------
DROP TABLE IF EXISTS `w_link`;
CREATE TABLE `w_link` (
  `wlink_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '链接id',
  `wxs_id` int(11) NOT NULL COMMENT '文学社id',
  `name` varchar(10) DEFAULT NULL COMMENT '链接名',
  `link_url` varchar(200) DEFAULT NULL COMMENT '链接url',
  `logo` varchar(50) DEFAULT NULL COMMENT 'logo地址',
  `link_type` int(11) DEFAULT NULL COMMENT '链接类型',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `status` smallint(6) DEFAULT NULL COMMENT '状态',
  `sort_order` smallint(6) DEFAULT NULL COMMENT '排列顺序',
  `ext1` int(11) DEFAULT NULL,
  `ext2` int(11) DEFAULT NULL,
  `ext3` varchar(1024) DEFAULT NULL,
  `ext4` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`wlink_id`),
  KEY `wlink_id` (`wlink_id`),
  KEY `wxs_id` (`wxs_id`),
  CONSTRAINT `FK_w_link_wxs` FOREIGN KEY (`wxs_id`) REFERENCES `w_wxs` (`wxs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of w_link
-- ----------------------------

-- ----------------------------
-- Table structure for `w_status`
-- ----------------------------
DROP TABLE IF EXISTS `w_status`;
CREATE TABLE `w_status` (
  `wstatus_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '状态id',
  `wxs_id` int(11) NOT NULL COMMENT '文学社id',
  `time` datetime DEFAULT NULL COMMENT '统计时间',
  `uv_count` int(11) DEFAULT NULL COMMENT '用户id',
  `pv_count` int(11) DEFAULT NULL COMMENT '点击次数',
  `type` int(11) DEFAULT NULL COMMENT '访问类型',
  `update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`wstatus_id`),
  KEY `wstatus_id` (`wstatus_id`),
  KEY `wxs_id` (`wxs_id`),
  CONSTRAINT `FK_w_status_wxs` FOREIGN KEY (`wxs_id`) REFERENCES `w_wxs` (`wxs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of w_status
-- ----------------------------

-- ----------------------------
-- Table structure for `w_wxs`
-- ----------------------------
DROP TABLE IF EXISTS `w_wxs`;
CREATE TABLE `w_wxs` (
  `wxs_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '文学社id',
  `account` int(11) NOT NULL COMMENT '账户',
  `password` varchar(48) NOT NULL COMMENT '密码',
  `name` varchar(20) DEFAULT NULL COMMENT '空间的名字',
  `title` varchar(10) DEFAULT NULL COMMENT '唯一的标示 （与空间的url相关）',
  `wxs_url` varchar(100) DEFAULT NULL COMMENT '文学社url',
  `wxs_detail` text COMMENT '文虚设说明',
  `logo` varchar(200) DEFAULT NULL COMMENT 'logo地址',
  `style_id` int(11) DEFAULT NULL COMMENT '样式id',
  `flag` smallint(6) DEFAULT NULL COMMENT '空间标志',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_time` datetime DEFAULT NULL COMMENT '最后发帖时间',
  `mode` smallint(6) unsigned zerofill DEFAULT NULL COMMENT '权限模式',
  `access_code` varchar(50) DEFAULT NULL COMMENT '访问密码',
  `index_name` varchar(10) DEFAULT NULL COMMENT '个性化首页名',
  `diary_name` varchar(10) DEFAULT NULL COMMENT '个性化日志名',
  `sound_name` varchar(10) DEFAULT NULL COMMENT '个性化相册名',
  `image_name` varchar(10) DEFAULT NULL COMMENT '个性化相册名',
  `site_type` int(11) DEFAULT NULL COMMENT '空间类型',
  `status` smallint(6) DEFAULT NULL COMMENT '状态',
  `ext1` int(11) DEFAULT NULL,
  `ext2` int(11) DEFAULT NULL,
  `ext3` varchar(1024) DEFAULT NULL,
  `ext4` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`wxs_id`),
  KEY `wxs_id` (`wxs_id`),
  KEY `account` (`account`),
  KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of w_wxs
-- ----------------------------
