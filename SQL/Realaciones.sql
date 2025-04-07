CREATE TABLE clientes (
    id NUMBER(5) PRIMARY KEY,
    nombre VARCHAR2(50) NOT NULL
);

CREATE TABLE clientes_detalles (
    id NUMBER(5) PRIMARY KEY,
    direccion VARCHAR2(100),
    telefono VARCHAR2(20),
    cliente_id NUMBER(5) UNIQUE, 
    CONSTRAINT fk_cliente FOREIGN KEY (cliente_id) REFERENCES clientes (id)
);

INSERT INTO clientes VALUES (1, 'Juan Pérez');
INSERT INTO clientes VALUES (2, 'Ana García');
INSERT INTO clientes_detalles VALUES (1, 'Calle Mayor 123', '654321987', 1);
INSERT INTO clientes_detalles VALUES (2, 'Avenida Central 45', '678905432', 2);
INSERT INTO clientes_detalles VALUES (3, 'Avenida Central 45', '678905432', 2);

SELECT c.id, c.nombre, d.direccion, d.telefono
FROM clientes c
JOIN clientes_detalles d ON c.id = d.cliente_id;

