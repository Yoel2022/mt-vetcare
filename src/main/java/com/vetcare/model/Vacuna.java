package com.vetcare.model;

import java.time.LocalDate;

public class Vacuna {
    private String nombreVacuna;     // Ej: "Séxtuple", "Antirrábica"
    private int numeroDosis;         // Ej: 1, 2, 3, 4 o 5
    private LocalDate fechaAplicacion; // Fecha REAL de aplicación

    // Constructor completo
    public Vacuna(String nombreVacuna, int numeroDosis, LocalDate fechaAplicacion) {
        this.nombreVacuna = nombreVacuna;
        this.numeroDosis = numeroDosis;
        this.fechaAplicacion = fechaAplicacion;
    }

    // Getters y Setters
    public String getNombreVacuna() {
        return nombreVacuna;
    }

    public void setNombreVacuna(String nombreVacuna) {
        this.nombreVacuna = nombreVacuna;
    }

    public int getNumeroDosis() {
        return numeroDosis;
    }

    public void setNumeroDosis(int numeroDosis) {
        this.numeroDosis = numeroDosis;
    }

    public LocalDate getFechaAplicacion() {
        return fechaAplicacion;
    }

    public void setFechaAplicacion(LocalDate fechaAplicacion) {
        this.fechaAplicacion = fechaAplicacion;
    }

    // Método para imprimir la dosis de forma clara
    public void mostrarVacuna() {
        System.out.println("   * Vacuna: " + nombreVacuna + " (Dosis N° " + numeroDosis + "/5) - Aplicada el: " + fechaAplicacion);
    }
}