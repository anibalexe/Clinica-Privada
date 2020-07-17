-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-08-2019 a las 06:48:43
-- Versión del servidor: 10.1.38-MariaDB
-- Versión de PHP: 7.3.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `clinicaprivada`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `almacen`
--

CREATE TABLE `almacen` (
  `sala` int(11) NOT NULL,
  `capacidad` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `almacen`
--

INSERT INTO `almacen` (`sala`, `capacidad`) VALUES
(1, 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cajadecompensacion`
--

CREATE TABLE `cajadecompensacion` (
  `id` int(10) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `porcentajeDescuento` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cajadecompensacion`
--

INSERT INTO `cajadecompensacion` (`id`, `nombre`, `porcentajeDescuento`) VALUES
(1, 'Caja los andes', 0.3),
(2, 'Caja 18', 0.4),
(3, 'Los Heroes', 0.4),
(4, 'La Araucana', 0.5),
(5, 'Gabriela Mistral', 0.3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `espacio`
--

CREATE TABLE `espacio` (
  `id` int(11) NOT NULL,
  `capacidad` int(11) DEFAULT NULL,
  `idEstante` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `espacio`
--

INSERT INTO `espacio` (`id`, `capacidad`, `idEstante`) VALUES
(1, 10, 1),
(2, 10, 1),
(3, 10, 2),
(4, 10, 2),
(5, 10, 3),
(6, 10, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estante`
--

CREATE TABLE `estante` (
  `id` int(11) NOT NULL,
  `capacidad` int(11) DEFAULT NULL,
  `sala` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `estante`
--

INSERT INTO `estante` (`id`, `capacidad`, `sala`) VALUES
(1, 10, 1),
(2, 10, 1),
(3, 10, 1),
(4, 10, 1),
(5, 10, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `fonasa`
--

CREATE TABLE `fonasa` (
  `id` int(10) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `porcentajeDescuento` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `fonasa`
--

INSERT INTO `fonasa` (`id`, `nombre`, `porcentajeDescuento`) VALUES
(1, 'A', 1),
(2, 'B', 0.9),
(3, 'C', 0.7),
(4, 'D', 0.5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `insumo`
--

CREATE TABLE `insumo` (
  `id` int(11) NOT NULL,
  `valor` int(11) DEFAULT NULL,
  `nombre` varchar(20) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `idEspacio` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `insumo`
--

INSERT INTO `insumo` (`id`, `valor`, `nombre`, `fecha`, `idEspacio`) VALUES
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(3, 5000, 'Gasa', '2019-04-29', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(1, 3000, 'Algodon', '2019-04-23', 1),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5),
(4, 3500, 'Jeringa', '0002-11-30', 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `insumosservicio`
--

CREATE TABLE `insumosservicio` (
  `id` int(10) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `precio` int(10) NOT NULL,
  `IdServicio` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `insumosservicio`
--

INSERT INTO `insumosservicio` (`id`, `nombre`, `precio`, `IdServicio`) VALUES
(1, 'gaza', 1000, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `isapre`
--

CREATE TABLE `isapre` (
  `id` int(10) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `porcentajeDescuento` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `isapre`
--

INSERT INTO `isapre` (`id`, `nombre`, `porcentajeDescuento`) VALUES
(1, 'Banmedica', 0.2),
(2, 'Vida Tres', 0.3),
(3, 'Mas Vida', 0.5),
(4, 'Consalud', 0.7),
(5, 'Colmena', 0.3),
(6, 'Cruz Blanca', 0.25);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pago`
--

CREATE TABLE `pago` (
  `id` int(10) NOT NULL,
  `montoneto` float NOT NULL,
  `fecha` date NOT NULL,
  `idUsuario` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `pago`
--

INSERT INTO `pago` (`id`, `montoneto`, `fecha`, `idUsuario`) VALUES
(1, 36000, '2019-06-12', '1'),
(2, 40000, '2019-07-10', '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `seguro`
--

CREATE TABLE `seguro` (
  `id` int(10) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `porcentajeDescuento` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `seguro`
--

INSERT INTO `seguro` (`id`, `nombre`, `porcentajeDescuento`) VALUES
(1, 'Salud', 0.4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `servicio`
--

CREATE TABLE `servicio` (
  `id` int(10) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `manoDeObra` float NOT NULL,
  `montoBruto` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `servicio`
--

INSERT INTO `servicio` (`id`, `nombre`, `manoDeObra`, `montoBruto`) VALUES
(1, 'Curacion Simple', 5000, 0),
(2, 'Cirugia de Pancreas', 150000, 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `almacen`
--
ALTER TABLE `almacen`
  ADD PRIMARY KEY (`sala`);

--
-- Indices de la tabla `cajadecompensacion`
--
ALTER TABLE `cajadecompensacion`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `espacio`
--
ALTER TABLE `espacio`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_idEstante` (`idEstante`);

--
-- Indices de la tabla `estante`
--
ALTER TABLE `estante`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_Sala` (`sala`);

--
-- Indices de la tabla `fonasa`
--
ALTER TABLE `fonasa`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `insumo`
--
ALTER TABLE `insumo`
  ADD KEY `FK_idEspacio` (`idEspacio`);

--
-- Indices de la tabla `isapre`
--
ALTER TABLE `isapre`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `pago`
--
ALTER TABLE `pago`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `seguro`
--
ALTER TABLE `seguro`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `servicio`
--
ALTER TABLE `servicio`
  ADD PRIMARY KEY (`id`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `espacio`
--
ALTER TABLE `espacio`
  ADD CONSTRAINT `FK_idEstante` FOREIGN KEY (`idEstante`) REFERENCES `estante` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `espacio_ibfk_1` FOREIGN KEY (`idEstante`) REFERENCES `estante` (`id`);

--
-- Filtros para la tabla `estante`
--
ALTER TABLE `estante`
  ADD CONSTRAINT `FK_Sala` FOREIGN KEY (`sala`) REFERENCES `almacen` (`sala`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `estante_ibfk_1` FOREIGN KEY (`sala`) REFERENCES `almacen` (`sala`);

--
-- Filtros para la tabla `insumo`
--
ALTER TABLE `insumo`
  ADD CONSTRAINT `FK_idEspacio` FOREIGN KEY (`idEspacio`) REFERENCES `espacio` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `insumo_ibfk_1` FOREIGN KEY (`idEspacio`) REFERENCES `espacio` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
