CREATE DATABASE `employees` /*!40100 DEFAULT CHARACTER SET utf8 */;

CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `middle_initial` varchar(2) DEFAULT NULL,
  `last_name` varchar(45) NOT NULL,
  `date_of_birth` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
  `date_of_employment` timestamp(6) NOT NULL DEFAULT '0000-00-00 00:00:00.000000',
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
