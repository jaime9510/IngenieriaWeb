-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema neurociencias
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `neurociencias` ;

-- -----------------------------------------------------
-- Schema neurociencias
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `neurociencias` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `neurociencias` ;

-- -----------------------------------------------------
-- Table `neurociencias`.`Administrador`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `neurociencias`.`Administrador` ;

CREATE TABLE IF NOT EXISTS `neurociencias`.`Administrador` (
  `email` VARCHAR(45) NOT NULL COMMENT '',
  `nombre` VARCHAR(30) NOT NULL COMMENT '',
  `apellidos` VARCHAR(45) NOT NULL COMMENT '',
  `contrasena` VARCHAR(120) NOT NULL COMMENT '',
  PRIMARY KEY (`email`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `neurociencias`.`Tipo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `neurociencias`.`Tipo` ;

CREATE TABLE IF NOT EXISTS `neurociencias`.`Tipo` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `nombre` VARCHAR(25) NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `neurociencias`.`Dispositivo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `neurociencias`.`Dispositivo` ;

CREATE TABLE IF NOT EXISTS `neurociencias`.`Dispositivo` (
  `referencia` VARCHAR(30) NOT NULL COMMENT '',
  `nombre` VARCHAR(45) NOT NULL COMMENT '',
  `disponible` TINYINT(1) NOT NULL COMMENT '',
  `descripcion` VARCHAR(200) NULL COMMENT '',
  `Tipo` INT NOT NULL COMMENT '',
  `foto` VARCHAR(120) NOT NULL COMMENT '',
  PRIMARY KEY (`referencia`)  COMMENT '',
  INDEX `fk_Dispositivo_Tipo_idx` (`Tipo` ASC)  COMMENT '',
  CONSTRAINT `fk_Dispositivo_Tipo`
    FOREIGN KEY (`Tipo`)
    REFERENCES `neurociencias`.`Tipo` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `neurociencias`.`Prestamo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `neurociencias`.`Prestamo` ;

CREATE TABLE IF NOT EXISTS `neurociencias`.`Prestamo` (
  `idPrestamo` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `nombreUsuario` VARCHAR(30) NOT NULL COMMENT '',
  `cedulaUsuario` VARCHAR(20) NOT NULL COMMENT '',
  `fechaInicio` DATETIME(6) NOT NULL COMMENT '',
  `fechaFin` DATETIME(6) NOT NULL COMMENT '',
  `administrador` VARCHAR(45) NULL COMMENT '',
  `estado` INT NOT NULL COMMENT '',
  `correoUsuario` VARCHAR(45) NOT NULL COMMENT '',
  `fechaEntrega` DATETIME(6) NULL COMMENT '',
  PRIMARY KEY (`idPrestamo`)  COMMENT '',
  INDEX `fk_Prestamo_Administrador1_idx` (`administrador` ASC)  COMMENT '',
  CONSTRAINT `fk_Prestamo_Administrador1`
    FOREIGN KEY (`administrador`)
    REFERENCES `neurociencias`.`Administrador` (`email`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `neurociencias`.`Prestamo_has_Dispositivo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `neurociencias`.`Prestamo_has_Dispositivo` ;

CREATE TABLE IF NOT EXISTS `neurociencias`.`Prestamo_has_Dispositivo` (
  `prestamo` INT NOT NULL COMMENT '',
  `referencia` VARCHAR(30) NOT NULL COMMENT '',
  PRIMARY KEY (`prestamo`, `referencia`)  COMMENT '',
  INDEX `fk_Prestamo_has_Dispositivo_Dispositivo1_idx` (`referencia` ASC)  COMMENT '',
  INDEX `fk_Prestamo_has_Dispositivo_Prestamo1_idx` (`prestamo` ASC)  COMMENT '',
  CONSTRAINT `fk_Prestamo_has_Dispositivo_Prestamo1`
    FOREIGN KEY (`prestamo`)
    REFERENCES `neurociencias`.`Prestamo` (`idPrestamo`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Prestamo_has_Dispositivo_Dispositivo1`
    FOREIGN KEY (`referencia`)
    REFERENCES `neurociencias`.`Dispositivo` (`referencia`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `neurociencias`.`Fallo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `neurociencias`.`Fallo` ;

CREATE TABLE IF NOT EXISTS `neurociencias`.`Fallo` (
  `idFallo` INT NOT NULL COMMENT '',
  `error` VARCHAR(120) NOT NULL COMMENT '',
  `fechaDeteccion` DATE NOT NULL COMMENT '',
  `solucionado` TINYINT(1) NOT NULL COMMENT '',
  `dispositivo` VARCHAR(30) NOT NULL COMMENT '',
  PRIMARY KEY (`idFallo`)  COMMENT '',
  INDEX `fk_Fallo_Dispositivo1_idx` (`dispositivo` ASC)  COMMENT '',
  CONSTRAINT `fk_Fallo_Dispositivo1`
    FOREIGN KEY (`dispositivo`)
    REFERENCES `neurociencias`.`Dispositivo` (`referencia`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
