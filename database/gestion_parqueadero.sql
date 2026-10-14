CREATE DATABASE IF NOT EXISTS gestion_parqueadero;
USE gestion_parqueadero;

-- 1. Tabla Clientes
CREATE TABLE clientes (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    documento VARCHAR(20) NOT NULL UNIQUE,
    telefono VARCHAR(15)
);

-- 2. Tabla Tipos de Vehículo
CREATE TABLE tipos_vehiculo (
    id_tipo INT AUTO_INCREMENT PRIMARY KEY,
    nombre_tipo VARCHAR(50) NOT NULL,
    tarifa_por_hora DECIMAL(10, 2) NOT NULL
);

-- 3. Tabla Celdas de Parqueadero
CREATE TABLE celdas (
    id_celda INT AUTO_INCREMENT PRIMARY KEY,
    numero_celda VARCHAR(10) NOT NULL UNIQUE,
    id_tipo INT NOT NULL,
    estado VARCHAR(20) DEFAULT 'Disponible',
    CONSTRAINT fk_celdas_tipos FOREIGN KEY (id_tipo) REFERENCES tipos_vehiculo(id_tipo) ON DELETE CASCADE
);

-- 4. Tabla Vehículos
CREATE TABLE vehiculos (
    placa VARCHAR(10) PRIMARY KEY,
    marca VARCHAR(50),
    modelo VARCHAR(50),
    color VARCHAR(30),
    id_cliente INT NOT NULL,
    id_tipo INT NOT NULL,
    CONSTRAINT fk_vehiculos_clientes FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente) ON DELETE CASCADE,
    CONSTRAINT fk_vehiculos_tipos FOREIGN KEY (id_tipo) REFERENCES tipos_vehiculo(id_tipo) ON DELETE CASCADE
);

-- 5. Tabla Registros de Entrada / Salida (Tickets)
CREATE TABLE registros_parqueadero (
    id_registro INT AUTO_INCREMENT PRIMARY KEY,
    placa VARCHAR(10) NOT NULL,
    id_celda INT NOT NULL,
    fecha_ingreso DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    fecha_salida DATETIME NULL,
    total_pagar DECIMAL(10, 2) NULL,
    estado VARCHAR(20) DEFAULT 'Activo',
    CONSTRAINT fk_registros_vehiculos FOREIGN KEY (placa) REFERENCES vehiculos(placa) ON DELETE CASCADE,
    CONSTRAINT fk_registros_celdas FOREIGN KEY (id_celda) REFERENCES celdas(id_celda) ON DELETE CASCADE
);

-- Datos iniciales de prueba
INSERT INTO clientes (nombre, documento, telefono) VALUES 
('Andrés Castro', '1018234567', '3001234567'),
('Isabela Gómez', '1019876543', '3107654321');

INSERT INTO tipos_vehiculo (nombre_tipo, tarifa_por_hora) VALUES 
('Automóvil', 4000.00),
('Motocicleta', 2000.00),
('Camioneta', 5500.00);

INSERT INTO celdas (numero_celda, id_tipo, estado) VALUES 
('A-01', 1, 'Disponible'),
('M-01', 2, 'Disponible'),
('C-01', 3, 'Disponible');

INSERT INTO vehiculos (placa, marca, modelo, color, id_cliente, id_tipo) VALUES 
('FZN200', 'Yamaha', 'FZ 2.0', 'Negro', 1, 2),
('RTR200', 'TVS', 'Apache RTR 200 4V', 'Rojo', 2, 2);
