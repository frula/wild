-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.6.26-log - MySQL Community Server (GPL)
-- SO del servidor:              Win32
-- HeidiSQL Versión:             9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando estructura de base de datos para pizzeria
CREATE DATABASE IF NOT EXISTS `pizzeria` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `pizzeria`;


-- Volcando estructura para tabla pizzeria.categoria
CREATE TABLE IF NOT EXISTS `categoria` (
  `IDCategoria` int(11) NOT NULL AUTO_INCREMENT,
  `Categoria` varchar(100) NOT NULL,
  PRIMARY KEY (`IDCategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla pizzeria.categoria: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` (`IDCategoria`, `Categoria`) VALUES
	(1, 'VERDULERIA'),
	(2, 'ALMACEN'),
	(3, 'LISTO');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;


-- Volcando estructura para tabla pizzeria.cliente
CREATE TABLE IF NOT EXISTS `cliente` (
  `IDCliente` int(11) NOT NULL AUTO_INCREMENT,
  `Cliente` varchar(200) NOT NULL,
  `DNI` varchar(50) NOT NULL,
  `Direccion` varchar(250) NOT NULL,
  `Telefono` varchar(15) NOT NULL,
  `Activo` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`IDCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla pizzeria.cliente: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` (`IDCliente`, `Cliente`, `DNI`, `Direccion`, `Telefono`, `Activo`) VALUES
	(1, 'CLIENTE PRUEBA 1', '29998776', 'SU CASA', '11776680', 0),
	(2, '30877654', 'CLIENTE ', 'SU CASA 2', '12333878', 0),
	(3, '34544379', 'lucas', 'alice', '4663', 1),
	(4, 'lucas villalba', '34544', 'alice 964', '4663-3665', 1),
	(5, 'pablo villalba', '36544', 'jose leon 30', '4668-1160', 1);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;


-- Volcando estructura para tabla pizzeria.combos
CREATE TABLE IF NOT EXISTS `combos` (
  `IDCombo` int(11) NOT NULL AUTO_INCREMENT,
  `Precio` double NOT NULL DEFAULT '0',
  `Productos` varchar(200) NOT NULL DEFAULT '0',
  `N°Combo` int(11) NOT NULL DEFAULT '0',
  `Estado` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`IDCombo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla pizzeria.combos: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `combos` DISABLE KEYS */;
INSERT INTO `combos` (`IDCombo`, `Precio`, `Productos`, `N°Combo`, `Estado`) VALUES
	(1, 20, ' 1 Empanadas de carne (Docena) 1 pizza de anchoa', 2, 1),
	(2, 20, ' 1 Empanadas de carne (Docena)', 2, 1),
	(3, 100, ' 2 Empanadas de carne (Docena) 1 COCA', 3, 1),
	(4, 100, ' 2 Empanadas de carne (Docena) 1 COCA', 4, 1),
	(5, 40, ' 1 pizza de anchoa 1 COCA', 5, 1);
/*!40000 ALTER TABLE `combos` ENABLE KEYS */;


-- Volcando estructura para tabla pizzeria.compra
CREATE TABLE IF NOT EXISTS `compra` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `NumeroCompra` int(11) NOT NULL,
  `Proveedor` varchar(50) NOT NULL,
  `Estado` tinyint(4) NOT NULL,
  `Monto` double DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla pizzeria.compra: ~14 rows (aproximadamente)
/*!40000 ALTER TABLE `compra` DISABLE KEYS */;
INSERT INTO `compra` (`Id`, `NumeroCompra`, `Proveedor`, `Estado`, `Monto`) VALUES
	(13, 1, 'Tutifruti', 1, NULL),
	(14, 1, 'Mercado ', 1, NULL),
	(15, 2, 'Proveedor1', 1, 50),
	(16, 3, 'Mercado ', 1, NULL),
	(17, 4, 'Proveedor1', 1, NULL),
	(18, 5, 'Mercado ', 1, NULL),
	(19, 6, 'Pepsi', 1, NULL),
	(20, 7, 'Proveedor1', 1, NULL),
	(21, 8, 'Mercado ', 1, NULL),
	(22, 9, 'Mercado ', 1, NULL),
	(23, 10, 'Pepsi', 1, NULL),
	(24, 11, 'Mercado ', 1, NULL),
	(25, 12, 'Tutifruti', 1, NULL),
	(26, 13, 'Pepsi', 1, NULL),
	(27, 14, 'Mercado ', 1, NULL);
/*!40000 ALTER TABLE `compra` ENABLE KEYS */;


-- Volcando estructura para tabla pizzeria.detallecompra
CREATE TABLE IF NOT EXISTS `detallecompra` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `IdMateriaPrima` varchar(50) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  `IdCompra` int(11) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `IdCompra` (`IdCompra`)
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla pizzeria.detallecompra: ~18 rows (aproximadamente)
/*!40000 ALTER TABLE `detallecompra` DISABLE KEYS */;
INSERT INTO `detallecompra` (`Id`, `IdMateriaPrima`, `Cantidad`, `IdCompra`) VALUES
	(24, 'HUEVOS', 6, 2),
	(28, 'queso', 2, 1),
	(51, 'HUEVOS', 2, 4),
	(52, 'queso', 2, 4),
	(53, 'HUEVOS', 2, 4),
	(61, 'HUEVOS', 30, 6),
	(62, 'HARINA', 10, 5),
	(63, 'HARINA', 4, 8),
	(64, 'queso', 5, 8),
	(65, 'queso', 20, 9),
	(66, 'HARINA', 2, 9),
	(67, 'HUEVOS', 60, 10),
	(68, 'HARINA', 70, 11),
	(69, 'queso', 80, 11),
	(70, 'HARINA', 6, 12),
	(71, 'queso', 10, 12),
	(72, 'HUEVOS', 100, 13),
	(73, 'HARINA', 15, 14),
	(74, 'queso', 15, 14);
/*!40000 ALTER TABLE `detallecompra` ENABLE KEYS */;


-- Volcando estructura para tabla pizzeria.detallepedido
CREATE TABLE IF NOT EXISTS `detallepedido` (
  `IDPedido` int(11) NOT NULL,
  `NumeroPedido` int(11) NOT NULL,
  `IDProducto` int(11) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  `Observacion` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`IDProducto`,`NumeroPedido`),
  KEY `FK1IDPedido` (`IDPedido`),
  CONSTRAINT `FK1IDPedido` FOREIGN KEY (`IDPedido`) REFERENCES `pedido` (`IDPedido`),
  CONSTRAINT `FK2IDProduc` FOREIGN KEY (`IDProducto`) REFERENCES `producto` (`IDProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla pizzeria.detallepedido: ~15 rows (aproximadamente)
/*!40000 ALTER TABLE `detallepedido` DISABLE KEYS */;
INSERT INTO `detallepedido` (`IDPedido`, `NumeroPedido`, `IDProducto`, `Cantidad`, `Observacion`) VALUES
	(112, 1, 1, 180, 'null'),
	(113, 2, 1, 1, 'null'),
	(117, 6, 1, 1, 'null'),
	(118, 7, 1, 4, 'null'),
	(119, 8, 1, 2, 'null'),
	(120, 9, 1, 2, 'null'),
	(114, 3, 3, 1, 'null'),
	(115, 4, 3, 4, 'null'),
	(116, 5, 3, 1, 'null'),
	(117, 6, 3, 1, 'null'),
	(119, 8, 4, 2, 'sin aceitunas sin oregano sin nada '),
	(120, 9, 4, 2, 'sin aceitunas sin oregano sin nada '),
	(121, 10, 6, 180, 'hola'),
	(122, 11, 6, 1, 'null'),
	(112, 1, 7, 1, 'null'),
	(122, 11, 7, 1, 'null');
/*!40000 ALTER TABLE `detallepedido` ENABLE KEYS */;


-- Volcando estructura para tabla pizzeria.listaproveedor
CREATE TABLE IF NOT EXISTS `listaproveedor` (
  `IDProveedor` int(11) NOT NULL,
  `IDMateriaPrima` int(11) NOT NULL,
  PRIMARY KEY (`IDProveedor`,`IDMateriaPrima`),
  KEY `FKMatPrima` (`IDMateriaPrima`),
  CONSTRAINT `FKMatPrima` FOREIGN KEY (`IDMateriaPrima`) REFERENCES `materiaprima` (`idMatPrima`),
  CONSTRAINT `FKProv` FOREIGN KEY (`IDProveedor`) REFERENCES `proveedor` (`IDProveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla pizzeria.listaproveedor: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `listaproveedor` DISABLE KEYS */;
INSERT INTO `listaproveedor` (`IDProveedor`, `IDMateriaPrima`) VALUES
	(1, 1),
	(1, 2);
/*!40000 ALTER TABLE `listaproveedor` ENABLE KEYS */;


-- Volcando estructura para tabla pizzeria.materiaprima
CREATE TABLE IF NOT EXISTS `materiaprima` (
  `idMatPrima` int(11) NOT NULL AUTO_INCREMENT,
  `Categoria` int(11) NOT NULL,
  `MateriaPrima` varchar(200) NOT NULL,
  `Habilitado` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idMatPrima`),
  KEY `FK1MatPrima` (`Categoria`),
  CONSTRAINT `FK1MatPrima` FOREIGN KEY (`Categoria`) REFERENCES `categoria` (`IDCategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla pizzeria.materiaprima: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `materiaprima` DISABLE KEYS */;
INSERT INTO `materiaprima` (`idMatPrima`, `Categoria`, `MateriaPrima`, `Habilitado`) VALUES
	(1, 2, 'HUEVOS', 0),
	(2, 1, 'HARINA', 1),
	(3, 1, 'queso', 1);
/*!40000 ALTER TABLE `materiaprima` ENABLE KEYS */;


-- Volcando estructura para tabla pizzeria.pedido
CREATE TABLE IF NOT EXISTS `pedido` (
  `IDPedido` int(11) NOT NULL AUTO_INCREMENT,
  `NumeroPedido` int(11) NOT NULL,
  `Cliente` int(11) NOT NULL,
  `FechaPedido` date NOT NULL,
  `TotalPedido` double DEFAULT NULL,
  `Pagado` tinyint(1) NOT NULL DEFAULT '0',
  `Preparado` tinyint(1) NOT NULL DEFAULT '0',
  `Adomicilio` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`IDPedido`),
  KEY `FK1IDCliente` (`Cliente`),
  CONSTRAINT `FK1IDCliente` FOREIGN KEY (`Cliente`) REFERENCES `cliente` (`IDCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=124 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla pizzeria.pedido: ~11 rows (aproximadamente)
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
INSERT INTO `pedido` (`IDPedido`, `NumeroPedido`, `Cliente`, `FechaPedido`, `TotalPedido`, `Pagado`, `Preparado`, `Adomicilio`) VALUES
	(112, 1, 1, '2015-10-23', 3600, 0, 0, 1),
	(113, 2, 1, '2015-10-23', 20, 0, 0, 0),
	(114, 3, 2, '2015-10-23', 100, 0, 0, 0),
	(115, 4, 1, '2015-10-23', 400, 0, 0, 1),
	(116, 5, 2, '2015-10-23', 100, 0, 0, 0),
	(117, 6, 1, '2015-10-23', 120, 0, 0, 0),
	(118, 7, 1, '2015-10-23', 32, 0, 0, 0),
	(119, 8, 2, '2015-10-23', 92, 0, 0, 0),
	(120, 9, 2, '2015-10-23', 92, 1, 0, 0),
	(121, 10, 1, '2015-10-23', 21780, 0, 0, 1),
	(122, 11, 1, '2015-10-23', 136, 0, 0, 0),
	(123, 1, 1, '2015-11-01', 31, 0, 0, 0);
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;


-- Volcando estructura para tabla pizzeria.producto
CREATE TABLE IF NOT EXISTS `producto` (
  `IDProducto` int(11) NOT NULL AUTO_INCREMENT,
  `Producto` varchar(200) NOT NULL,
  `Precio` double NOT NULL,
  `Categoria` varchar(50) NOT NULL,
  `Estado` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`IDProducto`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla pizzeria.producto: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` (`IDProducto`, `Producto`, `Precio`, `Categoria`, `Estado`) VALUES
	(1, 'Pizza Napolitana', 8, 'ELABORADO', 1),
	(3, 'Empanadas de carne (Docena)', 100, 'LISTO', 0),
	(4, 'pizza de anchoa', 38, 'ELABORADO', 0),
	(6, 'PROVOLONE', 121, 'ELABORADO', 0),
	(7, 'COCA', 15, 'LISTO', 0);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;


-- Volcando estructura para tabla pizzeria.proveedor
CREATE TABLE IF NOT EXISTS `proveedor` (
  `IDProveedor` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(200) NOT NULL,
  `Telefono` varchar(15) NOT NULL,
  `Categoria` int(11) NOT NULL,
  `Activo` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`IDProveedor`),
  KEY `FK1Cat` (`Categoria`),
  CONSTRAINT `FK1Cat` FOREIGN KEY (`Categoria`) REFERENCES `categoria` (`IDCategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla pizzeria.proveedor: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
INSERT INTO `proveedor` (`IDProveedor`, `Nombre`, `Telefono`, `Categoria`, `Activo`) VALUES
	(1, 'Proveedor1', '11121122', 2, 1),
	(2, 'Mercado ', '4668-1160', 1, 0),
	(3, 'Pepsi', '4663-3665', 2, 1),
	(4, 'Tutifruti', '4668-1160', 1, 1);
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;


-- Volcando estructura para tabla pizzeria.repartidor
CREATE TABLE IF NOT EXISTS `repartidor` (
  `IDRepartidor` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(50) NOT NULL,
  `DireccionRepartidor` varchar(500) NOT NULL,
  `Telefono` varchar(15) NOT NULL,
  `DatosVehiculo` varchar(500) NOT NULL,
  `Activo` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`IDRepartidor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla pizzeria.repartidor: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `repartidor` DISABLE KEYS */;
/*!40000 ALTER TABLE `repartidor` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
