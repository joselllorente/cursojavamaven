CREATE TABLE credenciales_empleados (
    id NUMBER(5) PRIMARY KEY,
    usuario VARCHAR2(15) UNIQUE NOT NULL,
    contrasena VARCHAR2(15) NOT NULL,
    empleado_id NUMBER(5) UNIQUE, 
    CONSTRAINT fk_empleado_credencial FOREIGN KEY (empleado_id) REFERENCES empleados(id)
);

--INSERTAR datos de credenciales para los empleados existentes
INSERT INTO credenciales_empleados VALUES (101, 'empleado1','password1',3);
INSERT INTO credenciales_empleados VALUES (102, 'empleado2','password2',4);
INSERT INTO credenciales_empleados VALUES (103, 'empleado3','password2',6);
INSERT INTO credenciales_empleados VALUES (104, 'empleado4','password3',8);
INSERT INTO credenciales_empleados VALUES (105, 'empleado5','password5',7);
INSERT INTO credenciales_empleados (ID,usuario, contrasena) VALUES (106, 'empleado6','password5');
INSERT INTO credenciales_empleados (ID,usuario, contrasena) VALUES (107, 'empleado7','password5');

-- Obtener todos los empleados con sus credenciales
SELECT e.id, e.nombre, e.edad, c.usuario
FROM empleados e, credenciales_empleados c
WHERE e.id = c.empleado_id;

SELECT e.id, e.nombre, e.edad, c.usuario
FROM empleados e  JOIN credenciales_empleados c ON e.id = c.empleado_id;

SELECT e.id, e.nombre, e.edad, c.usuario
FROM empleados e LEFT JOIN credenciales_empleados c ON e.id = c.empleado_id;

SELECT e.id, e.nombre, e.edad, c.usuario
FROM empleados e FULL OUTER JOIN credenciales_empleados c ON e.id = c.empleado_id;

SELECT e.id, e.nombre, e.edad, c.usuario
FROM empleados e FULL OUTER JOIN credenciales_empleados c ON e.id = c.empleado_id
WHERE e.id IS NULL or c.empleado_id IS NULL;

--Obtener todos los nombres de usuario de los empleados del departamento 1
SELECT c.usuario
FROM empleados e  JOIN credenciales_empleados c ON e.id = c.empleado_id
WHERE e.departamento_id=1;

--Modificar la contraseña de todos los usuarios del departamento 2 a un valor por defecto
UPDATE credenciales_empleados
SET contrasena = DEFAULT
WHERE empleado_id IN (
    SELECT e.id FROM empleados e WHERE e.departamento_id = 1
);
