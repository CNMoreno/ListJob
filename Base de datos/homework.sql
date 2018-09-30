-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-09-2018 a las 03:21:38
-- Versión del servidor: 10.1.36-MariaDB
-- Versión de PHP: 7.0.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `homework`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tareas`
--

CREATE TABLE `tareas` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `Descripcion` varchar(400) NOT NULL,
  `Estado` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tareas`
--

INSERT INTO `tareas` (`id`, `nombre`, `Descripcion`, `Estado`) VALUES
(1, 'Felipe', 'Tal vez', 1),
(2, 'cristian', 'sssss', 0),
(3, 'mat', 'mor', 2),
(4, 'SAD', 'ASD', 2),
(5, 'SAD', 'ASD', 2),
(6, 'AA', 'AA', 2),
(7, 'asd', 'AAsad', 2),
(8, 'Pipe', 'Tal vez', 1),
(9, 'Pepe', 'Tal vez', 1),
(10, 'Felipe', 'Tal vez', 1),
(11, 'pipe', 'Tal vez', 1),
(12, 'a', 'Tal vez', 1),
(13, 'a', 'Tal vez', 1),
(14, 'a', 'Tal vez', 1),
(15, 'AS', 'Tal vez', 1),
(16, 'AS', 'AS', 2),
(17, 'X', 'Tal vez', 1),
(18, 'AS', 'Tal vez', 1),
(19, 'as', 'Tal vez', 1),
(20, 'Felipe', 'Tal vez', 1),
(21, 'as', 'Tal vez', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tareas`
--
ALTER TABLE `tareas`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tareas`
--
ALTER TABLE `tareas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
