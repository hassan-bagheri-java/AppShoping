CREATE TABLE `cart`  (
  `id_product` int(11) NOT NULL,
  `username` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
   PRIMARY KEY (id)
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;



SELECT *
FROM cart
INNER JOIN products ON cart.id_product=products.id;



INSERT INTO `cart` (`id_product`, `username`) VALUES ('17', 'hassan');
INSERT INTO `cart` (`id_product`, `username`) VALUES ('10', 'hassan');
INSERT INTO `cart` (`id_product`, `username`) VALUES ('29', 'hassan');
INSERT INTO `cart` (`id_product`, `username`) VALUES ('10', 'hassan');
INSERT INTO `cart` (`id_product`, `username`) VALUES ('1', 'hassan');
INSERT INTO `cart` (`id_product`, `username`) VALUES ('42', 'hassan');