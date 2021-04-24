/*
 Navicat Premium Data Transfer

 Source Server         : xamp
 Source Server Type    : MySQL
 Source Server Version : 100411
 Source Host           : localhost:33066
 Source Schema         : hassanlo_shop

 Target Server Type    : MySQL
 Target Server Version : 100411
 File Encoding         : 65001

 Date: 20/04/2021 21:12:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;


CREATE DATABASE `hassanlo_shop` CHARACTER SET 'utf8' COLLATE 'utf8_persian_ci';

use hassanlo_shop ;

-- ----------------------------
-- Table structure for products
-- ----------------------------
DROP TABLE IF EXISTS `products`;
CREATE TABLE `products`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `imgAddress` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `discount` tinyint(1) NULL DEFAULT NULL,
  `priceDiscount` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `rate` double NULL DEFAULT NULL,
  `description` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
   PRIMARY KEY (id)
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
-- ----------------------------
-- Records of products
-- ----------------------------
INSERT INTO `products` VALUES (1, 'کاپشن چرم', 'http://hasanlo.ir/android/shop/img/newproduct/1.jpg', '135000', 0, '', 3.5, 'شرکت های مختلفی در سطح جهان شروع به ساخت کالاهای متفاوت با نام و نشان های متفاوتی کرده اند که در این میان نام شرکت ها پر اوازه ایرانی نیز به گوش میرسد. در میان این همه برند خارجی و با کیفیت چه خوب است که گهگداری سری به برند های ایرانی و کارهایی که دست سازه های هنرمندان ایرانی به حساب می آید نیز رفته و آن ها را نیز نظاره کنیم. به راستی که چه زیباست اگر به جای تعریف از دیگری، خودمان تعریفی شویم.', 'new_prodect');
INSERT INTO `products` VALUES (2, 'مانیتور NVIDIA', 'http://hasanlo.ir/android/shop/img/newproduct/2.jpg', '1150000', 1, '1000000', 3.8, 'شرکت های مختلفی در سطح جهان شروع به ساخت کالاهای متفاوت با نام و نشان های متفاوتی کرده اند که در این میان نام شرکت ها پر اوازه ایرانی نیز به گوش میرسد. در میان این همه برند خارجی و با کیفیت چه خوب است که گهگداری سری به برند های ایرانی و کارهایی که دست سازه های هنرمندان ایرانی به حساب می آید نیز رفته و آن ها را نیز نظاره کنیم. به راستی که چه زیباست اگر به جای تعریف از دیگری، خودمان تعریفی شویم.', 'new_prodect');
INSERT INTO `products` VALUES (3, 'پاور بانک', 'http://hasanlo.ir/android/shop/img/newproduct/3.jpg', '235000', 0, '', 3.5, 'شرکت های مختلفی در سطح جهان شروع به ساخت کالاهای متفاوت با نام و نشان های متفاوتی کرده اند که در این میان نام شرکت ها پر اوازه ایرانی نیز به گوش میرسد. در میان این همه برند خارجی و با کیفیت چه خوب است که گهگداری سری به برند های ایرانی و کارهایی که دست سازه های هنرمندان ایرانی به حساب می آید نیز رفته و آن ها را نیز نظاره کنیم. به راستی که چه زیباست اگر به جای تعریف از دیگری، خودمان تعریفی شویم.', 'new_prodect');
INSERT INTO `products` VALUES (4, 'اسکیت', 'http://hasanlo.ir/android/shop/img/newproduct/4.jpg', '650000', 0, '', 2.2, 'شرکت های مختلفی در سطح جهان شروع به ساخت کالاهای متفاوت با نام و نشان های متفاوتی کرده اند که در این میان نام شرکت ها پر اوازه ایرانی نیز به گوش میرسد. در میان این همه برند خارجی و با کیفیت چه خوب است که گهگداری سری به برند های ایرانی و کارهایی که دست سازه های هنرمندان ایرانی به حساب می آید نیز رفته و آن ها را نیز نظاره کنیم. به راستی که چه زیباست اگر به جای تعریف از دیگری، خودمان تعریفی شویم.', 'new_prodect');
INSERT INTO `products` VALUES (5, 'ساعت هوشمند', 'http://hasanlo.ir/android/shop/img/newproduct/5.jpg', '540000', 1, '512000', 3.5, 'شرکت های مختلفی در سطح جهان شروع به ساخت کالاهای متفاوت با نام و نشان های متفاوتی کرده اند که در این میان نام شرکت ها پر اوازه ایرانی نیز به گوش میرسد. در میان این همه برند خارجی و با کیفیت چه خوب است که گهگداری سری به برند های ایرانی و کارهایی که دست سازه های هنرمندان ایرانی به حساب می آید نیز رفته و آن ها را نیز نظاره کنیم. به راستی که چه زیباست اگر به جای تعریف از دیگری، خودمان تعریفی شویم.', 'new_prodect');
INSERT INTO `products` VALUES (6, 'اسپیکر', 'http://hasanlo.ir/android/shop/img/newproduct/6.jpg', '145000', 0, '', 4.1, 'شرکت های مختلفی در سطح جهان شروع به ساخت کالاهای متفاوت با نام و نشان های متفاوتی کرده اند که در این میان نام شرکت ها پر اوازه ایرانی نیز به گوش میرسد. در میان این همه برند خارجی و با کیفیت چه خوب است که گهگداری سری به برند های ایرانی و کارهایی که دست سازه های هنرمندان ایرانی به حساب می آید نیز رفته و آن ها را نیز نظاره کنیم. به راستی که چه زیباست اگر به جای تعریف از دیگری، خودمان تعریفی شویم.', 'new_prodect');
INSERT INTO `products` VALUES (7, 'گوشی سامسونگ a50', 'http://hasanlo.ir/android/shop/img/newproduct/7.jpg', '4100000', 0, '', 2.1, 'شرکت های مختلفی در سطح جهان شروع به ساخت کالاهای متفاوت با نام و نشان های متفاوتی کرده اند که در این میان نام شرکت ها پر اوازه ایرانی نیز به گوش میرسد. در میان این همه برند خارجی و با کیفیت چه خوب است که گهگداری سری به برند های ایرانی و کارهایی که دست سازه های هنرمندان ایرانی به حساب می آید نیز رفته و آن ها را نیز نظاره کنیم. به راستی که چه زیباست اگر به جای تعریف از دیگری، خودمان تعریفی شویم.', 'new_prodect');
INSERT INTO `products` VALUES (8, 'تلویزیون 60 اینچ', 'http://hasanlo.ir/android/shop/img/newproduct/8.jpg', '2500000', 1, '2350000', 4.8, 'شرکت های مختلفی در سطح جهان شروع به ساخت کالاهای متفاوت با نام و نشان های متفاوتی کرده اند که در این میان نام شرکت ها پر اوازه ایرانی نیز به گوش میرسد. در میان این همه برند خارجی و با کیفیت چه خوب است که گهگداری سری به برند های ایرانی و کارهایی که دست سازه های هنرمندان ایرانی به حساب می آید نیز رفته و آن ها را نیز نظاره کنیم. به راستی که چه زیباست اگر به جای تعریف از دیگری، خودمان تعریفی شویم.', 'new_prodect');
INSERT INTO `products` VALUES (9, 'وزنه بدنسازی', 'http://hasanlo.ir/android/shop/img/newproduct/9.jpg', '135000', 0, '', 4.9, 'شرکت های مختلفی در سطح جهان شروع به ساخت کالاهای متفاوت با نام و نشان های متفاوتی کرده اند که در این میان نام شرکت ها پر اوازه ایرانی نیز به گوش میرسد. در میان این همه برند خارجی و با کیفیت چه خوب است که گهگداری سری به برند های ایرانی و کارهایی که دست سازه های هنرمندان ایرانی به حساب می آید نیز رفته و آن ها را نیز نظاره کنیم. به راستی که چه زیباست اگر به جای تعریف از دیگری، خودمان تعریفی شویم.', 'new_prodect');
INSERT INTO `products` VALUES (10, 'ساعت', 'http://hasanlo.ir/android/shop/img/newproduct/10.jpg', '250000', 0, '', 3.1, 'شرکت های مختلفی در سطح جهان شروع به ساخت کالاهای متفاوت با نام و نشان های متفاوتی کرده اند که در این میان نام شرکت ها پر اوازه ایرانی نیز به گوش میرسد. در میان این همه برند خارجی و با کیفیت چه خوب است که گهگداری سری به برند های ایرانی و کارهایی که دست سازه های هنرمندان ایرانی به حساب می آید نیز رفته و آن ها را نیز نظاره کنیم. به راستی که چه زیباست اگر به جای تعریف از دیگری، خودمان تعریفی شویم.', 'new_prodect');
INSERT INTO `products` VALUES (11, 'لب تاب ایسوس', 'http://hasanlo.ir/android/shop/img/newproduct/11.jpg', '7000000', 1, '6100000', 5, 'شرکت های مختلفی در سطح جهان شروع به ساخت کالاهای متفاوت با نام و نشان های متفاوتی کرده اند که در این میان نام شرکت ها پر اوازه ایرانی نیز به گوش میرسد. در میان این همه برند خارجی و با کیفیت چه خوب است که گهگداری سری به برند های ایرانی و کارهایی که دست سازه های هنرمندان ایرانی به حساب می آید نیز رفته و آن ها را نیز نظاره کنیم. به راستی که چه زیباست اگر به جای تعریف از دیگری، خودمان تعریفی شویم.', 'new_prodect');
INSERT INTO `products` VALUES (12, 'کفش چرم', 'http://hasanlo.ir/android/shop/img/newproduct/12.jpg', '155000', 0, NULL, 3.3, 'شرکت های مختلفی در سطح جهان شروع به ساخت کالاهای متفاوت با نام و نشان های متفاوتی کرده اند که در این میان نام شرکت ها پر اوازه ایرانی نیز به گوش میرسد. در میان این همه برند خارجی و با کیفیت چه خوب است که گهگداری سری به برند های ایرانی و کارهایی که دست سازه های هنرمندان ایرانی به حساب می آید نیز رفته و آن ها را نیز نظاره کنیم. به راستی که چه زیباست اگر به جای تعریف از دیگری، خودمان تعریفی شویم.', 'new_prodect');
INSERT INTO `products` VALUES (13, 'کفش چمن', 'http://hasanlo.ir/android/shop/img/newproduct/13.jpg', '360000', 0, NULL, 2.7, 'شرکت های مختلفی در سطح جهان شروع به ساخت کالاهای متفاوت با نام و نشان های متفاوتی کرده اند که در این میان نام شرکت ها پر اوازه ایرانی نیز به گوش میرسد. در میان این همه برند خارجی و با کیفیت چه خوب است که گهگداری سری به برند های ایرانی و کارهایی که دست سازه های هنرمندان ایرانی به حساب می آید نیز رفته و آن ها را نیز نظاره کنیم. به راستی که چه زیباست اگر به جای تعریف از دیگری، خودمان تعریفی شویم.', 'new_prodect');
INSERT INTO `products` VALUES (14, 'کفش سالن', 'http://hasanlo.ir/android/shop/img/newproduct/14.jpg', '640000', 0, NULL, 4.3, 'شرکت های مختلفی در سطح جهان شروع به ساخت کالاهای متفاوت با نام و نشان های متفاوتی کرده اند که در این میان نام شرکت ها پر اوازه ایرانی نیز به گوش میرسد. در میان این همه برند خارجی و با کیفیت چه خوب است که گهگداری سری به برند های ایرانی و کارهایی که دست سازه های هنرمندان ایرانی به حساب می آید نیز رفته و آن ها را نیز نظاره کنیم. به راستی که چه زیباست اگر به جای تعریف از دیگری، خودمان تعریفی شویم.', 'new_prodect');
INSERT INTO `products` VALUES (15, 'توپ چمن', 'http://hasanlo.ir/android/shop/img/newproduct/15.jpg', '290000', 1, '250000', 4.5, 'شرکت های مختلفی در سطح جهان شروع به ساخت کالاهای متفاوت با نام و نشان های متفاوتی کرده اند که در این میان نام شرکت ها پر اوازه ایرانی نیز به گوش میرسد. در میان این همه برند خارجی و با کیفیت چه خوب است که گهگداری سری به برند های ایرانی و کارهایی که دست سازه های هنرمندان ایرانی به حساب می آید نیز رفته و آن ها را نیز نظاره کنیم. به راستی که چه زیباست اگر به جای تعریف از دیگری، خودمان تعریفی شویم.', 'new_prodect');
INSERT INTO `products` VALUES (16, 'توپ سالن', 'http://hasanlo.ir/android/shop/img/newproduct/16.jpg', '230000', 0, NULL, 2.2, 'شرکت های مختلفی در سطح جهان شروع به ساخت کالاهای متفاوت با نام و نشان های متفاوتی کرده اند که در این میان نام شرکت ها پر اوازه ایرانی نیز به گوش میرسد. در میان این همه برند خارجی و با کیفیت چه خوب است که گهگداری سری به برند های ایرانی و کارهایی که دست سازه های هنرمندان ایرانی به حساب می آید نیز رفته و آن ها را نیز نظاره کنیم. به راستی که چه زیباست اگر به جای تعریف از دیگری، خودمان تعریفی شویم.', 'new_prodect');
INSERT INTO `products` VALUES (17, 'هنذفری بلوتوث', 'http://hasanlo.ir/android/shop/img/newproduct/17.jpg', '185000', 0, NULL, 1.1, 'شرکت های مختلفی در سطح جهان شروع به ساخت کالاهای متفاوت با نام و نشان های متفاوتی کرده اند که در این میان نام شرکت ها پر اوازه ایرانی نیز به گوش میرسد. در میان این همه برند خارجی و با کیفیت چه خوب است که گهگداری سری به برند های ایرانی و کارهایی که دست سازه های هنرمندان ایرانی به حساب می آید نیز رفته و آن ها را نیز نظاره کنیم. به راستی که چه زیباست اگر به جای تعریف از دیگری، خودمان تعریفی شویم.', 'new_prodect');
INSERT INTO `products` VALUES (18, 'کفش چمن', 'http://hasanlo.ir/android/shop/img/newproduct/13.jpg', '360000', 0, NULL, 2.7, 'شرکت های مختلفی در سطح جهان شروع به ساخت کالاهای متفاوت با نام و نشان های متفاوتی کرده اند که در این میان نام شرکت ها پر اوازه ایرانی نیز به گوش میرسد. در میان این همه برند خارجی و با کیفیت چه خوب است که گهگداری سری به برند های ایرانی و کارهایی که دست سازه های هنرمندان ایرانی به حساب می آید نیز رفته و آن ها را نیز نظاره کنیم. به راستی که چه زیباست اگر به جای تعریف از دیگری، خودمان تعریفی شویم.', 'discount_products');
INSERT INTO `products` VALUES (19, 'توپ چمن', 'http://hasanlo.ir/android/shop/img/newproduct/15.jpg', '290000', 1, '250000', 4.5, 'شرکت های مختلفی در سطح جهان شروع به ساخت کالاهای متفاوت با نام و نشان های متفاوتی کرده اند که در این میان نام شرکت ها پر اوازه ایرانی نیز به گوش میرسد. در میان این همه برند خارجی و با کیفیت چه خوب است که گهگداری سری به برند های ایرانی و کارهایی که دست سازه های هنرمندان ایرانی به حساب می آید نیز رفته و آن ها را نیز نظاره کنیم. به راستی که چه زیباست اگر به جای تعریف از دیگری، خودمان تعریفی شویم.', 'discount_products');
INSERT INTO `products` VALUES (20, 'ساعت', 'http://hasanlo.ir/android/shop/img/newproduct/10.jpg', '250000', 0, '', 3.1, 'شرکت های مختلفی در سطح جهان شروع به ساخت کالاهای متفاوت با نام و نشان های متفاوتی کرده اند که در این میان نام شرکت ها پر اوازه ایرانی نیز به گوش میرسد. در میان این همه برند خارجی و با کیفیت چه خوب است که گهگداری سری به برند های ایرانی و کارهایی که دست سازه های هنرمندان ایرانی به حساب می آید نیز رفته و آن ها را نیز نظاره کنیم. به راستی که چه زیباست اگر به جای تعریف از دیگری، خودمان تعریفی شویم.', 'discount_products');
INSERT INTO `products` VALUES (21, 'اسپیکر', 'http://hasanlo.ir/android/shop/img/newproduct/6.jpg', '145000', 0, '', 4.1, 'شرکت های مختلفی در سطح جهان شروع به ساخت کالاهای متفاوت با نام و نشان های متفاوتی کرده اند که در این میان نام شرکت ها پر اوازه ایرانی نیز به گوش میرسد. در میان این همه برند خارجی و با کیفیت چه خوب است که گهگداری سری به برند های ایرانی و کارهایی که دست سازه های هنرمندان ایرانی به حساب می آید نیز رفته و آن ها را نیز نظاره کنیم. به راستی که چه زیباست اگر به جای تعریف از دیگری، خودمان تعریفی شویم.', 'discount_products');
INSERT INTO `products` VALUES (22, 'اسکیت', 'http://hasanlo.ir/android/shop/img/newproduct/4.jpg', '650000', 0, '', 2.2, 'شرکت های مختلفی در سطح جهان شروع به ساخت کالاهای متفاوت با نام و نشان های متفاوتی کرده اند که در این میان نام شرکت ها پر اوازه ایرانی نیز به گوش میرسد. در میان این همه برند خارجی و با کیفیت چه خوب است که گهگداری سری به برند های ایرانی و کارهایی که دست سازه های هنرمندان ایرانی به حساب می آید نیز رفته و آن ها را نیز نظاره کنیم. به راستی که چه زیباست اگر به جای تعریف از دیگری، خودمان تعریفی شویم.', 'discount_products');
INSERT INTO `products` VALUES (23, 'پاور بانک', 'http://hasanlo.ir/android/shop/img/newproduct/3.jpg', '235000', 0, '', 3.5, 'شرکت های مختلفی در سطح جهان شروع به ساخت کالاهای متفاوت با نام و نشان های متفاوتی کرده اند که در این میان نام شرکت ها پر اوازه ایرانی نیز به گوش میرسد. در میان این همه برند خارجی و با کیفیت چه خوب است که گهگداری سری به برند های ایرانی و کارهایی که دست سازه های هنرمندان ایرانی به حساب می آید نیز رفته و آن ها را نیز نظاره کنیم. به راستی که چه زیباست اگر به جای تعریف از دیگری، خودمان تعریفی شویم.', 'discount_products');
INSERT INTO `products` VALUES (24, 'مانیتور NVIDIA', 'http://hasanlo.ir/android/shop/img/newproduct/2.jpg', '1150000', 1, '1000000', 3.8, 'شرکت های مختلفی در سطح جهان شروع به ساخت کالاهای متفاوت با نام و نشان های متفاوتی کرده اند که در این میان نام شرکت ها پر اوازه ایرانی نیز به گوش میرسد. در میان این همه برند خارجی و با کیفیت چه خوب است که گهگداری سری به برند های ایرانی و کارهایی که دست سازه های هنرمندان ایرانی به حساب می آید نیز رفته و آن ها را نیز نظاره کنیم. به راستی که چه زیباست اگر به جای تعریف از دیگری، خودمان تعریفی شویم.', 'discount_products');
INSERT INTO `products` VALUES (25, 'هنذفری بلوتوث', 'http://hasanlo.ir/android/shop/img/newproduct/17.jpg', '185000', 0, NULL, 1.1, 'شرکت های مختلفی در سطح جهان شروع به ساخت کالاهای متفاوت با نام و نشان های متفاوتی کرده اند که در این میان نام شرکت ها پر اوازه ایرانی نیز به گوش میرسد. در میان این همه برند خارجی و با کیفیت چه خوب است که گهگداری سری به برند های ایرانی و کارهایی که دست سازه های هنرمندان ایرانی به حساب می آید نیز رفته و آن ها را نیز نظاره کنیم. به راستی که چه زیباست اگر به جای تعریف از دیگری، خودمان تعریفی شویم.', 'discount_products');
INSERT INTO `products` VALUES (26, 'ساعت هوشمند', 'http://hasanlo.ir/android/shop/img/newproduct/5.jpg', '540000', 1, '512000', 3.5, 'شرکت های مختلفی در سطح جهان شروع به ساخت کالاهای متفاوت با نام و نشان های متفاوتی کرده اند که در این میان نام شرکت ها پر اوازه ایرانی نیز به گوش میرسد. در میان این همه برند خارجی و با کیفیت چه خوب است که گهگداری سری به برند های ایرانی و کارهایی که دست سازه های هنرمندان ایرانی به حساب می آید نیز رفته و آن ها را نیز نظاره کنیم. به راستی که چه زیباست اگر به جای تعریف از دیگری، خودمان تعریفی شویم.', 'discount_products');
INSERT INTO `products` VALUES (27, 'گوشی سامسونگ a50', 'http://hasanlo.ir/android/shop/img/newproduct/7.jpg', '4100000', 0, '', 2.1, 'شرکت های مختلفی در سطح جهان شروع به ساخت کالاهای متفاوت با نام و نشان های متفاوتی کرده اند که در این میان نام شرکت ها پر اوازه ایرانی نیز به گوش میرسد. در میان این همه برند خارجی و با کیفیت چه خوب است که گهگداری سری به برند های ایرانی و کارهایی که دست سازه های هنرمندان ایرانی به حساب می آید نیز رفته و آن ها را نیز نظاره کنیم. به راستی که چه زیباست اگر به جای تعریف از دیگری، خودمان تعریفی شویم.', 'discount_products');
INSERT INTO `products` VALUES (28, 'تلویزیون 60 اینچ', 'http://hasanlo.ir/android/shop/img/newproduct/8.jpg', '2500000', 1, '2350000', 4.8, 'شرکت های مختلفی در سطح جهان شروع به ساخت کالاهای متفاوت با نام و نشان های متفاوتی کرده اند که در این میان نام شرکت ها پر اوازه ایرانی نیز به گوش میرسد. در میان این همه برند خارجی و با کیفیت چه خوب است که گهگداری سری به برند های ایرانی و کارهایی که دست سازه های هنرمندان ایرانی به حساب می آید نیز رفته و آن ها را نیز نظاره کنیم. به راستی که چه زیباست اگر به جای تعریف از دیگری، خودمان تعریفی شویم.', 'discount_products');
INSERT INTO `products` VALUES (29, 'وزنه بدنسازی', 'http://hasanlo.ir/android/shop/img/newproduct/9.jpg', '135000', 0, '', 4.9, 'شرکت های مختلفی در سطح جهان شروع به ساخت کالاهای متفاوت با نام و نشان های متفاوتی کرده اند که در این میان نام شرکت ها پر اوازه ایرانی نیز به گوش میرسد. در میان این همه برند خارجی و با کیفیت چه خوب است که گهگداری سری به برند های ایرانی و کارهایی که دست سازه های هنرمندان ایرانی به حساب می آید نیز رفته و آن ها را نیز نظاره کنیم. به راستی که چه زیباست اگر به جای تعریف از دیگری، خودمان تعریفی شویم.', 'discount_products');
INSERT INTO `products` VALUES (30, 'کفش چرم', 'http://hasanlo.ir/android/shop/img/newproduct/12.jpg', '155000', 0, NULL, 3.3, 'شرکت های مختلفی در سطح جهان شروع به ساخت کالاهای متفاوت با نام و نشان های متفاوتی کرده اند که در این میان نام شرکت ها پر اوازه ایرانی نیز به گوش میرسد. در میان این همه برند خارجی و با کیفیت چه خوب است که گهگداری سری به برند های ایرانی و کارهایی که دست سازه های هنرمندان ایرانی به حساب می آید نیز رفته و آن ها را نیز نظاره کنیم. به راستی که چه زیباست اگر به جای تعریف از دیگری، خودمان تعریفی شویم.', 'discount_products');
INSERT INTO `products` VALUES (31, 'توپ سالن', 'http://hasanlo.ir/android/shop/img/newproduct/16.jpg', '230000', 0, NULL, 2.2, 'شرکت های مختلفی در سطح جهان شروع به ساخت کالاهای متفاوت با نام و نشان های متفاوتی کرده اند که در این میان نام شرکت ها پر اوازه ایرانی نیز به گوش میرسد. در میان این همه برند خارجی و با کیفیت چه خوب است که گهگداری سری به برند های ایرانی و کارهایی که دست سازه های هنرمندان ایرانی به حساب می آید نیز رفته و آن ها را نیز نظاره کنیم. به راستی که چه زیباست اگر به جای تعریف از دیگری، خودمان تعریفی شویم.', 'discount_products');
INSERT INTO `products` VALUES (32, 'کاپشن چرم', 'http://hasanlo.ir/android/shop/img/newproduct/1.jpg', '135000', 0, '', 3.5, 'شرکت های مختلفی در سطح جهان شروع به ساخت کالاهای متفاوت با نام و نشان های متفاوتی کرده اند که در این میان نام شرکت ها پر اوازه ایرانی نیز به گوش میرسد. در میان این همه برند خارجی و با کیفیت چه خوب است که گهگداری سری به برند های ایرانی و کارهایی که دست سازه های هنرمندان ایرانی به حساب می آید نیز رفته و آن ها را نیز نظاره کنیم. به راستی که چه زیباست اگر به جای تعریف از دیگری، خودمان تعریفی شویم.', 'discount_products');
INSERT INTO `products` VALUES (33, 'ساعت', 'http://hasanlo.ir/android/shop/img/newproduct/10.jpg', '250000', 0, '', 3.1, 'شرکت های مختلفی در سطح جهان شروع به ساخت کالاهای متفاوت با نام و نشان های متفاوتی کرده اند که در این میان نام شرکت ها پر اوازه ایرانی نیز به گوش میرسد. در میان این همه برند خارجی و با کیفیت چه خوب است که گهگداری سری به برند های ایرانی و کارهایی که دست سازه های هنرمندان ایرانی به حساب می آید نیز رفته و آن ها را نیز نظاره کنیم. به راستی که چه زیباست اگر به جای تعریف از دیگری، خودمان تعریفی شویم.', 'top_selling_products');
INSERT INTO `products` VALUES (34, 'وزنه بدنسازی', 'http://hasanlo.ir/android/shop/img/newproduct/9.jpg', '135000', 0, '', 4.9, 'شرکت های مختلفی در سطح جهان شروع به ساخت کالاهای متفاوت با نام و نشان های متفاوتی کرده اند که در این میان نام شرکت ها پر اوازه ایرانی نیز به گوش میرسد. در میان این همه برند خارجی و با کیفیت چه خوب است که گهگداری سری به برند های ایرانی و کارهایی که دست سازه های هنرمندان ایرانی به حساب می آید نیز رفته و آن ها را نیز نظاره کنیم. به راستی که چه زیباست اگر به جای تعریف از دیگری، خودمان تعریفی شویم.', 'top_selling_products');
INSERT INTO `products` VALUES (35, 'تلویزیون 60 اینچ', 'http://hasanlo.ir/android/shop/img/newproduct/8.jpg', '2500000', 1, '2350000', 4.8, 'شرکت های مختلفی در سطح جهان شروع به ساخت کالاهای متفاوت با نام و نشان های متفاوتی کرده اند که در این میان نام شرکت ها پر اوازه ایرانی نیز به گوش میرسد. در میان این همه برند خارجی و با کیفیت چه خوب است که گهگداری سری به برند های ایرانی و کارهایی که دست سازه های هنرمندان ایرانی به حساب می آید نیز رفته و آن ها را نیز نظاره کنیم. به راستی که چه زیباست اگر به جای تعریف از دیگری، خودمان تعریفی شویم.', 'top_selling_products');
INSERT INTO `products` VALUES (36, 'گوشی سامسونگ a50', 'http://hasanlo.ir/android/shop/img/newproduct/7.jpg', '4100000', 0, '', 2.1, 'شرکت های مختلفی در سطح جهان شروع به ساخت کالاهای متفاوت با نام و نشان های متفاوتی کرده اند که در این میان نام شرکت ها پر اوازه ایرانی نیز به گوش میرسد. در میان این همه برند خارجی و با کیفیت چه خوب است که گهگداری سری به برند های ایرانی و کارهایی که دست سازه های هنرمندان ایرانی به حساب می آید نیز رفته و آن ها را نیز نظاره کنیم. به راستی که چه زیباست اگر به جای تعریف از دیگری، خودمان تعریفی شویم.', 'top_selling_products');
INSERT INTO `products` VALUES (37, 'ساعت هوشمند', 'http://hasanlo.ir/android/shop/img/newproduct/5.jpg', '540000', 1, '512000', 3.5, 'شرکت های مختلفی در سطح جهان شروع به ساخت کالاهای متفاوت با نام و نشان های متفاوتی کرده اند که در این میان نام شرکت ها پر اوازه ایرانی نیز به گوش میرسد. در میان این همه برند خارجی و با کیفیت چه خوب است که گهگداری سری به برند های ایرانی و کارهایی که دست سازه های هنرمندان ایرانی به حساب می آید نیز رفته و آن ها را نیز نظاره کنیم. به راستی که چه زیباست اگر به جای تعریف از دیگری، خودمان تعریفی شویم.', 'top_selling_products');
INSERT INTO `products` VALUES (38, 'اسکیت', 'http://hasanlo.ir/android/shop/img/newproduct/4.jpg', '650000', 0, '', 2.2, 'شرکت های مختلفی در سطح جهان شروع به ساخت کالاهای متفاوت با نام و نشان های متفاوتی کرده اند که در این میان نام شرکت ها پر اوازه ایرانی نیز به گوش میرسد. در میان این همه برند خارجی و با کیفیت چه خوب است که گهگداری سری به برند های ایرانی و کارهایی که دست سازه های هنرمندان ایرانی به حساب می آید نیز رفته و آن ها را نیز نظاره کنیم. به راستی که چه زیباست اگر به جای تعریف از دیگری، خودمان تعریفی شویم.', 'top_selling_products');
INSERT INTO `products` VALUES (39, 'مانیتور NVIDIA', 'http://hasanlo.ir/android/shop/img/newproduct/2.jpg', '1150000', 1, '1000000', 3.8, 'شرکت های مختلفی در سطح جهان شروع به ساخت کالاهای متفاوت با نام و نشان های متفاوتی کرده اند که در این میان نام شرکت ها پر اوازه ایرانی نیز به گوش میرسد. در میان این همه برند خارجی و با کیفیت چه خوب است که گهگداری سری به برند های ایرانی و کارهایی که دست سازه های هنرمندان ایرانی به حساب می آید نیز رفته و آن ها را نیز نظاره کنیم. به راستی که چه زیباست اگر به جای تعریف از دیگری، خودمان تعریفی شویم.', 'top_selling_products');
INSERT INTO `products` VALUES (40, 'هنذفری بلوتوث', 'http://hasanlo.ir/android/shop/img/newproduct/17.jpg', '185000', 0, NULL, 1.1, 'شرکت های مختلفی در سطح جهان شروع به ساخت کالاهای متفاوت با نام و نشان های متفاوتی کرده اند که در این میان نام شرکت ها پر اوازه ایرانی نیز به گوش میرسد. در میان این همه برند خارجی و با کیفیت چه خوب است که گهگداری سری به برند های ایرانی و کارهایی که دست سازه های هنرمندان ایرانی به حساب می آید نیز رفته و آن ها را نیز نظاره کنیم. به راستی که چه زیباست اگر به جای تعریف از دیگری، خودمان تعریفی شویم.', 'top_selling_products');
INSERT INTO `products` VALUES (41, 'توپ چمن', 'http://hasanlo.ir/android/shop/img/newproduct/15.jpg', '290000', 1, '250000', 4.5, 'شرکت های مختلفی در سطح جهان شروع به ساخت کالاهای متفاوت با نام و نشان های متفاوتی کرده اند که در این میان نام شرکت ها پر اوازه ایرانی نیز به گوش میرسد. در میان این همه برند خارجی و با کیفیت چه خوب است که گهگداری سری به برند های ایرانی و کارهایی که دست سازه های هنرمندان ایرانی به حساب می آید نیز رفته و آن ها را نیز نظاره کنیم. به راستی که چه زیباست اگر به جای تعریف از دیگری، خودمان تعریفی شویم.', 'top_selling_products');
INSERT INTO `products` VALUES (42, 'کفش چمن', 'http://hasanlo.ir/android/shop/img/newproduct/13.jpg', '360000', 0, NULL, 2.7, 'شرکت های مختلفی در سطح جهان شروع به ساخت کالاهای متفاوت با نام و نشان های متفاوتی کرده اند که در این میان نام شرکت ها پر اوازه ایرانی نیز به گوش میرسد. در میان این همه برند خارجی و با کیفیت چه خوب است که گهگداری سری به برند های ایرانی و کارهایی که دست سازه های هنرمندان ایرانی به حساب می آید نیز رفته و آن ها را نیز نظاره کنیم. به راستی که چه زیباست اگر به جای تعریف از دیگری، خودمان تعریفی شویم.', 'top_selling_products');
INSERT INTO `products` VALUES (43, 'اسپیکر', 'http://hasanlo.ir/android/shop/img/newproduct/6.jpg', '145000', 0, '', 4.1, 'شرکت های مختلفی در سطح جهان شروع به ساخت کالاهای متفاوت با نام و نشان های متفاوتی کرده اند که در این میان نام شرکت ها پر اوازه ایرانی نیز به گوش میرسد. در میان این همه برند خارجی و با کیفیت چه خوب است که گهگداری سری به برند های ایرانی و کارهایی که دست سازه های هنرمندان ایرانی به حساب می آید نیز رفته و آن ها را نیز نظاره کنیم. به راستی که چه زیباست اگر به جای تعریف از دیگری، خودمان تعریفی شویم.', 'top_selling_products');
INSERT INTO `products` VALUES (44, 'پاور بانک', 'http://hasanlo.ir/android/shop/img/newproduct/3.jpg', '235000', 0, '', 3.5, 'شرکت های مختلفی در سطح جهان شروع به ساخت کالاهای متفاوت با نام و نشان های متفاوتی کرده اند که در این میان نام شرکت ها پر اوازه ایرانی نیز به گوش میرسد. در میان این همه برند خارجی و با کیفیت چه خوب است که گهگداری سری به برند های ایرانی و کارهایی که دست سازه های هنرمندان ایرانی به حساب می آید نیز رفته و آن ها را نیز نظاره کنیم. به راستی که چه زیباست اگر به جای تعریف از دیگری، خودمان تعریفی شویم.', 'top_selling_products');
INSERT INTO `products` VALUES (45, 'کاپشن چرم', 'http://hasanlo.ir/android/shop/img/newproduct/1.jpg', '135000', 0, '', 3.5, 'شرکت های مختلفی در سطح جهان شروع به ساخت کالاهای متفاوت با نام و نشان های متفاوتی کرده اند که در این میان نام شرکت ها پر اوازه ایرانی نیز به گوش میرسد. در میان این همه برند خارجی و با کیفیت چه خوب است که گهگداری سری به برند های ایرانی و کارهایی که دست سازه های هنرمندان ایرانی به حساب می آید نیز رفته و آن ها را نیز نظاره کنیم. به راستی که چه زیباست اگر به جای تعریف از دیگری، خودمان تعریفی شویم.', 'top_selling_products');
INSERT INTO `products` VALUES (46, 'توپ سالن', 'http://hasanlo.ir/android/shop/img/newproduct/16.jpg', '230000', 0, NULL, 2.2, 'شرکت های مختلفی در سطح جهان شروع به ساخت کالاهای متفاوت با نام و نشان های متفاوتی کرده اند که در این میان نام شرکت ها پر اوازه ایرانی نیز به گوش میرسد. در میان این همه برند خارجی و با کیفیت چه خوب است که گهگداری سری به برند های ایرانی و کارهایی که دست سازه های هنرمندان ایرانی به حساب می آید نیز رفته و آن ها را نیز نظاره کنیم. به راستی که چه زیباست اگر به جای تعریف از دیگری، خودمان تعریفی شویم.', 'top_selling_products');
INSERT INTO `products` VALUES (47, 'کفش سالن', 'http://hasanlo.ir/android/shop/img/newproduct/14.jpg', '640000', 0, NULL, 4.3, 'شرکت های مختلفی در سطح جهان شروع به ساخت کالاهای متفاوت با نام و نشان های متفاوتی کرده اند که در این میان نام شرکت ها پر اوازه ایرانی نیز به گوش میرسد. در میان این همه برند خارجی و با کیفیت چه خوب است که گهگداری سری به برند های ایرانی و کارهایی که دست سازه های هنرمندان ایرانی به حساب می آید نیز رفته و آن ها را نیز نظاره کنیم. به راستی که چه زیباست اگر به جای تعریف از دیگری، خودمان تعریفی شویم.', 'top_selling_products');
INSERT INTO `products` VALUES (48, 'کفش چرم', 'http://hasanlo.ir/android/shop/img/newproduct/12.jpg', '155000', 0, NULL, 3.3, 'شرکت های مختلفی در سطح جهان شروع به ساخت کالاهای متفاوت با نام و نشان های متفاوتی کرده اند که در این میان نام شرکت ها پر اوازه ایرانی نیز به گوش میرسد. در میان این همه برند خارجی و با کیفیت چه خوب است که گهگداری سری به برند های ایرانی و کارهایی که دست سازه های هنرمندان ایرانی به حساب می آید نیز رفته و آن ها را نیز نظاره کنیم. به راستی که چه زیباست اگر به جای تعریف از دیگری، خودمان تعریفی شویم.', 'top_selling_products');
INSERT INTO `products` VALUES (49, 'لب تاب ایسوس', 'http://hasanlo.ir/android/shop/img/newproduct/11.jpg', '7000000', 1, '6100000', 5, 'شرکت های مختلفی در سطح جهان شروع به ساخت کالاهای متفاوت با نام و نشان های متفاوتی کرده اند که در این میان نام شرکت ها پر اوازه ایرانی نیز به گوش میرسد. در میان این همه برند خارجی و با کیفیت چه خوب است که گهگداری سری به برند های ایرانی و کارهایی که دست سازه های هنرمندان ایرانی به حساب می آید نیز رفته و آن ها را نیز نظاره کنیم. به راستی که چه زیباست اگر به جای تعریف از دیگری، خودمان تعریفی شویم.', 'top_selling_products');


SET FOREIGN_KEY_CHECKS = 1;
