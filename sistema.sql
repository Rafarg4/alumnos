-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 10-06-2023 a las 03:16:32
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 8.0.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sistema`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnos`
--

CREATE TABLE `alumnos` (
  `id` int(11) NOT NULL,
  `nombre` text NOT NULL,
  `apellido` text NOT NULL,
  `edad` text NOT NULL,
  `Direccion` text NOT NULL,
  `fechanac` date NOT NULL,
  `carrera` text NOT NULL,
  `genero` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `alumnos`
--

INSERT INTO `alumnos` (`id`, `nombre`, `apellido`, `edad`, `Direccion`, `fechanac`, `carrera`, `genero`) VALUES
(11, 'er', 'er', 'er', 'er', '2023-05-12', 'Lic. Analisis de sistemas', ''),
(12, 'erd', 'erd', 'erd', 'erd', '2023-05-05', 'Lic. Diseño grafico', ''),
(13, 'aaa', 'aa', '1aaaa', 'aa', '2023-06-15', 'Lic. Analisis de sistemas', ''),
(14, 'as', 'as', 'as', 'as', '2023-06-30', 'Lic. Diseño de modas', ''),
(15, 'Rafael', 'Escobar', '22', 'Barrio san isido', '2023-06-16', 'Lic. Analisis de sistemas', 'Masculino'),
(16, 'CARMEN', 'IJIJ', '78', 'JIJI', '2023-06-17', 'Lic. Diseño de modas', 'Femenino'),
(17, 'Mario', 'Gomez', '34', 'Barrio la amistad', '1970-01-01', 'Arquitectura', 'Otro'),
(18, 'Mariojiji', 'Gomezjiji', '34', 'Barrio la amistad', '1970-01-01', 'Arquitectura', 'Masculino'),
(19, 'Mariojiji', 'Gomezjiji', '34', 'Barrio la amistad', '1970-01-01', 'Arquitectura', 'Femenino'),
(20, 'aaa', 'a', 'a', 'a', '2023-06-09', 'Lic. Diseño grafico', 'Masculino');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
