create table`cart`(
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45)  NOT NULL,
  `quantity` int   NOT NULL,
  `price` double   NOT NULL,
  `consumer_id` int NOT NULL,
   PRIMARY KEY (`id`),
   KEY `fk_cart_consumer_id` (`consumer_id`),
   CONSTRAINT `fk_cart_consumer_id` FOREIGN KEY (`consumer_id`) REFERENCES `consumer` (`id`)
)