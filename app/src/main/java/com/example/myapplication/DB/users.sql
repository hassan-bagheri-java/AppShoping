
USE hassanlo_shop;



CREATE TABLE `users`  (
  `email` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
   PRIMARY KEY (email)
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;




INSERT INTO `users` (`email`, `password`) VALUES ('hassan1@gmail.com', '123456');


SELECT * FROM users
WHERE email IN ('hassan1@gmail.com') AND password IN ('123456');