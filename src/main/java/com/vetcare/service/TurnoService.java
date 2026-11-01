package com.vetcare.service;

import com.vetcare.model.Turno;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TurnoService {
    private List<Turno> agendaTurnos = new ArrayList<>();

    public void programarTurno(Turno turno) {
        agendaTurnos.add(turno);
        System.out.println("---- * Turno programado con éxito para " + turno.getMascota().getNombre());
    }

    // Método getter necesario para que las pruebas unitarias puedan verificar la agenda
    public List<Turno> getAgendaTurnos() {
        return agendaTurnos;
    }

    public void listarTurnos() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("==================================================");
        System.out.println("------- AGENDA DE QUIRÓFANO VETCARE -------");
        System.out.println("==================================================");
        if (agendaTurnos.isEmpty()) {
            System.out.println("No hay turnos programados.");
        } else {
            for (Turno t : agendaTurnos) {
                String fechaFormateada = t.getFechaHora().format(formato);
                System.out.println(" - Paciente: " + t.getMascota().getNombre() +
                                   " | Fecha: " + fechaFormateada + 
                                   " | Motivo: " + t.getMotivo());
            }
        }
        System.out.println("==================================================");
    }
}