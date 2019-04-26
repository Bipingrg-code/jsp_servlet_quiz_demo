-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 30, 2019 at 10:00 AM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 7.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `demo`
--

-- --------------------------------------------------------

--
-- Table structure for table `quiz`
--

CREATE TABLE `quiz` (
  `qid` int(11) NOT NULL,
  `question` varchar(100) NOT NULL,
  `catagory` varchar(50) NOT NULL,
  `option1` varchar(50) NOT NULL,
  `option2` varchar(50) NOT NULL,
  `option3` varchar(50) NOT NULL,
  `option4` varchar(50) NOT NULL,
  `correctanswer` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `quiz`
--

INSERT INTO `quiz` (`qid`, `question`, `catagory`, `option1`, `option2`, `option3`, `option4`, `correctanswer`) VALUES
(2, 'what is the capital of Nepal ?', 'geography', 'kathmandu', 'Delhi', 'Bejing', 'Tokyo', 1),
(3, 'what is the capital of Nepal ?', 'geography', 'kathmandu', 'Delhi', 'Bejing', 'Tokyo', 1),
(4, 'who play rancho charector in 3 idiots ?', 'movie', 'amir', 'dhiren', 'rajesh', 'bipin', 1),
(5, 'who unified Nepal ?', 'history', 'King Prithvinarayan', 'King Tribhuvan', 'King Birendra', 'King Hanuman', 1),
(6, 'Capital of india ?', 'geography', 'kathmandu', 'Delhi', 'Bejing', 'Tokyo', 2),
(7, 'Capital of China ?', 'geography', 'kathmandu', 'Delhi', 'Bejing', 'Tokyo', 3),
(8, 'Capital of China ?', 'geography', 'kathmandu', 'Delhi', 'Bejing', 'Tokyo', 4),
(9, 'Capital of China ?', 'geography', 'kathmandu', 'Delhi', 'Bejing', 'Tokyo', 4),
(10, 'who escape most of the web servlet class ?', 'comedy', 'Bipin', 'Bishal', 'Ishwor', 'Sanjay', 2),
(11, 'what is the capital of England ?', 'geography', 'Berlin', 'Paris', 'Milan', 'London', 4);

-- --------------------------------------------------------

--
-- Table structure for table `result`
--

CREATE TABLE `result` (
  `rid` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `qid` int(100) NOT NULL,
  `catagory` varchar(255) NOT NULL,
  `answer` varchar(100) NOT NULL,
  `no_of_correct_question` int(255) NOT NULL,
  `created_at` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `result`
--

INSERT INTO `result` (`rid`, `username`, `qid`, `catagory`, `answer`, `no_of_correct_question`, `created_at`) VALUES
(65, 'admin', 2, 'geography', '1', 1, '2019-01-30 08:11:55'),
(66, 'admin', 3, 'geography', '1', 2, '2019-01-30 08:11:55'),
(67, 'admin', 6, 'geography', '2', 3, '2019-01-30 08:11:56'),
(68, 'admin', 7, 'geography', '3', 4, '2019-01-30 08:11:56'),
(69, 'admin', 8, 'geography', '3', 4, '2019-01-30 08:11:56'),
(70, 'admin', 9, 'geography', '3', 4, '2019-01-30 08:11:56'),
(71, 'admin', 11, 'geography', '4', 5, '2019-01-30 08:11:56'),
(72, 'admin', 4, 'movie', '1', 1, '2019-01-30 02:35:05');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(250) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `role` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `username`, `password`, `role`) VALUES
(3, 'admin', 'root', 'admin'),
(4, 'sanjay', 'sanjay', 'user'),
(5, 'shyam', 'shyam', 'user');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `quiz`
--
ALTER TABLE `quiz`
  ADD PRIMARY KEY (`qid`);

--
-- Indexes for table `result`
--
ALTER TABLE `result`
  ADD PRIMARY KEY (`rid`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `quiz`
--
ALTER TABLE `quiz`
  MODIFY `qid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `result`
--
ALTER TABLE `result`
  MODIFY `rid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=73;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(250) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
