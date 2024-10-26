package appointmentService;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Date;

public class AppointmentTest {

    @Test
    public void testAppointmentCreation() {
        Appointment appointment = new Appointment(new Date(System.currentTimeMillis() + 10000), "Test Description");
        assertNotNull(appointment.getAppointmentId());
        assertEquals(10, appointment.getAppointmentId().length());
        assertNotNull(appointment.getAppointmentDate());
        assertEquals("Test Description", appointment.getDescription());
    }

    @Test
    public void testInvalidAppointmentDate() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(new Date(System.currentTimeMillis() - 10000), "Test Description");
        });
    }

    @Test
    public void testInvalidDescription() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(new Date(System.currentTimeMillis() + 10000), null);
        });
    }
}