package src.test.java.com.vetcare;

import com.vetcare.model.Mascota;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MascotaTest {

    @Test
    public void testCrearMascota() {
        // Se pasan los valores en orden, sin etiquetas de nombre
        Mascota mascota = new Mascota("Bruno", "Canino", 3);

        // Verificamos que los datos se asignen y retornen correctamente
        assertEquals("Bruno", mascota.getNombreMascota());
        assertEquals("Canino", mascota.getEspecie());
        assertEquals(3, mascota.getEdad());
        assertNotNull(mascota.getListaVacunas(), "La lista de vacunas no debe ser nula");
    }
}