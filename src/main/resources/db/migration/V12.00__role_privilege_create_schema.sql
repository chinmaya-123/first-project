create table`role_privilege`(
  `role_id` int NOT NULL,
  `privilege_id` int NOT NULL,
  FOREIGN KEY (`role_id`) REFERENCES roles(id),
  FOREIGN KEY (`privilege_id`) REFERENCES privileges(id)
  )