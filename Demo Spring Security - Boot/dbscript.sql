-- MySQL dump 10.13  Distrib 8.1.0, for Win64 (x86_64)
--
-- Host: localhost    Database: school_management
-- ------------------------------------------------------
-- Server version	8.1.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` binary(16) NOT NULL,
  `first_name` varchar(100) COLLATE utf8mb4_0900_as_cs DEFAULT NULL,
  `last_name` varchar(100) COLLATE utf8mb4_0900_as_cs DEFAULT NULL,
  `account_name` varchar(100) COLLATE utf8mb4_0900_as_cs NOT NULL,
  `password` varchar(128) COLLATE utf8mb4_0900_as_cs NOT NULL,
  `user_role` binary(16) NOT NULL,
  `dob` date NOT NULL,
  `address` varchar(256) COLLATE utf8mb4_0900_as_cs DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_un` (`account_name`),
  KEY `user_FK_1` (`user_role`),
  CONSTRAINT `user_FK_1` FOREIGN KEY (`user_role`) REFERENCES `user_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_as_cs;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (_binary ',,ä£˙=@œÅ∑z\ıóΩ\Œ','Ti·∫øn D≈©ng','B√πi','liquidrekto','$2a$10$SSfat0NJE2P.uPzVzQ12w.VnjNRgTsAsOuiNvNowoZyj2jZtNdRqi',_binary '@©ÖT±ºGâÜ\·\Õ˛≈µÆy','2003-02-22','fpt hn'),(_binary '.(pj•L;âÑÖA-\Ôä','FPT','Admin','fptadmin','$2a$10$f2HuzNQIVJlSQ.gtjIS/U.UOOlWu0XFPOrighqTCOv6ajiymOD9mS',_binary '\„w∑\\rJÎí¨Uû<\¬¡','1970-01-01','fpt'),(_binary 'â©1MîùC\Ôëuk\\ÅJ∏¢','FPT','Teacher','fptteach','$2a$10$H3UQjxEtkMCrSu1KxGjA.u5lfn/ljFsuXY1NusKdSHM3eoPckmpGW',_binary '!\»\ﬂ9uC˚•≠¸rﬁíWa','1990-05-25','fpt');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `id` binary(16) NOT NULL,
  `role_name` varchar(100) COLLATE utf8mb4_0900_as_cs NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_role_un` (`role_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_as_cs;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (_binary '\„w∑\\rJÎí¨Uû<\¬¡','USER_ADMIN'),(_binary '@©ÖT±ºGâÜ\·\Õ˛≈µÆy','USER_STUDENT'),(_binary '!\»\ﬂ9uC˚•≠¸rﬁíWa','USER_TEACHER');
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'school_management'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-08-23 15:06:37
