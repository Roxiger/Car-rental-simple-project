-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 06, 2016 at 02:07 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `car_rental`
--

-- --------------------------------------------------------

--
-- Table structure for table `cars`
--

CREATE TABLE IF NOT EXISTS `cars` (
  `CAR_ID` int(11) NOT NULL AUTO_INCREMENT,
  `BRAND` varchar(30) NOT NULL,
  `MODEL` varchar(30) NOT NULL,
  `REG_NUM` varchar(10) NOT NULL,
  `Rate` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`CAR_ID`),
  UNIQUE KEY `REG_NUM` (`REG_NUM`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=23 ;

--
-- Dumping data for table `cars`
--

INSERT INTO `cars` (`CAR_ID`, `BRAND`, `MODEL`, `REG_NUM`, `Rate`) VALUES
(13, 'Peugeot', '406 Coupe', 'pb 4434 bp', 0),
(14, 'Peugeot', '306 gti6', 'pb 3244 bp', 1),
(16, 'Citroen', 'C4', 'bp 2323 pc', 0),
(17, 'Mercedes', 'S-Klasse', '999999', 0),
(18, 'Renault', 'Megane', 'PB 2323 bp', 0);

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE IF NOT EXISTS `customers` (
  `CUSTOMER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `FNAME` varchar(30) NOT NULL,
  `LNAME` varchar(30) NOT NULL,
  `ADDRESS` varchar(50) NOT NULL,
  PRIMARY KEY (`CUSTOMER_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=19 ;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`CUSTOMER_ID`, `FNAME`, `LNAME`, `ADDRESS`) VALUES
(15, 'Celia', 'Bellagha', 'Plovdiv, Bulgaria'),
(16, 'Ivan', 'Banchev', 'Plovdiv, Bulgaria'),
(17, 'Vero', 'Mechov', 'alabala 23'),
(18, 'Alex', 'Bancheva', 'fdsfdsfs 23, Maina');

-- --------------------------------------------------------

--
-- Table structure for table `rent`
--

CREATE TABLE IF NOT EXISTS `rent` (
  `RENT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CUSTOMER_ID` int(11) NOT NULL,
  `RENT_DATE` varchar(10) NOT NULL,
  `RETURN_DATE` varchar(10) NOT NULL,
  `CAR_ID` int(11) NOT NULL,
  PRIMARY KEY (`RENT_ID`),
  KEY `car_id` (`CAR_ID`),
  KEY `customer_id` (`CUSTOMER_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=48 ;

--
-- Dumping data for table `rent`
--

INSERT INTO `rent` (`RENT_ID`, `CUSTOMER_ID`, `RENT_DATE`, `RETURN_DATE`, `CAR_ID`) VALUES
(47, 18, '23.03.2016', 'never', 14);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `rent`
--
ALTER TABLE `rent`
  ADD CONSTRAINT `CARS` FOREIGN KEY (`CAR_ID`) REFERENCES `cars` (`CAR_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `car_id` FOREIGN KEY (`CAR_ID`) REFERENCES `cars` (`CAR_ID`) ON DELETE CASCADE,
  ADD CONSTRAINT `CUSTOMERS` FOREIGN KEY (`CUSTOMER_ID`) REFERENCES `customers` (`CUSTOMER_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `customer_id` FOREIGN KEY (`CUSTOMER_ID`) REFERENCES `customers` (`CUSTOMER_ID`) ON DELETE CASCADE,
  ADD CONSTRAINT `rent_ibfk_1` FOREIGN KEY (`CUSTOMER_ID`) REFERENCES `customers` (`CUSTOMER_ID`),
  ADD CONSTRAINT `rent_ibfk_2` FOREIGN KEY (`CUSTOMER_ID`) REFERENCES `customers` (`CUSTOMER_ID`),
  ADD CONSTRAINT `rent_ibfk_3` FOREIGN KEY (`CAR_ID`) REFERENCES `cars` (`CAR_ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
