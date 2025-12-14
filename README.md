# Sistema Bancario en Java (Swing + MySQL)

# Integrantes : Arias, Tana

---

## Descripción del Proyecto
Este proyecto consiste en el desarrollo de una aplicación de escritorio en Java utilizando Swing, que simula un sistema bancario básico con inicio de sesión y operaciones bancarias, conectado a una base de datos MySQL.

El sistema permite a los usuarios autenticarse y realizar operaciones como depósitos, retiros y transferencias, manteniendo siempre el saldo actualizado y mostrando un historial de transacciones.

---

## Capturas del Sistema

### Pantalla de Inicio de Sesión

<img width="670" height="419" alt="image" src="https://github.com/user-attachments/assets/6beb53c6-79d4-4ad9-85bd-9a43d5b8855b" />


---

### Ventana Principal – Operaciones Bancarias

<img width="1228" height="985" alt="image" src="https://github.com/user-attachments/assets/c07ecef5-7ba0-4cc5-9aa7-9d5542983f09" />


---

### Historial de Transacciones

<img width="306" height="814" alt="image" src="https://github.com/user-attachments/assets/75edef5b-1dc8-415b-a241-ada3c892f3d3" />


---

## Parte 1: Inicio de Sesión (Login)

### Formulario: Login_bancario

Funcionalidades:
- Campos de entrada:
  - Usuario (JTextField)
  - Contraseña (JPasswordField)
- Botón Ingresar
- Validación de credenciales desde la base de datos
- Verificación de usuario activo
- Control de intentos fallidos (máximo 3)
- Acceso al sistema solo con credenciales válidas

  <img width="482" height="368" alt="image" src="https://github.com/user-attachments/assets/33e0bf9b-8ead-4a20-ae64-7a6de4be4419" />

  <img width="479" height="362" alt="image" src="https://github.com/user-attachments/assets/883d8c61-9371-4fc8-8d99-1ce565d896b1" />


---

## Parte 2: Operaciones Bancarias

### Formulario: Banco

Funcionalidades:
- Visualización del nombre del cliente
- Visualización del saldo actual desde la base de datos
- Botones disponibles:
  - Depósito
  - Retiro
  - Transferencia
  - Salir

<img width="1084" height="77" alt="image" src="https://github.com/user-attachments/assets/b8f0dc88-7a16-4feb-af86-b075730ac677" />

---

### Depósito
- Solicita el valor a depositar mediante JOptionPane
- Suma el valor al saldo actual
- Actualiza el saldo en la base de datos
- Muestra mensaje de confirmación
- Registra la operación en el historial

<img width="344" height="157" alt="image" src="https://github.com/user-attachments/assets/7292bcce-4e52-46f8-938c-1d35a8cb3c9f" />

<img width="355" height="177" alt="image" src="https://github.com/user-attachments/assets/4dde073a-b212-424b-a3e9-665a645b391e" />

<img width="562" height="61" alt="image" src="https://github.com/user-attachments/assets/616a5c9d-46e1-41dc-8bcf-29d1172582bb" />

---

### Retiro
- Solicita el valor a retirar
- Verifica que el saldo sea suficiente
- Si el monto es mayor al saldo, muestra una advertencia
- Actualiza el saldo y el historial si la operación es válida

<img width="346" height="165" alt="image" src="https://github.com/user-attachments/assets/1e8e0f36-646d-40a7-8fb1-43bc8a3d7cce" />

<img width="345" height="170" alt="image" src="https://github.com/user-attachments/assets/2aeaed0a-9cf9-4561-8f75-87e10c28b258" />

<img width="574" height="60" alt="image" src="https://github.com/user-attachments/assets/ee79d48d-a7a0-45d3-bc53-b234b9905086" />

---

### Transferencia
- Solicita:
  - Nombre del destinatario
  - Monto a transferir
- Verifica que el monto no supere el saldo disponible
- Realiza la transferencia si es válida
- Muestra el mensaje:
  Transferencia exitosa a [Nombre] por $[Monto]

  <img width="343" height="158" alt="image" src="https://github.com/user-attachments/assets/303034d3-3a78-439e-b3a6-06d8ce8fd1d1" />

  <img width="324" height="158" alt="image" src="https://github.com/user-attachments/assets/c65192ce-e770-48f4-9e15-dca415ad4ca3" />

  <img width="374" height="163" alt="image" src="https://github.com/user-attachments/assets/398aeba4-3f27-4dca-a8b6-f67c989a306e" />

  <img width="353" height="45" alt="image" src="https://github.com/user-attachments/assets/9f9954e8-a11e-4a98-8442-7502eaea62a7" />

---

### Historial de Transacciones
- Cada operación se muestra en un JTextArea
- Permite visualizar los movimientos realizados por el usuario

  <img width="275" height="206" alt="image" src="https://github.com/user-attachments/assets/bcb3ae81-6088-475d-a1f0-9e8c2d78d527" />

---

### Salir
- Cierra completamente la aplicación
- Para volver a usar el sistema, el usuario debe iniciar sesión nuevamente

<img width="287" height="42" alt="image" src="https://github.com/user-attachments/assets/89eaf3a2-5f2b-43ad-a63b-0ea3fe78651f" />

---

## Base de Datos

### Nombre: DB_Banco

<img width="311" height="56" alt="image" src="https://github.com/user-attachments/assets/2760f506-b048-47ab-8c97-061863772b82" />

<img width="492" height="370" alt="image" src="https://github.com/user-attachments/assets/3c1632ca-cff7-47c7-a325-10be92fbb90b" />

<img width="621" height="348" alt="image" src="https://github.com/user-attachments/assets/05b155d9-d08a-4733-bee5-4bd51534a5d4" />

### Script SQL
```sql
CREATE DATABASE DB_Banco;
USE DB_Banco;

CREATE TABLE usuarios(
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario VARCHAR(50) UNIQUE,
    contraseña VARCHAR(100),
    nombre VARCHAR(100),
    activo BOOLEAN DEFAULT TRUE
);

CREATE TABLE cuentas(
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT,
    saldo DECIMAL(10,2),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);

INSERT INTO usuarios (usuario, contraseña, nombre, activo) VALUES
('emilia', '1234', 'Emilia Tana', true),
('juanp', 'abcd', 'Juan Pérez', true),
('mariaa', 'pass1', 'María Andrade', true),
('ariel', '5678', 'Ariel Arias', false),
('anag', 'ana2024', 'Ana Gómez', true);

INSERT INTO cuentas (usuario_id, saldo) VALUES
(1, 1000.00),
(2, 1500.50),
(3, 800.00),
(4, 1200.00),
(5, 2000.00);

