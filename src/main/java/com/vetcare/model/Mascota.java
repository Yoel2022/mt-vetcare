package com.vetcare.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Mascota {
    private String nombre;
    private String especie;
    private LocalDate fechaNacimiento;
    private List<Vacuna> vacunas;

    // 1. Constructor: Recibe la fecha de nacimiento directa (LocalDate)
    public Mascota(String nombre, String especie, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.especie = especie;
        this.fechaNacimiento = fechaNacimiento;
        this.vacunas = new ArrayList<>();
    }

    // 2. Constructor: Recibe la edad en años (int)
    public Mascota(String nombre, String especie, int edad) {
        this.nombre = nombre;
        this.especie = especie;
        this.fechaNacimiento = LocalDate.now().minusYears(edad);
        this.vacunas = new ArrayList<>();
    }

    // 3. NUEVO Constructor: Recibe edad en Años y Meses (ideal para cachorros o mayor precisión)
    public Mascota(String nombre, String especie, int anios, int meses) {
        this.nombre = nombre;
        this.especie = especie;
        this.fechaNacimiento = LocalDate.now().minusYears(anios).minusMonths(meses);
        this.vacunas = new ArrayList<>();
    }

    // --- CÁLCULO DE ETAPAS DE VIDA Y PACIENTE SENIOR ---
    public String getEtapaDeVida() {
        if (fechaNacimiento == null) {
            return "Desconocida";
        }
        
        int anios = Period.between(fechaNacimiento, LocalDate.now()).getYears();
        
        if (anios < 1) {
            return "Cachorro";
        } else if (anios < 3) {
            return "Joven";
        } else if (anios < 7) {
            return "Adulto";
        } else {
            return "Senior";
        }
    }

    public boolean esSenior() {
        return "Senior".equals(getEtapaDeVida());
    }

    // --- MÉTODOS DE VACUNAS ---
    public void agregarVacuna(Vacuna vacuna) {
        this.vacunas.add(vacuna);
    }

    public void registrarVacuna(Vacuna vacuna) {
        this.agregarVacuna(vacuna);
    }

    public List<Vacuna> getVacunas() {
        return vacunas;
    }

    // Alias requerido por AlertaVacunaService.java
    public List<Vacuna> getListaVacunas() {
        return this.vacunas;
    }

    public void setVacunas(List<Vacuna> vacunas) {
        this.vacunas = vacunas;
    }

    // --- GETTERS Y SETTERS ---
    public String getNombre() {
        return nombre;
    }

    // Alias requerido por Pago.java
    public String getNombreMascota() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    // Método getEdad() opcional si alguna prueba lo requiere
    public int getEdad() {
        if (fechaNacimiento == null) {
            return 0;
        }
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }
}