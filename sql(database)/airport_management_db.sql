-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Oct 27, 2022 at 11:37 PM
-- Server version: 5.7.36
-- PHP Version: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `airport_management_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `auser`
--

DROP TABLE IF EXISTS `auser`;
CREATE TABLE IF NOT EXISTS `auser` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_2cewcn54usplgepxj770laf80` (`email`),
  UNIQUE KEY `UK_2chfuw1dhlsi3ej5w1olfsmx9` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `auser`
--

INSERT INTO `auser` (`id`, `email`, `password`, `username`) VALUES
(1, 'rustymabiala150@gmail.com', '$2a$10$RkEKTW1wK5FxRxCU9JCba.PbEkKEgj.Ezi1/uaCeX.dXlHJO.JC4q', 'Adecel');

-- --------------------------------------------------------

--
-- Table structure for table `contact`
--

DROP TABLE IF EXISTS `contact`;
CREATE TABLE IF NOT EXISTS `contact` (
  `id` int(11) NOT NULL,
  `contact` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `contact`
--

INSERT INTO `contact` (`id`, `contact`, `description`) VALUES
(16, '0814424939', 'telckom Lufthansa ');

-- --------------------------------------------------------

--
-- Table structure for table `contact_type`
--

DROP TABLE IF EXISTS `contact_type`;
CREATE TABLE IF NOT EXISTS `contact_type` (
  `id` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `phone_number` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_5xjgrp4j0xhrqma5332cus4yp` (`email`),
  UNIQUE KEY `UK_duagpaqjrt1rdy1qydcpscopx` (`phone_number`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `flight`
--

DROP TABLE IF EXISTS `flight`;
CREATE TABLE IF NOT EXISTS `flight` (
  `id` varchar(255) NOT NULL,
  `arrival_date_and_time` varchar(255) NOT NULL,
  `departure_date_and_time` varchar(255) NOT NULL,
  `departure_location` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `plane_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7p9fvp6d7uh9cgn47uet8a8nb` (`plane_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `flight`
--

INSERT INTO `flight` (`id`, `arrival_date_and_time`, `departure_date_and_time`, `departure_location`, `description`, `plane_id`) VALUES
('2', '10-10-2022', '11-10-2022', 'Cape Town', 'to Libreville', 10),
('9', '11-10-2022', '10-10-2022', 'Paris', 'to Cape Town', 12);

-- --------------------------------------------------------

--
-- Table structure for table `flight_line`
--

DROP TABLE IF EXISTS `flight_line`;
CREATE TABLE IF NOT EXISTS `flight_line` (
  `id` int(11) NOT NULL,
  `departure` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `flight_line`
--

INSERT INTO `flight_line` (`id`, `departure`, `description`) VALUES
(2, 'Paris Charles de Gaulle Airport', '5h of Flight '),
(3, 'Cape Town International Airport', '3h of Flight '),
(4, 'O.R. Tambo International Airport', '1h-30 of Flight '),
(5, 'King Shaka International Airport', '1h-30 of Flight '),
(6, 'Cape Town International Airport', '2h-30 of Flight '),
(7, 'Cape Town International Airport', '4h of Flight '),
(8, 'Chubu Centrair International Airport', '5h-30 of Flight '),
(9, 'Robert Gabriel Mugabe International Airport', '3h of Flight '),
(25, 'Cape Town International Airport', '4h of Flight ');

-- --------------------------------------------------------

--
-- Table structure for table `flight_pilot`
--

DROP TABLE IF EXISTS `flight_pilot`;
CREATE TABLE IF NOT EXISTS `flight_pilot` (
  `id` varchar(255) NOT NULL,
  `date` varchar(255) NOT NULL,
  `flight_id` varchar(255) NOT NULL,
  `user_id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(29);

-- --------------------------------------------------------

--
-- Table structure for table `hostess`
--

DROP TABLE IF EXISTS `hostess`;
CREATE TABLE IF NOT EXISTS `hostess` (
  `id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `middle_name` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hostess`
--

INSERT INTO `hostess` (`id`, `description`, `gender`, `first_name`, `last_name`, `middle_name`, `phone_number`) VALUES
(26, 'plane from bville', 'Male', 'Adecel', 'Mabiala', 'Rusty', '+27813623440'),
(28, 'Hotess togo', 'Femele', 'Vie-Sainte', 'Matoumona', 'Gil', '+22813623440');

-- --------------------------------------------------------

--
-- Table structure for table `line`
--

DROP TABLE IF EXISTS `line`;
CREATE TABLE IF NOT EXISTS `line` (
  `flight_line_id` varchar(255) NOT NULL,
  `flight_id` varchar(255) NOT NULL,
  PRIMARY KEY (`flight_line_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `pilot`
--

DROP TABLE IF EXISTS `pilot`;
CREATE TABLE IF NOT EXISTS `pilot` (
  `id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `middle_name` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pilot`
--

INSERT INTO `pilot` (`id`, `description`, `gender`, `first_name`, `last_name`, `middle_name`, `phone_number`) VALUES
(20, 'Capitaine', 'Male', 'Adecel', 'Mabiala', 'Rusty', '+27813623440'),
(21, 'Co-Pilot', 'Male', 'Aaron', 'Kissimba', 'Nyembo', '+27603662794'),
(22, 'Hotess military', 'Femele', 'Julie', 'Lolo', NULL, '0814326740'),
(24, 'pilot capitaine', 'Male', 'Tawfeeq', 'Cupido', 'Eric', '09145034189');

-- --------------------------------------------------------

--
-- Table structure for table `plane`
--

DROP TABLE IF EXISTS `plane`;
CREATE TABLE IF NOT EXISTS `plane` (
  `id` int(11) NOT NULL,
  `capacity` varchar(255) NOT NULL,
  `model` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `plane`
--

INSERT INTO `plane` (`id`, `capacity`, `model`, `name`) VALUES
(10, ' 372 passengers', 'Airbus A340-500', 'Emirates'),
(11, '350 passengers', 'Airbus A350-900', 'lufthansa'),
(12, '440 passengers', 'Boeing 777-200', 'British Airways'),
(13, '380 passengers', 'Airbus A340-600', 'Lufthansa '),
(14, '550 passengers', 'Boeing 777-300', 'Emirates');

-- --------------------------------------------------------

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
CREATE TABLE IF NOT EXISTS `ticket` (
  `id` varchar(255) NOT NULL,
  `flight_line_id` varchar(255) NOT NULL,
  `luggage` varchar(255) NOT NULL,
  `price` varchar(255) NOT NULL,
  `seat_number` varchar(255) NOT NULL,
  `user_id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ticket`
--

INSERT INTO `ticket` (`id`, `flight_line_id`, `luggage`, `price`, `seat_number`, `user_id`) VALUES
('1', '1', '1', '1', '1', '1');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `middle_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `description`, `gender`, `first_name`, `last_name`, `middle_name`) VALUES
(17, 'Luggage', 'male', 'Adecel', 'Mabiala', 'Rusty'),
(19, 'Emirates Employee', 'femele', 'Hilary', 'Nguepi Nangmo', 'Cassidy');

-- --------------------------------------------------------

--
-- Table structure for table `user_category`
--

DROP TABLE IF EXISTS `user_category`;
CREATE TABLE IF NOT EXISTS `user_category` (
  `id` int(11) NOT NULL,
  `description` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_category`
--

INSERT INTO `user_category` (`id`, `description`, `name`) VALUES
(1, 'employee on luggage', 'Eddie');

-- --------------------------------------------------------

--
-- Table structure for table `user_contact`
--

DROP TABLE IF EXISTS `user_contact`;
CREATE TABLE IF NOT EXISTS `user_contact` (
  `id` int(11) NOT NULL,
  `date` varchar(255) NOT NULL,
  `contact_id` int(11) DEFAULT NULL,
  `contact_type_id` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2pm3m3m7xlwh9nfca4wvgpnwb` (`contact_id`),
  KEY `FK5675v4dlmo8s1rg6t50lrgga4` (`contact_type_id`),
  KEY `FK9fm1vrfyjcs735xlykhnedyd7` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_contact`
--

INSERT INTO `user_contact` (`id`, `date`, `contact_id`, `contact_type_id`, `user_id`) VALUES
(2, '20-06-2020', 16, NULL, 19);

-- --------------------------------------------------------

--
-- Table structure for table `user_type`
--

DROP TABLE IF EXISTS `user_type`;
CREATE TABLE IF NOT EXISTS `user_type` (
  `user_id` varchar(255) NOT NULL,
  `user_category_id` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `flight`
--
ALTER TABLE `flight`
  ADD CONSTRAINT `FK7p9fvp6d7uh9cgn47uet8a8nb` FOREIGN KEY (`plane_id`) REFERENCES `plane` (`id`);

--
-- Constraints for table `user_contact`
--
ALTER TABLE `user_contact`
  ADD CONSTRAINT `FK2pm3m3m7xlwh9nfca4wvgpnwb` FOREIGN KEY (`contact_id`) REFERENCES `contact` (`id`),
  ADD CONSTRAINT `FK5675v4dlmo8s1rg6t50lrgga4` FOREIGN KEY (`contact_type_id`) REFERENCES `contact_type` (`id`),
  ADD CONSTRAINT `FK9fm1vrfyjcs735xlykhnedyd7` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
