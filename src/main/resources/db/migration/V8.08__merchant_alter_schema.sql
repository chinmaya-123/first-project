ALTER TABLE `merchant`
ADD COLUMN `email` VARCHAR(45) NOT NULL ,
ADD COLUMN `user_id` INT NULL AFTER `updated_at`;

ALTER TABLE `merchant`
ADD CONSTRAINT fk_merchant
FOREIGN KEY (user_id) REFERENCES auth_user(id);
