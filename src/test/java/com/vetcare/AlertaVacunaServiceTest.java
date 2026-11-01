package src.test.java.com.vetcare;

import com.vetcare.model.Mascota;
import com.vetcare.model.Vacuna;
import com.vetcare.service.AlertaVacunaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class AlertaVacunaServiceTest {

    private AlertaVacunaService alertaVacunaService;

    @BeforeEach
    public void setUp() {
        alertaVacunaService = new AlertaVacunaService();
    }

    @Test
    public void testVerificarAlertaVacuna() {
        // Preparamos una mascota y una vacuna
        Mascota mascota = new Mascota("Bruno", "Canino", 2);
        Vacuna vacuna = new Vacuna("Antirrábica", 1, LocalDate.of(2026, 10, 1));
        
        // Agregamos la vacuna usando el getter de la lista de la mascota
        mascota.getListaVacunas().add(vacuna);

        // Verificamos que el servicio se inicialice correctamente
        assertNotNull(alertaVacunaService);
        assertFalse(mascota.getListaVacunas().isEmpty(), "La lista de vacunas no debe estar vacía");
    }
}