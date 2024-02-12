-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 12-02-2024 a las 12:12:15
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `test_store`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `client`
--

CREATE TABLE `client` (
  `id_cliente` bigint(20) NOT NULL,
  `apellidos` varchar(255) NOT NULL,
  `codigo_postal` varchar(255) NOT NULL,
  `contrasena` varchar(255) NOT NULL,
  `correo_electronico` varchar(255) NOT NULL,
  `direccion` varchar(255) NOT NULL,
  `foto_perfil_url` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) NOT NULL,
  `numero_tarjeta` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `client`
--

INSERT INTO `client` (`id_cliente`, `apellidos`, `codigo_postal`, `contrasena`, `correo_electronico`, `direccion`, `foto_perfil_url`, `nombre`, `numero_tarjeta`) VALUES
(1, 'Lovelace', '12345', 'ada123', 'ada@example.com', 'Calle Principal 123', 'url_foto_ada.jpg', 'Ada', '1234567890123456'),
(2, 'Turing', '54321', 'alan123', 'alan@example.com', 'Avenida Central 456', 'url_foto_alan.jpg', 'Alan', '9876543210987654'),
(3, 'Hopper', '67890', 'grace123', 'grace@example.com', 'Plaza Mayor 789', 'url_foto_grace.jpg', 'Grace', '2468013579246801'),
(4, 'Torvalds', '13579', 'linus123', 'linus@example.com', 'Calle Secundaria 321', 'url_foto_linus.jpg', 'Linus', '7890123456789012'),
(5, 'Hamilton', '98765', 'margaret123', 'margaret@example.com', 'Paseo del Bosque 654', 'url_foto_margaret.jpg', 'Margaret', '3579246801357924'),
(6, 'Noether', '54321', 'emmy123', 'emmy@example.com', 'Avenue 42', 'url_foto_margaret.jpg', 'Emmy', '9876543210987654');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_pedido`
--

CREATE TABLE `detalle_pedido` (
  `id_detalle_pedido` bigint(20) NOT NULL,
  `unidades_producto` int(11) DEFAULT NULL,
  `pedido_id` bigint(20) DEFAULT NULL,
  `id_producto` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `detalle_pedido`
--

INSERT INTO `detalle_pedido` (`id_detalle_pedido`, `unidades_producto`, `pedido_id`, `id_producto`) VALUES
(1, 2, 1, 3),
(2, 1, 1, 5),
(3, 2, 1, 3),
(4, 4, 2, 6),
(5, 1, 3, 2),
(6, 1, 3, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `orders`
--

CREATE TABLE `orders` (
  `id_pedido` bigint(20) NOT NULL,
  `fecha_pedido` datetime(6) DEFAULT NULL,
  `id_cliente` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `orders`
--

INSERT INTO `orders` (`id_pedido`, `fecha_pedido`, `id_cliente`) VALUES
(1, NULL, NULL),
(2, '2024-02-02 11:50:52.000000', 4),
(3, '2024-02-11 11:51:24.000000', 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `product`
--

CREATE TABLE `product` (
  `id_producto` bigint(20) NOT NULL,
  `descripcion` varchar(255) NOT NULL,
  `imagen_url` varchar(255) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `precio` double NOT NULL,
  `stock` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `product`
--

INSERT INTO `product` (`id_producto`, `descripcion`, `imagen_url`, `nombre`, `precio`, `stock`) VALUES
(2, 'Las icónicas zapatillas Nike Air Jordan 1, diseñadas para el jugador de baloncesto Michael Jordan.', 'url_imagen_jordan.jpg', 'Nike Air Jordan 1', 200, 50),
(3, 'Las clásicas zapatillas Adidas Stan Smith, un símbolo de estilo y comodidad.', 'url_imagen_stan_smith.jpg', 'Adidas Stan Smith', 100, 100),
(4, 'Las populares zapatillas Converse Chuck Taylor All Star, un diseño atemporal que ha perdurado por décadas.', 'url_imagen_chuck_taylor.jpg', 'Converse Chuck Taylor All Star', 80, 75),
(5, 'Las modernas zapatillas Adidas UltraBoost, conocidas por su comodidad y tecnología de amortiguación.', 'url_imagen_ultraboost.jpg', 'Adidas UltraBoost', 180, 60),
(6, 'Las emblemáticas zapatillas Vans Old Skool, un icono del estilo urbano y la cultura skater.', 'url_imagen_old_skool.jpg', 'Vans Old Skool', 90, 90);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id_cliente`),
  ADD UNIQUE KEY `UK_30axgmrs8y43ea31p1r0unhnm` (`correo_electronico`);

--
-- Indices de la tabla `detalle_pedido`
--
ALTER TABLE `detalle_pedido`
  ADD PRIMARY KEY (`id_detalle_pedido`),
  ADD KEY `FKoxtxes5am214b3ilqwonft0ki` (`pedido_id`),
  ADD KEY `FKjeypkdl7mu6dd15guf3f5rh77` (`id_producto`);

--
-- Indices de la tabla `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id_pedido`),
  ADD KEY `FKfo6gspfm7x1uvc4m1ts6qu5p5` (`id_cliente`);

--
-- Indices de la tabla `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id_producto`),
  ADD UNIQUE KEY `UK_alnpjby01hic0779ydhicvtix` (`nombre`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `client`
--
ALTER TABLE `client`
  MODIFY `id_cliente` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `detalle_pedido`
--
ALTER TABLE `detalle_pedido`
  MODIFY `id_detalle_pedido` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `orders`
--
ALTER TABLE `orders`
  MODIFY `id_pedido` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `product`
--
ALTER TABLE `product`
  MODIFY `id_producto` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalle_pedido`
--
ALTER TABLE `detalle_pedido`
  ADD CONSTRAINT `FKjeypkdl7mu6dd15guf3f5rh77` FOREIGN KEY (`id_producto`) REFERENCES `product` (`id_producto`),
  ADD CONSTRAINT `FKoxtxes5am214b3ilqwonft0ki` FOREIGN KEY (`pedido_id`) REFERENCES `orders` (`id_pedido`);

--
-- Filtros para la tabla `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `FKfo6gspfm7x1uvc4m1ts6qu5p5` FOREIGN KEY (`id_cliente`) REFERENCES `client` (`id_cliente`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
