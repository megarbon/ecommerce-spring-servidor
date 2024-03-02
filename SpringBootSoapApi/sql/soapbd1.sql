-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 02, 2024 at 11:28 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `soapbd1`
--

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `employee_id` bigint(20) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`employee_id`, `address`, `department`, `name`, `phone`) VALUES
(1, 'Calle Einstein 1', 'Física Teórica', 'Albert Einstein', '+1 (123) 456-7890'),
(2, 'Avenida Newton 2', 'Matemáticas y Física', 'Isaac Newton', '+1 (234) 567-8901'),
(3, 'Plaza da Vinci 3', 'Arte e Inventiva', 'Leonardo da Vinci', '+1 (345) 678-9012'),
(4, 'Calle Curie 4', 'Ciencias Radiológicas', 'Marie Curie', '+1 (456) 789-0123'),
(5, 'Avenida Galileo 5', 'Astronomía', 'Galileo Galilei', '+1 (567) 890-1234'),
(6, 'Calle Darwin 6', 'Biología Evolutiva', 'Charles Darwin', '+1 (678) 901-2345'),
(7, 'Plaza Tesla 7', 'Ingeniería Eléctrica', 'Nikola Tesla', '+1 (789) 012-3456'),
(8, 'Avenida Aristotle 8', 'Filosofía Natural', 'Aristotle', '+1 (890) 123-4567'),
(9, 'Calle Bell 9', 'Comunicaciones', 'Alexander Graham Bell', '+1 (901) 234-5678'),
(10, 'Plaza Turing 10', 'Ciencias de la Computación', 'Alan Turing', '+1 (012) 345-6789');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`employee_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
