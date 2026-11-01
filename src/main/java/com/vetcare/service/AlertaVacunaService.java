package com.vetcare.service;

import com.vetcare.model.Mascota;
import com.vetcare.model.Vacuna;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class AlertaVacunaService {

    public void evaluarAlertaVacunacion(Mascota mascota) {
        System.out.println("========================================");
        System.out.println(" PACIENTE: " + mascota.getNombre());
        System.out.println("========================================");

        if (mascota.getListaVacunas() == null || mascota.getListaVacunas().isEmpty()) {
            System.out.println(" El paciente no registra vacunas aplicadas.");
            System.out.println("========================================");
            return;
        }

        // Tomamos la última vacuna aplicada
        Vacuna ultimaVacuna = mascota.getListaVacunas().get(mascota.getListaVacunas().size() - 1);
        LocalDate fechaAplicacion = ultimaVacuna.getFechaAplicacion();
        LocalDate hoy = LocalDate.now();

        // Calculamos los días transcurridos desde la última dosis
        long diasTranscurridos = ChronoUnit.DAYS.between(fechaAplicacion, hoy);

        System.out.println(" Última vacuna: Dosis " + ultimaVacuna.getNumeroDosis() + " (" + ultimaVacuna.getNombreVacuna() + ")");
        System.out.println(" Días transcurridos: " + diasTranscurridos + " días.");

        // Regla estricta de los 21 días con cálculo de retraso
        if (diasTranscurridos >= 21) {
            long diasDeRetraso = diasTranscurridos - 21;
            if (diasDeRetraso == 0) {
                System.out.println(" ¡ALERTA! Hoy se cumple exactamente el plazo de los 21 días para la siguiente dosis.");
            } else {
                System.out.println(" ¡ATENCIÓN! La fecha prevista de vacunación pasó hace " + diasDeRetraso + " días (Plazo de 21 días superado).");
            }
        } else {
            long diasFaltantes = 21 - diasTranscurridos;
            System.out.println(" FALTAN " + diasFaltantes + " días para cumplir el protocolo de los 21 días.");
        }
        System.out.println("========================================");
    }
}