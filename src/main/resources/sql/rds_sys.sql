/*
SQLyog Ultimate v12.5.0 (64 bit)
MySQL - 5.6.41 : Database - rds_sys
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`rds_sys` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `rds_sys`;

/*Table structure for table `dict_item` */

DROP TABLE IF EXISTS `dict_item`;

CREATE TABLE `dict_item` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `type_id` bigint(11) DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `sort` int(10) DEFAULT '0' COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `dict_item` */

insert  into `dict_item`(`id`,`type_id`,`code`,`name`,`sort`) values 
(1,1,'byf','搬运费',0);

/*Table structure for table `dict_type` */

DROP TABLE IF EXISTS `dict_type`;

CREATE TABLE `dict_type` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `status` int(10) DEFAULT '0' COMMENT '状态(0:可用,1:不可用)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `dict_type` */

insert  into `dict_type`(`id`,`code`,`name`,`status`) values 
(1,'invoice_tupe','发票类型',0);

/*Table structure for table `invoice_detail` */

DROP TABLE IF EXISTS `invoice_detail`;

CREATE TABLE `invoice_detail` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(100) DEFAULT NULL COMMENT '票据\n编号',
  `ticket_user` bigint(11) DEFAULT NULL COMMENT '交票人',
  `ticket_name` varchar(100) DEFAULT NULL COMMENT '交票人名称',
  `card_user` bigint(11) DEFAULT NULL COMMENT '持卡人',
  `card_name` varchar(50) DEFAULT NULL COMMENT '持卡人名称',
  `card_num` varchar(100) DEFAULT NULL COMMENT '卡号',
  `consume_time` datetime DEFAULT NULL COMMENT '消费时间',
  `card_money` decimal(10,2) DEFAULT NULL COMMENT '公务卡金额',
  `cash_money` decimal(10,2) DEFAULT NULL COMMENT '现金金额(无小票)',
  `cash_subsidy` decimal(10,2) DEFAULT NULL COMMENT '现金补助费',
  `responsible_user` bigint(20) DEFAULT NULL COMMENT '出差补助费负责人id',
  `responsible_name` varchar(100) DEFAULT NULL COMMENT '出差补助费负责人名称',
  `invoice_type_id` bigint(11) DEFAULT NULL COMMENT '发票类型id',
  `invoice_type` varchar(100) DEFAULT NULL COMMENT '发票类型',
  `month` varchar(100) DEFAULT NULL COMMENT '计算月份',
  `summary` varchar(255) DEFAULT NULL COMMENT '摘要',
  `refund` varchar(25) DEFAULT NULL COMMENT '退票',
  `receiving_time` datetime DEFAULT NULL COMMENT '到账时间',
  `received_time` datetime DEFAULT NULL COMMENT '收票时间',
  `account_time` datetime DEFAULT NULL COMMENT '报账时间',
  `purpose` varchar(255) DEFAULT NULL COMMENT '开支用途',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `invoice_detail` */

insert  into `invoice_detail`(`id`,`number`,`ticket_user`,`ticket_name`,`card_user`,`card_name`,`card_num`,`consume_time`,`card_money`,`cash_money`,`cash_subsidy`,`responsible_user`,`responsible_name`,`invoice_type_id`,`invoice_type`,`month`,`summary`,`refund`,`receiving_time`,`received_time`,`account_time`,`purpose`,`remark`,`create_time`,`update_time`) values 
(3,'2',NULL,'李新权',NULL,'李新权','6282880052216562','2018-10-02 11:20:50',200.00,2801.00,200.00,NULL,'2',NULL,'住宿费','3','2','2','2018-10-19 16:22:18','1970-01-01 08:00:00','1970-01-01 08:00:00','2','2',NULL,NULL),
(4,'33',NULL,'李新权',NULL,'李新权','6282880052216562','2018-10-05 11:23:38',380.00,380.00,381.00,NULL,'31',NULL,'车费','3','3','3','2018-10-19 11:23:46','2018-10-19 11:23:48','2018-10-19 11:23:49','3','3',NULL,NULL),
(5,'32',NULL,'丘剑平',NULL,'丘剑平','6282880052296569','2018-10-05 11:23:38',300.00,3001.00,3003.00,NULL,'3',NULL,'3','3','3','3','2018-10-19 11:23:46','2018-10-19 11:23:48','2018-10-19 11:23:49','3','3',NULL,NULL),
(10,'22',NULL,'李新权',NULL,'李新权','6282880052216562','2018-10-19 16:39:51',10.00,10.00,0.00,NULL,'0',NULL,'车费','8','8','8','2018-10-19 16:40:03','2018-10-19 16:40:05','2018-10-19 16:40:06','8','8',NULL,NULL);

/*Table structure for table `org_user` */

DROP TABLE IF EXISTS `org_user`;

CREATE TABLE `org_user` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `user_num` varchar(50) DEFAULT NULL,
  `name` varchar(25) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `org_user` */

insert  into `org_user`(`id`,`user_num`,`name`,`create_time`) values 
(1,'9999','李永迈',NULL),
(2,'888','李新权',NULL),
(4,'333','丘剑平',NULL),
(5,'444','魏建忠',NULL),
(6,'555','刘晓辉',NULL),
(7,'666','666',NULL),
(8,'777','777',NULL),
(9,'888','888',NULL),
(10,'999','999',NULL),
(11,'10','10',NULL),
(12,'11','11',NULL);

/*Table structure for table `outtime` */

DROP TABLE IF EXISTS `outtime`;

CREATE TABLE `outtime` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `outtime` */

insert  into `outtime`(`id`,`user_id`,`date`,`create_time`,`update_time`) values 
(13,1,'2018-10-11 09:23:10','2018-10-18 09:23:30',NULL);

/*Table structure for table `overtime` */

DROP TABLE IF EXISTS `overtime`;

CREATE TABLE `overtime` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) DEFAULT NULL,
  `date` datetime DEFAULT NULL COMMENT '日期',
  `reason` varchar(255) DEFAULT NULL COMMENT '原因',
  `flag` tinyint(1) DEFAULT NULL COMMENT '0:上午，1下午',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;

/*Data for the table `overtime` */

insert  into `overtime`(`id`,`user_id`,`date`,`reason`,`flag`) values 
(61,1,'2018-10-29 00:00:00',NULL,0),
(62,1,'2018-10-30 00:00:00',NULL,1);

/*Table structure for table `sys_menu` */

DROP TABLE IF EXISTS `sys_menu`;

CREATE TABLE `sys_menu` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(64) NOT NULL COMMENT '资源名称',
  `url` varchar(100) DEFAULT NULL COMMENT '资源路径',
  `open_mode` varchar(32) DEFAULT NULL COMMENT '打开方式 ajax,iframe',
  `description` varchar(255) DEFAULT NULL COMMENT '资源介绍',
  `icon` varchar(32) DEFAULT NULL COMMENT '资源图标',
  `pid` bigint(19) DEFAULT NULL COMMENT '父级资源id',
  `seq` tinyint(2) NOT NULL DEFAULT '0' COMMENT '排序',
  `status` tinyint(2) NOT NULL DEFAULT '0' COMMENT '状态',
  `menu_type` tinyint(2) NOT NULL DEFAULT '0' COMMENT '资源类别',
  `is_leaf` tinyint(1) DEFAULT '0' COMMENT '是否是叶子',
  `resource_id` bigint(20) DEFAULT NULL COMMENT '资源id',
  `del_flag` tinyint(1) DEFAULT '0' COMMENT '删除标记',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=250 DEFAULT CHARSET=utf8 COMMENT='资源';

/*Data for the table `sys_menu` */

insert  into `sys_menu`(`id`,`name`,`url`,`open_mode`,`description`,`icon`,`pid`,`seq`,`status`,`menu_type`,`is_leaf`,`resource_id`,`del_flag`,`update_time`,`create_time`) values 
(236,'系统管理','','0','','',NULL,0,0,0,1,NULL,0,'2017-01-08 03:33:16','2017-01-08 03:33:16'),
(237,'机构管理','','0','','',236,0,0,0,1,NULL,0,'2017-01-08 03:33:32','2017-01-08 03:33:32'),
(238,'权限管理','','0','','',236,0,0,0,1,NULL,0,'2017-01-08 03:38:43','2017-01-08 03:38:43'),
(239,'机构列表','/sys/orgs/ui/list','0','','',237,0,0,0,1,NULL,0,'2017-01-10 21:13:09','2017-01-08 03:38:56'),
(240,'用户列表','/sys/users/ui/list','0','','',237,0,0,0,0,NULL,0,'2017-01-10 21:14:55','2017-01-08 03:39:08'),
(242,'列表','','0','','',239,0,0,1,0,NULL,0,'2017-01-10 16:23:51','2017-01-08 10:22:24'),
(244,'增加','','0','','',239,1,0,1,0,NULL,0,'2017-01-08 10:23:19','2017-01-08 10:23:19'),
(245,'资源列表','/sys/resources/ui/list','0','','',238,0,0,0,0,NULL,0,'2017-01-10 22:59:30','2017-01-10 21:15:22'),
(246,'角色列表','/sys/roles/ui/list','0','','',238,0,0,0,0,NULL,0,'2017-01-10 21:16:15','2017-01-10 21:16:15'),
(247,'物业管理','','0','','',NULL,0,0,0,1,NULL,0,'2017-01-10 21:20:31','2017-01-10 21:20:31'),
(248,'小区管理','','0','','',247,0,0,0,1,NULL,0,'2017-01-10 21:20:48','2017-01-10 21:20:48'),
(249,'垃圾管理','','0','','',248,0,0,0,0,NULL,0,'2017-01-10 21:21:00','2017-01-10 21:21:00');

/*Table structure for table `sys_org` */

DROP TABLE IF EXISTS `sys_org`;

CREATE TABLE `sys_org` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(64) NOT NULL COMMENT '组织名',
  `address` varchar(100) DEFAULT NULL COMMENT '地址',
  `code` varchar(64) NOT NULL COMMENT '编号',
  `icon` varchar(32) DEFAULT NULL COMMENT '图标',
  `pid` bigint(19) DEFAULT NULL COMMENT '父级主键',
  `is_leaf` tinyint(1) DEFAULT '0' COMMENT '叶子节点',
  `seq` tinyint(2) NOT NULL DEFAULT '0' COMMENT '排序',
  `del_flag` tinyint(1) DEFAULT '0' COMMENT '删除标记',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 COMMENT='组织机构';

/*Data for the table `sys_org` */

insert  into `sys_org`(`id`,`name`,`address`,`code`,`icon`,`pid`,`is_leaf`,`seq`,`del_flag`,`update_time`,`create_time`) values 
(26,'竞远','','','',NULL,1,1,0,'2018-10-15 16:27:05','2017-01-06 12:37:12'),
(27,'事业部','','','',26,1,0,0,'2017-01-06 12:38:56','2017-01-06 12:37:26'),
(28,'开发部','','','',27,0,0,0,'2017-01-06 12:37:37','2017-01-06 12:37:37'),
(29,'产品部','','','',27,0,1,1,'2017-01-06 12:37:50','2017-01-06 12:37:50'),
(30,'售后部','','','',26,0,1,0,'2017-01-06 12:38:12','2017-01-06 12:38:12'),
(31,'产品部','','','',27,0,1,1,'2017-01-06 12:41:17','2017-01-06 12:41:17'),
(32,'产品部','','','',27,0,1,1,'2017-01-06 12:42:38','2017-01-06 12:42:38'),
(33,'产品部','','','',27,0,1,1,'2017-01-06 12:45:32','2017-01-06 12:45:32'),
(34,'系统开发','','','',NULL,0,0,0,'2017-04-21 15:32:00','2017-01-06 12:55:39'),
(35,'测试','','','',NULL,0,0,1,'2017-04-21 15:33:06','2017-04-21 15:33:06');

/*Table structure for table `sys_resource` */

DROP TABLE IF EXISTS `sys_resource`;

CREATE TABLE `sys_resource` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(64) NOT NULL COMMENT '资源名称',
  `url` varchar(100) DEFAULT NULL COMMENT '资源路径',
  `open_mode` varchar(32) DEFAULT NULL COMMENT '打开方式 ajax,iframe',
  `description` varchar(255) DEFAULT NULL COMMENT '资源介绍',
  `icon` varchar(100) DEFAULT NULL COMMENT '资源图标',
  `pid` bigint(19) DEFAULT NULL COMMENT '父级资源id',
  `seq` tinyint(2) NOT NULL DEFAULT '0' COMMENT '排序',
  `status` tinyint(2) NOT NULL DEFAULT '0' COMMENT '状态',
  `resource_type` tinyint(2) NOT NULL DEFAULT '0' COMMENT '资源类别',
  `is_leaf` tinyint(1) DEFAULT '0' COMMENT '是否是叶子',
  `del_flag` tinyint(1) DEFAULT '0' COMMENT '删除标记',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=256 DEFAULT CHARSET=utf8 COMMENT='资源';

/*Data for the table `sys_resource` */

insert  into `sys_resource`(`id`,`name`,`url`,`open_mode`,`description`,`icon`,`pid`,`seq`,`status`,`resource_type`,`is_leaf`,`del_flag`,`update_time`,`create_time`) values 
(236,'系统管理','','0','','/resources/images/32x32/settings.png',NULL,1,0,0,1,0,'2017-05-22 22:51:03','2017-01-08 03:33:16'),
(237,'机构管理','','0','','/resources/images/32x32/1-1.png',236,0,0,0,1,0,'2017-05-22 22:39:11','2017-01-08 03:33:32'),
(238,'权限管理','','0','','/resources/images/32x32/1-1.png',236,1,0,0,1,0,'2017-05-22 22:39:18','2017-01-08 03:38:43'),
(239,'机构列表','/sys/orgs/ui/list','0','','/resources/images/32x32/user.png',237,0,0,0,1,0,'2017-05-23 08:12:16','2017-01-08 03:38:56'),
(240,'用户列表','/sys/users/ui/list','0','','/resources/images/32x32/1-1.png',237,0,0,0,0,0,'2017-05-22 22:39:40','2017-01-08 03:39:08'),
(245,'资源列表','/sys/resources/ui/list','0','','/resources/images/32x32/graphic-design.png',238,0,0,0,0,0,'2017-05-23 08:19:42','2017-01-10 21:15:22'),
(246,'角色列表','/sys/roles/ui/list','0','','/resources/images/32x32/1-1.png',238,0,0,0,0,0,'2017-05-22 22:39:51','2017-01-10 21:16:15'),
(247,'直播管理','','0','','/resources/images/32x32/photography.png',NULL,0,0,0,1,0,'2017-05-22 22:55:36','2017-01-10 21:20:31'),
(248,'直播会员','','0','','/resources/images/32x32/sign-out.png',247,0,0,0,1,0,'2017-05-22 22:50:08','2017-01-10 21:20:48'),
(249,'用户管理','/live/users/ui/list','0','','/resources/images/32x32/1-1.png',248,0,0,0,0,0,'2017-05-22 22:40:00','2017-01-10 21:21:00'),
(250,'人员管理','','0','1','/resources/images/32x32/finished-work.png',NULL,0,0,0,1,0,'2018-10-15 16:44:04','2018-10-15 16:32:16'),
(252,'公司人员','org/user/list','0','','/resources/images/32x32/customers.png',255,1,0,0,0,0,'2018-10-16 11:43:08','2018-10-15 16:38:14'),
(253,'发票报销明细','/invoice/toView/list','0','','/resources/images/32x32/administrative-docs.png',255,2,0,0,0,0,'2018-10-18 12:11:38','2018-10-15 16:38:27'),
(254,'出差人员','/resources/images/32x32/1.png','0','','/resources/images/32x32/communication.png',255,3,0,0,0,0,'2018-10-15 16:43:28','2018-10-15 16:38:47'),
(255,'人员管理','','0','','/resources/images/32x32/busy.png',250,0,0,0,1,0,'2018-10-15 16:45:17','2018-10-15 16:43:07');

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(64) NOT NULL COMMENT '角色名',
  `seq` tinyint(2) NOT NULL DEFAULT '0' COMMENT '排序号',
  `description` varchar(255) DEFAULT NULL COMMENT '简介',
  `status` tinyint(2) NOT NULL DEFAULT '0' COMMENT '状态',
  `del_flag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='角色';

/*Data for the table `sys_role` */

insert  into `sys_role`(`id`,`name`,`seq`,`description`,`status`,`del_flag`,`update_time`,`create_time`) values 
(11,'系统管理员',0,'',0,0,'2017-01-08 17:30:37','2017-01-08 17:30:37'),
(14,'普通员工',1,'',0,NULL,NULL,NULL);

/*Table structure for table `sys_role_resource` */

DROP TABLE IF EXISTS `sys_role_resource`;

CREATE TABLE `sys_role_resource` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `role_id` bigint(19) NOT NULL COMMENT '角色id',
  `resource_id` bigint(19) NOT NULL COMMENT '资源id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=658 DEFAULT CHARSET=utf8 COMMENT='角色-资源';

/*Data for the table `sys_role_resource` */

insert  into `sys_role_resource`(`id`,`role_id`,`resource_id`) values 
(603,14,247),
(604,14,248),
(605,14,249),
(646,11,250),
(647,11,255),
(648,11,252),
(649,11,253),
(650,11,254),
(651,11,236),
(652,11,237),
(653,11,239),
(654,11,240),
(655,11,238),
(656,11,245),
(657,11,246);

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `login_name` varchar(64) NOT NULL COMMENT '登录名',
  `name` varchar(64) NOT NULL COMMENT '用户名',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `sex` tinyint(2) DEFAULT '0' COMMENT '性别',
  `age` tinyint(2) DEFAULT '0' COMMENT '年龄',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机号',
  `user_type` tinyint(2) DEFAULT '0' COMMENT '用户类别',
  `status` tinyint(2) DEFAULT '0' COMMENT '用户状态',
  `del_flag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8 COMMENT='用户';

/*Data for the table `sys_user` */

insert  into `sys_user`(`id`,`login_name`,`name`,`password`,`sex`,`age`,`phone`,`user_type`,`status`,`del_flag`,`update_time`,`create_time`) values 
(38,'admin','系统管理员','6ff3b18929bae1973fceaf16e8746f08',0,NULL,'',0,0,0,'2017-01-09 10:52:59','2017-01-09 10:52:59'),
(42,'test','测试','986b9372eaaa6adab68b024c0be2c7e3',0,NULL,'',0,0,0,'2017-01-16 21:46:39','2017-01-16 21:34:54'),
(43,'zhangsan','张三','9d79c1d574711267d68c738eee063336',0,21,'',0,0,0,'2018-10-15 16:29:04','2018-10-15 16:29:04');

/*Table structure for table `sys_user_org` */

DROP TABLE IF EXISTS `sys_user_org`;

CREATE TABLE `sys_user_org` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `org_id` bigint(20) DEFAULT NULL COMMENT '机构id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户-机构';

/*Data for the table `sys_user_org` */

insert  into `sys_user_org`(`id`,`user_id`,`org_id`) values 
(22,38,34),
(25,42,28),
(26,43,28);

/*Table structure for table `sys_user_role` */

DROP TABLE IF EXISTS `sys_user_role`;

CREATE TABLE `sys_user_role` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` bigint(19) NOT NULL COMMENT '用户id',
  `role_id` bigint(19) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='用户-角色';

/*Data for the table `sys_user_role` */

insert  into `sys_user_role`(`id`,`user_id`,`role_id`) values 
(4,38,11),
(7,42,14),
(8,43,14);

/*Table structure for table `vacationtime` */

DROP TABLE IF EXISTS `vacationtime`;

CREATE TABLE `vacationtime` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

/*Data for the table `vacationtime` */

insert  into `vacationtime`(`id`,`user_id`,`date`,`create_time`,`update_time`) values 
(18,1,'2018-10-02 18:09:27','2018-10-17 18:09:45',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
