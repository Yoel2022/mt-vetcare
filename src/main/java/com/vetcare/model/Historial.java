package com.vetcare.model;

import java.time.LocalDate;

public class Historial {
    private LocalDate fecha;
    private String motivo;
    private String observaciones;

    // Constructor para registrar una visita
    public Historial(LocalDate fecha, String motivo, String observaciones) {
        this.fecha = fecha;
        this.motivo = motivo;
        this.observaciones = observaciones;
    }

    // Getters y Setters
    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    // Método para imprimir en consola de forma legible el registro clínico
    public void mostrarRegistro() {
        System.out.println("   * [" + fecha + "] Motivo: " + motivo + " | Obs: " + observaciones);
    }
}
