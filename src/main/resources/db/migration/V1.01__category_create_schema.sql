CREATE TABLE `category` (
  `id` int NOT NULL AUTO_INCREMENT ,
  `name` varchar(45) NOT NULL,
  `description` varchar(255) NOT NULL,
  `created_at` DATE DEFAULT NULL,
  `updated_at`DATE DEFAULT NULL,
  PRIMARY KEY (`id`)
) 

