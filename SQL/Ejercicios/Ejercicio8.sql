--Ejercicio 8: Relación Muchos a Muchos (M:M) - Empleados y Certificaciones
--Un empleado puede obtener varias certificaciones, y una certificación puede ser obtenida por varios empleados y cada cada certificación de cada empleado es válida hasta una fecha determinada. Por defecto el valor de la fecha será de 1 año más a partir de la fecha en la que se inserta.

--Tabla certificaciones con id, nombre y descripción


CREATE TABLE certificaciones (
    id_certificacion NUMBER(5) PRIMARY KEY,
    nombre VARCHAR2(50) NOT NULL
);

CREATE TABLE empleados_certificaciones (
    id_empleado NUMBER(5),
    id_certificacion NUMBER(5),
    fecha_obtencion DATE DEFAULT SYSDATE,
    PRIMARY KEY (id_empleado, id_certificacion),
    FOREIGN KEY (id_empleado) REFERENCES empleados(id_empleado),
    FOREIGN KEY (id_certificacion) REFERENCES certificaciones(id_certificacion)
);


INSERT INTO certificaciones VALUES (1, 'Oracle Certified SQL Expert');
INSERT INTO certificaciones VALUES (2, 'AWS Cloud Practitioner');
INSERT INTO certificaciones VALUES (3, 'Machine Learning con Python');


INSERT INTO empleados_certificaciones VALUES (1, 1, TO_DATE('2023-05-10', 'YYYY-MM-DD'));
INSERT INTO empleados_certificaciones VALUES (1, 2, TO_DATE('2023-06-15', 'YYYY-MM-DD'));
INSERT INTO empleados_certificaciones VALUES (2, 3, TO_DATE('2023-07-20', 'YYYY-MM-DD'));
INSERT INTO empleados_certificaciones VALUES (3, 1, TO_DATE('2023-08-05', 'YYYY-MM-DD'));
INSERT INTO empleados_certificaciones VALUES (3, 2, TO_DATE('2023-09-10', 'YYYY-MM-DD'));


--Consulta para ver qué certificaciones ha obtenido cada empleado
SELECT e.nombre AS empleado, c.nombre AS certificacion, ec.fecha_obtencion
FROM empleados_certificaciones ec
JOIN empleados e ON ec.id_empleado = e.id_empleado
JOIN certificaciones c ON ec.id_certificacion = c.id_certificacion
ORDER BY e.nombre;

--consulta SQL que muestre el nombre del empleado, el nombre de la certificación y la fecha en la que la obtuvo.
SELECT e.nombre AS empleado, c.nombre AS certificacion, ec.fecha_obtencion
FROM empleados_certificaciones ec
JOIN empleados e ON ec.id_empleado = e.id_empleado
JOIN certificaciones c ON ec.id_certificacion = c.id_certificacion
ORDER BY e.nombre;

--consulta SQL que muestre el nombre del empleado y el número total de certificaciones que ha obtenido.
SELECT e.nombre AS empleado, COUNT(ec.id_certificacion) AS total_certificaciones
FROM empleados_certificaciones ec
JOIN empleados e ON ec.id_empleado = e.id_empleado
GROUP BY e.nombre
ORDER BY total_certificaciones DESC;

--Escribe una consulta SQL que muestre el nombre de la certificación y la cantidad de empleados que la han obtenido, pero solo si más de un empleado la ha conseguido.
SELECT c.nombre AS certificacion, COUNT(ec.id_empleado) AS cantidad_empleados
FROM empleados_certificaciones ec
JOIN certificaciones c ON ec.id_certificacion = c.id_certificacion
GROUP BY c.nombre
HAVING COUNT(ec.id_empleado) > 1
ORDER BY cantidad_empleados DESC;


--Realiza una consulta SQL que muestre el nombre del empleado, su usuario de acceso, y el nombre del equipo al que pertenece.
SELECT e.nombre AS empleado, c.usuario, eq.nombre AS equipo
FROM empleados e
JOIN credenciales_empleados c ON e.id_empleado = c.empleado_id
JOIN equipos eq ON e.id_equipo = eq.id_equipo
ORDER BY eq.nombre;


--Contar cuántos empleados hay en cada equipo y cuántos tienen credenciales asignadas
SELECT eq.nombre AS equipo, 
       COUNT(e.id_empleado) AS total_empleados,
       COUNT(c.empleado_id) AS empleados_con_credenciales
FROM empleados e
JOIN equipos eq ON e.id_equipo = eq.id_equipo
LEFT JOIN credenciales_empleados c ON e.id_empleado = c.empleado_id
GROUP BY eq.nombre
ORDER BY total_empleados DESC;


--Listar empleados con sus certificaciones y credenciales
SELECT e.nombre AS empleado, c.usuario, cert.nombre AS certificacion, ec.fecha_obtencion
FROM empleados e
JOIN credenciales_empleados c ON e.id_empleado = c.empleado_id
JOIN empleados_certificaciones ec ON e.id_empleado = ec.id_empleado
JOIN certificaciones cert ON ec.id_certificacion = cert.id_certificacion
ORDER BY e.nombre, ec.fecha_obtencion;


--Muestra el nombre del equipo y el número total de certificaciones obtenidas por sus empleados.
SELECT eq.nombre AS equipo, COUNT(ec.id_certificacion) AS total_certificaciones
FROM empleados e
JOIN equipos eq ON e.id_equipo = eq.id_equipo
JOIN empleados_certificaciones ec ON e.id_empleado = ec.id_empleado
GROUP BY eq.nombre
ORDER BY total_certificaciones DESC;

