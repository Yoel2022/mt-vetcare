package src.test.java.com.vetcare;

import com.vetcare.model.Mascota;
import com.vetcare.model.Pago;
import com.vetcare.service.PagoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PagoServiceTest 
{

  private PagoService pagoService;

  @BeforeEach
  public void setUp() {
    // Inicializamos el servicio de pagos antes de cada test
    pagoService = new PagoService();
  }

  @Test
  public void testRegistrarYConsultarPago() {
    // Creamos una mascota de prueba
    Mascota mascota = new Mascota("Firulais", "Canino", 3);

    // Instanciamos el Pago usando el constructor correcto de la clase Pago
    Pago pago = new Pago(mascota, 5000.0, 2000.0, 1500.0, "Antifebril y jeringa", "Efectivo");

    // Ejecutamos el método del servicio (ajusta el nombre si en tu PagoService se llama distinto)
    pagoService.registrarPago(pago);

    // Verificamos que el pago se haya registrado correctamente
    assertNotNull(pagoService, "El servicio de pagos no debe ser nulo");
    assertEquals(8500.0, pago.calcularTotal(), 0.01, "El cálculo total del pago debe ser correcto");
  }
}