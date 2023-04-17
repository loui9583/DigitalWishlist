DROP DATABASE IF EXISTS digitalwishlist;
CREATE DATABASE digitalwishlist;
USE digitalwishlist;

CREATE TABLE user
(
user_id 			INT 		NOT NULL 	PRIMARY KEY 	AUTO_INCREMENT,
user_name 			VARCHAR(45) DEFAULT NULL,
user_password 		VARCHAR(45) DEFAULT NULL  
);

CREATE TABLE wishlist
(
wishlist_id 		INT 		NOT NULL 	PRIMARY KEY 	AUTO_INCREMENT,
user_id				INT			NOT NULL,
wishlist_name		VARCHAR(45) NOT NULL,
								FOREIGN KEY(user_id) REFERENCES user(user_id)
);

CREATE TABLE item
(
item_id				INT			NOT NULL PRIMARY KEY		AUTO_INCREMENT,
item_name			VARCHAR(45)	NOT NULL,
item_price			INT			NOT NULL
);

CREATE TABLE wish
(
wish_id 			INT 		NOT NULL 	PRIMARY KEY 	AUTO_INCREMENT,
wishlist_id			INT			NOT NULL,
item_id				INT			NOT NULL,
is_reserved			BOOLEAN		NOT NULL,
								FOREIGN KEY(wishlist_id) REFERENCES wishlist(wishlist_id),
								FOREIGN KEY(item_id) REFERENCES item(item_id)
);

