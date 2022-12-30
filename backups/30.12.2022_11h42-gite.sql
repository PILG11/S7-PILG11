-- MariaDB dump 10.19  Distrib 10.5.18-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: gite
-- ------------------------------------------------------
-- Server version	10.5.18-MariaDB-0+deb11u1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `gite`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `gite` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;

USE `gite`;

--
-- Table structure for table `Actualites`
--

DROP TABLE IF EXISTS `Actualites`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Actualites` (
  `Id` int(11) NOT NULL,
  `Nom` varchar(20) DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `PremièreImage` varchar(255) DEFAULT NULL,
  `SecondeImage` varchar(255) DEFAULT NULL,
  `TroisiemeImage` varchar(255) DEFAULT NULL,
  `QuatriemeImage` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Actualites`
--

LOCK TABLES `Actualites` WRITE;
/*!40000 ALTER TABLE `Actualites` DISABLE KEYS */;
INSERT INTO `Actualites` VALUES (1,'Mariage Champêtre','La saison des mariages n’est pas fini, mariage d’automne ce week-end.\r\n\r\n#mariagechampetre #maineetloire #bassesvalleesangevines #rivesduloirenanjou #salledereceptionmariage #salledereceptionavechebergements','../img/Actualites/premier_post/premier_post.jpg','../img/Actualites/premier_post/premier_post_2.jpg','../img/Actualites/premier_post/premier_post_3.jpg','../img/Actualites/premier_post/premier_post_4.jpg','2022-10-08'),(2,'Les extérieurs','Nos espaces extérieurs et la salle en mode banquet #salledereception #bibou #mariagechampetre #bassesvalleesangevines #romaintouzé #hebergementsinsolites','../img/Actualites/second_post/second_post.jpg','../img/Actualites/second_post/second_post_2.jpg','../img/Actualites/second_post/second_post_3.jpg','../img/Actualites/second_post/second_post_4.jpg','2022-07-24'),(3,'Mariage au logis','Mariage au logis #mariage #decomariage #lydiefleurs #salledereception #maineetloire #bassesvalleesangevines #mariagehebergement','../img/Actualites/troisieme_post/troisieme_post.jpg','../img/Actualites/troisieme_post/troisieme_post_2.jpg','../img/Actualites/troisieme_post/troisieme_post_3.jpg','../img/Actualites/troisieme_post/troisieme_post_4.jpg','2022-07-10'),(4,'Robe de mariée','Robe de mariée de Blandine\r\n\r\n#robedemariee #mariage #mariagechic #cheval #salledereception #hebergementinsolite','../img/Actualites/quatrieme_post/quatrieme_post.jpg',NULL,NULL,NULL,'2022-06-26');
/*!40000 ALTER TABLE `Actualites` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Chambres`
--

DROP TABLE IF EXISTS `Chambres`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Chambres` (
  `Id` int(11) NOT NULL,
  `Nom` varchar(20) DEFAULT NULL,
  `Type` varchar(20) DEFAULT NULL,
  `Places` int(11) DEFAULT NULL,
  `Douche` tinyint(1) DEFAULT NULL,
  `Image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Chambres`
--

LOCK TABLES `Chambres` WRITE;
/*!40000 ALTER TABLE `Chambres` DISABLE KEYS */;
/*!40000 ALTER TABLE `Chambres` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Clients`
--

DROP TABLE IF EXISTS `Clients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Clients` (
  `Id` int(11) NOT NULL,
  `Nom` varchar(20) DEFAULT NULL,
  `Prenom` varchar(20) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `Numero` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Clients`
--

LOCK TABLES `Clients` WRITE;
/*!40000 ALTER TABLE `Clients` DISABLE KEYS */;
/*!40000 ALTER TABLE `Clients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Reservations`
--

DROP TABLE IF EXISTS `Reservations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Reservations` (
  `Id` int(11) NOT NULL,
  `Type` varchar(20) DEFAULT NULL,
  `Valide` tinyint(1) DEFAULT NULL,
  `Date` date DEFAULT NULL,
  `Duree` int(11) DEFAULT NULL,
  `Chambres` int(11) DEFAULT NULL,
  `Salles` int(11) DEFAULT NULL,
  `Client` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `Chambres` (`Chambres`),
  KEY `Salles` (`Salles`),
  KEY `Client` (`Client`),
  CONSTRAINT `Reservations_ibfk_1` FOREIGN KEY (`Chambres`) REFERENCES `Chambres` (`Id`),
  CONSTRAINT `Reservations_ibfk_2` FOREIGN KEY (`Salles`) REFERENCES `Salles` (`Id`),
  CONSTRAINT `Reservations_ibfk_3` FOREIGN KEY (`Client`) REFERENCES `Clients` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Reservations`
--

LOCK TABLES `Reservations` WRITE;
/*!40000 ALTER TABLE `Reservations` DISABLE KEYS */;
/*!40000 ALTER TABLE `Reservations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Salles`
--

DROP TABLE IF EXISTS `Salles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Salles` (
  `Id` int(11) NOT NULL,
  `Nom` varchar(20) DEFAULT NULL,
  `Type` varchar(20) DEFAULT NULL,
  `Capacite` int(11) DEFAULT NULL,
  `Image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Salles`
--

LOCK TABLES `Salles` WRITE;
/*!40000 ALTER TABLE `Salles` DISABLE KEYS */;
/*!40000 ALTER TABLE `Salles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventaire`
--

DROP TABLE IF EXISTS `inventaire`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inventaire` (
  `Id` int(11) NOT NULL,
  `Materiel` varchar(20) DEFAULT NULL,
  `Quantite` int(11) DEFAULT NULL,
  `Etat` enum('neuf','bon','moyen','mauvais') DEFAULT NULL,
  `Lieu` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventaire`
--

LOCK TABLES `inventaire` WRITE;
/*!40000 ALTER TABLE `inventaire` DISABLE KEYS */;
/*!40000 ALTER TABLE `inventaire` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'gite'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-30 11:42:24
