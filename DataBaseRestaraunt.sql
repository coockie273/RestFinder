-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: restarauntfinder
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `keyword`
--

DROP TABLE IF EXISTS `keyword`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `keyword` (
  `id` int NOT NULL,
  `name` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `keyword`
--

LOCK TABLES `keyword` WRITE;
/*!40000 ALTER TABLE `keyword` DISABLE KEYS */;
INSERT INTO `keyword` VALUES (1,'meal'),(2,'fish'),(3,'vegetarian'),(4,'vegetable'),(5,'alcohol'),(6,'pizza'),(7,'fast food'),(8,'student menu'),(9,'Family-friendly'),(10,'kids menu'),(11,'Steakhouse'),(12,'seafood'),(13,'gluten-free'),(14,'romantic atmosphere'),(15,'kids\' menu'),(16,'Outdoor seating');
/*!40000 ALTER TABLE `keyword` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `keyword_user`
--

DROP TABLE IF EXISTS `keyword_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `keyword_user` (
  `user_id` bigint NOT NULL,
  `keyword_id` bigint NOT NULL,
  PRIMARY KEY (`keyword_id`,`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `keyword_user`
--

LOCK TABLES `keyword_user` WRITE;
/*!40000 ALTER TABLE `keyword_user` DISABLE KEYS */;
INSERT INTO `keyword_user` VALUES (152,2);
/*!40000 ALTER TABLE `keyword_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kitchen`
--

DROP TABLE IF EXISTS `kitchen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kitchen` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kitchen`
--

LOCK TABLES `kitchen` WRITE;
/*!40000 ALTER TABLE `kitchen` DISABLE KEYS */;
INSERT INTO `kitchen` VALUES (1,'Italian'),(2,'French'),(3,'Chinese'),(4,'Japanese'),(5,'Mexican'),(6,'Indian'),(7,'Thai'),(8,'Greek'),(9,'Spanish'),(10,'Korean'),(11,'Lebanese'),(12,'Vietnamese'),(13,'Turkish'),(14,'Brazilian'),(15,'Russian'),(16,'American'),(17,'British'),(18,'Ethiopian'),(19,'Moroccan'),(20,'Caribbean');
/*!40000 ALTER TABLE `kitchen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaraunt`
--

DROP TABLE IF EXISTS `restaraunt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `restaraunt` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL,
  `coordinate_x` int NOT NULL,
  `coordinate_y` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaraunt`
--

LOCK TABLES `restaraunt` WRITE;
/*!40000 ALTER TABLE `restaraunt` DISABLE KEYS */;
INSERT INTO `restaraunt` VALUES (1,'The Rustic Table',55,40),(2,'Spice Haven',57,35),(3,'Ocean Breeze Grill',47,45),(4,'Bella Italia Trattoria',67,30),(5,'The Green Leaf Cafe',65,41),(6,'Seafood Delight',64,43),(7,'The Vintage Diner',54,37),(8,'Fire & Smoke Steakhouse',56,37),(9,'Fusion Flavors',57,47),(10,'The Cozy Corner Bistro',58,37),(11,'Sushi Sensation',55,30),(12,'La Petite Brasserie',54,35),(13,'The Hungry Pelican',60,37),(14,'Thai Orchid Garden',60,35),(15,'Gourmet Galore',49,35),(16,'The Spice Route',49,37),(17,'Heavenly Delights Bakery',65,29),(18,'Continental Cravings',58,31),(19,'The Wholesome Plate',55,37),(20,'Pizzeria Paradiso',56,37);
/*!40000 ALTER TABLE `restaraunt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaraunt_keyword`
--

DROP TABLE IF EXISTS `restaraunt_keyword`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `restaraunt_keyword` (
  `restaraunt_id` int NOT NULL,
  `keyword_id` int NOT NULL,
  PRIMARY KEY (`restaraunt_id`,`keyword_id`),
  KEY `res_keyword_id_idx` (`keyword_id`),
  CONSTRAINT `res_keyword_id` FOREIGN KEY (`keyword_id`) REFERENCES `keyword` (`id`),
  CONSTRAINT `res_restaraunt_id` FOREIGN KEY (`restaraunt_id`) REFERENCES `restaraunt` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaraunt_keyword`
--

LOCK TABLES `restaraunt_keyword` WRITE;
/*!40000 ALTER TABLE `restaraunt_keyword` DISABLE KEYS */;
INSERT INTO `restaraunt_keyword` VALUES (1,1),(4,1),(5,1),(11,1),(12,1),(17,1),(18,1),(1,2),(5,2),(11,2),(12,2),(15,2),(18,2),(11,4),(13,5),(16,6),(5,7),(14,7),(3,8),(5,8),(6,8),(16,8),(5,9),(7,10),(9,10),(11,10),(9,11),(8,14),(5,15),(3,16),(7,16),(8,16),(10,16),(13,16);
/*!40000 ALTER TABLE `restaraunt_keyword` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaraunt_kitchen`
--

DROP TABLE IF EXISTS `restaraunt_kitchen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `restaraunt_kitchen` (
  `restaraunt_id` int NOT NULL,
  `kitchen_id` int NOT NULL,
  PRIMARY KEY (`restaraunt_id`,`kitchen_id`),
  KEY `r_kitchen_id_idx` (`kitchen_id`),
  CONSTRAINT `r_kitchen_id` FOREIGN KEY (`kitchen_id`) REFERENCES `kitchen` (`id`),
  CONSTRAINT `r_restaraunt_id` FOREIGN KEY (`restaraunt_id`) REFERENCES `restaraunt` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaraunt_kitchen`
--

LOCK TABLES `restaraunt_kitchen` WRITE;
/*!40000 ALTER TABLE `restaraunt_kitchen` DISABLE KEYS */;
INSERT INTO `restaraunt_kitchen` VALUES (1,1),(4,1),(5,1),(11,1),(17,1),(18,1),(1,2),(5,2),(11,2),(12,2),(15,2),(18,2),(11,4),(2,6),(16,6),(2,7),(5,7),(14,7),(3,8),(5,8),(6,8),(16,8),(5,9),(9,10),(11,10),(9,11),(8,14),(5,15),(17,15),(3,16),(7,16),(8,16),(10,16),(13,16),(17,16),(7,17),(12,17),(19,19),(13,20);
/*!40000 ALTER TABLE `restaraunt_kitchen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaraunt_seq`
--

DROP TABLE IF EXISTS `restaraunt_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `restaraunt_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaraunt_seq`
--

LOCK TABLES `restaraunt_seq` WRITE;
/*!40000 ALTER TABLE `restaraunt_seq` DISABLE KEYS */;
INSERT INTO `restaraunt_seq` VALUES (1);
/*!40000 ALTER TABLE `restaraunt_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` text NOT NULL,
  `second_name` text NOT NULL,
  `login` text NOT NULL,
  `password` text NOT NULL,
  `coordinates_x` int NOT NULL,
  `coordinates_y` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=153 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (102,'stas','statib','kingstast1446','stas11',37,39),(152,'stasik','toporov','st','st12',51,35);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_keyword_preference`
--

DROP TABLE IF EXISTS `user_keyword_preference`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_keyword_preference` (
  `user_id` int NOT NULL,
  `keyword_id` int NOT NULL,
  `id` int NOT NULL,
  PRIMARY KEY (`user_id`,`keyword_id`),
  KEY `pkrit_keyword_id_idx` (`keyword_id`),
  CONSTRAINT `pkrit_keyword_id` FOREIGN KEY (`keyword_id`) REFERENCES `keyword` (`id`),
  CONSTRAINT `prkit_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_keyword_preference`
--

LOCK TABLES `user_keyword_preference` WRITE;
/*!40000 ALTER TABLE `user_keyword_preference` DISABLE KEYS */;
INSERT INTO `user_keyword_preference` VALUES (152,1,1),(152,2,2);
/*!40000 ALTER TABLE `user_keyword_preference` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_keyword_preference_seq`
--

DROP TABLE IF EXISTS `user_keyword_preference_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_keyword_preference_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_keyword_preference_seq`
--

LOCK TABLES `user_keyword_preference_seq` WRITE;
/*!40000 ALTER TABLE `user_keyword_preference_seq` DISABLE KEYS */;
INSERT INTO `user_keyword_preference_seq` VALUES (1);
/*!40000 ALTER TABLE `user_keyword_preference_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_kitchen_preference`
--

DROP TABLE IF EXISTS `user_kitchen_preference`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_kitchen_preference` (
  `user_id` int NOT NULL,
  `kitchen_id` int NOT NULL,
  `id` int NOT NULL,
  PRIMARY KEY (`user_id`,`kitchen_id`),
  KEY `prk_kitchen_id_idx` (`kitchen_id`),
  CONSTRAINT `prk_kitchen_id` FOREIGN KEY (`kitchen_id`) REFERENCES `kitchen` (`id`),
  CONSTRAINT `prk_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_kitchen_preference`
--

LOCK TABLES `user_kitchen_preference` WRITE;
/*!40000 ALTER TABLE `user_kitchen_preference` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_kitchen_preference` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_kitchen_preference_seq`
--

DROP TABLE IF EXISTS `user_kitchen_preference_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_kitchen_preference_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_kitchen_preference_seq`
--

LOCK TABLES `user_kitchen_preference_seq` WRITE;
/*!40000 ALTER TABLE `user_kitchen_preference_seq` DISABLE KEYS */;
INSERT INTO `user_kitchen_preference_seq` VALUES (1);
/*!40000 ALTER TABLE `user_kitchen_preference_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_restaraunt`
--

DROP TABLE IF EXISTS `user_restaraunt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_restaraunt` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `restaraunt_id` int NOT NULL,
  `id` bigint NOT NULL,
  PRIMARY KEY (`user_id`,`restaraunt_id`),
  KEY `visited_restaraunt_id_idx` (`restaraunt_id`),
  CONSTRAINT `visited_restaraunt_id` FOREIGN KEY (`restaraunt_id`) REFERENCES `restaraunt` (`id`),
  CONSTRAINT `visited_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=153 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_restaraunt`
--

LOCK TABLES `user_restaraunt` WRITE;
/*!40000 ALTER TABLE `user_restaraunt` DISABLE KEYS */;
INSERT INTO `user_restaraunt` VALUES (152,9,3);
/*!40000 ALTER TABLE `user_restaraunt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_restaraunt_seq`
--

DROP TABLE IF EXISTS `user_restaraunt_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_restaraunt_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_restaraunt_seq`
--

LOCK TABLES `user_restaraunt_seq` WRITE;
/*!40000 ALTER TABLE `user_restaraunt_seq` DISABLE KEYS */;
INSERT INTO `user_restaraunt_seq` VALUES (1);
/*!40000 ALTER TABLE `user_restaraunt_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_seq`
--

DROP TABLE IF EXISTS `user_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_seq`
--

LOCK TABLES `user_seq` WRITE;
/*!40000 ALTER TABLE `user_seq` DISABLE KEYS */;
INSERT INTO `user_seq` VALUES (1);
/*!40000 ALTER TABLE `user_seq` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-11 23:40:04
