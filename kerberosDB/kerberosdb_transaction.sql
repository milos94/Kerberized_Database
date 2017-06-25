CREATE DATABASE  IF NOT EXISTS `kerberosdb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `kerberosdb`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: kerberosdb
-- ------------------------------------------------------
-- Server version	5.7.18-log

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
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transaction` (
  `transaction_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `value` varchar(50) NOT NULL,
  `type` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`transaction_id`),
  KEY `USER_FK_idx` (`user_id`),
  CONSTRAINT `USER_FK` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=157 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
INSERT INTO `transaction` VALUES (1,4,'TAUy3WJayWfDdgRc9cBEpg==','Deposit'),(2,4,'T1YDknKN3hBjM6xs6PYFMg==','Deposit'),(3,3,'0/Vlbt5MK+0qpD9GkiHjSw==','Deposit'),(4,2,'ub+tefSrgajbG0lgB8wcGQ==','Withdraw'),(5,4,'u4ECwD9lK14U45tGGuMkgA==','Deposit'),(6,4,'3QsEW+u8pkUuL1qJDWtEew==','Deposit'),(7,4,'QDQo20q1xqksIfO0K53HfQ==','Deposit'),(8,1,'rS3O9trkPPtCIiGSUohnxA==','Deposit'),(9,4,'nTj3VeQa3gtTTUBJxpO3gg==','Withdraw'),(10,3,'GV1vvltLTaUCE1CVh7eJAQ==','Deposit'),(11,1,'RMS8Hsu2uQaa/wlNpMaHsg==','Withdraw'),(12,2,'vB1NbRqRTpYYYFrBRBKt1g==','Withdraw'),(13,4,'AyIXDPS0QpWYwcfHVjOP5A==','Withdraw'),(14,3,'mh3WscJGRNENUk/mCjmcAA==','Withdraw'),(15,2,'ldT6a4PoRUGg5wn4vU+xug==','Withdraw'),(16,3,'WY+s530ynlNdv1IuXg+FMw==','Deposit'),(17,2,'5gTVb9pnhvR0sznrZSjboQ==','Withdraw'),(18,1,'n9gY/0VsK4jNd4OZurcvAA==','Withdraw'),(19,4,'Z/fQ0IUGHCLOvfB5v3FYcQ==','Deposit'),(20,4,'yGMKzHGCPpuMQezYMeU+xw==','Deposit'),(21,2,'d2FclhJezaOxH98efDvKxg==','Withdraw'),(22,1,'mGyOvpyAJAet61VYpg23pg==','Withdraw'),(23,2,'NpiRSAowpzorFMueu4prgw==','Withdraw'),(24,2,'KfaFTCivVyC/mB3MCN6/tQ==','Withdraw'),(25,4,'ikGBwINGyirX9I+mDa6yeg==','Deposit'),(26,2,'2CMuViNgynxLNUr8ve7eWg==','Deposit'),(27,2,'1k+MG6eOaC3iny5fA+ut6g==','Deposit'),(28,4,'h1FEZWkMkbnU9swJyqqb2A==','Withdraw'),(29,1,'YZXwR1A8ExIO/p4Tb5Ladg==','Deposit'),(30,4,'c0fXFWuTkYCM2NdeSmgAlA==','Deposit'),(31,4,'wRnbORtd9Tr96I62cj7Svw==','Deposit'),(32,1,'RjGI45by8RG7vYCXNclNdA==','Deposit'),(33,2,'glHJ+kZp6fgYD5j13f2MLw==','Deposit'),(34,1,'jZI8n0oaYUMMG+rpnQgXRg==','Withdraw'),(35,1,'8H0NhRRxP5MtoNCGX8WUGg==','Deposit'),(36,2,'s7u+Ho391z/1hLCOG6+dvw==','Withdraw'),(37,1,'s/Zyi0isN313pFDawCBdyA==','Deposit'),(38,3,'b/ZacsfxjXN1dxHXlFcgnQ==','Deposit'),(39,1,'9Eby6cQcYN8ECgQ8O1OSEA==','Withdraw'),(40,4,'WGfooAA5zfJco8zQLyXraA==','Deposit'),(41,4,'3QvBPvupi06kN1eusfTTVQ==','Deposit'),(42,4,'+ko7uQv7JqxDld5vYBp+0w==','Withdraw'),(43,4,'bwLTwiiYzNAS+yXaDye0kg==','Withdraw'),(44,2,'X89GngHfx47U7nDLU2L12Q==','Deposit'),(45,4,'h1FEZWkMkbnU9swJyqqb2A==','Deposit'),(46,4,'/63+G3+JHYE6LJL5rt3kVw==','Withdraw'),(47,1,'axsi/UIMoIXFU/no/Y3IHw==','Deposit'),(48,4,'FpNdh9+SL2WmcDo31PB6Hw==','Withdraw'),(49,2,'UIPCItuH9Pi2K+Tfdhy65g==','Deposit'),(50,3,'Z7Xlvx/cOiDbO1fa1cUjLw==','Deposit'),(51,3,'J0+7f2hLedAqtv4KCjHTgw==','Withdraw'),(52,2,'czOsY1v4OP8f6wbgYT3Dkw==','Withdraw'),(53,3,'gSx1SjW7ih3QQPvluWIFPg==','Withdraw'),(54,2,'HBaMB/YFhUJDFhEkugUwog==','Withdraw'),(55,2,'gH8IqsZH7CaZQdg/9XQcFw==','Withdraw'),(56,3,'wxjBFBeWpflNjnc40Y/3Og==','Withdraw'),(57,1,'8Lk2+hvWonmZpeDIpRNu+A==','Deposit'),(58,2,'D0JF4aDEKDC3jv+TXGqsrA==','Deposit'),(59,2,'O/q2Iud/CVy442P8/HzgGg==','Withdraw'),(60,3,'iuZO2sty0pTSoJXnC5U7hg==','Deposit'),(61,1,'qnDszm3phtFy7DfczDY/hw==','Withdraw'),(62,3,'KRK9ct638gJ4A9T9R/fepg==','Deposit'),(63,1,'xAqmT4kxZr9rOrVjN2ximA==','Deposit'),(64,1,'4hU6L+m3u5Pvn1NUGWTbhw==','Withdraw'),(65,2,'DGQfYeHN/yledkqjpbVyuQ==','Deposit'),(66,2,'fWjTqtPAXezTEZtmqCwEPQ==','Withdraw'),(67,4,'ezD46uyh9VcqAezxpK9nrg==','Withdraw'),(68,2,'3A1Quq8XtLFvsKtJ8T3Ztw==','Deposit'),(69,1,'Uft8nnDEzT+jPQREbWR6VA==','Deposit'),(70,3,'WnIolRX5pah/3bkswzpK4g==','Deposit'),(71,3,'axsi/UIMoIXFU/no/Y3IHw==','Deposit'),(72,4,'GNl88CGLHZQMQ2xuJaRw8g==','Deposit'),(73,4,'uWaB1hP7P5tT+NSJhS4xUA==','Deposit'),(74,2,'GNl88CGLHZQMQ2xuJaRw8g==','Deposit'),(75,2,'9BNo/UPTrfmVytmsdvSxag==','Deposit'),(76,2,'DwjF4KKVhxx4pv9mfvHWRQ==','Deposit'),(77,1,'UwYwg2Af6rRMFX8Ge1Yc4Q==','Withdraw'),(78,4,'KEe9D5z2qY89nFHMD2KybQ==','Withdraw'),(79,1,'eReAS8np7ta5mVJLBBB+2Q==','Deposit'),(80,2,'jdYg4XTddM2GVs5vabqX3A==','Withdraw'),(81,2,'k+C7ARKOMCbvs9T7L2cKcA==','Withdraw'),(82,2,'5w+5ImBgwwlDYEfRLjGmDQ==','Deposit'),(83,4,'WGfooAA5zfJco8zQLyXraA==','Withdraw'),(84,2,'nOxLIjMxHpbMDC/ef0ax3w==','Withdraw'),(85,1,'mhxnB3fHM4A730rjHM0qoA==','Withdraw'),(86,1,'UwYwg2Af6rRMFX8Ge1Yc4Q==','Withdraw'),(87,3,'+PPGtukDGdoq8yRb3gpazg==','Deposit'),(88,1,'fhommGTEopiFCo8Raj8XjQ==','Withdraw'),(89,1,'uWaB1hP7P5tT+NSJhS4xUA==','Deposit'),(90,4,'FpEEMzUupdn5XeWc4CRvVw==','Withdraw'),(91,3,'FnTykO3I10LN5ybVLDee8g==','Withdraw'),(92,3,'RMEvTrUFN5JY0KLYUoSO6g==','Deposit'),(93,2,'4/0wIj+TlF6lCh3/Sg01JQ==','Deposit'),(94,4,'SCZM9ZAGnBNgU+7iBFN1Eg==','Deposit'),(95,4,'b+g8JFTZF0lIa7UUQX0/Mw==','Withdraw'),(96,3,'I5LgqwkuaY2Ks8p0grFAtw==','Withdraw'),(97,1,'ti4Peq7u0EvD9PrbsXzSog==','Deposit'),(98,1,'C5MynUavwHQiKdsmU42nlQ==','Withdraw'),(99,4,'pcdS/X+Cr2rmZbKG4n4cng==','Deposit'),(100,4,'9cGZLdpY4BmtMUqu+cu2rA==','Withdraw'),(101,1,'Ws1RdVccT0fisPE8jSemLw==','Withdraw'),(102,1,'yl5IasYA1VQNAakM6UrrvQ==','Deposit'),(103,4,'TzL46XMYK+sDn+jnENDx9w==','Deposit'),(104,3,'0pIsXgRN4czccU9wRetBVg==','Withdraw'),(105,3,'YZASXOD0QNs/MWMBSaxJZA==','Withdraw'),(106,4,'jdqi7J9Y31hEaaKiLESTSg==','Withdraw'),(107,4,'Ps4mucJRSDaWPfy34ym5RA==','Withdraw'),(108,4,'plniE+1u8M7zeVjcHwK5sQ==','Deposit'),(109,1,'+Kn2/fPOhL7nkXwgelV0CA==','Deposit'),(110,3,'0pIsXgRN4czccU9wRetBVg==','Deposit'),(111,3,'xD3vPa7AyUi6d1w8UKZyfA==','Withdraw'),(112,3,'ILlWtckR4BVhNh4zYyhT0w==','Deposit'),(113,1,'h/NyXjIsGg8c7mFFQ4eO7A==','Deposit'),(114,3,'RAEccgNfxRNQR6KOd3UEAw==','Withdraw'),(115,3,'yGeCSgf4kcBWN/OBB2Lj8Q==','Withdraw'),(116,2,'EGXwHUkof7aRq7+eX+HKDw==','Withdraw'),(117,2,'plniE+1u8M7zeVjcHwK5sQ==','Withdraw'),(118,1,'qlNPcgUEveBERPWnMnXu2A==','Deposit'),(119,2,'LNR3Tgus9XvpQxuoK/DHdQ==','Deposit'),(120,1,'rugz0xIdycC/DOL2In4omg==','Deposit'),(121,1,'MeXF9RqGLlbCnCTmJpmpng==','Withdraw'),(122,3,'6PdQ6ZMCsw5AjZfnjjzXQQ==','Deposit'),(123,3,'WMySshzCzb7LEfuouu/A6Q==','Withdraw'),(124,1,'6rFVVpUYi+ai0ID0b/K+ng==','Withdraw'),(125,1,'jVyb2tJfew2zI9wnmQsvqw==','Withdraw'),(126,4,'somEpjqdZ5mZdMLIe4mpig==','Withdraw'),(127,1,'9jdtGVAT46Rb7z+UlKazsw==','Withdraw'),(128,2,'jYmRCaRfaJvG8DzlyOp2rg==','Withdraw'),(129,4,'bT8ePMuFIRSE2nrhG8N1Wg==','Withdraw'),(130,2,'+Kn2/fPOhL7nkXwgelV0CA==','Withdraw'),(131,1,'rS3O9trkPPtCIiGSUohnxA==','Withdraw'),(132,3,'R/jkD0k1Wt3FHABk/Wnp5A==','Withdraw'),(133,3,'ziPiqZAWhyQwP4UZOf0TDQ==','Withdraw'),(134,1,'Z7Xlvx/cOiDbO1fa1cUjLw==','Withdraw'),(135,4,'s285P72a3gG9umKGujlt1A==','Withdraw'),(136,2,'l56S1qSr+MC+uTFSKOMang==','Withdraw'),(137,4,'PA/SZ1f41o5zknltFromQA==','Deposit'),(138,4,'MKaDVMFi05l47SGC/QfO0A==','Deposit'),(139,1,'9x+iP0dxelf+T45uqeN/Xg==','Deposit'),(140,1,'FpdHtBeac3i3mnl2G25zZw==','Deposit'),(141,2,'Zgy/SmL2sE7EfB+XEXsKOQ==','Deposit'),(142,1,'hKySpW4EvhS+BAD5jqWGuw==','Withdraw'),(143,2,'dWjoGVSmjw7puhSJLAqKiA==','Withdraw'),(144,3,'XWdP3p6bNNB9QimNsE0T+A==','Withdraw'),(145,1,'9BCnBRy+fUz/ehtmqu3fKg==','Withdraw'),(146,4,'nehHWKb4LMV5OgoRXB18rw==','Withdraw'),(147,2,'85y5mps3Rlw7EXanF6LQJw==','Deposit'),(148,4,'H2rr4VqJtTJ8I2EmiYvP/Q==','Deposit'),(149,2,'8GNGdonrX/wQDV+932o0IQ==','Withdraw'),(150,4,'wI2NggXk2tysKwdAfbYLpQ==','Deposit'),(151,1,'3QvBPvupi06kN1eusfTTVQ==','Withdraw'),(152,2,'3QvBPvupi06kN1eusfTTVQ==','Withdraw'),(153,2,'3QvBPvupi06kN1eusfTTVQ==','Withdraw'),(154,2,'3QvBPvupi06kN1eusfTTVQ==','Withdraw'),(155,2,'3QvBPvupi06kN1eusfTTVQ==','Withdraw'),(156,1,'dyLyOXnGCm4P0tDzRecDfw==','Deposit');
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-25 19:07:56
