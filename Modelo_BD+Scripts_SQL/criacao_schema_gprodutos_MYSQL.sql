-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema gprodutos_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema gprodutos_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `gprodutos_db` DEFAULT CHARACTER SET utf8 ;
USE `gprodutos_db` ;

-- -----------------------------------------------------
-- Table `gprodutos_db`.`empregado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gprodutos_db`.`empregado` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `tipo` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `nome_UNIQUE` (`nome` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gprodutos_db`.`Categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gprodutos_db`.`Categoria` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gprodutos_db`.`SubCategoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gprodutos_db`.`SubCategoria` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(45) NULL,
  `categoria_id` INT NOT NULL,
  PRIMARY KEY (`id`, `categoria_id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_SubCategoria_Categoria1_idx` (`categoria_id` ASC),
  CONSTRAINT `fk_SubCategoria_Categoria1`
    FOREIGN KEY (`categoria_id`)
    REFERENCES `gprodutos_db`.`Categoria` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gprodutos_db`.`Produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gprodutos_db`.`Produto` (
  `codigo` INT NOT NULL AUTO_INCREMENT,
  `sub_categoria_id` VARCHAR(45) NULL,
  `descricao` VARCHAR(45) NOT NULL,
  `stock` INT NULL,
  `preco_unitario` FLOAT NULL,
  `SubCategoria_id` INT NOT NULL,
  `SubCategoria_Produto_codigo` INT NOT NULL,
  `gestor_id` INT NOT NULL,
  PRIMARY KEY (`codigo`, `gestor_id`),
  UNIQUE INDEX `codigo_UNIQUE` (`codigo` ASC),
  INDEX `fk_Produto_SubCategoria1_idx` (`SubCategoria_id` ASC, `SubCategoria_Produto_codigo` ASC),
  INDEX `fk_Produto_empregado1_idx` (`gestor_id` ASC),
  UNIQUE INDEX `descricao_UNIQUE` (`descricao` ASC),
  CONSTRAINT `fk_Produto_SubCategoria1`
    FOREIGN KEY (`SubCategoria_id`)
    REFERENCES `gprodutos_db`.`SubCategoria` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Produto_empregado1`
    FOREIGN KEY (`gestor_id`)
    REFERENCES `gprodutos_db`.`empregado` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gprodutos_db`.`Factura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gprodutos_db`.`Factura` (
  `numero` INT NOT NULL AUTO_INCREMENT,
  `vendedor_id` VARCHAR(45) NULL,
  `data` DATE NULL,
  `total` FLOAT NULL,
  `empregado_id` INT NOT NULL,
  PRIMARY KEY (`numero`, `empregado_id`),
  UNIQUE INDEX `numero_UNIQUE` (`numero` ASC),
  INDEX `fk_Factura_empregado1_idx` (`empregado_id` ASC),
  CONSTRAINT `fk_Factura_empregado1`
    FOREIGN KEY (`empregado_id`)
    REFERENCES `gprodutos_db`.`empregado` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gprodutos_db`.`LinhaFactura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gprodutos_db`.`LinhaFactura` (
  `factura_id` INT NOT NULL,
  `produto_id` INT NOT NULL,
  `quantidade` INT NULL,
  `preco_calculado` FLOAT NULL,
  `subtotal` FLOAT NULL,
  `codigo_produto` INT NOT NULL,
  `Factura_numero` INT NOT NULL,
  UNIQUE INDEX `produto_id_UNIQUE` (`produto_id` ASC),
  UNIQUE INDEX `factura_id_UNIQUE` (`factura_id` ASC),
  PRIMARY KEY (`codigo_produto`, `Factura_numero`),
  INDEX `fk_LinhaFactura_Produto1_idx` (`codigo_produto` ASC),
  INDEX `fk_LinhaFactura_Factura1_idx` (`Factura_numero` ASC),
  CONSTRAINT `fk_LinhaFactura_Produto1`
    FOREIGN KEY (`codigo_produto`)
    REFERENCES `gprodutos_db`.`Produto` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_LinhaFactura_Factura1`
    FOREIGN KEY (`Factura_numero`)
    REFERENCES `gprodutos_db`.`Factura` (`numero`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
