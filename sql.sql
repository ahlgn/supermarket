/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.27 : Database - supermarket
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`supermarket` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `supermarket`;

/*Table structure for table `tb_customer` */

DROP TABLE IF EXISTS `tb_customer`;

CREATE TABLE `tb_customer` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(16) NOT NULL,
  `sex` varchar(2) NOT NULL DEFAULT '男',
  `level` varchar(8) NOT NULL DEFAULT 'Lv1',
  `phone` varchar(11) NOT NULL,
  `address` varchar(20) NOT NULL DEFAULT '中国',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `tb_customer` */

insert  into `tb_customer`(`id`,`name`,`sex`,`level`,`phone`,`address`) values (1,'郭冬临','男','Lv6','12312341234','北京中南海'),(2,'蔡明','女','Lv5','12312341234','不知道在哪');

/*Table structure for table `tb_orders` */

DROP TABLE IF EXISTS `tb_orders`;

CREATE TABLE `tb_orders` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `product_name` varchar(30) DEFAULT NULL,
  `product_num` int(10) unsigned NOT NULL DEFAULT '1',
  `customer_name` varchar(16) NOT NULL,
  `unit_price` double unsigned NOT NULL,
  `total_price` double NOT NULL,
  `personnel_name` varchar(16) NOT NULL,
  `createtime` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10001016 DEFAULT CHARSET=utf8;

/*Data for the table `tb_orders` */

insert  into `tb_orders`(`id`,`product_name`,`product_num`,`customer_name`,`unit_price`,`total_price`,`personnel_name`,`createtime`) values (10001009,'智能手环V2',100,'郭冬临',100,10000,'测试新员工','2019-04-15'),(10001010,'智能手环V2',200,'郭冬临',100,20000,'测试员工2','2019-04-16'),(10001011,'智能手环V2',300,'郭冬临',100,30000,'测试员工3','2019-04-16'),(10001012,'未来手机',10,'郭冬临',10000,100000,'测试新员工','2019-04-17'),(10001013,'未来手机',20,'郭冬临',10000,200000,'测试员工2','2019-04-18'),(10001014,'智能上网本book13',20,'郭冬临',3500,70000,'测试员工3','2019-04-20'),(10001015,'智能手环V2',1,'郭冬临',100,100,'李庚南','2019-05-29');

/*Table structure for table `tb_personnel` */

DROP TABLE IF EXISTS `tb_personnel`;

CREATE TABLE `tb_personnel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(16) NOT NULL,
  `position` varchar(16) NOT NULL DEFAULT '员工',
  `phone` varchar(11) DEFAULT NULL,
  `Sales` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1008 DEFAULT CHARSET=utf8;

/*Data for the table `tb_personnel` */

insert  into `tb_personnel`(`id`,`name`,`position`,`phone`,`Sales`) values (1,'李庚南','销售总监','13605522888',100),(2,'刘林春','销售经理','12312341234',0),(3,'汪小乐','金牌销售','12312341234',0),(4,'汤正广','销售经理','12312341234',0),(5,'张志超','铜牌销售','12312341234',0),(6,'测试新员工','销售总监','123123',110000),(1006,'测试员工2','银牌销售','11',220000),(1007,'测试员工3','金牌销售','1123',100000);

/*Table structure for table `tb_product` */

DROP TABLE IF EXISTS `tb_product`;

CREATE TABLE `tb_product` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(16) NOT NULL,
  `stock` int(10) unsigned NOT NULL,
  `price` double unsigned NOT NULL,
  `message` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `tb_product` */

insert  into `tb_product`(`id`,`name`,`stock`,`price`,`message`) values (1,'智能手环V2',1399,100,'库存量不足'),(2,'智能上网本book13',1980,3500,'库存充足'),(3,'未来手机',1970,10000,'库存充足');

/*Table structure for table `tb_user` */

DROP TABLE IF EXISTS `tb_user`;

CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(12) NOT NULL,
  `password` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `tb_user` */

insert  into `tb_user`(`id`,`username`,`password`) values (1,'admin','admin'),(2,'李庚南','ligengnan'),(3,'李庚南','ligengnan'),(4,'张志超','zhangzhichao'),(5,'张志超','zhangzhichao');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
