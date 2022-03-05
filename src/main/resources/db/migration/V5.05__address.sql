CREATE TABLE `address` (
  `id` int NOT NULL AUTO_INCREMENT,
  `address1` varchar(45) NOT NULL,
  `address2` varchar(45) DEFAULT NULL,
  `country` varchar(45) NOT NULL,
  `city` varchar(45) NOT NULL,
  `state` varchar(45) NOT NULL,
  `postal_code` int NOT NULL,
  `mobile` bigint NOT NULL,
  PRIMARY KEY (`id`)
  )