# 🐾 VetCare - Sistema Integral de Gestión Veterinaria

Proyecto desarrollado para la materia **Metodología y Testing** de la **Tecnicatura Universitaria en Desarrollo de Software (ITU - UNCUYO)**. 

Objetivo del Proyecto:
Desarrollar un sistema de gestión veterinaria en Java aplicando Programación Orientada a Objetos (POO) y una arquitectura modular. Busca automatizar procesos clave —como vacunación, turnos y finanzas a través de una consola interactiva, logrando un código limpio, estructurado y listo para testing.

## 🚀 Funcionalidades Principales

* **Gestión de Pacientes:** Registro de mascotas en listas (`ArrayList`) con búsqueda rápida de historiales por nombre.
* **Control de Vacunación (21 días):** Cálculo automático de días restantes o días de retraso para el refuerzo de vacunas.
* **Agenda de Quirófano:** Programación y listado de turnos quirúrgicos con formato claro de fecha y hora.
* **Módulo Financiero:** Registro de cobros (Efectivo, Transferencia, Tarjeta) y cálculo de la recaudación total de la clínica.
* **Menú por Consola:** Interfaz interactiva (`MainCargarDatos`) para operar todo el sistema de forma sencilla.

* ## 🏗️ Arquitectura del Proyecto

El código está organizado modularmente bajo el principio de separación de responsabilidades:

* **`com.vetcare.model`**: Entidades del dominio de negocio (`Mascota`, `Vacuna`, `Turno`, `Pago`).
* **`com.vetcare.service`**: Lógica de negocio y servicios operativos (`AlertaVacunaService`, `TurnoService`, `PagoService`).
* **`com.vetcare`**: Clase principal de ejecución y menú interactivo (`MainCargarDatos.java`).
* **`src/test/java`**: Pruebas unitarias automatizadas con JUnit 5.

* ## 🛠️ Tecnologías Utilizadas

* **Java** (Programación Orientada a Objetos y colecciones dinámicas).
* **API `java.time**` (`LocalDate`, `LocalDateTime`, `DateTimeFormatter`, `ChronoUnit`) para el manejo preciso de fechas y periodos.
* **JUnit 5** para pruebas unitarias automatizadas.
* **Visual Studio Code** como entorno de desarrollo.

* ## ▶️ Instrucciones de Ejecución

1. Abre el proyecto en tu entorno de desarrollo (Visual Studio Code).
2. Asegúrate de tener instalado el **JDK (Java Development Kit)**.
3. Ubica la clase principal en:
`src/main/java/com/vetcare/MainCargarDatos.java`
4. Ejecuta el archivo e interactúa con el menú en la consola.
