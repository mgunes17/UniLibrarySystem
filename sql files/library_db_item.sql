-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: library_db
-- ------------------------------------------------------
-- Server version	5.7.11-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item` (
  `item_no` int(11) NOT NULL AUTO_INCREMENT,
  `item_state` smallint(1) NOT NULL,
  `current__user` varchar(45) DEFAULT NULL,
  `item_type` int(11) NOT NULL,
  `item_name` varchar(45) NOT NULL,
  PRIMARY KEY (`item_no`),
  KEY `stateFK_idx` (`item_state`),
  KEY `currentUserFK_idx` (`current__user`),
  KEY `itemtypeFK_idx` (`item_type`),
  CONSTRAINT `itemtypeFK` FOREIGN KEY (`item_type`) REFERENCES `item_type` (`type_no`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `stateFK` FOREIGN KEY (`item_state`) REFERENCES `state` (`state_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `userFK` FOREIGN KEY (`current__user`) REFERENCES `users` (`mail`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES (7,0,NULL,1,'Cehennem'),(8,0,NULL,2,'Lalegul'),(10,2,'ercan',2,'Express'),(11,2,'ercan',1,'Olasılıksız'),(12,0,NULL,1,'Empati'),(13,0,NULL,1,'Beyaz Diş'),(14,2,'ercan',2,'National Geographic');
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-10 23:37:05
