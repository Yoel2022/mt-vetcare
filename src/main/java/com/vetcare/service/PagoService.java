package com.vetcare.service;

import com.vetcare.model.Pago;
import java.util.ArrayList;
import java.util.List;

public class PagoService 
{
    // Lista para almacenar los pagos registrados en el sistema
    private List<Pago> historialPagos = new ArrayList<>();

    // Registra un nuevo pago en el sistema y emite su comprobante.
     
    public void registrarPago(Pago pago) {
        historialPagos.add(pago);
        System.out.println(" Transacción procesada con éxito.");
        pago.mostrarComprobante();
    }

    // Calcula y muestra la recaudación total histórica de la veterinaria.
     
    public void calcularRecaudacionTotal() 
    {
        double totalGeneral = 0;
        for (Pago p : historialPagos) 
        {
            totalGeneral += p.getMontoTotal();
        }
        System.out.println("\n Recaudación total acumulada en VetCare: $" + totalGeneral);
    }
}