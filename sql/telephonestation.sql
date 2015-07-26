-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               5.5.23 - MySQL Community Server (GPL)
-- ОС Сервера:                   Win32
-- HeidiSQL Версия:              8.3.0.4694
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Дамп структуры базы данных telephonestation
CREATE DATABASE IF NOT EXISTS `telephonestation` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `telephonestation`;


-- Дамп структуры для таблица telephonestation.account
CREATE TABLE IF NOT EXISTS `account` (
  `id` int(10) NOT NULL,
  `balance` int(20) DEFAULT NULL,
  `account_type_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `account_type_id` (`account_type_id`),
  CONSTRAINT `FK_user_account` FOREIGN KEY (`id`) REFERENCES `users` (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.


-- Дамп структуры для таблица telephonestation.account_service
CREATE TABLE IF NOT EXISTS `account_service` (
  `account_id` int(10) NOT NULL,
  `service_id` int(10) NOT NULL,
  PRIMARY KEY (`account_id`,`service_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.


-- Дамп структуры для таблица telephonestation.roles
CREATE TABLE IF NOT EXISTS `roles` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `number` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_user_role` FOREIGN KEY (`id`) REFERENCES `users` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.


-- Дамп структуры для таблица telephonestation.service
CREATE TABLE IF NOT EXISTS `service` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `price` int(20) DEFAULT NULL,
  `duration` time DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.


-- Дамп структуры для таблица telephonestation.typeofaccount
CREATE TABLE IF NOT EXISTS `typeofaccount` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_type_account` FOREIGN KEY (`id`) REFERENCES `account` (`account_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.


-- Дамп структуры для таблица telephonestation.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `login` varchar(13) DEFAULT '0',
  `first_name` varchar(40) DEFAULT '0',
  `last_name` varchar(40) DEFAULT '0',
  `password` varchar(40) DEFAULT '0',
  `account_id` int(10) DEFAULT '0',
  `role_id` int(10) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `login` (`login`),
  KEY `account_id` (`account_id`),
  KEY `role_id` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
