package com.vetcare.model;

public class Cliente 
{
    String nombre;
    String telefono;
    String domicilio;

    public Cliente(String nombre, String telefono, String domicilio) 
  {
        this.nombre = nombre;
        this.telefono = telefono;
        this.domicilio = domicilio;
  }

    public void mostrarDatos() 
    {
        System.out.println("Cliente: " + nombre + " | Teléfono: " + telefono + " | Domicilio: " + domicilio);
    }
}