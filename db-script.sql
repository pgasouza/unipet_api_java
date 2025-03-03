SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `db_unipet` DEFAULT CHARACTER SET utf8mb3 ;
USE `db_unipet`;

CREATE TABLE IF NOT EXISTS `db_unipet`.`orgs` (
    `id` VARCHAR(255) NOT NULL,
    `name` VARCHAR(255) NOT NULL,
    `author_name` VARCHAR(255) NOT NULL,
    `email` VARCHAR(255) NOT NULL,
    `password` VARCHAR(255) NOT NULL,
    `whatsapp` VARCHAR(20) NOT NULL,
    `cep` VARCHAR(20) NOT NULL,
    `street` VARCHAR(255) NOT NULL,
    `neighborhood` VARCHAR(255) NOT NULL,
    `city` VARCHAR(255) NOT NULL,
    `state` VARCHAR(255) NOT NULL,
    `latitude` DECIMAL(10,7) NOT NULL,
    `longitude` DECIMAL(10,7) NOT NULL,

    PRIMARY KEY (`id`)
);

CREATE UNIQUE INDEX `orgs_email_key` ON `orgs`(`email`);


CREATE TABLE IF NOT EXISTS `db_unipet`.`pets` (
    `id` VARCHAR(255) NOT NULL,
    `name` VARCHAR(255) NOT NULL,
    `about` TEXT NOT NULL,
    `age` VARCHAR(50) NOT NULL,
    `size` VARCHAR(50) NOT NULL,
    `energy_level` VARCHAR(50) NOT NULL,
    `environment` VARCHAR(255) NOT NULL,
    `org_id` VARCHAR(255) NOT NULL,

    PRIMARY KEY (`id`),
    CONSTRAINT `pets_org_id_fkey` FOREIGN KEY (`org_id`) REFERENCES `orgs`(`id`) 
    ON DELETE RESTRICT ON UPDATE CASCADE
);

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;