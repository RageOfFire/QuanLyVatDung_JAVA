-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 02, 2022 at 12:13 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `khachsan_btl`
--

-- --------------------------------------------------------

--
-- Table structure for table `vatdung`
--

CREATE TABLE `vatdung` (
  `MaVatDung` int(11) NOT NULL,
  `TenVatDung` varchar(50) NOT NULL,
  `SoLuong` int(11) DEFAULT NULL,
  `TinhTrang` varchar(30) DEFAULT NULL,
  `GhiChu` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `vatdung`
--

INSERT INTO `vatdung` (`MaVatDung`, `TenVatDung`, `SoLuong`, `TinhTrang`, `GhiChu`) VALUES
(1, 'Chổi', 5, 'Ổn định', 'Ở tầng 2'),
(3, 'Thìa', 200, 'Ổn định', ''),
(4, 'Bát', 134, 'Ổn định', ''),
(5, 'Bàn', 20, 'Ổn định', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `vatdung`
--
ALTER TABLE `vatdung`
  ADD PRIMARY KEY (`MaVatDung`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `vatdung`
--
ALTER TABLE `vatdung`
  MODIFY `MaVatDung` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
