package src.test.java.com.vetcare;

import com.vetcare.model.Vacuna;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class VacunaTest {

    @Test
    public void testCrearVacuna() {
        // Definimos la fecha usando LocalDate y pasamos los 3 parámetros del constructor
        LocalDate fechaPrueba = LocalDate.of(2026, 11, 15);
        Vacuna vacuna = new Vacuna("Antirrábica", 1, fechaPrueba);

        // Verificamos que los datos se asignen y retornen correctamente
        assertEquals("Antirrábica", vacuna.getNombreVacuna());
        assertEquals(1, vacuna.getNumeroDosis());
        assertEquals(fechaPrueba, vacuna.getFechaAplicacion());
    }
}