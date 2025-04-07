CREATE TABLE equipos (
    id NUMBER(5) PRIMARY KEY,
    nombre VARCHAR2(50) NOT NULL,
    fecha_creacion DATE DEFAULT SYSDATE
);

-- Paso 1: Añadir la columna que actuará como clave foránea
ALTER TABLE empleados
ADD id_equipo NUMBER(5);

-- Paso 2: Crear la restricción de clave foránea
ALTER TABLE empleados
ADD CONSTRAINT fk_equipo
FOREIGN KEY (id_equipo) REFERENCES equipos(id);


INSERT INTO equipos (id, nombre) VALUES (1, 'Desarrollo Web');
INSERT INTO equipos  (id, nombre) VALUES (2, 'Analítica de Datos');

INSERT INTO equipos VALUES (3, 'Seguridad Informática', DATE '2024-10-03');
INSERT INTO equipos VALUES (5, 'Seguridad Informática3', '03/11/2023');

UPDATE empleados 
SET id_equipo = (select id from equipos where nombre='Analítica de Datos')
WHERE id NOT IN (4,6,8);

INSERT INTO empleados VALUES (1, 'Juan Pérez', 30, 3000.00, 1);
INSERT INTO empleados VALUES (2, 'Ana García', 28, 3500.00, 1);
INSERT INTO empleados VALUES (3, 'Carlos Gómez', 40, 5000.00, 2);
INSERT INTO empleados VALUES (4, 'Laura Torres', 25, 2800.00, 3);

Insert into EMPLEADOS (ID,NOMBRE,EDAD,SALARIO,DEPARTAMENTO_ID,FECHA_CONTRATACION,ID_EQUIPO) 
values ('17','Juan Pérez','30','3000','3',to_date('04/03/52','DD/MM/RRRR'),'2');

SELECT e.nombre AS empleado, e.salario, eq.nombre AS equipo
FROM empleados e
JOIN equipos eq ON e.id_equipo = eq.id;

SELECT COUNT(DISTINCT(NOMBRE)) FROM empleados;

SELECT eq.nombre AS equipo, COUNT(e.id) AS total_empleados
FROM empleados e
JOIN equipos eq ON e.id_equipo = eq.id
GROUP BY eq.nombre
ORDER BY total_empleados DESC;


SELECT e.nombre AS empleado, e.salario, eq.nombre AS equipo
FROM empleados e
JOIN equipos eq ON e.id_equipo = eq.id
WHERE e.salario = (
    SELECT MAX(e2.salario)
    FROM empleados e2
    WHERE e2.id_equipo = e.id_equipo
);

SELECT e.nombre AS empleado, e.salario, eq.nombre AS equipo
FROM empleados e , equipos eq 
WHERE e.id_equipo = eq.id AND
e.salario = (
    SELECT MAX(e2.salario)
    FROM empleados e2
    WHERE e2.id_equipo = e.id_equipo
);

SELECT e.nombre AS empleado, eq.nombre AS equipo, eq.fecha_creacion
FROM empleados e
JOIN equipos eq ON e.id_equipo = eq.id
WHERE eq.fecha_creacion < ADD_MONTHS(SYSDATE, -36);