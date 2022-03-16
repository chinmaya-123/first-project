ALTER TABLE `consumer`
ADD COLUMN `user_id` INT NOT NULL ;


ALTER TABLE `consumer`
ADD CONSTRAINT fk_consumer
FOREIGN KEY (user_id) REFERENCES auth_user(id);
