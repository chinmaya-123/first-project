create table`user_role`(
  `user_id` int NOT NULL,
  `role_id` int NOT NULL,
  FOREIGN KEY (`user_id`) REFERENCES auth_user(id),
  FOREIGN KEY (`role_id`) REFERENCES roles(id)
  )