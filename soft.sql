-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        10.2.7-MariaDB - mariadb.org binary distribution
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
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
  `user_name` varchar(50) NOT NULL DEFAULT '0' COMMENT '账号',
  `password` varchar(50) NOT NULL DEFAULT '0' COMMENT '密码',
  `real_name` varchar(50) NOT NULL DEFAULT '0' COMMENT '真实姓名',
  `mobile` varchar(50) NOT NULL DEFAULT '0' COMMENT '电话号码',
  `group_id` int(11) NOT NULL DEFAULT 0 COMMENT '角色',
  `status` int(11) NOT NULL DEFAULT 0 COMMENT '状态：1-启用、0-停用',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_name` (`user_name`),
  KEY `FK__sys_group` (`group_id`),
  CONSTRAINT `FK__sys_group` FOREIGN KEY (`group_id`) REFERENCES `sys_group` (`group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- 正在导出表  db.sys_user 的数据：~1 rows (大约)
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` (`user_id`, `user_name`, `password`, `real_name`, `mobile`, `group_id`, `status`) VALUES
	(1, 'admin', '7003d55bebfea70262236628298f4b57', '超级管理员', '15645155210', 1, 1);
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;

-- 导出  表 db.tickets 结构
CREATE TABLE IF NOT EXISTS `tickets` (
  `ticket_id` int(11) NOT NULL AUTO_INCREMENT,
  `ticket_name` varchar(50) NOT NULL,
  `ticket_price` double NOT NULL,
  `filepath` varchar(50) NOT NULL,
  `state` int(11) NOT NULL,
  `create_date` date NOT NULL,
  PRIMARY KEY (`ticket_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='门票';

-- 正在导出表  db.tickets 的数据：~1 rows (大约)
/*!40000 ALTER TABLE `tickets` DISABLE KEYS */;
/*!40000 ALTER TABLE `tickets` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
