package src.test.java.com.vetcare;

import com.vetcare.model.Mascota;
import com.vetcare.model.Turno;
import com.vetcare.service.TurnoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime; // O LocalDate según cómo lo maneje Turno
import static org.junit.jupiter.api.Assertions.*;

public class TurnoServiceTest {

    private TurnoService turnoService;

    @BeforeEach
    public void setUp() {
        turnoService = new TurnoService();
    }

    @Test
    public void testProgramarTurno() {
        Mascota mascota = new Mascota("Firulais", "Canino", 3);
        LocalDateTime fechaHoraTurno = LocalDateTime.of(2026, 11, 20, 10, 30);
        
        // Usamos el constructor de Turno acorde a los getters que usa listarTurnos()
        Turno turno = new Turno(mascota, fechaHoraTurno, "Control general");

        // Llamamos al método real de tu servicio
        turnoService.programarTurno(turno);

        // Verificamos que se haya agregado a la agenda
        assertFalse(turnoService.getAgendaTurnos().isEmpty(), "La agenda no debería estar vacía");
        assertEquals(1, turnoService.getAgendaTurnos().size());
        assertEquals("Firulais", turnoService.getAgendaTurnos().get(0).getMascota().getNombreMascota());
    }
}