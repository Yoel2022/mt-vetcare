package com.vetcare.model;

import java.time.LocalDate;

public class Pago {
    private Mascota mascota;
    private double valorConsulta;
    private double costoVacunas;
    private double costoMedicamentosInsumos; // Ej: antifebriles, jeringas, analgésicos
    private String detalleMedicamentos;    // Descripción de los fármacos aplicados
    private LocalDate fechaPago;
    private String metodoPago;             // "Efectivo", "Tarjeta", "Transferencia"

    public Pago(Mascota mascota, double valorConsulta, double costoVacunas, 
                double costoMedicamentosInsumos, String detalleMedicamentos, String metodoPago) {
        this.mascota = mascota;
        this.valorConsulta = valorConsulta;
        this.costoVacunas = costoVacunas;
        this.costoMedicamentosInsumos = costoMedicamentosInsumos;
        this.detalleMedicamentos = detalleMedicamentos;
        this.fechaPago = LocalDate.now();
        this.metodoPago = metodoPago;
    }

    // Método para calcular el total automáticamente
    public double calcularTotal() {
        return valorConsulta + costoVacunas + costoMedicamentosInsumos;
    }

    // Getters
    public Mascota getMascota() {
        return mascota;
    }

    public double getMontoTotal() {
        return calcularTotal();
    }

    // Método para mostrar el ticket detallado en consola
    public void mostrarComprobante() {
        System.out.println("========================================");
        System.out.println("         TICKET DE PAGO VETCARE         ");
        System.out.println("========================================");
        System.out.println(" Fecha: " + fechaPago);
        System.out.println(" Paciente: " + mascota.getNombreMascota());
        System.out.println("----------------------------------------");
        System.out.println(" > Valor de la Consulta:        $" + valorConsulta);
        System.out.println(" > Vacunas aplicadas:           $" + costoVacunas);
        System.out.println(" > Medicamentos e Insumos:      $" + costoMedicamentosInsumos);
        if (detalleMedicamentos != null && !detalleMedicamentos.isEmpty()) {
            System.out.println("   (Detalle: " + detalleMedicamentos + ")");
        }
        System.out.println("----------------------------------------");
        System.out.println(" TOTAL A PAGAR:                 $" + calcularTotal());
        System.out.println(" Método de Pago:                " + metodoPago);
        System.out.println("========================================");
    }
}