CREATE TABLE `user_address` (
`user_id` int NOT NULL,
`address_id` int NOT NULL,
PRIMARY KEY (`user_id`,`address_id`),
UNIQUE KEY `address_id_UNIQUE` (`address_id`),
KEY `fk_user` (`user_id`),
KEY `fk_address` (`address_id`),
CONSTRAINT `fk_address` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`),
CONSTRAINT `fk_user` FOREIGN KEY (`user_id`) REFERENCES `consumer` (`id`)
)