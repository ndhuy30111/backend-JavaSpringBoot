/*
 Navicat Premium Data Transfer

 Source Server         : 2
 Source Server Type    : MySQL
 Source Server Version : 100509
 Source Host           : 103.146.23.233:3306
 Source Schema         : xaydungweb

 Target Server Type    : MySQL
 Target Server Version : 100509
 File Encoding         : 65001

 Date: 13/04/2021 15:12:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` bigint(20) NOT NULL,
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_date` datetime(6) NULL DEFAULT NULL,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `status` tinyint(1) NULL DEFAULT 1,
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_date` datetime(6) NULL DEFAULT NULL,
  `url` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (7, 'ndhuy30111', '2021-03-31 01:28:51.159000', 'Áo thun', 0, 'ndhuy30111', '2021-03-31 01:28:51.159000', 'ao-thun');
INSERT INTO `category` VALUES (9, 'ndhuy30111', '2021-03-31 13:26:07.009000', 'Quần short', 0, 'ndhuy30111', '2021-03-31 13:26:07.009000', 'quan-short');
INSERT INTO `category` VALUES (10, 'ndhuy30111', '2021-03-31 13:56:54.144000', 'Quần Jeans', 0, 'ndhuy30111', '2021-03-31 13:56:54.144000', 'quan-jeans');
INSERT INTO `category` VALUES (11, 'ndhuy30111', '2021-03-31 13:57:13.880000', 'Quần thun', 0, 'ndhuy30111', '2021-03-31 13:57:13.880000', 'quan-thun');
INSERT INTO `category` VALUES (16, 'tuan1', '2021-03-31 03:35:10.195000', 'Áo Nam', 0, 'tuan1', '2021-03-31 03:35:10.195000', 'ao-nam');
INSERT INTO `category` VALUES (25, 'myduyen', '2021-04-02 04:08:42.039000', 'Áo đôi', 0, 'myduyen', '2021-04-02 04:08:42.039000', 'ao-oi');
INSERT INTO `category` VALUES (38, 'myduyen', '2021-04-02 04:41:16.881000', 'Áo dài', 0, 'myduyen', '2021-04-02 04:41:16.881000', 'ao-dai');
INSERT INTO `category` VALUES (49, 'myduyen', '2021-04-02 05:20:56.532000', 'Áo Sơ Mi', 0, 'myduyen', '2021-04-02 05:20:56.532000', 'ao-so-mi');
INSERT INTO `category` VALUES (74, 'tuan1', '2021-04-03 01:31:57.127000', 'Quần Jogger', 0, 'tuan1', '2021-04-03 01:31:57.127000', 'quan-jogger');
INSERT INTO `category` VALUES (76, 'myduyen', '2021-04-03 01:42:50.289000', 'Áo khoác', 0, 'myduyen', '2021-04-03 01:42:50.289000', 'ao-khoac');
INSERT INTO `category` VALUES (1003, 'ntmduyen', '2021-04-09 08:16:35.454000', 'Áo cổ lọ', 0, 'ntmduyen', '2021-04-09 08:16:35.454000', 'ao-co-lo');
INSERT INTO `category` VALUES (1030, 'tuan1', '2021-04-09 21:07:31.878000', 'Aunn', 0, 'tuan1', '2021-04-09 21:07:31.878000', 'aunn');
INSERT INTO `category` VALUES (1066, 'ndhuy30111', '2021-04-11 11:42:15.449000', 'Giày Bata', 0, 'ndhuy30111', '2021-04-11 11:42:15.449000', 'giay-bata');

-- ----------------------------
-- Table structure for category_product
-- ----------------------------
DROP TABLE IF EXISTS `category_product`;
CREATE TABLE `category_product`  (
  `category_id` bigint(20) NOT NULL,
  `product_id` bigint(20) NOT NULL,
  INDEX `FKfr6rjc04htbtc3xas2b9xmq7r`(`category_id`) USING BTREE,
  INDEX `FKssroqj2vyiaujfleklq1ifigj`(`product_id`) USING BTREE,
  CONSTRAINT `FKfr6rjc04htbtc3xas2b9xmq7r` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKssroqj2vyiaujfleklq1ifigj` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category_product
-- ----------------------------
INSERT INTO `category_product` VALUES (9, 30);
INSERT INTO `category_product` VALUES (49, 66);
INSERT INTO `category_product` VALUES (10, 93);
INSERT INTO `category_product` VALUES (7, 21);
INSERT INTO `category_product` VALUES (7, 26);
INSERT INTO `category_product` VALUES (7, 39);
INSERT INTO `category_product` VALUES (7, 44);
INSERT INTO `category_product` VALUES (7, 70);
INSERT INTO `category_product` VALUES (76, 77);
INSERT INTO `category_product` VALUES (76, 1149);

-- ----------------------------
-- Table structure for color
-- ----------------------------
DROP TABLE IF EXISTS `color`;
CREATE TABLE `color`  (
  `id` bigint(20) NOT NULL,
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_date` datetime(6) NULL DEFAULT NULL,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `status` tinyint(1) NULL DEFAULT 1,
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_date` datetime(6) NULL DEFAULT NULL,
  `url` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `product_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKsgsuxxoc1h5pskbjpch4id2ec`(`product_id`) USING BTREE,
  CONSTRAINT `FKsgsuxxoc1h5pskbjpch4id2ec` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of color
-- ----------------------------
INSERT INTO `color` VALUES (22, 'tuan1', '2021-04-01 20:15:15.955000', 'Đen', 0, 'tuan1', '2021-04-01 20:15:16.039000', 'en', '#000000', 21);
INSERT INTO `color` VALUES (27, 'tuan1', '2021-04-02 04:27:36.128000', 'Đen', 0, 'tuan1', '2021-04-02 04:27:36.137000', 'en', '', 26);
INSERT INTO `color` VALUES (31, 'tuan1', '2021-04-02 04:31:45.710000', 'Đen', 0, 'tuan1', '2021-04-02 04:31:45.723000', 'en', '#000000', 30);
INSERT INTO `color` VALUES (35, 'tuan1', '2021-04-02 04:31:45.719000', 'Trắng', 0, 'tuan1', '2021-04-02 04:31:45.782000', 'trang', '#ffffff', 30);
INSERT INTO `color` VALUES (40, 'ndhuy30111', '2021-04-02 05:10:29.603000', 'vàng', 0, 'ndhuy30111', '2021-04-02 05:10:29.607000', 'vang', '#f2e42c', 39);
INSERT INTO `color` VALUES (45, 'myduyen', '2021-04-02 05:13:30.984000', 'Trắng', 0, 'myduyen', '2021-04-02 05:13:30.996000', 'trang', '#ffffff', 44);
INSERT INTO `color` VALUES (67, 'myduyen', '2021-04-02 05:33:15.416000', 'Đen', 0, 'myduyen', '2021-04-02 05:33:15.419000', 'en', '#00000', 66);
INSERT INTO `color` VALUES (71, 'myduyen', '2021-04-02 05:34:01.352000', 'DS', 0, 'myduyen', '2021-04-02 05:34:01.357000', 'ds', '#a48989', 70);
INSERT INTO `color` VALUES (78, 'myduyen', '2021-04-03 01:44:25.613000', 'Xanh', 0, 'myduyen', '2021-04-03 01:44:25.711000', 'xanh', '#7a90e1', 77);
INSERT INTO `color` VALUES (94, 'myduyen', '2021-04-06 03:56:13.462000', 'Xám', 0, 'myduyen', '2021-04-06 03:56:13.467000', 'xam', '#ebe5e5', 93);
INSERT INTO `color` VALUES (1150, 'tuan1', '2021-04-12 00:44:57.014000', 'Đen', 0, 'tuan1', '2021-04-12 00:44:57.152000', 'en', '#000000', 1149);

-- ----------------------------
-- Table structure for color_image
-- ----------------------------
DROP TABLE IF EXISTS `color_image`;
CREATE TABLE `color_image`  (
  `color_id` bigint(20) NOT NULL,
  `image_id` bigint(20) NOT NULL,
  INDEX `FK2fbfqw20q0s013j1j2yvr31j2`(`image_id`) USING BTREE,
  INDEX `FKfdyjy4pvl10sgpdy7qwb2lu9o`(`color_id`) USING BTREE,
  CONSTRAINT `FK2fbfqw20q0s013j1j2yvr31j2` FOREIGN KEY (`image_id`) REFERENCES `uploadfile` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKfdyjy4pvl10sgpdy7qwb2lu9o` FOREIGN KEY (`color_id`) REFERENCES `color` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of color_image
-- ----------------------------
INSERT INTO `color_image` VALUES (22, 23);
INSERT INTO `color_image` VALUES (27, 28);
INSERT INTO `color_image` VALUES (31, 32);
INSERT INTO `color_image` VALUES (35, 36);
INSERT INTO `color_image` VALUES (40, 41);
INSERT INTO `color_image` VALUES (45, 46);
INSERT INTO `color_image` VALUES (67, 68);
INSERT INTO `color_image` VALUES (71, 72);
INSERT INTO `color_image` VALUES (78, 79);
INSERT INTO `color_image` VALUES (94, 95);
INSERT INTO `color_image` VALUES (1150, 1151);

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence`  (
  `next_not_cached_value` bigint(21) NOT NULL,
  `minimum_value` bigint(21) NOT NULL,
  `maximum_value` bigint(21) NOT NULL,
  `start_value` bigint(21) NOT NULL COMMENT 'start value when sequences is created or value if RESTART is used',
  `increment` bigint(21) NOT NULL COMMENT 'increment value',
  `cache_size` bigint(21) UNSIGNED NOT NULL,
  `cycle_option` tinyint(1) UNSIGNED NOT NULL COMMENT '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
  `cycle_count` bigint(21) NOT NULL COMMENT 'How many cycles have been done'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES (2001, 1, 9223372036854775806, 1, 1, 1000, 0, 0);

-- ----------------------------
-- Table structure for invoice
-- ----------------------------
DROP TABLE IF EXISTS `invoice`;
CREATE TABLE `invoice`  (
  `id` bigint(20) NOT NULL,
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_date` datetime(6) NULL DEFAULT NULL,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `status` tinyint(1) NULL DEFAULT 1,
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_date` datetime(6) NULL DEFAULT NULL,
  `user_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKjunvl5maki3unqdvljk31kns3`(`user_id`) USING BTREE,
  CONSTRAINT `FKjunvl5maki3unqdvljk31kns3` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for invoicedetails
-- ----------------------------
DROP TABLE IF EXISTS `invoicedetails`;
CREATE TABLE `invoicedetails`  (
  `id` bigint(20) NOT NULL,
  `amount` int(11) NULL DEFAULT NULL,
  `price` bigint(20) NULL DEFAULT NULL,
  `invoice_id` bigint(20) NULL DEFAULT NULL,
  `product_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKiuxe079u0ql6k46t0xkmmy8s3`(`invoice_id`) USING BTREE,
  INDEX `FKbwhymgkytycpm3obr70b6lg2v`(`product_id`) USING BTREE,
  CONSTRAINT `FKbwhymgkytycpm3obr70b6lg2v` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKiuxe079u0ql6k46t0xkmmy8s3` FOREIGN KEY (`invoice_id`) REFERENCES `invoice` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `id` bigint(20) NOT NULL,
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_date` datetime(6) NULL DEFAULT NULL,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `status` tinyint(1) NULL DEFAULT 1,
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_date` datetime(6) NULL DEFAULT NULL,
  `url` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `discount` bigint(20) NULL DEFAULT 0,
  `introduce` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` bigint(20) NULL DEFAULT 0,
  `short_introduction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (21, 'tuan1', '2021-04-01 20:15:15.943000', 'Áo thun 001', 0, 'tuan1', '2021-04-01 20:15:15.943000', 'ao-thun-001', 200000, ' không', 250000, 'không');
INSERT INTO `product` VALUES (26, 'tuan1', '2021-04-02 04:27:36.126000', 'Áo thun 002', 0, 'tuan1', '2021-04-02 04:27:36.126000', 'ao-thun-002', 100000, 'không', 150000, 'không');
INSERT INTO `product` VALUES (30, 'tuan1', '2021-04-02 04:31:45.708000', 'Quần short 001', 0, 'tuan1', '2021-04-02 04:31:45.708000', 'quan-short-001', 250000, 'đẹp', 3000000, 'đep');
INSERT INTO `product` VALUES (39, 'ndhuy30111', '2021-04-02 05:10:29.600000', 'Áo thun', 0, 'ndhuy30111', '2021-04-02 05:10:29.600000', 'ao-thun', 230000, 'đẹp', 250000, 'đẹp');
INSERT INTO `product` VALUES (44, 'myduyen', '2021-04-02 05:13:30.969000', 'Áo sơ mi 0611', 0, 'myduyen', '2021-04-02 05:13:30.969000', 'ao-so-mi-0611', 290000, 'đẹp', 300000, 'đẹp');
INSERT INTO `product` VALUES (66, 'myduyen', '2021-04-02 05:33:15.413000', 'Áo thun vàng', 0, 'myduyen', '2021-04-02 05:33:15.413000', 'ao-thun-vang', 10000000, 'asldkjaskdjaksd', 1000000, 'asdjaksdjkasd');
INSERT INTO `product` VALUES (70, 'myduyen', '2021-04-02 05:34:01.351000', 'Áo dài', 0, 'myduyen', '2021-04-02 05:34:01.351000', 'ao-dai', 123123, 'qdqwdqwd', 123123123, 'dqwdqwd');
INSERT INTO `product` VALUES (77, 'myduyen', '2021-04-03 01:44:25.587000', 'ÁO KHOÁC W2AK', 0, 'myduyen', '2021-04-03 01:44:25.587000', 'ao-khoac-w2ak', 425000, 'Áo đẹp ', 423000, 'Áo đẹp ');
INSERT INTO `product` VALUES (93, 'myduyen', '2021-04-06 03:56:13.460000', 'Quần Jeans Xám 001', 0, 'myduyen', '2021-04-06 03:56:13.460000', 'quan-jeans-xam-001', 400000, 'Không', 425000, 'Không ');
INSERT INTO `product` VALUES (1149, 'tuan1', '2021-04-12 00:44:56.957000', 'Áo khoác 002', 0, 'tuan1', '2021-04-12 00:44:56.957000', 'ao-khoac-002', 150000, 'xinh', 200000, 'không');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` bigint(20) NOT NULL,
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_date` datetime(6) NULL DEFAULT NULL,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `status` tinyint(1) NULL DEFAULT 1,
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_date` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, NULL, NULL, 'ADMIN', 1, NULL, NULL);
INSERT INTO `role` VALUES (2, NULL, NULL, 'USER', 1, NULL, NULL);
INSERT INTO `role` VALUES (3, NULL, NULL, 'EDITER', 1, NULL, NULL);

-- ----------------------------
-- Table structure for size
-- ----------------------------
DROP TABLE IF EXISTS `size`;
CREATE TABLE `size`  (
  `id` bigint(20) NOT NULL,
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_date` datetime(6) NULL DEFAULT NULL,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `status` tinyint(1) NULL DEFAULT 1,
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_date` datetime(6) NULL DEFAULT NULL,
  `amount` int(11) NULL DEFAULT NULL,
  `color_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK8xjuqwpb5xlnn3978a9uhreor`(`color_id`) USING BTREE,
  CONSTRAINT `FK8xjuqwpb5xlnn3978a9uhreor` FOREIGN KEY (`color_id`) REFERENCES `color` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of size
-- ----------------------------
INSERT INTO `size` VALUES (24, 'tuan1', '2021-04-01 20:15:15.976000', 'S', 0, 'tuan1', '2021-04-01 20:15:16.040000', 30, 22);
INSERT INTO `size` VALUES (29, 'tuan1', '2021-04-02 04:27:36.132000', 'S', 0, 'tuan1', '2021-04-02 04:27:36.137000', 30, 27);
INSERT INTO `size` VALUES (33, 'tuan1', '2021-04-02 04:31:45.717000', 'XL', 0, 'tuan1', '2021-04-02 04:31:45.723000', 30, 31);
INSERT INTO `size` VALUES (34, 'tuan1', '2021-04-02 04:31:45.719000', 'S', 0, 'tuan1', '2021-04-02 04:31:45.723000', 30, 31);
INSERT INTO `size` VALUES (37, 'tuan1', '2021-04-02 04:31:45.720000', 'M', 0, 'tuan1', '2021-04-02 04:31:45.782000', 30, 35);
INSERT INTO `size` VALUES (42, 'ndhuy30111', '2021-04-02 05:10:29.604000', 'M', 0, 'ndhuy30111', '2021-04-02 05:10:29.608000', 20, 40);
INSERT INTO `size` VALUES (43, 'ndhuy30111', '2021-04-02 05:10:29.604000', 'L', 0, 'ndhuy30111', '2021-04-02 05:10:29.609000', 40, 40);
INSERT INTO `size` VALUES (47, 'myduyen', '2021-04-02 05:13:30.989000', 'M', 0, 'myduyen', '2021-04-02 05:13:30.996000', 10, 45);
INSERT INTO `size` VALUES (48, 'myduyen', '2021-04-02 05:13:30.990000', 'L', 0, 'myduyen', '2021-04-02 05:13:30.997000', 20, 45);
INSERT INTO `size` VALUES (69, 'myduyen', '2021-04-02 05:33:15.417000', 'S', 0, 'myduyen', '2021-04-02 05:33:15.419000', 1, 67);
INSERT INTO `size` VALUES (73, 'myduyen', '2021-04-02 05:34:01.354000', 'D', 0, 'myduyen', '2021-04-02 05:34:01.357000', 1, 71);
INSERT INTO `size` VALUES (80, 'myduyen', '2021-04-03 01:44:25.634000', 'L', 0, 'myduyen', '2021-04-03 01:44:25.713000', 20, 78);
INSERT INTO `size` VALUES (96, 'myduyen', '2021-04-06 03:56:13.463000', 'S', 0, 'myduyen', '2021-04-06 03:56:13.468000', 30, 94);
INSERT INTO `size` VALUES (1152, 'tuan1', '2021-04-12 00:44:57.034000', 'S', 0, 'tuan1', '2021-04-12 00:44:57.153000', 10, 1150);

-- ----------------------------
-- Table structure for uploadfile
-- ----------------------------
DROP TABLE IF EXISTS `uploadfile`;
CREATE TABLE `uploadfile`  (
  `id` bigint(20) NOT NULL,
  `filedowndloaduri` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `filename` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `filetype` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `size` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of uploadfile
-- ----------------------------
INSERT INTO `uploadfile` VALUES (23, 'http://103.146.23.233/api/downloadFile/5c3f7d34-9c7e-47d2-a413-63ccd296e274.jpg', '5c3f7d34-9c7e-47d2-a413-63ccd296e274.jpg', 'image/jpeg', 54613);
INSERT INTO `uploadfile` VALUES (28, 'http://103.146.23.233/api/downloadFile/2c64f30d-014b-4cb6-9784-52cb4449ee87.jpg', '2c64f30d-014b-4cb6-9784-52cb4449ee87.jpg', 'image/jpeg', 117783);
INSERT INTO `uploadfile` VALUES (32, 'http://103.146.23.233/api/downloadFile/850f66f6-da08-411a-a8d0-790fb1e506cb.jpg', '850f66f6-da08-411a-a8d0-790fb1e506cb.jpg', 'image/jpeg', 63162);
INSERT INTO `uploadfile` VALUES (36, 'http://103.146.23.233/api/downloadFile/e6314ff7-e832-4b21-be83-ae3562be8cb4.jpg', 'e6314ff7-e832-4b21-be83-ae3562be8cb4.jpg', 'image/jpeg', 26939);
INSERT INTO `uploadfile` VALUES (41, 'http://103.146.23.233/api/downloadFile/08f39b3a-61ba-4847-8a30-338e1c4d5080.jpg', '08f39b3a-61ba-4847-8a30-338e1c4d5080.jpg', 'image/jpeg', 92813);
INSERT INTO `uploadfile` VALUES (46, 'http://103.146.23.233/api/downloadFile/ab6849dc-a1cf-4f2b-8da1-85f89db2f23f.jpg', 'ab6849dc-a1cf-4f2b-8da1-85f89db2f23f.jpg', 'image/jpeg', 150273);
INSERT INTO `uploadfile` VALUES (68, 'http://103.146.23.233/api/downloadFile/b763eb23-3063-4513-9a90-2e09c1323fa0.jpg', 'b763eb23-3063-4513-9a90-2e09c1323fa0.jpg', 'image/jpeg', 103850);
INSERT INTO `uploadfile` VALUES (72, 'http://103.146.23.233/api/downloadFile/7798424e-8256-4206-86d0-e71ce2f2c2cc.jpg', '7798424e-8256-4206-86d0-e71ce2f2c2cc.jpg', 'image/jpeg', 103850);
INSERT INTO `uploadfile` VALUES (79, 'http://103.146.23.233/api/downloadFile/77eb1d42-a79d-4f9c-a1d3-09e4ad16a6f5.jpg', '77eb1d42-a79d-4f9c-a1d3-09e4ad16a6f5.jpg', 'image/jpeg', 185338);
INSERT INTO `uploadfile` VALUES (95, 'http://103.146.23.233/api/downloadFile/9294ab03-47b7-4376-908e-0542acecfa17.jpg', '9294ab03-47b7-4376-908e-0542acecfa17.jpg', 'image/jpeg', 82328);
INSERT INTO `uploadfile` VALUES (1151, 'http://103.146.23.233/api/downloadFile/78dab8a6-608f-446d-a5a1-b7c71e316a3b.jpg', '78dab8a6-608f-446d-a5a1-b7c71e316a3b.jpg', 'image/jpeg', 10432);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL,
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_date` datetime(6) NULL DEFAULT NULL,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `status` tinyint(1) NULL DEFAULT 1,
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_date` datetime(6) NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `isenabled` tinyint(1) NULL DEFAULT 0,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `UK_ob8kqyqqgmefl0aco34akdtpe`(`email`) USING BTREE,
  UNIQUE INDEX `UK_sb8bbouer5wak8vyiiy4pf2bx`(`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'anonymousUser', '2021-03-31 10:03:34.054000', 'Nguyễn Đức Huy', 1, 'anonymousUser', '2021-03-31 10:44:10.486000', 'ndhuy30111@gmail.com', 1, '$2a$10$fBcXC3q/tcg9UwBFkTLFjeQFx8qELSug/VvOFha.HFreTF9XFZU1.', 'ndhuy30111');
INSERT INTO `user` VALUES (14, 'anonymousUser', '2021-03-31 03:31:14.530000', 'Tuấn đẹp trai', 1, 'anonymousUser', '2021-03-31 03:31:14.530000', 'tymap644@gmail.com', 0, '$2a$10$rrQkknNPeqypQ8jPzvvN1OjqIys7gUETMBeXjTKDuLL7IIIoWwzfS', 'tuan1');
INSERT INTO `user` VALUES (17, 'anonymousUser', '2021-03-31 04:36:46.393000', 'Tuấn đẹp trai', 1, 'anonymousUser', '2021-03-31 15:37:40.875000', 'phamquoctuand17@gmail.com', 1, '$2a$10$NtCaLNN/GzQ/saa9HP7nNO.0MUGBeKO.l2XuLgyUuEaH3TzjmwQ86', 'tuan221');
INSERT INTO `user` VALUES (19, 'anonymousUser', '2021-03-31 11:29:19.871000', 'Dat Dep Trai', 1, 'anonymousUser', '2021-03-31 11:29:19.871000', 'datdeptrai@gmail.com', 0, '$2a$10$gaUPECfTlN/BWZuAMppEX.KUYztJXU33rU7/rSfN7K32WFosgxubi', 'datdeptrai');
INSERT INTO `user` VALUES (91, 'anonymousUser', '2021-04-03 11:39:26.229000', 'Phạm Quốc Tuấn', 1, 'anonymousUser', '2021-04-03 11:39:26.229000', 'tymap64@gmail.com', 0, '$2a$10$NXN.f92pligvEyMnJqJAse3HbKj9Sra/wqV.wTg8CdrmL3dZ4GN7C', 'tuan2211');
INSERT INTO `user` VALUES (97, 'anonymousUser', '2021-04-06 04:19:37.393000', 'Nguyễn Thị Mỹ Duyên', 1, 'anonymousUser', '2021-04-06 04:19:37.393000', 'myduyen06122910@gmail.com', 0, '$2a$10$iI484nqXMqeBZqigGAjhBegrveefeP2yyHyjOXH77KCqoEXMVdv5i', 'myduyen');
INSERT INTO `user` VALUES (1001, 'anonymousUser', '2021-04-09 06:14:42.336000', 'Mỹ Duyên Xinh', 1, 'anonymousUser', '2021-04-09 06:15:14.558000', 'ntmduyen0612@gmail.com', 1, '$2a$10$MJMYu1mjoSgDJpLGa7PIRuaPrM.9gmN4m43R.fPuhkXQLkKyHWmsm', 'ntmduyen');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `role_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  INDEX `FK859n2jvi8ivhui0rl0esws6o`(`user_id`) USING BTREE,
  INDEX `FKa68196081fvovjhkek5m97n3y`(`role_id`) USING BTREE,
  CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for verification_user
-- ----------------------------
DROP TABLE IF EXISTS `verification_user`;
CREATE TABLE `verification_user`  (
  `token_id` bigint(20) NOT NULL,
  `confirmation_token` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `created_date` datetime(6) NULL DEFAULT NULL,
  `user_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`token_id`) USING BTREE,
  INDEX `FKbphggqd71b7igx9dm5g6ej2vl`(`user_id`) USING BTREE,
  CONSTRAINT `FKbphggqd71b7igx9dm5g6ej2vl` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of verification_user
-- ----------------------------
INSERT INTO `verification_user` VALUES (2, '8b480886-bec0-4e4f-8978-cbc495e58175', '2021-03-31 10:03:34.228000', 1);
INSERT INTO `verification_user` VALUES (15, '1cb58aec-50b5-4d33-9253-4a5f67eaef20', '2021-03-31 03:31:14.638000', 14);
INSERT INTO `verification_user` VALUES (18, 'c47dc59e-f94d-4bd2-84c0-b5ff36c01dae', '2021-03-31 04:36:46.406000', 17);
INSERT INTO `verification_user` VALUES (20, '3578ce90-d3c0-44fb-b13e-dcf4ff0b0835', '2021-03-31 11:29:20.020000', 19);
INSERT INTO `verification_user` VALUES (92, '9d971f9d-5c92-44c8-be23-0f80f27b58f2', '2021-04-03 11:39:26.287000', 91);
INSERT INTO `verification_user` VALUES (98, '056bc602-32b4-42ea-85df-d63ee539d58a', '2021-04-06 04:19:37.405000', 97);
INSERT INTO `verification_user` VALUES (1002, '3f29a989-0fa9-4daa-8e1e-d124b20721f3', '2021-04-09 06:14:42.468000', 1001);

SET FOREIGN_KEY_CHECKS = 1;
