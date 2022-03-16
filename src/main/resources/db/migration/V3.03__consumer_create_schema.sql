CREATE TABLE `consumer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(255) NOT NULL,
  `type` varchar(45) DEFAULT NULL,
  `status`varchar(45) DEFAULT NULL,
   PRIMARY KEY (`id`),
)
