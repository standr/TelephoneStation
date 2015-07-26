-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               5.6.11 - MySQL Community Server (GPL)
-- ОС Сервера:                   Win64
-- HeidiSQL Версия:              8.0.0.4396
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Дамп структуры базы данных telephone_station
DROP DATABASE IF EXISTS `telephone_station`;
CREATE DATABASE IF NOT EXISTS `telephone_station` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `telephone_station`;


-- Дамп структуры для таблица telephone_station.account
DROP TABLE IF EXISTS `account`;
CREATE TABLE IF NOT EXISTS `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account_status_id` int(11) NOT NULL,
  `balance` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`,`account_status_id`),
  KEY `fk_account_account_status1_idx` (`account_status_id`),
  CONSTRAINT `fk_account_account_status1` FOREIGN KEY (`account_status_id`) REFERENCES `account_status` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы telephone_station.account: ~0 rows (приблизительно)
DELETE FROM `account`;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
/*!40000 ALTER TABLE `account` ENABLE KEYS */;


-- Дамп структуры для таблица telephone_station.account_status
DROP TABLE IF EXISTS `account_status`;
CREATE TABLE IF NOT EXISTS `account_status` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `status_UNIQUE` (`status`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы telephone_station.account_status: ~0 rows (приблизительно)
DELETE FROM `account_status`;
/*!40000 ALTER TABLE `account_status` DISABLE KEYS */;
INSERT INTO `account_status` (`id`, `status`) VALUES
	(1, 'ACTIVE'),
	(2, 'BLOCKED'),
	(3, 'UNCONFIRMED');
/*!40000 ALTER TABLE `account_status` ENABLE KEYS */;


-- Дамп структуры для таблица telephone_station.role
DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `role_name_UNIQUE` (`role_name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы telephone_station.role: ~0 rows (приблизительно)
DELETE FROM `role`;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`id`, `role_name`) VALUES
	(2, 'ADMIN'),
	(1, 'USER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;


-- Дамп структуры для таблица telephone_station.service
DROP TABLE IF EXISTS `service`;
CREATE TABLE IF NOT EXISTS `service` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `service_name` varchar(45) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `duration` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `service_name_UNIQUE` (`service_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы telephone_station.service: ~0 rows (приблизительно)
DELETE FROM `service`;
/*!40000 ALTER TABLE `service` DISABLE KEYS */;
/*!40000 ALTER TABLE `service` ENABLE KEYS */;


-- Дамп структуры для таблица telephone_station.service_account
DROP TABLE IF EXISTS `service_account`;
CREATE TABLE IF NOT EXISTS `service_account` (
  `service_id` int(11) NOT NULL,
  `account_id` int(11) NOT NULL,
  PRIMARY KEY (`service_id`,`account_id`),
  KEY `fk_service_has_account_account1_idx` (`account_id`),
  KEY `fk_service_has_account_service1_idx` (`service_id`),
  CONSTRAINT `fk_service_has_account_service1` FOREIGN KEY (`service_id`) REFERENCES `service` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_service_has_account_account1` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы telephone_station.service_account: ~0 rows (приблизительно)
DELETE FROM `service_account`;
/*!40000 ALTER TABLE `service_account` DISABLE KEYS */;
/*!40000 ALTER TABLE `service_account` ENABLE KEYS */;


-- Дамп структуры для таблица telephone_station.subscriber
DROP TABLE IF EXISTS `subscriber`;
CREATE TABLE IF NOT EXISTS `subscriber` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `account_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id_UNIQUE` (`user_id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_subscriber_user1_idx` (`user_id`),
  KEY `fk_subscriber_account1_idx` (`account_id`),
  CONSTRAINT `fk_subscriber_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_subscriber_account1` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы telephone_station.subscriber: ~0 rows (приблизительно)
DELETE FROM `subscriber`;
/*!40000 ALTER TABLE `subscriber` DISABLE KEYS */;
/*!40000 ALTER TABLE `subscriber` ENABLE KEYS */;


-- Дамп структуры для таблица telephone_station.user
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `login_UNIQUE` (`login`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `fk_user_role1_idx` (`role_id`),
  CONSTRAINT `fk_user_role1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы telephone_station.user: ~0 rows (приблизительно)
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `login`, `password`, `email`, `role_id`) VALUES
	(1, 'admin', 'admin123', 'admin@admin123', 2);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
