CREATE DATABASE `botiga` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
CREATE TABLE `picture` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `painter` varchar(255) DEFAULT NULL,
  `price` int DEFAULT NULL,
  `date` date NOT NULL,
  `fk_shop` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK597hg2jorq352ao3ov2sworvf` (`fk_shop`),
  CONSTRAINT `FK597hg2jorq352ao3ov2sworvf` FOREIGN KEY (`fk_shop`) REFERENCES `shop` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `shop` (
  `id` int NOT NULL AUTO_INCREMENT,
  `capacity` int DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


insert into shop(capacity,name)values(10,'prado');
insert into shop(capacity,name)values(10,'Picasso');

insert into picture(name,painter,price,date,fk_shop)values('Las meninas','Diego Velázquez',300,'2020-01-01',1);
insert into picture(name,painter,price,date,fk_shop)values('Guernica','Pablo Picasso',5030,'2020-01-01',2);
