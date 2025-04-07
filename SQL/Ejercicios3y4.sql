DROP TABLE EMPLEADOS;

CREATE TABLE EMPLEADOS (
    ID NUMBER(5) PRIMARY KEY,
    NOMBRE VARCHAR2(50) NOT NULL,
    EDAD NUMBER(3),
    SALARIO NUMBER(10,2) CHECK (SALARIO>0),
    ID_DEPARTAMENTO NUMBER(3),
    FECHA_CONTRATACION DATE DEFAULT SYSDATE
);
ALTER TABLE EMPLEADOS RENAME CONSTRAINT SYS_C008490 TO PK_EMPLEADO;

CREATE TABLE empleados (
    id NUMBER(5),
    nombre VARCHAR2(50) ,
    edad NUMBER(3),
    salario NUMBER(10,2),
    departamento_id NUMBER(3),
    fecha_contratacion DATE DEFAULT SYSDATE,
    CONSTRAINT pk_empleados PRIMARY KEY (id),
    CONSTRAINT chk_salario CHECK (salario > 0),
    CONSTRAINT notnull_nombre CHECK (nombre is not null)
);

INSERT INTO EMPLEADOS (ID,NOMBRE,edad,salario,departamento_id) VALUES(10, 'Juan Pérez',30,3000, 3);
--Agrega tres empleados más con los siguientes datos:
--	id: 2, nombre: "Ana García", edad: 28, salario: 3200.00, departamento_id: 1
--	id: 3, nombre: "Carlos Gómez", edad: 40, salario: 5000.00, departamento_id: 2
--	id: 4, nombre: "Laura Torres", edad: 25, salario: 2800.00, departamento_id: 3
INSERT ALL
    INTO empleados (id, nombre, edad, salario, departamento_id) VALUES (7, 'Ana García', 28, 3200.00, 1)
    INTO empleados (id, nombre, edad, salario, departamento_id) VALUES (8, 'Carlos Gómez', 40, 5000.00, 1)
    INTO empleados (id, nombre, edad, salario, departamento_id) VALUES (9, 'Laura Torres', 25, 2800.00, 2)
SELECT * FROM DUAL;

--Actualizar el salario de un empleado
UPDATE EMPLEADOS SET SALARIO = SALARIO*1.1 WHERE nombre='Juan Pérez';
--Actualizar la edad y el salario de múltiples empleados
UPDATE EMPLEADOS SET EDAD = EDAD+1;
UPDATE EMPLEADOS SET SALARIO = SALARIO*1.05 WHERE DEPARTAMENTO_ID = 1;
--
DELETE FROM EMPLEADOS WHERE ID=5;
--Eliminar empleados con salario menor a 3000
DELETE FROM empleados WHERE salario < 3000.00;
--Consultar todos los empleados con SELECT
SELECT ID, NOMBRE, EDAD, SALARIO, DEPARTAMENTO_ID, FECHA_CONTRATACION FROM EMPLEADOS;

-- Consultar empleados con salario superior a 4000
SELECT ID, NOMBRE, EDAD, SALARIO, 
        DEPARTAMENTO_ID, FECHA_CONTRATACION 
FROM EMPLEADOS 
WHERE SALARIO>4000;

--Obtener los empleados con el salario más alto en cada departamento
SELECT MAX(SALARIO) AS MAX_SALARIO,  DEPARTAMENTO_ID 
FROM EMPLEADOS 
GROUP BY DEPARTAMENTO_ID

SELECT MAX(SALARIO) AS MAX_SALARIO,  DEPARTAMENTO_ID 
FROM EMPLEADOS 
GROUP BY DEPARTAMENTO_ID
ORDER BY DEPARTAMENTO_ID, MAX_SALARIO;


SELECT NOMBRE, SALARIO, DEPARTAMENTO_ID
FROM EMPLEADOS
ORDER BY DEPARTAMENTO_ID, SALARIO DESC;

SELECT NOMBRE, e.SALARIO, e.DEPARTAMENTO_ID
FROM EMPLEADOS e
WHERE e.SALARIO = (select MAX(SALARIO) FROM EMPLEADOS  WHERE departamento_id = e.departamento_id );


select MAX(SALARIO) FROM EMPLEADOS;

--Listar los departamentos con al menos 2 empleados y calcular el salario total y promedio
SELECT DEPARTAMENTO_ID, COUNT(NOMBRE) as TOTAL_EMPLEADOS, 
        SUM(SALARIO) AS TOTAL_SALARIO, AVG(SALARIO) AS MEDIA_SALARIO
FROM EMPLEADOS
GROUP BY (DEPARTAMENTO_ID)
HAVING COUNT (NOMBRE)>=2;




