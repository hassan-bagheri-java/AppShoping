CREATE TABLE `cart`  (
  `id_product` int(11) NOT NULL,
  `email` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;



SELECT *
FROM cart
INNER JOIN products ON cart.id_product=products.id;



INSERT INTO `cart` (`id_product`, `email`) VALUES ('17', 'hassan');
INSERT INTO `cart` (`id_product`, `email`) VALUES ('10', 'hassan');
INSERT INTO `cart` (`id_product`, `email`) VALUES ('29', 'hassan');
INSERT INTO `cart` (`id_product`, `email`) VALUES ('10', 'hassan');
INSERT INTO `cart` (`id_product`, `email`) VALUES ('1', 'hassan');
INSERT INTO `cart` (`id_product`, `email`) VALUES ('42', 'hassan');


INSERT INTO `cart` (`id_product`, `email`) VALUES ('17', 'hassan');

DROP PROCEDURE IF EXISTS `insert_cart`;


CREATE PROCEDURE `insert_cart`(IN id_product VARCHAR(200) , IN email VARCHAR(200))
BEGIN
  INSERT INTO `cart` (`id_product`, `email`) VALUES (id_product, email)
	;
END;

CALL insert_cart('33','hassan@gmail.com')


CREATE PROCEDURE `show_cartlist`(IN email VARCHAR(200) )
BEGIN
   SELECT * FROM cart
  WHERE cart.email COLLATE utf8_unicode_ci = email
	;
END