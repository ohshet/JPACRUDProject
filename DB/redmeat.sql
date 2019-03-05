-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema redmeat
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `redmeat` ;

-- -----------------------------------------------------
-- Schema redmeat
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `redmeat` DEFAULT CHARACTER SET utf8 ;
USE `redmeat` ;

-- -----------------------------------------------------
-- Table `redmeat`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `redmeat` ;

CREATE TABLE IF NOT EXISTS `redmeat` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(1000) NOT NULL,
  `characters` VARCHAR(1000) NULL,
  `text` TEXT NULL,
  `img_url` VARCHAR(1000) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS redmeatuser@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'redmeatuser'@'localhost' IDENTIFIED BY 'redmeatpassword';

GRANT SELECT, INSERT, TRIGGER ON TABLE * TO 'redmeatuser'@'localhost';
GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'redmeatuser'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `redmeat`
-- -----------------------------------------------------
START TRANSACTION;
USE `redmeat`;
INSERT INTO `redmeat` (`id`, `title`, `characters`, `text`, `img_url`) VALUES (1, 'test title', 'test characters', 'test text', 'test url');
INSERT INTO `redmeat` (`id`, `title`, `characters`, `text`, `img_url`) VALUES (2, 'test title 2', 'test characters 2', 'test text 2', 'test url 2');

COMMIT;

