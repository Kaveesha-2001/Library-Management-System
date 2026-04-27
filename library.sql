-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 01, 2024 at 09:53 PM
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
-- Database: `library`
--

-- --------------------------------------------------------

--
-- Table structure for table `author`
--

CREATE TABLE `author` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `address` text NOT NULL,
  `phone` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `author`
--

INSERT INTO `author` (`id`, `name`, `address`, `phone`) VALUES
(12, 'C.J.Kannan', 'kannan@gmail.com', 112346753),
(13, 'S.Swamynathan', 'swamynathan@gmail.com', 774867942),
(14, 'Robert A.Peeter', 'robert@dcn.com', 117895246),
(15, 'Andrew Orwell', 'andrew123@gmail.com', 712498751),
(16, 'Frederick Thomas', 'thomas@cleancode.com', 224567856),
(17, 'A.Martin', 'martin@aiapproach.com', 117895234),
(18, 'Kathy Sierra', 'kathy.sierra@gmail.com', 775649238),
(19, 'David Patterson', 'pattersondavid@gmail.com', 321456782),
(20, 'Richard Bachman', 'richard@gmail.com', 773259467),
(21, 'Sewwandi Kumarihami', 'sewkumari2gmail.com', 712665487),
(23, 'Kazuo Ishiguro', 'ishiguro456@gmail.com', 754230089),
(24, 'Sithumini Kavindi', 'sithuminikavi@gmail.com', 714237781),
(25, 'Dinesh Bandara', 'dinesh12@gmail.com', 776223485);

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `id` int(11) NOT NULL,
  `bname` varchar(255) NOT NULL,
  `category` varchar(255) NOT NULL,
  `author` int(11) NOT NULL,
  `pages` int(11) NOT NULL,
  `edition` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`id`, `bname`, `category`, `author`, `pages`, `edition`) VALUES
(2, 'English grammer', '4', 4, 200, 1),
(3, 'java basic', '1', 4, 23, 2),
(6, 'j code', '1', 4, 56, 3),
(9, 'English story', '4', 5, 25, 2),
(10, 'songs', '5', 9, 45, 1),
(11, 'WEB', '4', 5, 23, 2),
(12, 'Tamil ', '2', 4, 56, 3),
(13, 'java ', '6', 4, 32, 1),
(15, 'Global Marketing Management', '11', 13, 450, 3),
(16, 'Human Resources', '13', 12, 380, 1),
(17, 'Export Management', '11', 13, 600, 2),
(18, 'Cost Accounting', '14', 18, 400, 3),
(19, 'Operation Management', '12', 12, 300, 2),
(20, 'Clean code', '18', 16, 500, 1),
(21, 'An Introduction to Database Systems', '22', 17, 350, 5),
(22, 'Python Crash Course', '18', 15, 400, 5),
(23, 'Effective Java', '18', 19, 500, 4),
(24, 'You Don\'t Know', '23', 16, 100, 1),
(25, 'Artificial Intelligence', '17', 17, 400, 2),
(26, 'Sihina Mayawi', '24', 21, 200, 2),
(27, 'C++ Basic', '18', 17, 600, 6),
(29, 'Statistics', '11', 12, 260, 3);

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `catname` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `catname`, `status`) VALUES
(11, 'Marketing Management', 'Active'),
(12, 'Financial Management', 'Active'),
(13, 'Personal Management', 'Active'),
(14, 'Accounting', 'Active'),
(15, 'IT and Business', 'Active'),
(16, 'Operating Systems', 'Active'),
(17, 'Computer Science', 'Active'),
(18, 'Programming and Software', 'Active'),
(19, 'Database and Storage', 'DeActive'),
(20, 'Networking and Cybersecurity', 'Active'),
(22, 'Database Management', 'Active'),
(23, 'English', 'Active'),
(24, 'Novels', 'Active'),
(25, 'Tamil Books', 'DeActive'),
(26, 'PHP', 'Active'),
(28, 'Mathematics', 'Active'),
(29, 'Architecture', 'Active');

-- --------------------------------------------------------

--
-- Table structure for table `dvd`
--

CREATE TABLE `dvd` (
  `id` int(11) NOT NULL,
  `dtitle` varchar(255) NOT NULL,
  `category` int(11) NOT NULL,
  `duration` varchar(255) NOT NULL,
  `direction` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `dvd`
--

INSERT INTO `dvd` (`id`, `dtitle`, `category`, `duration`, `direction`) VALUES
(2, 'sd', 2, '34', '4f'),
(5, 'Java Basic', 18, '2h 30min', 'Gamin Sumith'),
(6, 'Networking Basics', 15, '3hours', 'Richat Dee'),
(7, 'Python for Beginners', 18, '4hours', 'Rosel Juniya'),
(8, 'Cybersecurity', 17, '4hours', 'Wolda Joo'),
(9, ' Machine Learning Basics', 17, '5hours', 'Reoo Gamage'),
(10, 'Web Dev Essentials', 15, '2h 40min', 'Osen Konar'),
(11, 'Spoken English by CJ', 23, '1h 30min', 'Colm Coetzee'),
(12, 'Statistics', 28, '1h 40min', 'Dinesh Bandara'),
(13, 'English Songs', 11, '1hours', 'Nadeera Dias');

-- --------------------------------------------------------

--
-- Table structure for table `lendbook`
--

CREATE TABLE `lendbook` (
  `id` int(11) NOT NULL,
  `memberid` int(11) NOT NULL,
  `bookid` int(11) NOT NULL,
  `issuedate` date NOT NULL,
  `returndate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `lendbook`
--

INSERT INTO `lendbook` (`id`, `memberid`, `bookid`, `issuedate`, `returndate`) VALUES
(5, 4, 19, '2024-09-02', '2024-09-06'),
(8, 3, 2, '2024-09-03', '2024-09-06'),
(9, 5, 17, '2024-09-10', '2024-09-13'),
(10, 7, 21, '2024-09-17', '2024-09-20'),
(11, 9, 10, '2024-10-01', '2024-10-04'),
(12, 13, 2, '2024-10-22', '2024-10-25');

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE `member` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `phone` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`id`, `name`, `address`, `phone`) VALUES
(3, 'Sithumini Ruwanmali', 'sithumini@gmail.com', 712846753),
(4, 'Lakmi Kaveesha', 'athapattulakmi@gmail.com', 712916623),
(5, 'Naduni Samindi', 'Nadu@gmail.com', 714582341),
(6, 'Samadhi Disanayake', 'samadhi@gmail.com', 704523950),
(7, 'Tharushika Ranaweera', 'tharushi@gmail.com', 718534204),
(8, 'Yogeesha Lakshmini', 'yogisha@gmail.com', 724561283),
(9, 'Himasha Adhikari', 'himasha@gmail.com', 728623490),
(10, 'Ishan Sandeepa', 'ishansandeepa@gmail.com', 714582317),
(11, 'Erandi Wijesinghe', 'erandi@gmail.com', 712544362),
(12, 'Sandunika Herath', 'sanduherath@gmail.com', 724433314),
(13, 'Sepalika Herath', 'sepaliherath@gmail.com', 724466134);

-- --------------------------------------------------------

--
-- Table structure for table `returnbook`
--

CREATE TABLE `returnbook` (
  `id` int(11) NOT NULL,
  `mid` int(11) NOT NULL,
  `mname` varchar(255) NOT NULL,
  `bname` varchar(255) NOT NULL,
  `returndate` varchar(255) NOT NULL,
  `elp` int(11) NOT NULL,
  `fine` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `returnbook`
--

INSERT INTO `returnbook` (`id`, `mid`, `mname`, `bname`, `returndate`, `elp`, `fine`) VALUES
(1, 4, 'Lakmi Kaveesha', 'Operation Management', '2024-09-06', 25, 2500),
(3, 3, 'Hashan Sasanka', 'English grammer', '2024-09-06', 25, 2500),
(4, 9, 'Himasha Adhikari', 'songs', '2024-10-04', 0, 0),
(5, 5, 'Naduni Samindi', 'Export Management', '2024-09-13', 18, 1800);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `author`
--
ALTER TABLE `author`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `dvd`
--
ALTER TABLE `dvd`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `lendbook`
--
ALTER TABLE `lendbook`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `returnbook`
--
ALTER TABLE `returnbook`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `author`
--
ALTER TABLE `author`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `book`
--
ALTER TABLE `book`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT for table `dvd`
--
ALTER TABLE `dvd`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `lendbook`
--
ALTER TABLE `lendbook`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `member`
--
ALTER TABLE `member`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `returnbook`
--
ALTER TABLE `returnbook`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
