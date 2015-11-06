-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.5.24-log - MySQL Community Server (GPL)
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla pizzeria.categoria: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` (`IDCategoria`, `Categoria`) VALUES
	(1, 'VERDULERIA'),
	(2, 'ALMACEN');
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla pizzeria.cliente: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` (`IDCliente`, `Cliente`, `DNI`, `Direccion`, `Telefono`, `Activo`) VALUES
	(1, 'CLIENTE PRUEBA 1', '29998776', 'guemes', '11776680', 1),
	(2, 'CLIENTE PRUEBA 2', '30877654', 'SU CASA 2', '12333878', 0),
	(3, 'PABLO', '36718500', 'gutierrz', '44881', 1),
	(4, 'DARIO', '36789032', 'lomas', '15666741', 1);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;


-- Volcando estructura para tabla pizzeria.compra
CREATE TABLE IF NOT EXISTS `compra` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `NumeroCompra` int(11) NOT NULL,
  `Proveedor` varchar(50) NOT NULL,
  `Estado` tinyint(4) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla pizzeria.compra: ~7 rows (aproximadamente)
/*!40000 ALTER TABLE `compra` DISABLE KEYS */;
INSERT INTO `compra` (`Id`, `NumeroCompra`, `Proveedor`, `Estado`) VALUES
	(13, 1, 'Tutifruti', 1),
	(14, 1, 'Mercado ', 1),
	(15, 2, 'Proveedor1', 1),
	(16, 3, 'Mercado ', 1),
	(17, 4, 'proveedor2', 1),
	(18, 5, 'proveedor2', 1),
	(19, 6, 'proveedor2', 1);
/*!40000 ALTER TABLE `compra` ENABLE KEYS */;


-- Volcando estructura para tabla pizzeria.detallecompra
CREATE TABLE IF NOT EXISTS `detallecompra` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `IdMateriaPrima` varchar(50) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  `IdCompra` int(11) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla pizzeria.detallecompra: ~11 rows (aproximadamente)
/*!40000 ALTER TABLE `detallecompra` DISABLE KEYS */;
INSERT INTO `detallecompra` (`Id`, `IdMateriaPrima`, `Cantidad`, `IdCompra`) VALUES
	(16, 'HARINA', 3, 1),
	(17, 'HARINA', 3, 1),
	(19, 'HARINA', 3, 2),
	(21, 'HUEVOS', 4, 2),
	(24, 'HUEVOS', 3, 4),
	(25, 'MUZARELLA', 4, 4),
	(26, 'MUZARELLA', 8, 5),
	(27, 'HUEVOS', 8, 5),
	(28, 'MUZARELLA', 8, 6),
	(29, 'MUZARELLA', 8, 6),
	(30, 'HUEVOS', 20, 6);
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

-- Volcando datos para la tabla pizzeria.detallepedido: ~10 rows (aproximadamente)
/*!40000 ALTER TABLE `detallepedido` DISABLE KEYS */;
INSERT INTO `detallepedido` (`IDPedido`, `NumeroPedido`, `IDProducto`, `Cantidad`, `Observacion`) VALUES
	(99, 1, 1, 3, '60.0'),
	(100, 3, 1, 10, 'observacion 1'),
	(102, 4, 1, 1, 'null'),
	(100, 5, 1, 3, 'null'),
	(100, 6, 1, 1, 'null'),
	(106, 8, 1, 63, '60.0'),
	(107, 9, 1, 2, 'null'),
	(99, 1, 3, 22, '2200.0'),
	(100, 2, 3, 2, ''),
	(106, 8, 3, 1, 'null');
/*!40000 ALTER TABLE `detallepedido` ENABLE KEYS */;


-- Volcando estructura para tabla pizzeria.itinerario
CREATE TABLE IF NOT EXISTS `itinerario` (
  `IdItinerario` int(11) NOT NULL AUTO_INCREMENT,
  `NumeroEntrega` int(11) NOT NULL DEFAULT '0',
  `IdRepartidor` int(11) DEFAULT NULL,
  `IdPedido` int(11) DEFAULT NULL,
  `Fecha` date DEFAULT NULL,
  PRIMARY KEY (`IdItinerario`),
  KEY `FK2Pedido` (`IdRepartidor`),
  KEY `FK3Pedido` (`IdPedido`),
  CONSTRAINT `FK1Repartidor` FOREIGN KEY (`IdRepartidor`) REFERENCES `repartidor` (`IDRepartidor`),
  CONSTRAINT `FK3Pedido` FOREIGN KEY (`IdPedido`) REFERENCES `pedido` (`IDPedido`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 CHECKSUM=1;

-- Volcando datos para la tabla pizzeria.itinerario: ~9 rows (aproximadamente)
/*!40000 ALTER TABLE `itinerario` DISABLE KEYS */;
INSERT INTO `itinerario` (`IdItinerario`, `NumeroEntrega`, `IdRepartidor`, `IdPedido`, `Fecha`) VALUES
	(4, 0, 2, 104, '2015-11-05'),
	(5, 0, 2, 106, '2015-11-05'),
	(6, 2, 1, 105, '2015-11-06'),
	(7, 2, 1, 109, '2015-11-06'),
	(8, 4, 1, 107, '2015-11-06'),
	(9, 5, 1, 105, '2015-11-06'),
	(10, 6, 1, 104, '2015-11-06'),
	(11, 7, 1, 106, '2015-11-06'),
	(12, 8, 1, 108, '2015-11-06');
/*!40000 ALTER TABLE `itinerario` ENABLE KEYS */;


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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla pizzeria.materiaprima: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `materiaprima` DISABLE KEYS */;
INSERT INTO `materiaprima` (`idMatPrima`, `Categoria`, `MateriaPrima`, `Habilitado`) VALUES
	(1, 2, 'HUEVOS', 0),
	(2, 1, 'HARINA', 0),
	(3, 2, 'MUZARELLA', 1),
	(4, 1, 'MORRON', 1),
	(5, 1, 'PAPA', 1);
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
  `Itinerario` tinyint(4) DEFAULT '0',
  `Estado` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`IDPedido`),
  KEY `FK1IDCliente` (`Cliente`),
  CONSTRAINT `FK1IDCliente` FOREIGN KEY (`Cliente`) REFERENCES `cliente` (`IDCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=112 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla pizzeria.pedido: ~11 rows (aproximadamente)
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
INSERT INTO `pedido` (`IDPedido`, `NumeroPedido`, `Cliente`, `FechaPedido`, `TotalPedido`, `Pagado`, `Preparado`, `Adomicilio`, `Itinerario`, `Estado`) VALUES
	(101, 3, 1, '2015-10-22', 300, 0, 0, 1, NULL, 'Preparado'),
	(102, 4, 1, '2015-10-22', 120, 0, 0, 1, NULL, 'Preparado'),
	(103, 5, 1, '2015-10-22', 60, 0, 1, 0, NULL, 'Preparado'),
	(104, 6, 1, '2015-10-22', 20, 0, 0, 1, NULL, 'Entregado'),
	(105, 7, 2, '2015-10-22', 60, 0, 0, 0, NULL, 'Entregado'),
	(106, 8, 2, '2015-10-22', 1360, 1, 0, 0, NULL, 'Entregado'),
	(107, 9, 2, '2015-10-22', 40, 0, 0, 0, NULL, 'Entregado'),
	(108, 10, 1, '2015-10-22', 20, 0, 0, 0, NULL, 'Entregado'),
	(109, 11, 1, '2015-10-22', 40, 0, 0, 0, NULL, 'Entregado'),
	(110, 12, 3, '2015-10-30', 300, 0, 0, 1, 0, 'No preparado'),
	(111, 13, 3, '2015-10-31', 40, 1, 0, 1, 0, 'No preparado');
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;


-- Volcando estructura para tabla pizzeria.producto
CREATE TABLE IF NOT EXISTS `producto` (
  `IDProducto` int(11) NOT NULL AUTO_INCREMENT,
  `Producto` varchar(200) NOT NULL,
  `Precio` double NOT NULL,
  `Categoria` int(11) NOT NULL,
  `Activo` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`IDProducto`),
  KEY `FK1IDCategoriaPr` (`Categoria`),
  CONSTRAINT `FK1IDCategoriaPr` FOREIGN KEY (`Categoria`) REFERENCES `categoria` (`IDCategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla pizzeria.producto: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` (`IDProducto`, `Producto`, `Precio`, `Categoria`, `Activo`) VALUES
	(1, 'Pizza Napolitana', 20, 2, 0),
	(3, 'Empanadas de carne (Docena)', 100, 2, 0);
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla pizzeria.proveedor: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
INSERT INTO `proveedor` (`IDProveedor`, `Nombre`, `Telefono`, `Categoria`, `Activo`) VALUES
	(1, 'Proveedor1', '11121122', 2, 0),
	(2, 'proveedor2', '156666', 2, 1);
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla pizzeria.repartidor: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `repartidor` DISABLE KEYS */;
INSERT INTO `repartidor` (`IDRepartidor`, `Nombre`, `DireccionRepartidor`, `Telefono`, `DatosVehiculo`, `Activo`) VALUES
	(1, 'Repartidor1', '', '44446464', 'moto', 1),
	(2, 'Repartidor2', '', '445678900', 'Bici', 1);
/*!40000 ALTER TABLE `repartidor` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
