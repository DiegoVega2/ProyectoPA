-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-11-2022 a las 23:56:16
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_ventas`
--
CREATE DATABASE IF NOT EXISTS `bd_ventas` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `bd_ventas`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `IdCliente` int(11) UNSIGNED NOT NULL,
  `Dni` varchar(8) DEFAULT NULL,
  `Nombres` varchar(244) DEFAULT NULL,
  `Direccion` varchar(244) DEFAULT NULL,
  `Estado` varchar(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`IdCliente`, `Dni`, `Nombres`, `Direccion`, `Estado`) VALUES
(17, '2', 'Juan Guerrero Solis', 'Los Alamos', '1'),
(18, '1', 'Maria Rosas Villanueva', 'Los Laureles 234', '1'),
(19, '3', 'Andres de Santa Cruz', 'Av. La Frontera 347', '1'),
(20, '4', 'Andres Mendoza', 'Chosica, Lurigancho', '1'),
(22, '123', 'Diego Vega', '8135736', '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_ventas`
--

CREATE TABLE `detalle_ventas` (
  `IdDetalleVentas` int(11) UNSIGNED NOT NULL,
  `IdVentas` int(11) UNSIGNED NOT NULL,
  `IdProducto` int(11) UNSIGNED NOT NULL,
  `Cantidad` int(11) UNSIGNED DEFAULT NULL,
  `PrecioVenta` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `detalle_ventas`
--

INSERT INTO `detalle_ventas` (`IdDetalleVentas`, `IdVentas`, `IdProducto`, `Cantidad`, `PrecioVenta`) VALUES
(166, 1, 2, 8, 20),
(167, 1, 3, 1, 800),
(168, 1, 3, 1, 800),
(169, 1, 3, 1, 800),
(170, 1, 1, 1, 150),
(171, 1, 3, 1, 800),
(172, 1, 3, 1, 800),
(173, 1, 3, 1, 800),
(174, 1, 3, 1, 800),
(175, 1, 3, 1, 800),
(176, 1, 3, 1, 800),
(177, 1, 3, 1, 800),
(178, 1, 3, 1, 800),
(179, 108, 3, 1, 800),
(180, 109, 3, 1, 800),
(181, 110, 3, 1, 800),
(182, 111, 2, 1, 20),
(183, 112, 3, 1, 800),
(184, 113, 3, 1, 800),
(185, 114, 1, 1, 150),
(186, 114, 3, 1, 800),
(187, 115, 3, 1, 800),
(188, 115, 4, 1, 500),
(189, 116, 3, 1, 800),
(190, 117, 2, 1, 20),
(191, 118, 3, 1, 800),
(192, 119, 3, 1, 800),
(193, 120, 3, 1, 800),
(194, 121, 3, 1, 800),
(195, 122, 3, 1, 800),
(196, 123, 3, 1, 800);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `IdEmpleado` int(10) UNSIGNED NOT NULL,
  `Dni` varchar(8) NOT NULL,
  `Nombres` varchar(255) DEFAULT NULL,
  `Telefono` varchar(18) DEFAULT NULL,
  `Estado` varchar(1) DEFAULT NULL,
  `User` varchar(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`IdEmpleado`, `Dni`, `Nombres`, `Telefono`, `Estado`, `User`) VALUES
(1, '123', 'Pedro Hernandez', '988252459', '1', 'emp01'),
(10, '123', 'Diego Vega', '3014669669', '1', 'Alen'),
(11, '123', 'Karen', '677667', '8', 'Karenso'),
(20, '123', 'Sandra', '321312', '1', 'Sandra');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `IdProducto` int(11) UNSIGNED NOT NULL,
  `Nombres` varchar(244) DEFAULT NULL,
  `Precio` double DEFAULT NULL,
  `Stock` int(11) UNSIGNED DEFAULT NULL,
  `Estado` varchar(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`IdProducto`, `Nombres`, `Precio`, `Stock`, `Estado`) VALUES
(1, 'Teclado Logitech 345 Editado', 150, 97, '1'),
(2, 'Mouse Logitech 567', 20, 88, '1'),
(3, 'Laptop Lenovo Ideapad 520', 800, 72, '1'),
(4, 'HeadPhones Sony M333', 500, 97, '1'),
(7, 'Microfono Omkara VSG  ', 35, 35, '1'),
(9, 'Coca-Cola', 3800, 47, '1'),
(11, 'Gygabyte GTX 1070Ti', 4321, 12, '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `IdVentas` int(11) UNSIGNED NOT NULL,
  `IdCliente` int(11) UNSIGNED NOT NULL,
  `IdEmpleado` int(11) UNSIGNED NOT NULL,
  `NumeroSerie` varchar(244) DEFAULT NULL,
  `FechaVentas` varchar(15) DEFAULT NULL,
  `Monto` double DEFAULT NULL,
  `Estado` varchar(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `ventas`
--

INSERT INTO `ventas` (`IdVentas`, `IdCliente`, `IdEmpleado`, `NumeroSerie`, `FechaVentas`, `Monto`, `Estado`) VALUES
(1, 17, 1, '00000010', '2022-11-26', 345, '1'),
(108, 17, 1, '00000011', '27/10/2022', 800, '1'),
(109, 17, 1, '00000012', '27/10/2022', 800, '1'),
(110, 17, 1, '00000013', '27/10/2022', 800, '1'),
(111, 19, 1, '00000014', '27/10/2022', 20, '1'),
(112, 17, 10, '00000015', '28/10/2022', 800, '1'),
(113, 17, 10, '00000016', '28/10/2022', 800, '1'),
(114, 17, 1, '00000017', '28/10/2022', 800, '1'),
(115, 17, 1, '00000018', '28/10/2022', 500, '1'),
(116, 17, 1, '00000019', '28/10/2022', 800, '1'),
(117, 19, 1, '00000020', '28/10/2022', 20, '1'),
(118, 17, 1, '00000021', '28/10/2022', 800, '1'),
(119, 17, 1, '00000022', '28/10/2022', 800, '1'),
(120, 17, 1, '00000023', '28/10/2022', 800, '1'),
(121, 17, 1, '00000024', '28/10/2022', 800, '1'),
(122, 17, 1, '00000025', '28/10/2022', 800, '1'),
(123, 17, 1, '00000026', '28/10/2022', 800, '1');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`IdCliente`);

--
-- Indices de la tabla `detalle_ventas`
--
ALTER TABLE `detalle_ventas`
  ADD PRIMARY KEY (`IdDetalleVentas`,`IdVentas`,`IdProducto`),
  ADD KEY `Ventas_has_Producto_FKIndex1` (`IdVentas`),
  ADD KEY `Ventas_has_Producto_FKIndex2` (`IdProducto`);

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`IdEmpleado`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`IdProducto`);

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`IdVentas`),
  ADD KEY `Ventas_FKIndex1` (`IdEmpleado`),
  ADD KEY `Ventas_FKIndex2` (`IdCliente`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `IdCliente` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT de la tabla `detalle_ventas`
--
ALTER TABLE `detalle_ventas`
  MODIFY `IdDetalleVentas` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=197;

--
-- AUTO_INCREMENT de la tabla `empleado`
--
ALTER TABLE `empleado`
  MODIFY `IdEmpleado` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `IdProducto` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `ventas`
--
ALTER TABLE `ventas`
  MODIFY `IdVentas` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=124;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalle_ventas`
--
ALTER TABLE `detalle_ventas`
  ADD CONSTRAINT `detalle_ventas_ibfk_1` FOREIGN KEY (`IdVentas`) REFERENCES `ventas` (`IdVentas`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `detalle_ventas_ibfk_2` FOREIGN KEY (`IdProducto`) REFERENCES `producto` (`IdProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD CONSTRAINT `ventas_ibfk_1` FOREIGN KEY (`IdEmpleado`) REFERENCES `empleado` (`IdEmpleado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `ventas_ibfk_2` FOREIGN KEY (`IdCliente`) REFERENCES `cliente` (`IdCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
