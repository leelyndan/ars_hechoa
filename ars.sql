# Host: 127.0.0.1  (Version: 5.7.3-m13)
# Date: 2014-08-19 17:58:27
# Generator: MySQL-Front 5.3  (Build 4.89)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "plane_info"
#

DROP TABLE IF EXISTS `plane_info`;
CREATE TABLE `plane_info` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `flight` varchar(255) DEFAULT NULL,
  `departure_airport` varchar(255) DEFAULT NULL,
  `arrival_airport` varchar(255) DEFAULT NULL,
  `first_class` varchar(255) DEFAULT NULL,
  `business_class` varchar(255) DEFAULT NULL,
  `economy_class` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "plane_info"
#

INSERT INTO `plane_info` VALUES (1,'A100','Xi\'an','Incheon','4000','3000','2000'),(2,'A101','Xi\'an','Incheon','4000','3000','2000'),(3,'A102','Xi\'an','Incheon','4000','3000','2000'),(4,'A100','Incheon','Xi\'an','4000','3000','1500'),(5,'A101','Incheon','Xi\'an','4000','3000','1500'),(6,'A102','Incheon','Xi\'an','4000','3000','1500');

#
# Structure for table "plane_time"
#

DROP TABLE IF EXISTS `plane_time`;
CREATE TABLE `plane_time` (
  `Id` int(11) NOT NULL,
  `time` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "plane_time"
#

INSERT INTO `plane_time` VALUES (1,'10:00'),(1,'14:00'),(2,'15:00'),(2,'19:00'),(3,'20:00'),(3,'24:00'),(4,'18:00'),(4,'20:30'),(5,'09:00'),(5,'11:30'),(6,'12:00'),(6,'14:30');

#
# Structure for table "reservation_info"
#

DROP TABLE IF EXISTS `reservation_info`;
CREATE TABLE `reservation_info` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `plane_id` varchar(255) DEFAULT NULL,
  `depart_date` varchar(255) DEFAULT NULL,
  `depart_time` varchar(255) DEFAULT NULL,
  `passenger_adult` varchar(255) DEFAULT NULL,
  `passenger_child` varchar(255) DEFAULT NULL,
  `seat_class` varchar(255) DEFAULT NULL,
  `payment` varchar(255) DEFAULT NULL,
  `total` varchar(255) DEFAULT NULL,
  `change` varchar(255) DEFAULT NULL,
  `reservation_number` varchar(255) DEFAULT NULL,
  `promotion_price` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

#
# Data for table "reservation_info"
#

