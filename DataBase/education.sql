-- MySQL dump 10.13  Distrib 8.0.22, for macos10.15 (x86_64)
--
-- Host: localhost    Database: education
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `advise`
--

DROP TABLE IF EXISTS `advise`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `advise` (
  `apcode` char(4) NOT NULL,
  `ascode` char(4) NOT NULL,
  PRIMARY KEY (`apcode`,`ascode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `advise`
--

LOCK TABLES `advise` WRITE;
/*!40000 ALTER TABLE `advise` DISABLE KEYS */;
INSERT INTO `advise` VALUES ('P001','S001'),('P001','S002'),('P003','S003'),('P003','S004'),('P007','S005'),('P007','S006');
/*!40000 ALTER TABLE `advise` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `advise2`
--

DROP TABLE IF EXISTS `advise2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `advise2` (
  `apcode` char(4) NOT NULL,
  `ascode` char(4) NOT NULL,
  PRIMARY KEY (`apcode`,`ascode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `advise2`
--

LOCK TABLES `advise2` WRITE;
/*!40000 ALTER TABLE `advise2` DISABLE KEYS */;
INSERT INTO `advise2` VALUES ('P001','S001'),('P001','S002'),('P003','S003'),('P003','S004'),('P007','S005'),('P007','S006');
/*!40000 ALTER TABLE `advise2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `advise3`
--

DROP TABLE IF EXISTS `advise3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `advise3` (
  `apcode` char(4) NOT NULL,
  `ascode` char(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `advise3`
--

LOCK TABLES `advise3` WRITE;
/*!40000 ALTER TABLE `advise3` DISABLE KEYS */;
INSERT INTO `advise3` VALUES ('P001','S001'),('P001','S002'),('P003','S003'),('P003','S004'),('P007','S005'),('P007','S006');
/*!40000 ALTER TABLE `advise3` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `ccode` char(4) NOT NULL,
  `cname` char(10) DEFAULT NULL,
  `ctime` int DEFAULT NULL,
  `croom` char(8) DEFAULT NULL,
  PRIMARY KEY (`ccode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES ('C001','TCP/IP',3,'R001'),('C002','HTML',3,'R002'),('C003','PHP',3,'R003'),('C004','LINUX',3,'Lab1'),('C005','MYSQL',3,'Lab1'),('C006','JAVA',3,'Lab1');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lecture`
--

DROP TABLE IF EXISTS `lecture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lecture` (
  `lpcode` char(4) NOT NULL,
  `lccode` char(4) NOT NULL,
  `opendate` date DEFAULT NULL,
  `closedate` date DEFAULT NULL,
  PRIMARY KEY (`lpcode`,`lccode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lecture`
--

LOCK TABLES `lecture` WRITE;
/*!40000 ALTER TABLE `lecture` DISABLE KEYS */;
INSERT INTO `lecture` VALUES ('P001','C001','2017-03-02','2017-08-02'),('P001','C002','2017-03-02','2017-08-02'),('P001','C003','2017-09-02','2017-12-02'),('P002','C004','2017-03-02','2017-08-02'),('P002','C005','2017-03-02','2017-08-02'),('P002','C006','2017-09-02','2017-12-02');
/*!40000 ALTER TABLE `lecture` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `professor`
--

DROP TABLE IF EXISTS `professor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `professor` (
  `pcode` char(4) NOT NULL,
  `pname` char(10) DEFAULT NULL,
  `pdept` char(12) DEFAULT NULL,
  `pphone` char(12) DEFAULT NULL,
  `paddress` char(50) DEFAULT NULL,
  PRIMARY KEY (`pcode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `professor`
--

LOCK TABLES `professor` WRITE;
/*!40000 ALTER TABLE `professor` DISABLE KEYS */;
INSERT INTO `professor` VALUES ('P001','하은용','컴퓨터공학과','0001','서울'),('P002','안창호','컴퓨터공학과','0002','서울'),('P003','이육사','국문학과','0003','강원도'),('P004','박종화','국문학과','0004','경상북도'),('P005','심훈','사학과','0005','전라남도'),('P006','한용운','사학과','0006','충청남도');
/*!40000 ALTER TABLE `professor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `register`
--

DROP TABLE IF EXISTS `register`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `register` (
  `rscode` char(4) NOT NULL,
  `rccode` char(4) NOT NULL,
  `score` int DEFAULT NULL,
  PRIMARY KEY (`rscode`,`rccode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `register`
--

LOCK TABLES `register` WRITE;
/*!40000 ALTER TABLE `register` DISABLE KEYS */;
INSERT INTO `register` VALUES ('S001','C001',90),('S001','C002',85),('S001','C003',80),('S002','C001',76),('S002','C002',88),('S002','C003',78);
/*!40000 ALTER TABLE `register` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `score`
--

DROP TABLE IF EXISTS `score`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `score` (
  `V1` bigint DEFAULT NULL,
  `V2` bigint DEFAULT NULL,
  `V3` bigint DEFAULT NULL,
  `V4` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `score`
--

LOCK TABLES `score` WRITE;
/*!40000 ALTER TABLE `score` DISABLE KEYS */;
INSERT INTO `score` VALUES (1,90,80,70),(2,90,88,70),(3,90,89,70),(4,90,87,70),(5,90,60,70),(6,100,100,100),(7,100,100,100),(8,100,100,100),(9,100,100,100),(10,100,100,100),(11,90,80,70),(12,90,88,70);
/*!40000 ALTER TABLE `score` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `scode` char(4) NOT NULL,
  `sname` char(10) DEFAULT NULL,
  `sdept` char(12) DEFAULT NULL,
  `sphone` char(12) DEFAULT NULL,
  `saddress` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`scode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES ('S002','최민국','컴퓨터공학과','234-5678',NULL),('S005','김상진','사학과','567-8901',NULL),('S006','황정숙','사학과','678-9012',NULL),('S100','박소명','컴퓨터공학과','123-4567',NULL);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-10 14:07:55