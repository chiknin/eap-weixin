/*
 Navicat MySQL Data Transfer

 Source Server         : local
 Source Server Version : 50615
 Source Host           : 127.0.0.1
 Source Database       : weixin

 Target Server Version : 50615
 File Encoding         : utf-8

 Date: 05/24/2015 13:51:49 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `t_bas_code_table`
-- ----------------------------
DROP TABLE IF EXISTS `t_bas_code_table`;
CREATE TABLE `t_bas_code_table` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `code_type` varchar(100) DEFAULT NULL,
  `code_key` varchar(100) DEFAULT NULL,
  `code_value` varchar(100) DEFAULT NULL,
  `code_name` varchar(200) DEFAULT NULL,
  `code_desc` varchar(200) DEFAULT NULL,
  `code_group` varchar(100) DEFAULT NULL,
  `ordinal` smallint(2) DEFAULT NULL,
  `can_modify_ind` char(1) DEFAULT '1',
  `status` char(1) DEFAULT '1',
  `created_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
--  Records of `t_bas_code_table`
-- ----------------------------
BEGIN;
INSERT INTO `t_bas_code_table` VALUES ('1', 'Status', 'S0', '0', '失效', null, null, '1', '0', '1', '2014-12-06 20:14:35', '2014-12-06 20:14:37'), ('2', 'Status', 'S1', '1', '生效', null, null, '2', '0', '1', '2014-12-06 20:14:38', '2014-12-06 20:14:39'), ('3', 'MsgDirection', 'S1', '1', '接收/响应', null, null, '1', '0', '1', '2014-12-06 20:14:41', '2014-12-06 20:14:41'), ('4', 'MsgDirection', 'S2', '2', '回复/请求', null, null, '2', '0', '1', '2014-12-06 20:14:42', '2014-12-06 20:14:43'), ('5', 'ReplyType', 'S1', '1', '被动回复', null, null, '1', '0', '1', '2014-12-06 20:14:44', '2014-12-06 20:14:45'), ('6', 'ReplyType', 'S2', '2', '自动回复', null, null, '2', '0', '1', '2014-12-06 20:14:46', '2014-12-06 20:14:47'), ('7', 'MediaType', 'S1', 'text', '文本', null, null, '1', '1', '1', '2014-12-06 20:14:48', '2014-12-06 20:14:49'), ('8', 'MediaType', 'S2', 'image', '图片', null, null, '2', '1', '1', '2014-12-06 20:14:50', '2014-12-06 20:14:50'), ('9', 'MediaType', 'S3', 'voice', '音频', null, null, '3', '1', '1', '2014-12-06 20:14:52', '2014-12-06 20:14:53'), ('10', 'MediaType', 'S4', 'video', '视频', null, null, '4', '1', '1', '2014-12-06 20:14:54', '2014-12-06 20:14:55'), ('11', 'MediaType', 'S5', 'music', '音乐', null, null, '5', '1', '1', '2014-12-06 20:14:56', '2014-12-06 20:14:56'), ('12', 'MediaType', 'S6', 'news', '图文', null, null, '6', '1', '1', '2014-12-06 20:14:57', '2014-12-06 20:14:58'), ('13', 'MpAccountType', 'S1', '1', '订阅号', null, null, '1', '1', '1', '2014-12-06 20:14:59', '2014-12-06 20:15:00'), ('14', 'MpAccountType', 'S2', '2', '服务号', null, null, '2', '1', '1', '2014-12-06 20:15:01', '2014-12-06 20:15:02'), ('15', 'MpAccountType', 'S3', '3', '企业号', null, null, '3', '1', '1', '2014-12-06 20:15:04', '2014-12-06 20:15:04'), ('16', 'Sex', 'S0', '0', '未知', null, null, '1', '1', '1', '2014-12-06 20:15:07', '2014-12-06 20:15:08'), ('17', 'Sex', 'S1', '1', '男', null, null, '2', '1', '1', '2014-12-06 20:15:09', '2014-12-06 20:15:09'), ('18', 'Sex', 'S2', '2', '女', null, null, '3', '1', '1', '2014-12-06 20:15:11', '2014-12-06 20:15:11'), ('19', 'Indicator', 'S0', '0', '否', null, null, '1', '1', '1', '2014-12-06 20:16:31', '2014-12-06 20:16:32'), ('20', 'Indicator', 'S1', '1', '是', null, null, '2', '1', '1', '2014-12-06 20:16:33', '2014-12-06 20:16:34'), ('21', 'EncryptionMode', 'S1', '1', '明文模式', null, null, '1', '1', '1', '2014-12-08 09:49:03', '2014-12-08 09:49:04'), ('22', 'EncryptionMode', 'S2', '2', '兼容模式', null, null, '2', '1', '1', '2014-12-08 09:49:31', '2014-12-08 09:49:33'), ('23', 'EncryptionMode', 'S3', '3', '安全模式', null, null, '3', '1', '1', '2014-12-08 09:49:34', '2014-12-08 09:49:35'), ('24', 'RequestMode', 'S1', '1', '进站', 'inbound', null, '1', '1', '1', '2014-12-08 15:04:23', '2014-12-08 15:04:27'), ('25', 'RequestMode', 'S2', '2', '出站', 'outbound', null, '2', '1', '1', '2014-12-08 15:04:29', '2014-12-08 15:04:31');
COMMIT;

-- ----------------------------
--  Table structure for `t_mp_access_token`
-- ----------------------------
DROP TABLE IF EXISTS `t_mp_access_token`;
CREATE TABLE `t_mp_access_token` (
  `id` bigint(18) unsigned NOT NULL DEFAULT '0',
  `mp_open_id` varchar(100) DEFAULT NULL,
  `access_token` varchar(200) DEFAULT NULL,
  `expires_in` datetime DEFAULT NULL,
  `refresh_token` varchar(200) DEFAULT NULL,
  `fans_open_id` varchar(100) DEFAULT NULL,
  `scope` varchar(100) DEFAULT NULL,
  `status` char(1) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `t_mp_access_token`
-- ----------------------------
BEGIN;
INSERT INTO `t_mp_access_token` VALUES ('478631061618692098', 'gh_c428cb3829b5', 'YS2LIVDTg5gPlF4XctulBFMpr1W2JeWZF5qSC8wF9zhL3LmmitkwS_9H3pR1oUWvh2pLWN11PwY3W92x0RWL_DSwGUeg1IWMzAYBgHEJy3k', null, null, null, null, '1', '2014-12-08 11:43:37', '2014-12-08 11:43:48');
COMMIT;

-- ----------------------------
--  Table structure for `t_mp_account`
-- ----------------------------
DROP TABLE IF EXISTS `t_mp_account`;
CREATE TABLE `t_mp_account` (
  `id` bigint(18) unsigned NOT NULL DEFAULT '0',
  `account_type` char(1) DEFAULT NULL COMMENT '账号类型：1-订阅号，2-服务号，3-企业号',
  `account_name` varchar(100) DEFAULT NULL COMMENT '公众号名称',
  `open_id` varchar(100) DEFAULT NULL COMMENT '微信原始ID， openid',
  `mp_no` varchar(100) DEFAULT NULL COMMENT '微信号',
  `email` varchar(100) DEFAULT NULL COMMENT '登录邮箱',
  `head_img_url` varchar(2000) DEFAULT NULL COMMENT '公众号头像URL',
  `qrcode_pic_url` varchar(2000) DEFAULT NULL,
  `language` varchar(50) DEFAULT NULL,
  `description` text,
  `app_id` varchar(100) DEFAULT NULL COMMENT '应用ID',
  `app_secret` char(32) DEFAULT NULL COMMENT '应用密钥',
  `server_url` varchar(2000) DEFAULT NULL,
  `token` varchar(32) DEFAULT NULL,
  `aes_key` char(32) DEFAULT NULL,
  `encryption_mode` char(1) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `t_mp_account`
-- ----------------------------
BEGIN;
INSERT INTO `t_mp_account` VALUES ('478601361542352898', '2', '微信测试号', 'gh_c428cb3829b5', 'gh_c428cb3829b5', null, null, null, 'zh_CN', null, 'wx2795ed48af470051', '8a37d4be54f288f3ea6a38002165c64f', 'http://58.135.84.44/weixin/gateway/weixin/wx2795ed48af470051.rest', '123456', null, '1', '2014-12-08 09:49:54', '2014-12-08 09:49:58');
COMMIT;

-- ----------------------------
--  Table structure for `t_mp_media`
-- ----------------------------
DROP TABLE IF EXISTS `t_mp_media`;
CREATE TABLE `t_mp_media` (
  `id` bigint(18) unsigned NOT NULL DEFAULT '0',
  `mp_open_id` varchar(100) DEFAULT NULL COMMENT '公众号openid',
  `media_type` varchar(50) DEFAULT NULL COMMENT '媒体文件类型',
  `group_id` bigint(18) unsigned DEFAULT NULL COMMENT '分组',
  `format` varchar(50) DEFAULT NULL COMMENT '媒体文件格式',
  `mp_thumb_media_id` varchar(500) DEFAULT NULL COMMENT '缩略图的媒体id（微信平台）',
  `title` varchar(500) DEFAULT NULL COMMENT '消息的标题',
  `description` text COMMENT '消息内容',
  `music_url` varchar(1000) DEFAULT NULL COMMENT '音乐链接',
  `hq_music_url` varchar(1000) DEFAULT NULL COMMENT '高品质音乐链接',
  `mp_media_id` varchar(500) DEFAULT NULL COMMENT '媒体id（微信平台）',
  `mp_created_time` datetime DEFAULT NULL COMMENT '创建时间（微信平台）',
  `file_name` varchar(100) DEFAULT NULL COMMENT '文件名称',
  `file_path` varchar(1000) DEFAULT NULL COMMENT '文件路径',
  `status` char(1) DEFAULT NULL COMMENT '如  是否过期',
  `created_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `t_mp_media`
-- ----------------------------
BEGIN;
INSERT INTO `t_mp_media` VALUES ('478278557827600384', 'gh_c428cb3829b5', 'text', '478278557827600385', null, null, null, '回复文本内容', null, null, null, null, null, null, '1', '2014-12-05 16:36:26', '2014-12-05 16:36:27'), ('478729719349514242', 'gh_c428cb3829b5', 'text', '478278557827600385', null, null, null, 'text1', null, null, null, null, null, null, '1', '2014-12-08 18:15:49', '2014-12-08 18:15:56');
COMMIT;

-- ----------------------------
--  Table structure for `t_mp_media_article`
-- ----------------------------
DROP TABLE IF EXISTS `t_mp_media_article`;
CREATE TABLE `t_mp_media_article` (
  `id` bigint(18) unsigned NOT NULL DEFAULT '0',
  `mp_open_id` varchar(100) DEFAULT NULL,
  `media_id` bigint(18) unsigned DEFAULT NULL,
  `title` varchar(500) DEFAULT NULL,
  `author` varchar(100) DEFAULT NULL COMMENT '消息的作者',
  `summary` varchar(1000) DEFAULT NULL COMMENT '消息摘要',
  `content` text,
  `content_source_url` varchar(2000) DEFAULT NULL COMMENT '阅读原文链接 == url',
  `ordinal` decimal(2,0) DEFAULT NULL,
  `mp_thumb_media_id` varchar(500) DEFAULT NULL COMMENT '缩略图的媒体id（微信平台）',
  `pic_url` varchar(2000) DEFAULT NULL,
  `show_cover_pic` char(1) DEFAULT NULL COMMENT '是否显示封面，1为显示，0为不显示',
  `created_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `t_mp_media_group`
-- ----------------------------
DROP TABLE IF EXISTS `t_mp_media_group`;
CREATE TABLE `t_mp_media_group` (
  `id` bigint(18) unsigned NOT NULL DEFAULT '0',
  `mp_open_id` varchar(100) DEFAULT NULL,
  `media_type` varchar(50) DEFAULT NULL,
  `group_name` varchar(50) DEFAULT NULL,
  `count` int(10) unsigned DEFAULT NULL,
  `builtin` char(1) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `t_mp_media_group`
-- ----------------------------
BEGIN;
INSERT INTO `t_mp_media_group` VALUES ('478278557827600385', 'gh_c428cb3829b5', '1', '未分组', '0', null, '2014-12-05 16:33:49', '2014-12-05 16:33:50');
COMMIT;

-- ----------------------------
--  Table structure for `t_mp_menu`
-- ----------------------------
DROP TABLE IF EXISTS `t_mp_menu`;
CREATE TABLE `t_mp_menu` (
  `id` bigint(18) unsigned NOT NULL DEFAULT '0',
  `mp_open_id` varchar(100) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `key` varchar(100) DEFAULT NULL,
  `url` varchar(2000) DEFAULT NULL,
  `ordinal` smallint(2) DEFAULT NULL,
  `parent_id` bigint(18) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `t_mp_msg`
-- ----------------------------
DROP TABLE IF EXISTS `t_mp_msg`;
CREATE TABLE `t_mp_msg` (
  `id` bigint(18) unsigned NOT NULL DEFAULT '0',
  `msg_direction` char(1) DEFAULT NULL COMMENT '消息方向：1-接收，2-回复',
  `fans_open_id` varchar(100) DEFAULT NULL COMMENT '粉丝openid',
  `mp_open_id` varchar(100) DEFAULT NULL COMMENT '公众号openid',
  `mp_created_time` datetime DEFAULT NULL COMMENT '创建时间（微信平台）',
  `msg_type` varchar(100) DEFAULT NULL COMMENT '消息类型',
  `mp_msg_id` varchar(50) DEFAULT NULL COMMENT '信息ID（微信平台）',
  `event` varchar(100) DEFAULT NULL COMMENT '事件',
  `event_key` varchar(1000) DEFAULT NULL COMMENT '事件key',
  `content` text COMMENT '文本消息内容',
  `pic_url` varchar(1000) DEFAULT NULL COMMENT '图片链接\n图片链接',
  `mp_media_id` varchar(500) DEFAULT NULL COMMENT '图片消息媒体id',
  `format` varchar(50) DEFAULT NULL COMMENT '多媒体格式',
  `mp_thumb_media_id` varchar(500) DEFAULT NULL COMMENT '缩略图的媒体id（微信平台）',
  `title` varchar(500) DEFAULT NULL COMMENT '消息标题',
  `description` text COMMENT '消息描述',
  `url` varchar(1000) DEFAULT NULL COMMENT '消息链接',
  `ticket` varchar(1000) DEFAULT NULL COMMENT '二维码的ticket',
  `pos_latitude` int(10) DEFAULT NULL COMMENT '地理位置纬度',
  `pos_longitude` int(10) DEFAULT NULL COMMENT '地理位置经度',
  `pos_precision` int(10) DEFAULT NULL COMMENT '地理位置精度',
  `pos_scale` int(10) DEFAULT NULL COMMENT '地图缩放大小',
  `label` varchar(500) DEFAULT NULL COMMENT '地理位置信息',
  `recognition` text COMMENT '语音识别结',
  `reply_type` char(1) DEFAULT NULL COMMENT '消息回复类型',
  `reply_media_id` bigint(18) unsigned DEFAULT NULL COMMENT '回复素材ID',
  `origin_msg_id` bigint(18) unsigned DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `t_mp_msg`
-- ----------------------------
BEGIN;
INSERT INTO `t_mp_msg` VALUES ('478724091205914624', '1', 'oO7yRjkr-n0oyefNG4gBNb7DXLNA', 'gh_c428cb3829b5', '2014-12-08 17:52:57', 'event', null, 'unsubscribe', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2014-12-08 17:52:58', '2014-12-08 17:52:58'), ('478724157551415296', '1', 'oO7yRjkr-n0oyefNG4gBNb7DXLNA', 'gh_c428cb3829b5', '2014-12-08 17:53:13', 'event', null, 'subscribe', '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2014-12-08 17:53:14', '2014-12-08 17:53:14'), ('478724161875742720', '2', 'oO7yRjkr-n0oyefNG4gBNb7DXLNA', 'gh_c428cb3829b5', null, 'text', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '478278557827600384', '478724157551415296', '2014-12-08 17:53:15', '2014-12-08 17:53:15'), ('478724168074924032', '1', 'oO7yRjkr-n0oyefNG4gBNb7DXLNA', 'gh_c428cb3829b5', '2014-12-08 17:53:16', 'event', null, 'LOCATION', null, null, null, null, null, null, null, null, null, null, '40', '116', '65', null, null, null, null, null, null, '2014-12-08 17:53:16', '2014-12-08 17:53:16'), ('478724561509027840', '1', 'oO7yRjkr-n0oyefNG4gBNb7DXLNA', 'gh_c428cb3829b5', '2014-12-08 17:54:50', 'event', null, 'unsubscribe', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2014-12-08 17:54:50', '2014-12-08 17:54:50'), ('478729564801994752', '1', 'oO7yRjkr-n0oyefNG4gBNb7DXLNA', 'gh_c428cb3829b5', '2014-12-08 18:14:42', 'event', null, 'subscribe', '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2014-12-08 18:14:43', '2014-12-08 18:14:43'), ('478729564906852352', '2', 'oO7yRjkr-n0oyefNG4gBNb7DXLNA', 'gh_c428cb3829b5', null, 'text', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '478278557827600384', '478729564801994752', '2014-12-08 18:14:43', '2014-12-08 18:14:43'), ('478729972127633408', '1', 'oO7yRjkr-n0oyefNG4gBNb7DXLNA', 'gh_c428cb3829b5', '2014-12-08 18:16:19', 'text', '6090408705630042984', null, null, '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2014-12-08 18:16:20', '2014-12-08 18:16:20'), ('478729972215713792', '2', 'oO7yRjkr-n0oyefNG4gBNb7DXLNA', 'gh_c428cb3829b5', null, 'text', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '478278557827600384', '478729972127633408', '2014-12-08 18:16:20', '2014-12-08 18:16:20'), ('478729985356468224', '1', 'oO7yRjkr-n0oyefNG4gBNb7DXLNA', 'gh_c428cb3829b5', '2014-12-08 18:16:23', 'text', '6090408722809912172', null, null, '2', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2014-12-08 18:16:23', '2014-12-08 18:16:23'), ('478729985440354304', '2', 'oO7yRjkr-n0oyefNG4gBNb7DXLNA', 'gh_c428cb3829b5', null, 'text', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '478729719349514242', '478729985356468224', '2014-12-08 18:16:23', '2014-12-08 18:16:23'), ('478730180651651072', '1', 'oO7yRjkr-n0oyefNG4gBNb7DXLNA', 'gh_c428cb3829b5', '2014-12-08 18:17:09', 'text', '6090408920378407805', null, null, 'Hello', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2014-12-08 18:17:10', '2014-12-08 18:17:10'), ('478730208367611904', '1', 'oO7yRjkr-n0oyefNG4gBNb7DXLNA', 'gh_c428cb3829b5', '2014-12-08 18:17:16', 'text', '6090408950443178881', null, null, 'hello', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2014-12-08 18:17:17', '2014-12-08 18:17:17'), ('478730208472469504', '2', 'oO7yRjkr-n0oyefNG4gBNb7DXLNA', 'gh_c428cb3829b5', null, 'text', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '478729719349514242', '478730208367611904', '2014-12-08 18:17:17', '2014-12-08 18:17:17'), ('480145268759597056', '1', 'o9lYQuPEiLMPVJkUJAdSyigFvoas', 'gh_95f93382ab6d', '2014-12-12 16:00:11', 'event', null, 'unsubscribe', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2014-12-12 16:00:13', '2014-12-12 16:00:13'), ('480145304830611456', '1', 'o9lYQuPEiLMPVJkUJAdSyigFvoas', 'gh_95f93382ab6d', '2014-12-12 16:00:21', 'event', null, 'subscribe', '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2014-12-12 16:00:22', '2014-12-12 16:00:22');
COMMIT;

-- ----------------------------
--  Table structure for `t_mp_msg_data`
-- ----------------------------
DROP TABLE IF EXISTS `t_mp_msg_data`;
CREATE TABLE `t_mp_msg_data` (
  `id` bigint(18) unsigned NOT NULL DEFAULT '0',
  `request_id` char(36) DEFAULT NULL,
  `request_mode` char(1) DEFAULT NULL,
  `msg_direction` char(1) DEFAULT NULL,
  `data` text,
  `created_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `t_mp_msg_data`
-- ----------------------------
BEGIN;
INSERT INTO `t_mp_msg_data` VALUES ('478724091050725376', 'a6265f04-0b2d-4cb9-98d4-7f15eb236103', '1', '1', '<xml><ToUserName><![CDATA[gh_c428cb3829b5]]></ToUserName>\n<FromUserName><![CDATA[oO7yRjkr-n0oyefNG4gBNb7DXLNA]]></FromUserName>\n<CreateTime>1418032377</CreateTime>\n<MsgType><![CDATA[event]]></MsgType>\n<Event><![CDATA[unsubscribe]]></Event>\n<EventKey><![CDATA[]]></EventKey>\n</xml>', '2014-12-08 17:52:58', '2014-12-08 17:52:58'), ('478724091310772224', 'a6265f04-0b2d-4cb9-98d4-7f15eb236103', '1', '2', '', '2014-12-08 17:52:58', '2014-12-08 17:52:58'), ('478724157509472256', 'a7845d7a-f3c5-4d32-9cb6-f8ac7c096708', '1', '1', '<xml><ToUserName><![CDATA[gh_c428cb3829b5]]></ToUserName>\n<FromUserName><![CDATA[oO7yRjkr-n0oyefNG4gBNb7DXLNA]]></FromUserName>\n<CreateTime>1418032393</CreateTime>\n<MsgType><![CDATA[event]]></MsgType>\n<Event><![CDATA[subscribe]]></Event>\n<EventKey><![CDATA[]]></EventKey>\n</xml>', '2014-12-08 17:53:14', '2014-12-08 17:53:14'), ('478724157618524160', '1f98e007-6ec5-46f4-90e8-cf1e99d8b09d', '2', '2', 'GET\r\nhttps://api.weixin.qq.com/cgi-bin/user/info?access_token=YS2LIVDTg5gPlF4XctulBFMpr1W2JeWZF5qSC8wF9zhL3LmmitkwS_9H3pR1oUWvh2pLWN11PwY3W92x0RWL_DSwGUeg1IWMzAYBgHEJy3k&openid=oO7yRjkr-n0oyefNG4gBNb7DXLNA&lang=zh_CN\r\n', '2014-12-08 17:53:14', '2014-12-08 17:53:14'), ('478724161087213568', '1f98e007-6ec5-46f4-90e8-cf1e99d8b09d', '2', '1', '{\"subscribe\":1,\"openid\":\"oO7yRjkr-n0oyefNG4gBNb7DXLNA\",\"nickname\":\"step\",\"sex\":0,\"language\":\"zh_CN\",\"city\":\"\",\"province\":\"\",\"country\":\"\",\"headimgurl\":\"\",\"subscribe_time\":1418032393,\"remark\":\"\"}', '2014-12-08 17:53:15', '2014-12-08 17:53:15'), ('478724161393397760', '446f61f1-b3cd-40b8-b147-7e12b3893ab6', '2', '2', 'POST\r\nhttps://api.weixin.qq.com/cgi-bin/groups/getid?access_token=YS2LIVDTg5gPlF4XctulBFMpr1W2JeWZF5qSC8wF9zhL3LmmitkwS_9H3pR1oUWvh2pLWN11PwY3W92x0RWL_DSwGUeg1IWMzAYBgHEJy3k\r\n{\"openid\":\"oO7yRjkr-n0oyefNG4gBNb7DXLNA\"}', '2014-12-08 17:53:15', '2014-12-08 17:53:15'), ('478724161653444608', '446f61f1-b3cd-40b8-b147-7e12b3893ab6', '2', '1', '{\"groupid\":0}', '2014-12-08 17:53:15', '2014-12-08 17:53:15'), ('478724163553464320', 'a7845d7a-f3c5-4d32-9cb6-f8ac7c096708', '1', '2', '<xml>\n   <ToUserName><![CDATA[oO7yRjkr-n0oyefNG4gBNb7DXLNA]]></ToUserName>\n   <FromUserName><![CDATA[gh_c428cb3829b5]]></FromUserName>\n   <CreateTime>1417768586</CreateTime>\n   <MsgType><![CDATA[text]]></MsgType>\n   <Content><![CDATA[回复文本内容]]></Content>\n</xml>', '2014-12-08 17:53:15', '2014-12-08 17:53:15'), ('478724168053952512', 'e39ef2c9-5d06-4ab8-b483-6d60efa19773', '1', '1', '<xml><ToUserName><![CDATA[gh_c428cb3829b5]]></ToUserName>\n<FromUserName><![CDATA[oO7yRjkr-n0oyefNG4gBNb7DXLNA]]></FromUserName>\n<CreateTime>1418032396</CreateTime>\n<MsgType><![CDATA[event]]></MsgType>\n<Event><![CDATA[LOCATION]]></Event>\n<Latitude>39.919056</Latitude>\n<Longitude>116.426903</Longitude>\n<Precision>65.000000</Precision>\n</xml>', '2014-12-08 17:53:16', '2014-12-08 17:53:16'), ('478724168154615808', 'e39ef2c9-5d06-4ab8-b483-6d60efa19773', '1', '2', '', '2014-12-08 17:53:16', '2014-12-08 17:53:16'), ('478724561488056320', 'c25a5646-3297-4a81-acd0-297a94369d6e', '1', '1', '<xml><ToUserName><![CDATA[gh_c428cb3829b5]]></ToUserName>\n<FromUserName><![CDATA[oO7yRjkr-n0oyefNG4gBNb7DXLNA]]></FromUserName>\n<CreateTime>1418032490</CreateTime>\n<MsgType><![CDATA[event]]></MsgType>\n<Event><![CDATA[unsubscribe]]></Event>\n<EventKey><![CDATA[]]></EventKey>\n</xml>', '2014-12-08 17:54:50', '2014-12-08 17:54:50'), ('478724563086086144', 'c25a5646-3297-4a81-acd0-297a94369d6e', '1', '2', '', '2014-12-08 17:54:51', '2014-12-08 17:54:51'), ('478729563203964928', '313f63ed-a6d8-4337-bb09-c3d3ace7e7a0', '1', '1', '<xml><ToUserName><![CDATA[gh_c428cb3829b5]]></ToUserName>\n<FromUserName><![CDATA[oO7yRjkr-n0oyefNG4gBNb7DXLNA]]></FromUserName>\n<CreateTime>1418033682</CreateTime>\n<MsgType><![CDATA[event]]></MsgType>\n<Event><![CDATA[subscribe]]></Event>\n<EventKey><![CDATA[]]></EventKey>\n</xml>', '2014-12-08 18:14:43', '2014-12-08 18:14:43'), ('478729564919435264', '313f63ed-a6d8-4337-bb09-c3d3ace7e7a0', '1', '2', '<xml>\n   <ToUserName><![CDATA[oO7yRjkr-n0oyefNG4gBNb7DXLNA]]></ToUserName>\n   <FromUserName><![CDATA[gh_c428cb3829b5]]></FromUserName>\n   <CreateTime>1417768586</CreateTime>\n   <MsgType><![CDATA[text]]></MsgType>\n   <Content><![CDATA[回复文本内容]]></Content>\n</xml>', '2014-12-08 18:14:43', '2014-12-08 18:14:43'), ('478729971745951744', 'ab3071f7-0b53-491b-858b-757a37086b67', '1', '1', '<xml><ToUserName><![CDATA[gh_c428cb3829b5]]></ToUserName>\n<FromUserName><![CDATA[oO7yRjkr-n0oyefNG4gBNb7DXLNA]]></FromUserName>\n<CreateTime>1418033779</CreateTime>\n<MsgType><![CDATA[text]]></MsgType>\n<Content><![CDATA[1]]></Content>\n<MsgId>6090408705630042984</MsgId>\n</xml>', '2014-12-08 18:16:20', '2014-12-08 18:16:20'), ('478729972224102400', 'ab3071f7-0b53-491b-858b-757a37086b67', '1', '2', '<xml>\n   <ToUserName><![CDATA[oO7yRjkr-n0oyefNG4gBNb7DXLNA]]></ToUserName>\n   <FromUserName><![CDATA[gh_c428cb3829b5]]></FromUserName>\n   <CreateTime>1417768586</CreateTime>\n   <MsgType><![CDATA[text]]></MsgType>\n   <Content><![CDATA[回复文本内容]]></Content>\n</xml>', '2014-12-08 18:16:20', '2014-12-08 18:16:20'), ('478729985335496704', 'a9ed6194-01ea-4009-b03f-04da0c17b1ef', '1', '1', '<xml><ToUserName><![CDATA[gh_c428cb3829b5]]></ToUserName>\n<FromUserName><![CDATA[oO7yRjkr-n0oyefNG4gBNb7DXLNA]]></FromUserName>\n<CreateTime>1418033783</CreateTime>\n<MsgType><![CDATA[text]]></MsgType>\n<Content><![CDATA[2]]></Content>\n<MsgId>6090408722809912172</MsgId>\n</xml>', '2014-12-08 18:16:23', '2014-12-08 18:16:23'), ('478729985452937216', 'a9ed6194-01ea-4009-b03f-04da0c17b1ef', '1', '2', '<xml>\n   <ToUserName><![CDATA[oO7yRjkr-n0oyefNG4gBNb7DXLNA]]></ToUserName>\n   <FromUserName><![CDATA[gh_c428cb3829b5]]></FromUserName>\n   <CreateTime>1418033749</CreateTime>\n   <MsgType><![CDATA[text]]></MsgType>\n   <Content><![CDATA[text1]]></Content>\n</xml>', '2014-12-08 18:16:23', '2014-12-08 18:16:23'), ('478730180634873856', '0ae7c30a-688a-494d-b52a-e7710b54b085', '1', '1', '<xml><ToUserName><![CDATA[gh_c428cb3829b5]]></ToUserName>\n<FromUserName><![CDATA[oO7yRjkr-n0oyefNG4gBNb7DXLNA]]></FromUserName>\n<CreateTime>1418033829</CreateTime>\n<MsgType><![CDATA[text]]></MsgType>\n<Content><![CDATA[Hello]]></Content>\n<MsgId>6090408920378407805</MsgId>\n</xml>', '2014-12-08 18:17:10', '2014-12-08 18:17:10'), ('478730180693594112', '0ae7c30a-688a-494d-b52a-e7710b54b085', '1', '2', '', '2014-12-08 18:17:10', '2014-12-08 18:17:10'), ('478730208350834688', '1aaa668b-ad8c-460d-83ab-b483e41dfa51', '1', '1', '<xml><ToUserName><![CDATA[gh_c428cb3829b5]]></ToUserName>\n<FromUserName><![CDATA[oO7yRjkr-n0oyefNG4gBNb7DXLNA]]></FromUserName>\n<CreateTime>1418033836</CreateTime>\n<MsgType><![CDATA[text]]></MsgType>\n<Content><![CDATA[hello]]></Content>\n<MsgId>6090408950443178881</MsgId>\n</xml>', '2014-12-08 18:17:17', '2014-12-08 18:17:17'), ('478730208489246720', '1aaa668b-ad8c-460d-83ab-b483e41dfa51', '1', '2', '<xml>\n   <ToUserName><![CDATA[oO7yRjkr-n0oyefNG4gBNb7DXLNA]]></ToUserName>\n   <FromUserName><![CDATA[gh_c428cb3829b5]]></FromUserName>\n   <CreateTime>1418033749</CreateTime>\n   <MsgType><![CDATA[text]]></MsgType>\n   <Content><![CDATA[text1]]></Content>\n</xml>', '2014-12-08 18:17:17', '2014-12-08 18:17:17'), ('480145263080509440', '49e7a243-2a9b-4575-8d4f-b324f6caca18', '1', '1', '<xml><ToUserName><![CDATA[gh_95f93382ab6d]]></ToUserName>\n<FromUserName><![CDATA[o9lYQuPEiLMPVJkUJAdSyigFvoas]]></FromUserName>\n<CreateTime>1418371211</CreateTime>\n<MsgType><![CDATA[event]]></MsgType>\n<Event><![CDATA[unsubscribe]]></Event>\n<EventKey><![CDATA[]]></EventKey>\n</xml>', '2014-12-12 16:00:12', '2014-12-12 16:00:12'), ('480145270374404096', '49e7a243-2a9b-4575-8d4f-b324f6caca18', '1', '2', '', '2014-12-12 16:00:14', '2014-12-12 16:00:14'), ('480145304184688640', '2df98bba-6733-4e1d-b41a-3b73db4451ca', '1', '1', '<xml><ToUserName><![CDATA[gh_95f93382ab6d]]></ToUserName>\n<FromUserName><![CDATA[o9lYQuPEiLMPVJkUJAdSyigFvoas]]></FromUserName>\n<CreateTime>1418371221</CreateTime>\n<MsgType><![CDATA[event]]></MsgType>\n<Event><![CDATA[subscribe]]></Event>\n<EventKey><![CDATA[]]></EventKey>\n</xml>', '2014-12-12 16:00:22', '2014-12-12 16:00:22');
COMMIT;

-- ----------------------------
--  Table structure for `t_mp_msg_route`
-- ----------------------------
DROP TABLE IF EXISTS `t_mp_msg_route`;
CREATE TABLE `t_mp_msg_route` (
  `id` bigint(18) unsigned NOT NULL DEFAULT '0',
  `route_name` varchar(100) DEFAULT NULL,
  `rule` text,
  `priority` smallint(3) DEFAULT NULL,
  `class_name` varchar(500) DEFAULT NULL,
  `method_name` varchar(100) DEFAULT NULL,
  `method_params` varchar(1000) DEFAULT NULL,
  `status` char(1) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `t_mp_msg_route`
-- ----------------------------
BEGIN;
INSERT INTO `t_mp_msg_route` VALUES ('478275145270562816', 'reply', '#msgType == \'event\'', '1', 'spring replyUCC', 'doReplyByEvent', null, '1', '2014-12-06 23:07:02', '2014-12-06 23:07:03'), ('478275145274757121', 'reply', '#msgType == \'text\'', '2', 'spring replyUCC', 'doReplyByKeyword', null, '1', '2014-12-05 16:27:57', '2014-12-05 16:27:58'), ('478275603829624835', 'reply', '#msgType == \'text\' && #content == \'hello\'', '3', 'spring replyUCC', 'doReplyByMediaId', '{\"mediaId\":\"478729719349514242\"}', '1', '2014-12-07 12:11:50', '2014-12-07 12:11:51'), ('478286836419006466', 'reply', '#msgType == \'text\' && #content == \'0\'', '4', 'spring replyUCC', 'doReplyByTsr', null, '1', '2014-12-07 12:57:03', '2014-12-07 12:57:05');
COMMIT;

-- ----------------------------
--  Table structure for `t_mp_reply_event`
-- ----------------------------
DROP TABLE IF EXISTS `t_mp_reply_event`;
CREATE TABLE `t_mp_reply_event` (
  `id` bigint(18) unsigned NOT NULL DEFAULT '0',
  `mp_open_id` varchar(1000) DEFAULT NULL,
  `event` varchar(100) DEFAULT NULL COMMENT '事件',
  `event_key` varchar(2000) DEFAULT NULL COMMENT '事件key',
  `media_id` bigint(18) unsigned DEFAULT NULL COMMENT '回复素材ID',
  `created_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `t_mp_reply_event`
-- ----------------------------
BEGIN;
INSERT INTO `t_mp_reply_event` VALUES ('478279980690706433', 'gh_c428cb3829b5', 'subscribe', null, '478278557827600384', '2014-12-07 12:29:00', '2014-12-07 12:29:01'), ('478279980690706434', 'gh_c428cb3829b5', 'subscribe', 'qrscene_1111', '478278557827600384', '2014-12-07 12:31:29', '2014-12-07 12:31:30');
COMMIT;

-- ----------------------------
--  Table structure for `t_mp_reply_keyword`
-- ----------------------------
DROP TABLE IF EXISTS `t_mp_reply_keyword`;
CREATE TABLE `t_mp_reply_keyword` (
  `id` bigint(18) unsigned NOT NULL DEFAULT '0',
  `mp_open_id` varchar(1000) DEFAULT NULL,
  `keyword` varchar(100) DEFAULT NULL COMMENT '事件',
  `media_id` bigint(18) unsigned DEFAULT NULL COMMENT '回复素材ID',
  `created_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `t_mp_reply_keyword`
-- ----------------------------
BEGIN;
INSERT INTO `t_mp_reply_keyword` VALUES ('478281140487065600', 'gh_c428cb3829b5', '1', '478278557827600384', '2014-12-07 12:34:02', '2014-12-07 12:34:03'), ('478281140491259904', 'gh_c428cb3829b5', '2', '478729719349514242', '2014-12-07 12:34:16', '2014-12-07 12:34:17'), ('478281140491259905', 'gh_c428cb3829b5', '3', '478278557827600384', '2014-12-07 12:34:28', '2014-12-07 12:34:30');
COMMIT;

-- ----------------------------
--  Table structure for `t_mp_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_mp_user`;
CREATE TABLE `t_mp_user` (
  `id` bigint(18) unsigned NOT NULL DEFAULT '0',
  `mp_open_id` varchar(100) DEFAULT NULL,
  `open_id` varchar(100) DEFAULT NULL,
  `union_id` varchar(100) DEFAULT NULL,
  `nick_name` varchar(100) DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  `country` varchar(100) DEFAULT NULL,
  `province` varchar(100) DEFAULT NULL,
  `city` varchar(100) DEFAULT NULL,
  `head_img_url` varchar(1000) DEFAULT NULL,
  `language` varchar(50) DEFAULT NULL,
  `subscribe` char(1) DEFAULT NULL,
  `subscribe_time` datetime DEFAULT NULL,
  `privilege` varchar(1000) DEFAULT NULL,
  `mp_group_id` int(10) unsigned DEFAULT NULL,
  `qrcode_scene` varchar(100) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `I_MP_USER_OPEN_ID` (`open_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `t_mp_user`
-- ----------------------------
BEGIN;
INSERT INTO `t_mp_user` VALUES ('478724161670221824', 'gh_c428cb3829b5', 'oO7yRjkr-n0oyefNG4gBNb7DXLNA', null, 'step', null, '0', '', '', '', '', 'zh_CN', '1', '2014-12-08 18:14:42', null, '0', '', '2014-12-08 17:53:15', '2014-12-08 18:14:43');
COMMIT;

-- ----------------------------
--  Table structure for `t_mp_user_group`
-- ----------------------------
DROP TABLE IF EXISTS `t_mp_user_group`;
CREATE TABLE `t_mp_user_group` (
  `id` bigint(18) unsigned NOT NULL DEFAULT '0',
  `mp_open_id` varchar(100) DEFAULT NULL,
  `mp_group_id` int(10) unsigned DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `count` int(10) unsigned DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
