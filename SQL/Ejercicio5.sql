--1.	Muestra el nombre de los empleados en mayúsculas.
SELECT UPPER(NOMBRE) AS NOMBRE_MAYS FROM EMPLEADOS;

--2.	Muestra el id, el nombre y la cantidad de caracteres en el nombre del empleado.
SELECT ID, NOMBRE, LENGTH(NOMBRE) AS TOTAL_CARACTERES FROM EMPLEADOS;

--3.	Muestra el id, el nombre y los primeros 3 caracteres del nombre.
SELECT ID, NOMBRE, SUBSTR(NOMBRE,1,3) AS PRIM_CARAC FROM EMPLEADOS;

--4.	Muestra el id, el nombre, el salario y su versión redondeada y truncada a 2 decimales.
SELECT ID, NOMBRE, SALARIO, ROUND(SALARIO,1), TRUNC(SALARIO,1) FROM EMPLEADOS;

--5.	Muestra el nombre, la fecha_contratacion y el número de meses trabajados hasta la fecha actual.
SELECT NOMBRE, FECHA_CONTRATACION, MONTHS_BETWEEN(SYSDATE,FECHA_CONTRATACION) from EMPLEADOS;
SELECT NOMBRE, FECHA_CONTRATACION, (SYSDATE-FECHA_CONTRATACION)/30 from EMPLEADOS;

--6.	Muestra el nombre, la fecha_contratacion y la fecha del próximo lunes después de su contratación.
SELECT NOMBRE, FECHA_CONTRATACION, NEXT_DAY(FECHA_CONTRATACION,'Lunes') from EMPLEADOS;

--7.	Muestra el salario total, salario mínimo, salario máximo y salario promedio de todos los empleados.
SELECT SUM(SALARIO) as SUMATORIO, MIN(SALARIO) AS MINIMO, MAX(SALARIO) AS MAXIMO, 
ROUND(AVG(SALARIO),2) AS MEDIA 
FROM empleados;

--8.	Lista los empleados que han trabajado más de 3 años desde su fecha de contratación.
SELECT NOMBRE , EDAD, FECHA_CONTRATACION
FROM EMPLEADOS
WHERE MONTHS_BETWEEN(SYSDATE,FECHA_CONTRATACION)>=(12*2) ;

--9.	Muestra el nombre, salario y una columna llamada nivel_salarial con las siguientes clasificaciones:
--"Bajo" si el salario es menor a 3000.
--"Medio" si el salario está entre 3000 y 4500.
--"Alto" si el salario es mayor a 4500.
SELECT NOMBRE, SALARIO, 
        CASE 
            WHEN SALARIO<3000 THEN  'Bajo'
            WHEN SALARIO>=4500 THEN  'Alto'
            ELSE  'Medio'
        END AS nivel_salarial
FROM empleados;

--10.	Muestra el número de empleados por cada departamento_id y el salario promedio en cada departamento, 
--pero solo si hay al menos 2 empleados en ese departamento.
SELECT DEPARTAMENTO_ID, COUNT(NOMBRE) as TOTAL_EMPLEADOS, 
ROUND(AVG(SALARIO),2) AS SALARIO_PROMEDIO 
FROM empleados
GROUP BY DEPARTAMENTO_ID
HAVING COUNT(NOMBRE)>=2;
