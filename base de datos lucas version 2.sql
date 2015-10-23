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
  PRIMARY KEY (`IDCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla pizzeria.cliente: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` (`IDCliente`, `Cliente`, `DNI`, `Direccion`, `Telefono`) VALUES
	(1, 'CLIENTE PRUEBA 1', '29998776', 'SU CASA', '11776680'),
	(2, 'CLIENTE PRUEBA 2', '30877654', 'SU CASA 2', '12333878');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;


-- Volcando estructura para tabla pizzeria.combos
CREATE TABLE IF NOT EXISTS `combos` (
  `Columna 1` int(11) NOT NULL AUTO_INCREMENT,
  `Precio` double NOT NULL,
  `Productos` varchar(200) NOT NULL,
  `N°Combo` int(11) NOT NULL,
  `Estado` tinyint(4) NOT NULL,
  PRIMARY KEY (`Columna 1`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla pizzeria.combos: ~14 rows (aproximadamente)
/*!40000 ALTER TABLE `combos` DISABLE KEYS */;
INSERT INTO `combos` (`Columna 1`, `Precio`, `Productos`, `N°Combo`, `Estado`) VALUES
	(1, 120, 'pizza anchoas12', 1, 1),
	(2, 60, '', 2, 0),
	(3, 90, ' 1 Doble cola 4 pizza muzarela 6 empanadas', 3, 1),
	(4, 60, ' pizza muzarela + 4', 1, 1),
	(5, 70, ' 2 pizza anchoas 2 pizza muzarela', 1, 1),
	(6, 100, ' 2 pizza muzarela 12 empanadas', 1, 1),
	(7, 120, ' 3 pizza muzarela 1 seven a 1 pizza anchoas', 1, 1),
	(8, 30, ' 3 empanadas 1 coca cola', 6, 1),
	(9, 100, ' 1 seven a 2 pizza muzarela 2 pizza muzarela', 7, 1),
	(10, 220, '', 10, 0),
	(11, 90, ' 1 seven a 3 Doble cola', 11, 1),
	(12, 30, '', 12, 1),
	(13, 0, ' -1 empanadas', 13, 1),
	(14, 20, ' -1 pizza muzarela', 14, 1);
/*!40000 ALTER TABLE `combos` ENABLE KEYS */;


-- Volcando estructura para tabla pizzeria.detallepedido
CREATE TABLE IF NOT EXISTS `detallepedido` (
  `IDPedido` int(11) NOT NULL,
  `IDProducto` int(11) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  `Observacion` varchar(300) NOT NULL,
  PRIMARY KEY (`IDProducto`),
  KEY `FK1IDPedido` (`IDPedido`),
  CONSTRAINT `FK1IDPedido` FOREIGN KEY (`IDPedido`) REFERENCES `pedido` (`IDPedido`),
  CONSTRAINT `FK2IDProduc` FOREIGN KEY (`IDProducto`) REFERENCES `producto` (`IDProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla pizzeria.detallepedido: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `detallepedido` DISABLE KEYS */;
INSERT INTO `detallepedido` (`IDPedido`, `IDProducto`, `Cantidad`, `Observacion`) VALUES
	(1, 1, 2, 'PRUEBA DE OBS');
/*!40000 ALTER TABLE `detallepedido` ENABLE KEYS */;


-- Volcando estructura para tabla pizzeria.materiaprima
CREATE TABLE IF NOT EXISTS `materiaprima` (
  `idMatPrima` int(11) NOT NULL AUTO_INCREMENT,
  `MateriaPrima` int(11) NOT NULL,
  PRIMARY KEY (`idMatPrima`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla pizzeria.materiaprima: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `materiaprima` DISABLE KEYS */;
/*!40000 ALTER TABLE `materiaprima` ENABLE KEYS */;


-- Volcando estructura para tabla pizzeria.pedido
CREATE TABLE IF NOT EXISTS `pedido` (
  `IDPedido` int(11) NOT NULL AUTO_INCREMENT,
  `Cliente` int(11) NOT NULL,
  `FechaPedido` date NOT NULL,
  `SubTotal` double NOT NULL,
  `TotalPedido` double NOT NULL,
  `PagoConfirmado` bit(1) NOT NULL DEFAULT b'0',
  `PedidoPreparado` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`IDPedido`),
  KEY `FK1IDCliente` (`Cliente`),
  CONSTRAINT `FK1IDCliente` FOREIGN KEY (`Cliente`) REFERENCES `cliente` (`IDCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla pizzeria.pedido: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
INSERT INTO `pedido` (`IDPedido`, `Cliente`, `FechaPedido`, `SubTotal`, `TotalPedido`, `PagoConfirmado`, `PedidoPreparado`) VALUES
	(1, 1, '2015-09-28', 100, 100, b'0', b'0');
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;


-- Volcando estructura para tabla pizzeria.producto
CREATE TABLE IF NOT EXISTS `producto` (
  `IDProducto` int(11) NOT NULL AUTO_INCREMENT,
  `Producto` varchar(200) NOT NULL,
  `Precio` double NOT NULL,
  `Categoria` int(11) NOT NULL,
  `Estado` int(30) NOT NULL,
  PRIMARY KEY (`IDProducto`),
  KEY `FK1IDCategoriaPr` (`Categoria`),
  CONSTRAINT `FK1IDCategoriaPr` FOREIGN KEY (`Categoria`) REFERENCES `categoria` (`IDCategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla pizzeria.producto: ~14 rows (aproximadamente)
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` (`IDProducto`, `Producto`, `Precio`, `Categoria`, `Estado`) VALUES
	(1, 'HARINA', 20, 2, 0),
	(2, 'LECHE', 15, 2, 0),
	(7, 'descripcion.toString()', 4, 2, 0),
	(8, 'dfs', 3, 2, 0),
	(9, 'dfs', 3, 2, 0),
	(10, 'dfs', 3, 2, 0),
	(11, 'dfdf', 4, 1, 0),
	(12, 'empanadas', 4.5, 2, 0),
	(13, 'pizza muzarela', 40, 2, 0),
	(14, 'pizza anchoas', 41, 2, 0),
	(15, 'coca cola', 34, 1, 1),
	(16, 'seven a', 32, 1, 1),
	(17, 'Doble cola', 27, 2, 0),
	(18, 'coca cola', 34, 1, 1);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;


-- Volcando estructura para tabla pizzeria.proveedor
CREATE TABLE IF NOT EXISTS `proveedor` (
  `IDProveedor` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(200) NOT NULL,
  `Telefono` varchar(15) NOT NULL,
  `Categoria` int(11) NOT NULL,
  PRIMARY KEY (`IDProveedor`),
  KEY `FK1Cat` (`Categoria`),
  CONSTRAINT `FK1Cat` FOREIGN KEY (`Categoria`) REFERENCES `categoria` (`IDCategoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla pizzeria.proveedor: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;


-- Volcando estructura para tabla pizzeria.repartidor
CREATE TABLE IF NOT EXISTS `repartidor` (
  `IDRepartidor` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(50) NOT NULL,
  `DireccionRepartidor` varchar(500) NOT NULL,
  `Telefono` varchar(15) NOT NULL,
  `DatosVehiculo` varchar(500) NOT NULL,
  PRIMARY KEY (`IDRepartidor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla pizzeria.repartidor: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `repartidor` DISABLE KEYS */;
/*!40000 ALTER TABLE `repartidor` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
