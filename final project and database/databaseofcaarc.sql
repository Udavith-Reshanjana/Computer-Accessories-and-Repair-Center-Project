-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 23, 2023 at 05:19 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `databaseofcaarc`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `customerID` varchar(12) NOT NULL,
  `customerName` varchar(80) NOT NULL,
  `type` varchar(10) NOT NULL,
  `NIC` varchar(13) NOT NULL,
  `address` varchar(140) NOT NULL,
  `userName` varchar(12) DEFAULT NULL,
  `password` varchar(12) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`customerID`, `customerName`, `type`, `NIC`, `address`, `userName`, `password`) VALUES
('CUS/N/00001', 'John Smith', 'Normal', '199812345673', '123 Main Street, Apt 4B, Anytown, USA, 12345', NULL, NULL),
('CUS/N/00002', 'John Doe', 'Normal', '81756080V', '123 Main Street, Cityville, USA', NULL, NULL),
('CUS/N/00003', 'Jane Smith', 'Normal', '78215648V', '456 Elm Avenue, Townsville, USA', NULL, NULL),
('CUS/N/00004', 'Robert Brown', 'Normal', '199279564132', '789 Oak Road, Villagetown, USA', NULL, NULL),
('CUS/N/00005', 'Sarah Johnson', 'Normal', '199955649583', '102 Pine Street, Hamletville, USA', NULL, NULL),
('CUS/N/00006', 'Dave Jhones', 'Normal', '200135410235', 'test 1 address', NULL, NULL),
('CUS/N/00007', 'David Correy', 'Normal', '12011103v', 'sample address 2', NULL, NULL),
('CUS/W/00001', 'Mary Johnson', 'Wholesale', '23456782V', '456 Elm Avenue, Suite 200, Cityville, Canada, A1B 2C3', 'Mary00001', '12345'),
('CUS/W/00002', 'Emily White', 'Wholesale', '200163700070', '303 Maple Drive, Countryside, USA', 'emilywht', '45678'),
('CUS/W/00003', 'David Wilson', 'Wholesale', '200104587934', '404 Birch Street, Riverside, USA', 'dwilson123', 'Wils0nDav1d!'),
('CUS/W/00004', 'Lisa Davis', 'Wholesale ', '97158435V', '505 Willow Lane, Lakeside, USA', 'lisadavis45', 'L1s@DaV1s'),
('CUS/W/00005', 'James Taylor', 'Wholesale', '90245873V', '606 Redwood Avenue, Mountainview, USA', 'jamestaylor2', 'T@ylorJam3s'),
('CUS/W/00006', 'test 1', 'Wholesale', '12011102V', 'test add', 'test', '0000'),
('CUS/W/00007', 'test 2', 'Wholesale', '12011101V', 'test add', 'test', '0000'),
('CUS/W/00008', 'test 3', 'Wholesale', '12011100V', 'test add', 'test', '0000');

-- --------------------------------------------------------

--
-- Table structure for table `customerphonenumber`
--

CREATE TABLE `customerphonenumber` (
  `customerID` varchar(12) NOT NULL,
  `phoneNumber` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customerphonenumber`
--

INSERT INTO `customerphonenumber` (`customerID`, `phoneNumber`) VALUES
('CUS/N/00001', '771234567'),
('CUS/N/00001', '772025213'),
('CUS/N/00002', '712459637'),
('CUS/N/00003', '781234567'),
('CUS/N/00003', '781451973'),
('CUS/N/00004', '751248796'),
('CUS/N/00004', '767823159'),
('CUS/N/00005', '702458963'),
('CUS/N/00006', '0112451412'),
('CUS/W/00001', '781111111'),
('CUS/W/00001', '781234567'),
('CUS/W/00002', '712348975'),
('CUS/W/00002', '781549735'),
('CUS/W/00003', '748612967'),
('CUS/W/00003', '774587361'),
('CUS/W/00004', '714852367'),
('CUS/W/00005', '754896312'),
('CUS/W/00005', '771547382'),
('CUS/W/00006', '0112365222'),
('CUS/W/00006', '0771421416');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `employeeID` varchar(12) NOT NULL,
  `fName` varchar(15) NOT NULL,
  `mName` varchar(15) DEFAULT NULL,
  `lName` varchar(15) NOT NULL,
  `role` varchar(15) NOT NULL,
  `NIC` varchar(13) NOT NULL,
  `address` varchar(100) NOT NULL,
  `username` varchar(12) NOT NULL,
  `password` varchar(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`employeeID`, `fName`, `mName`, `lName`, `role`, `NIC`, `address`, `username`, `password`) VALUES
('EMP/MGT/001', 'Sarah', NULL, 'Anderson', 'Manager', '1998100000001', '789 Oak Lane, Unit 3D, Riverside, CA 98765, USA', 'SaraMGT0001', 'MGT00001'),
('EMP/MGT/002', 'Olivia', 'Marie', 'Johnson', 'Manager', '1998100000002', '321 Maple Street, Apartment 5A, Toronto, ON M1A 2B3, Canada', 'OlivMGT0002', 'MGT00002'),
('EMP/MGT/003', 'Udavith', NULL, 'Reshanjana', 'Manager ', '211065897407', 'sample test address', 'udavith', '00000'),
('EMP/REC/001', 'Bob', 'Smith', 'Malei', 'Receptionalist', '1998107315404', '456 Oak Avenue, Townsville, USA', 'SmithREC0001', 'REC00001'),
('EMP/REC/002', 'Emma ', 'Lisa', 'Lee', 'Receptionalist', '924876135V', '101 Pine Lane, Hamletville, USA', 'LeeREC0002', 'REC00002'),
('EMP/REC/003', 'Isabella ', NULL, 'Brown', 'Receptionalist', '1995100754005', '606 Redwood Avenue, Mountainview, USA', 'IsabelREC000', 'REC00003'),
('EMP/REC/004', 'Harry ', 'Davis', 'Potter', 'Receptionalist', '1995154832007', '404 Birch Street, Riverside, USA', 'PotterREC000', 'REC00004'),
('EMP/REC/005', 'Nimesh', NULL, 'Ariyarathne', 'Receptionalist', '200131965840', 'sample address 2', 'nimesh', '00000'),
('EMP/TEC/001', 'Susan ', 'Martinez', 'Andruu', 'Technician', '845672138V', '123 Elm Street, Cityville, USA', 'MartinezTEC0', 'TEC00001'),
('EMP/TEC/002', 'Alice', NULL, 'Johnson', 'Technician', '1992154698706', '789 Maple Road, Villagetown, USA', 'AliceTEC0002', 'TEC00002'),
('EMP/TEC/003', 'Sanduni', NULL, 'Kaushalya', 'Technician', '32524511V', 'Sample address 3', 'sanduni', '00000');

-- --------------------------------------------------------

--
-- Table structure for table `employeephonenumber`
--

CREATE TABLE `employeephonenumber` (
  `employeeID` varchar(12) NOT NULL,
  `phoneNumber` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employeephonenumber`
--

INSERT INTO `employeephonenumber` (`employeeID`, `phoneNumber`) VALUES
('EMP/MGT/001', '751212345'),
('EMP/MGT/001', '780685423'),
('EMP/MGT/002', '775864153'),
('EMP/MGT/003', '780685424'),
('EMP/MGT/003', '780685425'),
('EMP/REC/001', '751483259'),
('EMP/REC/002', '701257863'),
('EMP/REC/002', '768543972'),
('EMP/REC/003', '751284368'),
('EMP/REC/004', '740321805'),
('EMP/REC/004', '785497384'),
('EMP/REC/005', '0715852555'),
('EMP/TEC/001', '724863159'),
('EMP/TEC/001', '775928432'),
('EMP/TEC/002', '704825793'),
('EMP/TEC/003', '704111111');

-- --------------------------------------------------------

--
-- Table structure for table `hardware`
--

CREATE TABLE `hardware` (
  `hardwareID` varchar(13) NOT NULL,
  `name` varchar(50) NOT NULL,
  `brandName` varchar(9) NOT NULL,
  `type` varchar(13) NOT NULL,
  `unitPrice` double NOT NULL,
  `qty` int(11) NOT NULL,
  `importedCountry` varchar(6) NOT NULL,
  `usageTime` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `hardware`
--

INSERT INTO `hardware` (`hardwareID`, `name`, `brandName`, `type`, `unitPrice`, `qty`, `importedCountry`, `usageTime`) VALUES
('HW/BN/00001', 'Motherboard - AFOX H110D4-MA4-V2 DDR4/6th/7th/8th/', 'Intel', 'Second Hand', 22500, 6, 'USA', 0),
('HW/BN/00002', 'Motherboard - Mpg Z790 Carbon (Wi-Fi) Ddr5 911-7D8', 'msi', 'Brand New', 192500, 37, 'USA', 0),
('HW/BN/00003', 'Processor - Intel Core i7 1st Gen Processors 860, ', 'Intel', 'Brand New', 10000, 28, 'USA', NULL),
('HW/BN/00004', 'Graphic Card - GeForce RTX 4090', 'Nvidia', 'Brand New', 510481, 40, 'USA', 0),
('HW/BN/00005', 'RAM - Crucial Pro 32GB Kit (2x16GB) DDR4-3200 UDIM', 'Crucial', 'Brand New', 17555, 22, 'USA', NULL),
('HW/BN/00006', 'RAM - Micron 8GB DDR4 SDRAM', 'Micorn', 'Brand New', 6350, 50, 'USA', NULL),
('HW/BN/00007', 'Graphics card - ASUS STRIX GAMING GEFORCE RTX 4090', 'ASUS', 'Brand New', 879000, 98, 'USA', 0),
('HW/BN/00008', 'CPU Cooling Fan RGB WX-3 cooling and lighting', 'DarazMall', 'Brand New', 2510, 89, 'China', NULL),
('HW/BN/00009', 'DC Cooling PC Computer or Charcoal Stove Fan 12V 3', 'DarazMall', 'Brand New', 578, 100, 'China', NULL),
('HW/BN/00010', 'High Rpm Cooling Fan 12025 2800RPM DC brushless fa', 'DarazMall', 'Brand New ', 1600, 80, 'China', NULL),
('HW/BN/00011', 'HardDrive - SanDisk SSD X300s SATA 2.5\" 128GB SD7T', 'Sandisk', 'Brand New ', 5500, 90, 'China', NULL),
('HW/BN/00012', 'HardDrive - HDD SSD - SANDISK 500GB ULTRA (SDSSDH3', 'Sandisk', 'Brand New ', 20300, 48, 'China', NULL),
('HW/BN/00013', 'HardDrive - HDD - TOSHIBA 1TB SATA(2y)', 'Toshiba', 'Brand New ', 14000, 35, 'Japan', NULL),
('HW/BN/00014', 'Monitor - Dell 19\'\' Inch Square Monitor', 'DELL', 'Brand New', 9900, 40, 'USA', NULL),
('HW/BN/00015', 'Monitor - DELL MP223 21.45” INCH 100HZ 1MS FHD ULT', 'DELL', 'Brand New ', 33500, 30, 'USA', NULL),
('HW/BN/00016', 'Monitor - Samsung LED Monitors (19inch, 20inch, 22', 'SAMSUNG', 'Brand New', 17500, 30, 'USA', NULL),
('HW/BN/00017', 'Monitor - Lenovo L27i-30 - 27 Inch - FHD IPs - 75 ', 'Lenovo', 'Brand New', 69500, 20, 'USA', NULL),
('HW/BN/00018', 'Mouse - Razer DeathAdder Essential Gaming Mouse: 6', 'Razer', 'Brand New', 7981, 20, 'USA', NULL),
('HW/BN/00019', 'Mouse - Asus 2.4GHz Wireless USB Receiver with Opt', 'Asus', 'Brand New', 2219, 40, 'USA', NULL),
('HW/BN/00020', 'Mouse - Wireless Mouse for Laptop, 2.4Ghz Ergonomi', 'Logitech', 'Brand New', 5117, 40, 'USA', NULL),
('HW/BN/00021', 'Keyboard - RAZER CYNOSA V2 - US MEMBRANE GAMING KE', 'Razer', 'Brand New', 17000, 100, 'USA', 0),
('HW/BN/00022', 'Keyboard - Dell 0DJ331 Keyboard', 'DELL', 'Brand New', 2900, 50, 'USA', NULL),
('HW/BN/00023', 'SSD - Ssd Samsung 1tb 870evo Sata (2y)', 'SAMSUNG', 'Brand New', 23600, 30, 'USA', NULL),
('HW/BN/00024', 'SSD - ADATA SU650 240GB SSD 2.5 SATA 6GB/S ULTIMAT', 'ADATA', 'Brand New', 9000, 48, 'USA', NULL),
('HW/BN/00025', 'USB Drive - 4 GB', 'SandDisk', 'Brand New', 1234, 98, 'test1', 0),
('HW/BN/00026', 'Graphic Card - Nvidia RTX 1060', 'Nvidia', 'Brand New', 25000, 10, 'USA', NULL),
('HW/SEC/00001', 'Motherboard - Asus ProArt B760 Creator D4', 'Asus', 'Second Hand', 100000, 4, 'USA', 6),
('HW/SEC/00002', 'Motherboard - XFX nForce 630i/GeForce 7100 mATX LG', 'XFX', 'Second Hand', 25540, 15, 'Korea', 10),
('HW/SEC/00003', 'Processor - AMD Ryzen 7 5800X', 'AMD', 'Second Hand', 110000, 5, 'USA', 6),
('HW/SEC/00004', 'RAM - Kingston 8GB DDR4 2666mhz Desktop RAM (3Y)', 'Kingston', 'Second Hand', 7000, 50, 'Korea', 6),
('HW/SEC/00005', 'RAM - ADATA 16GB DDR4 3200MHZ 260-PIN SODIMM LAPTO', 'ADATA', 'Second Hand', 16500, 30, 'Korea', 6),
('HW/SEC/00006', 'Graphics card - Asus TUF Gaming GTX 1660 Super OC ', 'msi', 'Second Hand', 50000, 20, 'USA', 10),
('HW/SEC/00007', 'Monitor - 27\" Philips Monitor IPS', 'Philips', 'Second Hand', 39000, 30, 'Korea', 3),
('HW/SEC/00008', 'Monitor - DEL-Monitor-Silver Solid Build', 'DELL', 'Second Hand', 9900, 65, 'Korea', 10),
('HW/SEC/00009', 'SSD - 250 GB SanDisk SSD', 'SanDisk', 'Second Hand', 4900, 45, 'China', 8);

-- --------------------------------------------------------

--
-- Table structure for table `order`
--

CREATE TABLE `order` (
  `customerID` varchar(12) NOT NULL,
  `orderID` varchar(9) NOT NULL,
  `employeeID` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `order`
--

INSERT INTO `order` (`customerID`, `orderID`, `employeeID`) VALUES
('CUS/N/00001', 'ORD/00001', 'EMP/REC/001'),
('CUS/N/00001', 'ORD/00010', 'EMP/REC/001'),
('CUS/N/00001', 'ORD/00018', 'EMP/REC/003'),
('CUS/N/00001', 'ORD/00027', 'EMP/REC/003'),
('CUS/N/00002', 'ORD/00014', 'EMP/REC/003'),
('CUS/N/00002', 'ORD/00017', 'EMP/REC/002'),
('CUS/N/00002', 'ORD/00019', 'EMP/REC/001'),
('CUS/N/00002', 'ORD/00025', 'EMP/REC/002'),
('CUS/N/00002', 'ORD/00028', 'EMP/REC/002'),
('CUS/N/00004', 'ORD/00013', 'EMP/REC/002'),
('CUS/N/00004', 'ORD/00021', 'EMP/REC/001'),
('CUS/N/00005', 'ORD/00011', 'EMP/TEC/001'),
('CUS/N/00005', 'ORD/00015', 'EMP/REC/003'),
('CUS/N/00005', 'ORD/00029', 'EMP/REC/003'),
('CUS/N/00006', 'ORD/00002', 'EMP/MGT/003'),
('CUS/N/00006', 'ORD/00003', 'EMP/REC/003'),
('CUS/N/00006', 'ORD/00022', 'EMP/REC/002'),
('CUS/W/00001', 'ORD/00008', 'EMP/REC/003'),
('CUS/W/00001', 'ORD/00023', 'EMP/REC/001'),
('CUS/W/00001', 'ORD/00024', 'EMP/REC/001'),
('CUS/W/00001', 'ORD/00026', 'EMP/REC/001'),
('CUS/W/00003', 'ORD/00005', 'EMP/REC/003'),
('CUS/W/00003', 'ORD/00006', 'EMP/REC/003'),
('CUS/W/00003', 'ORD/00007', 'EMP/REC/003'),
('CUS/W/00003', 'ORD/00009', 'EMP/REC/003'),
('CUS/W/00004', 'ORD/00012', 'EMP/REC/003'),
('CUS/W/00005', 'ORD/00020', 'EMP/REC/001'),
('CUS/W/00006', 'ORD/00004', 'EMP/REC/003'),
('CUS/W/00006', 'ORD/00016', 'EMP/REC/001');

-- --------------------------------------------------------

--
-- Table structure for table `orderwarranty`
--

CREATE TABLE `orderwarranty` (
  `customerID` varchar(12) NOT NULL,
  `orderID` varchar(9) NOT NULL,
  `hardwareID` varchar(12) NOT NULL,
  `orderQty` int(11) NOT NULL,
  `initialDateOfWarranty` date NOT NULL,
  `dueDateOfWarranty` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `orderwarranty`
--

INSERT INTO `orderwarranty` (`customerID`, `orderID`, `hardwareID`, `orderQty`, `initialDateOfWarranty`, `dueDateOfWarranty`) VALUES
('CUS/N/00001', 'ORD/00001', 'HW/BN/00001', 1, '2023-11-01', '2024-11-01'),
('CUS/N/00001', 'ORD/00010', 'HW/BN/00005', 2, '2023-12-12', '2024-12-12'),
('CUS/N/00001', 'ORD/00010', 'HW/BN/00008', 1, '2023-12-07', '2023-12-12'),
('CUS/N/00001', 'ORD/00018', 'HW/BN/00003', 2, '2023-12-16', '2023-12-30'),
('CUS/N/00001', 'ORD/00027', 'HW/BN/00001', 1, '2023-12-18', '2023-12-31'),
('CUS/N/00002', 'ORD/00014', 'HW/BN/00001', 2, '2023-12-16', '2023-12-30'),
('CUS/N/00002', 'ORD/00019', 'HW/BN/00002', 1, '2023-12-17', '2023-12-31'),
('CUS/N/00002', 'ORD/00028', 'HW/BN/00001', 1, '2023-12-18', '2023-12-31'),
('CUS/N/00004', 'ORD/00021', 'HW/BN/00001', 1, '2023-12-17', '2023-12-31'),
('CUS/N/00005', 'ORD/00015', 'HW/BN/00001', 1, '2023-12-16', '2023-12-23'),
('CUS/N/00005', 'ORD/00029', 'HW/BN/00001', 1, '2023-12-18', '2023-12-25'),
('CUS/N/00006', 'ORD/00002', 'HW/BN/00025', 100, '2023-11-01', '2024-11-01'),
('CUS/N/00006', 'ORD/00022', 'HW/BN/00001', 1, '2023-12-17', '2023-12-31'),
('CUS/W/00001', 'ORD/00008', 'HW/BN/00010', 20, '2023-12-04', '2024-01-04'),
('CUS/W/00001', 'ORD/00008', 'HW/BN/00011', 10, '2023-12-04', '2024-12-03'),
('CUS/W/00001', 'ORD/00008', 'HW/SEC/00009', 7, '2023-12-04', '2024-01-01'),
('CUS/W/00001', 'ORD/00023', 'HW/BN/00005', 3, '2023-12-17', '2024-12-23'),
('CUS/W/00003', 'ORD/00006', 'HW/BN/00001', 5, '2023-12-03', '2024-12-03'),
('CUS/W/00003', 'ORD/00006', 'HW/BN/00008', 10, '2023-12-03', '2024-01-31'),
('CUS/W/00004', 'ORD/00012', 'HW/BN/00004', 1, '2023-12-15', '2024-12-17'),
('CUS/W/00005', 'ORD/00020', 'HW/BN/00002', 1, '2023-12-17', '2023-12-31'),
('CUS/W/00006', 'ORD/00004', 'HW/BN/00001', 1, '2023-11-01', '2023-12-01'),
('CUS/W/00006', 'ORD/00004', 'HW/SEC/00008', 5, '2023-11-01', '2023-12-01');

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `paymentID` varchar(9) NOT NULL,
  `date` date NOT NULL,
  `totalAmount` int(11) DEFAULT NULL,
  `givenAmount` int(11) DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `repairID` varchar(9) DEFAULT NULL,
  `customerID` varchar(12) NOT NULL,
  `orderID` varchar(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`paymentID`, `date`, `totalAmount`, `givenAmount`, `discount`, `repairID`, `customerID`, `orderID`) VALUES
('PMT/00001', '2023-11-01', 200000, 225000, NULL, NULL, 'CUS/N/00001', 'ORD/00001'),
('PMT/00002', '2023-11-26', 123400, 1300000, 7.5, NULL, 'CUS/N/00006', 'ORD/00002'),
('PMT/00003', '2023-11-29', 196000, 200000, 2, 'REP/00002', 'CUS/N/00006', 'ORD/00003'),
('PMT/00004', '2023-11-30', 72000, 80000, 0, NULL, 'CUS/W/00006', 'ORD/00004'),
('PMT/00005', '2023-11-30', 71640, 100000, 0.5, NULL, 'CUS/W/00006', 'ORD/00004'),
('PMT/00006', '2023-11-30', 19600, 20000, 2, 'REP/00003', 'CUS/W/00003', 'ORD/00005'),
('PMT/00007', '2023-12-03', 136210, 150000, 1.01, NULL, 'CUS/W/00003', 'ORD/00006'),
('PMT/00008', '2023-12-03', 5000, 5000, 0, 'REP/00004', 'CUS/W/00003', 'ORD/00007'),
('PMT/00009', '2023-12-04', 120694, 130000, 0.5, NULL, 'CUS/W/00001', 'ORD/00008'),
('PMT/00010', '2023-12-04', 15000, 15000, 0, 'REP/00005', 'CUS/W/00003', 'ORD/00009'),
('PMT/00011', '2023-12-15', 37620, 40000, 0, NULL, 'CUS/N/00001', 'ORD/00010'),
('PMT/00012', '2023-12-15', 10000, 10000, 0, 'REP/00006', 'CUS/N/00005', 'ORD/00011'),
('PMT/00013', '2023-12-15', 510481, 515000, 1.5, NULL, 'CUS/W/00004', 'ORD/00012'),
('PMT/00014', '2023-12-15', 100000, 100000, 0, 'REP/00007', 'CUS/N/00004', 'ORD/00013'),
('PMT/00015', '2023-12-16', 44550, 50000, 1, NULL, 'CUS/N/00002', 'ORD/00014'),
('PMT/00016', '2023-12-16', 22500, 23000, 0, NULL, 'CUS/N/00005', 'ORD/00015'),
('PMT/00017', '2023-12-16', 0, 1, 0, 'REP/00008', 'CUS/W/00006', 'ORD/00016'),
('PMT/00018', '2023-12-16', 30000, 30000, 0, 'REP/00009', 'CUS/N/00002', 'ORD/00017'),
('PMT/00019', '2023-12-16', 19700, 20000, 1.5, NULL, 'CUS/N/00001', 'ORD/00018'),
('PMT/00020', '2023-12-17', 192500, 200000, 0, NULL, 'CUS/N/00002', 'ORD/00019'),
('PMT/00021', '2023-12-17', 192500, 200000, 0, NULL, 'CUS/W/00005', 'ORD/00020'),
('PMT/00022', '2023-12-17', 22163, 23000, 1.5, NULL, 'CUS/N/00004', 'ORD/00021'),
('PMT/00023', '2023-12-17', 22275, 23000, 1, NULL, 'CUS/N/00006', 'ORD/00022'),
('PMT/00024', '2023-12-17', 51612, 52000, 2, NULL, 'CUS/W/00001', 'ORD/00023'),
('PMT/00025', '2023-12-18', 0, 1, 0, 'REP/00010', 'CUS/W/00001', 'ORD/00024'),
('PMT/00026', '2023-12-18', 50000, 50000, 0, 'REP/00011', 'CUS/N/00002', 'ORD/00025'),
('PMT/00027', '2023-12-18', 98000, 100000, 2, 'REP/00012', 'CUS/W/00001', 'ORD/00026'),
('PMT/00028', '2023-12-18', 22275, 23000, 1, NULL, 'CUS/N/00001', 'ORD/00027'),
('PMT/00029', '2023-12-18', 22275, 23000, 1, NULL, 'CUS/N/00002', 'ORD/00028'),
('PMT/00030', '2023-12-18', 22275, 23000, 1, NULL, 'CUS/N/00005', 'ORD/00029');

-- --------------------------------------------------------

--
-- Table structure for table `repair`
--

CREATE TABLE `repair` (
  `repairID` varchar(12) NOT NULL,
  `repairDiscription` text NOT NULL,
  `customerID` varchar(12) NOT NULL,
  `Status` varchar(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `repair`
--

INSERT INTO `repair` (`repairID`, `repairDiscription`, `customerID`, `Status`) VALUES
('REP/00001', 'test 1', 'CUS/N/00001', 'Completed'),
('REP/00002', 'test details', 'CUS/N/00006', 'Completed'),
('REP/00003', 'Replace the ribbon of display', 'CUS/W/00003', 'Completed'),
('REP/00004', 'HW/BN/00008 CPU Cooling is not working well', 'CUS/W/00003', 'Completed'),
('REP/00005', 'HW/SEC/00008 monitor does not working', 'CUS/W/00003', 'Completed'),
('REP/00006', 'dead laptop', 'CUS/N/00005', 'Completed'),
('REP/00007', 'laptop display not working', 'CUS/N/00004', 'Started'),
('REP/00008', 'dead laptop', 'CUS/W/00006', 'Started'),
('REP/00009', 'OS is not support well', 'CUS/N/00002', 'Completed'),
('REP/00010', 'CPU does not working', 'CUS/W/00001', 'Pending'),
('REP/00011', 'display issue', 'CUS/N/00002', 'Pending'),
('REP/00012', 'display issue', 'CUS/W/00001', 'Pending');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`customerID`);

--
-- Indexes for table `customerphonenumber`
--
ALTER TABLE `customerphonenumber`
  ADD PRIMARY KEY (`customerID`,`phoneNumber`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`employeeID`);

--
-- Indexes for table `employeephonenumber`
--
ALTER TABLE `employeephonenumber`
  ADD PRIMARY KEY (`employeeID`,`phoneNumber`);

--
-- Indexes for table `hardware`
--
ALTER TABLE `hardware`
  ADD PRIMARY KEY (`hardwareID`);

--
-- Indexes for table `order`
--
ALTER TABLE `order`
  ADD PRIMARY KEY (`customerID`,`orderID`,`employeeID`),
  ADD KEY `order_ibfk_2` (`employeeID`);

--
-- Indexes for table `orderwarranty`
--
ALTER TABLE `orderwarranty`
  ADD PRIMARY KEY (`customerID`,`orderID`,`hardwareID`),
  ADD KEY `hardwareID` (`hardwareID`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`paymentID`),
  ADD KEY `repairID` (`repairID`),
  ADD KEY `payment_ibfk_2` (`customerID`,`orderID`);

--
-- Indexes for table `repair`
--
ALTER TABLE `repair`
  ADD PRIMARY KEY (`repairID`),
  ADD KEY `customerID` (`customerID`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `customerphonenumber`
--
ALTER TABLE `customerphonenumber`
  ADD CONSTRAINT `customerphonenumber_ibfk_1` FOREIGN KEY (`customerID`) REFERENCES `customer` (`customerID`);

--
-- Constraints for table `employeephonenumber`
--
ALTER TABLE `employeephonenumber`
  ADD CONSTRAINT `employeephonenumber_ibfk_1` FOREIGN KEY (`employeeID`) REFERENCES `employee` (`EmployeeID`);

--
-- Constraints for table `order`
--
ALTER TABLE `order`
  ADD CONSTRAINT `order_ibfk_1` FOREIGN KEY (`customerID`) REFERENCES `customer` (`customerID`),
  ADD CONSTRAINT `order_ibfk_2` FOREIGN KEY (`employeeID`) REFERENCES `employee` (`EmployeeID`);

--
-- Constraints for table `orderwarranty`
--
ALTER TABLE `orderwarranty`
  ADD CONSTRAINT `orderwarranty_ibfk_2` FOREIGN KEY (`hardwareID`) REFERENCES `hardware` (`hardwareID`),
  ADD CONSTRAINT `orderwarranty_ibfk_3` FOREIGN KEY (`customerID`,`orderID`) REFERENCES `order` (`customerID`, `orderID`);

--
-- Constraints for table `payment`
--
ALTER TABLE `payment`
  ADD CONSTRAINT `payment_ibfk_1` FOREIGN KEY (`repairID`) REFERENCES `repair` (`RepairID`),
  ADD CONSTRAINT `payment_ibfk_2` FOREIGN KEY (`customerID`,`orderID`) REFERENCES `order` (`customerID`, `orderID`);

--
-- Constraints for table `repair`
--
ALTER TABLE `repair`
  ADD CONSTRAINT `repair_ibfk_1` FOREIGN KEY (`customerID`) REFERENCES `customer` (`customerID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
