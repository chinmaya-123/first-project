
CREATE TABLE `product` (
  `id` int NOT NULL,
  `name` varchar(45)  NOT NULL,
  `description` text,
  `category_id` int   NOT NULL,
  `quantity` int   NOT NULL,
  `price` double   NOT NULL,
  `created_at` DATE DEFAULT NULL,
  `modified_at` DATE DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1` (`category_id`),
  CONSTRAINT `FK1` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
)



