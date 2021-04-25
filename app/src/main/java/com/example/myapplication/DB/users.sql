
USE hassanlo_shop;



CREATE TABLE `users`  (
  `email` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
   PRIMARY KEY (email)
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;




INSERT INTO `users` (`email`, `password`) VALUES ('hassan1@gmail.com', '123456');


SELECT * FROM users
WHERE email IN ('hassan1@gmail.com') AND password IN ('123456');




DROP PROCEDURE IF EXISTS `check_login`;

CREATE PROCEDURE `check_login`(IN email VARCHAR(200) , IN pass VARCHAR(200))
BEGIN
  SELECT * FROM users
  WHERE users.email COLLATE utf8_unicode_ci = email
	AND
	users.password COLLATE utf8_unicode_ci = pass
	;
END;

CALL check_login('hassan1@gmail.com','123456')