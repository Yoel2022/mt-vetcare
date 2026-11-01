package com.vetcare.model;

import java.time.LocalDateTime;

public class Turno {
    private Mascota mascota;
    private LocalDateTime fechaHora;
    private String motivo;

    // Constructor
    public Turno(Mascota mascota, LocalDateTime fechaHora, String motivo) {
        this.mascota = mascota;
        this.fechaHora = fechaHora;
        this.motivo = motivo;
    }

    // Getters y Setters
    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}