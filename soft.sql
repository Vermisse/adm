-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        10.1.13-MariaDB - mariadb.org binary distribution
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.1.0.4867
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 db 的数据库结构
CREATE DATABASE IF NOT EXISTS `db` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `db`;


-- 导出  表 db.product 结构
CREATE TABLE IF NOT EXISTS `product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) NOT NULL,
  `product_price` double NOT NULL,
  `description` longtext NOT NULL,
  `feature` longtext NOT NULL,
  `price_description` longtext NOT NULL,
  `notice` longtext NOT NULL,
  `create_date` date NOT NULL,
  `filepath` varchar(50) NOT NULL,
  `state` int(11) NOT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品表';

-- 正在导出表  db.product 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
/*!40000 ALTER TABLE `product` ENABLE KEYS */;


-- 导出  表 db.sys_user 结构
CREATE TABLE IF NOT EXISTS `sys_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) NOT NULL COMMENT '账号',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `real_name` varchar(50) NOT NULL COMMENT '真实姓名',
  `mobile` varchar(50) NOT NULL COMMENT '电话号码',
  `invite_id` int(11) DEFAULT NULL,
  `status` int(11) NOT NULL COMMENT '状态：1-启用、0-停用',
  `create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_name` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- 正在导出表  db.sys_user 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` (`user_id`, `user_name`, `password`, `real_name`, `mobile`, `invite_id`, `status`, `create_date`) VALUES
	(1, 'admin', '7003d55bebfea70262236628298f4b57', '超级管理员', '15645155210', NULL, 1, NULL),
	(2, '123', '123', '用户', '11111111111', NULL, 2, '2017-08-06 22:14:29'),
	(3, '321', '313', '用户', '12312312312', NULL, 2, '2017-08-07 22:28:26');
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;


-- 导出  表 db.tb_hotel_order 结构
CREATE TABLE IF NOT EXISTS `tb_hotel_order` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userName` varchar(200) DEFAULT NULL COMMENT '联系人名字，默认注册人',
  `userTel` varchar(200) DEFAULT NULL COMMENT '联系电话，默认注册人的',
  `peopleNum` varchar(50) NOT NULL COMMENT '人数',
  `address` varchar(200) DEFAULT NULL COMMENT '入住地址',
  `checkStartTime` varchar(200) DEFAULT NULL COMMENT '入住开始时间',
  `checkEndTime` varchar(200) DEFAULT NULL COMMENT '入住结束时间',
  `createTime` varchar(50) DEFAULT NULL COMMENT '创建时间',
  `updateTime` varchar(50) DEFAULT '' COMMENT '上次修改时间',
  `state` int(1) unsigned NOT NULL COMMENT '0初始值；1未沟通；2已沟通；3未成单；4已成单；',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='酒店订单表';

-- 正在导出表  db.tb_hotel_order 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `tb_hotel_order` DISABLE KEYS */;
INSERT INTO `tb_hotel_order` (`id`, `userName`, `userTel`, `peopleNum`, `address`, `checkStartTime`, `checkEndTime`, `createTime`, `updateTime`, `state`) VALUES
	(1, '于志强', '15045133902', '3', '大庆', '2017-08-06 18:42:00', '2017-08-08 18:42:00', '2017-08-6 18:42:00', '2017-08-06 21:25:22', 2);
/*!40000 ALTER TABLE `tb_hotel_order` ENABLE KEYS */;


-- 导出  表 db.tb_hotel_order_detail 结构
CREATE TABLE IF NOT EXISTS `tb_hotel_order_detail` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `o_id` int(11) unsigned zerofill NOT NULL COMMENT 'tb_hotel_order表ID',
  `checkName` varchar(50) DEFAULT NULL,
  `checkTel` varchar(50) DEFAULT NULL,
  `createTime` varchar(50) DEFAULT NULL COMMENT '创建时间',
  `updateTIme` varchar(50) DEFAULT NULL COMMENT '上次修改时间',
  `state` int(1) unsigned NOT NULL COMMENT '0正常；1删除；',
  PRIMARY KEY (`id`),
  KEY `o_id` (`o_id`),
  CONSTRAINT `o_id` FOREIGN KEY (`o_id`) REFERENCES `tb_hotel_order` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='酒店订单详情表';

-- 正在导出表  db.tb_hotel_order_detail 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `tb_hotel_order_detail` DISABLE KEYS */;
INSERT INTO `tb_hotel_order_detail` (`id`, `o_id`, `checkName`, `checkTel`, `createTime`, `updateTIme`, `state`) VALUES
	(1, 00000000001, '孙琪', '12345678901', '2017-08-06 16:54:00', '2017-08-06 16:54:00', 0);
/*!40000 ALTER TABLE `tb_hotel_order_detail` ENABLE KEYS */;


-- 导出  表 db.tb_train_order 结构
CREATE TABLE IF NOT EXISTS `tb_train_order` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userName` varchar(200) DEFAULT NULL COMMENT '联系人名字，默认注册人',
  `userTel` varchar(200) DEFAULT NULL COMMENT '联系电话，默认注册人的',
  `peopleNum` varchar(50) NOT NULL COMMENT '人数',
  `departurePlace` varchar(200) DEFAULT NULL COMMENT '出发地',
  `destination` varchar(200) DEFAULT NULL COMMENT '目的地',
  `checkStartTime` varchar(200) DEFAULT NULL COMMENT '出行开始时间',
  `checkEndTime` varchar(200) DEFAULT NULL COMMENT '出行结束时间',
  `createTime` varchar(50) DEFAULT NULL COMMENT '创建时间',
  `updateTime` varchar(50) DEFAULT '' COMMENT '上次修改时间',
  `state` int(1) unsigned NOT NULL COMMENT '0初始值；1未沟通；2已沟通；3未成单；4已成单；',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='直通车订单表';

-- 正在导出表  db.tb_train_order 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `tb_train_order` DISABLE KEYS */;
INSERT INTO `tb_train_order` (`id`, `userName`, `userTel`, `peopleNum`, `departurePlace`, `destination`, `checkStartTime`, `checkEndTime`, `createTime`, `updateTime`, `state`) VALUES
	(14, '于志强', '15045133902', '2017-08-07 08:6:00', '哈尔滨', '北京', '2017-08-07 08:6:00', '2017-08-07 08:6:00', '2017-08-07 08:6:00', '2017-08-07 08:22:47', 3);
/*!40000 ALTER TABLE `tb_train_order` ENABLE KEYS */;


-- 导出  表 db.tb_train_order_detail 结构
CREATE TABLE IF NOT EXISTS `tb_train_order_detail` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `t_id` int(11) unsigned NOT NULL COMMENT 'tb_train_order表ID',
  `cardId` varchar(50) DEFAULT NULL COMMENT '身份证号',
  `checkName` varchar(50) DEFAULT NULL,
  `checkTel` varchar(50) DEFAULT NULL,
  `createTime` varchar(50) DEFAULT NULL COMMENT '创建时间',
  `updateTIme` varchar(50) DEFAULT NULL COMMENT '上次修改时间',
  `state` int(1) unsigned NOT NULL COMMENT '0正常；1删除；',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='直通车订单详情表';

-- 正在导出表  db.tb_train_order_detail 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `tb_train_order_detail` DISABLE KEYS */;
INSERT INTO `tb_train_order_detail` (`id`, `t_id`, `cardId`, `checkName`, `checkTel`, `createTime`, `updateTIme`, `state`) VALUES
	(14, 14, '230606199202152059', '于志强', '15045133902', '2017-08-07 08:18:00', '2017-08-07 08:18:00', 0);
/*!40000 ALTER TABLE `tb_train_order_detail` ENABLE KEYS */;


-- 导出  表 db.tb_visa_order 结构
CREATE TABLE IF NOT EXISTS `tb_visa_order` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userName` varchar(200) DEFAULT NULL COMMENT '联系人名字，默认注册人',
  `userTel` varchar(200) DEFAULT NULL COMMENT '联系电话，默认注册人的',
  `peopleNum` varchar(50) NOT NULL COMMENT '人数',
  `address` varchar(200) DEFAULT NULL COMMENT '入住地址',
  `checkStartTime` varchar(200) DEFAULT NULL COMMENT '入住开始时间',
  `checkEndTime` varchar(200) DEFAULT NULL COMMENT '入住结束时间',
  `createTime` varchar(50) DEFAULT NULL COMMENT '创建时间',
  `updateTime` varchar(50) DEFAULT '' COMMENT '上次修改时间',
  `state` int(1) unsigned NOT NULL COMMENT '0初始值；1未沟通；2已沟通；3未成单；4已成单；',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='酒店订单表';

-- 正在导出表  db.tb_visa_order 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `tb_visa_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_visa_order` ENABLE KEYS */;


-- 导出  表 db.tb_visa_order_detail 结构
CREATE TABLE IF NOT EXISTS `tb_visa_order_detail` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `v_id` int(10) unsigned NOT NULL COMMENT 'tb_visa_order表id',
  `checkName` varchar(50) DEFAULT NULL,
  `checkTel` varchar(50) DEFAULT NULL,
  `createTime` varchar(50) DEFAULT NULL COMMENT '创建时间',
  `updateTIme` varchar(50) DEFAULT NULL COMMENT '上次修改时间',
  `state` int(1) unsigned NOT NULL COMMENT '0正常；1删除；',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='酒店订单详情表';

-- 正在导出表  db.tb_visa_order_detail 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `tb_visa_order_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_visa_order_detail` ENABLE KEYS */;


-- 导出  表 db.tickets 结构
CREATE TABLE IF NOT EXISTS `tickets` (
  `ticket_id` int(11) NOT NULL AUTO_INCREMENT,
  `ticket_name` varchar(50) NOT NULL,
  `ticket_price` double NOT NULL,
  `filepath` varchar(50) NOT NULL,
  `state` int(11) NOT NULL,
  `create_date` date NOT NULL,
  PRIMARY KEY (`ticket_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='门票';

-- 正在导出表  db.tickets 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `tickets` DISABLE KEYS */;
/*!40000 ALTER TABLE `tickets` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
