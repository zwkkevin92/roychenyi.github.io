/*
MySQL Backup
Source Server Version: 5.6.19
Source Database: wxs
Date: 2016/04/08 23:20:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
--  Table structure for `b_access`
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
--  Table structure for `b_backlist`
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
--  Table structure for `b_config`
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
--  Table structure for `b_site`
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `b_status`
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
--  Table structure for `b_tag`
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
--  Table structure for `d_access`
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
--  Table structure for `d_annex`
-- ----------------------------
DROP TABLE IF EXISTS `d_annex`;
CREATE TABLE `d_annex` (
  `annex_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '附件id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `site_id` int(11) DEFAULT NULL COMMENT '空间id',
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
--  Table structure for `d_catalog`
-- ----------------------------
DROP TABLE IF EXISTS `d_catalog`;
CREATE TABLE `d_catalog` (
  `catalog_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '日记分类id',
  `site_id` int(11) DEFAULT NULL COMMENT '空间id',
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
--  Table structure for `d_diary`
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
--  Table structure for `d_reply1`
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
--  Table structure for `d_reply2`
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
--  Table structure for `d_upvote`
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
--  Table structure for `i_access`
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
--  Table structure for `i_album`
-- ----------------------------
DROP TABLE IF EXISTS `i_album`;
CREATE TABLE `i_album` (
  `album_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '相册id',
  `site_id` int(11) DEFAULT NULL COMMENT '空间id',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `i_image`
-- ----------------------------
DROP TABLE IF EXISTS `i_image`;
CREATE TABLE `i_image` (
  `image_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '声音id',
  `album_id` int(11) NOT NULL COMMENT '相册id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `site_id` int(11) DEFAULT NULL COMMENT '网站id',
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
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `i_reply1`
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
--  Table structure for `i_reply2`
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
--  Table structure for `i_upvote`
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
--  Table structure for `m_affiche`
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
--  Table structure for `m_guestbook`
-- ----------------------------
DROP TABLE IF EXISTS `m_guestbook`;
CREATE TABLE `m_guestbook` (
  `guestbook_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录id',
  `site_id` int(11) DEFAULT NULL COMMENT '空间id',
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
--  Table structure for `m_message`
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
--  Table structure for `m_reply`
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
--  Table structure for `sys_blocked_ip`
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
--  Table structure for `sys_city`
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
--  Table structure for `sys_college`
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
--  Table structure for `sys_config`
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config` (
  `config_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '配置id',
  `config_name` varchar(50) DEFAULT NULL COMMENT '配置key',
  `value` varchar(50) DEFAULT NULL COMMENT '配置参数',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_time` datetime DEFAULT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`config_id`),
  KEY `config_id` (`config_id`),
  KEY `config_name` (`config_name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `sys_illegal`
-- ----------------------------
DROP TABLE IF EXISTS `sys_illegal`;
CREATE TABLE `sys_illegal` (
  `illegal_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `word` varchar(10) NOT NULL COMMENT '非法词',
  `newword` varchar(10) DEFAULT NULL COMMENT '用于替换的字符',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `nullify` tinyint(4) DEFAULT NULL COMMENT '作废标志',
  PRIMARY KEY (`illegal_id`),
  UNIQUE KEY `word` (`word`),
  UNIQUE KEY `UK_pwm3bqcmr2wwmg1ck40u5qu80` (`word`)
) ENGINE=InnoDB AUTO_INCREMENT=123 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `sys_invitation_code`
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
--  Table structure for `sys_link`
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
--  Table structure for `sys_login_record`
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
--  Table structure for `sys_province`
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
--  Table structure for `sys_rank`
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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `sys_role`
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
--  Table structure for `sys_school`
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
--  Table structure for `sys_style`
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `sys_topic`
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
--  Table structure for `sys_type`
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
--  Table structure for `s_access`
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
--  Table structure for `s_box`
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
--  Table structure for `s_reply1`
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
--  Table structure for `s_reply2`
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
--  Table structure for `s_sound`
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
--  Table structure for `s_upvote`
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
--  Table structure for `u_book`
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
--  Table structure for `u_friend`
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
--  Table structure for `u_friend_group`
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
--  Table structure for `u_sign`
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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `u_user`
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
  `blood` varchar(5) DEFAULT NULL COMMENT '血型',
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
  `rank_id` int(11) DEFAULT '1' COMMENT '用户等级',
  `rank` int(11) DEFAULT '0' COMMENT '积分',
  `article_count` int(11) DEFAULT '0' COMMENT '文章数',
  `article_reply_count` int(11) DEFAULT '0' COMMENT '评论数',
  `topic_count` int(11) DEFAULT '0' COMMENT '帖子数',
  `topic_reply_count` int(11) DEFAULT '0' COMMENT '回帖数',
  `image_count` int(11) DEFAULT '0' COMMENT '照片数',
  `image_reply_count` int(11) DEFAULT '0' COMMENT '图片回帖数',
  `guestbook_count` int(11) DEFAULT '0' COMMENT '留言数',
  `tag_count` int(11) DEFAULT '0' COMMENT '收藏数',
  `fans` int(11) DEFAULT '0' COMMENT '粉丝数',
  `follows` int(11) DEFAULT '0' COMMENT '关注数',
  `popedom` int(11) DEFAULT NULL COMMENT '权限',
  `code_id` int(11) DEFAULT NULL COMMENT '邀请码',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `UK_9ujn2ebi367np35n74jlg9yl9` (`username`),
  KEY `user_id` (`user_id`),
  KEY `FK_u_user_rank` (`rank_id`),
  KEY `FK_u_user_sign` (`sign_id`),
  KEY `FK_u_user_site` (`site_id`),
  CONSTRAINT `FK_u_user_rank` FOREIGN KEY (`rank_id`) REFERENCES `sys_rank` (`rank_id`),
  CONSTRAINT `FK_u_user_sign` FOREIGN KEY (`sign_id`) REFERENCES `u_sign` (`sign_id`),
  CONSTRAINT `FK_u_user_site` FOREIGN KEY (`site_id`) REFERENCES `b_site` (`site_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `v_access`
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
--  Table structure for `v_count`
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
--  Table structure for `v_item`
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
--  Table structure for `v_reply1`
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
--  Table structure for `v_reply2`
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
--  Table structure for `v_upvote`
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
--  Table structure for `v_vote`
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
--  Table structure for `w_access`
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
--  Table structure for `w_book`
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
--  Table structure for `w_config`
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
--  Table structure for `w_link`
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
--  Table structure for `w_status`
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
--  Table structure for `w_wxs`
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
--  Records 
-- ----------------------------
INSERT INTO `b_site` VALUES ('1','1','test','测试','/admin','这个是个测试页面','upload/image/1/2016/4/7//1460014285872_s_100.jpg','1',NULL,'2016-02-01 20:50:50','2016-04-07 15:31:25','1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL), ('8','11','陈义','陈义的博客','/陈义',NULL,NULL,'1',NULL,'2016-04-06 14:08:53',NULL,'1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `i_album` VALUES ('1',NULL,NULL,'默认相册',NULL,'1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `i_image` VALUES ('1','1','1',NULL,'1459390208378.jpg',NULL,'3_1366x768.jpg',NULL,'upload/image/1/2016/3/31//1459390208378.jpg','upload/image/1/2016/3/31//1459390208378_200.jpg',NULL,'2016-03-31 10:10:08','2016','3','31','1366','768',NULL,'0','192.168.1.103','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2657.3 Safari/537.36','1',NULL,NULL,NULL,NULL,NULL,'upload/image/1/2016/3/31//1459390208378_s_200.jpg','upload/image/1/2016/3/31//1459390208378_s_100.jpg'), ('2','1','1',NULL,'1459390540403.jpg',NULL,'3_1366x768.jpg',NULL,'upload/image/1/2016/3/31//1459390540403.jpg','upload/image/1/2016/3/31//1459390540403_200.jpg',NULL,'2016-03-31 10:15:40','2016','3','31','1366','768',NULL,'0','192.168.1.103','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2657.3 Safari/537.36','1',NULL,NULL,NULL,NULL,NULL,'upload/image/1/2016/3/31//1459390540403_s_200.jpg','upload/image/1/2016/3/31//1459390540403_s_100.jpg'), ('3','1','1',NULL,'1459390697468.jpg',NULL,'3_1366x768.jpg',NULL,'upload/image/1/2016/3/31//1459390697468.jpg','upload/image/1/2016/3/31//1459390697468_200.jpg',NULL,'2016-03-31 10:18:17','2016','3','31','1366','768',NULL,'0','192.168.1.103','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2657.3 Safari/537.36','1',NULL,NULL,NULL,NULL,NULL,'upload/image/1/2016/3/31//1459390697468_s_200.jpg','upload/image/1/2016/3/31//1459390697468_s_100.jpg'), ('4','1','1',NULL,'1459390806184.jpg',NULL,'QQ头像.jpg',NULL,'upload/image/1/2016/3/31//1459390806184.jpg','upload/image/1/2016/3/31//1459390806184_200.jpg',NULL,'2016-03-31 10:20:06','2016','3','31','1206','1200',NULL,'0','192.168.1.103','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2657.3 Safari/537.36','1',NULL,NULL,NULL,NULL,NULL,'upload/image/1/2016/3/31//1459390806184_s_200.jpg','upload/image/1/2016/3/31//1459390806184_s_100.jpg'), ('5','1','1',NULL,'1459391305707.jpg',NULL,'IMG_20160328_111134.jpg',NULL,'upload/image/1/2016/3/31//1459391305707.jpg','upload/image/1/2016/3/31//1459391305707_200.jpg',NULL,'2016-03-31 10:28:25','2016','3','31','2304','4096',NULL,'1','192.168.1.101','Mozilla/5.0 (Linux; U; Android 5.1; zh-CN; Lenovo K50-t5 Build/LMY47D) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 UCBrowser/10.9.5.729 U3/0.8.0 Mobile Safari/534.30','1',NULL,NULL,NULL,NULL,NULL,'upload/image/1/2016/3/31//1459391305707_s_200.jpg','upload/image/1/2016/3/31//1459391305707_s_100.jpg'), ('6','1','1',NULL,'1459391442264.jpg',NULL,'1431845829809.jpg',NULL,'upload/image/1/2016/3/31//1459391442264.jpg','upload/image/1/2016/3/31//1459391442264_200.jpg',NULL,'2016-03-31 10:30:42','2016','3','31','480','480',NULL,'1','192.168.1.103','Mozilla/5.0 (iPhone; CPU iPhone OS 9_1 like Mac OS X) AppleWebKit/601.1.46 (KHTML, like Gecko) Version/9.0 Mobile/13B143 Safari/601.1','1',NULL,NULL,NULL,NULL,NULL,'upload/image/1/2016/3/31//1459391442264_s_200.jpg','upload/image/1/2016/3/31//1459391442264_s_100.jpg'), ('7','1','1',NULL,'1459393148434.jpg',NULL,'IMG_20160325_151941.jpg',NULL,'upload/image/1/2016/3/31//1459393148434.jpg','upload/image/1/2016/3/31//1459393148434_200.jpg',NULL,'2016-03-31 10:59:08','2016','3','31','2304','4096',NULL,'1','192.168.1.101','Mozilla/5.0 (Linux; U; Android 5.1; zh-CN; Lenovo K50-t5 Build/LMY47D) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 UCBrowser/10.9.5.729 U3/0.8.0 Mobile Safari/534.30','1',NULL,NULL,NULL,NULL,NULL,'upload/image/1/2016/3/31//1459393148434_s_200.jpg','upload/image/1/2016/3/31//1459393148434_s_100.jpg'), ('10','1','1',NULL,'1459948889763.jpg',NULL,'psb.jpg',NULL,'upload/image/1/2016/4/6//1459948889763.jpg','upload/image/1/2016/4/6//1459948889763_200.jpg',NULL,'2016-04-06 21:21:29','2016','4','6','440','312',NULL,'0','192.168.1.103','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2657.3 Safari/537.36','1',NULL,NULL,NULL,NULL,NULL,'upload/image/1/2016/4/6//1459948889763_s_200.jpg','upload/image/1/2016/4/6//1459948889763_s_100.jpg'), ('11','1','1',NULL,'1459950091921.jpg',NULL,'psb.jpg',NULL,'upload/image/1/2016/4/6//1459950091921.jpg','upload/image/1/2016/4/6//1459950091921_200.jpg',NULL,'2016-04-06 21:41:31','2016','4','6','440','312',NULL,'0','192.168.1.103','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2657.3 Safari/537.36','1',NULL,NULL,NULL,NULL,NULL,'upload/image/1/2016/4/6//1459950091921_s_200.jpg','upload/image/1/2016/4/6//1459950091921_s_100.jpg'), ('12','1','1',NULL,'1459952903460.jpg',NULL,'QQ截图20160331155950.png',NULL,'upload/image/1/2016/4/6//1459952903460.jpg','upload/image/1/2016/4/6//1459952903460_200.jpg',NULL,'2016-04-06 22:28:23','2016','4','6','1507','893',NULL,'0','192.168.1.103','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2657.3 Safari/537.36','1',NULL,NULL,NULL,NULL,NULL,'upload/image/1/2016/4/6//1459952903460_s_200.jpg','upload/image/1/2016/4/6//1459952903460_s_100.jpg'), ('13','1','1',NULL,'1459952978832.jpg',NULL,'psb.jpg',NULL,'upload/image/1/2016/4/6//1459952978832.jpg','upload/image/1/2016/4/6//1459952978832_200.jpg',NULL,'2016-04-06 22:29:38','2016','4','6','440','312',NULL,'0','192.168.1.103','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2657.3 Safari/537.36','1',NULL,NULL,NULL,NULL,NULL,'upload/image/1/2016/4/6//1459952978832_s_200.jpg','upload/image/1/2016/4/6//1459952978832_s_100.jpg'), ('14','1','1',NULL,'1460013399929.jpg',NULL,'3_1366x768.jpg',NULL,'upload/image/1/2016/4/7//1460013399929.jpg','upload/image/1/2016/4/7//1460013399929_200.jpg',NULL,'2016-04-07 15:16:39','2016','4','7','1366','768',NULL,'0','192.168.1.103','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2657.3 Safari/537.36','1',NULL,NULL,NULL,NULL,NULL,'upload/image/1/2016/4/7//1460013399929_s_200.jpg','upload/image/1/2016/4/7//1460013399929_s_100.jpg'), ('15','1','1',NULL,'1460014285872.jpg',NULL,'3_1366x768.jpg',NULL,'upload/image/1/2016/4/7//1460014285872.jpg','upload/image/1/2016/4/7//1460014285872_200.jpg',NULL,'2016-04-07 15:31:25','2016','4','7','1366','768',NULL,'0','192.168.1.103','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2657.3 Safari/537.36','1',NULL,NULL,NULL,NULL,NULL,'upload/image/1/2016/4/7//1460014285872_s_200.jpg','upload/image/1/2016/4/7//1460014285872_s_100.jpg');
INSERT INTO `sys_config` VALUES ('1','system_email_username','wxs@9347.xyz','2016-04-02 20:38:40','2016-04-02 20:38:44'), ('2','system_email_password','cjdx@2016','2016-04-02 20:40:52',NULL), ('3','system_email_smtp','smtp.mxhichina.com','2016-04-02 20:42:40',NULL), ('4','system_email_pop3','pop3.mxhichina.com','2016-04-02 20:42:44',NULL), ('5','system_email_port','25','2016-04-02 20:42:46',NULL), ('6','system_email_sender','文学社平台','2016-04-02 20:42:49',NULL);
INSERT INTO `sys_illegal` VALUES ('1','独立台湾会','独****','2016-03-24 21:16:42',NULL,'0'), ('2','法轮功','法**','2016-03-24 21:16:42',NULL,'0'), ('3','法轮','法*','2016-03-24 21:16:42',NULL,'0'), ('4','反腐败论坛','反****','2016-03-24 21:16:42',NULL,'0'), ('5','共匪','共*','2016-03-24 21:16:42',NULL,'0'), ('6','轮奸','轮*','2016-03-24 21:16:42',NULL,'0'), ('7','射精','射*','2016-03-24 21:16:42',NULL,'0'), ('8','台湾独立','台***','2016-03-24 21:16:42',NULL,'0'), ('9','天安门事件','天****','2016-03-24 21:16:42',NULL,'0'), ('10','天安门屠杀','天****','2016-03-24 21:16:42',NULL,'0'), ('11','西藏独立','西***','2016-03-24 21:16:42',NULL,'0'), ('12','下体','下*','2016-03-24 21:16:42',NULL,'0'), ('13','淫穴','淫*','2016-03-24 21:16:42',NULL,'0'), ('14','幼齿','幼*','2016-03-24 21:16:42',NULL,'0'), ('15','幼女','幼*','2016-03-24 21:16:42',NULL,'0'), ('16','政治犯','政**','2016-03-24 21:16:42',NULL,'0'), ('17','中国猪','中**','2016-03-24 21:16:42',NULL,'0'), ('18','fuck','f***','2016-03-24 21:16:42',NULL,'0'), ('19','小穴','小*','2016-03-24 21:16:42',NULL,'0'), ('20','傻B','傻*','2016-03-24 21:16:42',NULL,'0'), ('21','傻逼','傻*','2016-03-24 21:16:42',NULL,'0'), ('22','日死你','日**','2016-03-24 21:16:42',NULL,'0'), ('23','我操你','我**','2016-03-24 21:16:42',NULL,'0'), ('24','干死你','干**','2016-03-24 21:16:42',NULL,'0'), ('25','鸡八','鸡*','2016-03-24 21:16:42',NULL,'0'), ('26','鸡巴','鸡*','2016-03-24 21:16:42',NULL,'0'), ('27','操逼','操*','2016-03-24 21:16:42',NULL,'0'), ('28','操比','操*','2016-03-24 21:16:42',NULL,'0'), ('29','大逼','大*','2016-03-24 21:16:42',NULL,'0'), ('30','大b','大*','2016-03-24 21:16:42',NULL,'0'), ('31','贱逼','贱*','2016-03-24 21:16:42',NULL,'0'), ('32','贱比','贱*','2016-03-24 21:16:42',NULL,'0'), ('33','干你娘','干**','2016-03-24 21:16:42',NULL,'0'), ('34','卖逼','卖*','2016-03-24 21:16:42',NULL,'0'), ('35','卖比','卖*','2016-03-24 21:16:42',NULL,'0'), ('36','狗b','狗*','2016-03-24 21:16:42',NULL,'0'), ('37','烂逼','烂*','2016-03-24 21:16:42',NULL,'0'), ('38','烂比','烂*','2016-03-24 21:16:42',NULL,'0'), ('39','大花逼','大**','2016-03-24 21:16:42',NULL,'0'), ('40','靠你妈','靠**','2016-03-24 21:16:42',NULL,'0'), ('41','操你妈','操**','2016-03-24 21:16:42',NULL,'0'), ('42','妈批','妈*','2016-03-24 21:16:42',NULL,'0'), ('43','逼样','逼*','2016-03-24 21:16:42',NULL,'0'), ('44','肉棍','肉*','2016-03-24 21:16:42',NULL,'0'), ('45','二逼','二*','2016-03-24 21:16:42',NULL,'0'), ('46','二B','二*','2016-03-24 21:16:42',NULL,'0'), ('47','肉棒','肉*','2016-03-24 21:16:42',NULL,'0'), ('48','你妈','你*','2016-03-24 21:16:42',NULL,'0'), ('49','你娘','你*','2016-03-24 21:16:42',NULL,'0'), ('50','你爸','你*','2016-03-24 21:16:42',NULL,'0'), ('51','shit','s***','2016-03-24 21:16:42',NULL,'0'), ('52','操你','操*','2016-03-24 21:16:42',NULL,'0'), ('53','婊子','婊*','2016-03-24 21:16:42',NULL,'0'), ('54','bitch','b****','2016-03-24 21:16:42',NULL,'0'), ('55','我日','我*','2016-03-24 21:16:42',NULL,'0'), ('56','我操','我*','2016-03-24 21:16:42',NULL,'0'), ('57','日你','日*','2016-03-24 21:16:42',NULL,'0'), ('58','操他','操*','2016-03-24 21:16:42',NULL,'0'), ('59','操蛋','操*','2016-03-24 21:16:42',NULL,'0'), ('60','共产党','共**','2016-03-24 21:16:42',NULL,'0'), ('61','屄','屄','2016-03-24 21:16:42',NULL,'0'), ('62','舔奶','舔*','2016-03-24 21:16:42',NULL,'0'), ('63','小鸡鸡','小**','2016-03-24 21:16:42',NULL,'0'), ('64','强奸','强*','2016-03-24 21:16:42',NULL,'0'), ('65','群奸','群*','2016-03-24 21:16:42',NULL,'0'), ('66','贱人','贱*','2016-03-24 21:16:42',NULL,'0'), ('67','狗娘','狗*','2016-03-24 21:16:42',NULL,'0'), ('68','睾丸','睾*','2016-03-24 21:16:42',NULL,'0'), ('69','包皮','包*','2016-03-24 21:16:42',NULL,'0'), ('70','龟头','龟*','2016-03-24 21:16:42',NULL,'0'), ('71','奶子','奶*','2016-03-24 21:16:42',NULL,'0'), ('72','作爱','作*','2016-03-24 21:16:42',NULL,'0'), ('73','做爱','做*','2016-03-24 21:16:42',NULL,'0'), ('74','打炮','打*','2016-03-24 21:16:42',NULL,'0'), ('75','十八摸','十**','2016-03-24 21:16:42',NULL,'0'), ('76','喷你','喷*','2016-03-24 21:16:42',NULL,'0'), ('77','哈批','哈*','2016-03-24 21:16:42',NULL,'0'), ('78','大比','大*','2016-03-24 21:16:42',NULL,'0'), ('79','精液','精*','2016-03-24 21:16:42',NULL,'0'), ('80','精子','精*','2016-03-24 21:16:42',NULL,'0'), ('81','龟公','龟*','2016-03-24 21:16:42',NULL,'0'), ('82','屁眼','屁*','2016-03-24 21:16:42',NULL,'0'), ('83','你妈的','你**','2016-03-24 21:16:42',NULL,'0'), ('84','他妈的','他**','2016-03-24 21:16:42',NULL,'0'), ('85','去你妈的','去***','2016-03-24 21:16:42',NULL,'0'), ('86','奸淫','奸*','2016-03-24 21:16:42',NULL,'0'), ('87','淫荡','淫*','2016-03-24 21:16:42',NULL,'0'), ('88','烂货','烂*','2016-03-24 21:16:42',NULL,'0'), ('89','破鞋','破*','2016-03-24 21:16:42',NULL,'0'), ('90','贱货','贱*','2016-03-24 21:16:42',NULL,'0'), ('91','肛门','肛*','2016-03-24 21:16:42',NULL,'0'), ('92','阴茎','阴*','2016-03-24 21:16:42',NULL,'0'), ('93','狗卵子','狗**','2016-03-24 21:16:42',NULL,'0'), ('94','狗操','狗*','2016-03-24 21:16:42',NULL,'0'), ('95','猪操','猪*','2016-03-24 21:16:42',NULL,'0'), ('96','发骚','发*','2016-03-24 21:16:42',NULL,'0'), ('97','骚货','骚*','2016-03-24 21:16:42',NULL,'0'), ('98','狗屎','狗*','2016-03-24 21:16:42',NULL,'0'), ('99','妓女','妓*','2016-03-24 21:16:42',NULL,'0'), ('100','招妓','招*','2016-03-24 21:16:42',NULL,'0');
INSERT INTO `sys_illegal` VALUES ('101','阴道','阴*','2016-03-24 21:16:42',NULL,'0'), ('102','阴水','阴*','2016-03-24 21:16:42',NULL,'0'), ('103','阴唇','阴*','2016-03-24 21:16:42',NULL,'0'), ('104','阴蒂','阴*','2016-03-24 21:16:42',NULL,'0'), ('105','狂操','狂*','2016-03-24 21:16:42',NULL,'0'), ('106','淫水','淫*','2016-03-24 21:16:42',NULL,'0'), ('107','杂种','杂*','2016-03-24 21:16:42',NULL,'0'), ('108','插你','插*','2016-03-24 21:16:42',NULL,'0'), ('109','性交','性*','2016-03-24 21:16:42',NULL,'0'), ('110','肛交','肛*','2016-03-24 21:16:42',NULL,'0'), ('111','性欲','性*','2016-03-24 21:16:42',NULL,'0'), ('112','B样','B*','2016-03-24 21:16:42',NULL,'0'), ('113','淫图','淫*','2016-03-24 21:16:42',NULL,'0'), ('114','肉洞','肉*','2016-03-24 21:16:42',NULL,'0'), ('115','交媾','交*','2016-03-24 21:16:42',NULL,'0'), ('116','毛泽东','毛**','2016-03-24 21:16:42',NULL,'0'), ('117','MB','M*','2016-03-24 21:16:42',NULL,'0'), ('118','nnd',NULL,'2016-03-24 21:19:55',NULL,'0'), ('121','骚逼',NULL,'2016-03-25 12:06:07',NULL,'0'), ('122','台独','台*',NULL,NULL,NULL);
INSERT INTO `sys_rank` VALUES ('1','1','10','1',NULL,'2016-03-31 16:55:38',NULL,NULL,NULL,NULL), ('2','2','10','2',NULL,'2016-03-31 16:55:56',NULL,NULL,NULL,NULL), ('3','3','10','3',NULL,'2016-03-31 16:56:11',NULL,NULL,NULL,NULL), ('4','4','10','4',NULL,'2016-03-31 16:56:30',NULL,NULL,NULL,NULL), ('5','5','10','5',NULL,'2016-03-31 16:56:49',NULL,NULL,NULL,NULL), ('6','6','10','6',NULL,'2016-03-31 16:57:16',NULL,NULL,NULL,NULL), ('7','7','10','7',NULL,'2016-03-31 16:57:31',NULL,NULL,NULL,NULL), ('8','8','10','8',NULL,'2016-03-31 16:57:55',NULL,NULL,NULL,NULL), ('9','9','10','9',NULL,'2016-03-31 16:58:17',NULL,NULL,NULL,NULL), ('10','10','10','10',NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `sys_style` VALUES ('1','默认','0000','0','2016-02-01 20:50:26',NULL,NULL,NULL,NULL,NULL);
INSERT INTO `u_sign` VALUES ('1','1','一个好人！！！！','2016-04-06 09:51:09','0'), ('2','1','测试签名档！！！','2016-04-06 09:53:43','0'), ('3','1','测试签名档！！！测试','2016-04-06 09:56:11','0'), ('4','1','测试签名档！！！测试','2016-04-06 09:59:53','0'), ('5','1','测试签名档！！！测试','2016-04-06 10:01:29','0'), ('6','1','签名档','2016-04-06 10:14:05','0'), ('7','1','再牛逼的梦想抵不过傻逼式的坚持','2016-04-06 10:19:58','0'), ('8','1','我的未来不是梦','2016-04-06 10:21:22','0'), ('9','1','','2016-04-06 10:25:57','0'), ('10','11','我就是我，颜色不一样的烟火！！！',NULL,'1'), ('11','1','',NULL,'0'), ('12','1','我一般不说自己有才华，因为别人会说。',NULL,'1');
INSERT INTO `u_user` VALUES ('1','1','852416288@qq.com','E10ADC3949BA59ABBE56E057F20F883E','admin','0','0','2016-01-03 00:00:00','852416288@qq.com',NULL,'852416288','A',NULL,NULL,NULL,NULL,NULL,NULL,'upload/image/1/2016/4/7//1460014285872_s_30.jpg','12',NULL,'2016-04-07 14:24:13','192.168.1.103',NULL,NULL,'1','0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1',NULL), ('11','8','tbyfchenyi@126.com','E10ADC3949BA59ABBE56E057F20F883E','陈义','1',NULL,'2004-02-29 00:00:00','tbyfchenyi@126.com',NULL,NULL,'A',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'10','2016-04-06 14:08:16','2016-04-06 14:15:21','192.168.1.103',NULL,NULL,NULL,'0','0','0','0','0','0','0','0','0','0','0','1',NULL);
