CREATE DATABASE `databaseProjet` ;

USE `databaseProjet` ;
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `elementMap`(IN `NumberMap` INT)
    NO SQL
SELECT elementmap.IDelement, elementmap.x, elementmap.y, element.url
FROM elementmap JOIN element ON elementmap.IDelement=element.IDelement
WHERE elementmap.IDmap = NumberMap 
ORDER BY elementmap.y, elementmap.x ASC$$

DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `allMap`()
    NO SQL
SELECT map.IDmap
FROM map$$

DELIMITER ;