create database cajero_2024;
use cajero_2024;
create table cuentas
(id_cuenta int not null primary key,
saldo double not null,
tipo_cuenta varchar(20) not null,
check (tipo_cuenta in ('AHORRO','CORRIENTE','JUVENIL', 'NOMINA'))
);
INSERT INTO CUENTAS VALUES(1000, 2000,'AHORRO');
INSERT INTO CUENTAS VALUES(2000, 12000,'CORRIENTE');
commit;
CREATE TABLE MOVIMIENTOS
(ID_MOVIMIENTO INT NOT NULL auto_increment PRIMARY KEY,
ID_CUENTA INT NOT NULL,
FECHA DATETIME,
CANTIDAD DOUBLE,
OPERACION VARCHAR(45),
FOREIGN KEY(ID_CUENTA) REFERENCES CUENTAS(ID_CUENTA)
);


INSERT INTO MOVIMIENTOS (ID_CUENTA, FECHA, CANTIDAD, OPERACION)
VALUES 
    (1000, '2024-11-12 10:00:00', 500.00, 'ingreso'),
    (1000, '2024-11-12 11:30:00', 200.00, 'extraccion'),
    (1000, '2024-11-12 14:15:00', 1000.00, 'ingreso'),
    (1000, '2024-11-12 16:00:00', 150.00, 'extraccion'),
    (1000, '2024-11-12 09:00:00', 300.00, 'ingreso'),
    (1000, '2024-11-12 12:00:00', 120.00, 'extraccion'),
    (1000, '2024-11-12 13:30:00', 700.00, 'ingreso'),
    (1000, '2024-11-12 15:00:00', 250.00, 'extraccion'),
    (1000, '2024-11-12 17:00:00', 600.00, 'ingreso'),
    (2000, '2024-11-12 18:30:00', 400.00, 'extraccion');
