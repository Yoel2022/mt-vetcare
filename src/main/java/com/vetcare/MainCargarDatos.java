package com.vetcare;

import com.vetcare.model.Mascota;
import com.vetcare.model.Vacuna;
import com.vetcare.model.Turno;
import com.vetcare.model.Pago;
import com.vetcare.service.AlertaVacunaService;
import com.vetcare.service.TurnoService;
import com.vetcare.service.PagoService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainCargarDatos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TurnoService turnoService = new TurnoService();
        PagoService pagoService = new PagoService();
        AlertaVacunaService alertaService = new AlertaVacunaService();

        // Lista general para almacenar todas las mascotas registradas en el sistema
        List<Mascota> listaMascotas = new ArrayList<>();

        // Creamos una mascota por defecto y la agregamos a la lista
        Mascota mascotaActual = new Mascota("Firulais", "Canino", 2);
        listaMascotas.add(mascotaActual);
        
        int opcion = 0;

        do {
            System.out.println("\n========================================");
            System.out.println("   SISTEMA DE GESTIÓN VETERINARIA VETCARE   ");
            System.out.println("========================================");
            System.out.println(" 1. Registrar nueva Mascota");
            System.out.println(" 2. Evaluar Alerta de Vacunación (21 días)");
            System.out.println(" 3. Programar Turno de Quirófano");
            System.out.println(" 4. Listar Turnos en Agenda");
            System.out.println(" 5. Registrar Pago / Atención Detallada");
            System.out.println(" 6. Ver Recaudación Total");
            System.out.println(" 7. Buscar Mascota e Historial");
            System.out.println(" 0. Salir");
            System.out.print(" Seleccione una opción: ");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer
            } else {
                System.out.println("  Por favor, ingrese un número válido.");
                scanner.nextLine();
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese nombre de la mascota: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese especie (Canino/Felino/etc.): ");
                    String especie = scanner.nextLine();
                    System.out.print("Ingrese edad: ");
                    int edad = scanner.nextInt();
                    scanner.nextLine();

                    // Creamos la nueva mascota y la guardamos en la lista general
                    mascotaActual = new Mascota(nombre, especie, edad);
                    listaMascotas.add(mascotaActual);
                    
                    System.out.println("  ¡Mascota registrada y guardada con éxito: " + nombre + "!");
                    break;

                case 2:
                    System.out.print("Ingrese el nombre de la mascota para evaluar su alerta de vacunación: ");
                    String nombreAlerta = scanner.nextLine();
                    
                    Mascota mascotaAlerta = null;
                    for (Mascota m : listaMascotas) {
                        if (m.getNombre().equalsIgnoreCase(nombreAlerta)) {
                            mascotaAlerta = m;
                            break;
                        }
                    }

                    if (mascotaAlerta != null) {
                        if (mascotaAlerta.getListaVacunas().isEmpty()) {
                            // Simulamos una vacuna previa hace 25 días si no tiene ninguna
                            Vacuna dosisPrueba = new Vacuna("Antirrábica", 1, LocalDate.now().minusDays(25));
                            mascotaAlerta.registrarVacuna(dosisPrueba);
                            System.out.println(" (Se autogeneró una Dosis 1 aplicada hace 25 días para la prueba).");
                        }
                        alertaService.evaluarAlertaVacunacion(mascotaAlerta);
                    } else {
                        System.out.println(" No se encontró ninguna mascota registrada con el nombre: " + nombreAlerta);
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el motivo de la cirugía (ej. Castración): ");
                    String motivo = scanner.nextLine();
                    LocalDateTime fechaCirugia = LocalDateTime.now().plusDays(3).withHour(10).withMinute(30);
                    
                    Turno nuevoTurno = new Turno(mascotaActual, fechaCirugia, motivo);
                    turnoService.programarTurno(nuevoTurno);
                    break;

                case 4:
                    turnoService.listarTurnos();
                    break;

                case 5:
                    System.out.print("Ingrese valor de la consulta médica ($): ");
                    double consulta = scanner.nextDouble();
                    System.out.print("Ingrese costo de la vacuna ($): ");
                    double vacunaCosto = scanner.nextDouble();
                    System.out.print("Ingrese costo de insumos/medicamentos ($): ");
                    double insumos = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Detalle de los insumos (ej. Jeringa, antibiótico): ");
                    String detalle = scanner.nextLine();
                    System.out.print("Método de pago (Efectivo / Transferencia / Tarjeta): ");
                    String metodo = scanner.nextLine();

                    Pago pago = new Pago(mascotaActual, consulta, vacunaCosto, insumos, detalle, metodo);
                    pagoService.registrarPago(pago);
                    break;

                case 6:
                    pagoService.calcularRecaudacionTotal();
                    break;

                case 7: // Buscar mascota por nombre e historial
                    System.out.print("Ingrese el nombre de la mascota a buscar: ");
                    String nombreBuscado = scanner.nextLine();
                    
                    Mascota mascotaEncontrada = null;
                    for (Mascota m : listaMascotas) {
                        if (m.getNombre().equalsIgnoreCase(nombreBuscado)) {
                            mascotaEncontrada = m;
                            break;
                        }
                    }

                    if (mascotaEncontrada != null) {
                        System.out.println("\n--- ¡MASCOTA ENCONTRADA! ---");
                        System.out.println("Nombre: " + mascotaEncontrada.getNombre());
                        System.out.println("Especie: " + mascotaEncontrada.getEspecie());
                        System.out.println("Edad: " + mascotaEncontrada.getEdad() + " años");
                        System.out.println("Etapa de vida: " + mascotaEncontrada.getEtapaDeVida());
                        
                        System.out.println("\nHistorial de Vacunas:");
                        if (mascotaEncontrada.getListaVacunas().isEmpty()) {
                            System.out.println(" - No registra vacunas aplicadas.");
                        } else {
                            for (Vacuna v : mascotaEncontrada.getListaVacunas()) {
                                v.mostrarVacuna();
                            }
                        }
                        // La establecemos como la mascota actual para las siguientes operaciones si se desea
                        mascotaActual = mascotaEncontrada;
                        System.out.println("\n(Ahora está seleccionada como mascota actual)");
                    } else {
                        System.out.println(" No se encontró ninguna mascota registrada con el nombre: " + nombreBuscado);
                    }
                    break;

                case 0:
                    System.out.println(" Saliendo del sistema VetCare. ¡Hasta luego!");
                    break;

                default:
                    System.out.println("  Opción no válida. Intente nuevamente.");
            }

        } while (opcion != 0);

        scanner.close();
    }
}