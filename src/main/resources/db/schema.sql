CREATE DATABASE if not exists `JocDaus` ;

use `JocDaus`;

CREATE TABLE `player` ( 
 `id` int NOT NULL AUTO_INCREMENT,
 `name` varchar(255) DEFAULT NULL,
 `regist_date` date NOT NULL,
 `success` double DEFAULT NULL,
 PRIMARY KEY (`id`));
 
CREATE TABLE `tirada` (
`id` int NOT NULL AUTO_INCREMENT,
`dau1` int DEFAULT NULL,
`dau2` int DEFAULT NULL,
`win` bit(1) DEFAULT NULL,
`fk_player` int DEFAULT NULL,
PRIMARY KEY (`id`),
KEY `FKnho8drgeowhrvmur20jk0f4w9` (`fk_player`),
CONSTRAINT `FKnho8drgeowhrvmur20jk0f4w9` FOREIGN KEY (`fk_player`)
REFERENCES `player`(`id`));
