# 🐾 VetCare - Sistema Integral de Gestión Veterinaria

Proyecto desarrollado para la materia **Metodología y Testing** de la **Tecnicatura Universitaria en Desarrollo de Software (ITU - UNCUYO)**. 

Objetivo del Proyecto:
Desarrollar un sistema de gestión veterinaria en Java aplicando Programación Orientada a Objetos (POO) y una arquitectura modular. Busca automatizar procesos clave —como vacunación, turnos y finanzas a través de una consola interactiva, logrando un código limpio, estructurado y listo para testing.

##  Equipo de Trabajo y Roles Scrum

| Nombre del Integrante | Rol en Scrum | Responsabilidades Principales |
| :--- | :--- | :--- |
| **Renzo Gonzalez** | **Scrum Master & Dev Lead** | Gestión del proceso ágil (Trello), arquitectura de software y desarrollo core. |
| **Joel Aricoma** | **Product Owner** | Definición y priorización del Backlog, redacción de Historias de Usuario. |
| **Jaime Ignacio** | **QA / Test Automation Lead** | Implementación y ejecución de la suite de pruebas unitarias automatizadas. |
| **Joaquin Rinaldoni** | **Documentation & UX Lead** | Redacción de la matriz formal de pruebas y documentación general del proyecto. |

---
<img width="1919" height="797" alt="Captura de pantalla 2026-10-30 181454" src="https://github.com/user-attachments/assets/b6523475-8143-436a-b68d-ce5871117327" />
<img width="1919" height="797" alt="Captura de pantalla 2026-10-30 182010" src="https://github.com/user-attachments/assets/a74ded54-af9c-4b71-bbdd-966d5cc8e8ca" />
<img width="1919" height="801" alt="Captura de pantalla 2026-10-30 182322" src="https://github.com/user-attachments/assets/98504b81-addd-498e-89d7-3feb96a7d7a9" />

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
