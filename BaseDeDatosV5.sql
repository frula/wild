-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.6.14 - MySQL Community Server (GPL)
-- SO del servidor:              Win32
-- HeidiSQL Versión:             8.1.0.4545
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
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
REPLACE INTO `categoria` (`IDCategoria`, `Categoria`) VALUES
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla pizzeria.cliente: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
REPLACE INTO `cliente` (`IDCliente`, `Cliente`, `DNI`, `Direccion`, `Telefono`, `Activo`) VALUES
	(1, 'CLIENTE PRUEBA 1', '29998776', 'SU CASA', '11776680', 0),
	(2, 'CLIENTE PRUEBA 2', '30877654', 'SU CASA 2', '12333878', 0);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;


-- Volcando estructura para tabla pizzeria.detallepedido
CREATE TABLE IF NOT EXISTS `detallepedido` (
  `IDPedido` int(11) NOT NULL,
  `NumeroPedido` varchar(50) NOT NULL,
  `IDProducto` int(11) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  `Observacion` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`IDProducto`,`NumeroPedido`),
  KEY `FK1IDPedido` (`IDPedido`),
  CONSTRAINT `FK1IDPedido` FOREIGN KEY (`IDPedido`) REFERENCES `pedido` (`IDPedido`),
  CONSTRAINT `FK2IDProduc` FOREIGN KEY (`IDProducto`) REFERENCES `producto` (`IDProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla pizzeria.detallepedido: ~13 rows (aproximadamente)
/*!40000 ALTER TABLE `detallepedido` DISABLE KEYS */;
REPLACE INTO `detallepedido` (`IDPedido`, `NumeroPedido`, `IDProducto`, `Cantidad`, `Observacion`) VALUES
	(85, '1-2015-10-20', 1, 2, 'null'),
	(94, '10-2015-10-20', 1, 3, 'null'),
	(95, '11-2015-10-20', 1, 1, 'null'),
	(86, '2-2015-10-20', 1, 10, 'null'),
	(88, '4-2015-10-20', 1, 1, 'null'),
	(89, '5-2015-10-20', 1, 1, 'null'),
	(90, '6-2015-10-20', 1, 1, 'null'),
	(91, '7-2015-10-20', 1, 1, 'null'),
	(94, '10-2015-10-20', 3, 5, 'null'),
	(95, '11-2015-10-20', 3, 2, 'null'),
	(87, '3-2015-10-20', 3, 1, 'null'),
	(92, '8-2015-10-20', 3, 10, 'null'),
	(93, '9-2015-10-20', 3, 10, 'null');
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
REPLACE INTO `listaproveedor` (`IDProveedor`, `IDMateriaPrima`) VALUES
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla pizzeria.materiaprima: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `materiaprima` DISABLE KEYS */;
REPLACE INTO `materiaprima` (`idMatPrima`, `Categoria`, `MateriaPrima`, `Habilitado`) VALUES
	(1, 2, 'HUEVOS', 0),
	(2, 1, 'HARINA', 0);
/*!40000 ALTER TABLE `materiaprima` ENABLE KEYS */;


-- Volcando estructura para tabla pizzeria.pedido
CREATE TABLE IF NOT EXISTS `pedido` (
  `IDPedido` int(11) NOT NULL AUTO_INCREMENT,
  `NumeroPedido` varchar(50) NOT NULL,
  `Cliente` int(11) NOT NULL,
  `FechaPedido` date NOT NULL,
  `TotalPedido` double DEFAULT NULL,
  `Pagado` tinyint(1) NOT NULL DEFAULT '0',
  `Preparado` tinyint(1) NOT NULL DEFAULT '0',
  `Adomicilio` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`IDPedido`),
  UNIQUE KEY `NumeroPedido_FechaPedido` (`NumeroPedido`),
  KEY `FK1IDCliente` (`Cliente`),
  CONSTRAINT `FK1IDCliente` FOREIGN KEY (`Cliente`) REFERENCES `cliente` (`IDCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla pizzeria.pedido: ~11 rows (aproximadamente)
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
REPLACE INTO `pedido` (`IDPedido`, `NumeroPedido`, `Cliente`, `FechaPedido`, `TotalPedido`, `Pagado`, `Preparado`, `Adomicilio`) VALUES
	(85, '1-2015-10-20', 1, '2015-10-20', 50, 1, 1, 1),
	(86, '2-2015-10-20', 2, '2015-10-20', 200, 1, 1, 0),
	(87, '3-2015-10-20', 1, '2015-10-20', 100, 1, 1, 0),
	(88, '4-2015-10-20', 2, '2015-10-20', 20, 1, 1, 0),
	(89, '5-2015-10-20', 2, '2015-10-20', 20, 1, 1, 0),
	(90, '6-2015-10-20', 1, '2015-10-20', 20, 0, 1, 0),
	(91, '7-2015-10-20', 1, '2015-10-20', 20, 0, 1, 0),
	(92, '8-2015-10-20', 1, '2015-10-20', 1000, 0, 1, 0),
	(93, '9-2015-10-20', 1, '2015-10-20', 1000, 0, 1, 0),
	(94, '10-2015-10-20', 2, '2015-10-20', 560, 0, 1, 0),
	(95, '11-2015-10-20', 1, '2015-10-20', 220, 1, 0, 0);
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
REPLACE INTO `producto` (`IDProducto`, `Producto`, `Precio`, `Categoria`, `Activo`) VALUES
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla pizzeria.proveedor: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
REPLACE INTO `proveedor` (`IDProveedor`, `Nombre`, `Telefono`, `Categoria`, `Activo`) VALUES
	(1, 'Proveedor1', '11121122', 2, 0);
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
