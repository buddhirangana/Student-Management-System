-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Feb 05, 2020 at 02:58 AM
-- Server version: 5.7.24
-- PHP Version: 7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sms_database`
--

-- --------------------------------------------------------

--
-- Table structure for table `attendence`
--

DROP TABLE IF EXISTS `attendence`;
CREATE TABLE IF NOT EXISTS `attendence` (
  `Attenden_id` int(8) NOT NULL AUTO_INCREMENT,
  `Name` varchar(20) NOT NULL,
  `Course` varchar(10) NOT NULL,
  `Student_id` int(8) NOT NULL,
  `Date` date NOT NULL,
  `Attenden` char(10) NOT NULL,
  PRIMARY KEY (`Attenden_id`) USING BTREE,
  KEY `Student_id` (`Student_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `audit`
--

DROP TABLE IF EXISTS `audit`;
CREATE TABLE IF NOT EXISTS `audit` (
  `Audit_id` int(8) NOT NULL AUTO_INCREMENT,
  `User_id` int(8) NOT NULL,
  `Date` varchar(30) NOT NULL,
  `Status` varchar(60) NOT NULL,
  PRIMARY KEY (`Audit_id`),
  KEY `INDEX` (`User_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
CREATE TABLE IF NOT EXISTS `course` (
  `Course_id` varchar(30) NOT NULL,
  `Course_name` varchar(10) NOT NULL,
  `Start_date` varchar(20) NOT NULL,
  `Duration` varchar(15) NOT NULL,
  `Course_fee` varchar(10) NOT NULL,
  `Credits` int(11) NOT NULL,
  PRIMARY KEY (`Course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `eligible`
--

DROP TABLE IF EXISTS `eligible`;
CREATE TABLE IF NOT EXISTS `eligible` (
  `Eligible_id` int(8) NOT NULL AUTO_INCREMENT,
  `Student_id` int(8) NOT NULL,
  `Name` varchar(20) NOT NULL,
  `Presentage` int(11) NOT NULL,
  `Status` varchar(20) NOT NULL,
  PRIMARY KEY (`Eligible_id`),
  KEY `Student_id` (`Student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `lecturer`
--

DROP TABLE IF EXISTS `lecturer`;
CREATE TABLE IF NOT EXISTS `lecturer` (
  `Lecturer_id` varchar(11) NOT NULL,
  `Name` varchar(20) NOT NULL,
  `Dob` varchar(20) NOT NULL,
  `Gender` char(10) NOT NULL,
  `Telephone` varchar(10) NOT NULL,
  `Address1` varchar(30) NOT NULL,
  `Address2` varchar(30) NOT NULL,
  `Age` int(11) NOT NULL,
  PRIMARY KEY (`Lecturer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `marks`
--

DROP TABLE IF EXISTS `marks`;
CREATE TABLE IF NOT EXISTS `marks` (
  `Mark_id` int(8) NOT NULL AUTO_INCREMENT,
  `Name` varchar(20) NOT NULL,
  `Student_id` int(8) NOT NULL,
  `Course` varchar(10) NOT NULL,
  `Subject` varchar(25) NOT NULL,
  `Assign_status` char(5) NOT NULL,
  `Final_mark` int(5) NOT NULL,
  `Grade` varchar(5) NOT NULL,
  `Status` varchar(10) NOT NULL,
  PRIMARY KEY (`Mark_id`),
  KEY `Student_id` (`Student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `payments`
--

DROP TABLE IF EXISTS `payments`;
CREATE TABLE IF NOT EXISTS `payments` (
  `Payment_id` int(8) NOT NULL AUTO_INCREMENT,
  `Name` varchar(20) NOT NULL,
  `Student_id` int(8) NOT NULL,
  `Course` varchar(10) NOT NULL,
  `Reg_Fee` int(11) NOT NULL,
  `Course_Fee` int(11) NOT NULL,
  `Exam_Fee` int(11) NOT NULL,
  PRIMARY KEY (`Payment_id`),
  KEY `Student_id` (`Student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
CREATE TABLE IF NOT EXISTS `student` (
  `Student_id` int(8) NOT NULL AUTO_INCREMENT,
  `Name` varchar(20) NOT NULL,
  `Dob` varchar(20) NOT NULL,
  `Gender` char(10) NOT NULL,
  `Telephone` varchar(10) NOT NULL,
  `Address1` varchar(30) NOT NULL,
  `Address2` varchar(30) NOT NULL,
  `Age` int(11) NOT NULL,
  `Course` varchar(10) NOT NULL,
  PRIMARY KEY (`Student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
CREATE TABLE IF NOT EXISTS `subject` (
  `Subject_code` varchar(20) NOT NULL,
  `Subject_name` varchar(30) NOT NULL,
  `Credits` int(11) NOT NULL,
  `Lecturer_id` varchar(11) NOT NULL,
  PRIMARY KEY (`Subject_code`),
  KEY `INDEX` (`Lecturer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `User_id` int(8) NOT NULL AUTO_INCREMENT,
  `Username` varchar(20) NOT NULL,
  `Password` varchar(30) NOT NULL,
  `UserType` varchar(20) NOT NULL,
  PRIMARY KEY (`User_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`User_id`, `Username`, `Password`, `UserType`) VALUES
(1, 'Admin', 'Pass123', 'Admin');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `attendence`
--
ALTER TABLE `attendence`
  ADD CONSTRAINT `attendence_ibfk_1` FOREIGN KEY (`Student_id`) REFERENCES `student` (`Student_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `eligible`
--
ALTER TABLE `eligible`
  ADD CONSTRAINT `eligible_ibfk_1` FOREIGN KEY (`Student_id`) REFERENCES `student` (`Student_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `marks`
--
ALTER TABLE `marks`
  ADD CONSTRAINT `marks_ibfk_1` FOREIGN KEY (`Student_id`) REFERENCES `student` (`Student_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `payments`
--
ALTER TABLE `payments`
  ADD CONSTRAINT `payments_ibfk_1` FOREIGN KEY (`Student_id`) REFERENCES `student` (`Student_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `subject`
--
ALTER TABLE `subject`
  ADD CONSTRAINT `subject_ibfk_1` FOREIGN KEY (`Lecturer_id`) REFERENCES `lecturer` (`Lecturer_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
