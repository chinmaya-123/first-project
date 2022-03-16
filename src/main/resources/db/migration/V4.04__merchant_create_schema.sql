CREATE TABLE `merchant` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(255) NOT NULL,
  `type` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `created_at` DATE  DEFAULT NULL,
  `updated_at` DATE  DEFAULT NULL,
  PRIMARY KEY (`id`)
)