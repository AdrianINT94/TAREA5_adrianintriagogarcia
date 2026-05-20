-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 20-05-2026 a las 23:02:39
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `circo_adrianintriago`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `artistas`
--

CREATE TABLE `artistas` (
  `id` bigint(20) NOT NULL,
  `apodo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `artistas`
--

INSERT INTO `artistas` (`id`, `apodo`) VALUES
(5, 'Konce'),
(7, 'Intriago'),
(8, 'Robot');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `artista_especialidades`
--

CREATE TABLE `artista_especialidades` (
  `id` bigint(20) NOT NULL,
  `especialidades` enum('ACROBACIA','EQUILIBRISMO','HUMOR','MAGIA','MALABARISMO') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `coordinadores`
--

CREATE TABLE `coordinadores` (
  `id` bigint(20) NOT NULL,
  `senior` tinyint(1) DEFAULT 0,
  `fecha_senior` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `coordinadores`
--

INSERT INTO `coordinadores` (`id`, `senior`, `fecha_senior`) VALUES
(1, 1, NULL),
(6, 1, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `credenciales`
--

CREATE TABLE `credenciales` (
  `id` bigint(20) NOT NULL,
  `nombreusuario` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `rol` enum('ADMIN','ARTISTA','COORDINADOR') DEFAULT NULL,
  `persona_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `credenciales`
--

INSERT INTO `credenciales` (`id`, `nombreusuario`, `password`, `rol`, `persona_id`) VALUES
(1, 'admin', 'admin', 'ADMIN', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `espectaculos`
--

CREATE TABLE `espectaculos` (
  `id` bigint(20) NOT NULL,
  `fecha_fin` date NOT NULL,
  `fecha_inicio` date NOT NULL,
  `nombre` varchar(25) NOT NULL,
  `coordinador_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `espectaculos`
--

INSERT INTO `espectaculos` (`id`, `fecha_fin`, `fecha_inicio`, `nombre`, `coordinador_id`) VALUES
(1, '2026-05-31', '2026-05-01', 'Cisnes Negros', 6),
(2, '2026-05-27', '2026-05-02', 'Carros de Fuego ', 6),
(3, '2026-05-31', '2026-05-11', 'Polo Norte', 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `numeros`
--

CREATE TABLE `numeros` (
  `id` bigint(20) NOT NULL,
  `duracion` double DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `orden` int(11) NOT NULL,
  `espectaculo_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `numeros`
--

INSERT INTO `numeros` (`id`, `duracion`, `nombre`, `orden`, `espectaculo_id`) VALUES
(2, 10, 'Acto1', 0, 2),
(3, 50, 'Acto2', 0, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `numero_artista`
--

CREATE TABLE `numero_artista` (
  `numero_id` bigint(20) NOT NULL,
  `artista_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `numero_artista`
--

INSERT INTO `numero_artista` (`numero_id`, `artista_id`) VALUES
(2, 5),
(3, 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personas`
--

CREATE TABLE `personas` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) NOT NULL,
  `nacionalidad` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `personas`
--

INSERT INTO `personas` (`id`, `email`, `nacionalidad`, `nombre`) VALUES
(1, 'admin@circo.com', 'Española', 'Administrador'),
(5, 'Dani@educastur.es', 'Japones', 'Daniel'),
(6, 'Francisco@educastur.es', 'Brasileño', 'Fran'),
(7, 'wkj62135@educastur.es', 'Americano', 'Adrian'),
(8, 'Ruben@educastur.es', 'Escandinavo', 'Ruben');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `artistas`
--
ALTER TABLE `artistas`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `artista_especialidades`
--
ALTER TABLE `artista_especialidades`
  ADD KEY `FKo9q86j109eridmgm8581rx9ax` (`id`);

--
-- Indices de la tabla `coordinadores`
--
ALTER TABLE `coordinadores`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `credenciales`
--
ALTER TABLE `credenciales`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_y84i4f4kdrpo1pvq99vsop74` (`nombreusuario`),
  ADD KEY `FKdrfftlast5p4qtiisw19u888w` (`persona_id`);

--
-- Indices de la tabla `espectaculos`
--
ALTER TABLE `espectaculos`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_hfcxcafgirg2fd73hg256fd50` (`nombre`),
  ADD KEY `FK5krgn5b10dfpwcu34f53o0v04` (`coordinador_id`);

--
-- Indices de la tabla `numeros`
--
ALTER TABLE `numeros`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_numero_espectaculo` (`espectaculo_id`);

--
-- Indices de la tabla `numero_artista`
--
ALTER TABLE `numero_artista`
  ADD KEY `FKkvqcspg7iocgr53vvh33vbgo0` (`artista_id`),
  ADD KEY `FKk869b936w40dt3cm8rfa6xuv7` (`numero_id`);

--
-- Indices de la tabla `personas`
--
ALTER TABLE `personas`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `artistas`
--
ALTER TABLE `artistas`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `coordinadores`
--
ALTER TABLE `coordinadores`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `credenciales`
--
ALTER TABLE `credenciales`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `espectaculos`
--
ALTER TABLE `espectaculos`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `numeros`
--
ALTER TABLE `numeros`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `personas`
--
ALTER TABLE `personas`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `artistas`
--
ALTER TABLE `artistas`
  ADD CONSTRAINT `FK2140y9hyhpeltkxtcxae7on1l` FOREIGN KEY (`id`) REFERENCES `personas` (`id`);

--
-- Filtros para la tabla `artista_especialidades`
--
ALTER TABLE `artista_especialidades`
  ADD CONSTRAINT `FKo9q86j109eridmgm8581rx9ax` FOREIGN KEY (`id`) REFERENCES `artistas` (`id`);

--
-- Filtros para la tabla `coordinadores`
--
ALTER TABLE `coordinadores`
  ADD CONSTRAINT `FKjo6h3ermcbbpw7btx840rfnxb` FOREIGN KEY (`id`) REFERENCES `personas` (`id`);

--
-- Filtros para la tabla `credenciales`
--
ALTER TABLE `credenciales`
  ADD CONSTRAINT `FKdrfftlast5p4qtiisw19u888w` FOREIGN KEY (`persona_id`) REFERENCES `personas` (`id`);

--
-- Filtros para la tabla `espectaculos`
--
ALTER TABLE `espectaculos`
  ADD CONSTRAINT `FK5krgn5b10dfpwcu34f53o0v04` FOREIGN KEY (`coordinador_id`) REFERENCES `coordinadores` (`id`);

--
-- Filtros para la tabla `numeros`
--
ALTER TABLE `numeros`
  ADD CONSTRAINT `FK_numero_espectaculo` FOREIGN KEY (`espectaculo_id`) REFERENCES `espectaculos` (`id`);

--
-- Filtros para la tabla `numero_artista`
--
ALTER TABLE `numero_artista`
  ADD CONSTRAINT `FKk869b936w40dt3cm8rfa6xuv7` FOREIGN KEY (`numero_id`) REFERENCES `numeros` (`id`),
  ADD CONSTRAINT `FKkvqcspg7iocgr53vvh33vbgo0` FOREIGN KEY (`artista_id`) REFERENCES `artistas` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
